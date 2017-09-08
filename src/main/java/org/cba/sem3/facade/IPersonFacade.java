package org.cba.sem3.facade;

import org.cba.sem3.entity.Person;

import java.util.List;

/**
 * Created by adam on 9/4/2017.
 */
public interface IPersonFacade {
    Person addPerson(Person p);

    Person deletePerson(int id);

    Person getPerson(int id);

    List<Person> getPersons();

    Person editPerson(Person p);
}
