import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class mapDemo {
    public static void main(String[] args){
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        Set<Integer> intSet = intList.stream().collect(Collectors.toSet());

        intSet.forEach(i -> System.out.println(i));
    }
}
