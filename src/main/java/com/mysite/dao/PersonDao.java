package com.mysite.dao;

import com.mysite.entity.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Алена on 16.03.14.
 */
@Repository
public class PersonDao {
    @PersistenceContext
    private EntityManager em;

//    @PersistenceContext   //сюда инжектит бин, который реализуется в персистенс контексте
    public void setEntityManager(final EntityManager em){
        this.em = em;
    }

    @PostConstruct
    public void savePerson(Person person){
        em.persist(person);
    }

    public Person findByName(String name) {
        return (Person)em.createQuery("SELECT p from Person p WHERE p.name=:name").setParameter("name", name).getSingleResult();
    }

    public List<Person> findAll() {
        return (List<Person>)em.createQuery("SELECT p from Person p").getResultList();
    }
}
