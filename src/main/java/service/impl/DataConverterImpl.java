package service.impl;

import java.util.Objects;
import java.util.List;
import java.util.stream.*;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        return lines.stream()
            .skip(1)
                .map(s -> {
                    String[] str = s.split(",");
                    Operation operation = Operation.fromCode(str[0]);
                    return new FruitTransaction(operation, str[1], Integer.parseInt(str[2]));
                })
        .collect(Collectors.toList());
    }

    }

