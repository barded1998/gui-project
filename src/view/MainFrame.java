package view;

import domain.Airport;
import file.CsvFileController;
import file.JsonFileController;
import org.json.simple.parser.ParseException;
import repository.AirportRepository;
import repository.JDBCAirportRepository;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {
    private final static AirportRepository repository = new JDBCAirportRepository();
    private Search search;
    private MenuBar menuBar;
    private Info info;
    private JPanel t;
    private ResultPanel resultPanel;
    private Result result;
    private JFileChooser fileChooser;
    private List<Airport> results;
    private Graph graph;
    private PieChart pieChart;

    public MainFrame() throws HeadlessException, SQLException {
        super("GUI");
        getContentPane().setBackground(new Color(138, 198, 255));
        setLayout(null);
        setSize(800, 1200);
        Map<String, String> categories = new HashMap<>();
        mapInit(categories);
        menuBar = new MenuBar();
        setJMenuBar(menuBar);

        menuBar.getFiCsv().addActionListener(e ->{
            fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("csv", "csv"));
            int i = fileChooser.showOpenDialog(null);
            File selectedFile = fileChooser.getSelectedFile();
            CsvFileController csv = new CsvFileController();
            List<Airport> results = csv.read(selectedFile);
            try {
                repository.save(results);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            ArrayList<Airport> list = null;
            try {
                list = repository.findAll();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            resultPanel.setAirports(list);
            t.setPreferredSize(new Dimension(730, 60 * list.size()));
        });

        menuBar.getFiJson().addActionListener(e ->{
            fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("json", "json"));
            int i = fileChooser.showOpenDialog(null);
            File selectedFile = fileChooser.getSelectedFile();
            JsonFileController csv = new JsonFileController();
            List<Airport> results = null;
            try {
                results = csv.read(selectedFile);
                System.out.println("results = " + results.size());
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            try {
                repository.save(results);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            ArrayList<Airport> list = null;
            try {
                list = repository.findAll();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            resultPanel.setAirports(list);
            t.setPreferredSize(new Dimension(730, 60 * list.size()));
        });

        menuBar.getFoCsv().addActionListener(e ->{
            fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("csv", "csv"));
            int i = fileChooser.showSaveDialog(null);
            File file = fileChooser.getSelectedFile();

            CsvFileController csv = new CsvFileController();
            csv.save(file, resultPanel.getAirports());

        });

        menuBar.getFoJson().addActionListener(e ->{
            fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("json", ".json"));
            int i = fileChooser.showSaveDialog(null);
            File file = fileChooser.getSelectedFile();
            file.


            JsonFileController json = new JsonFileController();
            try {
                json.save(file, resultPanel.getAirports());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        search = new Search();
        add(search);
        search.setBounds(20, 20, 751, 157);

        info = new Info();
        add(info);
        info.setBounds(20, 214, 751, 147);


        menuBar.getBarGraph().addActionListener(e -> {
            search.setVisible(false);
            info.setVisible(false);
            if (pieChart != null) {
                pieChart.setVisible(false);
            }
            graph = new Graph(results);
            add(graph);
            graph.setBounds(20, 26, 751, 335);
        });

        menuBar.getPieChart().addActionListener(e -> {
            search.setVisible(false);
            info.setVisible(false);
            pieChart = new PieChart(results);
            if (graph != null) {
                graph.setVisible(false);
            }
            add(pieChart);
            pieChart.setBounds(20, 26, 751, 335);
        });

        menuBar.getBack().addActionListener(e -> {
            search.setVisible(true);
            info.setVisible(true);
            if (graph != null) {
                graph.setVisible(false);
            }
            if (pieChart != null) {
                pieChart.setVisible(false);
            }
        });

        results = repository.findAll();

        t = new JPanel();
        t.setPreferredSize(new Dimension(730, 60 * results.size()));
        t.setBackground(Color.WHITE);
        t.setLayout(null);

        resultPanel = new ResultPanel(results);
        t.add(resultPanel);
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setBounds(36, 0, 679, 10000000);


        result = new Result(t);
        add(result);
        result.setBounds(20, 392, 751, 730);

        search.getSearchBtn().addActionListener(e -> {
            String key = categories.get(search.getCategoryValues().getSelectedItem().toString());
            String value = search.getSearchValue().getText();
            try {
                results = repository.findByKeyAndValue(key, value);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            resultPanel.setAirports((ArrayList<Airport>) results);
            t.setPreferredSize(new Dimension(730, 60 * results.size()));
        });
    }

    private void mapInit(Map<String, String> categories) {
        categories.put("영문공항명", "ENGLISH_AIRPORT_NAME") ;
        categories.put("한글공항명", "KOREAN_AIRPORT_NAME") ;
        categories.put("공항코드1", "IATA") ;
        categories.put("공항코드2", "ICAO") ;
        categories.put("지역", "LOCALE") ;
        categories.put("영문국가명", "ENGLISH_COUNTRY_NAME") ;
        categories.put("한글국가명", "KOREAN_COUNTRY_NAME") ;
        categories.put("영문도시명", "ENGLISH_CITY_NAME");
    }

    private String openDialog() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("csv", "csv"));
        int returnVal = fileChooser.showOpenDialog(null);
        if(returnVal == 0) {
            File file = fileChooser.getSelectedFile();
            return file.getPath();
        }
        else
        {
            System.out.println("파일 열기를 취소하였습니다.");
        }
        return null;
    }
    public Search getSearch() {
        return search;
    }

    public Info getInfo() {
        return info;
    }

    public JPanel getT() {
        return t;
    }

    public ResultPanel getResultPanel() {
        return resultPanel;
    }

    public Result getResult() {
        return result;
    }
}
