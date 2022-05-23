import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientDatabase {

    public static String file_name() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file input: ");
        String readFile = sc.nextLine();

        return readFile;
    }

    // get length of file
    public static int get_length(String readFile) {
        BufferedReader reader;
        int num_patients = 0;
        try {
            reader = new BufferedReader(new FileReader(readFile));

            // read each line of file
            String line = reader.readLine();

            // increment
            int num_lines = 0;
            while (line != null) {
                line = reader.readLine();
                num_lines = num_lines + 1;
            }
            reader.close();

            // each patient has 12 lines of info so divide by 12 to get number of patients
            num_patients = num_lines / 12;
            // System.out.println("There are " + num_patients + " patients.");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return num_patients;
    }

    // find specific entry and print entry info
    public static String[] read_entry(String readFile, String last, String bd) {
        int fileLength = get_length(readFile);

        try {
            int i = 0;
            int check = 0;
            while(i < fileLength) {
                String read_last = Files.readAllLines(Paths.get(readFile)).get(i*12 + 1);
                String read_bd = Files.readAllLines(Paths.get(readFile)).get(i*12 + 4);

                // triggers if we found the correct patient
                if(read_last.equals(last) & read_bd.equals(bd)) {
                    // store info in variables
                    String read_first = Files.readAllLines(Paths.get(readFile)).get(i*12);
                    String read_add = Files.readAllLines(Paths.get(readFile)).get(i*12 + 2);
                    String read_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 3);
                    String read_ins = Files.readAllLines(Paths.get(readFile)).get(i*12 + 5);
                    String read_copay = Files.readAllLines(Paths.get(readFile)).get(i*12 + 6);
                    String read_type = Files.readAllLines(Paths.get(readFile)).get(i*12 + 7);
                    String read_phys_name = Files.readAllLines(Paths.get(readFile)).get(i*12 + 8);
                    String read_phys_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 9);
                    String read_aller = Files.readAllLines(Paths.get(readFile)).get(i*12 + 10);
                    String read_ill = Files.readAllLines(Paths.get(readFile)).get(i*12 + 11);

                    // print info
                    System.out.println("First: " + read_first + "\nLast: " + read_last + "\nAddress: " + read_add
                            + "\nPhone: " + read_phone + "\nBirthday: " + bd + "\nInsurance: " + read_ins + "\nCopay: " + read_copay
                            + "\nType: " + read_type + "\nPhysician Name: " + read_phys_name + "\nPhysician Phone: "
                            + read_phys_phone + "\nAllergies" + read_aller + "\nIllness: " + read_ill);

                    String[] patient_info = {read_first, read_last, read_add, read_phone, bd, read_ins, read_copay,
                            read_type, read_phys_name, read_phys_phone, read_aller, read_ill};

                    check = check + 1;

                    return patient_info;
                }

                i = i + 1;
            }

            // warn user of abnormalities
            if(check == 0) {
                System.out.println("Warning: Did not find the specified patient. ");
            }
            if(check > 1) {
                System.out.println("Warning: Found more than one specified patient. ");
            }

        } catch (IOException e) {
            // this should catch errors with the file
            e.printStackTrace();
            System.exit(0);
        }


        return new String[0];
    }

    // appends new entry to end of file
    public static void append_entry(String readFile, Patient p) {
        String first = p.getFirst();
        String last = p.getLast();
        String add = p.getAddress();
        String phone = p.getPhone();
        String bd = p.getBirthday();
        String ins = String.valueOf(p.getInsurance());
        String copay = String.valueOf(p.getCopay());
        String type = String.valueOf(p.getType());
        String phys_name = p.MC.getPhysician();
        String phys_phone = p.MC.getPhysicianPhone();
        String aller = String.valueOf(p.MC.getAllergies());
        String ill = String.valueOf(p.MC.getIllnesses());

        int fileLength = get_length(readFile);

        try {
            if(fileLength == 0) {
                Files.write(Paths.get(readFile), (first).getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(Paths.get(readFile), ("\n" + first).getBytes(), StandardOpenOption.APPEND);
            }
            Files.write(Paths.get(readFile), ("\n" + last).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + add).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + phone).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + bd).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + ins).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + copay).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + type).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + phys_name).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + phys_phone).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + aller).getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(readFile), ("\n" + ill).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void delete_entry(String readFile, String last, String bd) {
        int fileLength = get_length(readFile);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(readFile));

            File tempFile = new File("myTempFile.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            int i = 0;
            int check = 0;
            while (i < fileLength) {
                String read_last = Files.readAllLines(Paths.get(readFile)).get(i * 12 + 1);
                String read_bd = Files.readAllLines(Paths.get(readFile)).get(i * 12 + 4);

                // triggers if we found the correct patient
                if (read_last.equals(last) & read_bd.equals(bd)) {
                    // skip over these lines because we are removing this patient
                    check = check + 1;
                } else {
                    // store info in variables
                    String read_first = Files.readAllLines(Paths.get(readFile)).get(i*12);
                    String read_add = Files.readAllLines(Paths.get(readFile)).get(i*12 + 2);
                    String read_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 3);
                    String read_ins = Files.readAllLines(Paths.get(readFile)).get(i*12 + 5);
                    String read_copay = Files.readAllLines(Paths.get(readFile)).get(i*12 + 6);
                    String read_type = Files.readAllLines(Paths.get(readFile)).get(i*12 + 7);
                    String read_phys_name = Files.readAllLines(Paths.get(readFile)).get(i*12 + 8);
                    String read_phys_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 9);
                    String read_aller = Files.readAllLines(Paths.get(readFile)).get(i*12 + 10);
                    String read_ill = Files.readAllLines(Paths.get(readFile)).get(i*12 + 11);

                    // write new info to temporary file
                    if(i != check) {
                        writer.write(System.getProperty("line.separator"));
                    }
                    writer.write(read_first + System.getProperty("line.separator"));
                    writer.write(read_last + System.getProperty("line.separator"));
                    writer.write(read_add + System.getProperty("line.separator"));
                    writer.write(read_phone + System.getProperty("line.separator"));
                    writer.write(read_bd + System.getProperty("line.separator"));
                    writer.write(read_ins + System.getProperty("line.separator"));
                    writer.write(read_copay + System.getProperty("line.separator"));
                    writer.write(read_type + System.getProperty("line.separator"));
                    writer.write(read_phys_name + System.getProperty("line.separator"));
                    writer.write(read_phys_phone + System.getProperty("line.separator"));
                    writer.write(read_aller + System.getProperty("line.separator"));
                    writer.write(read_ill);
                }
                i = i + 1;
            }
            writer.close();
            reader.close();
            File old = new File(readFile);
            old.delete();
            tempFile.renameTo(new File(readFile));

            // warn user of abnormalities
            if(check == 0) {
                System.out.println("Warning: Did not find the specified patient. ");
            }
            if(check > 1) {
                System.out.println("Warning: Found more than one specified patient. ");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    // replaces entry with new info
    public static void replace_entry(String readFile, String last, String bd, Patient p) {
        String first = p.getFirst();
        String new_last = p.getLast();
        String add = p.getAddress();
        String phone = p.getPhone();
        String new_bd = p.getBirthday();
        String ins = String.valueOf(p.getInsurance());
        String copay = String.valueOf(p.getCopay());
        String type = String.valueOf(p.getType());
        String phys_name = p.MC.getPhysician();
        String phys_phone = p.MC.getPhysicianPhone();
        String aller = String.valueOf(p.MC.getAllergies());
        String ill = String.valueOf(p.MC.getIllnesses());

        if(!bd.equals(new_bd)) {
            System.out.println("Warning: The new birthdate does not match the previous birthdate. " +
                    "However, the birthdate is not allowed to be updated. " +
                    "Therefore, the old birthdate will remain in the database.");
        }


        int fileLength = get_length(readFile);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(readFile));

            File tempFile = new File("myTempFile.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            int i = 0;
            int check = 0;
            while (i < fileLength) {
                String read_last = Files.readAllLines(Paths.get(readFile)).get(i * 12 + 1);
                String read_bd = Files.readAllLines(Paths.get(readFile)).get(i * 12 + 4);

                // triggers if we found the correct patient
                if(i != 0) {
                    writer.write(System.getProperty("line.separator"));
                }
                if (read_last.equals(last) & read_bd.equals(bd)) {
                    writer.write(first + System.getProperty("line.separator"));
                    writer.write(new_last + System.getProperty("line.separator"));
                    writer.write(add + System.getProperty("line.separator"));
                    writer.write(phone + System.getProperty("line.separator"));
                    writer.write(bd + System.getProperty("line.separator"));
                    writer.write(ins + System.getProperty("line.separator"));
                    writer.write(copay + System.getProperty("line.separator"));
                    writer.write(type + System.getProperty("line.separator"));
                    writer.write(phys_name + System.getProperty("line.separator"));
                    writer.write(phys_phone + System.getProperty("line.separator"));
                    writer.write(aller + System.getProperty("line.separator"));
                    writer.write(ill);

                    check = check + 1;
                } else {
                    // store info in variables
                    String read_first = Files.readAllLines(Paths.get(readFile)).get(i*12);
                    String read_add = Files.readAllLines(Paths.get(readFile)).get(i*12 + 2);
                    String read_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 3);
                    String read_ins = Files.readAllLines(Paths.get(readFile)).get(i*12 + 5);
                    String read_copay = Files.readAllLines(Paths.get(readFile)).get(i*12 + 6);
                    String read_type = Files.readAllLines(Paths.get(readFile)).get(i*12 + 7);
                    String read_phys_name = Files.readAllLines(Paths.get(readFile)).get(i*12 + 8);
                    String read_phys_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 9);
                    String read_aller = Files.readAllLines(Paths.get(readFile)).get(i*12 + 10);
                    String read_ill = Files.readAllLines(Paths.get(readFile)).get(i*12 + 11);

                    // write new info to temporary file
                    writer.write(read_first + System.getProperty("line.separator"));
                    writer.write(read_last + System.getProperty("line.separator"));
                    writer.write(read_add + System.getProperty("line.separator"));
                    writer.write(read_phone + System.getProperty("line.separator"));
                    writer.write(read_bd + System.getProperty("line.separator"));
                    writer.write(read_ins + System.getProperty("line.separator"));
                    writer.write(read_copay + System.getProperty("line.separator"));
                    writer.write(read_type + System.getProperty("line.separator"));
                    writer.write(read_phys_name + System.getProperty("line.separator"));
                    writer.write(read_phys_phone + System.getProperty("line.separator"));
                    writer.write(read_aller + System.getProperty("line.separator"));
                    writer.write(read_ill);
                }
                i = i + 1;
            }
            writer.close();
            reader.close();
            File old = new File(readFile);
            old.delete();
            tempFile.renameTo(new File(readFile));

            // warn user of abnormalities
            if(check == 0) {
                System.out.println("Warning: Did not find the specified patient. ");
            }
            if(check > 1) {
                System.out.println("Warning: Found more than one specified patient. ");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static void modify_single(String readFile, String last, String bd, String cat, String val) {
        int fileLength = get_length(readFile);

        BufferedReader reader;
        String first = "";
        String new_last = "";
        String add = "";
        String phone = "";
        String ins = "";
        String copay = "";
        String type = "";
        String phys_name = "";
        String phys_phone = "";
        String aller = "";
        String ill = "";

        try {
            reader = new BufferedReader(new FileReader(readFile));

            File tempFile = new File("myTempFile.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            int i = 0;
            int check = 0;
            while (i < fileLength) {
                String read_last = Files.readAllLines(Paths.get(readFile)).get(i * 12 + 1);
                String read_bd = Files.readAllLines(Paths.get(readFile)).get(i * 12 + 4);

                // triggers if we found the correct patient
                if(i != 0) {
                    writer.write(System.getProperty("line.separator"));
                }
                if (read_last.equals(last) & read_bd.equals(bd)) {

                    if(cat.equals("First")) {
                        first = val;
                    } else {
                        first = Files.readAllLines(Paths.get(readFile)).get(i*12);
                    }

                    if(cat.equals("Last")) {
                        new_last = val;
                    } else {
                        new_last = Files.readAllLines(Paths.get(readFile)).get(i*12 + 1);
                    }

                    if(cat.equals("Address")) {
                        add = val;
                    } else {
                        add = Files.readAllLines(Paths.get(readFile)).get(i*12 + 2);
                    }

                    if(cat.equals("Phone")) {
                        phone = val;
                    } else {
                        phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 3);
                    }

                    if(cat.equals("Insurance")) {
                        ins = val;
                    } else {
                        ins = Files.readAllLines(Paths.get(readFile)).get(i*12 + 5);
                    }

                    if(cat.equals("Copay")) {
                        copay = val;
                    } else {
                        copay = Files.readAllLines(Paths.get(readFile)).get(i*12 + 6);
                    }

                    if(cat.equals("Type")) {
                        type = val;
                    } else {
                        type = Files.readAllLines(Paths.get(readFile)).get(i*12 + 7);
                    }

                    if(cat.equals("Physician")) {
                        phys_name = val;
                    } else {
                        phys_name = Files.readAllLines(Paths.get(readFile)).get(i*12 + 8);
                    }

                    if(cat.equals("Physician Phone")) {
                        phys_phone = val;
                    } else {
                        phys_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 9);
                    }

                    if(cat.equals("Allergy")) {
                        aller = val;
                    } else {
                        aller = Files.readAllLines(Paths.get(readFile)).get(i*12 + 10);
                    }

                    if(cat.equals("Illness")) {
                        ill = val;
                    } else {
                        ill = Files.readAllLines(Paths.get(readFile)).get(i*12 + 8);
                    }

                    writer.write(first + System.getProperty("line.separator"));
                    writer.write(new_last + System.getProperty("line.separator"));
                    writer.write(add + System.getProperty("line.separator"));
                    writer.write(phone + System.getProperty("line.separator"));
                    writer.write(bd + System.getProperty("line.separator"));
                    writer.write(ins + System.getProperty("line.separator"));
                    writer.write(copay + System.getProperty("line.separator"));
                    writer.write(type + System.getProperty("line.separator"));
                    writer.write(phys_name + System.getProperty("line.separator"));
                    writer.write(phys_phone + System.getProperty("line.separator"));
                    writer.write(aller + System.getProperty("line.separator"));
                    writer.write(ill);

                    check = check + 1;
                } else {
                    // store info in variables
                    String read_first = Files.readAllLines(Paths.get(readFile)).get(i*12);
                    String read_add = Files.readAllLines(Paths.get(readFile)).get(i*12 + 2);
                    String read_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 3);
                    String read_ins = Files.readAllLines(Paths.get(readFile)).get(i*12 + 5);
                    String read_copay = Files.readAllLines(Paths.get(readFile)).get(i*12 + 6);
                    String read_type = Files.readAllLines(Paths.get(readFile)).get(i*12 + 7);
                    String read_phys_name = Files.readAllLines(Paths.get(readFile)).get(i*12 + 8);
                    String read_phys_phone = Files.readAllLines(Paths.get(readFile)).get(i*12 + 9);
                    String read_aller = Files.readAllLines(Paths.get(readFile)).get(i*12 + 10);
                    String read_ill = Files.readAllLines(Paths.get(readFile)).get(i*12 + 11);

                    // write new info to temporary file
                    writer.write(read_first + System.getProperty("line.separator"));
                    writer.write(read_last + System.getProperty("line.separator"));
                    writer.write(read_add + System.getProperty("line.separator"));
                    writer.write(read_phone + System.getProperty("line.separator"));
                    writer.write(read_bd + System.getProperty("line.separator"));
                    writer.write(read_ins + System.getProperty("line.separator"));
                    writer.write(read_copay + System.getProperty("line.separator"));
                    writer.write(read_type + System.getProperty("line.separator"));
                    writer.write(read_phys_name + System.getProperty("line.separator"));
                    writer.write(read_phys_phone + System.getProperty("line.separator"));
                    writer.write(read_aller + System.getProperty("line.separator"));
                    writer.write(read_ill);
                }
                i = i + 1;
            }
            writer.close();
            reader.close();
            File old = new File(readFile);
            old.delete();
            tempFile.renameTo(new File(readFile));

            // warn user of abnormalities
            if(check == 0) {
                System.out.println("Warning: Did not find the specified patient. ");
            }
            if(check > 1) {
                System.out.println("Warning: Found more than one specified patient. ");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


    public static List<String> summarise(String readFile, String category, String value) {
        int fileLength = get_length(readFile);
        List<String> list = new ArrayList<String>();

        // calculate amount to be added to find correct column
        int addition = 0;
        if(category.equals("Physician")) addition = 8;
        else if(category.equals("Patient Type")) addition = 7;
        else if(category.equals("Insurance")) addition = 5;
        else if(category.equals("Allergy")) addition = 10;
        else if(category.equals("Illness")) addition = 11;
        else {
            System.out.println("Error: Invalid Category. The valid categories are as follows:\n" +
                    "Physician\nPatient Type\nInsurance\nAllergy\nIllness");
            System.exit(0);
        }

        try {
            System.out.println("The following patients have " + category + " " + value + ":");
            int i = 0;
            int count = 0;
            while (i < fileLength) {
                String read_cat = Files.readAllLines(Paths.get(readFile)).get(i * 12 + addition);

                // triggers if we found the correct value in column
                if (read_cat.equals(value)) {
                    String read_first = Files.readAllLines(Paths.get(readFile)).get(i * 12);
                    String read_last = Files.readAllLines(Paths.get(readFile)).get(i * 12 + 1);
                    String read_phone = Files.readAllLines(Paths.get(readFile)).get(i * 12 + 3);

                    String arr_me = read_first + " " + read_last + ", " + read_phone;

                    System.out.println("First: " + read_first);
                    System.out.println("Last: " + read_last);
                    System.out.println("Phone: " + read_phone);
                    System.out.println();


                    list.add(arr_me);

                    count = count + 1;
                }
                i = i + 1;
            }
            System.out.println("Total: " + count + " occurrence(s) of " + category + " " + value + ".");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return list;
    }

}
