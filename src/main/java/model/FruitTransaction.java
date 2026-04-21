package model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (this.getClass() != ob.getClass()) return false;
        FruitTransaction ft = (FruitTransaction) ob;
        return (quantity == ft.quantity && fruit.equals(ft.fruit) && operation.equals(ft.operation));
    }
    @Override
    public int hashCode() {
        int result = fruit == null ? 0: fruit.hashCode();
        result += operation == null ? 0: operation.hashCode();
        result += quantity;
        return result;
    }
}
