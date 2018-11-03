package entitiesP;

abstract class BasicPerson {
    private String personFIO;

    public String getPersonFIO() {
        return personFIO;
    }

    public void setPersonFIO(String personFIO) {
        this.personFIO = personFIO;
    }

    public BasicPerson(String personFIO){
        this.personFIO = personFIO;
    }
}
