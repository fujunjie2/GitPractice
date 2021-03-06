package com.thread;

/**
 * 伪共享
 */
public class FakeShare {

    public static void main(String[] args) throws Exception{
        testPointer(new Pointer());
    }


    private static void testPointer(Pointer pointer) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.x++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.y++;
            }
        });


        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(pointer.x);
        System.out.println(pointer.y);
    }
}

class Pointer {
    volatile long x;
    volatile long y;
}

