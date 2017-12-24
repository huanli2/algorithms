import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by lih on 2017/12/24.
 *
 * source:
 *   https://juejin.im/post/5a38d2046fb9a045076fcb1f
 *
 * Semaphore管理着一组许可（permit）,许可的初始数量可以通过构造函数设定，
 * 操作时首先要获取到许可，才能进行操作，操作完成后需要释放许可。
 * 如果没有获取许可，则阻塞到有许可被释放。
 * 如果初始化了一个许可为1的Semaphore，那么就相当于一个不可重入的互斥锁（Mutex）。
 *
 */
public class SemaphoreDemo {
    private static final int THREAD_COUNT = 30;
    private static Semaphore s = new Semaphore(10);

    private static ExecutorService excutorService = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        for(int i = 0; i < THREAD_COUNT; ++i) {
            excutorService.execute(new Employee(String.valueOf(i), s));
        }
        excutorService.shutdown();
    }
}

class Employee implements Runnable {
    private String id;
    private Semaphore semaphore;
    private static Random random = new Random(47);

    public Employee(String id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(this.id + " is using the toilet");
            TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
            semaphore.release();
            System.out.println(this.id + " is leaving");
        } catch (InterruptedException e) {}
    }
}
