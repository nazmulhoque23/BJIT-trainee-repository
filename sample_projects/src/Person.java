import org.w3c.dom.ls.LSOutput;

public class Person {
    int id;
    String name;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }


}
class Student extends Person {
    int marks;

    public Student(int id, String name, int marks){
        super(id, name);
        this.marks = marks;
    }

    void passOrFail(Student st){
        if(st.marks <50){
            System.out.println("FAIL");
        }
        else{
            System.out.println("PASS");
        }
    }


}

class TranserStudent extends Student{
    int rollNo;
    public TranserStudent(int id, String name, int marks, int rollNo){
        super(id, name, marks);
        this.rollNo = rollNo;

    }
    void passOrFail(Student kd){
        if(kd.marks <50){
            System.out.println("Kid FAILed");
        }
        else{
            System.out.println("Kid PASSed");
        }
    }
}
class Test{
    public static void main(String[] args){
        Person s = new TranserStudent(1, "Kazi", 60, 34);
        Student st = (Student) s;
        st.passOrFail(st);
    }
}
