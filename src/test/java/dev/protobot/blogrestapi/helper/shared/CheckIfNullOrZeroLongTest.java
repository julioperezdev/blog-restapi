package dev.protobot.blogrestapi.helper.shared;

import dev.protobot.blogrestapi.exceptions.helper.shared.HelperCheckIfNullOrZeroLongException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CheckIfNullOrZeroLongTest {

    @InjectMocks
    CheckIfNullOrZeroLong helper;

    @Test
    void itShouldCheckIfNullOrZeroLongHappyCase() {
        //given
        Long particularLong = 5L;
        //when
        //then
        assertDoesNotThrow(() -> helper.check(particularLong));
    }

    @Test
    void itShouldCheckIfNullOrZeroLongWhenHaveNull() {
        //given
        Long nullLong = null;
        //when
        //then
        assertThrows(HelperCheckIfNullOrZeroLongException.class, () -> helper.check(nullLong));

    }

    @Test
    void itShouldCheckIfNullOrZeroLongWhenHaveZero() {
        //given
        Long zeroLong = 0L;
        //when
        //then
        assertThrows(HelperCheckIfNullOrZeroLongException.class, () -> helper.check(zeroLong));
    }
}