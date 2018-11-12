package entities;

import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Contract {
    private int number;
    // Dates are stored with the type "Date", but
    // access is implemented by string values
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
        return client.getClientType();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Filling the list of insured persons9
    public boolean addInsuredPerson(InsuredPerson insuredPerson){
        insuredPersons.add(insuredPerson);
        return true;
    }

    //Получение элементов списка по номеру и по ФИО
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

    // Console output
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Контракт № " + number + ":" + "\n");
        result.append("дата заключения - " + getAgreeDate() + "\n");
        result.append("действует с " + getStartDate() + " по " + getStopDate() + "\n");
        // Here is the information expert pattern
        result.append(client.toString() + "\n");
        result.append("общая сумма - " + getTotalPrice() + "\n");
        return result.toString();
    }
}
