import java.io.*;
public class BufferedReadWrite {
    public static void main(String[] args){
//        char[] input = new char[50];
//        int size = 0;
        try{
            File file = new File("D:\\trainee folder\\sample_files\\fileWrite.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Hey\neveryone\n");
            bw.newLine();
            bw.write("How are you");
            bw.flush();
            bw.close();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine())!=null){
                System.out.println(s);
            }
            br.close();
            fr.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
