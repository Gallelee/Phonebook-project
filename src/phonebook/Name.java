package phonebook;

import java.util.Scanner;

public class Name implements Comparable<Name>{
    private String first;
    private String last;

    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }
    public String getFormal(){
        return first+" "+last;
    }
    public String getOfficial(){
        return last+", "+first;
    }
    public boolean equals(Name input){
        return (first.equals(input.first)&&last.equals(input.last));
    }
    public String toString(){
        return first+" "+last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
    public static Name read(Scanner scanner){ //reads in the last then first name in either a file or through the keyboard and then returns a new Name object
        if(!scanner.hasNext()) return null;
        String last = scanner.next();
        String first = scanner.next();
        return new Name(first,last);
    }
    public String getInitials(){
        return first.charAt(0)+"."+last.charAt(0)+".";
    }

    @Override
    public int compareTo(Name o) {
        if(equals(o)) return 0;
        return 1;
    }
}
