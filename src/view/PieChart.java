package view;

import domain.Airport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class PieChart extends JPanel {
    private List<Airport> airportList;
    private JFreeChart chart;

    public PieChart(List<Airport> airportList) {
        this.setSize(751, 335);
        this.setLayout(null);
        this.setBackground(Color.white);
        this.airportList = airportList;
        chart = ChartFactory.createPieChart("파이 차트", createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(0, 0, 751, 335);
        add(chartPanel);

    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
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

    private void addValue(DefaultPieDataset dataset, String locale) {
        int value = airportList.stream().filter(airport -> locale.equals(airport.getLocale())).collect(Collectors.toList()).size();
        if (value == 0) {
            return;
        }
        dataset.setValue(locale, value);
    }
}
