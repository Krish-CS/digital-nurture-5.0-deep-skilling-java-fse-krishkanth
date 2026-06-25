package com.bank;

public class PerformanceTester {

    public String performTask() {
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        return "Task completed, sum = " + sum;
    }

    public void slowTask() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
