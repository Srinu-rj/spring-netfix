package com.web.app.backend_netflix.customerService.request;

import com.web.app.backend_netflix.addressService.request.AddressRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    private Long customerId;

    private String fullName;
    private int age;
    private String gender;
    @NotBlank(message = "Mobile number is required")
    private String mobileNumber;
    @Email(message = "Invalid email format")
    private String email;
    // ✅ Nested DTO (not entity)
    private AddressRequest address;
    private Long foodCartId;
}
