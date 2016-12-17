package day11;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

    private static int produceTaskSleepTime = 2000;// 间歇时间2秒

    public static void main(String[] args) {
        // 构造一个线程池
        ThreadPoolExecutor producerPool = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        // 每隔produceTaskSleepTime的时间向线程池派送一个任务
        int i = 1;
        while (true) {
            try {
                Thread.sleep(produceTaskSleepTime);// 休息一定的时间
                String task = "task@" + i;// 设置任务名字
                System.out.println("put " + task);
                //用execute启动一个线程
                producerPool.execute(new ThreadPoolTask(task));
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 线程类
class ThreadPoolTask implements Runnable, Serializable {
    private static final long serialVersionUID = 1L;
    private static int consumeTaskSleepTime = 2000;// 时间间歇毫秒
    private String threadPoolTaskData;// 存储人物名的变量

    // 构造方法

    public ThreadPoolTask(String tasks) {
        this.threadPoolTaskData = tasks;
    }

    // 每个任务的执行过程，现在是什么 都没做，除了print和sleep
    @Override
    public void run() {
        System.out.println("start.." + threadPoolTaskData);
        // 便于观察现象，等待一段时间
        try {
            Thread.sleep(consumeTaskSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolTaskData = null;
    }

}