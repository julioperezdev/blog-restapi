package dev.protobot.blogrestapi.exceptions.service.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryDoesntExistInDatabaseException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(CategoryDoesntExistInDatabaseException.class);

    public CategoryDoesntExistInDatabaseException(){
        logger.error("Category in process doesnt complete because doesnt exist in database");
    }

}
