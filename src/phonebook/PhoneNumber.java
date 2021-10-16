package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneNumber {
    private String number;
    public PhoneNumber(String number){
        this.number = number;
    }
    public String getAreaCode(){
        return number.substring(1,4);
    }
    public String getExchange(){
        return number.substring(5,8);
    }
    public String getLineNumber(){
        return number.substring(9);
    }
    public boolean isTollFree(){
        return number.charAt(1) == '8';
    }
    public String toString(){
        return number;
    }
    public boolean equals(PhoneNumber obj){
        return (this.number).equals(obj.number);
    }
    public static PhoneNumber read(Scanner scan){
        if(!scan.hasNext()) return null;
        String number = scan.next();
        return new PhoneNumber(number);
    }

}

