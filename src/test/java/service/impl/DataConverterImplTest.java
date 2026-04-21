package service.impl;

import model.FruitTransaction;
import model.Operation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataConverterImplTest {
    @Test
    void convertToTransaction_dataConversion_FruitTransactionArray() {
        DataConverterImpl dt = new DataConverterImpl();
        List<String> lines = List.of("operation,fruit,quantity", "b,apple,36", "b,banana,65");
        List<FruitTransaction> ft = dt.convertToTransaction(lines);
        FruitTransaction[] expected = {
                new FruitTransaction(Operation.BALANCE, "apple", 36),
                new FruitTransaction(Operation.BALANCE, "banana", 65)
        };
        assertArrayEquals(expected,ft.toArray());
    }
}