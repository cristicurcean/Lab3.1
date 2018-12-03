package lab3;


import lab3.personController.PersonController;
import lab3.personModel.Mitarbeiter;
import lab3.personModel.Person;
import lab3.personRepository.PersonalMemoryRepository;

import javax.sound.midi.MidiDeviceTransmitter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static lab3.personModel.BerufPos.*;

public class StartApp {

    private static PersonalMemoryRepository personalMemoryRepository = new PersonalMemoryRepository();
    private static PersonController personController = new PersonController(personalMemoryRepository);


    public static void main(String[] args)  {

        Person person1 = new Person(1, "Curcean", "Cristian", "Str campeni");
        Person person2 = new Person(2, "Muntean", "Robert", "Str campeni");
        Person person3 = new Person(3, "Muntean", "Catalin", "Str campeni");
        Person person4 = new Person(4, "Cergo", "Iosca", "Str campeni");
        Mitarbeiter mitarbeiter1 = new Mitarbeiter(5, "Balan", "Alin", "Darlos", ENTWICKLER, 4, 15.0, 12);
        Mitarbeiter mitarbeiter2 = new Mitarbeiter(6, "Trief", "Stella", "Cluj", TESTER, 3, 9.0, 8);
        Mitarbeiter mitarbeiter3 = new Mitarbeiter(7, "Balan", "Alin", "Darlos", PROJECTMANAGER, 5, 30.0, 6);
        Mitarbeiter mitarbeiter4 = new Mitarbeiter(8, "Balan", "Alin", "Darlos", TEAMLEADER, 2, 3.0, 4);

        personController.addPerson(person1);
        personController.addPerson(person2);
        personController.addPerson(person3);
        personController.addPerson(person4);
        personController.addPerson(mitarbeiter1);
        personController.addPerson(mitarbeiter2);
        personController.addPerson(mitarbeiter3);
        personController.addPerson(mitarbeiter4);


        Scanner input = new Scanner(System.in);
        boolean mainLoop = true;

        int choice;
        while (true) {
            System.out.println("Menu\n");
            System.out.print("1.) Add-user \n");
            System.out.print("2.) Delete.\n");
            System.out.print("3.) Update.\n");
            System.out.print("4.) Show all.\n");
            System.out.print("5.) Show by id.\n");
            System.out.print("6.) Calculate salary pro jahr.\n");
            System.out.print("7.) Exit\n");
            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    List <Person> personList = (List<Person>)personController.findAll();
                    int id = personList.size() + 1 ;
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Enter PersonName: ");
                    String name = scan.nextLine();
                    System.out.println("Enter PersonVorName: ");
                    String vorName = scan.nextLine();
                    System.out.println("Enter Adresse: ");
                    String adressa = scan.nextLine();
                    Person person = new Person(id, vorName, name, adressa);
                    personController.addPerson(person);
                    break;
                case 2:
                    System.out.println("Enter id  user welchen du loschen willst");
                    Scanner w = new Scanner(System.in);
                    int idDelete = w.nextInt();
                    personController.deleteBerson(idDelete);
                    break;

                case 3:
                    Scanner t = new Scanner(System.in);
                    System.out.println("Select id die du anders willst");
                    int updaetID = t.nextInt();
                    Person personToUpdate = personController.findPersonById(updaetID) ;
                    if(personToUpdate == null) {
                        System.out.println("User existiert nicht");
                        break;
                    }
                    t.nextLine();
                    System.out.println("Enter PersonName: ");
                    String neueName = t.nextLine();
                    personToUpdate.setNachname(neueName);
                    System.out.println("Enter PersonVorName: ");
                    String neueVorName = t.nextLine();
                    personToUpdate.setVorname(neueVorName);
                    System.out.println("Enter Adresse: ");
                    String neueAdressa = t.nextLine();
                    personToUpdate.setAdresse(neueAdressa);

                    personController.update(personToUpdate);
                    break;



                case 4:
                    for (Person p : personController.findAll()) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    System.out.println("Enter PersonID: ");
                    Scanner tr = new Scanner(System.in);
                    long idd = tr.nextInt();
                    System.out.println(personController.findPersonById(idd));
                    break;

                case 6:

                    for(Object personnn : personController.findAll()) {
                        if (personnn instanceof Mitarbeiter) {
                            System.out.println(((Mitarbeiter) personnn).getNachname());
                            System.out.println(personController.calculireSalary((Mitarbeiter)personnn, 365));
                        }else {
                            System.out.println(((Person) personnn).getNachname());
                            System.out.println(personController.calculireSalary((Person) personnn, 365));

                        }



                    }

                }


        }
    }
}

