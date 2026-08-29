package com.fundoo.notes.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.notes.dto.request.TagRequestDTO;
import com.fundoo.notes.dto.response.TagResponseDTO;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.Tag;
import com.fundoo.notes.exception.NoteNotFoundException;
import com.fundoo.notes.exception.TagAlreadyExistsException;
import com.fundoo.notes.exception.TagInUseException;
import com.fundoo.notes.exception.TagNotFoundException;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.repository.TagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

	private final TagRepository tagRepository;

	private final NoteRepository noteRepository;

	@Override
	@Transactional
	public TagResponseDTO createTag(TagRequestDTO request) {

		String tagName = request.getName().trim();

		if (tagRepository.existsByNameIgnoreCase(tagName)) {

			throw new TagAlreadyExistsException("Tag already exists: " + tagName);
		}

		Tag tag = new Tag();

		tag.setName(tagName);

		Tag savedTag = tagRepository.save(tag);

		return toResponse(savedTag);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TagResponseDTO> getAllTags() {

		return tagRepository.findAllByOrderByNameAsc().stream().map(this::toResponse).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public TagResponseDTO getTagById(Long tagId) {

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with id: " + tagId));

		return toResponse(tag);
	}

	@Override
	@Transactional
	public void deleteTag(Long tagId) {

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with id: " + tagId));

		/*
		 * IMPORTANT:
		 *
		 * Tag is global.
		 *
		 * Therefore we must check ALL notes, not notes belonging to the current user.
		 */

		if (!tag.getNotes().isEmpty()) {

			throw new TagInUseException("Tag '" + tag.getName() + "' cannot be deleted because it is being used by "
					+ tag.getNotes().size() + " note(s)");
		}

		tagRepository.delete(tag);
	}

	@Override
	@Transactional
	public TagResponseDTO addTagToNote(Long noteId, Long tagId, Long userId) {

		/*
		 * IMPORTANT:
		 *
		 * Find note using BOTH noteId and userId.
		 *
		 * This prevents User B from modifying User A's note.
		 */

		Note note = noteRepository.findByNoteIdAndUserId(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + noteId));

		// Find global tag

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with id: " + tagId));

		// Avoid duplicate relationship

		if (note.getTags().contains(tag)) {

			return toResponse(tag);
		}

		note.getTags().add(tag);

		noteRepository.save(note);

		return toResponse(tag);
	}

	@Override
	@Transactional
	public void removeTagFromNote(Long noteId, Long tagId, Long userId) {

		/*
		 * Again, verify ownership.
		 */

		Note note = noteRepository.findByNoteIdAndUserId(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + noteId));

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with id: " + tagId));

		if (!note.getTags().contains(tag)) {

			throw new TagNotFoundException("Tag is not attached to this note");
		}

		note.getTags().remove(tag);

		noteRepository.save(note);
	}

	private TagResponseDTO toResponse(Tag tag) {

		TagResponseDTO response = new TagResponseDTO();

		response.setTagId(tag.getTagId());

		response.setName(tag.getName());

		return response;
	}
}