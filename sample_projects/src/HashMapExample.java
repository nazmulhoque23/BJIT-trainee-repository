import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        // create a new HashMap to store key-value pairs of strings
        Map<String, String> map = new HashMap<>();

        // add some key-value pairs to the map
//        map.put("apple", "red");
//        map.put("banana", "yellow");
//        map.put("peach", "pink");
//        map.put("avocado", "green");
//        map.put("mango", "light yellow");
//        map.put("jackfruit", "light green");
//        map.put("watermelon", "dark red");
        map.put("V-1", "Car");
        map.put("V-2", "Motorcycles");
        map.put("V-3", "Bus");
        map.put("V-4", "Train");
        map.put("V-5", "Rickshaw");
        map.put("V-6", "Aeroplane");
        map.put("V-7", "Truck");



        Set<Map.Entry<String, String>> s = map.entrySet();
        System.out.println("Key and Value of Map Entries");
        for(Map.Entry<String, String> fruits:s){
            System.out.println(fruits.getKey()+":"+fruits.getValue());
        }
        // retrieve the value associated with a key
        String color = map.get("apple");
        System.out.println("The color of an apple is " + color);

        // iterate over the keys in the map and print each one
        System.out.println("The keys in the map are:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // iterate over the values in the map and print each one
        System.out.println("The values in the map are:");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }

        // remove a key-value pair from the map
        map.remove("banana");

        // check if a key is present in the map
        boolean containsKey = map.containsKey("banana");
        System.out.println("Does the map contain a banana? " + containsKey);

        // check if a value is present in the map
        boolean containsValue = map.containsValue("red");
        System.out.println("Does the map contain the color red? " + containsValue);
    }
}
