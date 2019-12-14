package com.codeaches.pi4j.led;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Configuration
public class GpioLEDConfiguration {

  @Bean
  public GpioController gpioController() {
    return GpioFactory.getInstance();
  }

  @Bean("pin")
  GpioPinDigitalOutput pin() {
    return gpioController().provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
  }

  @PreDestroy
  void preDestroy() {
    gpioController().shutdown();
  }
}