package com.gyd.concurrent;

public class ThreadBasicDemo2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("daemon...");
            } finally {
                System.out.println("exit daemon...");
            }
        }
    }
}
