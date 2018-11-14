package com.lqs.app.coursesTask.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContractTest {

    @Test
    public void getTotalPrice() {
        Client client = new Client(ClientType.PRIVATE_PERSON, "A B C", "XXX");
        Contract contract = new Contract(1,"01.01.2019", "02.01.2019", "03.01.2019", client);

        Assert.assertEquals((int)0, (int)contract.getTotalPriceByIterator());
        Assert.assertEquals((int)0, (int)contract.getTotalPriceForeach());

        contract.addInsuredPerson(new InsuredPerson("Вовк Максим Дмитриевич", "04.05.1998", 24000, 2457656486558L));
        contract.addInsuredPerson(new InsuredPerson("Гришко Валерий Артурович", "22.01.1998", 25000, 36582343487696L));
        contract.addInsuredPerson(new InsuredPerson("Врюкало Денис Максимович", "07.09.1998", 24000, 257365847356L));

        Assert.assertEquals(73000, (int)contract.getTotalPriceByIterator());
        Assert.assertEquals(73000, (int)contract.getTotalPriceForeach());
    }
}