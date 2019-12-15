package com.codeaches.pi4j.led;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Configuration
public class GpioLEDConfiguration {

  Logger log = LoggerFactory.getLogger(GpioLEDConfiguration.class);

  @Bean
  public GpioController gpioController() {
    return GpioFactory.getInstance();
  }

  // GPIO_02 - works for led
  // GPIO_03 - works for led
  // GPIO_04 - works for led
  // GPIO_05 - works for led
  // GPIO_06 - works for led
  @Bean("pin")
  GpioPinDigitalOutput pin() {

    GpioPinDigitalOutput pin = gpioController().provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);
    log.info("Configured GPIO_07 as output pin with default set to LOW");
    return pin;
  }

  @PreDestroy
  void preDestroy() {
    gpioController().shutdown();
  }
}