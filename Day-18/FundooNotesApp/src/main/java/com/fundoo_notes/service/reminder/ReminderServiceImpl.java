package com.fundoo_notes.service.reminder;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fundoo_notes.dto.request.reminder.ReminderRequestDTO;
import com.fundoo_notes.dto.response.ReminderResponseDTO;
import com.fundoo_notes.entity.Note;
import com.fundoo_notes.entity.Reminder;
import com.fundoo_notes.entity.ReminderStatus;
import com.fundoo_notes.entity.User;
import com.fundoo_notes.exception.NoteNotFoundException;
import com.fundoo_notes.exception.ReminderNotFoundException;
import com.fundoo_notes.exception.UserNotFoundException;
import com.fundoo_notes.repository.NoteRepository;
import com.fundoo_notes.repository.ReminderRepository;
import com.fundoo_notes.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReminderServiceImpl implements ReminderService {

	private final ReminderRepository reminderRepository;

	private final NoteRepository noteRepository;

	private final UserRepository userRepository;

	@Override
	public ReminderResponseDTO createReminder(Long noteId, ReminderRequestDTO request) {

		User currentUser = getCurrentUser();

		Note note = noteRepository.findByNoteIdAndUser(noteId, currentUser)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with ID: " + noteId));

		Reminder reminder = new Reminder();

		reminder.setNote(note);

		reminder.setUser(currentUser);

		reminder.setReminderTime(request.getReminderTime());

		reminder.setStatus(ReminderStatus.PENDING);

		reminder.setCreatedAt(LocalDateTime.now());

		Reminder savedReminder = reminderRepository.save(reminder);

		return toResponse(savedReminder);
	}

	@Override
	public List<ReminderResponseDTO> getMyReminders() {

		User currentUser = getCurrentUser();

		return reminderRepository.findByUser(currentUser).stream().map(this::toResponse).toList();
	}

	@Override
	public void cancelReminder(Long reminderId) {

		User currentUser = getCurrentUser();

		Reminder reminder = reminderRepository.findById(reminderId)
				.orElseThrow(() -> new ReminderNotFoundException("Reminder not found with ID: " + reminderId));

		if (!reminder.getUser().getId().equals(currentUser.getId())) {

			throw new RuntimeException("You are not authorized to cancel this reminder");
		}

		reminder.setStatus(ReminderStatus.CANCELLED);

		reminderRepository.save(reminder);
	}

	private User getCurrentUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String email = authentication.getName();

		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	private ReminderResponseDTO toResponse(Reminder reminder) {

		return new ReminderResponseDTO(

				reminder.getReminderId(),

				reminder.getNote().getNoteId(),

				reminder.getNote().getTitle(),

				reminder.getReminderTime(),

				reminder.getStatus());
	}
}