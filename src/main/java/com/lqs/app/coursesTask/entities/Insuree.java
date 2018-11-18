package com.lqs.app.coursesTask.entities;

import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import lombok.*;

public class Insuree extends BasicPerson {
    private Date bornDate;
    @Getter @Setter private float insurancePrice;
    @Getter @Setter private long personINN;
    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    //@Getter private static String simpleFieldsMapping = "personFIO,bornDate,insurancePrice,stopDate";

    public static Comparator<Insuree> compareNames = new Comparator<Insuree>(){
        public int compare(Insuree a, Insuree b){
            return a.getPersonFIO().compareTo(b.getPersonFIO());
        }
    };
    public static Comparator<Insuree> compareBornDates = new Comparator<Insuree>(){
        public int compare(Insuree a, Insuree b){
            return a.bornDate.compareTo(b.bornDate);
        }
    };

    public Insuree(String personFIO, String bornDate, float insurancePrice, long personINN){
        super(personFIO);
        this.setBornDate(bornDate);
        this.insurancePrice = insurancePrice;
        this.personINN = personINN;
    }

    public String getBornDate() {
        return "" + dateFormat.format(bornDate);
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
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
        if(words.length == 3) {
            result.append(words[0] + ' ' + words[1].charAt(0) + ". " + words[2].charAt(0) + '.');
        }
        else{
            result.append(getPersonFIO());
        }

        return result.toString();
    }
}
