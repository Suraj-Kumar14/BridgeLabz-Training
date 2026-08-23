package com.fundoo_notes.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo_notes.dto.request.reminder.ReminderMessageDTO;
import com.fundoo_notes.entity.Reminder;
import com.fundoo_notes.entity.ReminderStatus;
import com.fundoo_notes.messaging.ReminderProducer;
import com.fundoo_notes.repository.ReminderRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReminderScheduler {

    private final ReminderRepository reminderRepository;
    private final ReminderProducer reminderProducer;


    @Scheduled(fixedRate = 10000)
    @Transactional
    public void checkDueReminders() {

        recoverStuckReminders();

        List<Reminder> reminders =
                reminderRepository
                        .findByStatusAndReminderTimeLessThanEqual(
                                ReminderStatus.PENDING,
                                LocalDateTime.now()
                        );

        for (Reminder reminder : reminders) {

            reminder.setStatus(
                    ReminderStatus.PROCESSING
            );

            reminder.setProcessingStartedAt(
                    LocalDateTime.now()
            );

            ReminderMessageDTO message =
                    new ReminderMessageDTO(
                            reminder.getReminderId(),
                            reminder.getNote().getNoteId(),
                            reminder.getUser().getId(),
                            reminder.getNote().getTitle()
                    );

            reminderProducer.sendMessage(message);
        }
    }


    private void recoverStuckReminders() {

        LocalDateTime recoveryTime =
                LocalDateTime.now().minusMinutes(1);

        List<Reminder> stuckReminders =
                reminderRepository
                        .findByStatusAndProcessingStartedAtLessThanEqual(
                                ReminderStatus.PROCESSING,
                                recoveryTime
                        );

        for (Reminder reminder : stuckReminders) {

            reminder.setStatus(
                    ReminderStatus.PENDING
            );

            reminder.setProcessingStartedAt(
                    null
            );
        }
    }
}