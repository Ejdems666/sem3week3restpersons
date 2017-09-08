package org.cba.sem3.utility;

import com.google.gson.Gson;
import org.cba.sem3.entity.Person;

import java.util.List;

/**
 * Created by adam on 9/4/2017.
 */
public class PersonJSONConverter {
    public static final Gson gson = new Gson();

    public static Person getPersonFromJson(String json){
        return gson.fromJson(json, Person.class);
    }

    public static String getJSONFromPerson(Person person) {
        return gson.toJson(person);
    }

    public static String getJSONFromPerson(List<Person> persons) {
        return gson.toJson(persons);
    }
}
