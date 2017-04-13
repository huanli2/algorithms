import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by lih on 2017/3/30.
 *
 * source
 *     https://juejin.im/post/58d1377561ff4b006ca9ba49?utm_source=gold_browser_extension
 *
 * res: [datetime] [event]
 *   1490848703288 begin using future get with single thread executor
 *   1490848703289 after future get with single thread executor
 *   1490848703289 task begin to sleep with sec: 1961
 *   1490848703389 after future get wait 100 mills
 *   1490848705250 task end to sleep with sec: 1961
 *   1490848703389 | 1961
 *  comment:
 *    future get time < task end time, but console print sequence: future get > task end, why??
 */

public class BasicDemo {

    static class Task implements Callable<Integer> {

        public Integer call() throws Exception {
            int sleepSecs = new Random().nextInt(10000);

            System.out.println(new Date().getTime() + " task begin to sleep with sec: " + sleepSecs);
            Thread.sleep(sleepSecs);

            System.out.println(new Date().getTime() + " task end to sleep with sec: " + sleepSecs);
            return sleepSecs;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        System.out.println(new Date().getTime() + " begin using future get with single thread executor");
        Future<Integer> future = executor.submit(new Task());

        System.out.println(new Date().getTime() + " after future get with single thread executor");

        Thread.sleep(100);

        System.out.println(new Date().getTime() + " after future get wait 100 mills");

        try {
            System.out.println(new Date().getTime() + " | " + future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
