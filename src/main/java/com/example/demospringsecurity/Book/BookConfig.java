package com.example.demospringsecurity.Book;

import com.cloudinary.Cloudinary;
import com.example.demospringsecurity.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
//    @Bean
//    public Cloudinary cloudinaryConfig() {
//        Cloudinary cloudinary = null;
//        Map config = new HashMap();
//        config.put("cloud_name", "dpxgtmzld");
//        config.put("api_key", "388178861795212");
//        config.put("api_secret", "F-pUcToMhk18nnVmqLN5W8HeViw");
//        cloudinary = new Cloudinary(config);
//        return cloudinary;
//    }

}
