import java.util.*;

public class TestBox{
	public static <T> void addBox(T t, List<Box<T>> boxList){
		Box<T> box = new Box<>();
		box.set(t);
		boxList.add(box);
	}

	public static <T> void showBoxList(List<Box<T>> boxList){
		int counter = 0;
		for (Box<T>box : boxList)
		{
			T contents = box.get();
			System.out.println("Box #" + counter + " contains " + contents.toString());
			counter++;
		}
	}

	public static void main(String[] args)
	{
		ArrayList<Box<Integer>> boxList = new ArrayList<>();
		addBox(100, boxList);
		addBox(200, boxList);
		addBox(300, boxList);

		showBoxList(boxList);
	}
}
