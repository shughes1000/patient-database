import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;


public class PatientInterface {
    public static String file = "No File Input";
    private static JTextField file_text;
    public static JButton enter;
    //public String file;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Medical Information System");
        // Setting the width and height of frame
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel file_label;
        file_label = new JLabel("File Name");
        file_label.setBounds(500, 30, 150, 25);
        file_text = new JTextField(20);
        file_text.setBounds(560, 30, 165, 25);
        panel.add(file_label);
        panel.add(file_text);
        enter = new JButton("enter file name");
        enter.setBounds(500,70,150,25);
        //enter.addActionListener(new newPatient());
        panel.add(enter);

        JButton enterButton = new JButton("1.Enter a new patient");
        enterButton.setBounds(10, 50, 320, 50);
        panel.add(enterButton);

        JButton deleteButton = new JButton("2.Delete a patient:");
        deleteButton.setBounds(10, 100, 320, 50);
        panel.add(deleteButton);

        JButton findButton = new JButton("3.Find and display a Patient:");
        findButton.setBounds(10, 150, 320, 50);
        panel.add(findButton);

        JButton modifyButton = new JButton("4.Modify a patient profile:");
        modifyButton.setBounds(10, 200, 320, 50);
        panel.add(modifyButton);

        JButton searchButton = new JButton("5.Search a patient profile:");
        searchButton.setBounds(10, 250, 320, 50);
        panel.add(searchButton);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file = file_text.getText();
                System.out.println("You entered file name " + file + ".");
                try {
                    new FileOutputStream(file, true).close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        enterButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                newPatient.addPatient(file);
            }});

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delPatient.delPatient(file);

            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findPatient.findPatient(file);
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modPatient.modPatient(file);

            }
        });
            searchButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   searchPatients.searchPatients(file);
                }
           });
    }
}


