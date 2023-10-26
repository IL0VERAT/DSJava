import java.util.Scanner;
class DoorSystem {
        enum GearShift { P, N, D, ONE, TWO, THREE, R }
        //Note to self: eventually just make one string and use substrings for methods + fix capitalzation 
        String Dash_Switch_Left; 
        String Dash_Switch_Right;
        String Child_Lock;
        String Master_Unlock;
        String Outside_Handle_Left;
        String Outside_Handle_Right;
        String Inside_Handle_Left;
        String Inside_Handle_Right;
        Gearshift Gear;
        
        
        boolean left_door_dashswitch;
        public void Dash_SwitchL_Code(){
            if(Dash_Switch_Left.equals("0")){
                left_door_dashswitch = false;
            }
            else if(Dash_Switch_Left.equals("1")){
                left_door_dashswitch = true;
            }
            else{
                System.out.println("Error with dash switch left input.");
            }
        }
        boolean right_door_dashswitch;
        public void Dash_SwitchR_Code(){
            if(Dash_Switch_Right.equals("0")){
                right_door_dashswitch = false;
            }
            else if(Dash_Switch_Right.equals("0")){
                right_door_dashswitch = true;
            }
            else{
                System.out.println("Error with dash switch right input.");
            }

        }
        boolean the_masters_unlock;
        public void Master_Lock_Code(){
            if(Master_Unlock.equals("0")){
                the_masters_unlock = false;
            }
            else if(Master_Unlock.equals("1")){
                the_masters_unlock = true;
            }
            else{
                System.out.println("Error with master lock input.");
            }
        }

        boolean lock_of_child;
        public void Child_Lock_Code(){
            if(Child_Lock.equals("0")){
                lock_of_child = false;
            }
            else if(Child_Lock.equals("1")){
                lock_of_child = true;
            }
            else{
                System.out.println("Error with child lock input.");
            }
        }
        boolean Outside_Handle_Left_boo;
        public void Outside_Handle_Left_Code(){
            if(Outside_Handle_Left.equals("0")){
                Outside_Handle_Left_boo = false;
            }
            else if(Outside_Handle_Left.equals("1")){
                Outside_Handle_Left_boo = true;
            }
            else{
                System.out.println("Error with Outside Handle Left Input");
            }
        }
        boolean Outside_Handle_Right_boo;
        public void Outside_Handle_Right_Code(){
            if(Outside_Handle_Right.equals("0")){
                Outside_Handle_Right_boo = false;
            }
            else if(Outside_Handle_Right.equals("1")){
                Outside_Handle_Right_boo = true;
            }
            else{
                System.out.println("Error with Outside Handle Right Input");
            }
        }
        boolean Inside_Handle_Left_boo;
        public void Inside_Handle_Left_Code(){
        if(lock_of_child = false){
            if(Inside_Handle_Left.equals("0")){
                Inside_Handle_Left_boo = false;
            }
            else if(Inside_Handle_Left.equals("1")){
                Inside_Handle_Left_boo = true;
            }
            else{
                System.out.println("Error with Inside Handle Left Input");
            }
        }
        else if(lock_of_child = true){
            Inside_Handle_Left_boo = false;
        }
        }
        boolean Inside_Handle_Right_boo;
        public void Inside_Handle_Right_Code(){
        if(lock_of_child = false){
            if(Inside_Handle_Right.equals("0")){
                Inside_Handle_Right_boo = false;
            }
            else if(Inside_Handle_Right.equals("1")){
                Inside_Handle_Right_boo = true;
            }
            else{
                System.out.println("Error with Inside Handle Right Input");
            }
        }
        else if(lock_of_child = true){
            Inside_Handle_Right_boo = false;
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
