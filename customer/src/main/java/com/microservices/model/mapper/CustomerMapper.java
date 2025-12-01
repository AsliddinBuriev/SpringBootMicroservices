package com.ajibprojects.model.mapper;

import com.ajibprojects.model.dto.request.CustomerRegisterRequest;
import com.ajibprojects.model.dto.response.GetCustomersResponse;
import com.ajibprojects.model.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {
    public Customer toCustomerEntity(CustomerRegisterRequest customerRegisterRequest) {
        return Customer.builder()
                .email(customerRegisterRequest.getEmail())
                .firstName(customerRegisterRequest.getFirstName())
                .lastName(customerRegisterRequest.getLastName())
                .build();
    }

    public List<GetCustomersResponse> toCustomerResponseList(List<Customer> customerList) {
        return customerList.stream()
                .map(customer -> GetCustomersResponse.builder()
                    .email(customer.getEmail())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .build()
                )
                .toList();
    }

    public GetCustomersResponse toGetCustomersResponse(Customer customerList) {
        return GetCustomersResponse.builder()
                .firstName(customerList.getFirstName())
                .lastName(customerList.getLastName())
                .email(customerList.getEmail())
                .build();
    }
}
