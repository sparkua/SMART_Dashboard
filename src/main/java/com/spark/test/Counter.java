package com.spark.test;

/**
 * Created by Spark on 8/30/16.
 */
public class Counter {
    int count;

    public Counter(){}
    public Counter(int count){
        this.count = count;
    }


    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increase() {
        count++;
    }

}
