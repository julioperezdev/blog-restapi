package dev.protobot.blogrestapi.helper.shared;

import dev.protobot.blogrestapi.exceptions.helper.shared.HelperCheckIfNullOrEmptyStringException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CheckIfNullOrEmptyStringTest {

    @InjectMocks
    CheckIfNullOrEmptyString helper;

    @Test
    void itShouldCheckIfNullOrEmptyStringWhenHaveAStringHappyCase() {
        //given
        String particularString = "is a string";
        //when
        //assertThrows(HelperCheckIfNullOrEmptyStringException.class, () -> helper.check(particularString));
        assertDoesNotThrow(() -> helper.check(particularString));
        //assertThrows(HelperCheckIfNullOrEmptyStringException.class, () -> helper.check(particularString));
        //then
    }

    @Test
    void itShouldCheckIfNullOrEmptyStringWhenHaveNull() {
        //given
        String nullString = null;
        //when
        //then
        assertThrows(HelperCheckIfNullOrEmptyStringException.class, () -> helper.check(nullString));
    }

    @Test
    void itShouldCheckIfNullOrEmptyStringWhenHaveEmptyString() {
        //given
        String emptyString = "";
        //when
        //then
        assertThrows(HelperCheckIfNullOrEmptyStringException.class, () -> helper.check(emptyString));
    }
}