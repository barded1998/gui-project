package file;

import domain.Airport;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileController implements FileController {

    @Override
    public List<Airport> read(File file) {
        List<Airport> airports = new ArrayList<>();
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로
                Airport airport = new Airport(null, lineArr[0], lineArr[1], lineArr[2], lineArr[3], lineArr[4], lineArr[5], lineArr[6], lineArr[7]);
                airports.add(airport);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close(); // 사용 후 BufferedReader를 닫아준다.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return airports;
    }


    @Override
    public void save(File file, List<Airport> airports) {
        BufferedWriter bw = null; // 출력 스트림 생성
        try {
            bw = new BufferedWriter(new FileWriter(file));// csv파일의 기존 값에 이어쓰려면 위처럼 true를 지정하고, 기존 값을 덮어쓰려면 true를 삭제한다
            String columns = "영문공항명,한글공항명,공항코드1(IATA),공항코드2(ICAO),지역,영문국가명,한글국가명,영문도시명";
            bw.write(columns);
            bw.newLine();
            for (Airport airport : airports) {
                String aData = "";
                aData = airport.getEnglishAirportName() + "," + airport.getKoreanAirportName() + ","+ airport.getIATA() + ","+ airport.getICAO() + ","+ airport.getLocale() + ","+ airport.getEnglishCountryName() + ","+ airport.getKoreanCountryName() + ","+ airport.getEnglishCityName();
                bw.write(aData);// 작성한 데이터를 파일에 넣는다
                bw.newLine(); // 개행
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush(); // 남아있는 데이터까지 보내 준다
                    bw.close(); // 사용한 BufferedWriter를 닫아 준다
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
