public class BaseballCard {
    String name; // the name of the player on the card.
    int year; // the year the card was issued.

    public BaseballCard(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    //overide toString() method
    public String toString(){
        String val = this.getClass().getName() 
        + "[name = " + this.name 
        + ", year = " + this.year + "]";
        return val;

    }

    //overide equals() method
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()){
            return false;
        } else {
            //cast the other object into Employee31 type
            BaseballCard bc = (BaseballCard)obj;
            if(name.equals(bc.getName()) && Double.compare(year, bc.getYear()) == 0){
                return true;
            } else {
                return false;
            }
        }
    }
}
    

