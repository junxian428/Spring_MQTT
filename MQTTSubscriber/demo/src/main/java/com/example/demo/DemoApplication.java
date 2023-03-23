package com.example.demo;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.demo.Config.MqttSubscriber;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws MqttException {
        MqttSubscriber mqtt = new MqttSubscriber();
        mqtt.start();
        new SpringApplicationBuilder(DemoApplication.class)
                .run(args);
    }



}