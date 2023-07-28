import java.util.ArrayList;

public class LambdaExample {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(6);
        numbers.add(8);
        //Integer sum = 0;
        numbers.forEach((n)->System.out.println(n));

    }
}
