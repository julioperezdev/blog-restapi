package dev.protobot.blogrestapi.exceptions.helper.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperStringCanNotHaveAnyNumberException extends NumberFormatException{

    Logger logger = LoggerFactory.getLogger(HelperStringCanNotHaveAnyNumberException.class);

    public HelperStringCanNotHaveAnyNumberException(String particularString) {
        logger.warn("Can not use a Number in this String :" + particularString);
        falseResult();
    }

    public boolean falseResult(){
        return false;
    }
}