package com._book_loan_app.repository;

import com._book_loan_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book , Integer> {
}
