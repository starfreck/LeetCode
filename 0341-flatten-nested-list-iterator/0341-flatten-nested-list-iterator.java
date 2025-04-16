/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    // NestedInteger Methods
    // public boolean isInteger();
    // public Integer getInteger();
    // public List<NestedInteger> getList();
    private List<Integer> flattenList;
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new ArrayList<>();
        flattening(nestedList);
        it = flattenList.iterator();
    }

    private void flattening(List<NestedInteger> nestedList){
        for(NestedInteger item :nestedList){
            if(item.isInteger()){
                this.flattenList.add(item.getInteger());
            } else {
                this.flattening(item.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(it.hasNext()){
            return it.next();
        } 
        return null;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */