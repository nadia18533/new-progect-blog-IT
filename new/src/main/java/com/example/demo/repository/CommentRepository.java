package com.example.demo.repository;

import com.example.demo.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
    boolean existsById(Integer id);
}
