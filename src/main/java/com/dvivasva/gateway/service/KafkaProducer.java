package com.dvivasva.gateway.service;

import com.dvivasva.gateway.entity.Wallet;
import com.dvivasva.gateway.utils.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducer {
    private static final Logger logger= LoggerFactory.getLogger(KafkaProducer.class);


    @Autowired
    public KafkaTemplate<String, String> stringKafkaTemplate;
    @Autowired
    public KafkaTemplate<String, Wallet> walletKafkaTemplate;




    public void sendMessage(String value) {
        ListenableFuture<SendResult<String,String>> future = stringKafkaTemplate.send(Topic.INS_WALLET, value);

        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Messages failed to push on topic: "+Topic.INS_WALLET);
            }
            @Override
            public void onSuccess(Object result) {
                logger.info("Messages successfully pushed on topic: "+Topic.INS_WALLET);
            }
        });
    }

    public void sendMessage(Wallet value) {
        ListenableFuture<SendResult<String,Wallet>> future = walletKafkaTemplate.send(Topic.INS_WALLET_JSON, value);
        future.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Messages failed to push on topic: "+Topic.INS_WALLET_JSON);
            }
            @Override
            public void onSuccess(Object result) {

                logger.info("Messages failed to push on topic: "+Topic.INS_WALLET_JSON);
            }
        });
    }
}
