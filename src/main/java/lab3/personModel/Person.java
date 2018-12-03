package lab3.personModel;


import java.util.Objects;

/**
 * MOdel der person
 */
public class Person {
    private long id;
    private String vorname;
    private String nachname;
    private String adresse;

    /**  Constructor der classe
     * @param id id der user
     * @param vorname user der vorname
     * @param nachname  user nachname
     * @param adresse user adresse
     */
    public Person(int id, String vorname, String nachname, String adresse) {
        super();
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {this.nachname = nachname;}

    public String getAdresse() {return adresse;}

    public void setAdresse(String adresse) {this.adresse = adresse;}




    @Override
    public String toString(){
        return "ID :" + id + " , " + "Vorname: " + vorname  + " , " + "Nachman: " +  nachname + " , " + "Adresse: " + adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(vorname, person.vorname) &&
                Objects.equals(nachname, person.nachname) &&
                Objects.equals(adresse, person.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vorname, nachname, adresse);
    }

}
