import java.util.*;

//ctrl+alt+l to format code
public class KaziMdNazmulHoque0030059 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> items = new HashMap<String, ArrayList<String>>();

        items.put("vehicles", new ArrayList<>(Arrays.asList("bus", "car", "truck", "aeroplane", "rickshaw")));
        items.put("foods", new ArrayList<>(Arrays.asList("banana", "mango", "jackfruit", "watermelon")));
        items.put("brands", new ArrayList<>(Arrays.asList("coca-cola", "mcdonalds", "apple")));
        items.put("nullexample", null);
        items.put("sports", new ArrayList<>(4));

        ArrayList<String> sportsName = items.get("sports");
        sportsName.add("Football");
        sportsName.add("Cricket");
        sportsName.add("hockey");

        try {
            sportsName.add(5, "baseball");

        } catch (Exception ex) {
            System.out.println("Thrown exception:" + ex);
        } finally {
            System.out.println("getting out of try/catch block");
        }
        Set<Map.Entry<String, ArrayList<String>>> itemSet = items.entrySet();

        for (Map.Entry<String, ArrayList<String>> item : itemSet) {
            //System.out.println(item.getKey()+":"+item.getValue());
            System.out.println(item.getKey() + "(KEY):");

            if (item.getValue() == null) {
                try {
                    item.getValue().removeAll(item.getValue());
                } catch (NullPointerException e) {
                    System.out.println("Exception thrown:" + e);
                } finally {
                    System.out.println("Getting out of try/catch block");
                }
            } else {
                Collections.sort(item.getValue());
                System.out.println("Size of the list:" + item.getValue().size());
                System.out.println("Values of the list:" + item.getValue());

            }


        }
        ArrayList<String> values = items.get("sports");

        /*for(String food:values){
            System.out.println(food);
        }*/

        System.out.println("SIZE:" + values.size());
        Iterator itr = values.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        values.set(0, "baseball");
        Collections.sort(items.get("sports"));
        System.out.println(items.get("sports"));
        //items.get("foods").add(0,"pizza");
        //values.removeAll(values);

        boolean containsKey = items.containsKey("foods");
        System.out.println(containsKey);
        for (String key : items.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
        items.remove("nullexample");
        System.out.println(items);
        /*Iterator itr = category.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }*/


    }
}
