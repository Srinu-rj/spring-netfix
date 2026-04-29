package com.web.app.backend_netflix.addressService.serviceImpl;

import com.web.app.backend_netflix.addressService.modual.Address;
import com.web.app.backend_netflix.addressService.repository.AddressRepo;
import com.web.app.backend_netflix.addressService.request.AddressRequest;
import com.web.app.backend_netflix.addressService.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;


    @Override
    public AddressRequest createAddress(AddressRequest request) {

        Address saveAddress = mapToEntity(request);
        Address saved = addressRepo.save(saveAddress);

        return mapToDto(saved);
    }

    @Override
    public List<AddressRequest> getAllAddresses() {

        return addressRepo.findAll()
                .stream()
                .map(this::mapToDto).toList();
    }

    @Override
    public AddressRequest getAddressById(long id) {
        Address address=addressRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Address Not Found"));
        return mapToDto(address);
    }

    @Override
    public AddressRequest updateAddress(long id, AddressRequest request) {
        Address existing = addressRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

        existing.setArea(request.getArea());
        existing.setCity(request.getCity());
        existing.setState(request.getState());

        Address updated = addressRepo.save(existing);

        return mapToDto(updated);
    }

    @Override
    public void deleteAddress(long id) {

        Address address = addressRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        addressRepo.delete(address);
    }


    private Address mapToEntity(AddressRequest request) {
        Address address = new Address();
        address.setArea(request.getArea());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setPinCode(request.getPinCode());
        return address;
    }

    private AddressRequest mapToDto(Address address) {
        return new AddressRequest(
                address.getArea(),
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getPinCode()
        );
    }
}
