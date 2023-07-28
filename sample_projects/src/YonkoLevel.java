import java.util.ArrayList;

public interface YonkoLevel {
    boolean hasCaptainKingsHaki();
    String threatLevel(int incidents);
    void noOfTerritories(int sizesInNo, String sentiment);

}

class PirateCrew{
    String captainName;
    int noOfCrews;
    public PirateCrew(String captainName, int noOfCrews){
        this.captainName = captainName;
        this.noOfCrews = noOfCrews;
    }
}

class NewWorldPirateCrew extends PirateCrew implements YonkoLevel{
    int kingsHakiUsers;
    public NewWorldPirateCrew(String captainName, int noOfCrews, int kingsHakiUsers){
            super(captainName, noOfCrews);
            this.kingsHakiUsers = kingsHakiUsers;
        }
    public boolean hasCaptainKingsHaki(){
        if(kingsHakiUsers>1){
            return true;
        }
        else{
            return false;
        }
    }

    public String threatLevel(int bigIncidents){
        if(bigIncidents>5){
            return "HIGH";
        }
        else{
            return "ROOKIE";
        }
    }

    @Override
    public void noOfTerritories(int sizesInNo, String sentiment) {
        if(sizesInNo>5000 && sentiment =="kind"){
            System.out.println("GOOD GUYS");

        }
        else{
            System.out.println("BAD GUYS");
        }
    }
}

class WorstGeneration extends NewWorldPirateCrew implements YonkoLevel {
    public WorstGeneration(String captainName, int noOfCrews, int kingsHakiUsers) {
        super(captainName, noOfCrews, kingsHakiUsers);
    }

    public boolean hasCaptainKingsHaki() {
        if (noOfCrews < 10) {
            return false;

        } else {
            return true;
        }
    }
}

class Testing{
    public static void main(String[] args){
//        NewWorldPirateCrew strawHatPirates = new NewWorldPirateCrew("Monkey. D Luffy", 11, 3);
//        System.out.println(strawHatPirates.hasCaptainKingsHaki());
//        System.out.println(strawHatPirates.threatLevel(4));

        WorstGeneration kidPirates = new WorstGeneration("Kidd", 15, 0);
        System.out.println(kidPirates.hasCaptainKingsHaki());
        System.out.println(kidPirates.threatLevel(3));

    }
}
