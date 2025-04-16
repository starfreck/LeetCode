import java.util.Random;

class RandomizedSet {

    private List<Integer> list;
    private HashMap<Integer, Integer> valueToIndex;
    private Random random;

    public RandomizedSet() {
        random = new Random();
        list = new ArrayList<>();
        valueToIndex = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(valueToIndex.containsKey(val)){
            return false;
        }
        // Add item into map and store it's index
        valueToIndex.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valueToIndex.containsKey(val)){
                return false;
        }
        // get the index of item which needs to be removed
        Integer valIndex = valueToIndex.get(val);
        // Replace the item with last value in list
        if(valIndex < valueToIndex.size()-1){
                Integer lastVal = list.get(list.size()-1);
                list.set(valIndex,lastVal);
                valueToIndex.put(lastVal, valIndex);
        }
        // Remove the last item from the list
        list.remove(list.size()-1);
        // Remove val from the map
        valueToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */