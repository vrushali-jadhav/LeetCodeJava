/*Approach: 
1. Since the String object is immutable, each call for concatenation will result in a new String object being created. Hence for complex concatination operations, 
we will be using stringbuilder instead.
2. We traverse through the string, opening brace would mean the string following it should be multiplied with the number of times we saw the number before it. 
So we add the number and the string we saw so far to their respective stacks. So for "abc3[cd]xyz", "abc" and 3 would go to the stack. 
3. Now when we see ']', we take out the number from the stack, multiply it with the currentString, which would be "cd". Pop the value from stack, "abc", and concatinate popped value with the multilied current string, "abc"+"cdcdcd"
4. cuurentString is alaways holding the decoded value so far
5. Return the currentString

Time complexity: O(N)
Space complexity: O(Depth of the string) the longest length of inner string from '[' to ']'
*/

class Solution {
    Stack<Integer> stackNum = new Stack<>();
    Stack<StringBuilder> stackString = new Stack<>();
    public String decodeString(String s) {
        StringBuilder currentString= new StringBuilder();
        int num = 0;
        for(int i=0; i<= s.length()-1; i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num*10+Character.getNumericValue(c);
            }
            else if(c=='[')
            {
                stackNum.push(num);
                num = 0;
                stackString.push(currentString);
                currentString=new StringBuilder();
            }
            else if(c==']')
            {
                StringBuilder newString = new StringBuilder();
                
                int length = stackNum.pop()-1;
                for(int j = 0; j<= length; j++)
                {
                    newString.append(currentString);
                }
                currentString=stackString.pop().append(newString);
            }
            else
                currentString.append(c);
        }
        return currentString.toString();
    }
}