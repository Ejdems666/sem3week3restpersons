import org.cba.sem3.entity.Person;
import org.cba.sem3.facade.IPersonFacade;
import org.cba.sem3.facade.PersonFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by adam on 9/4/2017.
 */
public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        IPersonFacade facade = new PersonFacade(em);
        facade.addPerson(new Person("Adam","Becvar","+420777777777"));
    }
}
