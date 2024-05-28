import java.util.ArrayList;
public class Part1{
    

    public static void main(String[] args) {
      ArrayList<String> names = new ArrayList<String>();
      int MAX_lengths = 0;
      int max = 0;
      double avg = 0;
      String temp1;
      String temp2;

      names.add("Steve");
      names.add("Tracy");
      names.add("James");
      names.add("Elise");
      names.add("Michelle");
      names.add("Jeremiah");

      System.out.println("List of names: ");
      for(int i = 0; i < names.size(); i++){
        temp1 = String.valueOf(names.get(i));
        max = max + temp1.length();
        if(i == 0||temp1.length() > MAX_lengths){
            MAX_lengths = temp1.length();
        }
      }

      for(int j = 0; j< names.size(); j++){
        temp2 = String.valueOf(names.get(j));
        if(temp2.length() == MAX_lengths){
        System.out.print(names.get(j));
        System.out.printf(" (%d) <= MAX LENGTH %n",temp2.length());
        } else {
        System.out.print(names.get(j));
        System.out.printf(" (%d)%n",temp2.length());
        }
      }
      avg = max/names.size();
      System.out.println("-----");
      System.out.printf("The average name length is %.1f characters",avg);
        
    }
}
