package com.example.demospringboot.repository;

import com.example.demospringboot.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface TacoOrderRepository extends CrudRepository<TacoOrder, Long>{
}
