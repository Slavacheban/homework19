package com.springdata.service;

import com.springdata.model.PersonEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Log4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SchedualService {
    private final PersonService personService;
    private final EmailSender emailSender;

    @Scheduled(cron = "$(CRON)")
    public void sendMailToPerson() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        List<PersonEntity> list = personService.findAllByBirthDay(month, day);
        list.forEach(personEntity -> {
            try {
                String message = "Happy Birthday dear " + personEntity.getName() + "!";
                emailSender.send(personEntity.getEmail(), "Happy Birthday!", message);
            } catch (Exception e) {
            }
        });
    }
}

