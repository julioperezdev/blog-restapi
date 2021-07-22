package dev.protobot.blogrestapi.helper.shared;

import dev.protobot.blogrestapi.exceptions.helper.shared.HelperStringCanNotHaveAnyNumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CheckIfStringHaveNumber {

    Logger logger = LoggerFactory.getLogger(CheckIfStringHaveNumber.class);

    public CheckIfStringHaveNumber() {
    }

    public void check(String particularString) {
        logger.info("Executing check if String have a number");
        boolean matches = particularString.matches(".*\\d.*");
        if(matches){
            logger.warn("Execution does not be completed because this String have a number");
            throw new HelperStringCanNotHaveAnyNumberException(particularString);
        }
    }
}