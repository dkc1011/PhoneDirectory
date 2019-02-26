package com.company;

public interface PhoneDirectory {
    void loadData(String filename);
    void saveData(String filename);
    void addEntry(String name, String number);
    PhoneDirectoryEntry getFirst();  //gets the first entry in the directory
    PhoneDirectoryEntry getNext();//gets the next entry 
    PhoneDirectoryEntry getPrevious(); //gets the previous entry
    String  search(String name);
}
