package start;

import entities.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Start {
    public static void main(String[] args){
        test1();
    }

    // Object for data formatting
    public static SimpleDateFormat dateFormat  = new SimpleDateFormat("dd/mm/yyyy");

    // Example of classes' work
    public static void test1(){
        Client client1 = new Client(
                ClientType.PRIVATE_PERSON,
                "Врюкало Денис Максимович",
                "Харьков, ул. Цветочная, д. 15"
        );

        Contract contract1 = new Contract(
                1,
                "01.11.2018",
                "15.11.2018",
                "01.02.2019",
                client1,
                new ArrayList<InsuredPerson>()
        );

        contract1.addInsuredPerson(new InsuredPerson(
                "Вовк Максим Дмитриевич",
                "04.05.1998",
                24000,
                2457656486558L)
        );
        contract1.addInsuredPerson(new InsuredPerson(
                "Лисовская Виктория Валериевна",
                "02.08.1999",
                25000,
                36582343487696L
        ));


        Client client2 = new Client(
                ClientType.JURISTIC_PERSON,
                "ООО Секрет",
                "Харьков, ул. Танкопия, д. 102"
        );

        Contract contract2 = new Contract(
                2,
                "02.11.2018",
                "14.11.2018",
                "13.02.2019",
                client2,
                new ArrayList<InsuredPerson>()
        );

        contract2.addInsuredPerson(new InsuredPerson(
                "Врюкало Денис Максимович",
                "07.09.1998",
                2400,
                257365847356L));

        System.out.println(contract1.toString());
        System.out.println();
        System.out.println(contract2.toString());
    }
}