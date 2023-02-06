package file;

import com.mysql.cj.xdevapi.JsonParser;
import domain.Airport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonFileController implements FileController {

    @Override
    public List<Airport> read(File file) throws IOException, ParseException {
        List<Airport> airports = new ArrayList<>();
        FileReader fileReader = new FileReader(file);     // 파일 입력 스트림 생성
        JSONParser jsonParse = new JSONParser();
        JSONArray jsonArray = (JSONArray)jsonParse.parse(fileReader);    // json 파일을 읽어서 JSONArray에 저장

        for (int i = 0; i < jsonArray.size(); ++i) {
            JSONObject jo = (JSONObject)jsonArray.get(i);                        // 첫번째 list를 꺼낸다
            airports.add(new Airport(null, (String) jo.get("영문공항명"), (String) jo.get("한글공항명"), (String) jo.get("공항코드1"), (String) jo.get("공항코드2"), (String) jo.get("지역"), (String) jo.get("영문국가명"), (String) jo.get("한글국가명"), (String) jo.get("영문도시명")));
        }

        System.out.println("airports = " + airports);
        return airports;
    }


    @Override
    public void save(File file, List<Airport> airports) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        JSONParser jsonParse = new JSONParser();
        JSONArray jsonArray = new JSONArray();

        for (Airport airport : airports) {
            JSONObject jo = new JSONObject();                     // 첫번째 list를 꺼낸다
            jo.put("영문공항명", airport.getEnglishAirportName());
            jo.put("한글공항명", airport.getKoreanAirportName());
            jo.put("공항코드1", airport.getIATA());
            jo.put("공항코드2", airport.getICAO());
            jo.put("지역", airport.getLocale());
            jo.put("영문국가명", airport.getEnglishCountryName());
            jo.put("한글국가명", airport.getKoreanCountryName());
            jo.put("영문도시명", airport.getEnglishCityName());
            jsonArray.add(jo);
        }

        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    private String AirportToJson(Airport airport) {
        return "{\"영문공항명\":\"" + airport.getEnglishAirportName() +"\","
                + "\"영문공항명\":\"" + airport.getKoreanAirportName() +"\","
                + "\"영문공항명\":\"" + airport.getIATA() +"\","
                + "\"영문공항명\":\"" + airport.getICAO() +"\","
                + "\"영문공항명\":\"" + airport.getLocale() +"\","
                + "\"영문공항명\":\"" + airport.getEnglishCountryName() +"\","
                + "\"영문공항명\":\"" + airport.getKoreanCountryName() +"\","
                + "\"영문공항명\":\"" + airport.getEnglishCityName() +"\","
                + "}";
    }
}
