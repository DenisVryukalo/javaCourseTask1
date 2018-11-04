package entities;

abstract class BasicPerson {
    //fields-------------------------------------------
    private String personFIO;

    //constructor--------------------------------------
    public BasicPerson(String personFIO){
        this.personFIO = personFIO;
    }

    //getters & setters--------------------------------
    public String getPersonFIO() {
        return personFIO;
    }

    public void setPersonFIO(String personFIO) {
        this.personFIO = personFIO;
    }
}
