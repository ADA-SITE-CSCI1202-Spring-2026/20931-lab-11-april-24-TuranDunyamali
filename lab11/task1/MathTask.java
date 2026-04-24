package task1;

class MathTask implements Runnable {
    private int taskId;

    public MathTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        long sum = 0;
        int j = taskId;

        for (int i = 0; i < 10_000_000; i++) {
            sum += (long)i * i * i + (long)i * j;
        }

        System.out.println("Task " + taskId + " finished with sum = " + sum);
    }
}