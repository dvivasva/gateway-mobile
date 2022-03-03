package com.dvivasva.gateway.service;

import com.dvivasva.gateway.entity.Payment;
import com.dvivasva.gateway.entity.Wallet;
import com.dvivasva.gateway.utils.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger logger= LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    public Payment eventCreatePayment(Payment payment){
        kafkaTemplate.send(Topic.INS_PAYMENT,payment);
        logger.info("Messages successfully pushed on topic: " + Topic.INS_PAYMENT);
        return payment;
    }

    @Autowired
    public KafkaTemplate<String, Wallet> walletKafkaTemplate;
    public Wallet eventCreateWallet(Wallet wallet){
        walletKafkaTemplate.send(Topic.INS_WALLET,wallet);
        logger.info("Messages successfully pushed on topic: " + Topic.INS_WALLET);
        return wallet;
    }


}
