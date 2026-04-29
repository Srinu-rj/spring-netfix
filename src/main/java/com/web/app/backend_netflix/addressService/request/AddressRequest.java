package com.web.app.backend_netflix.addressService.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotBlank(message = "Area should not be empty")
    private String area;
    @NotBlank(message = "City should not be empty")
    private String city;
    @NotBlank(message = "State should not be empty")
    private String state;
    @NotBlank(message = "Country should not be empty")
    private String country;
    @NotBlank(message = "PinCode should not be empty")
    private String pinCode;
}
