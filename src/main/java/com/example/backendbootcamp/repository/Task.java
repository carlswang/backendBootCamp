package com.example.backendbootcamp.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    private int id;
    private String name;
    private String describe;
}
