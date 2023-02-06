
import view.Colors;
import view.MainFrame;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setBackground(Colors.LIGHTBLUE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
