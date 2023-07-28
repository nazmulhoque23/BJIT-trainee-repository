import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DayFourList {
    public static void main(String[] args){
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Toyota");
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Mercedes");

        System.out.println("SIZE OF CAR LIST is: "+ cars.size());
        Collections.sort(cars);//sorting the cars list
        /*for(String car: cars){
            System.out.println(car);
        }*/

        Iterator itr = cars.iterator();
        System.out.println("CARS LISTS:");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        //System.out.println(cars);
        //int index = cars.indexOf("Toyota");
        /*Setting Opel at the 0 index
        cars.set(0, "opel");
        System.out.print(cars.get(0));*/
        //cars.removeAll(cars);

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(22);
        numbers.add(33);
        numbers.add(11);
        numbers.add(04);
        numbers.add(100);

        Collections.sort(numbers);
        System.out.println("Sorted Numbers arraylist:");
        /*for(Integer num: numbers){
            System.out.println(num);
        }*/

        Iterator numItr = numbers.iterator();
        while(numItr.hasNext()){
            System.out.println(numItr.next());
        }

        ArrayList<String> names = new ArrayList<String>();
        boolean result = names.isEmpty();//checking if arraylist is empty
        System.out.println(result);

        if(names.size()==0){//size() is used to check the size of an arraylist
            System.out.println("List is empty");
        }

    }
}
