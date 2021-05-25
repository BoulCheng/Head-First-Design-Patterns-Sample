# strategy


- 继承 所有的子类都具有某种行为，但可能某些子类不需要这种行为
- 接口 所有实现类都要实现接口中的方法，虽然可以不同实现类可以定制行为，但行为相同的实现类会产生重复代码 (JDK8接口可以有default方法 对4而言却只能定义一种行为的具体一种特性，只能复用行为的一种特性)
- 每个行为定义一个具体的实现类，但可能一种行为有多种特性
- 因此用接口定义某种行为(算法)，用具体的实现类实现该接口并定义一种行为的一种特性(一族算法)

- 策略模式: 定义了算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户

- 良好的OO设计必须具备可复用、可扩充、可维护三个特性

- 设计原则:
    - 封装变化
    - 针对接口编程(利用多态针对超类型 (supertype)编程)  可以更明确地说成“变 量的声明类型应该是超类型，通常是一个抽象类或者是一 个接口，如此，只要是具体实现此超类型的类所产生的对 象，都可以指定给这个变量。这也意味着，声明类时不用理会以后执行时的真正对象类型!” 实例变量在运行时持有特定行为的引用。
    - 多用组合少用继承(将多个类结合起来用)

- guava BloomFilter 中的枚举实现策略模式
```

    interface Strategy extends Serializable {
        <T> boolean put(T var1, Funnel<? super T> var2, int var3, LockFreeBitArray var4);

        <T> boolean mightContain(T var1, Funnel<? super T> var2, int var3, LockFreeBitArray var4);

        int ordinal();
    }
```
```
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter.Strategy;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.qual.Nullable;

enum BloomFilterStrategies implements Strategy {
    MURMUR128_MITZ_32 {
        public <T> boolean put(T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
            int hash1 = (int)hash64;
            int hash2 = (int)(hash64 >>> 32);
            boolean bitsChanged = false;

            for(int i = 1; i <= numHashFunctions; ++i) {
                int combinedHash = hash1 + i * hash2;
                if (combinedHash < 0) {
                    combinedHash = ~combinedHash;
                }

                bitsChanged |= bits.set((long)combinedHash % bitSize);
            }

            return bitsChanged;
        }

        public <T> boolean mightContain(T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
            int hash1 = (int)hash64;
            int hash2 = (int)(hash64 >>> 32);

            for(int i = 1; i <= numHashFunctions; ++i) {
                int combinedHash = hash1 + i * hash2;
                if (combinedHash < 0) {
                    combinedHash = ~combinedHash;
                }

                if (!bits.get((long)combinedHash % bitSize)) {
                    return false;
                }
            }

            return true;
        }
    },
    MURMUR128_MITZ_64 {
        public <T> boolean put(T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            byte[] bytes = Hashing.murmur3_128().hashObject(object, funnel).getBytesInternal();
            long hash1 = this.lowerEight(bytes);
            long hash2 = this.upperEight(bytes);
            boolean bitsChanged = false;
            long combinedHash = hash1;

            for(int i = 0; i < numHashFunctions; ++i) {
                bitsChanged |= bits.set((combinedHash & 9223372036854775807L) % bitSize);
                combinedHash += hash2;
            }

            return bitsChanged;
        }

        public <T> boolean mightContain(T object, Funnel<? super T> funnel, int numHashFunctions, BloomFilterStrategies.LockFreeBitArray bits) {
            long bitSize = bits.bitSize();
            byte[] bytes = Hashing.murmur3_128().hashObject(object, funnel).getBytesInternal();
            long hash1 = this.lowerEight(bytes);
            long hash2 = this.upperEight(bytes);
            long combinedHash = hash1;

            for(int i = 0; i < numHashFunctions; ++i) {
                if (!bits.get((combinedHash & 9223372036854775807L) % bitSize)) {
                    return false;
                }

                combinedHash += hash2;
            }

            return true;
        }

        private long lowerEight(byte[] bytes) {
            return Longs.fromBytes(bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]);
        }

        private long upperEight(byte[] bytes) {
            return Longs.fromBytes(bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]);
        }
    };

    private BloomFilterStrategies() {
    }

    static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        final AtomicLongArray data;
        private final LongAddable bitCount;

        LockFreeBitArray(long bits) {
            Preconditions.checkArgument(bits > 0L, "data length is zero!");
            this.data = new AtomicLongArray(Ints.checkedCast(LongMath.divide(bits, 64L, RoundingMode.CEILING)));
            this.bitCount = LongAddables.create();
        }

        LockFreeBitArray(long[] data) {
            Preconditions.checkArgument(data.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(data);
            this.bitCount = LongAddables.create();
            long bitCount = 0L;
            long[] var4 = data;
            int var5 = data.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                long value = var4[var6];
                bitCount += (long)Long.bitCount(value);
            }

            this.bitCount.add(bitCount);
        }

        boolean set(long bitIndex) {
            if (this.get(bitIndex)) {
                return false;
            } else {
                int longIndex = (int)(bitIndex >>> 6);
                long mask = 1L << (int)bitIndex;

                long oldValue;
                long newValue;
                do {
                    oldValue = this.data.get(longIndex);
                    newValue = oldValue | mask;
                    if (oldValue == newValue) {
                        return false;
                    }
                } while(!this.data.compareAndSet(longIndex, oldValue, newValue));

                this.bitCount.increment();
                return true;
            }
        }

        boolean get(long bitIndex) {
            return (this.data.get((int)(bitIndex >>> 6)) & 1L << (int)bitIndex) != 0L;
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            long[] array = new long[atomicLongArray.length()];

            for(int i = 0; i < array.length; ++i) {
                array[i] = atomicLongArray.get(i);
            }

            return array;
        }

        long bitSize() {
            return (long)this.data.length() * 64L;
        }

        long bitCount() {
            return this.bitCount.sum();
        }

        BloomFilterStrategies.LockFreeBitArray copy() {
            return new BloomFilterStrategies.LockFreeBitArray(toPlainArray(this.data));
        }

        void putAll(BloomFilterStrategies.LockFreeBitArray other) {
            Preconditions.checkArgument(this.data.length() == other.data.length(), "BitArrays must be of equal length (%s != %s)", this.data.length(), other.data.length());

            for(int i = 0; i < this.data.length(); ++i) {
                long otherLong = other.data.get(i);
                boolean changedAnyBits = true;

                long ourLongOld;
                long ourLongNew;
                do {
                    ourLongOld = this.data.get(i);
                    ourLongNew = ourLongOld | otherLong;
                    if (ourLongOld == ourLongNew) {
                        changedAnyBits = false;
                        break;
                    }
                } while(!this.data.compareAndSet(i, ourLongOld, ourLongNew));

                if (changedAnyBits) {
                    int bitsAdded = Long.bitCount(ourLongNew) - Long.bitCount(ourLongOld);
                    this.bitCount.add((long)bitsAdded);
                }
            }

        }

        public boolean equals(@Nullable Object o) {
            if (o instanceof BloomFilterStrategies.LockFreeBitArray) {
                BloomFilterStrategies.LockFreeBitArray lockFreeBitArray = (BloomFilterStrategies.LockFreeBitArray)o;
                return Arrays.equals(toPlainArray(this.data), toPlainArray(lockFreeBitArray.data));
            } else {
                return false;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }
    }
}

```