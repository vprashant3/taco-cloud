package com.datastructures;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class HashTableQuadraticProbing<K,V> implements Iterable<K> {

    private double loadFactor;
    private int capacity, threshold, modificationCount;

    private int usedBuckets = 0, keyCount = 0;

    private K[] keyTable;
    private V[] valueTable;

    private boolean containsFlag;

    private final K TOMBSTONE = (K) (new Object());

    private static final int DEFAULT_CAPACITY = 8;

    private static final double DEFAULT_LOAD_FACTOR = 0.45;

    public HashTableQuadraticProbing() {
        this(DEFAULT_CAPACITY);
    }

    public HashTableQuadraticProbing(int capacity) {
        this.capacity = capacity;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashTableQuadraticProbing(int capacity, int loadFactor) {
        if(capacity <= 0) throw new IllegalArgumentException("Illegal Capacity");

        if(loadFactor <=0 || Double.isNaN(loadFactor) || Double.isFinite(loadFactor)) throw new IllegalArgumentException("Illegal load factor");

        this.loadFactor = loadFactor;
        this.capacity = Math.max(DEFAULT_CAPACITY, next2Power(capacity));
        threshold = this.capacity * loadFactor;

        keyTable = (K[]) new Object[this.capacity];
        valueTable = (V[]) new Object[this.capacity];
    }

    private int normalizeIndex(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            keyTable[i] = null;
            valueTable[i] = null;
        }
        keyCount =  usedBuckets = 0;
        modificationCount++;
    }

    public int size() { return  keyCount; }

    public boolean isEmpty() { return keyCount == 0; }

    public V put(K key, V value) { return insert(key, value);}
    public V add(K key, V value) { return insert(key, value);}

    public V insert(K key, V value) {
        if(key == null) throw new IllegalArgumentException("Null key");
        if(usedBuckets >= threshold) resizeTable();

        final int hash = normalizeIndex(key.hashCode());
        int i =  hash, j = -1, x = 1;

        do {
            if(keyTable[i] == TOMBSTONE) {
                if(j == -1) j = i;
            } else if(keyTable[i] !=  null) {
                if(keyTable[i].equals(key)) {
                    V oldValue =  valueTable[i];
                    if(j == -1) {
                        valueTable[i] =  value;
                    } else  {
                        keyTable[i] =  TOMBSTONE;
                        valueTable[i] = null;
                        keyTable[i] = key;
                        valueTable[i] = value;
                    }
                    modificationCount++;
                    return oldValue;
                }
            } else {
                if( j == -1) {
                    usedBuckets++; keyCount++;
                    keyTable[i] = key;
                    valueTable[i] = value;
                } else {
                    keyCount++;
                    keyTable[j] = key;
                    valueTable[j] = value;
                }
                modificationCount++;
                return null;
            }
            i = normalizeIndex(hash + P(x));

        } while (true);
    }

    public boolean cotainsKey(K key) {
        return hasKey(key);
    }

    private boolean hasKey(K key) {
        get(key);
        return containsFlag;
    }

    private V get(K key) {
        if(key == null) throw  new IllegalArgumentException("Null key");
        final int hash = normalizeIndex(key.hashCode());
        int i = hash, j = -1, x = 1;

        do {
            if(keyTable[i] == TOMBSTONE) {
                if(j == -1) j = i;
            } else  if(keyTable[i] !=  null) {
                if(keyTable[i].equals(key)) {
                    containsFlag = true;
                    if(j != -1) {
                        keyTable[j] = keyTable[i];
                        valueTable[j] = valueTable[j];

                        keyTable[i] = TOMBSTONE;
                        valueTable[i] = null;
                        return valueTable[j];
                    } else  {
                        return valueTable[j];
                    }
                }
            } else  {
                containsFlag = false;
                return null;
            }
            i =  normalizeIndex(hash + P(x));
        }while (true);
    }

    public V remove(K key) {
        if(key == null) throw new IllegalArgumentException("Null key");
        final int hash =  normalizeIndex(key.hashCode());
        int i = hash, x = 1;

        for(;;i =  normalizeIndex(hash + P(x++))) {
            if(keyTable[i]  == TOMBSTONE) continue;
            if(keyTable[i] == null) return null;
            if(keyTable[i].equals(key)) {
                keyCount--;
                modificationCount++;
                V oldValue =  valueTable[i];
                keyTable[i] =  TOMBSTONE;
                valueTable[i] =  null;
                return oldValue;
            }
        }
    }

    public List<K> keys() {
        return Arrays.stream(keyTable)
                .filter(key -> key != TOMBSTONE &&  key !=  null).collect(Collectors.toList());
    }

    public List<V> values() {
        List<V> values =  new ArrayList<>();
        for(int i = 0; i < capacity; i++) {
            if(keyTable[i] !=  null && keyTable[i] !=  TOMBSTONE) {
                values.add(valueTable[i]);
            }
        }
        return values;
    }

    private void resizeTable() {
        capacity *= 2;
        threshold = (int) (capacity * loadFactor);

        K[] oldKeyTable = (K[]) new Object[capacity];
        V[] oldValueTable = (V[]) new Object[capacity];

        K[] keyTableTmp = keyTable;
        keyTable = oldKeyTable;
        oldKeyTable = keyTableTmp;

        V[] valueTableTmp = valueTable;
        valueTable = oldValueTable;
        oldValueTable = valueTableTmp;

        keyCount =  usedBuckets = 0;

        for (int i = 0; i < oldKeyTable.length; i++) {
            if(oldKeyTable[i] != null && oldKeyTable[i] != TOMBSTONE)
                insert(oldKeyTable[i], oldValueTable[i]);
            oldKeyTable[i] = null;
            oldValueTable[i] = null;
        }
    }

    private static int P(int x) {
        return (x*x + x) >> 1;
    }

    private static int next2Power(int capacity) {
        return Integer.highestOneBit(capacity) << 1;
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
