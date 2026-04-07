package strategy.impl;

import model.FruitTransaction;
import strategy.OperationHandler;
import static db.Storage.storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        storage.merge(transaction.getFruit(), transaction.getQuantity(),Integer::sum);
    }
}
