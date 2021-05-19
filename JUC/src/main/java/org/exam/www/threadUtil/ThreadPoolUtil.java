package org.exam.www.threadUtil;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/19 22:23
 **/
public class ThreadPoolUtil {

    /**
     * 工具类，构造方法私有化
     */
    private ThreadPoolUtil() {
        super();
    }
    /**
     * 线程池核心线程数
     */
    private final static Integer COREPOOLSIZE = 3;
    /**
     * 最大线程数
     */
    private final static Integer MAXIMUMPOOLSIZE = Runtime.getRuntime().availableProcessors() + 1;
   /**
    *  空闲线程存活时间
    */
    private final static Long KEEPALIVETIME = 3L;
    /**
     * 线程等待队列
     */
    private static BlockingQueue<Runnable> QUEUE = new LinkedBlockingQueue<>(3);
    /**
     * 线程池对象
     */
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(COREPOOLSIZE,
            MAXIMUMPOOLSIZE,
            KEEPALIVETIME,
            TimeUnit.SECONDS,
            QUEUE,
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void execute(Runnable r) {
        threadPool.execute(r);
    }

    /** 获取当前线程池线程数量 */
    public static int getSize() {
        return threadPool.getPoolSize();
    }

    /** 获取当前活动的线程数量 */
    public static int getActiveCount() {
        return threadPool.getActiveCount();
    }
}
