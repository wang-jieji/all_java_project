import com.exam.www.singletonType.*;

/**
 * @Description TODO
 * @Author WJJ
 * @Date 2021/8/4 17:20
 **/
public class SingletonTest {

    public static void main(String[] args) {
        SingletonTest01 instance = SingletonTest01.getInstance();
        SingletonTest01 instance2 = SingletonTest01.getInstance();
        System.out.println(instance==instance2);
        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());

        SingletonTest02 instance3 = SingletonTest02.getInstance();
        SingletonTest02 instance4 = SingletonTest02.getInstance();
        System.out.println(instance3==instance4);
        System.out.println("instance3.hashCode() = " + instance3.hashCode());
        System.out.println("instance4.hashCode() = " + instance4.hashCode());


        SingletonTest03 instance5 = SingletonTest03.getInstance();
        SingletonTest03 instance6 = SingletonTest03.getInstance();
        System.out.println(instance5==instance6);
        System.out.println("instance5.hashCode() = " + instance5.hashCode());
        System.out.println("instance6.hashCode() = " + instance6.hashCode());

        SingletonTest04 instance7 = SingletonTest04.getInstance();
        SingletonTest04 instance8 = SingletonTest04.getInstance();
        System.out.println(instance7==instance8);
        System.out.println("instance7.hashCode() = " + instance7.hashCode());
        System.out.println("instance8.hashCode() = " + instance8.hashCode());

        SingletonTest05 instance9 = SingletonTest05.getInstance();
        SingletonTest05 instance0 = SingletonTest05.getInstance();
        System.out.println(instance9==instance0);
        System.out.println("instance9.hashCode() = " + instance9.hashCode());
        System.out.println("instance0.hashCode() = " + instance0.hashCode());

        SingletonTest06 instance11 = SingletonTest06.INSTANCE;
        SingletonTest06 instance12 = SingletonTest06.INSTANCE;
        System.out.println(instance11==instance12);
        System.out.println("instance11.hashCode() = " + instance11.hashCode());
        System.out.println("instance12.hashCode() = " + instance12.hashCode());

    }
}
