package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Accepted extends AbstractEvent {

    private Long id;
    private String foodId;
    private String ordered;
    private String status;
}
