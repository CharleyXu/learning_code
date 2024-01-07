package com.xu.algorithm.hash;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author CharleyXu Created on 2019/3/18.
 */
public class LRUCache<K, V> {

  private LinkedHashMap<K, V> linkedHashMap;
  private int size;
  private float loadFactor = 0.75F;

  public LRUCache(int maxSize) {
    this.size = maxSize;
    //  +1确保当达到size上限时不会触发hashMap的扩容,其实在lruCache这里意义不大
    int capacity = (int) Math.ceil(maxSize / loadFactor) + 1;
    this.linkedHashMap = new LinkedHashMap<K, V>(capacity, loadFactor, true) {
      @Override
      protected boolean removeEldestEntry(Entry eldest) {
        return size() > size;
      }
    };

  }

  public V get(K k) {
    return linkedHashMap.get(k);
  }

  public void put(K k, V v) {
    linkedHashMap.put(k, v);
  }

  public int size() {
    return linkedHashMap.size();
  }

  public boolean isEmpty() {
    return linkedHashMap.isEmpty();
  }

  public void remove(V v) {
    linkedHashMap.remove(v);
  }

  public String toString() {
    return linkedHashMap.toString();
  }

  public static void main(String[] args) {
    LRUCache<String, String> lruCache = new LRUCache<String, String>(5);
    lruCache.put("1", "a");
    lruCache.put("2", "b");
    lruCache.put("3", "c");
    lruCache.put("4", "d");
    lruCache.put("5", "e");
    System.out.println(lruCache);
    System.out.println(lruCache.get("1"));
    lruCache.put("6", "f");
    System.out.println(lruCache);
  }

}
