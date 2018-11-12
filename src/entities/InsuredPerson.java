package entities;

import java.text.DateFormat;
import java.util.Date;

public class InsuredPerson extends BasicPerson {
    private Date bornDate;
    private float insurancePrice;
    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    private long personINN;

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
        StringBuilder result = new StringBuilder(this.getPersonFIO());

        return result.toString();
    }
}
