package service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileWriterImplTest {
    FileWriterImpl fw = new FileWriterImpl();

    @Test
    void write_withValidDataAndPath_writesContentToFile(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        String data = "fruit,quantity\nbanana,36\napple,356\n";

        String filePath = testFile.toString();
        fw.write(data, filePath);

        assertTrue(Files.exists(testFile));
        assertEquals(data,Files.readString(testFile));
    }
}