package com.lqs.app.coursesTask.entities;

import java.text.DateFormat;
import java.util.*;
import lombok.*;

public class Contract {
    @Getter @Setter private int number;
    // Dates are stored with the type "Date", but
    // access is implemented by string values
    private Date agreeDate;
    private Date startDate;
    private Date stopDate;
    @Getter @Setter private Client client;
    private ArrayList<Insuree> insuredPersons;
    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    //@Getter private static String simpleFieldsMapping = "number,agreeDate,startDate,stopDate";

    public Contract(int number, String agreeDate, String startDate, String stopDate, Client client, ArrayList<Insuree> insuredPersons) {
        this.number = number;
        this.setAgreeDate(agreeDate);
        this.setStartDate(startDate);
        this.setStopDate(stopDate);
        this.client = client;
        this.insuredPersons = insuredPersons;
    }
    public Contract(int number, String agreeDate, String startDate, String stopDate, Client client) {
        this.number = number;
        this.setAgreeDate(agreeDate);
        this.setStartDate(startDate);
        this.setStopDate(stopDate);
        this.client = client;
        this.insuredPersons = new ArrayList<Insuree>();
    }

    // Gives the date as a string
    public String getAgreeDate() {
        return "" + dateFormat.format(agreeDate);
    }

    // Sets the date taking a string value
    public void setAgreeDate(String agreeDate) {
        try {
            this.agreeDate = dateFormat.parse(agreeDate);
        }catch(java.text.ParseException e){
            System.out.println("wrong date format: " + agreeDate);
        }
    }

    public String getStartDate() {
        return "" + dateFormat.format(startDate);
    }

    public void setStartDate(String startDate) {
        try {
            this.startDate = dateFormat.parse(startDate);
        }catch(java.text.ParseException e){
            System.out.println("wrong date format: " + startDate);
        }
    }

    public String getStopDate() {
        return "" + dateFormat.format(stopDate);
    }

    public void setStopDate(String stopDate) {
        try {
            this.stopDate = dateFormat.parse(stopDate);
        }catch(java.text.ParseException e){
            System.out.println("wrong date format: " + stopDate);
        }
    }

    public String getClientFIO() {
        return client.getPersonFIO();
    }

    public String getClientType() {
        return client.getClientType().toString();
    }

    // Filling the list of insured persons9
    public void addInsuredPerson(Insuree insuredPerson){
        if(insuredPerson != null) {
            insuredPersons.add(insuredPerson);
        }
    }

    //Getting the elements of the list by number and by FIO
    public Insuree getInsuredPersonByNum(int num){
        if(insuredPersons.size() < num){
            return null;
        }
        else{
            return insuredPersons.get(num);
        }
    }

    public Insuree getInsuredPersonByFIO(String personFIO){
        for(Insuree currentPerson : insuredPersons){
            if(currentPerson.getPersonFIO() == personFIO){
                return currentPerson;
            }
        }
        return null;
    }

    public float getTotalPriceForeach(){
        float sum = 0;
        for(Insuree insuredPerson : insuredPersons){
            sum += insuredPerson.getInsurancePrice();
        }
        return sum;
    }
    public float getTotalPriceByIterator(){
        float sum = 0;
        Iterator<Insuree> curStr = insuredPersons.iterator();
        while(curStr.hasNext())
        {
            sum += curStr.next().getInsurancePrice();
        }
        return sum;
    }

    public void printInsureesByAlphabet(){
        Collections.sort(insuredPersons, Insuree.compareNames);
        for(Insuree insuree : insuredPersons){
            System.out.println(insuree.getPersonFIOshort() + " " + insuree.getBornDate() + " " + insuree.getInsurancePrice());
        }
    }
    public void printInsureesByBornDate(){
        Collections.sort(insuredPersons, Insuree.compareBornDates);
        for(Insuree insuree : insuredPersons){
            System.out.println(insuree.getPersonFIOshort() + " " + insuree.getBornDate() + " " + insuree.getInsurancePrice());
        }
    }

    // Console output
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Контракт № " + number + ":" + System.lineSeparator());
        result.append("дата заключения - " + getAgreeDate() + System.lineSeparator());
        result.append("действует с " + getStartDate() + " по " + getStopDate() + System.lineSeparator());
        // Here is the information expert pattern
        result.append(client.toString() + System.lineSeparator());
        result.append("общая сумма - ");
        return result.toString();
    }
}
