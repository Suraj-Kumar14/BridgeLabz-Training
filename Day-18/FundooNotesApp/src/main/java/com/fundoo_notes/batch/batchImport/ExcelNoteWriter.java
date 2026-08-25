package com.fundoo_notes.batch.batchImport;

import com.fundoo_notes.dto.batch.ExcelNoteDTO;
import com.fundoo_notes.entity.Note;
import com.fundoo_notes.entity.User;
import com.fundoo_notes.repository.NoteRepository;
import com.fundoo_notes.repository.UserRepository;

import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;

import java.time.LocalDateTime;

public class ExcelNoteWriter implements ItemWriter<ExcelNoteDTO> {

	private final NoteRepository noteRepository;
	private final UserRepository userRepository;
	private final String userEmail;

	public ExcelNoteWriter(NoteRepository noteRepository, UserRepository userRepository, String userEmail) {

		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
		this.userEmail = userEmail;
	}

	@Override
	public void write(Chunk<? extends ExcelNoteDTO> chunk) {

		User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));

		for (ExcelNoteDTO dto : chunk.getItems()) {

			Note note = new Note();

			note.setTitle(dto.getTitle());
			note.setDescription(dto.getDescription());

			note.setCreatedAt(LocalDateTime.now());
			note.setUpdateAt(LocalDateTime.now());

			note.setPinned(false);
			note.setArchived(false);
			note.setTrashed(false);

			note.setUser(user);

			noteRepository.save(note);
		}
	}
}