package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Phonebook {
    public static void main(String[] args) throws Exception {
        try {
            String filename;
            String filenamePlaceholder;
            if(args.length==1) {
                filenamePlaceholder = Arrays.toString(args);
                filename = filenamePlaceholder.substring(1, filenamePlaceholder.length() - 1);
            }
            else{
                filename = "DefaultPhoneBook.txt";
            }
            Scanner scan = new Scanner(new File(filename));
            Scanner keyboard = new Scanner(System.in);
            Map<Name, PhonebookEntry> map = new TreeMap<Name, PhonebookEntry>();
            PhonebookEntry entry;
            while (scan.hasNext()) {
                entry = PhonebookEntry.read(scan);
                map.put(entry.getName(), entry);
            }
            System.out.print("lookup, quit (l/q)? ");
            while (keyboard.hasNext()) {
                String selection = keyboard.next();
                String first, last;
                char comp = selection.charAt(0);
                if (comp == 'l') {
                    System.out.print("last name? ");
                    last = keyboard.next();
                    System.out.print("first name? ");
                    first = keyboard.next();
                    if (map.get(new Name(first, last)) == null) {
                        System.out.println("-- Name not found");
                    } else {
                        System.out.println(first + " " + last + "'s phone numbers: " + map.get(new Name(first, last)));
                    }
                } else if (comp == 'q') {
                    System.exit(0);
                }
                System.out.println();
                System.out.print("lookup, quit (l/q)? ");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Usage: PhonebookApp 'phonebook-filename'");
        }
        catch(InputMismatchException e){
            System.out.println("Please check your inputs to prompts again and check for proper form");
        }

    }

}
