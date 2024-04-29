import java.awt.Rectangle;

public class ToStringDemo{
    public static void main(String[] args) {
        Rectangle box = new Rectangle (5,10,20,30);
        //System.out.print(box);

        Employee31 ed = new Employee31("Gerald", 10000000);
        System.out.println(ed);

        Employee31 steve = new Employee31("steve young", 10000);
        Employee31 mryoung = new Employee31("steve young", 10000);
        System.out.println(steve);
        System.out.println(mryoung);

        if(steve.equals(mryoung)){
            System.out.println("We have duplicates!");
        } else {
            System.out.println("No duplicates!");
        }
    }
}