package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String tittle;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_of_create", nullable = false, columnDefinition = "DATE")
    private String dateOfCreate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  UserEntity user;

    @ManyToMany
    @JoinTable(name = "comment_post",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<CommentEntity> comments;

    @ManyToMany
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private  List<TagEntity>tags;


}
