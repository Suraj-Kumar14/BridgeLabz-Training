package com.fundoo_notes.service.reminder;

import java.util.List;

import com.fundoo_notes.dto.request.reminder.ReminderRequestDTO;
import com.fundoo_notes.dto.response.ReminderResponseDTO;

public interface ReminderService {

	ReminderResponseDTO createReminder(Long noteId, ReminderRequestDTO request);

	List<ReminderResponseDTO> getMyReminders();

	void cancelReminder(Long reminderId);
}