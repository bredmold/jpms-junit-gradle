package com.github.bredmold.jpms.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class JpmsControllerAdvice extends ResponseEntityExceptionHandler {
    private static final MediaType VND_ERROR = MediaType.parseMediaType("application/vnd.error+json");

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
        Exception ex,
        Object body,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request) {
        if (body == null) {
            body = buildExceptionResponse(ex);
            headers.setContentType(VND_ERROR);
        }

        Logger logger = LoggerFactory.getLogger(ex.getClass());
        logger.warn("Unexpected exception", ex);

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    /**
     * For a generic exception, build a response body from it
     *
     * @param ex The exception to turn to an error
     * @return {@link VndErrors} object for the exception
     */
    private VndErrors buildExceptionResponse(Throwable ex) {
        String logref = Instant.now().toString();
        String message = String.format("%s: %s: %s",
            getClass().getSimpleName(),
            ex.getClass().getSimpleName(),
            exceptionMessage(ex));

        return new VndErrors(new VndErrors.VndError(logref, message));
    }

    /**
     * Given an exception, generate a message for it
     *
     * @param t The exception to examine
     * @return Message for that exception
     */
    private String exceptionMessage(Throwable t) {
        if (StringUtils.isNotBlank(t.getMessage())) {
            // If there's a message, return it
            return t.getMessage();
        } else if (t.getCause() == null || t.getCause() == t) {
            // If there's nothing, return a blank string
            return "";
        } else {
            // If there's a cause, look that up
            return exceptionMessage(t.getCause());
        }
    }
}
