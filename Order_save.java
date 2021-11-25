package smart_kitchen;
import java.io.*;
public class Order_save {
    String date_and_time;
    int order_number;
    Order_save(String date_and_time,int order_number)
    {
        this.date_and_time=date_and_time;
        this.order_number=order_number;
    }
    void save()
    {
        String filename=order_number+"_"+date_and_time;
        try(ObjectOutputStream obj= new ObjectOutputStream(new FileOutputStream(filename))){
            Order order_obj=new Order();
            order_obj.interact();
            //order_obj.revenue_calculation();
            //`order_obj.final_bill_calculation();
            obj.writeObject(order_obj);

        }
        catch(IOException e)
        {
            System.out.println("Exception during serialization : "+e);
        }
    }
    
}
