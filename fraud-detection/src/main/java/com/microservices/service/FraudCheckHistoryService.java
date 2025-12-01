package com.ajibprojects.service;

import com.ajibprojects.module.entity.FraudCheckHistory;
import com.ajibprojects.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckHistoryService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepo;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepo.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

}
