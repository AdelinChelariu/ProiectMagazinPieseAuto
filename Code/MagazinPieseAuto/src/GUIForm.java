import javax.swing.*;
import java.awt.*;

public class GUIForm {
    private final int width = 800;
    private final int height = 600;
    private JPanel loginPanel;
    private JLabel titleLabel;
    public GUIForm() {
        loginPanel = new JPanel();
        titleLabel = new JLabel("Master Of Pieces");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
        loginPanel.setLayout(new BorderLayout());
        loginPanel.add(titleLabel, BorderLayout.NORTH);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setPreferredSize(new Dimension(width, height));
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Master of Pieces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUIForm guiForm = new GUIForm();
        frame.setLayout(new CardLayout());
        frame.setContentPane(guiForm.loginPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
