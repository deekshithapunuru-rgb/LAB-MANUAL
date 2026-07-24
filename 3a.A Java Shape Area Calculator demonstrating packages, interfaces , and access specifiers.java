class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        // Index 1 = big, 2 = medium, 3 = small
        slots = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return slots[carType]-- > 0;
    }
}
8:56 pm
Forwarded
import java.util.HashMap;

class UndergroundSystem {
    HashMap<Integer, Object[]> in = new HashMap<>();
    HashMap<String, double[]> total = new HashMap<>();

    public UndergroundSystem() {}

    public void checkIn(int id, String station, int t) {
        in.put(id, new Object[]{station, t});
    }

    public void checkOut(int id, String station, int t) {
        Object[] p = in.remove(id);
        double[] r = total.computeIfAbsent((String) p[0] + "->" + station, k -> new double[2]);
        r[0] += t - (int) p[1];
        r[1]++;
    }

    public double getAverageTime(String start, String end) {
        double[] r = total.get(start + "->" + end);
        return r[0] / r[1];
    }
}
8:56 pm
Forwarded
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for (int c : count) {
            if (c != 0) return false;
        }
        
        return true;
    }
}
8:57 pm
Forwarded
class Foo {
    private volatile int step = 1;

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        step = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (step != 2);
        printSecond.run();
        step = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (step != 3);
        printThird.run();
    }
}
8:57 pm
Forwarded
class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        set=new boolean[1000001];
        
    }
    
    public void add(int key) {
        set[key]=true;
    }
    
    public void remove(int key) {
        set[key]=false;
    }
