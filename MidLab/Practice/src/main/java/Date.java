public class Date {
    int date = 234;


    public Date(int date) {
        this.date = date;

    }
    public Date() {
    }


    @Override
    public String toString() {
        return "Date{" +
                "date=" + date +
                '}';
    }

    public int getDate() {
        return date;
    }
}
 class Runner{
     public static void main(String[] args) {
//         var date = new Date(28);
//         int val = 24;
//         System.out.println(val.toString());
//        var obj = new Object();
//var date = new Date(29).getDate();
//         System.out.println(date);
         var arry= new int[]{1,2,3,4,6};
         for (var i =0 ; i<arry.length;i++)
         {
             if(2<=arry[i] && arry[i]<=4){

             }
         }

     }
}
