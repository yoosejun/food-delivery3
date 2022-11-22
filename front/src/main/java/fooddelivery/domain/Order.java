package fooddelivery.domain;

import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.OrderCanceled;
import fooddelivery.domain.OrderCanceled;
import fooddelivery.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private Integer amount;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String options;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        OrderPlaced OrderPlaced = new OrderPlaced(this);
        OrderPlaced.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fooddelivery.external.Payment payment = new fooddelivery.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext.getBean(fooddelivery.external.PaymentService.class)
            .pay(payment);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){


        OrderCanceled OrderCanceled = new OrderCanceled(this);
        OrderCanceled.publishAfterCommit();

    }
    @PreRemove
    public void onPreRemove(){
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void updateStatus(Accepted accepted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */
        
        repository().findById(accepted.getId()).ifPresent(order->{
            
//            order // do something
            repository().save(order);


         });
  
        
    }
    public static void updateStatus(Rejected rejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        repository().findById(rejected.getId()).ifPresent(order->{
            
//            order // do something
            repository().save(order);


         });
  
        
    }
    public static void updateStatus(Cooked cooked){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        repository().findById(cooked.getId()).ifPresent(order->{
            
//            order // do something
            repository().save(order);


         });
  
        
    }
    public static void updateStatus(CookStarted cookStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        
        repository().findById(cookStarted.getId()).ifPresent(order->{
            
//            order // do something
            repository().save(order);


         });
  
        
    }
    public static void orderCancel(Rejected rejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */
    
        repository().findById(rejected.getId()).ifPresent(order->{
            
//            order // do something
            repository().save(order);


         });
  
        
    }


}
