package entitiesP;

enum ClientType {
    PRIVATE_PERSON, JURISTIC_PERSON;

    public String getValue(){
        switch (this){
            case PRIVATE_PERSON:
                return "private person";
            case JURISTIC_PERSON:
                return "juristic person";
            default:
                return "";
        }
    }
}
