package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void getCode() {
    }

    @ParameterizedTest
    @CsvSource({
            "b,BALANCE",
            "s,SUPPLY",
            "p,PURCHASE"
    })
    void fromCode_return_required_operation(String a, Operation b) {
        assertEquals(b, Operation.fromCode(a));
    }

    @ParameterizedTest
    @CsvSource({
            "s,BALANCE",
            "b,SUPPLY",
            "r,PURCHASE"
    })
    void fromCode_doesnt_return_another_Operation(String a, Operation b) {
        assertNotEquals(b, Operation.fromCode(a));
    }

    @ParameterizedTest
    @CsvSource({
            "a",
            "v",
            "x"
    })
    void fromCode_exception_when_non_existed_code(String a) {
        assertThrows(IllegalArgumentException.class, () -> Operation.fromCode(a));
    }
}