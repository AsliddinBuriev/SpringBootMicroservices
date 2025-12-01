package com.ajibprojects.contoller;


import com.ajibprojects.model.dto.request.CustomerRegisterRequest;
import com.ajibprojects.model.dto.response.GetCustomersResponse;
import com.ajibprojects.model.entity.Customer;
import com.ajibprojects.model.mapper.CustomerMapper;
import com.ajibprojects.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    final private CustomerService customerService;
    final private CustomerMapper customerMapper;

    @PostMapping("")
    public ResponseEntity<Void> registerCustomer(
            @Valid @RequestBody CustomerRegisterRequest  customerRegisterRequest
    ) {
        Customer customer = customerMapper.toCustomerEntity(customerRegisterRequest);
        customerService.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("")
    public ResponseEntity<List<GetCustomersResponse>> getCustomersList(){
        List<Customer> customersList = customerService.getAllCustomers();
        List<GetCustomersResponse> response = customerMapper.toCustomerResponseList(customersList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomersResponse> getCustomer(
            @PathVariable("id") Integer id)
    {
        Customer customer = customerService.getCustomerById(id);

        if(customer == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(customerMapper.toGetCustomersResponse(customer));
    }
}
