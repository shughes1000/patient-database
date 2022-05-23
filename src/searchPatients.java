import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class searchPatients implements ActionListener {
    private static JLabel cat_label;
    private static JLabel value_label;
    private static JTextField value_text;
    private static JButton enter;
    private static JComboBox<String> cats;

    public static void searchPatients(String file) {
        JFrame frame = new JFrame("Patient Search");
        JPanel panel = new JPanel(); // the panel is not visible in output
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        panel.setLayout(null);
        enter = new JButton("submit");
        enter.setBounds(10,390,150,25);
        enter.addActionListener(new searchPatients());
        panel.add(enter);

        cat_label = new JLabel("Search by Category");
        cat_label.setBounds(10, 150, 250, 25);

        cats = new JComboBox<String>();
        cats.addItem("Physician");
        cats.addItem("Insurance");
        cats.addItem("Patient Type");
        cats.addItem("Allergy");
        cats.addItem("Illness");
        cats.setBounds(10, 30, 200, 25);
        panel.add(cats);

        value_label = new JLabel("Value");
        value_label.setBounds(10, 150, 150, 25);
        value_text = new JTextField(20);
        value_text.setBounds(170, 150, 165, 25);
        panel.add(value_label);
        panel.add(value_text);


        frame.getContentPane().add(BorderLayout.CENTER, panel);
        //display the window
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value_input = value_text.getText();
        String cat = (String) cats.getSelectedItem();
        List<String> arr = PatientDatabase.summarise(PatientInterface.file, cat, value_input);

        JFrame result_frame = new JFrame("search result");
        JPanel res_panel = new JPanel(); // the panel is not visible in output
        result_frame.setSize(500, 500);
        result_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        res_panel.setLayout(null);

        for (int i =0; i<arr.size(); i++){
            JLabel temp = new JLabel(arr.get(i));
            temp.setBounds(10, 20+30*i, 350, 25);
            res_panel.add(temp);
        }

        result_frame.getContentPane().add(BorderLayout.CENTER, res_panel);
        result_frame.setVisible(true);
    }
}
