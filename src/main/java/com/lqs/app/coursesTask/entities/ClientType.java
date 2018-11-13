package com.lqs.app.coursesTask.entities;

public enum ClientType {

    PRIVATE_PERSON, JURISTIC_PERSON;

    //Method for writing a string
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
