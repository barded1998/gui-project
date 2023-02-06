package view;

import domain.Airport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class Graph extends JPanel {
    private List<Airport> airportList;
    private JFreeChart chart;

    public Graph(List<Airport> airportList) {
        this.setSize(751, 335);
        this.setLayout(null);
        this.setBackground(Color.white);
        this.airportList = airportList;
        chart = ChartFactory.createBarChart("막대 그래프", "지역", "공항 개수", createDataset());
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        BarRenderer br = (BarRenderer) categoryPlot.getRenderer();
        br.setItemMargin(-2);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(0, 0,751, 335);
       add(chartPanel);

        JButton button = new JButton("돌아가기");
        button.addActionListener(e -> {
            this.setVisible(false);
        });
        button.setBounds(0,120, 100,30);
        add(button);
    }

    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        addValue(dataset, "남미");
        addValue(dataset, "대양주");
        addValue(dataset, "북미");
        addValue(dataset, "아시아");
        addValue(dataset, "아프리카");
        addValue(dataset, "유럽");
        addValue(dataset, "중남미");
        addValue(dataset, "중동");

        return dataset;
    }

    private void addValue(DefaultCategoryDataset dataset, String locale) {
        int value = airportList.stream().filter(airport -> locale.equals(airport.getLocale())).collect(Collectors.toList()).size();
        if (value == 0) {
            return;
        }
        System.out.println("value = " + value);
        dataset.addValue(value, locale, locale);
    }
}
