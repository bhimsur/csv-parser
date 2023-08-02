package io.bhimsur.csv;

import io.bhimsur.csv.util.CsvParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class CarController {
    @PostMapping("/file")
    public List<Car> parse(@RequestParam("file") MultipartFile file) {
        CsvParser csvParser = new CsvParser(file);
        return csvParser.command(Car.class);
    }
}
