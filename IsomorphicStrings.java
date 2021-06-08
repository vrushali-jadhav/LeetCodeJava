class Solution {
    /*Approach: Use 2 hashmaps to store the mapping of chars. "egg" and "add", 
'e' will be mapped to 'a'. Similarly 'a' will be mapped to 'e'. If we encounter a char which is present
in a hashmap as key, but the value is different than the new char, we return false
Time complexity: O(N)
Space complexity: O(1). As the siz of the hashmap will never be greater than 26 (all the characters combined)
*/
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        
        if(s.length()!=t.length())
            return false;
        
        for(int i=0; i<=s.length()-1; i++)
        {
            if(!map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i),t.charAt(i));
            else if(map1.get(s.charAt(i))!=t.charAt(i))
                return false;
            if(!map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i),s.charAt(i));
            else if(map2.get(t.charAt(i))!=s.charAt(i))
                return false;
        }
        return true;
    }
}