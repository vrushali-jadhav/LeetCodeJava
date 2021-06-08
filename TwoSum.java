/** 
 * Logic: storing the difference between the target and the number we come accross. The difference would be the key
 * and the index would be the value
 * 1. While iterating through the array, first check if the number we came accross is present in the hashamp as the key
 * 2. If it is present, simply resturn its value along with current index
 * 3. Or add the difference in the hashmap.
 * 
 * Time complexity: O(N)
 * Space complexity: O(N)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //store the mapping of difference and the index of the elements
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<= nums.length-1; i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(target-nums[i],i);
            else
                return new int[]{map.get(nums[i]),i};
        }
        return new int[]{-1,-1};
    }
}