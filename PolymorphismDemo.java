import java.util.Spliterator;

// run time polymorphism - Overriding

public class PolymorphismDemo {

    public static void main(String[] args) {
        
        splender ob = new splender();
        ob.run();
    }
}

class bike {

    public void run(){
        System.out.println("running at 210km");
    }
    
}
class splender extends bike {
    @Override
    public void run(){
        String x = "tjhrtud6t splender";
        if(x.contains("splender")){
            System.out.println("max speed is 90km");
        }
        else{
            super.run();
        }
    }
    
}