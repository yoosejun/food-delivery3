package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;
    private String foodId;
    private String orderId;
    private String status;
}


