package phonebook;

import java.util.Scanner;

public class ExtendedPhoneNumber extends PhoneNumber {
    private String description;
    public ExtendedPhoneNumber(String number,String description){
        super(number);
        this.description=description;
    }
    public static ExtendedPhoneNumber read(Scanner scan){
        if(!scan.hasNext()) return null;
        String description = scan.next();
        String number = scan.next();
        return new ExtendedPhoneNumber(number, description);

    }
    public String toString(){
        return description+": "+super.toString();
    }
    public boolean equals(ExtendedPhoneNumber obj){
        if(super.equals(obj)&&description.equals(obj.description)) return true;
        return false;
    }

}
