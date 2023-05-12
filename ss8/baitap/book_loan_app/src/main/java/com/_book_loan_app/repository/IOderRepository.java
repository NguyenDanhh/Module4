package com._book_loan_app.repository;

import com._book_loan_app.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderRepository extends JpaRepository<Oder , Integer> {
}
