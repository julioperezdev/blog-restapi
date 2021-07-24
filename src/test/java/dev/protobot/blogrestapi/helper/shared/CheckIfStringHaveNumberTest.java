package dev.protobot.blogrestapi.helper.shared;

import dev.protobot.blogrestapi.exceptions.helper.shared.HelperStringCanNotHaveAnyNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CheckIfStringHaveNumberTest {

    @InjectMocks
    CheckIfStringHaveNumber helper;

    @Test
    void itShouldCheckIfStringHaveNumberHappyCase() {
        //given
        String particularString = "qwerty";
        //when
        //then
        assertDoesNotThrow(() -> helper.check(particularString));
    }

    @Test
    void itShouldCheckIfStringHaveNumberWhenHaveNumberInFirstCharacter() {
        //given
        String numberInFirstCharacterString = "1qwerty";
        //when
        //then
        assertThrows(HelperStringCanNotHaveAnyNumberException.class,
                () -> helper.check(numberInFirstCharacterString));
    }

    @Test
    void itShouldCheckIfStringHaveNumberWhenHaveNumberInLastCharacter() {
        //given
        String numberInLastCharacterString = "qwerty2";
        //when
        //then
        assertThrows(HelperStringCanNotHaveAnyNumberException.class,
                () -> helper.check(numberInLastCharacterString));
    }

    @Test
    void itShouldCheckIfStringHaveNumberWhenHaveNumberInBetweenCharacters() {
        //given
        String numberInBetweenCharacterString = "qwer3ty";
        //when
        //then
        assertThrows(HelperStringCanNotHaveAnyNumberException.class,
                () -> helper.check(numberInBetweenCharacterString));
    }

    @Test
    void itShouldCheckIfStringHaveNumberWhenHaveNumberInAllCharacters() {
        //given
        String numbersString = "4567";
        //when
        //then
        assertThrows(HelperStringCanNotHaveAnyNumberException.class,
                () -> helper.check(numbersString));
    }

    @Test
    void itShouldCheckIfStringHaveNumberWhenHaveNumberInManyCharacters() {
        //given
        String numbersAndString = "89ab";
        //when
        //then
        assertThrows(HelperStringCanNotHaveAnyNumberException.class,
                () -> helper.check(numbersAndString));
    }
}