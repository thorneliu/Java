import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers{
    private ArrayList<Integer> intList;
    private static final int LISTSIZE = 10;

    ListOfNumbers(){
        intList = new ArrayList<Integer>(LISTSIZE);

        for(int i = 0; i < LISTSIZE; i++){
            intList.add(i);
        }
    }

    public void writeList() {
        // The FileWriter constructor throws IOException, which must be caught.
        try{
            PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < LISTSIZE; i++) {
            // The get(int) method throws IndexOutOfBoundsException, which must be caught.
            out.println("Value at: " + i + " = " + intList.get(i));
            }
            out.close();
        }catch (IOException e) {
            System.err.println("IOException :" + e.getMessage());
        }catch (IndexOutOfBoundsException e){
            System.err.println("IndexOutOfBoundsException:" + e.getMessage());
        }
    }
}
