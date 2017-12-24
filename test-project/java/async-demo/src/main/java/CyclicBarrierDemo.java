import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by lih on 2017/12/24.
 *
 * source:
 *   https://juejin.im/post/5a3267a66fb9a045132ab988
 *
 * CyclicBarrier适用于这样的情况：
 * 你希望创建一组任务，它们并行地执行工作，然后在下一个步骤之前等待，直到所有任务都完成。
 * 栅栏和闭锁的关键区别在于，所有线程必须同时到达栅栏位置，才能继续执行。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 200;

        new HorseRace(nHorse, pause);
    }
}

class Horse implements Runnable {
    private static int counter = 0;
    private final int id = ++counter;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;
    public Horse(CyclicBarrier b) {
        barrier = b;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //线程内不断循环
                strides += rand.nextInt(3);
                //走完后，就等所有其它马也走完，才能开始下一回合
                barrier.await();
                System.out.println(this + "reached barrier line. ");
            }
        } catch (InterruptedException e) {
        } catch (BrokenBarrierException e) {
          throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        //这里打印每个马走的轨迹
        for (int i = 0; i < getStrides(); ++i) s.append("*");
        s.append(id);
        return s.toString();
    }
}

class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horseList = new ArrayList<Horse>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {

            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; ++i) s.append("=");
                System.out.println(s);

                for(Horse horse : horseList) {
                    System.out.println(horse.tracks());
                }
                for(Horse horse : horseList) {

                    if (horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + "won!");
                        executorService.shutdownNow();
                        return;
                    }
                }
                try {
                    //每走完一轮，暂停一小会输出
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });

        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horseList.add(horse);
            executorService.execute(horse);
        }
    }
}