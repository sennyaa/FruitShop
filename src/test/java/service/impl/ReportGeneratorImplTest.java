package service.impl;

import db.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorImplTest {

    @Test
    void getReport_withFruitsInStorage_returnsCsvReport() {
        Storage.storage.clear();

        Storage.setQuantity("banana", 36);
        Storage.setQuantity("apple", 356);

        ReportGeneratorImpl rg = new ReportGeneratorImpl();
        String result = rg.getReport();
        String expected = "fruit,quantity\nbanana,36\napple,356\n";

        assertEquals(expected, result);
    }
}