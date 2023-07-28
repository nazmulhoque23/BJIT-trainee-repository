import java.io.*;

public class ObjectReadWrite implements Serializable{
    String name;
    int age;
    String gender;
    public ObjectReadWrite(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ObjectReadWrite{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args){


        try{
            //ObjectReadWrite person1 = new ObjectReadWrite("rachel", 30, "female");
//            ObjectReadWrite person2 = new ObjectReadWrite("ross", 30, "male");
            OutputStream f = new FileOutputStream("fileWrite.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            //System.out.println(person1.name);
            o.writeObject(new ObjectReadWrite("rachel", 30, "female"));
            o.flush();
//            o.writeObject(person2);

            o.close();

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        try{
            InputStream fi = new FileInputStream("fileWrite.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            ObjectReadWrite pr1 = (ObjectReadWrite) oi.readObject();
//            ObjectReadWrite pr2 = (ObjectReadWrite) oi.readObject();

            System.out.println(pr1.toString());
//            System.out.println(pr2.name);

            oi.close();
            fi.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
