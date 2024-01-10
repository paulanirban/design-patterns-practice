package com.practice.designpatterns.creational.singleton.sample;

public class SingletonPractice {
    public static void main(String[] args) {
        SingleObjectClass singleObj1 = SingleObjectClass.getInstance();
        SingleObjectClass singleObj2 = SingleObjectClass.getInstance();

        System.out.println(singleObj1);
        System.out.println(singleObj2);

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());

        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            SingletonMultithreaded singletonObj = SingletonMultithreaded.getInstance("Foo");
            System.out.println(singletonObj.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            SingletonMultithreaded singletonObj = SingletonMultithreaded.getInstance("Bar");
            System.out.println(singletonObj.value);
        }
    }
}
