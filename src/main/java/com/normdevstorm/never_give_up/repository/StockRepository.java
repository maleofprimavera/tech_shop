package com.normdevstorm.never_give_up.repository;

import com.normdevstorm.never_give_up.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

}
