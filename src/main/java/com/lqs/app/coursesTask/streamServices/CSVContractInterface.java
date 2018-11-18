package com.lqs.app.coursesTask.streamServices;

import com.lqs.app.coursesTask.entities.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVContractInterface {
    public static ArrayList<Contract> read(String path) throws IllegalArgumentException{
        ArrayList<Contract> contracts = new ArrayList<Contract>();

        String[] separatedPath= path.split("\\.");
        if (separatedPath.length < 2){
            System.out.println("Here is not a file: " + path);
            return contracts;
        }
        /*
        String fileFormat = separatedPath[separatedPath.length - 1];
        if (fileFormat  != "csv"){
            System.out.println(fileFormat + " format found, csv expected.");
            return contracts;
        }*/

        BufferedReader br = null;
        String[] line;

        try {
            br = new BufferedReader(new FileReader(path));
            String solidLine;
            readCycle: while ((solidLine = br.readLine()) != null) {
                line=solidLine.split(",");
                if(line.length < 7){
                    continue readCycle;
                }

                ClientType type = null;
                switch (line[4].toUpperCase()) {
                    case "J":
                        type = ClientType.JURISTIC_PERSON;
                        break;
                    case "P":
                        type = ClientType.PRIVATE_PERSON;
                        break;
                    default:
                        System.out.println("Invalid client type pseudonym: " + line[4]);
                        continue readCycle;
                }
                Client client = new Client(type, line[5], line[6]);

                ArrayList<Insuree> insurees = new ArrayList<Insuree>();

                int currInsureePos = 7;
                for (int i = 0; i < (line.length - 7) / 4; i++) {
                        currInsureePos = 7 + i*4;
                        insurees.add(new Insuree(line[currInsureePos], line[currInsureePos+1], Float.parseFloat(line[currInsureePos+2]), Long.parseLong(line[currInsureePos+3])));
                }

                contracts.add(new Contract(Integer.parseInt(line[0]), line[1], line[2], line[3], client, insurees));
            }

        } catch (FileNotFoundException e) {
            System.out.println("No file with path: " + path);
        } catch (IOException e) {
            System.out.println("Some input went wrong:");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return contracts;
    }
}
