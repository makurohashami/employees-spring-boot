package com.example.demowithtests.dto.employee;

import com.example.demowithtests.domain.Gender;
import com.example.demowithtests.dto.address.AddressRequestDto;
import com.example.demowithtests.util.annotations.BlockedEmailDomains;
import com.example.demowithtests.util.annotations.CountryRightFormed;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

public class EmployeeUpdateDto {

    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @Schema(description = "Name of an employee.", example = "Billy", required = true)
    public String name;

    @Email
    @Schema(description = "Email address of an employee.", example = "billys@mail.com", required = true)
    @BlockedEmailDomains(contains = {".com1", ".ru", ".su"})
    public String email;

    @Schema(description = "Name of the country.", example = "England")
    @CountryRightFormed
    public String country;

    @Schema(description = "Gender of an employee.")
    public Gender gender;

    @Schema(description = "Addresses of an employee.")
    public Set<AddressRequestDto> addresses;

}
