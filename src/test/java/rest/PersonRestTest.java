package rest;

import org.cba.sem3.entity.Person;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by adam on 08/09/2017.
 */
public class PersonRestTest extends FunctionalTest{
    @Test
    public void specificPerson() {
        given().when().get("/person/1")
                .then().body("id",equalTo(1));
    }

    @Test
    public void invalidPerson() {
        given().when().get("/person/999")
                .then().statusCode(404);
    }

    @Test
    public void allPersons() {
        given().when().get("/person")
                .then().statusCode(200);
    }

    @Test
    public void createPerson() {
        Person person = new Person("firstname","surname","1234");
        given().contentType("application/json")
                .body(person)
                .when().post("/person").then()
                .body("firstName",equalTo(person.getFirstName()))
                .statusCode(200);
    }

    @Test
    public void updatePerson() {
        Person person = new Person(1,"firstname","surname","1234");
        given().contentType("application/json")
                .body(person)
                .when().put("/person").then()
                .body(containsString("id"))
                .statusCode(200);
    }

    @Test
    public void deletePerson() {
        int id = 2;
        given().contentType("application/json")
                .pathParam("id", id)
                .when().delete("/person/{id}").then()
                .body(containsString("deleted"))
                .body(containsString(""+id))
                .statusCode(200);
    }
}
