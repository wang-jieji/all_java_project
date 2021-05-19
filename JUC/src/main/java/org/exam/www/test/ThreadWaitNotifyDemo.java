package org.exam.www.test;

/**
 * @Description TODO
 * @Author
 * @Date
 **/

// 资源类
class AirConditioner {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        //1 判断
       // if(number != 0)
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();


    }

    public synchronized void decrease() throws InterruptedException {

        //1 判断
        //if(number == 0)
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
}

/**
 * @Author
 * @Description 题目：现在两个线程，可以操作初始值为0的一个变量，实现一个线程对该变量加1，一个线程对变量减1，
 * 实现交替，来10轮，变量初始值为零。
 */
public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(200);
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(200);
                    airConditioner.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

}


