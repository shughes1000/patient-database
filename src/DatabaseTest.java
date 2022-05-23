import java.util.Scanner;

public class DatabaseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // prompt user for file
        System.out.print("Enter the file input: ");
        String readFile = sc.nextLine();

        System.out.println(readFile);

        System.out.println("There are " + PatientDatabase.get_length(readFile) + " entries.");
        // PatientDatabase.read_entry(readFile, "Mata", "1984-6-12");

        Patient pat = new Patient("Ramen", "Noodles", "69 UConn St", "18008008000",
                "1899-12-12", "PRIVATE", 300F, "ADULT", "Ur Mom",
                "18998998999", "NONE", "DIABETES");
        PatientDatabase.append_entry(readFile, pat);
        // System.out.println("Just added another entry.");
        System.out.println("There are now " + PatientDatabase.get_length(readFile) + " entries.");

/*
        PatientDatabase.delete_entry(readFile, "Cope", "1984-9-22");
        System.out.println("Just deleted an entry.");
        System.out.println("There are now " + PatientDatabase.get_length(readFile) + " entries.");
*/

//        PatientDatabase.replace_entry(readFile, "Cope", "1984-9-22", pat);
//        System.out.println("Just replaced an entry.");
//        System.out.println("There are now " + PatientDatabase.get_length(readFile) + " entries.");
//
//        System.out.println();
//        PatientDatabase.summarise(readFile, "insurance type", "Government");


        // PatientDatabase.modify_single(readFile, "Mata", "1984-6-12", "PHONE", "81934835");
        // System.out.println("Changed Mata's phone number");




    }
}
