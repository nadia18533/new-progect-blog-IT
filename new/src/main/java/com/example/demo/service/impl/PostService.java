package com.example.demo.service.impl;

/*import com.example.demo.entity.PostEntity;

import java.util.List;

public interface PostService {

    PostEntity save(PostEntity post);

    List<PostEntity> findAll();
    PostEntity findByPostId(Integer id);
    PostEntity findByPostTittle(String tittle);
}
*/

import com.example.demo.domain.PostDTO;

import java.util.List;

public interface PostService {

    void  savePost(PostDTO post);

    List<PostDTO> findAllPosts();

    PostDTO findPostById(int id);

    PostDTO updatePost(int id, PostDTO postToUpdate);
}
