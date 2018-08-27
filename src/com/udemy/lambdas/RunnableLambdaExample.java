package com.udemy.lambdas;

public class RunnableLambdaExample {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable1 thread id:" + Thread.currentThread().getId());
            }
        };
        new Thread(runnable).start();

        Runnable runnableLambda = () -> {
            System.out.println("Inside lambda thread id:" + Thread.currentThread().getId());
        };
        runnableLambda.run();

        new Thread(runnableLambda).start();
    }
}
