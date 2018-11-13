package com.lqs.app.coursesTask.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContractTest {

    @Test
    public void getTotalPriceIterator() {
        Client client = new Client(ClientType.PRIVATE_PERSON, "A B C", "XXX");
        Contract contract = new Contract(1,"01.01.2019", "02.01.2019", "03.01.2019", client, null);
        //Here is no insurees
        Assert.assertEquals((int)0, (int)contract.getTotalPriceIterator());
    }
}