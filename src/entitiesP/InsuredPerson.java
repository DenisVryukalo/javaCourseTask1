package entitiesP;

import java.util.Date;

public class InsuredPerson extends BasicPerson {
    private Date bornDate;
    private float insurancePrice;

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public float getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(float insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    InsuredPerson(String personFIO, Date bornDate, float insurancePrice){
        super(personFIO);
        this.bornDate = bornDate;
        this.insurancePrice = insurancePrice;
    }
}
