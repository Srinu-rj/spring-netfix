package com.web.app.backend_netflix.addressService.service;

import com.web.app.backend_netflix.addressService.modual.Address;
import com.web.app.backend_netflix.addressService.request.AddressRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {


    AddressRequest createAddress(@Valid AddressRequest request);
    List<AddressRequest> getAllAddresses();
    AddressRequest getAddressById(long id);
    AddressRequest updateAddress(long id, @Valid AddressRequest request);
    void deleteAddress(long id);
}
