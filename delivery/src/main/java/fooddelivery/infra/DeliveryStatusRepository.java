package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="deliveryStatuses", path="deliveryStatuses")
public interface DeliveryStatusRepository extends PagingAndSortingRepository<DeliveryStatus, Long> {

    List<DeliveryStatus> findByOrderId(String orderId);


    
}
