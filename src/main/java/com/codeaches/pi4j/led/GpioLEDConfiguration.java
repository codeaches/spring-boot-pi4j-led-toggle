package com.codeaches.pi4j.led;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Configuration
public class GpioLEDConfiguration {
  Logger log = LoggerFactory.getLogger(GpioLEDConfiguration.class);

  @Bean
  public GpioController gpioController() {

    // create gpio controller
    return GpioFactory.getInstance();
  }

  @Bean("pin01")
  GpioPinDigitalOutput pin01() {

    // provision gpio pin #01 as an output pin and turn off
    GpioPinDigitalOutput pin01 = gpioController().provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);

    // configure the pin shutdown behavior; these settings will be
    // automatically applied to the pin when the application is terminated
    pin01.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);

    return pin01;
  }

  @PreDestroy
  void preDestroy() {

    // stop all GPIO activity/threads by shutting down the GPIO controller
    // (this method will forcefully shutdown all GPIO monitoring threads and
    // scheduled tasks)

    if (!gpioController().isShutdown()) {
      gpioController().shutdown();
    }
  }
}