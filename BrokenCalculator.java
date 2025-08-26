// Time Complexity : O(log(target-startValue))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Let's greedily try to get target close to startValue by /2 until start>target, when start >target we have to use -1 to get it to target
class Solution {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while(startValue<target){
            if(target%2==0){
                target = target/2;
            }
            else{
                target = target +1;
            }
            count++;
        }
        return count + startValue-target;
    }
}