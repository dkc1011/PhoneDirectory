package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayBasedPD implements PhoneDirectory {
    // phone directory and related items
    private final int MAXENTRIES = 200; // maximum number of entries in phone directory
    private PhoneDirectoryEntry[] phoneDirectory = new PhoneDirectoryEntry[MAXENTRIES];
    private int numberOfEntries = 0; // number of entries
    private int startingNumberOfEntries;
    private int currentEntry = -1; //index of entry currently displayed

    public void loadData(String filename) {
        // TODO Auto-generated method stub
        try {
            File inputFile = new File(filename);
            Scanner in = new Scanner(inputFile);
            System.out.println(inputFile.canRead());
            String name;
            String number;
            int index = 0;

            while (in.hasNext()){
                name = in.next();
                number = in.next();
                phoneDirectory[index] = new PhoneDirectoryEntry(name, number);
                index++;
            }

            numberOfEntries = index;
            startingNumberOfEntries = numberOfEntries;
            //now call Arrays.sort() to sort phoneDirectory
            sortArray();

            in.close();

        } catch (IOException exc) {
            System.out.println("Details file does not exist");
        }
    }

    private void sortArray()
    {
        Arrays.sort(phoneDirectory, 0, numberOfEntries);
    }

    public void saveData(String filename) {
        // TODO Auto-generated method stub
        if(numberOfEntries > startingNumberOfEntries)
        {
            for (int i=numberOfEntries-startingNumberOfEntries; i<numberOfEntries; i++)
            {
                try {
                    usingPrintWriter(phoneDirectory[i].getName());
                    usingPrintWriter(phoneDirectory[i].getNumber());
                }
                catch (IOException e)
                {
                    System.out.println("was not added");
                }

            }
        }

    }

    public static void usingPrintWriter(String appendText) throws IOException
    {
        FileWriter fileWriter = new FileWriter("details.txt", true); //Set true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(appendText);  //New line
        printWriter.close();
    }

    public void addEntry(String name, String number) {
        // TODO Auto-generated method stub

        PhoneDirectoryEntry newEntry = new PhoneDirectoryEntry(name, number);
        phoneDirectory[numberOfEntries] = newEntry;
        numberOfEntries++;
        sortArray();
    }

    public PhoneDirectoryEntry getFirst() {
        // TODO Auto-generated method stub
        if (numberOfEntries != 0) {
            currentEntry = 0;
            return phoneDirectory[0];
        } else
            return null;
    }

    public PhoneDirectoryEntry getNext() {
        // TODO Auto-generated method stub
        if (currentEntry != numberOfEntries - 1) {
            currentEntry++;
            return phoneDirectory[currentEntry];
        } else
            return null;

    }

    public PhoneDirectoryEntry getPrevious() {
        // TODO Auto-generated method stub
        if (currentEntry != 0)
        {
            currentEntry--;
            return phoneDirectory[currentEntry];
        }
        else {
            return null;
        }
    }

    public String search(String name) {
        // TODO Auto-generated method stub

        PhoneDirectoryEntry temporary = new PhoneDirectoryEntry(name, "0");

        int result = Arrays.binarySearch(phoneDirectory, 0, numberOfEntries, temporary);

        if (result < 0) {
            return "Name \"" + name + "\" was not found.";
        } else {
            return phoneDirectory[result].getNumber();
        }
    }
}
