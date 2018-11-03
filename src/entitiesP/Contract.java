package entitiesP;

import java.util.Date;
import java.util.ArrayList;

public class Contract {
    private int number;
    private Date agreeDate;
    private Date startDate;
    private Date stopDate;
    private Client client;
    private ArrayList<InsuredPerson> insuredPersons;

    public Contract(
        int number,
        Date agreeDate,
        Date startDate,
        Date stopDate,
        Client client,
        ArrayList<InsuredPerson> insuredPersons
    ) {
      this.number = number;
      this.agreeDate = agreeDate;
      this. startDate = startDate;
      this.stopDate = stopDate;
      this.client = client;
      this.insuredPersons = insuredPersons;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getAgreeDate() {
        return agreeDate;
    }

    public void setAgreeDate(Date agreeDate) {
        this.agreeDate = agreeDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public Client getClient() {
        return client;
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

    public float mainPrice(){
        float sum = 0;
        for(InsuredPerson insuredPerson : insuredPersons){
            sum += insuredPerson.getInsurancePrice();
        }
        return sum;
    }
}
