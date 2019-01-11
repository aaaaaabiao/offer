package offer;


/**
 * @version: V1.0
 * @author: abiao
 * @className: Median
 * @packageName: offer
 * @description: 数据流中的中位数
 * @data: 2019/1/11
 **/
import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {

    private int size = 0;
    //创建一个大顶堆
    private PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {

            if (o1 == o2){
                return 0;
            }else if (o1 > o2) {
                return -1;
            }else {
                return 1;
            }
        }
    });
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    public void Insert(Integer num) {
        size++;
        if (size % 2 != 0){
            if (!max.isEmpty() && num < max.peek()){
                max.offer(num);
                min.offer(max.poll());
            }else {
                min.offer(num);
            }
        }else {
            if (!min.isEmpty() && num > min.peek()){
                min.offer(num);
                max.offer(min.poll());
            }else {
                max.offer(num);
            }
        }
    }


    public Double GetMedian() {
        if (size == 0) return 0.0;
        if ((size % 2) != 0){
            return (double)min.peek();
        }else {
            return (min.peek()+max.peek()) / 2.0;
        }
    }


    public void test(){
        max.offer(2);
        max.offer(3);
        max.offer(1);
        max.offer(4);
        max.offer(6);

        while (!max.isEmpty()){
            System.out.println(max.poll());
        }
    }


    public void test1(){
        min.offer(2);
        min.offer(3);
        min.offer(1);
        min.offer(4);
        min.offer(6);

        while (!min.isEmpty()){
            System.out.println(min.poll());
        }
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
