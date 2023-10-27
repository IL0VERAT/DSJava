import java.util.Scanner;
class DoorSystem {
         DoorSystem(String targetCode){
            update(targetCode);
        }

        enum GearShift { P, N, D, ONE, TWO, THREE, R }

        boolean dash_Switch_Left;
        boolean dash_Switch_Right;
        boolean child_Lock;
        boolean Master_Unlock;
        char Outside_Handle_Left = code.charAt(6);
        char Outside_Handle_Right = code.charAt(7);
        char Inside_Handle_Left = code.charAt(4);
        char Inside_Handle_Right = code.charAt(5);
        Gearshift Gear;
        char Gear_shifter = code.charAt(8);
        boolean left_door;//change to designated names
        boolean right_door;

        public void update(String targetCode) {

            // determine state of left dash switch.
            if (targetCode.charAt(0) == '1' ) {
                // the switch is enabled.
                dash_Switch_Left = true;
            } else {
                dash_Switch_Left = false;
            }
            

            // determine state of right dash switch.
            if (targetCode.charAt(1) == '1' ) {
                // the switch is enabled.
                dash_Switch_Right = true;
            } else {
                dash_Switch_Right = false;
            }

            if(targetCode.charAt(2) == '1'){
                child_Lock = true;
            } else{
                child_Lock = false;
            }

            

        }
            if(targetCode.charAt(2 == '2')){
                left_door = false;
            }
            else if(Dash_Switch_Left == 0){
                left_door = true;
            }
            else{
                System.out.println("Error with dash switch left input.");
            }
        }
        public void Dash_SwitchR_Code(){
            if(Dash_Switch_Right == 0){
                right_door = false;
            }
            else if(Dash_Switch_Right == 1){
                right_door = true;
            }
            else{
                System.out.println("Error with dash switch right input.");
            }

        }
        public void Master_Lock_Code(){
            if(Master_Unlock == 0){
                left_door = false;
                right_door = false;
            }
            else if(Master_Unlock == 1){
                left_door = true;
                right_door = true;
            }
            else{
                System.out.println("Error with master lock input.");
            }
        }
        boolean lock_of_child;
        public void Child_Lock_Code(){
            if(Child_Lock == 0){
                lock_of_child = false;
            }
            else if(Child_Lock == 1){
                lock_of_child = true;
            }
            else{
                System.out.println("Error with child lock input.");
            }
        }
        public void Outside_Handle_Left_Code(){
            if(Outside_Handle_Left == 0){
                left_door = false;
            }
            else if(Outside_Handle_Left == 1){
                left_door = true;
            }
            else{
                System.out.println("Error with Outside Handle Left Input");
            }
        }
        public void Outside_Handle_Right_Code(){
            if(Outside_Handle_Right == 0){
                right_door = false;
            }
            else if(Outside_Handle_Right == 1){
                right_door = true;
            }
            else{
                System.out.println("Error with Outside Handle Right Input");
            }
        }
        public void Inside_Handle_Left_Code(){
        if(lock_of_child = false){
            if(Inside_Handle_Left == 0){
                left_door = false;
            }
            else if(Inside_Handle_Left == 1){
                left_door = true;
            }
            else{
                System.out.println("Error with Inside Handle Left Input");
            }
        }
        else if(lock_of_child = true){
            left_door = false;
        }
        }
        public void Inside_Handle_Right_Code(){
        if(lock_of_child = false){
            if(Inside_Handle_Right == 0){
                right_door = false;
            }
            else if(Inside_Handle_Right == 1){
                right_door = true;
            }
            else{
                System.out.println("Error with Inside Handle Right Input");
            }
        }
        else if(lock_of_child = true){
            left_door = false;
        }
        }
        public void Gear_Shift_Code(){
            if(Gear_shifter == "P"){
            level = GearShift.P;
            left_door = true;
            right_door = true;
        }
        else if(Gear_shifter == "N"){
            level = GearShift.N;
            left_door = false;
            right_door = false;
            System.out.println("Shift into park to activate doors.");
        }
        else if(Gear_shifter == "D"){
            level = GearShift.D;
            left_door = false;
            right_door = false;
            System.out.println("Shift into park to activate doors.");
        }
        else if(Gear_shifter == "ONE"){
            level = GearShift.ONE;
            left_door = false;
            right_door = false;
            System.out.println("Shift into park to activate doors.");
        }
        else if(Gear_shifter == "TWO"){
            level = GearShift.TWO;
            left_door = false;
            right_door = false;
            System.out.println("Shift into park to activate doors.");
        }
        else if(Gear_shifter == "THREE"){
            level = GearShift.THREE;
            left_door = false;
            right_door = false;
            System.out.println("Shift into park to activate doors.");
        }
        else{
            System.out.println("Error: Input a correct value for gear");
        }
        }
        public void left_door_status(){
            if(left_door = true){
                System.out.println("Left door open");
            }
            else if(left_door = false){
                System.out.println("Left door closed");
            }
        }
        public void right_door_status(){
            if(right_door = true){
                System.out.println("Right door open");
            }
            else if(left_door = false){
                System.out.println("Right door closed");
            }
        }

    }
public class Minivan{
    public static void main(String[]args){
        DoorSystem doorSystem = new DoorSystem("00010100P");

        doorSystem.right_door_status();
        // Make sure to calculate all the variables. 

    }
}

