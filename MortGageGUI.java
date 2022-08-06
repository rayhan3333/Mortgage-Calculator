import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*;

public class MortGageGUI extends JFrame implements ActionListener {
    // JTextField
    static JTextField tprinc;
    static JTextField trate;
    static JTextField ttime;
    double princ;
    double rate;
    double time;
    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l;

    // default constructor
    MortGageGUI()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to store text field and button
        f = new JFrame("Mortgage Calculator!");

        // create a label to display text
        l = new JLabel("nothing entered");

        // create a new button
        b = new JButton("submit");

        // create a object of the text class
        MortGageGUI te = new MortGageGUI();

        // addActionListener to button
        b.addActionListener(te);

        // create a object of JTextField with 16 columns
        tprinc = new JTextField("Principal amount", 20);
        trate = new JTextField("Interest Rate", 20);
        ttime = new JTextField("Time", 20);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(tprinc);
        p.add(trate);
        p.add(ttime);
        p.add(b);
        p.add(l);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);

        f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            princ = Double.parseDouble(tprinc.getText());
            rate = Double.parseDouble(trate.getText());
            time = Double.parseDouble(ttime.getText());
            double mortgage = mortgageCalculator(princ, rate, time);
            l.setText(Double.toString(mortgage));
            // set the text of field to blank

        }
    }

    public double mortgageCalculator(double princ, double rate, double time) {
        double num = rate*Math.pow((1+rate), time);
        double den = Math.pow((1+rate), time) - 1;
        double mortgage = princ * (num/den);

        return mortgage;
    }
}
