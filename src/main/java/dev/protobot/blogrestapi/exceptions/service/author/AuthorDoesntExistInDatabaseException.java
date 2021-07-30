package dev.protobot.blogrestapi.exceptions.service.author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorDoesntExistInDatabaseException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(AuthorDoesntExistInDatabaseException.class);

    public AuthorDoesntExistInDatabaseException(){
        logger.error("Author process doesnt complete because doesnt exist in database");
    }

}
