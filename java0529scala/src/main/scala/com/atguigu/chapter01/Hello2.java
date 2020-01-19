package com.atguigu.chapter01;


/**
 * @author 游正荣
 * @create 2020-01-19 15:55
 */
public class Hello2 {
    public static void main(String[] args) {
        Hello2$.MODULE$.main(args);
    }
}

final class Hello2$ {
    public static final Hello2$ MODULE$;
    static {
        MODULE$ = new Hello2$();
    }

    public void main(String[] args) {
        System.out.println("hello,scala");
    }
}
