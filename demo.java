
class Parent{
    void Home(){
        System.out.println("home sweet home");
    }

    void bike(){
        System.out.println("Jupiter 125cc");
    }
}

class Child extends Parent{
    void bike(){
        System.out.println("RE");
    }
}



public class demo {

    static class Student{
        int reg_no ;
        String name;
        String dept;
        String clg;

        Student(int roll_no, String name,String dept, String cl){
            this.reg_no = roll_no;
            this.name = name;
            this.dept = dept;
            this.clg = cl;
        }

        // getter
        public int getReg_no(){
            return reg_no;
        }

        public String getName(){
            return name;
        }

        public String getDept(){
            return dept;
        }

        public String getclg(){
            return clg;
        }
    }

    public static void main(String[] args) {
        
        Student ob = new Student(1233,"sk");

        System.out.println(ob.getReg_no());
    }
}