package entitiesP;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Contract {
    private int number;
    private Date agreeDate;
    private Date startDate;
    private Date stopDate;
    private Client client;
    private ArrayList<InsuredPerson> insuredPersons;
    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);

    public Contract(
        int number,
        String agreeDate,
        String startDate,
        String stopDate,
        Client client,
        ArrayList<InsuredPerson> insuredPersons
    ) {
      this.number = number;
      this.setAgreeDate(agreeDate);
      this.setStartDate(startDate);
      this.setStopDate(stopDate);
      this.client = client;
      this.insuredPersons = insuredPersons;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAgreeDate() {
        return "" + dateFormat.format(agreeDate);
    }

    public void setAgreeDate(String agreeDate) {
        try {
            this.agreeDate = dateFormat.parse(agreeDate);
        }catch(java.text.ParseException e){
            System.out.println("wrong date format: " + agreeDate);
        }finally {

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
        }finally {

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
        }finally {

        }
    }

    public String getClient() {
        return client.getPersonFIO();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean addInsuredPerson(InsuredPerson insuredPerson){
        insuredPersons.add(insuredPerson);
        return true;
    }

    public InsuredPerson getInsuredPersonByNum(int num){
        if(insuredPersons.size() < num){
            return null;
        }
        else{
            return insuredPersons.get(num);
        }
    }

    public InsuredPerson getInsuredPersonByFIO(String personFIO){
        for(InsuredPerson currentPerson : insuredPersons){
            if(currentPerson.getPersonFIO() == personFIO){
                return currentPerson;
            }
        }
        return null;
    }

    public float getTotalPrice(){
        float sum = 0;
        for(InsuredPerson insuredPerson : insuredPersons){
            sum += insuredPerson.getInsurancePrice();
        }
        return sum;
    }
}
