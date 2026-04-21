package db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;
class StorageTest {
    @BeforeEach
    void clear() {
        Storage.clear();
    }

    @ParameterizedTest
    @CsvSource({"banana,35",
                "apple,15",
                "banana,47"
    })
    void setQuantity_Should_Set_Start_Balance(String a, int b) {
        Storage.setQuantity(a, b);
        assertEquals(b, Storage.storage.get(a));
    }

    @ParameterizedTest
    @CsvSource({"banana,35",
            "apple,15",
            "banana,47"
    })
    void addQuantity_should_add_quantity(String a, int b) {
        Storage.addQuantity(a, b);
        assertEquals(b, Storage.storage.get(a));
    }
}