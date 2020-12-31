/**
 * @brief
 * 380 Insert Delete GetRandom O(1) 确是道好题，通过把ArrayList和Hashmap结合得到了最终解决方案。
 * Hashmap帮助ArrayList解决了remove时搜索和移位都是O(n)的问题，而ArrayList则帮助Hashmap解决了getRandom需要index的问题
 */

import java.util.*;

class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            int size = list.size();
            list.add(size, val);
            map.put(val, size);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int size = list.size();
            int valIndex = map.get(val);
            int swap = list.get(size - 1);

            list.set(valIndex, swap);
            list.remove(size - 1);
            map.put(swap, valIndex);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */