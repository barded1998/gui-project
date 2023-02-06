package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;

public class MenuBar extends JMenuBar {
    private JMenu fi;
    private JMenuItem fiCsv;
    private JMenuItem fiJson;

    private JMenu fo;
    private JMenuItem foCsv;
    private JMenuItem foJson;

    private JMenu graph;
    private JMenuItem barGraph;
    private JMenuItem pieChart;
    private JMenuItem back;

    private JFileChooser fileChooser;

    public MenuBar() {
        fi = new JMenu("파일 가져오기");
        fiCsv = new JMenuItem("CSV");
        fiJson = new JMenuItem("JSON");
        fi.add(fiCsv);
        fi.add(fiJson);

        fo = new JMenu("파일 내보내기");
        foCsv = new JMenuItem("CSV");
        foJson = new JMenuItem("JSON");
        fo.add(foCsv);
        fo.add(foJson);

        graph = new JMenu("그래프");
        barGraph = new JMenuItem("막대 그래프");
        pieChart = new JMenuItem("파이 차트");
        back = new JMenuItem("뒤로 가기");
        graph.add(barGraph);
        graph.add(pieChart);
        graph.add(back);

        add(fi);
        add(fo);
        add(graph);

    }


    public JMenu getFi() {
        return fi;
    }

    public JMenuItem getFiCsv() {
        return fiCsv;
    }

    public JMenuItem getFiJson() {
        return fiJson;
    }

    public JMenu getFo() {
        return fo;
    }

    public JMenuItem getFoCsv() {
        return foCsv;
    }

    public JMenuItem getFoJson() {
        return foJson;
    }

    public JMenu getGraph() {
        return graph;
    }

    public JMenuItem getBarGraph() {
        return barGraph;
    }

    public JMenuItem getPieChart() {
        return pieChart;
    }

    public JMenuItem getBack() {
        return back;
    }
}

