package com.spark.test;

/**
 * Created by Spark on 8/30/16.
 */
public class CountControl {
    public static void main(String[] args) {
        Counter c = new Counter(5);
        c.increase();
        //c.setCount(7);
        System.out.println("args = [" + c.getCount() + "]");
    }
}
