import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taschenrechner_mit_UI extends JFrame implements ActionListener {
    JTextField eingabeFeld;
    double ersterWert = 0;
    String operator = "";

    public Taschenrechner_mit_UI() {
        setTitle("Taschenrechner");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        eingabeFeld = new JTextField();
        eingabeFeld.setFont(new Font("Arial", Font.PLAIN, 24));
        eingabeFeld.setHorizontalAlignment(JTextField.RIGHT);
        add(eingabeFeld, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("0123456789".contains(cmd)) {
            eingabeFeld.setText(eingabeFeld.getText() + cmd);
        } else if ("+-*/".contains(cmd)) {
            ersterWert = Double.parseDouble(eingabeFeld.getText());
            operator = cmd;
            eingabeFeld.setText("");
        } else if (cmd.equals("=")) {
            double zweiterWert = Double.parseDouble(eingabeFeld.getText());
            double ergebnis = 0;

            switch (operator) {
                case "+": ergebnis = ersterWert + zweiterWert; break;
                case "-": ergebnis = ersterWert - zweiterWert; break;
                case "*": ergebnis = ersterWert * zweiterWert; break;
                case "/": ergebnis = ersterWert / zweiterWert; break;
            }

            eingabeFeld.setText(String.valueOf(ergebnis));
        } else if (cmd.equals("C")) {
            eingabeFeld.setText("");
            ersterWert = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Taschenrechner_mit_UI().setVisible(true);
        });
    }
}