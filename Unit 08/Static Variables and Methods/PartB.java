/*class Item {
    private int value;
    public void setValue(int value) {
        value = value;
    }
    public int getValue() {
        return value;
    }
 }
 
 public class PartB {
    public static void main(String[] args) {
        Item myItem = new Item();
        System.out.print(myItem.getValue() + " | ");
        myItem.setValue(13);
        System.out.println(myItem.getValue());
    }
 } */

 //The output of this program would be 0|0 because method or constructor parameters are given priority to class attributes
 //The program can be fixed by adding this. before the first usage of value in the setValue method, like so: this.value
