package offer.list;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：
 1.在每个后面插入一个节点。
 2.对插入节点的random指针进行赋值。
 3.最后拆分，返回复制后的链表
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class Clone {
    public class RandomListNode { 
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        
        RandomListNode(int label) { 
            this.label = label; 
        }
    }

    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null) return null;
        //插入
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
