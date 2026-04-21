package strategy.impl;

import static db.Storage.storage;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    public void apply(FruitTransaction transaction) {
        Storage.addQuantity(transaction.getFruit(), -transaction.getQuantity());
    }
}
