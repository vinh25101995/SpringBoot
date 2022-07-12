package com.example.demospringboot.repository;

import com.example.demospringboot.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
                "select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> result = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,
                id
        );
        return result.size()==0?
                Optional.empty():
                Optional.of(result.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into taco (id,name,type) value(?,?,?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString()
        );
        return ingredient;
    }


    private Ingredient mapRowToIngredient(ResultSet resultSet, int i) throws SQLException {
        return  new Ingredient(resultSet.getString("id"),resultSet.getString("name"),Ingredient.Type.valueOf(resultSet.getString("type")));
    }
}
