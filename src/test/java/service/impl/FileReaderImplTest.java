package service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FileReaderImplTest {
    FileReaderImpl fr = new FileReaderImpl();

    @Test
    void read_readingFile_listOfStrings(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        String content = "b,banana,35\nb,apple,46";
        Files.writeString(testFile, content);
        List<String> result = fr.read(testFile.toString());
        String strResult = String.join("\n",result );
        assertEquals(content,strResult);
    }

    @Test
    void read_readingFile_exception(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");

        assertThrows(RuntimeException.class, () -> fr.read(testFile.toString()));
    }
  
}