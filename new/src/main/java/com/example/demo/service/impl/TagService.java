package com.example.demo.service.impl;

import com.example.demo.domain.TagDTO;

import java.util.List;

public interface TagService {
    void  saveTag(TagDTO tag);

    List<TagDTO> findAllTags();

    TagDTO findTagById(int id);

    TagDTO updateTag(int id, TagDTO tagToUpdate);
}

