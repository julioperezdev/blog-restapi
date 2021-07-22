package dev.protobot.blogrestapi.exceptions.helper.shared;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperCheckIfNullOrEmptyStringException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(HelperCheckIfNullOrEmptyStringException.class);

    public HelperCheckIfNullOrEmptyStringException (){
        logger.error("This string can`t be null to enroll in database because need set a Name");
    }
}