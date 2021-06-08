class Solution {
    ArrayList<String> arrayList = new ArrayList<>();
    String longest=""; 
    int length = -1;
    boolean valid;
    public String longestWord(String[] words) {
        Set<String> wordset = new HashSet();
        for (String word: words) wordset.add(word);
        for (String word: words) 
        {
            valid = true;
            for (int k = 1; k <= word.length()-1; k++) 
            {
                String subString = word.substring(0, k);
                if(!wordset.contains(subString))
                    valid = false;
            }
            if(valid)
            {
                if(word.length()==length)
                {
                    //choose the lexicographically smaller answer
                    if(word.compareTo(longest)<0)
                        longest=word;
                }
                if(word.length()>length)
                {
                    longest = word;
                    length = word.length();
                }
            }
        }
        return longest;
    }
}