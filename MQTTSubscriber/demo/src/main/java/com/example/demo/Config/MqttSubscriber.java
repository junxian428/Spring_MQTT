package com.example.demo.Config;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class MqttSubscriber {

    private static final String BROKER_URL = "tcp://127.0.0.1:1883";
    private static final String TOPIC = "Hello";

    public void start() throws MqttException {
        MqttClient client = new MqttClient(BROKER_URL, MqttClient.generateClientId());
        System.out.println("MQTT Subscriber started");
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);

        client.connect(options);

        client.subscribe(TOPIC, new IMqttMessageListener() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println("Received message: " + message.toString());
            }
        });
    }
}
