package offer.heap;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 ````````````````````````````````````例子`````````````````````````````````````
 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：双指针，滑动窗口。堆
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 维护一个大小为K的堆。p,q指针代表滑动窗口。小技巧q代表滑动窗口的后一个位置。堆中就是每次删除p元素,添加q元素。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/6
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList();
        if(num == null || size > num.length || size == 0) return ret;
        int len = num.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)-> o2-o1);
        int i = 0;
        int j = size;
        for(int n = 0; n < size; n++){
            queue.add(num[n]);
        }
        ret.add(queue.peek());
        while(j < len){
            queue.remove(num[i]);
            queue.add(num[j]);
            ret.add(queue.peek());
            i++;
            j++;
        }

        return ret;
    }
}
