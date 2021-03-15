package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

  @GetMapping("/number")
  public Number greeting(@RequestParam(value = "integer", defaultValue = "0") int n,
                         @RequestParam(value = "float", defaultValue = "1.5f") float f) {
    return new Number(n,f);
  }
}
