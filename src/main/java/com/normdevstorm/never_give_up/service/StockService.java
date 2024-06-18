package com.normdevstorm.never_give_up.service;

import com.normdevstorm.never_give_up.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;
}
