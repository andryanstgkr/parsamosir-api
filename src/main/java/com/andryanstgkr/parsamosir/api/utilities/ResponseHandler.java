package com.andryanstgkr.parsamosir.api.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    static Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    /**
     * 
     * @param message
     * @param status
     * @param responseObj
     * @return
     */
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, dd-MMM-yyyy HH:mm:ss")));
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        logger.info("Map" + map);
        return new ResponseEntity<Object>(map, status);
    }

    /**
     * 
     * @param message
     * @param status
     * @param responseObj
     * @param totalRecord
     * @param pageNumber
     * @param totalPages
     * @return
     */
    public static ResponseEntity<Object> generateResponseList(String message, HttpStatus status, Object responseObj,
            int totalRecord, int pageNumber, int totalPages) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, dd-MMM-yyyy HH:mm:ss")));
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        map.put("totalRecord", totalRecord);
        map.put("pageNumber", pageNumber);
        map.put("totalPages", totalPages);
        return new ResponseEntity<Object>(map, status);
    }
}
