import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIForm implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private final int width = 800;
    private final int height = 600;
    private JPanel loginPanel;
    private JLabel titleLabel = new JLabel("Master of Pieces");
    private JTextField userNameField;
    private JLabel userNameLabel;

    private void loginPanelInit(){

        assert loginPanel != null;
        loginPanel.setLayout(new BorderLayout());

        assert titleLabel != null;
        titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        assert userNameLabel != null;
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        userNameLabel.setVerticalAlignment(SwingConstants.CENTER);
        userNameLabel.setText("username: ");

        assert userNameField != null;
        userNameField.setFont(new Font("Arial", Font.BOLD, 15));
        userNameField.setHorizontalAlignment(SwingConstants.LEFT);
        userNameField.setText("Aici scrii username-ul");

        loginPanel.add(titleLabel, BorderLayout.NORTH);
        loginPanel.add(userNameLabel, BorderLayout.CENTER);
        loginPanel.add(userNameField, BorderLayout.CENTER);



        loginPanel.setBackground(Color.WHITE);
        loginPanel.setPreferredSize(new Dimension(width, height));

    }

    public GUIForm() {
        loginPanelInit();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Master of Pieces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUIForm guiForm = new GUIForm();
        frame.setLayout(new CardLayout());
        frame.add(guiForm.loginPanel, BorderLayout.CENTER);
        frame.setContentPane(guiForm.loginPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
