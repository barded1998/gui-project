package domain;

public class Airport {

    private Integer ID;
    private String englishAirportName;
    private String koreanAirportName;
    private String IATA;
    private String ICAO;
    private String locale;
    private String englishCountryName;
    private String koreanCountryName;
    private String englishCityName;

    public Airport(Integer ID, String englishAirportName, String koreanAirportName, String IATA, String ICAO, String locale, String englishCountryName, String koreanCountryName, String englishCityName) {
        this.ID = ID;
        this.englishAirportName = englishAirportName;
        this.koreanAirportName = koreanAirportName;
        this.IATA = IATA;
        this.ICAO = ICAO;
        this.locale = locale;
        this.englishCountryName = englishCountryName;
        this.koreanCountryName = koreanCountryName;
        this.englishCityName = englishCityName;
    }

    public Integer getID() {
        return ID;
    }

    public String getEnglishAirportName() {
        return englishAirportName;
    }

    public String getKoreanAirportName() {
        return koreanAirportName;
    }

    public String getIATA() {
        return IATA;
    }

    public String getICAO() {
        return ICAO;
    }

    public String getLocale() {
        return locale;
    }

    public String getEnglishCountryName() {
        return englishCountryName;
    }

    public String getKoreanCountryName() {
        return koreanCountryName;
    }

    public String getEnglishCityName() {
        return englishCityName;
    }

    @Override
    public String toString() {
        return "Airport{" + "englishAirportName='" + englishAirportName + '\'' + ", koreanAirportName='" + koreanAirportName + '\'' + ", IATA='" + IATA + '\'' + ", ICAO='" + ICAO + '\'' + ", locale='" + locale + '\'' + ", englishCountryName='" + englishCountryName + '\'' + ", koreanCountryName='" + koreanCountryName + '\'' + ", englishCityName='" + englishCityName + '\'' + '}';
    }
}
