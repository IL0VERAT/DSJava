//Coder: Milo Linn-Boggs Date: 2 Oct. 2023
import javax.swing.JOptionPane; //Imports JOptionPane
public class DialogBoxes {
public static void main(String[]args) throws Exception{
String Name = JOptionPane.showInputDialog("Enter your name:"); //Prompts user for their name
String number_one = JOptionPane.showInputDialog("Enter a number:"); //Prompts user for a number
int num1 = Integer.parseInt(number_one);
String number_two = JOptionPane.showInputDialog("Enter another number:"); //Prompts user for a number
int num2 = Integer.parseInt(number_two);
JOptionPane.showMessageDialog(null, "Your name is " + Name); //Shows a the user their name
int addition = num1 + num2; //Adds the given numbers together
JOptionPane.showMessageDialog(null, "Your numbers added together equal " + addition); //Shows user their numbers added together
    }
}