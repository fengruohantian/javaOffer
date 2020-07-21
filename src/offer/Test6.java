package offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        int[] ints = reversePrint(node);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
           list.add(head.val);
           head = head.next;
        }
        Collections.reverse(list);
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }
}
