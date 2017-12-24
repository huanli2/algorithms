
/**
 * Created by lih on 2017/12/24.
 *
 *  * source
 *     https://juejin.im/post/5a3267646fb9a0451d4180aa
 *
 * CountDownLatch是一种灵活的闭锁实现，它可以使一个或者多个线程等待一组事件的发生。
 * countDown方法递减计数器，表示已经有一个事件发生了，而await方法等待计数器达到0，
 * 表示所有需要等待的事件都已经发生，如果计数器值非0，则会一直阻塞，或者等待中的线程中断或超时
 *
 * 示例：
 *   1、所有运动员都在等待开始信号（start的count值为1）；
 *   2、教练喊开始，并等待结束信号（countDown修改start的count值为0，所有运动员开始工作）；
 *   3、运动员每跑完一个，end的count值减1，end的count值变为0时，教练喊结束！
 */
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    private static final int SIZE = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(SIZE);
        for(int i = 0; i < SIZE; ++i) {
            executorService.execute(new Runner(start, end));
        }
        executorService.execute(new Coach(start, end));
        executorService.shutdown();
    }
}

class Runner implements Runnable {
    private static int counter = 0;
    private final int id = counter ++;
    private static Random random = new Random(47);
    private final CountDownLatch start;
    private final CountDownLatch end;

    public Runner(CountDownLatch start, CountDownLatch end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            //所有运动员都在准备状态中，等待教练释放开始门
            start.await();
            try {
                doWork();
                end.countDown();
                System.out.println("end count remain:" + end.getCount());
            } catch (InterruptedException e) {
                System.out.println("Interrupted Runner" + id);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Runner" + id);
        }
    }

    public void doWork() throws InterruptedException {
        int time = random.nextInt(2000);
        System.out.println(this + "begin run with time:" + time);
        TimeUnit.MICROSECONDS.sleep(time);
        System.out.println(this + "completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}

class Coach implements Runnable {
    private final CountDownLatch start;
    private final CountDownLatch end;

    public Coach(CountDownLatch start, CountDownLatch end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public void run() {
        //教练释放了开始门，运动员们都开始跑
        System.out.println("enter coach with start count:" + start.getCount());
        start.countDown();
        System.out.println("coach ready with start count:" + start.getCount());
        System.out.println("Coach say: Ready!!!  Go!!!!");

        try {
            //当结束门的count down减为0时，教练宣布所有人都跑完了。
            end.await();
            System.out.println("Every one finished running");
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
    }
}