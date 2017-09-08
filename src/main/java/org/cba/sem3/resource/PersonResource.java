package org.cba.sem3.resource;

import com.google.gson.JsonObject;
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
    @Produces("application/json")
    public String savePerson(String json) {
        Person person = PersonJSONConverter.getPersonFromJson(json);
        facade.addPerson(person);
        return PersonJSONConverter.getJSONFromPerson(person);
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public String updatePerson(String json) {
        Person person = PersonJSONConverter.getPersonFromJson(json);
        facade.editPerson(person);
        return PersonJSONConverter.getJSONFromPerson(person);
    }

    @DELETE
    @Produces("application/json")
    @Path("{id}")
    public String deletePerson(@PathParam("id") int id) {
        facade.deletePerson(id);
        JsonObject successMessage = new JsonObject();
        successMessage.addProperty("success", "Person with id " + id + " was deleted!");
        return successMessage.toString();
    }
}
