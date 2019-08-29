package multithreading;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量的方式来实现交替打印
 *
 * @author hubiao
 * @date 2019/8/23
 */
public class AlternatePrint {
    public static class print implements Runnable{
        private Semaphore self;
        private Semaphore next;
        private String content;
        public print(Semaphore self, Semaphore next, String content){
            this.self = self;
            this.next = next;
            this.content = content;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                try {
                    self.acquire();
                    System.out.print(content);
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static int count = 0;

    public static class printEvenOdd implements Runnable{
        private Semaphore self;
        private Semaphore next;
        private String content;
        public printEvenOdd(Semaphore self, Semaphore next){
            this.self = self;
            this.next = next;
            this.content = content;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++){
                try {
                    self.acquire();
                    System.out.println(count);
                    count++;
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    public static void main(String[] args){

        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);
        Semaphore c = new Semaphore(0);

//        Thread tA = new Thread(new print(a, b, "A"));
//        Thread tB = new Thread(new print(b, c, "B"));
//        Thread tC = new Thread(new print(c, a, "C"));
//
//        tA.start();
//        tB.start();
//        tC.start();

        Thread tA = new Thread(new printEvenOdd(a, b));
        Thread tB = new Thread(new printEvenOdd(b, a));

        tA.start();
        tB.start();
    }
}
