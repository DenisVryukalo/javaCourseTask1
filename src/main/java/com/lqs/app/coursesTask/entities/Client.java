package com.lqs.app.coursesTask.entities;

import lombok.*;

import javax.management.InvalidAttributeValueException;

@Getter @Setter public class Client extends BasicPerson {
    private ClientType clientType;
    private String address;
    private String enterpriseName;
    //@Getter private static String simpleFieldsMapping = "address";

    public Client(ClientType type, String name, String address){
        super((type == ClientType.JURISTIC_PERSON)? "" : name);
        this.enterpriseName = (type == ClientType.JURISTIC_PERSON)? name : "";
        this.clientType = type;
        this.address = address;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("клиент - ");
        if(clientType == clientType.JURISTIC_PERSON){
            result.append(this.enterpriseName);
        }
        else{
            result.append(this.getPersonFIO());
        }
        result.append(", " + getClientType().getValue());
        return result.toString();
    }
}
