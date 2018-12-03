package lab3.personController;

import lab3.personModel.Mitarbeiter;
import lab3.personModel.Person;
import lab3.personRepository.PersonalMemoryRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static lab3.personModel.BerufPos.*;
import static org.junit.Assert.*;

public class PersonControllerTest {




    @Test
    public void addPerson() {
        PersonalMemoryRepository personalMemoryRepository = new PersonalMemoryRepository();
        PersonController personController = new PersonController(personalMemoryRepository);
        Person person1 = new Person(1,"Curcean","Cristian","Str campeni");
        Person person2 = new Person(2,"Muntean","Robert","Str campeni");
        Person person3 = new Person(3,"Muntean","Catalin","Str campeni");
        List<Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person2);
        personController.addPerson(person1);
        personController.addPerson(person2);
        assertEquals(personList,personController.findAll());
        personList.add(person3);
        personController.addPerson(person3);
        assertEquals(personList,personController.findAll());


    }

    @Test
    public void findPersonById() {
        PersonalMemoryRepository personalMemoryRepository = new PersonalMemoryRepository();
        PersonController personController = new PersonController(personalMemoryRepository);
        Person person1 = new Person(1,"Curcean","Cristian","Str campeni");
        Person person2 = new Person(2,"Muntean","Robert","Str campeni");
        Person person3 = new Person(3,"Muntean","Catalin","Str campeni");
        personController.addPerson(person1);
        personController.addPerson(person2);
        personController.addPerson(person3);
        assertEquals(person1,personController.findPersonById(1));
        assertEquals(person3,personController.findPersonById(3));
        assertNotEquals(person3,personController.findPersonById(2));
    }

    @Test
    public void deleteBerson() {
        PersonalMemoryRepository personalMemoryRepository = new PersonalMemoryRepository();
        PersonController personController = new PersonController(personalMemoryRepository);
        Person person1 = new Person(1,"Curcean","Cristian","Str campeni");
        Person person2 = new Person(2,"Muntean","Robert","Str campeni");
        Person person3 = new Person(3,"Muntean","Catalin","Str campeni");
        personController.addPerson(person1);
        personController.addPerson(person2);
        personController.addPerson(person3);
        List<Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person2);
        personController.deleteBerson(3);
        assertEquals(personList,personController.findAll());
    }

    @Test
    public void update() {
        PersonalMemoryRepository personalMemoryRepository = new PersonalMemoryRepository();
        PersonController personController = new PersonController(personalMemoryRepository);
        Person person1 = new Person(1,"Curcean","Cristian","Str campeni");
        Person person2 = new Person(1,"Muntean","Cristian","Str VAsile");
        Person person3 = new Person(2,"Vasilesc","Cristian","Str ionescu");
        Person person4 = new Person(2,"Muntean","Cristian","Str VAsile");
        personController.addPerson(person1);
        personController.addPerson(person3);
        assertEquals(person1,personController.update(person2));
        assertEquals(person4,personController.update(person4));




    }

    @Test
    public void findAll() {
        PersonalMemoryRepository personalMemoryRepository = new PersonalMemoryRepository();
        PersonController personController = new PersonController(personalMemoryRepository);
        Person person1 = new Person(1,"Curcean","Cristian","Str campeni");
        Person person2 = new Person(2,"Muntean","Robert","Str campeni");
        Person person3 = new Person(3,"Muntean","Catalin","Str campeni");
        List<Person> personList = new ArrayList<Person>();
        personController.addPerson(person1);
        personController.addPerson(person2);
        personController.addPerson(person3);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        assertEquals(personList,personController.findAll());
    }
    @Test
    public void calculireSalary(){
        PersonalMemoryRepository personalMemoryRepository = new PersonalMemoryRepository();
        PersonController personController = new PersonController(personalMemoryRepository);

        Person person1 = new Person(1,"Curcean","Cristian","Str campeni");
        Mitarbeiter mitarbeiter1 = new Mitarbeiter(5, "Balan", "Alin", "Darlos", ENTWICKLER, 4, 15.0, 12);
        Mitarbeiter mitarbeiter2 = new Mitarbeiter(6, "Trief", "Stella", "Cluj", TESTER, 3, 9.0, 8);
        Mitarbeiter mitarbeiter3 = new Mitarbeiter(7, "Balan", "Alin", "Darlos", PROJECTMANAGER, 5, 30.0, 6);
        Mitarbeiter mitarbeiter4 = new Mitarbeiter(8, "Balan", "Alin", "Darlos", TEAMLEADER, 2, 3.0, 4);


        assertEquals(180,personController.calculireSalary(mitarbeiter1,1), 0.00001);
        assertEquals(0,personController.calculireSalary(person1,0), 0.00001);
        assertEquals(4320,personController.calculireSalary(mitarbeiter2,60), 0.00001);
    }
}