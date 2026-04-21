package service.impl;

import model.FruitTransaction;
import model.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.OperationStrategyImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopServiceImplTest {
    @Mock
    private OperationStrategy operationStrategy;
    @Mock
    private OperationHandler mockHandler;

    @InjectMocks
    private ShopServiceImpl shopService;

    private FruitTransaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new FruitTransaction(Operation.BALANCE, "banana", 36);

    }


    @Test void process_shouldHandle_multiply_transactions() {
        FruitTransaction transaction2 = new FruitTransaction(Operation.PURCHASE, "banana",12);
        List<FruitTransaction> transactions = List.of(transaction, transaction2);

        OperationHandler mockHandler2 = mock(OperationHandler.class);

        when(operationStrategy.getHandler(Operation.BALANCE)).thenReturn(mockHandler);
        when(operationStrategy.getHandler(Operation.PURCHASE)).thenReturn(mockHandler2);

        shopService.process(transactions);

        verify(operationStrategy, times(2)).getHandler(any(Operation.class));
        verify(operationStrategy).getHandler(Operation.BALANCE);
        verify(operationStrategy).getHandler(Operation.PURCHASE);

        verify(mockHandler, times(1)).apply(transaction);
        verify(mockHandler2, times(1)).apply(transaction2);

    }
}