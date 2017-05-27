import java.time.Instant;

public class InstantDemo {
	public static void main(String[] args){
		Instant timestamp = Instant.now();
		System.out.println(timestamp.toString());
		return;
	}
}
