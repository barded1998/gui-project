package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Search extends JPanel {
    private JComboBox<String> categoryValues;
    private JTextField searchValue;
    private JButton searchBtn;

    public JComboBox<String> getCategoryValues() {
        return categoryValues;
    }

    public JTextField getSearchValue() {
        return searchValue;
    }

    public JButton getSearchBtn() {
        return searchBtn;
    }

    public Search() {
        super();
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel main = new JLabel(" ▼ 검색조건");
        add(main);
        main.setBounds(0,0, 80, 25);

        JLabel categoryKey = new JLabel("검색 항목");
        categoryKey.setHorizontalAlignment(JLabel.CENTER);
        categoryKey.setOpaque(true);
        categoryKey.setBackground(Colors.LIGHTGRAY);
        add(categoryKey);
        categoryKey.setBounds(74, 42, 126, 40);

        JLabel searchKey = new JLabel("검색어");
        searchKey.setHorizontalAlignment(JLabel.CENTER);
        searchKey.setOpaque(true);
        searchKey.setBackground(Colors.LIGHTGRAY);
        add(searchKey);
        searchKey.setBounds(74, 82, 126, 40);

        categoryValues = new JComboBox<String >(new String[]{"영문공항명", "한글공항명","공항코드1","공항코드2","지역","영문국가명","한글국가명","영문도시명"});
        add(categoryValues);
        categoryValues.setBounds(350, 42, 200, 40);

        searchValue = new JTextField();
        add(searchValue);
        searchValue.setBounds(350, 82, 200, 40);

        searchBtn = new JButton("검색");
        searchBtn.setBounds(695, 126, 48, 29);
        add(searchBtn);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Colors.GRAY);
        g.drawRect(74, 42, 126, 40);
        g.drawRect(74, 82, 126, 40);
        g.drawRect(200, 42, 486, 40);
        g.drawRect(200, 82, 486, 40);
    }
}
