package service;

import java.util.List;
import model.FruitTransaction;

public interface ShopService {
    public void process(List<FruitTransaction> transaction);

}
