import thread.ThreadKuu;

public class MainDriver {
    public static void main(String[] args) throws InterruptedException {
        // Using extends
        ThreadKuu t1 = new ThreadKuu("T1", 10);
        ThreadKuu t2 = new ThreadKuu("T2", 20);

        // Using implements
        // Thread t3 = new Thread(new ThreadKuu());
        // Thread t4 = new Thread(new ThreadKuu());

        System.out.println("Starting Thread 1");
        t1.setThreadName("-T1");
        t1.start();

        System.out.println("Starting Thread 2");
        t2.setThreadName("+T2");
        t2.start();

        t1.join();
        t2.join();

        System.out.println("T1 Result : " + t1.getResult());
        System.out.println("T2 Result : " + t2.getResult());

    }

}
