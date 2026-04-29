package com.web.app.backend_netflix.customerService.repository;

import com.web.app.backend_netflix.customerService.modual.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


    Customer findByEmail(String email);
//   @Query(value = "select * from Customer where mobileNumber =?",nativeQuery = true)
    Customer findByMobileNumber(String mobileNumber);
}
