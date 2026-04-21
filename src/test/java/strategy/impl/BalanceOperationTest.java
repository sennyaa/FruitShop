package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import model.Operation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BalanceOperationTest {

   @Test
    void apply_balanceOperation_correctQuantity() {
       BalanceOperation balanceOperation = new BalanceOperation();
       FruitTransaction ft = new FruitTransaction(Operation.BALANCE, "banana", 35);

       Storage.storage.clear();

       balanceOperation.apply(ft);
       assertEquals(35, Storage.storage.get("banana"));
    }
}