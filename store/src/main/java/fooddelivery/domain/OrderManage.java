package fooddelivery.domain;

import fooddelivery.domain.DeliveryStarted;
import fooddelivery.domain.Cooked;
import fooddelivery.domain.Accepted;
import fooddelivery.domain.Rejected;
import fooddelivery.domain.CookStarted;
import fooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="OrderManage_table")
@Data

public class OrderManage  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String test;
    
    
    
    
    
    private Long couponNumber;

    @PostPersist
    public void onPostPersist(){


        DeliveryStarted DeliveryStarted = new DeliveryStarted();
        DeliveryStarted.publishAfterCommit();



        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();



        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static OrderManageRepository repository(){
        OrderManageRepository orderManageRepository = StoreApplication.applicationContext.getBean(OrderManageRepository.class);
        return orderManageRepository;
    }



    public void accept(){
    }
    public void reject(){
    }
    public void startCook(){
    }
    public void finishCook(){
    }

    public static void addToOrderList(Paid paid){

        /** Example 1:  new item 
        OrderManage orderManage = new OrderManage();
        repository().save(orderManage);

        */

        repository().findById(paid.getId()).ifPresent(orderManage->{
            
            //orderManage // do something
            repository().save(orderManage);


         });
        
    }
    public static void alertOrderCancel(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        OrderManage orderManage = new OrderManage();
        repository().save(orderManage);

        */

        repository().findById(orderCanceled.getId()).ifPresent(orderManage->{
            
            //orderManage // do something
            repository().save(orderManage);


         });

        
    }


}
