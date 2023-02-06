package file;

import domain.Airport;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileController {
    List<Airport> read(File file) throws IOException, ParseException;

    void save(File file, List<Airport> airports) throws IOException;
}
