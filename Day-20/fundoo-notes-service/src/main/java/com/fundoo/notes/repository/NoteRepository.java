package com.fundoo.notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundoo.notes.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

	List<Note> findByUserIdAndPinnedFalseAndArchivedFalseAndTrashedFalse(Long userId);

	Optional<Note> findByNoteIdAndUserIdAndArchivedFalseAndTrashedFalse(Long noteId, Long userId);

	List<Note> findByUserIdAndPinnedTrueAndArchivedFalseAndTrashedFalse(Long userId);

	List<Note> findByUserIdAndArchivedTrueAndTrashedFalse(Long userId);

	Optional<Note> findByNoteIdAndUserIdAndArchivedTrueAndTrashedFalse(Long noteId, Long userId);

	List<Note> findByUserIdAndTrashedTrue(Long userId);

	Optional<Note> findByNoteIdAndUserIdAndTrashedTrue(Long noteId, Long userId);

	List<Note> findByUserIdAndTitleContainingIgnoreCaseAndArchivedFalseAndTrashedFalse(Long userId, String title);

	boolean existsByTagsTagId(Long tagId);

	List<Note> findByUserId(Long userId);

	Optional<Note> findByNoteIdAndUserId(Long noteId, Long userId);
}