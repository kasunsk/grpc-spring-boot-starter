package org.lognet.springboot.grpc.demo;

import io.grpc.examples.CalculatorGrpc;
import io.grpc.examples.CalculatorOuterClass;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.GreeterOuterClass;
import io.grpc.stub.StreamObserver;


@GRpcService(interceptors = { LogInterceptor.class })
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    Logger log = LoggerFactory.getLogger(GreeterService.class);

    @Override
    public void sayHello(GreeterOuterClass.HelloRequest request, StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
        String message = "Hello " + request.getName();
        final GreeterOuterClass.HelloReply.Builder replyBuilder = GreeterOuterClass.HelloReply.newBuilder().setMessage(message);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
        log.info("Returning " +message);
    }
}