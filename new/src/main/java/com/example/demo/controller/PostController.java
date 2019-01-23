package com.example.demo.controller;

/*import com.example.demo.entity.PostEntity;
import com.example.demo.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostEntity post) {
        PostEntity postEntity = postService.save(post);

        if(postEntity ==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(postEntity,HttpStatus.OK);
    }
}
*/


import com.example.demo.domain.PostDTO;
import com.example.demo.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController  {

    @Autowired
    private PostService postService;


    @PostMapping
    public ResponseEntity<?> createPost(
            @RequestBody PostDTO postDTO
    ){

        System.out.println(
                postDTO.getTittle()+ " "+
                        postDTO.getDescription()+" "+
                        postDTO.getDateOfCreate()
        );
        postService.savePost(postDTO);

        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<?>getPosts(){
        List<PostDTO> posts=postService.findAllPosts();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("{postId:[0-9]{1,5}}")
    public  ResponseEntity<?>getPostById(@PathVariable("postId")int id){
        PostDTO post=postService.findPostById(id);
        if (post==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return  new ResponseEntity<>(post,HttpStatus.OK);

    }
    @PutMapping("{postId:[0-9]{1,5}}")
    public  ResponseEntity<?>updatePost(
            @PathVariable("postId")int id,@RequestBody PostDTO postToUpdate
    ){
        PostDTO post=postService.updatePost(id, postToUpdate);

        if (post==null){
            return  new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(post,HttpStatus.OK);
    }

}
