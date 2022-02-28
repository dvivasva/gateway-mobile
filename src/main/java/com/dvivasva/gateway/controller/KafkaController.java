package com.dvivasva.gateway.controller;

import com.dvivasva.gateway.entity.Wallet;
import com.dvivasva.gateway.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banking-mobile")
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    private final KafkaProducer kafkaProducer;
    private final StreamBridge streamBridge;


    @GetMapping("/wallet/{numberPhone}")
    public void send(@PathVariable String numberPhone) {
        kafkaProducer.sendMessage(numberPhone);

    }

    @PostMapping("/wallet")
    public void send(@RequestBody Wallet wallet) {
        kafkaProducer.sendMessage(wallet);
    }

    @RequestMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delegateToSupplier(@RequestBody String body) {
        logger.info("Sending" + body);
        streamBridge.send("toStream-out-1", body);
    }
}
