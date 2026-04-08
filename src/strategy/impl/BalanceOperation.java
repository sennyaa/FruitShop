package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;
import static db.Storage.storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
