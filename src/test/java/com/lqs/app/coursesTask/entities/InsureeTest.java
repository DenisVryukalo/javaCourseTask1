package com.lqs.app.coursesTask.entities;

import org.junit.Assert;
import org.junit.Test;

public class InsureeTest {

    @Test
    public void getPersonFIOshort1() {
        Insuree insuree = new Insuree("Vriukalo Denys Maksymovych", "", 0, 0);
        insuree.getPersonFIOshort();
        Assert.assertEquals("Vriukalo D. M.", insuree.getPersonFIOshort());
    }
}