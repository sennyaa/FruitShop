package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void process(List<FruitTransaction> transaction) {
        for (FruitTransaction trans: transaction) {
            operationStrategy.getHandler(trans.getOperation()).apply(trans);
        }
    }
}
