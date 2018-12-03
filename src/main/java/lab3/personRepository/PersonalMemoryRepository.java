package lab3.personRepository;

import lab3.interfaces.CrudRepository;
import lab3.personModel.Mitarbeiter;
import lab3.personModel.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonalMemoryRepository implements CrudRepository<Person> {

    private List<Person> personList = new ArrayList<Person>();

    public PersonalMemoryRepository()  {
        super();
    }

    public Person findOne(Long id) {
        for (Person person : personList){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public Iterable<Person> findAll() {
        return personList;

    }

    public Person save(Person person) {
        personList.add(person);
        return person;
    }

    public Person delete(Long id) {
        Person person = findOne(id);
        personList.remove(person);
        return person;
    }

    public Person update(Person person) {
        if(findOne(person.getId()) != null) {
            Person updatedPerson = findOne(person.getId());
            updatedPerson.setVorname(person.getVorname());
            updatedPerson.setNachname(person.getNachname());
            updatedPerson.setAdresse(person.getAdresse());
            return updatedPerson;
        }
        return null;
    }
}


