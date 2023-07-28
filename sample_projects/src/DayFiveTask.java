import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyInterface{
    List<Integer> evenNumbers(ArrayList<Integer> nums);
}

public class DayFiveTask {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10,8,3,2,16,60,9));

        MyInterface evenFind = (nums)->{
            return nums.stream().filter((num)->num%2==0).sorted().toList();
        };

        System.out.println(evenFind.evenNumbers(numbers));
    }

}
