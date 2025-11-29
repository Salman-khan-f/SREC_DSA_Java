public class inher {
    public static void main(String[] args) {
        


        Iqube bike3 = new Iqube();

        Jupiter bike4 = new Jupiter();

        // System.out.println(bike1.Engine);

        bike3.
    }
}

// PARENT
class TVS {

    int Engine = 1200;

    String asset = "2cr";

    String totalasset; 


    public void data(){
        System.out.println("sample data from parents");
    }
    
}


// CHILD
class Jupiter extends TVS{
    int cc = 125;
    int MIL = 45;
}

// G C
class Iqube extends Jupiter{
    int cc = 110;
}