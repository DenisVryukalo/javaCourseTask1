package startP;

import entitiesP.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Cstart {
    public static void main(String[] args){
        test1();
    }

    public static void writeContract(Contract contract){
        System.out.println("Контракт № " + contract.getNumber() + ":");
        System.out.println("дата заключения - " + contract.getAgreeDate());
        System.out.println(
            "действует с " +
            contract.getStartDate() +
            " по " +
            contract.getStopDate()
        );
        System.out.println("клиент - " + contract.getClient());
        System.out.println("общая сумма - " + contract.getTotalPrice());
    }

    public static void test1(){
        Client client1 = new Client(
                "Врюкало Денис Максимович",
                "Харьков, ул. Цветочная, д. 15"
        );

        SimpleDateFormat dateFormat  = new SimpleDateFormat("dd/mm/yyyy");
        Contract contract1 = new Contract(
                1,
                "01.11.2018",
                "15.11.2018",
                "01.02.2019",
                client1,
                new ArrayList<InsuredPerson>()
        );

        contract1.addInsuredPerson(new InsuredPerson("Вовк Максим Дмитриевич", "04.05.1998", 24000));
        contract1.addInsuredPerson(new InsuredPerson("Лисовская Виктория Валериевна", "02.08.1999", 25000));

        writeContract(contract1);
    }
}
