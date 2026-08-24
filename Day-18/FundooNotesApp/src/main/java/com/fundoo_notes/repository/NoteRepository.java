package com.fundoo_notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundoo_notes.entity.Note;
import com.fundoo_notes.entity.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

	List<Note> findByUserEmail(String email);
	List<Note> findByUserAndTrashedFalse(User user);
	
	Optional<Note> findByNoteIdAndUser(Long noteId, User user);

	Optional<Note> findByNoteIdAndUserEmail(Long noteId, String email);

	List<Note> findByUserEmailAndPinnedTrueAndTrashedFalse(String userEmail);

	List<Note> findByUserEmailAndArchivedTrueAndTrashedFalse(String userEmail);

	List<Note> findByUserEmailAndTrashedTrue(String userEmail);

	List<Note> findByUserEmailAndArchivedFalseAndTrashedFalse(String userEmail);

	@Query("SELECT n FROM Note n WHERE n.user = :user AND n.trashed = false AND ( LOWER(n.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(n.description) LIKE LOWER(CONCAT('%', :keyword, '%')))")
	List<Note> searchNotes(@Param("user") User user, @Param("keyword") String keyword);
}
