//Coder: Milo Linn-Boggs Date: 1 Nov. 2023
import java.util.Scanner; 
//created DoorSystem class
class DoorSystem { 

        //enum type for minivan gears
        enum GearShift { P, N, D, ONE, TWO, THREE, R } 

        boolean dash_Switch_Left;  
        boolean dash_Switch_Right; 
        boolean child_Lock;
        boolean master_Unlock;
        boolean inside_Handle_Left;
        boolean inside_Handle_Right;
        boolean outside_Handle_Left;
        boolean outside_Handle_Right;
        GearShift Gear;
        boolean gearShifter;

        //Constructor
        public DoorSystem(String initState){ 
            this.update(initState);
        }
        //Updates the DoorSystem code depending on user input
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
                //the switch is enabled
                child_Lock = true;
            } else {
                child_Lock = false;
            }

            //determines the state of master lock
            if(targetCode.charAt(3) == '1'){
                //the switch is enabled
                master_Unlock = true;
            } else {
                master_Unlock = false;
            }

            //determines the state of the inside handle on the left
                if(targetCode.charAt(4) == '1'){
                    //the switch is enabled
                    inside_Handle_Left = true;
                 } else {
                    inside_Handle_Left = false;
                }

            //determines the state of the inside handle on the right
                if(targetCode.charAt(5) == '1'){
                    //the switch is enabled
                    inside_Handle_Right = true;
                } else {
                    inside_Handle_Right = false;
                }

            //determines the state of the outside handle on the left
            if(targetCode.charAt(6) == '1'){
                //the switch is enabled
                outside_Handle_Left = true;
            } else {
                outside_Handle_Left = false;
            }

            //determines the state of the outside handle on the right
            if(targetCode.charAt(7) == '1'){
                //the switch is enabled
                outside_Handle_Right = true;
            } else {
                outside_Handle_Right = false;
            }
        
            //determines the state of the gear 
            if(targetCode.charAt(8) == 'P') {
                //is inputted gear is P(park), switch is enabled
                Gear = GearShift.P;
                gearShifter = true;
            } else {
                gearShifter = false;
            }
    }
        //method for checking status of left door
        public boolean isLeftOpen(){
            //checks to see that gear shift is in park and master unlock is activated
            if(gearShifter == true && master_Unlock == true){
                //checks to see status of dash switch and outside handle
                if(outside_Handle_Left == true || dash_Switch_Left == true){
                    return true;
                } 
                //checks to see if child lock is activated and status of inside handle
                if(child_Lock == false && inside_Handle_Left == true){
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        //method for checking status of right door
        public boolean isRightOpen(){
            //checks to see that gear shift is in park and master unlock is activated
            if(gearShifter == true && master_Unlock == true){
                //checks to see status of dash switch and outside handle
                if(outside_Handle_Right == true || dash_Switch_Right == true){
                    return true;
                } 
                //checks to see if child lock is activated and status of inside handle
                if(child_Lock == false && inside_Handle_Right == true){
                    return true;

                } else {
                    return false;
                }
            } else {
               return false;
            }
        }
        

}
//public minivan class created (the program the user interacts with)
public class Minivan{
    public static void main(String[]args){
        //flag for whether both doors will stay closed
        boolean bothDoorFlag = false;
        Scanner in = new Scanner(System.in);
        //prompts user for an appropriate code for the new door state
        System.out.print("Enter appropriate code for new door state: ");
        String newState = in.nextLine();
        //inputs the users value as the string the custom class will use
        DoorSystem doorSystem = new DoorSystem(newState);
        
        //implements the isLeftOpen method and runs if true
        if (doorSystem.isLeftOpen()){
            System.out.println("Left door opens");
            bothDoorFlag = true;
        }

        //implements the isRightOpen method and runs if true
        if(doorSystem.isRightOpen()){
            System.out.println("Right door opens");
            bothDoorFlag = true;
        }

        //if both the right and left methods are not true, then this statement runs to update user on status
        if(bothDoorFlag == false){
            System.out.println("Both doors stay closed closed");
        }

    }
}


