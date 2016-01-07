/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

/*
 * DFS solution.
 * Time complexity: O(n), where n is the total number of nodes.
 * Space complexity: O(logn).
 * Status: Accepted, 5ms.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        nodeMap.put(node, head);
        dfs(node, nodeMap);
        return head;
    }

    private void dfs(UndirectedGraphNode curr, Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap) {
        UndirectedGraphNode head = nodeMap.get(curr);
        for (UndirectedGraphNode neighbor : curr.neighbors) {
            if (!nodeMap.containsKey(neighbor)) {
                UndirectedGraphNode cloned = new UndirectedGraphNode(neighbor.label);
                nodeMap.put(neighbor, cloned);
                dfs(neighbor, nodeMap);
            }
            head.neighbors.add(nodeMap.get(neighbor));
        }
    }
}
