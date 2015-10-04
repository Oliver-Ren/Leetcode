/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
       TreeLinkNode queueHead = root;

       while (queueHead != null) {
           TreeLinkNode levelDummyHead = new TreeLinkNode(-1);
           TreeLinkNode visitor = levelDummyHead;
           while (queueHead != null) {
               if (queueHead.left != null) {
                   visitor.next = queueHead.left;
                   visitor = visitor.next;
               } 

               if (queueHead.right != null) {
                   visitor.next = queueHead.right;
                   visitor = visitor.next;
               }

               queueHead = queueHead.next;
           }

           queueHead = levelDummyHead.next;
       }

    }
}
               

    }
}
