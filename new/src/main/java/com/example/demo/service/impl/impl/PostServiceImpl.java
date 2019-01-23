package com.example.demo.service.impl.impl;


import com.example.demo.domain.CommentDTO;
import com.example.demo.domain.PostDTO;
import com.example.demo.domain.TagDTO;
import com.example.demo.domain.UserDTO;
import com.example.demo.entity.CommentEntity;
import com.example.demo.entity.PostEntity;
import com.example.demo.entity.TagEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public PostEntity save(PostEntity post) {
        boolean exists = postRepository.existsByNameIgnoreCase(post.getTittle());
        if(exists){
            return null;
        }
        postRepository.save(post);
return post;
    }

    @Override
    public List<PostEntity> findAll() {
        return null;
    }

    @Override
    public PostEntity findByPostId(Integer id) {
        return null;
    }

    @Override
    public PostEntity findByPostTittle(String tittle) {
        return null;
    }
}*/



@Service
public class PostServiceImpl  implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void savePost(PostDTO post) {

        postRepository.save(dtoToEntityMapper(post));
    }

    @Override
    public List<PostDTO> findAllPosts() {
        List<PostEntity>posts=postRepository.findAll();
        List<PostDTO>postDTOS=new ArrayList<>();

        for (PostEntity entity:posts){
            PostDTO postDTO=entityToDTOMapper(entity);
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    @Override
    public PostDTO findPostById(int id) {
        boolean exists=postRepository.existsById(id);
        if(!exists){
            return  null;
        }
        PostEntity posts=postRepository.findById(id).get();
        return entityToDTOMapper(posts);
    }

    @Override
    public PostDTO updatePost(int id, PostDTO postToUpdate) {
        boolean exists=postRepository.existsById(id);
        if(!exists){
            return  null;
        }

        PostEntity postFromDB=postRepository.findById(id).get();
        postFromDB=dtoToEntityMapper(postToUpdate);
        postRepository.save(postFromDB);
        postToUpdate.setId(postFromDB.getId());
        return   postToUpdate;

    }
    private PostDTO entityToDTOMapper(PostEntity postEntity){
        PostDTO postDTO =new PostDTO();
        postDTO.setId(postEntity.getId());
        postDTO.setDescription(postEntity.getDescription());
        postDTO.setDateOfCreate(postEntity.getDateOfCreate());
        postDTO.setTittle(postEntity.getTittle());

        UserEntity user=postEntity.getUser();
        UserEntity userDTO= new UserEntity();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setNickname(user.getNickname());
        userDTO.setDateOfCreate(user.getDateOfCreate());


        List<CommentEntity>commentEntities=postEntity.getComments();
        List<CommentEntity> commentDTOS=new ArrayList<>();

        for(CommentEntity commentEntity:commentEntities){
            CommentDTO commentDTO=new CommentDTO();
            commentDTO.setId(commentEntity.getId());
            commentDTO.setComment(commentEntity.getComment());
            commentDTOS.add(commentDTO);
        }

        List<TagEntity>tagEntities=postEntity.getTags();
        List<TagEntity> tagDTOS=new ArrayList<>();

        for(TagEntity tagEntity:tagEntities){
            TagDTO tagDTO= new TagDTO();
            tagDTO.setId(tagEntity.getId());
            tagDTO.setNameOfTag(tagEntity.getNameOfTag());
            tagDTOS.add(tagDTO);
        }


        postDTO.setUser(userDTO);
        postDTO.setComments(commentDTOS);
        postDTO.setTags(tagDTOS);

        return  postDTO;
    }

    private PostEntity dtoToEntityMapper(PostDTO postDTO){
        PostEntity postEntity=new PostEntity();
        postEntity.setId(postDTO.getId());
        postEntity.setTittle(postDTO.getTittle());
        postEntity.setDescription(postDTO.getDescription());
        postEntity.setDateOfCreate(postDTO.getDateOfCreate());

        UserEntity userDTO= postDTO.getUser();
        UserEntity userEntity=new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setSecondName(userDTO.getSecondName());
        userEntity.setNickname(userDTO.getNickname());
        userEntity.setDateOfCreate(userDTO.getDateOfCreate());


        List<CommentEntity> commentDTOS=postDTO.getComments();
        List<CommentEntity>commentEntities=new ArrayList<>();

        for(CommentEntity commentDTO:commentDTOS) {
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setId(commentDTO.getId());
            commentEntity.setComment(commentDTO.getComment());
            commentEntities.add(commentEntity);
        }

        List<TagEntity> tagDTOS=postDTO.getTags();
        List<TagEntity>tagEntities=new ArrayList<>();

        for (TagEntity tagDTO:tagDTOS){
            TagEntity tagEntity= new TagEntity();
            tagEntity.setId(tagDTO.getId());
            tagEntity.setNameOfTag(tagDTO.getNameOfTag());
            tagEntities.add(tagEntity);
        }


        postEntity.setUser(userEntity);
        postEntity.setComments(commentEntities);
        postEntity.setTags(tagEntities);

        return   postEntity;

    }



}

