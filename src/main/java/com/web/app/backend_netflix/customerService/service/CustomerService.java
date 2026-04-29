package com.web.app.backend_netflix.customerService.service;


import com.web.app.backend_netflix.customerService.request.CustomerRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    CustomerRequest save(@Valid CustomerRequest categoryRequest);
    CustomerRequest getCustomerID(Long customerId);
    CustomerRequest deleteCustomerId(Long customerId);
    CustomerRequest updateCategoryById(Long customerId);
}
