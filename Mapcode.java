import java.util.*;

public class Mapcode {

    public static void printMap(Map<Integer,String> listMap){
        System.out.println(listMap);
    }

    public static void main(String[] args) {
        Map<Integer,String> obj = new HashMap<>();

        obj.put(1,"salman" );
        obj.put(2, "Kumar");
        obj.put(3,"sk");

        printMap(obj);

        obj.put(3, "Siva");

        printMap(obj);

        obj.remove(1);

        printMap(obj);

        obj.put(1,"Go for the Lunch Break");

        obj.put(2, "Come back by 1.10pm");

        obj.put(3,"not allowed on the class");

        printMap(obj);
    }
}


// {key : values}