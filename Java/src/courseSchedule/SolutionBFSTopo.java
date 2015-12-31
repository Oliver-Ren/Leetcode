import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * The BFS Topological sorting algorithm.
 * Time complexity: O(E + V);
 * Space compelxity: O(E);
 * Status: Accepted.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // precondition: prerequisites is not null
        if (prerequisites == null) throw new NullPointerException();
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
            indegree[prereq[1]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        for (int v = 0; v < numCourses; v++) {
            if (indegree[v] == 0) queue.offer(v);
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            count++;
            for (int w : graph.get(v)) {
                indegree[w]--;
                if (indegree[w] == 0) queue.offer(w);
            }
        }

        if (count != numCourses) {
            return false;
        }

        return true;
    }
}
