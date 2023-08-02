package io.bhimsur.csv.util;

import com.opencsv.bean.CsvToBeanBuilder;
import io.bhimsur.csv.exception.CsvParserException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CsvParser {
    private final MultipartFile file;
    private final char separator;

    public CsvParser(MultipartFile file, char separator) {
        this.file = file;
        this.separator = separator;
    }

    public CsvParser(MultipartFile file) {
        this.file = file;
        this.separator = ',';
    }

    public <T> List<T> command(Class<T> t) {
        try {
            InputStreamReader reader = new InputStreamReader(this.file.getInputStream());
            reader.close();
            return new CsvToBeanBuilder<T>(reader)
                    .withSeparator(this.separator)
                    .withType(t)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new CsvParserException(e.getMessage());
        }
    }

}
