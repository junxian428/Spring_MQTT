package com.example.demo.Controller;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MQTT.MqttPublisher;

@RestController
public class MqttController {

    private final MqttPublisher mqttPublisher;

    @Autowired
    public MqttController(MqttPublisher mqttPublisher) {
        this.mqttPublisher = mqttPublisher;
    }

    /**
     * @param messageDto
     * @throws MqttException
     */
    @PostMapping("/publish")
    public void publishMessage(@RequestBody String message) throws MqttException {
        mqttPublisher.connect();
        mqttPublisher.publish("Hello",message);
        mqttPublisher.disconnect();
    }
}