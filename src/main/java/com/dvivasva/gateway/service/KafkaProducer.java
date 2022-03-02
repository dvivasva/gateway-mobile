package com.dvivasva.gateway.service;

import com.dvivasva.gateway.entity.Payment;
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
    public Payment publishEvent(Payment payment){
        kafkaTemplate.send(Topic.INS_PAYMENT,payment);
        logger.info("Messages successfully pushed on topic: " + Topic.INS_PAYMENT);
        return payment;
    }



    /*
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    public KafkaTemplate<String, Wallet> walletKafkaTemplate;
    @Autowired
    public KafkaTemplate<String, Payment> paymentKafkaTemplate;
    @Autowired
    public KafkaTemplate<String, Account> accountKafkaTemplate;


    public void sendMessageWallet(String value) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(Topic.INS_WALLET, value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Messages failed to push on topic: " + Topic.INS_WALLET);
            }

            @Override
            public void onSuccess(Object result) {
                logger.info("Messages successfully pushed on topic: " + Topic.INS_WALLET);
            }
        });
    }

    public void sendMessagePayment(Payment value) {
        ListenableFuture<SendResult<String, Payment>> future = paymentKafkaTemplate.send(Topic.INS_PAYMENT, value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Messages failed to push on topic: " + Topic.INS_PAYMENT);
            }

            @Override
            public void onSuccess(Object result) {

                logger.info("Messages failed to push on topic: " + Topic.INS_PAYMENT);
            }
        });
    }

    public void sendMessageWallet(Wallet value) {
        ListenableFuture<SendResult<String, Wallet>> future = walletKafkaTemplate.send(Topic.INS_WALLET, value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Messages failed to push on topic: " + Topic.INS_WALLET);
            }

            @Override
            public void onSuccess(Object result) {

                logger.info("Messages failed to push on topic: " + Topic.INS_WALLET);
            }
        });
    }


    public void sendMessageAccount(Account value) {
        ListenableFuture<SendResult<String, Account>> future = accountKafkaTemplate.send(Topic.INS_ACCOUNT, value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Messages failed to push on topic: " + Topic.INS_ACCOUNT);
            }

            @Override
            public void onSuccess(Object result) {

                logger.info("Messages failed to push on topic: " + Topic.INS_ACCOUNT);
            }
        });
    }*/
}
