import java.util.ArrayList;
import java.util.List;

public class WildCards{
    public static void showNumberList(List<? extends Number> numberList){
        int count = 0;
        for (Number item : numberList){
            System.out.println("item #" + count + ": " + item);
            count++;
        }
    }

    public static void main(String [] args){
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        showNumberList(intList);
        
        List<Long> longList = new ArrayList<>();
        longList.add(10000000L);
        longList.add(6225158L);
        longList.add(3L);

        showNumberList(longList);

    }
}






