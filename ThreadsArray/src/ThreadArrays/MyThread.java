package ThreadArrays;

class MyThread implements Runnable {
    Thread thread;
    int sum;
    int indexStart;
    int indexFinish;

    public Thread getThread() {
        return thread;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getIndexStart() {
        return indexStart;
    }

    public void setIndexStart(int indexStart) {
        this.indexStart = indexStart;
    }

    public int getIndexFinish() {
        return indexFinish;
    }

    public void setIndexFinish(int indexFinish) {
        this.indexFinish = indexFinish;
    }

    public MyThread(String name, int indexStart, int indexFinish) {
        thread = new Thread(this, name);
        sum = 0;
        this.indexStart = indexStart;
        this.indexFinish = indexFinish;
        thread.start();
    }

    @Override
    public void run() {
        for (int i = indexStart; i < indexFinish; i++) {
            sum += Task_28c.arr[i];
        }
        System.out.println("Thread :" + thread.getName() + " :" + getSum());
    }
}
