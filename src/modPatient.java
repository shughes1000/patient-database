import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modPatient implements ActionListener {
    private static JLabel last_label;
    private static JTextField last_text;
    private static JLabel bday_label;
    private static JTextField bday_text;
    private static JComboBox<String> value;// = new JComboBox<String>();
    private static JLabel newVal_label;
    private static JTextField newVal_text;
    private static JButton enter;

    public static void modPatient(String file) {
        JFrame frame = new JFrame("Modify Patient");
        JPanel panel = new JPanel(); // the panel is not visible in output
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        panel.setLayout(null);

        last_label = new JLabel("Last Name");
        last_label.setBounds(10, 50, 150, 25);
        last_text = new JTextField(20);
        last_text.setBounds(170, 50, 165, 25);
        panel.add(last_label);
        panel.add(last_text);

        bday_label = new JLabel("Birthday");
        bday_label.setBounds(10, 100, 155, 25);
        bday_text = new JTextField(20);
        bday_text.setBounds(170, 100, 165, 25);
        panel.add(bday_label);
        panel.add(bday_text);

        enter = new JButton("Enter ALL info");
        enter.setBounds(10,250,150,25);
        enter.addActionListener(new modPatient());
        panel.add(enter);


        value = new JComboBox<String>();
        value.addItem("First");
        value.addItem("Last");
        value.addItem("Address");
        value.addItem("Phone");
        value.addItem("Insurance");
        value.addItem("Copay");
        value.addItem("Patient Type");
        value.addItem("Physician");
        value.addItem("Physician Phone");
        value.addItem("Allergy");
        value.addItem("Illness");
        value.setBounds(170, 150, 180, 25);
        panel.add(value);

        newVal_label = new JLabel("New Value");
        newVal_label.setBounds(10, 200, 150, 25);
        newVal_text = new JTextField(20);
        newVal_text.setBounds(170, 200, 165, 25);
        panel.add(newVal_label);
        panel.add(newVal_text);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        //display the window
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String last_input = last_text.getText();
        String birthday_input = bday_text.getText();
        String cat = (String) value.getSelectedItem();
        String val = newVal_text.getText();
        PatientDatabase.modify_single(PatientInterface.file, last_input, birthday_input, cat, val);
        String[] arr = PatientDatabase.read_entry(PatientInterface.file, last_input, birthday_input);

        JFrame result_frame = new JFrame("search result");
        JPanel res_panel = new JPanel(); // the panel is not visible in output
        result_frame.setSize(500, 500);
        result_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        res_panel.setLayout(null);

        for (int i =0; i<12; i++){
            JLabel temp = new JLabel(arr[i]);
            temp.setBounds(10, 20+30*i, 150, 25);
            res_panel.add(temp);
        }

        result_frame.getContentPane().add(BorderLayout.CENTER, res_panel);
        result_frame.setVisible(true);
    }
}

