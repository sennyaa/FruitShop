package strategy.impl;

import java.util.Map;
import model.Operation;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override public OperationHandler getHandler(Operation operation) {
        return handlers.get(operation);
    }
}
