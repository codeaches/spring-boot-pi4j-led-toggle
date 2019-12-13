package com.codeaches.pi4j.led;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

@RestController
public class MyRestController {

  Logger log = LoggerFactory.getLogger(MyRestController.class);

  @Autowired
  @Qualifier("pin01")
  GpioPinDigitalOutput pin01;

  @GetMapping("/toggleLED")
  public void toggleLED() {

    String state = pin01.getState().isHigh() ? "ON" : "OFF";
    log.info("PIN01 state before toggle: " + state);

    pin01.toggle();

    state = pin01.getState().isHigh() ? "ON" : "OFF";
    log.info("PIN01 state after toggle: " + state);
  }
}