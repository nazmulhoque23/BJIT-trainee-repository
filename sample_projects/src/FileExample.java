import java.io.File;

public class FileExample {
    public static void main(String[] args){
        try{
            boolean newFile = false;
            //File file = new File("D:\\trainee folder\\sample_files\\fileWrite.txt");
            File file = new File("D:\\trainee folder");
            System.out.println(file.exists());
            //newFile = file.createNewFile();
//            System//.out.println(newFile);
//            System.out.println(file.exists());
            System.out.println(file.getFreeSpace());
            System.out.println(file.listFiles());
            System.out.println(file.getUsableSpace());
            System.out.println(file.isDirectory());
            System.out.println(file.isFile());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
