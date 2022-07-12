package com.example.apispring.impl;

import com.example.apispring.dto.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
