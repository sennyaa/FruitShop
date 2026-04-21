package strategy;

import model.Operation;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
