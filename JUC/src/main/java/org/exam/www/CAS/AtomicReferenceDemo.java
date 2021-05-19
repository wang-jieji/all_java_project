package org.exam.www.CAS;

import org.exam.www.bean.User;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/4/16 21:06
 **/
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User(11,"z3",18);
        User lis4 = new User(12,"lis4",25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, lis4)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, lis4)+"\t"+atomicReference.get().toString());
    }
}
