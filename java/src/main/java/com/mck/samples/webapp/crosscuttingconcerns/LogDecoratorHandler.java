package com.mck.samples.webapp.crosscuttingconcerns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.samples.webapp.mediator.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;

import java.util.UUID;


public class LogDecoratorHandler<TCommand extends IAmCommand<TResponse>, TResponse> implements IAmCommandHandler<TCommand, TResponse> {
    private final IAmCommandHandler<TCommand, TResponse> innerHandler;

    public LogDecoratorHandler(IAmCommandHandler<TCommand, TResponse> innerHandler) {

        this.innerHandler = innerHandler;
    }

    public TResponse handle(TCommand command)  throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Logger logger = LogManager.getLogger(command.getClass());
        try{
            MDC.put("requestId",UUID.randomUUID().toString());
            logger.info("Before Request: "  + objectMapper.writeValueAsString(command));
            TResponse result = innerHandler.handle(command); // todas la excepciones esperadas de logica de negocio se controlan dentro del comando
            logger.info("After Response: " + objectMapper.writeValueAsString(result));

            return result;

        }

        catch (JsonProcessingException e){
            logger.error("Error", e);

             throw new Exception(e);
        }
        catch(Exception e) {
            logger.error("Error", e);
            throw e;
        }
        finally {
            MDC.clear();
            logger.debug("MDC cleaned");
        }
    }
}



