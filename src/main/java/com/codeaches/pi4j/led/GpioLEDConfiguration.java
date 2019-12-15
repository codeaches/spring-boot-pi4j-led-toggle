package com.codeaches.pi4j.led;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  public GpioController gpioController;

  @Bean("pin")
  GpioPinDigitalOutput pin() {

    return gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
  }

  @PreDestroy
  void preDestroy() {
    gpioController.shutdown();
  }
}