// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Recursively iterate through nested integer if list, initially has depth =1, keep incrementing it by 1 as we unfold
/// the list. For each integer, multiply it's int value with the depth

/*
Nested List Weighted Sum: Given a list of NestedIntegers, where each NestedInteger can be an integer or 
*/
 class Main {
    public static void main(String[] args) {
        // [[1,2]]
        NestedIntegerClass list1 = new NestedIntegerClass();
        list1.add(new NestedIntegerClass(1));
        list1.add(new NestedIntegerClass(2));

        // 3
        NestedIntegerClass val3 = new NestedIntegerClass(3);

        // [2]
        NestedIntegerClass innerMost = new NestedIntegerClass();
        innerMost.add(new NestedIntegerClass(2));

        // [3, [2]]
        NestedIntegerClass innerList = new NestedIntegerClass();
        innerList.add(new NestedIntegerClass(3));
        innerList.add(innerMost);

        // [4, [3,[2]]]
        NestedIntegerClass list2 = new NestedIntegerClass();
        list2.add(new NestedIntegerClass(4));
        list2.add(innerList);

        // Final: [[1,2], 3, [4,[3,[2]]]]
        List<NestedInteger> finalList = new ArrayList<>();
        finalList.add(list1);
        finalList.add(val3);
        finalList.add(list2);

        // Print the structure (just for checking)
        System.out.println(finalList);
        System.out.println(solve(finalList));
    }
    private static int solve(List<NestedInteger> list){
        return dfs(list, 1);
    }
    private static int dfs(List<NestedInteger> list, int d){
        int res = 0;
        for(NestedInteger n:list){
            if(n.isInteger()){
                res += n.getInteger()*d;
            }
            else{
                res += dfs(n.getList(), d+1);
            }
        }
        return res;
    }
}
 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
  interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // The result is undefined if this NestedInteger holds a nested list
     public Integer getInteger();

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value);

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni);
     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // The result is undefined if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
public class NestedIntegerClass implements NestedInteger {
    private Integer value; // if it's an integer
    private List<NestedInteger> list; // if it's a list

    // Constructor initializes an empty nested list
    public NestedIntegerClass() {
        this.list = new ArrayList<>();
    }

    // Constructor initializes a single integer
    public NestedIntegerClass(int value) {
        this.value = value;
    }

    // @return true if this NestedInteger holds a single integer
    @Override
    public boolean isInteger() {
        return value != null;
    }

    // @return the single integer that this NestedInteger holds
    @Override
    public Integer getInteger() {
        return value;
    }

    // Set this NestedInteger to hold a single integer
    @Override
    public void setInteger(int value) {
        this.value = value;
        this.list = null; // clear list
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it
    @Override
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
            value = null; // clear value
        }
        list.add(ni);
    }

    // @return the nested list
    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}