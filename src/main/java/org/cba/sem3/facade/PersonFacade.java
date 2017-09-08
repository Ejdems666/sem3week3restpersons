package org.cba.sem3.facade;

import org.cba.sem3.entity.Person;
import org.cba.sem3.exception.ExceptionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by adam on 9/4/2017.
 */
public class PersonFacade implements IPersonFacade {
    private EntityManager em;

    public PersonFacade(EntityManager em) {
        this.em = em;
    }

    @Override
    public Person addPerson(Person person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        em.flush();
        transaction.commit();
        return person;
    }

    @Override
    public Person deletePerson(int id) {
        Person person = getPerson(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(person);
        em.flush();
        transaction.commit();
        return person;
    }

    @Override
    public Person getPerson(int id) {
        Person person = em.find(Person.class, id);
        if (person == null) {
            throw ExceptionFactory.createNotFound(id);
        }
        return person;
    }

    @Override
    public List<Person> getPersons() {
        Query query = em.createQuery("SELECT p FROM Person p");
        return query.getResultList();
    }

    @Override
    public Person editPerson(Person person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(person);
        em.flush();
        transaction.commit();
        return person;
    }
}
