package com.mysite.service;

import com.mysite.dao.PersonDao;
import com.mysite.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Алена on 16.03.14.
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional   //должны быть выполнены все действия, или ни одного. если одно не было выполнено, предыдущ. отменяются
    public void createPerson(String name) {
        Person person = new Person();
        person.setName(name);
        personDao.savePerson(person);
    }

    @Transactional
    public Person findPerson(String name) {
        return personDao.findByName(name);
    }

    @Transactional
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Transactional
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }
}
