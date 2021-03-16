package com.example.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {
  Logger logger = LoggerFactory.getLogger(LoggingController.class);

  @GetMapping("/number")
  public Number greeting(@RequestParam(value = "integer", defaultValue = "0") int n,
                         @RequestParam(value = "float", defaultValue = "1.5f") float f) {
    logger.debug("number page");
    return new Number(n,f);

  }
}
