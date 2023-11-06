public class LogicErrorPartA {
    public static void main(String[] args) {
            String name = "Harry";
            System.out.println("The last letter of the name is " +
            name.charAt(name.length() - 1)); //added a -1 add because their is 5 characters, but strings are counted from 0, the string index was out of range. 
    }
    //This was a run time error as it is was crashing when it is run. 
            
}
