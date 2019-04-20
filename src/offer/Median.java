package offer;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：采用一个大顶堆和一个小顶堆来实现。
 描述：

 维护这两个堆，满足一下两个条件
 1.大顶堆的元素个数等于小顶堆，或者比小顶堆大一个。
 2.大顶堆的元素全要小于小顶堆。

 那么当数据流中的数和是偶数的时候。那么就是中位数两堆顶元素的平均数。
 当数据流中的数和是奇数的时候，那么中位数就是大顶堆的堆顶元素。


 题目需要解决的问题就是如何位置这两个堆
 对于（1）。插入的时候依次插入不同的堆。比如第一个次大顶堆，第二次小顶堆，第三次大顶堆。。。
 （2），比如某次该插入大顶堆的时候，不能直接插入。因为这个元素可能会大于小顶推的元素。可以采取的方法是，先插入小顶推。然后在把小顶堆的堆顶元素插入打大顶推。即可维护性质2
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import java.util.PriorityQueue;

public class Median {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int c = 0;
    public void Insert(Integer num) {
        c++;
        if(c % 2 != 0){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else{
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        return c % 2 != 0 ? (double)maxHeap.peek() : (double)(maxHeap.peek()+minHeap.peek())/2;
    }

    public static void main(String[] args){
        Median median = new Median();
        median.Insert(2);
        System.out.println(median.GetMedian());
        median.Insert(3);
        System.out.println(median.GetMedian());
        median.Insert(4);
        System.out.println(median.GetMedian());
        median.Insert(3);
        System.out.println(median.GetMedian());

//        median.test();
//        median.test();


        int a;
    }
}
