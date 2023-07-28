class Tech{
    public void tech(){System.out.print("tech");}

}
class ATech{
    Tech a = new Tech(){
        public void tech(){
            System.out.println("new tech");
        }
    };

    public void doTHis(){
        a.tech();
    }
}



public class Test {
    public static void main(String[] args){
        ATech a = new ATech();
        a.doTHis();
    }
}
