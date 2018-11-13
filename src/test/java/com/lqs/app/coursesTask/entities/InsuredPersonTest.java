package com.lqs.app.coursesTask.entities;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class InsuredPersonTest {

    @Test
    public void getBornDate() {
        InsuredPerson insuree = new InsuredPerson("Vriukalo Denys Maksymovych", "07.09.98", 1345, 1256);
        Assert.assertEquals("07.09.98", insuree.getBornDate());
    }

    @Test
    public void getPersonFIOshort() {
        InsuredPerson insuree = new InsuredPerson("Vriukalo Denys Maksymovych", "07.09.98", 1345, 1256);
        insuree.getPersonFIOshort();
        Assert.assertEquals("Vriukalo D. M.", insuree.getPersonFIOshort());
    }
}