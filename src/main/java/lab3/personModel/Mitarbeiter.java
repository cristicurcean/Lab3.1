package lab3.personModel;

/**
 *  model der classe mitarbeiter
 */
public class Mitarbeiter extends Person{

    private BerufPos berufPosition;
    private Integer erfahrungsNiveau;
    private Double stundenLohn;
    private Integer stundenProTag;

    /**
     * @param id id der mitarbeite
     * @param vorname vorname der mitarbeite
     * @param nachname nachname der mitartbeite
     * @param adresse adresse der mitarbeite
     * @param berufPosition beruf position der mitareiebr
     * @param erfahrungsNiveau erfahrung der mirtabeitere kentnissse
     * @param stundenLohn viewiel bekommt er pro stunde
     * @param stundenProTag vwievie arbeite er pro tar
     */
    public Mitarbeiter(int id, String vorname, String nachname, String adresse, BerufPos berufPosition,Integer erfahrungsNiveau,Double stundenLohn,Integer stundenProTag){
        super(id,vorname, nachname, adresse );
        this.berufPosition = berufPosition;
        this.erfahrungsNiveau = erfahrungsNiveau;
        this.stundenLohn = stundenLohn;
        this.stundenProTag = stundenProTag;

    }

    public BerufPos getBerufPosition() {
        return berufPosition;
    }

    public void setBerufPosition(BerufPos berufPosition) {
        this.berufPosition = berufPosition;
    }

    public Integer getErfahrungsNiveau() {
        return erfahrungsNiveau;
    }

    public void setErfahrungsNiveau(Integer erfahrungsNiveau) {
        this.erfahrungsNiveau = erfahrungsNiveau;
    }

    public Double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(Double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public Integer getStundenProTag() {
        return stundenProTag;
    }

    public void setStundenProTag(Integer stundenProTag) {
        this.stundenProTag = stundenProTag;
    }

    @Override
    public String toString() {

        return super.toString() + "berufPosition :" + berufPosition + " , " + "erfahrungsNiveau: " + erfahrungsNiveau  + " , " + "stundenLohn: " +  stundenLohn + " , " + "stundenProTag: " + stundenProTag;
    }
}

