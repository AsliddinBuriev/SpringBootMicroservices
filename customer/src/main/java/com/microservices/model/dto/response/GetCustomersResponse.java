package com.ajibprojects.model.dto.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetCustomersResponse {
    String firstName;
    String lastName;
    String email;
}
