class Message {
     String msg = "Happy New Year!";
 
     public void print() {
         System.out.println(msg);
     }
}
 
public class Test {
     public static void change(Message m) {
        // m = new Message();
         m.msg = "Happy Holidays!";
     }
 
     public static void main(String[] args) {
         Message obj = new Message();
         obj.print();
         change(obj);
         //Message m = obj;
        // m = new Message();
        // obj.msg = "Happy Holidays!";
         obj.print();
     }
}