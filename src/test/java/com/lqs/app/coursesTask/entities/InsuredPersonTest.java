package com.lqs.app.coursesTask.entities;

import org.junit.Assert;
import org.junit.Test;

public class InsuredPersonTest {

    @Test
    public void getPersonFIOshort1() {
        InsuredPerson insuree = new InsuredPerson("Vriukalo Denys Maksymovych", "", 0, 0);
        insuree.getPersonFIOshort();
        Assert.assertEquals("Vriukalo D. M.", insuree.getPersonFIOshort());
    }
}