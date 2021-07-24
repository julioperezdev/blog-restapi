package dev.protobot.blogrestapi.helper.shared;

import dev.protobot.blogrestapi.exceptions.helper.shared.HelperStringCanNotHaveAnyNumberException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ConvertStringToLowerCaseTest {

    @Mock
    CheckIfStringHaveNumber checkIfStringHaveNumber;

    @InjectMocks
    ConvertStringToLowerCase helper;

    @Test
    void itShouldCheckIfConvertToLowerCaseAllLetterHaveUpperCaseHappyCase() {
        //given
        String oldString = "ABC";

        //when
        String stringConverted = helper.convert(oldString);

        //then
        assertEquals("abc", stringConverted);
    }

    @Test
    void itShouldCheckIfConvertToLowerCaseSomeLetterHaveUpperCaseHappyCase() {
        //given
        String oldString = "AbCdeF";

        //when
        String stringConverted = helper.convert(oldString);

        //then
        assertEquals("abcdef", stringConverted);
    }

    @Test
    void itShouldCheckIfConvertToLowerCaseAnyLetterHaveUpperCaseHappyCase() {
        //given
        String oldString = "zxcvbnm";

        //when
        String stringConverted = helper.convert(oldString);

        //then
        assertEquals(oldString, stringConverted);
    }

    @Test

    void itShouldCheckIfConvertToLowerCaseRa() {
        //given
        String oldString = "zxFv2bnM";
        //when
        helper.convert(oldString);
        //then
        then(checkIfStringHaveNumber).should().check(oldString);
    }

}