package com.yjlc.commons.jedis;

import java.util.Hashtable;

public class LRUCache<K,V> {
    private int cacheSize;  
    private Hashtable<K,Entry<K,V>>nodes;//缓存容器  
    private int currentSize;  
    private Entry<K,V> first;//链表头  
    private Entry<K,V> last;//链表尾  
      
    public LRUCache(int i) {  
        currentSize = 0;  
        cacheSize = i;  
        nodes = new Hashtable<K,Entry<K,V>>(i);//缓存容器  
    }  
      
    /** 
     * 获取缓存中对象,并把它放在最前面 
     */  
    public V get(K key) {  
        Entry<K,V> node = nodes.get(key);  
        if (node != null) {  
            moveToHead(node);  
            return node.value;  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 添加 entry到hashtable, 并把entry  
     */  
    public void put(K key, V value) {  
        //先查看hashtable是否存在该entry, 如果存在，则只更新其value  
        Entry<K,V> node = nodes.get(key);  
          
        if (node == null) {  
            //缓存容器是否已经超过大小.  
            if (currentSize >= cacheSize) {  
                nodes.remove(last.key);  
                removeLast();  
            } else {  
                currentSize++;  
            }             
            node = new Entry<K,V>();  
        }  
        node.value = value;  
        //将最新使用的节点放到链表头，表示最新使用的.  
        moveToHead(node);  
        nodes.put(key, node);  
    }  
  
    /** 
     * 将entry删除, 注意：删除操作只有在cache满了才会被执行 
     */  
    public void remove(K key) {  
        Entry<K,V> node = nodes.get(key);  
        //在链表中删除  
        if (node != null) {  
            if (node.prev != null) {  
                node.prev.next = node.next;  
            }  
            if (node.next != null) {  
                node.next.prev = node.prev;  
            }  
            if (last == node)  
                last = node.prev;  
            if (first == node)  
                first = node.next;  
        }  
        //在hashtable中删除  
        nodes.remove(key);  
    }  
  
    /** 
     * 删除链表尾部节点，即使用最后 使用的entry 
     */  
    private void removeLast() {  
        //链表尾不为空,则将链表尾指向null. 删除连表尾（删除最少使用的缓存对象）  
        if (last != null) {  
            if (last.prev != null)  
                last.prev.next = null;  
            else  
                first = null;  
            last = last.prev;  
        }  
    }  
      
    /** 
     * 移动到链表头，表示这个节点是最新使用过的 
     */  
    private void moveToHead(Entry<K,V> node) {  
        if (node == first)  
            return;  
        if (node.prev != null)  
            node.prev.next = node.next;  
        if (node.next != null)  
            node.next.prev = node.prev;  
        if (last == node)  
            last = node.prev;  
        if (first != null) {  
            node.next = first;  
            first.prev = node;  
        }  
        first = node;  
        node.prev = null;  
        if (last == null)  
            last = first;  
    }  
    /* 
     * 清空缓存 
     */  
    public void clear() {  
        first = null;  
        last = null;  
        currentSize = 0;  
    }  
  
}  
	  
	class Entry<K,V> {  
	    Entry<K,V> prev;//前一节点  
	    Entry<K,V> next;//后一节点  
	    K key;//键  
	    V value;//值  
	}  
