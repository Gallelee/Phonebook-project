package phonebook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookEntry {
    private Name name;
    private ExtendedPhoneNumber phoneNumber;
    private ArrayList<ExtendedPhoneNumber> list;
    public PhonebookEntry(Name name, ExtendedPhoneNumber phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;

    }
    public PhonebookEntry(Name name, ArrayList<ExtendedPhoneNumber> list){
        this.name = name;
        this.list = list;
    }
    public Name getName(){
        return this.name;
    }
    public PhoneNumber getPhoneNumber(){
        return this.phoneNumber;
    }
    public void call(){
        if(!(phoneNumber.isTollFree())) {
            System.out.println("Dialing " + name.toString() + ":" + " " + phoneNumber.toString());
        }
        if(phoneNumber.isTollFree()){
            System.out.println("Dialing (toll-free) "+name.toString()+":"+" "+phoneNumber.toString());
        }
    }
    public String toString(){
        return ""+list;
    }
    public boolean equals(PhonebookEntry phonebook){

        return this.name.equals(phonebook.name) && this.phoneNumber.equals(phonebook.phoneNumber);
    }
     public static PhonebookEntry read(Scanner scan){
        Name name = Name.read(scan);
        int amount = scan.nextInt();
        ArrayList<ExtendedPhoneNumber> entries = new ArrayList<ExtendedPhoneNumber>();
        while (amount>0) {
            ExtendedPhoneNumber numbers = ExtendedPhoneNumber.read(scan);
            entries.add(numbers);
            amount--;
        }
        return new PhonebookEntry(name,entries);
     }


}
