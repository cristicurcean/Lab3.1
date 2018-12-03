package lab3.personController;


import lab3.personModel.Mitarbeiter;
import lab3.personModel.Person;

import lab3.personRepository.PersonalMemoryRepository;

public class PersonController {
    private PersonalMemoryRepository personalMemoryRepository;


    public PersonController(PersonalMemoryRepository personalMemoryRepository) {
        this.personalMemoryRepository = personalMemoryRepository;
    }

    public Person addPerson(Person person) {
        return personalMemoryRepository.save(person);
    }

    public Person findPersonById(long id) {
        return personalMemoryRepository.findOne(id);

    }

    public Person deleteBerson(long id) {
        return personalMemoryRepository.delete(id);
    }

    public Person update(Person person) {
        return personalMemoryRepository.update(person);
    }

    public Iterable<Person> findAll() {
        return personalMemoryRepository.findAll();
    }

    public double calculireSalary(Mitarbeiter mitarbeiter, int numberOfDays) {
        double salary = mitarbeiter.getStundenLohn() * mitarbeiter.getStundenProTag() * numberOfDays;
        return salary;

    }
    public double calculireSalary(Person person, int numberOfDays) {
        return 0;
    }
}






