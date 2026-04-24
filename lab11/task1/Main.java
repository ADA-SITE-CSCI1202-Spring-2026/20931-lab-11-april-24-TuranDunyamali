package task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available cores: " + cores);

        long start1 = System.currentTimeMillis();

        Thread single = new Thread(new MathTask(1));
        single.start();
        single.join();

        long end1 = System.currentTimeMillis();
        System.out.println("Time with 1 thread: " + (end1 - start1) + " ms");

        Thread[] threads = new Thread[cores];

        long start2 = System.currentTimeMillis();

        for (int i = 0; i < cores; i++) {
            threads[i] = new Thread(new MathTask(i));
            threads[i].start();
        }

        for (int i = 0; i < cores; i++) {
            threads[i].join();
        }

        long end2 = System.currentTimeMillis();
        System.out.println("Time with " + cores + " threads: " + (end2 - start2) + " ms");
    }
}