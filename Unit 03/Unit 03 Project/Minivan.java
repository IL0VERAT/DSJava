import java.util.Scanner;
class DoorSystem {
         DoorSystem(String targetCode){
            update(targetCode);
        }

        enum GearShift { P, N, D, ONE, TWO, THREE, R }

        boolean dash_Switch_Left; //good
        boolean dash_Switch_Right; //good
        boolean child_Lock;
        boolean Master_Unlock;
        boolean Inside_Handle_Left;
        boolean Inside_Handle_Right;
        boolean Outside_Handle_Left;
        boolean Outside_Handle_Right;
        Gearshift Gear;
        char Gear_shifter = code.charAt(8);

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

            //determine the state of child lock.
            if(targetCode.charAt(2) == '1'){
                child_Lock = true;
            } else {
                child_Lock = false;
            }

            //determines the state of master lock
            if(targetCode.charAt(3) == '1'){
                Master_Unlock = true;
            } else {
                Master_Unlock = false;
            }

            //determines the state of the inside handle on the left
            if(child_Lock = false){
                if(targetCode.chatAt(4) == '1'){
                    Inside_Handle_Left = true;
                 } else {
                    Inside_Handle_Left = false;
                }
            } else {
                Inside_Handle_Left = false;
            }

            //determines the state of the inside handle on the right
            if(targetCode.charAt(5) == '1'){
                Inside_Handle_Right = true;
            } else {
                Inside_Handle_Right = false;
            }

            //determines the state of the outside handle on the left
            if(targetCode.charAt(6) == '1'){
                Outside_Handle_Left = true;
            } else {
                Outside_Handle_Left = false;
            }

            //determines the state of the outside handle on the right
            if(targetCode.charAt(7) == '1'){
                Outside_Handle_Right = true;
            } else {
                Outside_Handle_Right = false;
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

