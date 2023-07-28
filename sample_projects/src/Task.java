public class Task {
    public static void main(String[] args){
        String str = "Hello there, what do you do?";
        String[] strArray = str.replaceAll("[,?]","").trim().split("\\s");
        System.out.println(strArray.length);
        for(String s:strArray){
            System.out.println(s);
        }
    }
}
