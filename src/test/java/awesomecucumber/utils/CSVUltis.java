package awesomecucumber.utils;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.Reader;

public class CSVUltis {
    @SneakyThrows
    public static CSVParser readDataFromCsv(String url) {
        Reader reader = new FileReader(url);
        return new CSVParser(reader, CSVFormat.EXCEL.withHeader());
    }
}
