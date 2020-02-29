import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    //speed of counter
    private int speed = 5;

    private JButton button = new JButton("");
    //makes a slider that will control speed with max value of 10 and min of 0
    private JSlider slider = new JSlider(0,10);
    //text field that shows how many objects they have
    private JLabel label = new JLabel("0");
    //timer that updates the game
    private Timer timer;
    //constructor for GUI
    public GUI() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText( Integer.toString( 1000+Integer.parseInt(label.getText())));
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds a layout
        setLayout(new GridLayout(1,3));
        //label that shows the amount the player has
        add(label);
        //button that allows the user to update their score
        add(button);
        //slider will be removed gets rid of shit
        add(slider);
        //timer begin
        timer.start();
        //changes the amount the user has with every button press from label.getText() to label.getText() + speed
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               label.setText( Integer.toString( speed+Integer.parseInt(label.getText())));
            }
        });
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                speed = slider.getValue();
            }
        });
        timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        timer.start();
        pack();
        setVisible(true);
    }
    static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            // s is a valid integer
            return true;
        } catch (NumberFormatException a) {
            return false;
        }
    }

    public static void main(String arg[]) {
        GUI a = new GUI();
        a.setSize(600,600);
    }
}



