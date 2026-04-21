package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        try {
            Files.writeString(Path.of(filePath), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file", e);
        }
    }
}

