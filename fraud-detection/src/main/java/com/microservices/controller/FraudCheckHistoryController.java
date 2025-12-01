package com.ajibprojects.controller;

import com.ajibprojects.module.dto.response.FraudCheckResponse;
import com.ajibprojects.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fraud-check")
@RequiredArgsConstructor
public class FraudCheckHistoryController {
    final FraudCheckHistoryService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId
    ){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
