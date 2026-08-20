package com.fundoo_notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundoo_notes.entity.Note;
import com.fundoo_notes.entity.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

	List<Note> findByUser(User user);
	
	Optional<Note> findByNoteIdAndUser(Long noteId, User user);
}
