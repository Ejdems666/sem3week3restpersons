package org.cba.sem3.resource;

import org.cba.sem3.entity.Person;
import org.cba.sem3.facade.IPersonFacade;
import org.cba.sem3.facade.PersonFacade;
import org.cba.sem3.utility.PersonJSONConverter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by adam on 9/4/2017.
 */
@Path("/person")
public class PersonResource {

    private IPersonFacade facade;

    public PersonResource() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        facade = new PersonFacade(em);
    }

    @GET
    @Produces("application/json")
    public String getAllPersons() {
        List<Person> personList = facade.getPersons();
        return PersonJSONConverter.getJSONFromPerson(personList);
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    public String getPerson(@PathParam("id") int id) {
        Person person = facade.getPerson(id);
        return PersonJSONConverter.getJSONFromPerson(person);
    }

    @POST
    @Consumes("application/json")
    public void savePerson(String json) {
        Person person = PersonJSONConverter.getPersonFromJson(json);
        facade.addPerson(person);
    }

    @PUT
    @Consumes("application/json")
    public void updatePerson(String json) {
        Person person = PersonJSONConverter.getPersonFromJson(json);
        facade.editPerson(person);
    }

    @DELETE
    @Path("{id}")
    public void deletePerson(@PathParam("id") int id) {
        facade.deletePerson(id);
    }
}
