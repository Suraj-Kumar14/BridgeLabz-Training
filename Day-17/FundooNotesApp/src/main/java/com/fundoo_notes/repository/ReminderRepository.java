package com.fundoo_notes.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoo_notes.entity.Reminder;
import com.fundoo_notes.entity.ReminderStatus;
import com.fundoo_notes.entity.User;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

	List<Reminder> findByStatusAndReminderTimeLessThanEqual(ReminderStatus status, LocalDateTime reminderTime);

	List<Reminder> findByStatusAndProcessingStartedAtLessThanEqual(ReminderStatus status, LocalDateTime time);

	List<Reminder> findByUser(User user);
}