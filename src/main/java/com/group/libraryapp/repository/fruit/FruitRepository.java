package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface FruitRepository extends JpaRepository<Fruits,Long> {
    Optional<Fruits> findById(Long id);
    long countByNameAndSaled(String name,int i);

}

