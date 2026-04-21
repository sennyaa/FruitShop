package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import model.Operation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplyOperationTest {

    @Test
    void apply_returnOperation_correctQuantity() {
        Storage.storage.clear();
        Storage.setQuantity("banana", 5);
        int expected = 10;
        SupplyOperation so = new SupplyOperation();
        FruitTransaction ft = new FruitTransaction(Operation.BALANCE, "banana", 5);
        so.apply(ft);
        assertEquals(expected, Storage.storage.get("banana"));
    }
}