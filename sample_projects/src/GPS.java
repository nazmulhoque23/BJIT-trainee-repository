//import java.util.Date;

import java.util.Scanner;

public interface GPS {
    void getCoordinates();
    void getCurrentLoc();
    final int price = 30;
}

class Electronics{
    int id;

    String brand;



    public Electronics(int id, String brand){
        this.id = id;
        this.brand = brand;

    }
}

class Phone extends Electronics implements GPS{
    String battery;
    public Phone(int id, String brand, String battery){
        super(id, brand);
        this.battery = battery;
    }
    public void getCoordinates(){
        Scanner sc = new Scanner(System.in);
        System.out.println(price);
        if(id>=1 && id< 10){
            System.out.println("N 83, S 76, E 81, W 74");
        }
        else if(id>10 && id< 20){
            System.out.println("N 81, S 71, E 89, W 79");
        }
        else{
            System.out.println("N 51, S 11, E 39, W 99");
        }
    }
    public void getCurrentLoc(){
        System.out.println("Located in Bangladesh");
    }

}

class TabPhone extends Phone implements GPS{
    String megaPixel;
    public TabPhone(int id, String brand, String battery, String megaPixel){
        super(id, brand, battery);
        this.megaPixel = megaPixel;
    }
    public void getCoordinates(){
        System.out.println("THIS IS IN: N 100, S 200, E 300, W 400");
    }

    public void getCurrentLoc(){
        System.out.println("THis is in INdia");
    }


}

class TestExample{
    public static void main(String[] args){
        Phone p = new Phone(1, "Nokia", "erd mobile battery");
        p.getCoordinates();
        p.getCurrentLoc();

        TabPhone tp = new TabPhone(2, "Apple", "iGear", "18 mp");
        tp.getCoordinates();
        tp.getCurrentLoc();
        System.out.println(GPS.price);

    }
}
/*class SmartWatch extends Electronics implements GPS{
    String battery;
    public SmartWatch(int id, String brand, String battery){
        super(id, brand);
        this.battery = battery;
    }
    public void getCoordinates(){
        System.out.println("THIS IS IN: N 100, S 200, E 300, W 400");
    }

    public void getCurrentLoc(){
        System.out.println("this is in India");
    }

}*/
