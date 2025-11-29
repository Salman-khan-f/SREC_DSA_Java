public class oops {
    public static void main(String[] args) {
        
        Management obj = new Management();

        // obj.abc();
        
    }
}

class Management {

    String data = "demo data";
    int datacount;

    // {
    //     System.out.println("before the constr");
    //     datacount = 5;
    // }

    // paramaters / arguments
    Management(){
        // this.data = data;
        data = "lalala";
        System.out.println("this is the constructor for the management class"+ this.data);
    }

    // Management(int age){
    //     System.out.println(age+"gafduygaduaesdyg");
    // }

    // Management(String name){
    //     System.out.println(name + "-------------");
    // }
    
    // Management(String name, int age){
    //     System.out.println(name + "-------------" + age);

    // }

    public void abc(){
        data = "lalalalalla";
        System.out.println("abc mana      " + this.data);
    }
    
    public void xyz(){
        System.out.println("xyz mana");
    }
}
