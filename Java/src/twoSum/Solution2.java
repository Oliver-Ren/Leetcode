import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solution2 {
    private static class Node implements Comparable<Node>{
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Node n2) {
            if (val < n2.val) return -1;
            else if (val > n2.val) return 1;
            else return 0;
        }
    }
        
    public int[] twoSum(int[] nums, int target) {
        // precondition: nums is not null.
        if (nums == null) {
            return null;
        }

        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i + 1);
        }
            
        Arrays.sort(nodes);
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (target > nodes[i].val + nodes[j].val) {
                i++;
            } else if (target < nodes[i].val + nodes[j].val) {
                j--;
            } else {
                int[] result = {nodes[i].index, nodes[j].index};
                if (result[0] > result[1]) {
                    int temp = result[0];
                    result[0] = result[1];
                    result[1] = temp;
                }
                return result;
            }
        }

        return null;

    }
    
    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] nums = {6,4,2,5,62,2};
        int[] result = test.twoSum(nums, 64);
        System.out.println("" + result[0] + "," + result[1]);
    }
}
