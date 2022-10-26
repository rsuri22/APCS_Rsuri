import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstGUI extends JFrame{
    public JPanel panelMain;
    private JTextField textField1;
    private JLabel label;
    private JButton btnClick;

    public FirstGUI() {
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnClick, "Hello " + textField1.getText() + "!");
            }
        });
    }
}
