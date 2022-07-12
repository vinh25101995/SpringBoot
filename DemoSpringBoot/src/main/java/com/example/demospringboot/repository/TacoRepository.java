package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

}
