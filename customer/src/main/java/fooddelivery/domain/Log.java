package fooddelivery.domain;

import fooddelivery.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Log_table")
@Data

public class Log  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String message;


    public static LogRepository repository(){
        LogRepository logRepository = CustomerApplication.applicationContext.getBean(LogRepository.class);
        return logRepository;
    }




    public static void alertViaKakao(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        repository().findById(deliveryStarted.getId()).ifPresent(log->{
            
//            log // do something
            repository().save(log);


         });

        
    }
    public static void alertViaKakao(Delivered delivered){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        repository().findById(delivered.getId()).ifPresent(log->{
            
//            log // do something
            repository().save(log);


         });
        
    }
    public static void alertViaKakao(Rejected rejected){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */
      
        repository().findById(rejected.getId()).ifPresent(log->{
            
//            log // do something
            repository().save(log);


         });

        
    }
    public static void alertViaKakao(Accepted accepted){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */
        
        repository().findById(accepted.getId()).ifPresent(log->{
            
//            log // do something
            repository().save(log);


         });
  
        
    }
    public static void alertViaKakao(Cooked cooked){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        repository().findById(cooked.getId()).ifPresent(log->{
            
//            log // do something
            repository().save(log);


         });
        
    }
    public static void alertViaKakao(Paid paid){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */
  
        repository().findById(paid.getId()).ifPresent(log->{
            
//            log // do something
            repository().save(log);


         });
  
        
    }
    public static void alertViaKakao(Wrapped wrapped){

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        */

        repository().findById(wrapped.getId()).ifPresent(log->{
            
//            log // do something
            repository().save(log);


         });

        
    }


}
