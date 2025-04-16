import java.util.Random;

class RandomizedCollection {

    private List<Integer> list;
    private HashMap<Integer, HashSet<Integer>> valueToIndexes;
    private Random random;

    public RandomizedCollection() {
        random = new Random();
        list = new ArrayList<>();
        valueToIndexes = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(!valueToIndexes.containsKey(val)){
            valueToIndexes.put(val, new HashSet());
        }
        // Get item from the map and store it's index
        valueToIndexes.get(val).add(list.size());
        list.add(val);
        return valueToIndexes.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if(!valueToIndexes.containsKey(val) || valueToIndexes.get(val).size() == 0) {
            return false;
        }
        // get the index of item which needs to be removed
        Integer valIndex = valueToIndexes.get(val).iterator().next();
        // Remove valIndex from HashSet of val
        valueToIndexes.get(val).remove(valIndex);
        // Replace the item with last value in list
        // Get the last value
        Integer lastVal = list.get(list.size()-1);
        // Replace val with lastVal 
        list.set(valIndex,lastVal);
        // Add valIndex in the HashSet of lastVal
        valueToIndexes.get(lastVal).add(valIndex);
        // Remove the last index from HashSet of lastVal
        valueToIndexes.get(lastVal).remove(list.size()-1);
        // Remove the last item from the list
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */