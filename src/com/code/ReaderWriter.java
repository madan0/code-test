package com.code;

import java.util.*;
import java.io.*;

/*
Utility class to read and write from file
 */
public class ReaderWriter {

    public static List<String> readData(String fileName) {
        List<String> inputData = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (!line.isEmpty()) {
                    String pincodes = line.substring(1, line.length() - 1);
                    inputData.addAll(Arrays.asList(pincodes.split("]\\s*\\[")));
                }
            }
        } catch (IOException e) {
            System.out.println("IO error in input.txt");
        }
        return inputData;
    }

    public static List<Range> convertToPinCodeRangeList(List<String> inputData) {
        List<Range> rangeList = new ArrayList<>();
        for (String pincodes : inputData) {
            rangeList.add(new Range(
                    Integer.parseInt(pincodes.substring(0, pincodes.indexOf(','))),
                    Integer.parseInt(pincodes.substring(pincodes.indexOf(',') + 1, pincodes.length()))));

        }
        Collections.sort(rangeList);
        return rangeList;
    }


    public static void writeData(List<Range> outputData, String fileName) {
        try {
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            output.println("" + outputData.toString().substring(1, outputData.toString().length() - 1).replaceAll("],\\s*\\[", "] ["));
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in output.txt");
        }
    }

}

