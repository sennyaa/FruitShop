package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileReader;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException exc) {
            throw new RuntimeException("cant read file", exc);
        }
    }
}
