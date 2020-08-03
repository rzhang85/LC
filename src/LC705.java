import java.util.LinkedList;

public class LC705 {

    private Bucket[] bucket;
    private int base = 769;
    /** Initialize your data structure here. */
    public LC705() {
        this.bucket = new Bucket[base]; // design trade off between space and collision
        for(int i = 0; i < bucket.length; i ++){
            bucket[i] = new Bucket();
        }
    }

    public int hash(int key){
        return key % base;
    }

    public void add(int key) {
        bucket[hash(key)].add(key);
    }

    public void remove(int key) {
        bucket[hash(key)].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bucket[hash(key)].contains(key);
    }

}

class Bucket{
    private LinkedList<Integer> container;

    public Bucket(){
        this.container = new LinkedList<>();
    }

    public void add(Integer key){
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }
    }

    public void remove(Integer key){
        container.remove(key);
    }

    public boolean contains(Integer key){
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}
