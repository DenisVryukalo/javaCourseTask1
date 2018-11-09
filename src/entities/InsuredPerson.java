package entities;

import java.text.DateFormat;
import java.util.Date;

public class InsuredPerson extends BasicPerson {
    private Date bornDate;
    private float insurancePrice;
    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);

    public InsuredPerson(String personFIO, String bornDate, float insurancePrice){
        super(personFIO);
        this.setBornDate(bornDate);
        this.insurancePrice = insurancePrice;
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
        }catch(java.text.ParseException e){
            System.out.println("wrong date format: " + bornDate);
        }finally {

        }
    }
}
