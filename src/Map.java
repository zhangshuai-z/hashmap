/**
 * @PROJECT_NAME: hashmap
 * @DATE: 2022/10/11 20:37
 * @author: zhangs
 */
public interface Map<K, V> {
    /**
     * HashMap 的put方法
     * @param k
     * @param v
     */
    void put(K k, V v);

    /**
     * HashMap 的get方法
     * @param k
     * @return
     */
    V get(K k);

    /**
     * 获取 HashMap 的容量
     * @return
     */
    int size();

    /**
     * 对键值对进行了一个封装便于后面的操作
     * @param <K>
     * @param <V>
     */
    interface Entry<K, V> {
        /**
         * 获取 key
         * @return
         */
        K getKey();

        /**
         * 获取 value
         * @return
         */
        V getValue();
    }
}
