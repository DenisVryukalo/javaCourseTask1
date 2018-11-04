package entities;

enum ClientType {

    PRIVATE_PERSON, JURISTIC_PERSON;

    //method for writing a string
    public String getValue(){
        switch (this){
            case PRIVATE_PERSON:
                return "физическое лицо";
            case JURISTIC_PERSON:
                return "юридическое лицо";
            default:
                return "";
        }
    }
}
