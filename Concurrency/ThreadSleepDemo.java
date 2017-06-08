public class ThreadSleepDemo {
	public static void main(String[] args) throws InterruptedException {
		int number = Integer.parseInt(args[0]);
		for (int i = 0; i < number; i++) {
			Thread.sleep(1000);
			System.out.println(i);
		}
	}
}
