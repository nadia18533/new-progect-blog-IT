package com.example.demo.repository;

import com.example.demo.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface TagRepository extends JpaRepository<TagEntity,Integer> {
    boolean existsById(Integer id);
}
