package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Wrapped extends AbstractEvent {

    private Long id;
    private String orderId;
    private String status;

    public Wrapped(Delivery aggregate){
        super(aggregate);
    }
    public Wrapped(){
        super();
    }
}
