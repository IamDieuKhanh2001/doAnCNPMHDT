package com.example.demospringsecurity.Book;

import com.example.demospringsecurity.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            Books p1 = new Books(
                    "Test title 1",
                    160,
                    LocalDate.now(),
                    "Des1 aa",
                    120,
                    5,
                    1,
                    2,
                    1,
                    19,
                    "1.jpg"
            );

//            repository.saveAll(
//                    List.of(p1)
//            );
        };
    }

}
