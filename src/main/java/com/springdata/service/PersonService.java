package com.springdata.service;

import com.springdata.model.PersonEntity;

import java.util.List;

public interface PersonService {
    void createPerson(PersonEntity person);

    void updatePerson(PersonEntity persin);

    void deletePerson(Long id);

    PersonEntity findPersonById(Long id);

    List<PersonEntity> findAll();

    List<PersonEntity> findAllByBirthDay(int month, int day);
}
