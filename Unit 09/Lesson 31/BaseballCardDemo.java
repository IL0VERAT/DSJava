public class BaseballCardDemo {
    public static void main(String[] args) {

        //creates BaseBallCard objects
        BaseballCard ruth = new BaseballCard("Babe Ruth", 1914);
        BaseballCard mays = new BaseballCard("Willie Mays", 1972);

        //prints out information
        System.out.println(ruth);
        System.out.println(mays);

        //compares the two cards
        if(ruth.equals(mays)){
            System.out.println("We have duplicates!");
        } else {
            System.out.println("No duplicates!");
        }
    }
}
