import java.util.Scanner;
class DoorSystem {
        enum GearShift { P, N, D, ONE, TWO, THREE, R }
        boolean Dash_Switch_Left; 
        boolean Dash_Switch_Right;
        boolean Child_Lock;
        boolean Master_Unlock;
        boolean Outside_Handle_Left;
        boolean Outside_Handle_Right;
        boolean Inside_Handle_Left;
        boolean Inside_Handle_Right;
        Gearshift Gear;

        public void Dash_SwitchL_Status(){
            if(Dash_Switch_Left = true){
                
            }
        }
public static void main (String[]args){
    //use charAt for if statements
    //use private then boolean or variable
        Scanner in = new Scanner(System.in);
        System.out.print("Enter permitted code for minivan doors: ");
        String code = in.nextLine();
        
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
        if(level ==GearShift.P){
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
    

        //Code for Inside Handle Left
        if(cl = true){
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
        } else if (cl = false){
        System.out.print("Please unlock the Child Lock function to use interior door handles.");
    
    }else{
        System.out.print("Error: Car must be parked to open doors");
    }
    }
    }
}
