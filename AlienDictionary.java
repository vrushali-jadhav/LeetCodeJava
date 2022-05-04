/*
["wrt","wrf","er","ett","rftt"]
["z","x"]
["z","x","z"]
["ab","adc"]
["ac","ab","zc","zb"]
["abc","ab"]
["dvpzu","bq","lwp","akiljwjdu","vnkauhh","ogjgdsfk","tnkmxnj","uvwa","zfe","dvgghw","yeyruhev","xymbbvo","m","n"]
*/
import java.util.*;
class Solution {
    HashMap<Character, HashSet<Character>> graph;
    HashMap<Character, Boolean> visited;
    StringBuilder resultString;
    public String alienOrder(String[] words) {
        graph = new HashMap<>();
        visited = new HashMap<>();
        resultString = new StringBuilder();

        for(String word : words)
        {
            for(char c : word.toCharArray())
            {
                graph.computeIfAbsent(c, o1->new HashSet<>());
            }
        }

        String prevWord = words[0];
        for(int i=1; i<=words.length-1; i++)
        {
            String currentWord = words[i];
            int pointer1 = 0, pointer2 = 0;
            while(pointer1<=prevWord.length()-1 && pointer2<=currentWord.length()-1)
            {
                char c1 = prevWord.charAt(pointer1);
                char c2 = currentWord.charAt(pointer2);
                if(c1!=c2)
                {
                    graph.computeIfAbsent(c1, o1->new HashSet<>()).add(c2);
                    break;
                }
                pointer1+=1;
                pointer2+=1;
            }
            if(pointer1<=prevWord.length()-1 && pointer2>currentWord.length()-1)
                return "";
            prevWord = currentWord;
        }
        
        //if theres a cycle, return ""
        //when do we add the node to the result 
        //when do we mark it as visited 
        for(char node : graph.keySet())
        {
            if(dfs(node, graph.getOrDefault(node, new HashSet<>())))
                return ""; //cycle detected 
        }
        
        return resultString.reverse().toString();
    }
    
    private boolean dfs(char node, HashSet<Character> neighbhors)
    {
        if(visited.containsKey(node))
        {
            if(!visited.get(node)) //already grey
                return true;
            else 
                return false; //already black, so processed
        }
        visited.put(node, false); //mark it grey
        for(char neighbhor : neighbhors)
        {
            if(dfs(neighbhor, graph.getOrDefault(neighbhor, new HashSet<>())))
                return true;
        }
        visited.put(node, true); //mark it black
        resultString.append(node);
        return false;
    }
}