public class DemoScope {
    static int total = 12; //has to be static as no object of class DemoScope --> if this included, will print 12 as total in newTotal is only seen in total
    public static void setTotal(int newVal){
        int total = newVal;

    }
    public static void main(String[] args) {
        setTotal(88);
        System.out.println(total); //total is only in the scope of the setTotal method --> thus is cannot be seen
    }
}

