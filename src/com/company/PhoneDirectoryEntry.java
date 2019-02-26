package com.company;

public class PhoneDirectoryEntry implements Comparable<PhoneDirectoryEntry>
{
   private String name;
   private String number;

   public PhoneDirectoryEntry(String s, String n)
   {
      name = s;
      number = n;
   }

   public String getName()
   {
      return name;
   }

   public String getNumber()
   {
      return number;
   }

   public int compareTo(PhoneDirectoryEntry pde)
   {
      return this.getName().compareTo(pde.getName());
   }
}