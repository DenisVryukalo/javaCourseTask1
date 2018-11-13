package com.lqs.app.coursesTask.entities;

import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;

public class InsuredPerson extends BasicPerson {
    private Date bornDate;
    private float insurancePrice;
    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    private long personINN;

    public static Comparator<InsuredPerson> compareNames = new Comparator<InsuredPerson>(){
        public int compare(InsuredPerson a, InsuredPerson b){
            return a.getPersonFIO().compareTo(b.getPersonFIO());
        }
    };
    public static Comparator<InsuredPerson> compareBornDates = new Comparator<InsuredPerson>(){
        public int compare(InsuredPerson a, InsuredPerson b){
            return a.bornDate.compareTo(b.bornDate);
        }
    };

    public InsuredPerson(String personFIO, String bornDate, float insurancePrice, long personINN){
        super(personFIO);
        this.setBornDate(bornDate);
        this.insurancePrice = insurancePrice;
        this.personINN = personINN;
    }

    public long getPersonINN() {
        return personINN;
    }

    public void setPersonINN(long personINN) {
        this.personINN = personINN;
    }

    public String getBornDate() {
        return "" + dateFormat.format(bornDate);
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public float getInsurancePrice() {
        return insurancePrice;
    }

    public void setBornDate(String bornDate) {
        try {
            this.bornDate = dateFormat.parse(bornDate);
        }catch(java.text.ParseException e) {
            System.out.println("wrong date format: " + bornDate);
        }
    }

    public String getPersonFIOshort(){
        StringBuilder result = new StringBuilder();
        String[] words = getPersonFIO().split(" ");
        result.append(words[0] + ' ' + words[1].charAt(0) + ". " + words[2].charAt(0) + '.');

        return result.toString();
    }
}
