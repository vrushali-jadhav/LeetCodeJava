/* Approach: 
1. Save the dependencies as all the nodes that are dependent on the node - HashMap
2. Save the number of courses a course is dependent on - queue
3. Process a course that has no dependency 
4. Update the number of courses a course is dependent on - As 1 course has been proccesed in step 3
5. By the end, if there are courses that still do not have 0 dependency, fail

Time complexity: O(V+E)
Space complexity: O(N)
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int[] dependency : prerequisites)
        {
            int is = dependency[0];
            int on = dependency[1];
            if(!map.containsKey(on)) //if the dependency key is not present, add it
                map.put(on, new ArrayList<Integer>());
            //now we do have the dependency key added, so just add the courses that are dependent on this course/key
            map.get(on).add(is); 
            //increase the count for the courses dependent on this course in the indegrees array
            indegrees[is]++;
        }
        //queue to hold the independent courses. Independent courses are the ones that have value as 0 in indegrees array
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<numCourses; i++)
        {
                if(indegrees[i]==0)
                    queue.add(i);
        }
            
        if(queue.isEmpty()) //this would nothing is 0 in indgrees, that is, no node is independent 
            return false;
        while(!queue.isEmpty())
        {
                int course = queue.remove();
                if(map.containsKey(course))
                {
                    //now we can reduce the dependency of the courses that are dependent on this course in the indegrees array
                    for(int depCourse: map.get(course))
                    {
                        indegrees[depCourse]--;
                        //now if the dependency has reduced to 0, add it to the queue
                        if(indegrees[depCourse]==0)
                            queue.add(depCourse);
                    }
                }
        }
            
        //at this point, all dependencies should have gone to 0
        for(int i =0; i<numCourses; i++)
        {
                if(indegrees[i]!=0)
                    return false;
        }
        return true;
    }
}