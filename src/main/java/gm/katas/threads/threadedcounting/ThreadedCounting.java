package gm.katas.threads.threadedcounting;

public class ThreadedCounting {

    public static final int MAX_VALUE = 100;
//    private static final Counter counter = new Counter();
    public static final int DIVISOR = 3;

    /*public static void main(String[] args) {
        final long currentTimeMillis = System.currentTimeMillis();
        countInThreads(counter);
        //System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }*/

    public static void countInThreads(Counter counter) {
        CommunicationChanel chanel = new CommunicationChanel();
        final Object lock = new Object();
        ProducerThread producerThread = new ProducerThread(lock, MAX_VALUE, chanel);
        ConsumerThread[] consumerThreads = new ConsumerThread[DIVISOR];
        for (int i = 0; i <DIVISOR; i++) {
            consumerThreads[i] = new ConsumerThread(lock, counter, i, chanel);
            consumerThreads[i].start();
        }
        producerThread.start();
        try {
            producerThread.join();
            for (int i = 0; i <DIVISOR; i++) {
                consumerThreads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ProducerThread extends Thread{
        private final Object lock;
        private final int maxValue;
        private final CommunicationChanel chanel;

        private ProducerThread(Object lock, int maxValue, CommunicationChanel chanel) {
            super("producer");
            this.lock = lock;
            this.maxValue = maxValue;
            this.chanel = chanel;
        }

        @Override
        public void run() {
            for (int i = 1; i <= maxValue; i++) {
                synchronized (lock){
                    //System.out.println("prod lock " + i);
                    chanel.setValue(i);
                    //System.out.println("prod notify " + i);
                    lock.notifyAll();
                    while (chanel.getValue() != 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            synchronized (lock){
                chanel.setValue(-1);
                lock.notifyAll();
            }
        }
    }

    private static class ConsumerThread extends Thread{
        private final Object lock;
        private final Counter counter;
        private final int modResult;
        private final CommunicationChanel chanel;

        private ConsumerThread(Object lock, Counter counter, int i, CommunicationChanel chanel) {
            super("consumer-3k+"+i);
            this.lock = lock;
            this.counter = counter;
            this.modResult = i;
            this.chanel = chanel;
        }

        @Override
        public void run() {
            synchronized (lock){
                //System.out.format("%s cons lock %d\n", getName(), chanel.getValue());
                while(chanel.getValue() != -1){
                    if((chanel.getValue() != -1 || chanel.getValue() == 0) && !isMyValue()) {
                        try {
                            //System.out.format("%s cons wait %d\n", getName(), chanel.getValue());
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //System.out.format("%s cons NO wait %d\n", getName(), chanel.getValue());

                    if(chanel.getValue()!=-1 && isMyValue()) {
                        counter.count(chanel.getValue());
                        chanel.setValue(0);
                        lock.notifyAll();
                    }
                }
            }
        }

        private boolean isMyValue() {
            return chanel.getValue()>0 && chanel.getValue() % DIVISOR == modResult;
        }
    }

    private static class CommunicationChanel {
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
