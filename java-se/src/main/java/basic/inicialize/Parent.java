package basic.inicialize;

/**
 * Created by conglin.liu on 2017/8/9.
 */
public class Parent {
    static final String s = "我是常量";
    static int i = 3;
    static {
        System.out.println("父类静态代码块");
    }
    static void  get(){
        System.out.println("父类静态方法");
    }

}

class Child extends Parent{
//    static int i;
    static {
        System.out.println("子类静态代码块");
    }
    static void  get(){
        System.out.println("子类静态方法");
    }
}

class  Test{
    public static void main(String[] args) {
//        System.out.println(Child.i); //不会初始化child
//        System.out.println(Parent.s); //会存入调用它的类的常量池中,不会初始化Parent
        Parent[] array = new Parent[5]; //不会初始化Parent
        System.out.println(array.getClass());
    }

}