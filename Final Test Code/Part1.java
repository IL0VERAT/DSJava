import java.util.ArrayList;
public class Part1{
    

    public static void main(String[] args) {
      ArrayList<String> names = new ArrayList<String>();
      int MAX_lengths = 0;
      int max = 0;
      double avg = 0;

      names.add("Steve");
      names.add("Tracy");
      names.add("James");
      names.add("Elise");
      names.add("Michelle");
      names.add("Jeremiah");

      System.out.println("List of names: ");
      for(int i = 0; i < names.size(); i++){
        String temp = String.valueOf(names.get(i));
        max = max + temp.length();
        if(i == 0||temp.length() > MAX_lengths){
            MAX_lengths = temp.length();
        }
        System.out.print(names.get(i));
        System.out.printf("(%d)%n",temp.length());
      }
      avg = max/names.size();
      System.out.println("-----");
      System.out.printf("The average name length is %.1f characters",avg);
        
    }
}
