public class StringClass {
    public static void main(String[] args){
        String s1 = "welcome to the split world";
        System.out.println(s1.hashCode());
        System.out.println("With limit 0:");
        for(String w: s1.split("\\s", 0)){
            System.out.println(w);
        }

        System.out.println("String split with limit 1");
        for(String w: s1.split("\\s", 1)){
            System.out.println(w);
        }

        System.out.println("String split with limit 2");
        for(String w: s1.split("\\s", 5)){
            System.out.println(w);
        }


    }
}
