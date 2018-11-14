package com.lqs.app.coursesTask.start;

import com.lqs.app.coursesTask.entities.*;

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
                "Гришко Валерий Артурович",
                "22.01.1998",
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
                257365847356L
        ));

        System.out.println(contract1.toString());
        System.out.println();
        System.out.println(contract2.toString());

        System.out.println("Сортировка по ФИО:");
        contract1.printInsureesByAlphabet();
        System.out.println("\nСортировка по дате рождения:");
        contract1.printInsureesByBornDate();

        System.out.println("\nДата рождения застрахованного лица Вовк Максим Дмитриевич:");
        System.out.println(contract1.getInsuredPersonByFIO("Вовк Максим Дмитриевич").getBornDate());
    }
}