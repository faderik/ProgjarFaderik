package thread;
/**
 * Week 6 : Wednesday, 23 Maret 2022
 */

//public class ThreadKuu implements Runnable{
public class ThreadKuu extends Thread{
    private String threadName;
    private int n;
    private int result;

    public ThreadKuu(String threadName, int n) {
        this.threadName = threadName;
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public static void main(String[] args)  {
        System.out.println("Class Thread");

    }

    @Override
    public void run() {
        synchronized (this){

            for(int i=0; i<this.n; i++){
                // System.out.println(this.getThreadName() + " : " + i);
                this.result += i;
            }

        }

    }
}
