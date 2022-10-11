/**
 * @PROJECT_NAME: hashmap
 * @DATE: 2022/10/11 20:49
 * @author: zhangs
 */
public class HashMap<K, V> implements Map<K, V>{
    Entry<K, V>[] table = null;
    int size = 0;

    public HashMap() {
        table = new Entry[16];
    }

    private int hash(K k) {
        return k.hashCode() % 16 >= 0 ? k.hashCode() % 16 : -k.hashCode() % 16;
    }

    @Override
    public void put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (null == entry) {
            table[index] = new Entry<>(k, v, index, null);
            size++;
        } else {
            table[index] = new Entry<>(k, v, index, entry);
        }
    }

    @Override
    public V get(K k) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        return findEntry(entry, k) == null ? null : entry.getValue();
    }

    private Entry<K, V> findEntry(Entry<K, V> entry, K k) {
        if(k.equals(entry.getKey()) || k == entry.getKey()) {
            return entry;
        } else {
            if (entry.next != null) {
                return findEntry(entry.next, k);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        int hashCode;
        Entry<K, V> next;

        public Entry(K k, V v, int hashCode, Entry next) {
            this.k = k;
            this.v = v;
            this.hashCode = hashCode;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
