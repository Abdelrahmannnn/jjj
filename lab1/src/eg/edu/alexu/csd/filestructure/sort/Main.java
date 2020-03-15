package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import static eg.edu.alexu.csd.filestructure.sort.Controller.arr;
public class Main {
    public static void main(String[] args) {
        //Controller controller=new Controller();
        //Node s=new Node(1);
        //System.out.println(s.getNode());
        ArrayList<Integer> k = new ArrayList<>();
        k.add(5);
        k.add(0) ;
        k.add(1) ;
        k.remove(0) ;
        k.add(0,2) ;
        for(int i=0 ;i<k.size();i++){
            System.out.println(k.get(i));
        }
    }
}
