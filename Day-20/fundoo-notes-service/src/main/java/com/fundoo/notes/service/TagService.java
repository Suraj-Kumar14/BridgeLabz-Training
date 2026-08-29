package com.fundoo.notes.service;

import java.util.List;

import com.fundoo.notes.dto.request.TagRequestDTO;
import com.fundoo.notes.dto.response.TagResponseDTO;


public interface TagService {

   
    TagResponseDTO createTag(TagRequestDTO request);

    List<TagResponseDTO> getAllTags();

    TagResponseDTO getTagById(Long tagId);

    TagResponseDTO addTagToNote(Long noteId, Long tagId, Long userId);

    void removeTagFromNote(Long noteId, Long tagId, Long userId);

    void deleteTag(Long tagId);
}