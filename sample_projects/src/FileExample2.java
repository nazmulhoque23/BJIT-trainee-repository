import java.io.*;
public class FileExample2 {
    public static void main(String[] args){
        char[] input = new char[50];
        int size = 0;
        try{
            File file = new File("D:\\trainee folder\\sample_files\\fileWrite.txt");
            FileWriter fw = new FileWriter(file);
            fw.write("Hey\neveryone\n");
            fw.flush();
            fw.close();

            FileReader fr = new FileReader(file);
            size = fr.read(input);
            System.out.println(size+" ");
            for(char c: input){
                System.out.println(c);
            }
            fr.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
