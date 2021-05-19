package org.exam.www.myvolatile;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/16 17:34
 **/
public class ReSortSeqDemo {

    int a = 0 ;
    boolean flag = false ;

    public void method1(){
        a = 1 ;
        flag = true ;
    }

    public void method02(){
        if(flag) {
            a = a + 5 ;
            System.out.println("*****retValue "+a);
        }
    }

}
