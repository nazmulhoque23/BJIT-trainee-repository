import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        // create an optional that contains a non-null value
        Optional<String> optional1 = Optional.of("hello");
        System.out.println(optional1.isPresent()); // prints "true"
        System.out.println(optional1.get()); // prints "hello"

        // create an optional that does not contain a value
        Optional<String> optional2 = Optional.empty();
        System.out.println(optional2.isPresent()); // prints "false"

        // use the map method to perform an operation on the contained value
        Optional<String> optional3 = Optional.empty();

        Optional<Integer> optional4 = optional3.map(Integer::parseInt);
        System.out.println(optional4.isPresent()); // prints "true"
        System.out.println(optional4.get());
        System.out.println(optional4.orElse(0));

//        try{
//            Optional<Integer> optional4 = optional3.map(Integer::parseInt);
//            System.out.println(optional4.isPresent()); // prints "true"
//            System.out.println(optional4.get()); // prints 123
//        }
//        catch (Exception e){
//            System.out.println("Exception thrown:"+e.getMessage());
//        }


        // use the orElse method to provide a default value if the optional is empty
        String value = optional2.orElse("world");
        System.out.println(value); // prints "world"
    }

}