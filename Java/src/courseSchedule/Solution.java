import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The DFS solution.
 * Time complexity: O(n) where n is the number of courses. 
 * Space complexity: O(n). 
 * Status: Accepted, 13ms.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // precondition: numCourses >= 0, prerequisites is not null
        if (numCourses < 0) throw new IllegalArgumentException();
        if (prerequisites == null) throw new NullPointerException();

        Map<Integer, List<Integer>> dependsOnThis = new HashMap<Integer, List<Integer>>();
        // the array representing the visit state
        // 0: not visited
        // 1: visited;
        // 2: valid;
        int[] visitState = new int[numCourses];
        
        for(int[] prereq : prerequisites) {
            if (!dependsOnThis.containsKey(prereq[1])) {
                List<Integer> adj = new ArrayList<Integer>();
                dependsOnThis.put(prereq[1], adj);
            }

            dependsOnThis.get(prereq[1]).add(prereq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!isValidDFS(dependsOnThis, i, visitState)) return false;
        }

        return true; 


    }

    private boolean isValidDFS(Map<Integer, List<Integer>> dependsOnThis, int course, int[] visitState) {
        if (visitState[course] == 1) return false;
        if (visitState[course] == 2) return true;

        visitState[course] = 1;
        if (dependsOnThis.containsKey(course)) {
            for (Integer neibor :  dependsOnThis.get(course)) {
                if (!isValidDFS(dependsOnThis, neibor, visitState)) return false;
            }
        }

        visitState[course] = 2;
        return true;
    }
    
}
