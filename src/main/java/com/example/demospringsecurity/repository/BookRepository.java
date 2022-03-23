package com.example.demospringsecurity.repository;

import com.example.demospringsecurity.Book.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
    @Query("select b from Books b where b.Title = ?1")
    Optional<Books> findBooksByTitle(String title);
}
