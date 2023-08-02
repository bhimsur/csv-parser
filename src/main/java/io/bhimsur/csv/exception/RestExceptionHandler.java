package io.bhimsur.csv.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

    @ExceptionHandler(CsvParserException.class)
    public ResponseEntity<Object> handle(CsvParserException e) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", e.getMessage());
        return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobal(Exception e) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", e.getMessage());
        return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
    }
}
