package entities;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Contract {
    //fields--------------------------------------------------------------------------------
    private int number;
    // Даты хранятся с типом "дата", но доступ
    // происходит через строковые значения
    private Date agreeDate;
    private Date startDate;
    private Date stopDate;
    private Client client;
    private ArrayList<InsuredPerson> insuredPersons;
    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);

    //constructor---------------------------------------------------------------------------
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

    //getters & setters--------------------------------------------------------------------
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // Даты выдаются в виде строк
    public String getAgreeDate() {
        return "" + dateFormat.format(agreeDate);
    }

    // И принимаются тоже
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

    public String getClientFIO() {
        return client.getPersonFIO();
    }

    public String getClientType() {
        return client.getClientType();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Добавление элементов в список
    // застрахованных лиц
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

    // Подсчет общей суммы страховки--------------------------------------------------------
    public float getTotalPrice(){
        float sum = 0;
        for(InsuredPerson insuredPerson : insuredPersons){
            sum += insuredPerson.getInsurancePrice();
        }
        return sum;
    }

    // Вывод информации в консоль
    public void writeInConsole(){
        System.out.println("Контракт № " + number + ":");
        System.out.println("дата заключения - " + getAgreeDate());
        System.out.println(
            "действует с " +
            getStartDate() +
            " по " +
            getStopDate()
        );
        // Часть, связанная с клиентом, ревлизована в соответствующем классе
        client.writeInConsole();
        System.out.println("общая сумма - " + getTotalPrice());
    }
}
