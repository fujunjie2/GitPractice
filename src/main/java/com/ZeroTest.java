package com;

public class ZeroTest {

    public static void main(String[] args) {

        int sum = 0;
        for (int i = 0; i<20; i++) {
            sum += 0;

            if (i % 4 == 0) {
                break;
            }
        }



        try {
            int i = 100 / 0;
        } catch (Exception e) {
            System.out.println(1);
            throw new RuntimeException();
        } finally {
            System.out.println(2);
        }

    }
}
