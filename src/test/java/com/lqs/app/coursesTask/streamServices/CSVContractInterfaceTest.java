package com.lqs.app.coursesTask.streamServices;

import com.lqs.app.coursesTask.entities.Contract;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CSVContractInterfaceTest {

    @Test
    public void readCorrect() {
        ArrayList<Contract> contracts = null;
        contracts = CSVContractInterface.read("test_files\\input_test.csv");
        Assert.assertEquals(2, contracts.size());
        Assert.assertEquals(1, contracts.get(0).getNumber());
        Assert.assertEquals(2, contracts.get(1).getNumber());
        Assert.assertEquals("03.01.19", contracts.get(1).getAgreeDate());
        Assert.assertEquals("Pupkin V. V.", contracts.get(1).getClientFIO());
        Assert.assertEquals(30, (int)contracts.get(0).getTotalPriceForeach());
    }

    @Test
    public void readNotExisting() {
        ArrayList<Contract> contracts = null;
        contracts = CSVContractInterface.read("test_files\\not_existing_file.csv");
        Assert.assertEquals(0, contracts.size());
    }

    @Test
    public void readWrongFormat() {
        ArrayList<Contract> contracts = null;
        contracts = CSVContractInterface.read("test_files\\wrong_format_test.txt");
        Assert.assertEquals(0, contracts.size());
    }

    @Test
    public void readWrongDataFormat() {
        ArrayList<Contract> contracts = null;
        contracts = CSVContractInterface.read("test_files\\wrong_data_format_test.csv");
        Assert.assertEquals(0, contracts.size());
    }
}