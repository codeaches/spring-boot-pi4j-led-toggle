package com.codeaches.pi4j.led;

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
public class GpioConfiguration {

  Logger log = LoggerFactory.getLogger(GpioConfiguration.class);

  @Bean
  public GpioController gpioController() {
    return GpioFactory.getInstance();
  }

  @Bean("pin01")
  GpioPinDigitalOutput pin01() {
    return gpioController().provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
  }
}
