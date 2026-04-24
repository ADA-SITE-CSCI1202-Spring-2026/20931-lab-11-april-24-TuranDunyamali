package task2;

class SharedResource {
    private int value;
    private boolean bChanged = false;

    public synchronized void set(int value) {
        try {
            while (bChanged) {
                wait(); 
            }

            this.value = value;
            bChanged = true;

            System.out.println("Produced: " + value);

            notify(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int get() {
        try {
            while (!bChanged) {
                wait(); 
            }

            bChanged = false;

            System.out.println("Consumed: " + value);

            notify();

            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
