package offer.list;
/**
 * @version: V1.0
 * @author: abiao
 * @className: ListClone
 * @packageName: offer
 * @description: 复杂链表的复制
 * @data: 2019/2/25
 **/
public class ListClone {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) return null;
        //现在每个节点后面都复制自己
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode next = cur.next;
            RandomListNode node = new RandomListNode(cur.label);
            node.next = next;
            cur.next = node;
            cur = next;
        }

        //random赋值
        cur = pHead;
        while (cur != null){
            RandomListNode random = cur.random;
            RandomListNode next = cur.next;
            if(random != null){
                next.random = random.next;

            }
            cur = next.next;
        }

//        //拆分
//        RandomListNode res = pHead.next;
//        cur = pHead.next;
//        while (cur.next != null){
//            RandomListNode next = cur.next;
//            cur.next = next.next;
//            cur = cur.next;
//        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
