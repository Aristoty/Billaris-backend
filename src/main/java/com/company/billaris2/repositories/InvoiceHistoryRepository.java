package com.company.billaris2.repositories;

import com.company.billaris2.entities.InvoiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceHistoryRepository extends JpaRepository<InvoiceHistory, Long> {
}