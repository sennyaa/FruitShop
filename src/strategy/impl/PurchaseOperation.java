package strategy.impl;

import static db.Storage.storage;

import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        storage.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
    }
}
