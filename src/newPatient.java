import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class newPatient implements ActionListener{
    private static JLabel last_label;
    private static JTextField last_text;
    private static JLabel first_label;
    private static JTextField first_text;
    private static JButton enter;
    private static JLabel add_label;
    private static JTextField add_text;
    private static JLabel phone_label;
    private static JTextField phone_text;
    private static JLabel bday_label;
    private static JTextField bday_text;
    private static JLabel insur_label;
    private static JTextField insur_text;
    private static JLabel copay_label;
    private static JTextField copay_text;
    private static JLabel pat_label;
    private static JTextField pat_text;
    private static JLabel phys_label;
    private static JTextField phys_text;
    private static JLabel pphone_label;
    private static JTextField pphone_text;
    private static JLabel allg_label;
    private static JTextField allg_text;
    private static JLabel ill_label;
    private static JTextField ill_text;
    private static JLabel success;
    private static JComboBox<String> ins;// = new JComboBox<String>();
    private static JComboBox<String> pat;
    private static JComboBox<String> allg;
    private static JComboBox<String> illn;


    public static void addPatient(String file) {
        //public PatientInterface() {
        JFrame frame = new JFrame("Add Patient");
        JPanel panel = new JPanel(); // the panel is not visible in output
        frame.setSize(550, 550);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        panel.setLayout(null);


        enter = new JButton("Enter ALL info");
        enter.setBounds(10,390,150,25);
        enter.addActionListener(new newPatient());

        success = new JLabel("");
        success.setBounds(10, 450, 150, 25);;
        panel.add(success);

        first_label = new JLabel("First Name");
        first_label.setBounds(10, 20, 150, 25);
        first_text = new JTextField(20);
        first_text.setBounds(170, 20, 165, 25);

        panel.add(first_label);
        panel.add(first_text);
        panel.add(enter);

        last_label = new JLabel("Last Name");
        last_label.setBounds(10, 50, 150, 25);
        last_text = new JTextField(20);
        last_text.setBounds(170, 50, 165, 25);
        panel.add(last_label);
        panel.add(last_text);

        add_label = new JLabel("Address");
        add_label.setBounds(10, 80, 150, 25);
        add_text = new JTextField(20);
        add_text.setBounds(170, 80, 165, 25);
        panel.add(add_label);
        panel.add(add_text);

        phone_label = new JLabel("Phone Number");
        phone_label.setBounds(10, 110, 150, 25);
        phone_text = new JTextField(20);
        phone_text.setBounds(170, 110, 165, 25);
        panel.add(phone_label);
        panel.add(phone_text);

        bday_label = new JLabel("Birthday");
        bday_label.setBounds(10, 140, 155, 25);
        bday_text = new JTextField(20);
        bday_text.setBounds(170, 140, 165, 25);
        panel.add(bday_label);
        panel.add(bday_text);

        insur_label = new JLabel("Insurance Type");
        insur_label.setBounds(10, 170, 155, 25);
        ins = new JComboBox<String>();
        ins.addItem("PRIVATE");
        ins.addItem("GOVERNMENT");
        ins.setBounds(170, 170, 165, 25);
        panel.add(ins);
        //  insur_text = new JTextField(20);
        //    insur_text.setBounds(170, 170, 165, 25);
        panel.add(insur_label);
        //  panel.add(insur_text);

        copay_label = new JLabel("Copay");
        copay_label.setBounds(10, 200, 155, 25);
        copay_text = new JTextField(20);
        copay_text.setBounds(170, 200, 165, 25);
        panel.add(copay_label);
        panel.add(copay_text);

        pat_label = new JLabel("Patient Type");
        pat_label.setBounds(10, 230, 155, 25);

        pat = new JComboBox<String>();
        pat.addItem("ADULT");
        pat.addItem("GERIATRIC");
        pat.addItem("PEDIATRIC");
        pat.setBounds(170, 230, 165, 25);
        panel.add(pat);
        //pat_text = new JTextField(20);
        //pat_text.setBounds(170, 230, 165, 25);
        panel.add(pat_label);
        //panel.add(pat_text);

        phys_label = new JLabel("Physician");
        phys_label.setBounds(10, 270, 155, 25);
        phys_text = new JTextField(20);
        phys_text.setBounds(170, 270, 165, 25);
        panel.add(phys_label);
        panel.add(phys_text);

        pphone_label = new JLabel("Physician Phone");
        pphone_label.setBounds(10, 300, 155, 25);
        pphone_text = new JTextField(20);
        pphone_text.setBounds(170, 300, 165, 25);
        panel.add(pphone_label);
        panel.add(pphone_text);

        allg_label = new JLabel("Allergies");
        allg_label.setBounds(10, 330, 155, 25);
        allg = new JComboBox<String>();
        allg.addItem("FOOD");
        allg.addItem("MEDICATION");
        allg.addItem("SEASONAL");
        allg.addItem("NONE");
        allg.addItem("OTHER");
        allg.setBounds(170, 330, 165, 25);
        panel.add(allg);
        //allg_text = new JTextField(20);
        // allg_text.setBounds(170, 330, 165, 25);
        panel.add(allg_label);
        //panel.add(allg_text);

        ill_label = new JLabel("Illness");
        ill_label.setBounds(10, 360, 155, 25);
        illn = new JComboBox<String>();
        illn.addItem("DIABETES");
        illn.addItem("CHD");
        illn.addItem("ASTHMA");
        illn.addItem("NONE");
        illn.addItem("OTHER");
        illn.setBounds(170, 360, 165, 25);
        panel.add(illn);
        //ill_text = new JTextField(20);
        //ill_text.setBounds(170, 360, 165, 25);
        panel.add(ill_label);
        //panel.add(ill_text);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        //frame.getContentPane().add(BorderLayout.CENTER, last_panel);

        //display the window
        //frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String first_input = first_text.getText();
        String last_input = last_text.getText();
        String address_input = add_text.getText();
        String phone_input = phone_text.getText();
        String birthday_input = bday_text.getText();
        String insurance_input = (String) ins.getSelectedItem();
        String copay_input_str = copay_text.getText();
        float copay_input = Float.parseFloat(copay_input_str);
        String patient_input = (String) pat.getSelectedItem();
        String phys_input = phys_text.getText();
        String pphone_input = pphone_text.getText();
        String allg_input = (String) allg.getSelectedItem();
        String ill_input = (String) illn.getSelectedItem();

        Patient p = new Patient(first_input, last_input, address_input, phone_input, birthday_input, insurance_input,
                copay_input, patient_input, phys_input, pphone_input, allg_input, ill_input);

        PatientDatabase.append_entry(PatientInterface.file, p);
        System.out.println("Success");
        success.setText("Success!");


    }

}

