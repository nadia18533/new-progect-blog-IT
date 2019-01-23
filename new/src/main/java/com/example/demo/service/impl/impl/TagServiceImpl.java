package com.example.demo.service.impl.impl;


import com.example.demo.domain.TagDTO;
import com.example.demo.entity.TagEntity;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl  implements TagService {

    @Autowired
    private TagRepository tagRepository;


    @Override
    public void saveTag(TagDTO tag) {

        tagRepository.save(dtoToEntityMapper(tag));
    }

    @Override
    public List<TagDTO> findAllTags() {
        List<TagEntity>tags=tagRepository.findAll();
        List<TagDTO>tagDTOS=new ArrayList<>();

        for (TagEntity entity:tags){

            TagDTO tagDTO= entityToDTOMapper(entity);
            tagDTOS.add(tagDTO);
        }
        return tagDTOS;
    }

    @Override
    public TagDTO findTagById(int id) {
        boolean exists=tagRepository.existsById(id);
        if (!exists){

            return  null;
        }
        TagEntity tags=tagRepository.findById(id).get();

        return entityToDTOMapper(tags);
    }

    @Override
    public TagDTO updateTag(int id, TagDTO tagToUpdate) {
        boolean exists=tagRepository.existsById(id);
        if (!exists){

            return  null;
        }

        TagEntity tagFromDB= tagRepository.findById(id).get();
        tagFromDB=dtoToEntityMapper(tagToUpdate);
        tagRepository.save(tagFromDB);
        tagToUpdate.setId(tagFromDB.getId());
        return tagToUpdate;
    }
    private  TagDTO entityToDTOMapper(TagEntity tagEntity){

        TagDTO tagDTO=new TagDTO();
        tagDTO.setId(tagEntity.getId());
        tagDTO.setNameOfTag(tagEntity.getNameOfTag());

        return  tagDTO;
    }
    private TagEntity dtoToEntityMapper(TagDTO tagDTO){
        TagEntity tagEntity=new TagEntity();
        tagEntity.setId(tagDTO.getId());
        tagEntity.setNameOfTag(tagDTO.getNameOfTag());
        tagEntity.setNameOfTag(tagDTO.getNameOfTag());

        return  tagEntity;



    }




}
