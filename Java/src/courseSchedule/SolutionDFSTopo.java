/**
 * The DFS Topological sorting algorithm.
 * Time complexity: O(E + V);
 * Space compelxity: O(E);
 * Status: Accepted.
 */
public class Solution {
    private boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // precondition: prerequisites is not null
        if (prerequisites == null) throw new NullPointerException();
        List<List<Integer>> neighbors = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            neighbors.add(new ArrayList<Integer>());
        }
        
        for (int[] prereq : prerequisites) {
            neighbors.get(prereq[0]).add(prereq[1]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !hasCycle) {
                dfs(i, neighbors, visited, onStack);
            }
            
            if (hasCycle) return false;
        }
        
        return !hasCycle;
    }
    
    private void dfs(int course, List<List<Integer>> neighbors, boolean[] visited, boolean[] onStack) {
        onStack[course] = true;
        visited[course] = true;
        for (Integer neighbor : neighbors.get(course)) {
            if (hasCycle) return;
            else if (!visited[neighbor]) {
                dfs(neighbor, neighbors, visited, onStack);
            } else if (onStack[neighbor]) {
                hasCycle = true;
            }
           
        }
        onStack[course] = false;
    }
    
}
