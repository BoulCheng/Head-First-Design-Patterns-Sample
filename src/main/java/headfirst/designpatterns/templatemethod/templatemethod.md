
- 模版方法定义了一个算法的步骤，并允许子类为一个或多个步骤提供实现；整个模版方法是一个final方法
- 算法内的每一个步骤可以被一个方法代表，某些方法由超类处理，某些方法由子类处理(在超类中声明为抽象)，
- 算法内的每一个步骤也可以不对应一个方法，代表整个模版的方法里可以有代码实现，只是在这个模版方法里调用了需要子类实现的抽象方法。
- 提供了一个框架，这个框架可以每个步骤一个方法代表即这模版方法里全是方法的调用，也可以是有代码实现且有调用需要子类实现的方法；到达专注于整个算法框架，需要由子类提供完整的实现。

- 将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
```

public abstract class CaffeineBeverage {
  
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
 
	abstract void brew();
  
	abstract void addCondiments();
 
	void boilWater() {
		System.out.println("Boiling water");
	}
  
	void pourInCup() {
		System.out.println("Pouring into cup");
	}
}

```

```
public abstract class AbstractSeerRecursiveTask<T> extends RecursiveTask<Long> {

    private static final int BATCH_INSERT_THRESHOLD = 3000;

    protected int currDepth;
    protected int begin;
    protected int end;
    protected SeerConfiguration seerConfiguration;
    protected List<ForecastShopDayDO> forecastDOList;

    public AbstractSeerRecursiveTask(int currDepth, int begin, int end, SeerConfiguration seerConfiguration, List<ForecastShopDayDO> forecastDOList) {
        this.currDepth = currDepth;
        this.begin = begin;
        this.end = end;
        this.seerConfiguration = seerConfiguration;
        this.forecastDOList = forecastDOList;
    }

    @Override
    protected final Long compute() {
        if (this.currDepth == seerConfiguration.getRecursiveDepth()) {
            execute();
        } else {
            int middle = (begin + end) / 2;
            currDepth++;
            RecursiveTask seerRecursiveTask = newInstance(currDepth, begin, middle, seerConfiguration, forecastDOList);
            RecursiveTask seerRecursiveTask2 = newInstance(currDepth, middle, end, seerConfiguration, forecastDOList);

            seerRecursiveTask.fork();
            seerRecursiveTask.join();

            seerRecursiveTask2.fork();
            seerRecursiveTask2.join();
        }
        return null;
    }

    private void execute() {
        Evaluator evaluator = seerConfiguration.getNextEvaluator();
        ForecastShopDayDO forecastDO;
        List<T> list = new ArrayList<>(BATCH_INSERT_THRESHOLD + 5);

        for (int i = this.begin; i < this.end; i++) {
            forecastDO = this.forecastDOList.get(i);
            Field[] fields = forecastDO.getClass().getDeclaredFields();
            Map<String, Object> map = new ConcurrentHashMap<>();
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.get(forecastDO) != null) {
                        map.put(field.getName(), field.get(forecastDO));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            EnumMap<Seer.SeerReturnEnum, Object> result;
            try {
                result = Seer.predict(evaluator, map, seerConfiguration);
            } catch (Exception e) {
                result = new EnumMap<>(Seer.SeerReturnEnum.class);
                result.put(Seer.SeerReturnEnum.EXCEPTION, Boolean.TRUE);
                e.printStackTrace();
            }

            list.add(generateDo(result, forecastDO));
            if (list.size() >= BATCH_INSERT_THRESHOLD || (this.end - 1 == i)) {
                try {
                    batchInsert(list);
                    list.clear();
                } catch (Exception e) {
                    // log
                    e.printStackTrace();
                }
            }
        }
    }

    protected abstract T generateDo(EnumMap<Seer.SeerReturnEnum, Object> result, ForecastShopDayDO forecastDO);

    protected abstract void batchInsert(List<T> list);

    protected abstract RecursiveTask newInstance(int currDepth, int begin, int end, SeerConfiguration seerConfiguration, List<ForecastShopDayDO> forecastDOList);
}
```

- 非继承实现
    - 是模板方法模式和回调模式的结合，是Template Method不需要继承的另一种实现方式
    - JDBC的抽象和对Hibernate的集成，都采用了一种理念或者处理方式，那就是模板方法模式与相应的Callback接口相结合
    因为这个类的方法太多，但是我们还是想用到JdbcTemplate已有的稳定的、公用的数据库连接，那么我们怎么办呢？
    
    我们可以把变化的东西抽出来作为一个参数传入JdbcTemplate的方法中。但是变化的东西是一段代码，而且这段代码会用到JdbcTemplate中的变量。怎么办？
    
    那我们就用回调对象吧。在这个回调对象中定义一个操纵JdbcTemplate中变量的方法，我们去实现这个方法，就把变化的东西集中到这里了。然后我们再传入这个回调对象到JdbcTemplate，从而完成了调用