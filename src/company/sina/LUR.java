package company.sina;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LUR {

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int capacity;
    private List<Integer> list = new LinkedList<>();
    public LUR(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(new Integer(key));
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        int size = list.size();
        if (map.containsKey(key)) {
            map.put(key, value);
            list.remove(new Integer(key));
            list.add(key);
        }else {
            if (size == capacity) {
                map.remove(list.get(0));
                list.remove(0);
            }
            map.put(key, value);
            list.add(key);
        }
    }


    public static void main(String[] args) {
        LUR lru = new LUR(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}
