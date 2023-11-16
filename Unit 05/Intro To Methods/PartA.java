public class PartA{
public static double mystery(double x, double y)
{double result = (x + y) / (y - x);
   return result;
}
public static void main(String[] args) {
   double example = mystery(3, 2);
   System.out.print(example);
}
}
