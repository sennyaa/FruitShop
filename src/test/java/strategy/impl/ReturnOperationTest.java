package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import model.Operation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReturnOperationTest {
    @Test
    void apply_returnOperation_correctQuantity() {
        Storage.storage.clear();
        Storage.setQuantity("banana", 45);
        int expected = 10;
        ReturnOperation ro = new ReturnOperation();
        FruitTransaction ft = new FruitTransaction(Operation.BALANCE, "banana", 35);
        ro.apply(ft);
        assertEquals(10, Storage.storage.get("banana"));
    }
}