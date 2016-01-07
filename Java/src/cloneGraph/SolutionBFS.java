/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

/*
 * BFS solution.
 * Time complexity: O(n), where n is the total number of nodes.
 * Space complexity: O(n).
 * Status: Accepted, 11ms.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        nodeQueue.offer(node);
        nodeMap.put(node, head);

        while (!nodeQueue.isEmpty()) {
            UndirectedGraphNode curr = nodeQueue.poll();
            UndirectedGraphNode cloned = nodeMap.get(curr); 
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    nodeMap.put(neighbor, neighborCopy);
                    nodeQueue.offer(neighbor);
                }
                cloned.neighbors.add(nodeMap.get(neighbor));
            }
        }

        return head;
    }
}

                
