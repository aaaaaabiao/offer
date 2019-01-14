import java.util.List;


/*
* 交换列表中相邻的节点，得到一个新的列表。
*
*
* */
public class SwapNodesInPairs {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
      }

    public static ListNode swapPairs(ListNode head) {
         ListNode res = new ListNode(0);
         int index = 1;
         ListNode pre = res;
         ListNode last = res;
         while (head != null){

             ListNode tmp = head;
             head = head.next;
             if (index % 2 == 0){
                 tmp.next = pre.next;
                 pre.next = tmp;
                 pre = tmp.next;
             }else {
                 last.next = tmp;
                 last = last.next;
             }
             index++;
         }
         last.next = null;
         return res.next;
    }
     public static void main(String[] args){
         ListNode listNode0 = new ListNode(1);
         ListNode listNode1 = new ListNode(2);
         ListNode listNode2 = new ListNode(3);
         ListNode listNode3 = new ListNode(4);
         listNode0.next = listNode1;
         listNode1.next = listNode2;
         listNode2.next = listNode3;

         ListNode res = swapPairs(listNode0);

         int a = 0;
     }
}
