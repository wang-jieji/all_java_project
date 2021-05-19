package org.exam.www.test;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/13 2:29
 **/
public class ThreadTest3 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                            s1.append("b");
                            s2.append("2");

                            System.out.println(s1);
                            System.out.println(s2);
                        }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (s2){
                    s2.append("3");
                    s1.append("c");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1){
                        s2.append("4");
                        s1.append("d");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

    }
}
