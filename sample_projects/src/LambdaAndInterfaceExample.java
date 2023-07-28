import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@FunctionalInterface
interface bonusInterface{
    Double calc(String emp, Double bonus);
}

public class LambdaAndInterfaceExample {
    public static void main(String[] args){
        Map<Integer, String> emps = new HashMap<>();
        emps.put(20000, "Developer");
        emps.put(30000, "Web Designer");

        bonusInterface calculateBonus = (emp, b) ->{
            if(emp == "Developer"){
                return (Double) (1500+(b/100))*20000;
            }
            else{
                return (Double)(1500+(b/50))*30000;
            }
        };
        System.out.println(calculateBonus.calc((emps.get(30000)), 12.00));
        System.out.println(emps.entrySet().stream().filter((emp)->emp.getKey()>20000).toList());
    }

}
