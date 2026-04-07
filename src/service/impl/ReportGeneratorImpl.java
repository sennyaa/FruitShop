package service.impl;

import java.util.Map;
import service.ReportGenerator;
import static db.Storage.storage;

public class ReportGeneratorImpl implements ReportGenerator {
    public String getReport() {
        String report = "fruit,quantity\n";
        for (Map.Entry<String, Integer> entry: storage.entrySet()) {
            report += entry.getKey() + "," + entry.getValue() + "\n";
        }
        return report;
    }
}
