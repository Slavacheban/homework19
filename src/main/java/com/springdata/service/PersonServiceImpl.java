package com.springdata.service;

import com.springdata.model.PersonEntity;
import com.springdata.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImpl implements PersonService {
    private PersonRepository repository;

    @Override
    public void createPerson(PersonEntity person) {
        repository.save(person);
    }

    @Override
    public void updatePerson(PersonEntity persin) {
        repository.save(persin);
    }

    @Override
    public void deletePerson(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PersonEntity findPersonById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<PersonEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PersonEntity> findAllByBirthDay(int month, int day) {
        return repository.findByMatchMonthAndMatchDay(month, day);
    }
}
