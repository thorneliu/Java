public class TestHelloRunnable {
	public static void main(String[] args) {
		(new Thread(new HelloRunnable())).start();

	}
}
