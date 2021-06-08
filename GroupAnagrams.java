class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Space complexity: O(nk) - should be 2*O(NK) for keys ad values. But constants don't matter
        //Only auxillary space is considered 
        //time complexity: O(NK)
        
        /*Approach1:
        1. Iterate through the list, get the string. Sort it in alphabatical manner
        2. Create a hashmap. If the sorted key is not present, add it to the map.
        3. The value for each key would be a list of strings read from input that are same to the key when sorted.
        4. Return the list of values of the hashmap. 
        -> Time complexity: O(NK)
        -> Space complexity: O(NK) + O(NK): 2*O(NK). But constants do not matter. So O(NK). 
           For hashmap, worst case, we will have to store all strings as keys. Each string is of average length K. So O(NK). 
           Each key has a value as a list of strings. But all values combined for all keys would be N with each string of averge lenth K. 
           Hence O(NK)+O(NK)
        */
        
        /*
        HashMap<String,List<String>> mapping = new HashMap<>();
        for(String stringInList : strs)
        {
            //Store the string in a char array
            char[] charArrayForStringInList = stringInList.toCharArray();
            Arrays.sort(charArrayForStringInList);
            //convert sorted array back to a string
            String sortedVal = String.valueOf(charArrayForStringInList);
            if(!mapping.containsKey(sortedVal))
                mapping.put(sortedVal, new ArrayList<String>());
            mapping.get(sortedVal).add(stringInList);
        }
        return new ArrayList(mapping.values());
        */
        
        /*Approach2:
        1. Iterate through the list, get the string. Find it's prime product. Prime product for string with same chars would always be the same.
        Example: cab : 5*2*3 and for bac : 3*2*5
        2. Create a hashmap. If the PP key is not present, add it to the map.
        3. The value for each key would be a list of strings read from input that have the same PP.
        4. Return the list of values of the hashmap. 
        -> Time complexity: O(NK)
        -> Space complexity: O(NK) + O(NK): 2*O(NK). But constants do not matter. So O(NK). 
           For hashmap, worst case, we will have to store all strings as keys. Each string is of average length K. So O(NK). 
           Each key has a value as a list of strings. But all values combined for all keys would be N with each string of averge lenth K. 
           Hence O(NK)+O(NK)
        */
        HashMap<Long,List<String>> mapping = new HashMap<>();
        for(String stringInList : strs)
        {
            Long pp = primeProduct(stringInList);
            if(!mapping.containsKey(pp))
                mapping.put(pp, new ArrayList<String>());
            mapping.get(pp).add(stringInList);
        }
        return new ArrayList(mapping.values());
    }
    
    private Long primeProduct(String s)
    {
        int[] primeVals = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,101,103};
        char[] stringToChars = s.toCharArray();
        long pp = 1;
        for(char charachter : stringToChars)
        {
            pp = pp*primeVals[charachter-'a']; //so 'b'-'a' would be 97-96 = 1
        }
        return pp;
    }
}