package com.example.demo.controller;

import com.example.demo.domain.CommentDTO;
import com.example.demo.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<?> createComment(
            @RequestBody CommentDTO commentDTO
    ){


        System.out.println(
                commentDTO.getComment()
        );

        commentService.saveComment(commentDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<?>getComments(){
        List<CommentDTO> comments=commentService.findAllComments();
        return  new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @GetMapping("{commentId:[0-9]{1,5}}")
    public ResponseEntity<?>getCommentById(@PathVariable("commentId")int id) {
        CommentDTO comment = commentService.findCommentById(id);
        if(comment==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return  new ResponseEntity<>(comment,HttpStatus.OK);
    }

    @PutMapping("{commentId:[0-9]{1,5}}")
    public ResponseEntity<?>updateComment(
            @PathVariable("commentId")int id,@RequestBody CommentDTO commentToUpdate
    ){
        CommentDTO comment=commentService.updateComment(id,commentToUpdate);

        if(comment==null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return  new ResponseEntity<>(comment,HttpStatus.OK);
    }

}
