package com.web.app.backend_netflix.billService.repository;

import com.web.app.backend_netflix.billService.modual.Bill;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {

    @Query(value = "SELECT * FROM bill WHERE bill_id =?1", nativeQuery = true)
    Optional<Bill> findByIdQuery(int billId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM bill WHERE bill_id = ?1", nativeQuery = true)
    Bill deleteByIdQuery(int billId);

    boolean existsByOrder_OrderId(Integer orderId);

    Arrays findByOrder_OrderId(Integer orderId);

}


