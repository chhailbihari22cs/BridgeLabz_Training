
public class BackgroundJob {

	public static void main(String[] args) {
		Runnable job = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Job interrupted");
            }
            System.out.println("Background job completed.");
        };

        Thread thread = new Thread(job);
        thread.start();

        System.out.println("Main thread continues execution...");

	}

}