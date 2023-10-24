import java.util.Scanner;
public class DoorSystem {

    public enum GearShift { P, N, D, ONE, TWO, THREE, R }

    public static void main (String[]args){
        String Dash_Switch_Left; 
        String Dash_Switch_Right;
        String Child_Lock;
        String Master_Unlock;
        String Outside_Handle_Left;
        String Outside_Handle_Right;
        String Inside_Handle_Left;
        String Inside_Handle_Right;
        Gearshift level;
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter permitted code for minivan doors: ");
        String code = in.nextLine();

        Dash_Switch_Left = code.substring(0);
        Dash_Switch_Right = code.substring(1);
        Child_Lock = code.substring(2);
        Master_Unlock = code.substring(3);
        Outside_Handle_Left = code.substring(4);
        Outside_Handle_Right = code.substring(5);
        Inside_Handle_Left = code.substring(6);
        Inside_Handle_Right = code.substring(7);
        String Gear = code.substring(8);
        
        //Code for Gearshifter 
        if(Gear.equals("P")){
            level = GearShift.P;
        }
        else if(Gear.equals("N")){
            level = GearShift.N;
        }
        else if(Gear.equals("D")){
            level = GearShift.D;
        }
        else if(Gear.equals("One")){
            level = GearShift.ONE;
        }
        else if(Gear.equals("Two")){
            level = GearShift.TWO;
        }
        else if(Gear.equals("Three")){
            level = GearShift.THREE;
        }
        else{
            System.out.println("Error: Input a correct value for gear");
        }

        //Code for Dash Switch Left
        if (Dash_Switch_Left.equals("0")){ 
            boolean dsl = false;
        }
        else if (Dash_Switch_Left.equals("1")){
            dsl = true;
        }
        else {
            System.outprint("Error: Input a corrct value for Dash Switch Left");
        }

        //Code for Dash Switch Right
        if (Dash_Switch_Right.equals("0")){
            boolean dsr = false;
        }
        else if (Dash_Switch_Right.equals("1")){
            dsl = true;
        }
        else {
            System.out.print("Error: Input a correct value for Dash Switch Right");
        }
        
        //Code for Child Lock 
        if (Child_Lock.equals("0")){
            boolean cl = false;
        }
        else if (Child_Lock.equals("1")){
            cl = true;
        }
        else {
            System.out.print("Error: Input a correct value for Child Lock");
        }

        //Code for Master Unlock
        if (Master_Unlock.equals("0")){
            boolean mu = false;
        }
        else if (Master_Unlock.equals("1")){
            mu = true;
        }
        else {
            System.out.print("Error: Input a correct value for Master Unlock");
        }
    

        //Code for Outside Handle Left
        if(cl = true){
        if (Outside_Handle_Left.equals("0")){ 
            boolean ohl = false;
        }
        else if (Outside_Handle_Left.equals("1")){
            ohl = true;
        }
        else {
            System.outprint("Error: Input a corrct value for Outside Handle Left");
        }

        //Code for Outside Handle Right
        if (Outside_Handle_Right.equals("0")){
            boolean ohr = false;
        }
        else if (Outside_Handle_Right.equals("1")){
            ohr = true;
        }
        else {
            System.out.print("Error: Input a correct value for Outside Handle Right");
        }
    } else if (cl = false){
        System.out.print("Please unlock the Child Lock function to use interior door handles.")
    }

        //Code for Inside Handle Left
        if (Inside_Handle_Left.equals("0")){ 
            boolean ihl = false;
        }
        else if (Inside_Handle_Left.equals("1")){
            ihl = true;
        }
        else {
            System.outprint("Error: Input a corrct value for Inside Handle Left");
        }

        //Code for Inside Handle Right
        if (Inside_Handle_Right.equals("0")){
            boolean ihr = false;
        }
        else if (Inside_Handle_Right.equals("1")){
            ihr = true;
        }
        else {
            System.out.print("Error: Input a correct value for Inside Handle Right");
        }

    }  
}
