public class DemoMinMax{
    public static void main(String[]args){
        //know how to do this with min AND max
        int []vals = {7,8,9,3,2,5,6};
        int min = 0;
        for(int i = 0; i<vals.length;i++){
            if(i==0){
                min = vals[i];
            }else{
                if(vals[i]<min){
                    min = vals[i];
                }
            }
        }
    }
}