package com.codeaches.pi4j.led;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

@RestController
public class MyRestController {

  @Autowired
  @Qualifier("pin01")
  GpioPinDigitalOutput pin01;

  @GetMapping("/toggleLED")
  public void toggleLED() {
    pin01.toggle();
  }
}