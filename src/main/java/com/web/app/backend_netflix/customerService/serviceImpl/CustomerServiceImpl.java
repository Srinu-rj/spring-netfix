package com.web.app.backend_netflix.customerService.serviceImpl;

import com.web.app.backend_netflix.addressService.modual.Address;
import com.web.app.backend_netflix.addressService.request.AddressRequest;
import com.web.app.backend_netflix.customerService.modual.Customer;
import com.web.app.backend_netflix.customerService.request.CustomerRequest;

public class CustomerServiceImpl {





    private Customer mapToEntity(CustomerRequest dto) {

        Customer customer = new Customer();

        customer.setCustomerId(dto.getCustomerId());
        customer.setFullName(dto.getFullName());
        customer.setAge(dto.getAge());
        customer.setGender(dto.getGender());
        customer.setMobileNumber(dto.getMobileNumber());
        customer.setEmail(dto.getEmail());

        // ✅ Address mapping
        if (dto.getAddress() != null) {
            Address address = new Address();
            address.setArea(dto.getAddress().getArea());
            address.setCity(dto.getAddress().getCity());
            address.setState(dto.getAddress().getState());
            address.setCountry(dto.getAddress().getCountry());
            address.setPinCode(dto.getAddress().getPinCode());

            customer.setAddress(address);
        }

        return customer;
    }
    private CustomerRequest mapToDto(Customer customer) {

        AddressRequest addressDto = null;

        if (customer.getAddress() != null) {
            addressDto = new AddressRequest(
                    customer.getAddress().getArea(),
                    customer.getAddress().getCity(),
                    customer.getAddress().getState(),
                    customer.getAddress().getCountry(),
                    customer.getAddress().getPinCode()
            );
        }

        return CustomerRequest.builder()
                .customerId(customer.getCustomerId())
                .fullName(customer.getFullName())
                .age(customer.getAge())
                .gender(customer.getGender())
                .mobileNumber(customer.getMobileNumber())
                .email(customer.getEmail())
                .address(addressDto)
                .foodCartId(
                        Long.valueOf(customer.getFoodCart() != null
                                ? customer.getFoodCart().getCartId()
                                : null)
                )
                .build();
    }

}
