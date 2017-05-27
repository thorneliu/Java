import java.util.List;
import java.util.ArrayList;

public class StreamDemo {
	public static void main(String[] args){
		List<String> words = new ArrayList<>();
		words.add("Hello");
		words.add("world");
		words.add("Goodbye");
		words.add("System");

		long count = words.stream().filter(w -> w.length() > 6).count();
		System.out.println(count);
	}
}
