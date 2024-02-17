package DSA.Hashmaps;

import java.util.ArrayList;

public class Map<K,V>{
    ArrayList<MapNode<K,V>> buckets;
    int size; // num of elements in map
    int numBuckets;

    public Map(){
        numBuckets = 5;
        buckets = new ArrayList<>();
        for(int i=0; i<numBuckets; i++){
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key){
        // this a method to find the hash code 
        int hashCode = key.hashCode();
        return (hashCode % numBuckets); // compression functio

    }
    
    public void insert(K key, V value){
        // using separate chaining method
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex); // head of linked list
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<K,V>(key, value);
        newNode.next = head;
        
        size++;

        buckets.set(bucketIndex, newNode);

        double loadFactor = loadFactor();
        if(loadFactor > 0.7){
            rehash();
        }
        
    }

    public double loadFactor(){
        return (1.0*size)/numBuckets;
    }

    private void rehash(){
        System.out.println("Rehashing: bucket: "+ numBuckets + "size: " + size);
        // create a new map of double size
        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();
        for(int i=0; i<2*numBuckets; i++){
            buckets.add(null);
        }
        size = 0;
        numBuckets = 2 * numBuckets;

        // re-insert the keys in the new map using temp
        for(int i=0; i< temp.size(); i++){
            MapNode<K,V> head = temp.get(i);
            while(head !=null){
                K key = head.key;
                V value = head.value;

                insert(key, value);
                head = head.next;
            }
        }
    }

    public int size(){
        return size;
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null; // key not found
    }

    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;

        while(head != null){
            if(head.key.equals(key)){
                if(prev == null){
                    buckets.set(bucketIndex, head.next); // if key is found at head
                }
                else{
                    prev.next = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null; // key not found
    
    }
}
