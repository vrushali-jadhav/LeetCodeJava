/*Approach: Use 2 hashmaps to store the mapping of chars and words (spilt string s by spaces). pattern = "abba", str = "dog cat cat dog", 
'a' will be mapped to 'dog'. Similarly 'dog' will be mapped to 'a'. If we encounter a char which is present
in a hashmap as key, but the value is different than the new word, we return false
Time complexity: O(N)
Space complexity: O(1). As the siz of the hashmap will never be greater than 26 (all the characters combined)
*/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] wordsInString = s.split(" ");
        
        if(wordsInString.length!=pattern.length())
            return false;
        
        for(int i=0; i<=wordsInString.length-1;i++)
        {
            if(!map1.containsKey(pattern.charAt(i)))
                map1.put(pattern.charAt(i),wordsInString[i]);
            else
            {
                if(!map1.get(pattern.charAt(i)).equals(wordsInString[i]))
                {
                    return false;
                }
            }
            if(!map2.containsKey(wordsInString[i]))
                map2.put(wordsInString[i],pattern.charAt(i));
            else
            {
                if(!map2.get(wordsInString[i]).equals(pattern.charAt(i)))
                {
                    return false;
                }
            }
        }
        return true;
    }
}