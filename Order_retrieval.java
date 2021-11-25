package smart_kitchen;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Order_retrieval {
    void retrieve()
    {
        try(ObjectInputStream ob=new ObjectInputStream(new FileInputStream("filename")))
        {
            Order retreived_order=(Order)ob.readObject();
            System.out.println(retreived_order);
        }
        catch(Exception e)
        {
            System.out.println("Exception during deserialization: "+e);
        }
    }
}
