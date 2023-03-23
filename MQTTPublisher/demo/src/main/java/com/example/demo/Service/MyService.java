package com.example.demo.Service;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.MQTT.MqttPublisher;

@Service
public class MyService {

    private final MqttPublisher mqttPublisher;

    @Autowired
    public MyService(MqttPublisher mqttPublisher) {
        this.mqttPublisher = mqttPublisher;
    }

    public void sendMessage(String topic, String message) throws MqttException {
        mqttPublisher.connect();
        mqttPublisher.publish(topic, message);
        mqttPublisher.disconnect();
    }
}