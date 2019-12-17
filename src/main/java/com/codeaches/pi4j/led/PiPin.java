package com.codeaches.pi4j.led;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public class PiPin {

  /**
   * Raspberry pi: Pin number 3 / GPIO 2 / SDA-1 / Pi4J-RaspiPin.GPIO_08 Defaulted
   * to LOW on startup
   */
  public static final Pin GPIO_02 = RaspiPin.GPIO_08;

  /**
   * Raspberry pi: Pin number 5 / GPIO 3 / SCL-1 / Pi4J-RaspiPin.GPIO_09 Defaulted
   * to LOW on startup
   */
  public static final Pin GPIO_03 = RaspiPin.GPIO_09;

  /**
   * Raspberry pi: Pin number 7 / GPIO 4 / GPCLK-0 / Pi4J-RaspiPin.GPIO_07
   * Defaulted to OFF on startup
   */
  public static final Pin GPIO_04 = RaspiPin.GPIO_07;

  /**
   * Raspberry pi: Pin number 8 / GPIO 14 / TXD-0 / Pi4J-RaspiPin.GPIO_15 Defaulted
   * to OFF on startup
   */
  public static final Pin GPIO_14 = RaspiPin.GPIO_15;
}
