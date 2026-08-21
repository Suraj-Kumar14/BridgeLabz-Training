package com.fundoo_notes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoo_notes.dto.request.tag.TagRequestDTO;
import com.fundoo_notes.dto.response.TagResponseDTO;
import com.fundoo_notes.entity.Tag;
import com.fundoo_notes.exception.TagNotFoundException;
import com.fundoo_notes.repository.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

	private final TagRepository tagRepository;

	@Override
	public TagResponseDTO createTag(TagRequestDTO request) {

		Tag tag = new Tag();

		tag.setName(request.getName());

		return toResponse(tagRepository.save(tag));
	}

	@Override
	public List<TagResponseDTO> getAllTags() {

		return tagRepository.findAll().stream().map(this::toResponse).toList();
	}

	@Override
	public TagResponseDTO getTagById(Long tagId) {

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with id: " + tagId));

		return toResponse(tag);
	}

	@Override
	public void deleteTag(Long tagId) {

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with id: " + tagId));

		tagRepository.delete(tag);

	}

	private TagResponseDTO toResponse(Tag tag) {

		return new TagResponseDTO(tag.getTagId(), tag.getName());
	}

}
