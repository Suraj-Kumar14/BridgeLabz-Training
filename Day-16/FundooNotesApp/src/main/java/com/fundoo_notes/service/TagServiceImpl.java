package com.fundoo_notes.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fundoo_notes.dto.request.tag.TagRequestDTO;
import com.fundoo_notes.dto.response.TagResponseDTO;
import com.fundoo_notes.entity.Tag;
import com.fundoo_notes.entity.User;
import com.fundoo_notes.exception.TagNotFoundException;
import com.fundoo_notes.exception.UserNotFoundException;
import com.fundoo_notes.repository.TagRepository;
import com.fundoo_notes.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    @Override
    public TagResponseDTO createTag(TagRequestDTO request) {

        User currentUser = getCurrentUser();

        // Check whether this tag already exists for this user
        if (tagRepository
                .findByNameIgnoreCaseAndUserEmail(
                        request.getName(),
                        currentUser.getEmail())
                .isPresent()) {

            throw new RuntimeException(
                    "Tag already exists for this user");
        }

        Tag tag = new Tag();

        tag.setName(request.getName());
        tag.setUser(currentUser);

        Tag savedTag = tagRepository.save(tag);

        return toResponse(savedTag);
    }

    @Override
    public List<TagResponseDTO> getAllTags() {

        User currentUser = getCurrentUser();

        return tagRepository
                .findByUserEmail(currentUser.getEmail())
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public TagResponseDTO getTagById(Long tagId) {

        User currentUser = getCurrentUser();

        Tag tag = tagRepository
                .findByTagIdAndUserEmail(
                        tagId,
                        currentUser.getEmail())
                .orElseThrow(() ->
                        new TagNotFoundException(
                                "Tag not found with id: " + tagId));

        return toResponse(tag);
    }

    @Override
    public void deleteTag(Long tagId) {

        User currentUser = getCurrentUser();

        Tag tag = tagRepository
                .findByTagIdAndUserEmail(
                        tagId,
                        currentUser.getEmail())
                .orElseThrow(() ->
                        new TagNotFoundException(
                                "Tag not found with id: " + tagId));

        tagRepository.delete(tag);
    }

    private User getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        String email = authentication.getName();

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"));
    }

    private TagResponseDTO toResponse(Tag tag) {

        return new TagResponseDTO(
                tag.getTagId(),
                tag.getName()
        );
    }
}