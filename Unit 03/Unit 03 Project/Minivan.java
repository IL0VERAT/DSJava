import java.util.Scanner; 
class DoorSystem {

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
        boolean flag;
        boolean isLeftOpen;
        boolean isRightOpen;

        //constructor
        public DoorSystem(String initState){
            this.update(initState);
        }

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
                master_Unlock = true;
            } else {
                master_Unlock = false;
            }

            //determines the state of the inside handle on the left
            if(child_Lock = false){
                if(targetCode.charAt(4) == '1'){
                    inside_Handle_Left = true;
                 } else {
                    inside_Handle_Left = false;
                    
                }
            } else {
                inside_Handle_Left = false;
            }

            //determines the state of the inside handle on the right
            if(child_Lock = false){
                if(targetCode.charAt(5) == '1'){
                    inside_Handle_Right = true;
                } else {
                    inside_Handle_Right = false;
                }
            } else {
                inside_Handle_Right = false;
            }

            //determines the state of the outside handle on the left
            if(targetCode.charAt(6) == '1'){
                outside_Handle_Left = true;
            } else {
                outside_Handle_Left = false;
            }

            //determines the state of the outside handle on the right
            if(targetCode.charAt(7) == '1'){
                outside_Handle_Right = true;
            } else {
                outside_Handle_Right = false;
            }
        
        
            if(targetCode.charAt(8) == 'P') {
                Gear = GearShift.P;
                gearShifter = true;
            } else {
                gearShifter = false;
            }
    }

        public void leftDoorCode(){
            if(gearShifter == true && master_Unlock == false){
                if(outside_Handle_Left == true || inside_Handle_Left == true || dash_Switch_Left == true){
                    isLeftOpen = true;
                } else {
                    isLeftOpen = false;
                }
            } else {
                isLeftOpen = false;
            }
        }
        public void rightDoorCode(){
            if(gearShifter == true && master_Unlock == false){
                if(outside_Handle_Right == true || inside_Handle_Right == true || dash_Switch_Right == true){
                    isRightOpen = true;
                } else {
                    isRightOpen = false;
                }
            } else {
                isRightOpen = false;
            }
        }
        public void Doors(){
                if(isLeftOpen == false && isRightOpen == false) {
                    System.out.println("Both doors closed");
                } else if(isLeftOpen == true ){
                        System.out.println("Left door opens");
                    } else if (isLeftOpen == false) {
                        System.out.println("Left door closed");
                } else if(isRightOpen == true){
                        System.out.println("Right door opens");
                    } else if (isRightOpen == false){
                        System.out.println("Right door closed");
                    } 
    } 
}
public class Minivan{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter appropriate code for new door state: ");
        String newState = in.nextLine();
        DoorSystem doorSystem = new DoorSystem(newState);
        doorSystem.Doors();
    }
}

