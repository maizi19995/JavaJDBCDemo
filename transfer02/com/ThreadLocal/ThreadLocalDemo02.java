package com.ThreadLocal;

/**
 * @author Maizi
 * @PackageName:com.ThreadLocal
 * @ClassName: ThreadLocalDemo
 * @Description:
 * @Date 2020/8/8 20:39
 */
public class ThreadLocalDemo02 {
    public static void main(String[] args) {

        /**
         * ThreadLocal作用:为每一个线程,提高一个独立的存储数据空间
         * 结论:ThreadLocal能保证,哪个线程保存的数据,只能有那个线程取出,别的线程取不到数据的
         */
        final ThreadLocal<String>  threadLocal=new ThreadLocal<>();
        threadLocal.set("abc");
        new Thread(){
            @Override
            public void run() {
               String s=threadLocal.get();
               System.out.println(s);
            }
        }.start();
    }
}
