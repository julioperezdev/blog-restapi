package dev.protobot.blogrestapi.helper.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertStringToLowerCase {

    Logger logger = LoggerFactory.getLogger(ConvertStringToLowerCase.class);

    private final CheckIfStringHaveNumber checkIfStringHaveNumber;

    @Autowired
    public ConvertStringToLowerCase(CheckIfStringHaveNumber checkIfStringHaveNumber) {
        this.checkIfStringHaveNumber = checkIfStringHaveNumber;
    }

    public String convert(String particularString) {
        logger.info("Executing convert String to lower case");
        checkIfStringHaveNumber.check(particularString);
        return particularString.toLowerCase();

    }
}