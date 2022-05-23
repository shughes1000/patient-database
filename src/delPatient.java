import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delPatient implements ActionListener {
    private static JLabel last_label;
    private static JTextField last_text;
    private static JLabel bday_label;
    private static JTextField bday_text;
    private static JButton enter;
    private static JLabel success;



    public static void delPatient(String file) {
        JFrame frame = new JFrame("Delete Patient");
        JPanel panel = new JPanel(); // the panel is not visible in output
        frame.setSize(550, 600);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        panel.setLayout(null);
        enter = new JButton("Enter ALL info");
        enter.setBounds(10,390,150,25);
        enter.addActionListener(new delPatient());
        panel.add(enter);

        success = new JLabel("");
        success.setBounds(10, 475, 150, 25);;
        panel.add(success);

        last_label = new JLabel("Last Name");
        last_label.setBounds(10, 50, 150, 25);
        last_text = new JTextField(20);
        last_text.setBounds(170, 50, 165, 25);
        panel.add(last_label);
        panel.add(last_text);

        bday_label = new JLabel("Birthday");
        bday_label.setBounds(10, 140, 155, 25);
        bday_text = new JTextField(20);
        bday_text.setBounds(170, 140, 165, 25);
        panel.add(bday_label);
        panel.add(bday_text);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        //display the window
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String last_input = last_text.getText();
        String birthday_input = bday_text.getText();

        PatientDatabase.delete_entry(PatientInterface.file, last_input, birthday_input);
        success.setText("Success!");
    }
}
