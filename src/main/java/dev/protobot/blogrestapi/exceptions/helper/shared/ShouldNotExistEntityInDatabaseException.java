package dev.protobot.blogrestapi.exceptions.helper.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShouldNotExistEntityInDatabaseException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(ShouldNotExistEntityInDatabaseException.class);

    public ShouldNotExistEntityInDatabaseException(){
        logger.error("This entity should not exist in database");
    }


}
