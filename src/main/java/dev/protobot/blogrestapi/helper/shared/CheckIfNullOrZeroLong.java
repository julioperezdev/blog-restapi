package dev.protobot.blogrestapi.helper.shared;

import dev.protobot.blogrestapi.exceptions.helper.shared.HelperCheckIfNullOrZeroLongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CheckIfNullOrZeroLong {

    Logger logger = LoggerFactory.getLogger(CheckIfNullOrZeroLong.class);

    public CheckIfNullOrZeroLong() {
    }

    public void check(Long longNumber){
        logger.info("Checking if Null or Zero this " + longNumber);
        if(isZeroOrNull(longNumber))
            throw new HelperCheckIfNullOrZeroLongException();

    }

    public void checkNotNull(Long longNumber){
        logger.info("Checking if Null or Zero this " + longNumber);
        if(!isZeroOrNull(longNumber))
            throw new HelperCheckIfNullOrZeroLongException();
    }



    private boolean isZeroOrNull(Long longNumber) {
        return !(longNumber != null && !longNumber.equals(0L));
    }
}