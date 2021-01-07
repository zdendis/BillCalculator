package com.phonecompany.billing;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {
    public List<CsvFile> readCsvFile(Path path, Class clazz, char csvSeparator) throws Exception {
        ColumnPositionMappingStrategy ms = new ColumnPositionMappingStrategy();
        ms.setType(clazz);

        Reader reader = Files.newBufferedReader(path);
        CsvToBean cb = new CsvToBeanBuilder(reader)
            .withType(clazz)
            .withSeparator(csvSeparator)
            .withMappingStrategy(ms)
            .build();

        List<CsvFile> list = cb.parse();
        reader.close();
        return list;
    }
}
