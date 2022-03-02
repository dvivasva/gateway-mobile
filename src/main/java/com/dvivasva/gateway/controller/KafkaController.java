package com.dvivasva.gateway.controller;

import com.dvivasva.gateway.entity.Payment;
import com.dvivasva.gateway.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banking-mobile")
public class KafkaController {


    private final KafkaProducer receiver;
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    private final InteractiveQueryService queryService;


    @PostMapping("/payment")
    public ResponseEntity<Payment> getObject(@RequestBody Payment payment){
        var value= this.receiver.publishEvent(payment);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Payment getAllPayment() {
        ReadOnlyKeyValueStore<String, Payment> keyValueStore =
                queryService.getQueryableStore("all-payment-store",
                        QueryableStoreTypes.keyValueStore());
        return keyValueStore.get("NEW");
    }









    //private final StreamBridge streamBridge;


    /*@GetMapping("/wallet/{numberPhone}")
    public void send(@PathVariable String numberPhone) {
        kafkaProducer.sendMessageWallet(numberPhone);

    }*/

    /*@PostMapping("/payment")
    public void send(@RequestBody Payment payment) {
        kafkaProducer.sendMessagePayment(payment);
    }*/


    /*@PostMapping("/wallet")
    public void send(@RequestBody Wallet wallet) {
        kafkaProducer.sendMessageWallet(wallet);
    }


    @PostMapping("/account")
    public void send(@RequestBody Account account) {
        kafkaProducer.sendMessageAccount(account);
    }*/



    //replyKafkaTemplate
   // private  RequestReplyFuture<String, SaleRequestFactory, SaleResponseFactory> requestReplyFuture;














   /* @RequestMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delegateToSupplier(@RequestBody String body) {
        logger.info("Sending" + body);
        streamBridge.send("toStream-out-0", body);
    }*/
}
