package com.fundoo_notes.service;

import java.util.List;

import com.fundoo_notes.dto.request.tag.TagRequestDTO;
import com.fundoo_notes.dto.response.TagResponseDTO;

public interface TagService {

    TagResponseDTO createTag(TagRequestDTO request);

    List<TagResponseDTO> getAllTags();

    TagResponseDTO getTagById(Long tagId);

    void deleteTag(Long tagId);
}