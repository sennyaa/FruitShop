package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import model.Operation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOperationTest {
    @Test
    void apply_purchaseOperation_correctQuantity() {
        Storage.storage.clear();
        Storage.setQuantity("banana", 45);
        int expected = 10;
        PurchaseOperation po = new PurchaseOperation();
        FruitTransaction ft = new FruitTransaction(Operation.BALANCE, "banana", 35);
        po.apply(ft);
        assertEquals(10, Storage.storage.get("banana"));
    }
}