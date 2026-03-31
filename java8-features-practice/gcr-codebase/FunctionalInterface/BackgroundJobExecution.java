public class BackgroundJobExecution {
    public static void main(String[] args){
        Runnable backgroundTask = () -> {
            System.out.println("Background job started...");
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){
                System.out.println("Task interrupted");
            }
            System.out.println("Background job completed.");
        };
        Thread thread = new Thread(backgroundTask);
        thread.start();

        System.out.println("Main thread is free to perform other tasks.");
    }
}
