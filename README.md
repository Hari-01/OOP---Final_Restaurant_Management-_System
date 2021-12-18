# Restaurant Management System
Classes and their descriptions  
<h6>Menu</h6>- This class contains three maps which map the item names, prices and the preparation times of each item to a code respectively. It also contains the getter and setter functions for each. The simpleTable() method is used to display the menu. The addItem method is used to add items by the admin when called.The PriceList class had to be used for knowing the prices as per the initial guidelines of the project and it had to be extended by the Menu class. However, the prices have been added to the Menu class itself so there was no need for the PriceList class. Pls note this.  
<h6>CookState</h6>- This class is used to allot the dishes for preparation to the cooks. This class also handles whether a given order is used in taken state or preparing state or served state. There are 5 cooks and the dishes are allocated in such a manner that the dish which takes most time is given to the cook who has the minimum remaining time to complete the dish previously allocated to him. For each order min_prep_time and final_prep_time are calculated. min_prep_time is the time from ordering for the first dish in the order to start being cooked. Final_prep_time is the time from ordering for the last dish in the order to get ready. These 2 variables are calculated to find out in which state the order is present. Like if the time difference between the user checking the state of order and the user ordering is less than than mmin_prep_time it will be in taken state if it is between min_prep_time and final_prep_time it is in in preparing state and if it is greater than final_prep_time then it is in served state.  
<h6>SeatAllottment</h6>- This class is used to allocate the seats to the incoming customers. It has static variables to handle the number of tables of six,four and two. There are some extra chairs too. The algorithm which is used to decide how the tables will be allocated to the customers goes as follows. The object gets initialised with the number of customers placing that particular order. Suppose the number of customers were 9. The efficient allocation of seats will be 1 table of six, 1 table of two and 1 extra chair. (% is the mod operation).So the number of tables of six allocated =9%6, number of tables of four allocated =((9-9%6)=3)%4 which is equal to 0 ,number of tables of two allocated= 3%2 which is equal to 1, number of extra chairs allocated=1 since the customer size is odd.The tables_left() function does this and returns true if the allocation can be done and false if it can’t be done. The updateTables method updates the number of tables left in the restaurant.   
<h6>Bill</h6>- This is a class just to encapsulate the details of the item being ordered.   
<h6>Order</h6>- This class takes care of placing the orders. It is composed of Bill class, since it uses an arraylist of Bill objects to add items to a particular order with a particular order ID. The interact() method is used to interact with the customer placing the order. The user is asked to enter a code (displayed in the menu) corresponding to the item he/she wants to order. The order_print method prints the order along with the final bill amount and minimum preparation time after which you can expect the order to be served. The revenue_calculation() method calculates the revenue from that order and adds it to the revenue variable of Revenue class. The CGST and SGST rates taken are 2.5%each.    
<h6>Revenue</h6>- This class is used to know about the revenue if the admin wishes to. The initial revenue (before any order) is hard coded to 7000 and the expenses are hard coded to 3000. The static variable revenue holds the revenue value. The getProfit() method returns the profit.  
<h6>RestaurantState</h6>- This class implements multithreading. This class is used to calculate the state in which the restaurant is in. This thread is implemented first before the main thread (join method is used in main), so if this is not implemented fully the part of main thread inside the synchronised block cannot be executed. It is considered that the restaurant opens after 12pm and closes at 12 am. So if the current time is not in the given range, the thread displays that the restaurant is closed, the thread goes to sleep mode (up till 12pm) not allowing the main thread to take orders.  If the restaurant is not closed, it asks for the number of members to be inputted which is used to initialize the SeatAllottment object. If the tables_left() of the SeatAllotment object returns false, it goes into full state, bringing the thread into sleep mode till the time one of the customer group is finished eating (for this the minimum time among all the customers is used). If the restaurant state is neither full nor closed, it is in an open state allowing the main thread to take orders.  
<h6>Admin</h6>- This class allows the admin to add items to the current menu and also change the price of an item in the menu.  
<h6>DisplayServed</h6>- This class also implements multithreading. This class is used to notify the customer that his/her order is served. It’s object is initialised with the time after which it should notify that the order is served i.e the time after which the order is ready , i.e  the minimum preparation time as mentioned in the bill printed. For that particular time, the thread goes to sleep mode. As soon as the thread wakes, it displays.  
<h6>SeatUnoccupied</h6>- This class also implements multithreading. This class is used to judge when the seats which were occupied are made unoccupied. An assumption is made that the time taken by the customers to eat their ordered items is 15 min. As soon as the order is served (notified by the thread of DisplayServed class), this thread starts. For fifteen minutes it goes to sleep mode after which it adds those occupied seats to the pool of unoccupied seats using the sixTablesUsed, fourTablesUsed,twoTablesUsed and extraChairsUsed variables of the SeatAllottment object.  
<h6>Main</h6>- This is the main class of the project. It maintains the list of orders as per their IDs and the list of the cook states. It displays two types of menu. One for the customer and one for the admin. In order to access the menu for admin, a password has to be provided. The password for accessing the menu is Hello@123. The admin menu allows you to choose between the options of changing the price of an item, knowing the revenue and adding the item (one at a time)to the menu. Accordingly, the instructions are provided. For the menu of the customer, there are options for either placing the new order or taking an update on the previous placed order. Accordingly the instructions are displayed. It should be noted that an assumption has been made that whenever the program starts, the order placed first is the first order and there are no previous orders. For placing a new order, follow the displayed instructions. When the number of members is entered, the thread in the RestaurantState first checks if the seats are available. If the seats are available, it allows for the placement of order, otherwise the main thread can take order when the seats get vacant.As soon as the order is placed, the cooks are allotted the time accordingly, the bill is displayed and the customer is notified as soon as the order is served due to the threads working in the background.   