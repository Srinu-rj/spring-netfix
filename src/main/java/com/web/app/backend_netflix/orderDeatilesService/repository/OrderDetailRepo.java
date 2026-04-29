package com.web.app.backend_netflix.orderDeatilesService.repository;

import com.web.app.backend_netflix.orderDeatilesService.modual.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetails,Long> {
}
