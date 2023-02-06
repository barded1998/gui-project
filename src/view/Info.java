package view;

import javax.swing.*;
import java.awt.*;

public class Info extends JPanel {
    public Info() {

        setBackground(Color.WHITE);
        setLayout(null);

        JLabel image = new JLabel("!?");
        image.setFont(new Font(this.getFont().getName(), Font.PLAIN, 36));
        image.setForeground(Colors.GRAY);
        image.setBounds(95, 54, 42, 42);
        add(image);

        JLabel info1 = new JLabel("* 검색 항목을 선택 후 알맞는 검색어를 입력하여 검색버튼을 누르세요");
        info1.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        info1.setForeground(Colors.GRAY);
        info1.setBounds(176, 35, 519, 26);
        add(info1);

        JLabel info2 = new JLabel("* 검색시 검색어가 포함된 결과를 제공합니다.");
        info2.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        info2.setForeground(Colors.GRAY);
        info2.setBounds(176, 61, 519, 26);
        add(info2);

        JLabel info3 = new JLabel("* 막대 그래프와 파이차트로도 결과를 제공합니다. 그래프 버튼을 누르세요 ");
        info3.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        info3.setForeground(Colors.GRAY);
        info3.setBounds(176, 87, 519, 26);
        add(info3);
    }
}
