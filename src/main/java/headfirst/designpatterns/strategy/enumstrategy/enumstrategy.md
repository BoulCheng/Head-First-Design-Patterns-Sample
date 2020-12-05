
- guava BloomFilter

```
    interface Strategy extends Serializable {
        <T> boolean put(T var1, Funnel<? super T> var2, int var3, LockFreeBitArray var4);

        <T> boolean mightContain(T var1, Funnel<? super T> var2, int var3, LockFreeBitArray var4);

        int ordinal();
    }
```

```
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
}
```