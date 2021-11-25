package smart_kitchen;

public class Demo {
    Order order;
    Demo(Order order)
    {
        this.order=order;
        
    }
    void display()
{
    System.out.println(order.order.get(0).prep_time);
}


}
