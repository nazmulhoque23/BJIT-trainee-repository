import java.util.*;

public class Main {
    public static void main(String[] args) {
        //wrapper using list
        /*List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(4);
        numbers.add(0);

        int sum = 0;
        for(Integer num:numbers){
            sum += num;
        }

        System.out.println("Sum of numbers: "+sum);
        Collections.sort(numbers);
        System.out.println("Sorted numbers:"+numbers);*/

        // ===== wrapper class usage to change byte to string====
        byte[] bytes = {4, 10, 110, 98, 10};
        //{72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100}
        String str = new String(bytes);
        System.out.println(str);

        StringBuilder sb = new StringBuilder();
        for(byte b: bytes){
            sb.append(Byte.toString(b)).append(",");
        }
        String byteStr = sb.toString().trim().replaceAll(",$","");
        //byteStr = byteStr.;
        System.out.println(byteStr);

    }
}