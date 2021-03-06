package org.lognet.springboot.grpc.demo;


import io.grpc.examples.calculator.CalculatorGrpc;
import io.grpc.examples.calculator.CalculatorOuterClass;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.grpc.stub.StreamObserver;

/**
 * Created by alexf on 28-Jan-16.
 */

@GRpcService(interceptors = NotSpringBeanInterceptor.class)
public class CalculateService extends CalculatorGrpc.CalculatorImplBase {

    @Override
    public void calculate(CalculatorOuterClass.CalculatorRequest request, StreamObserver<CalculatorOuterClass.CalculatorResponse> responseObserver) {
        CalculatorOuterClass.CalculatorResponse.Builder resultBuilder = CalculatorOuterClass.CalculatorResponse.newBuilder();
        switch (request.getOperation()) {
            case ADD:
                resultBuilder.setResult(request.getNumber1() + request.getNumber2());
                break;
            case SUBTRACT:
                resultBuilder.setResult(request.getNumber1() - request.getNumber2());
                break;
            case MULTIPLY:
                resultBuilder.setResult(request.getNumber1() * request.getNumber2());
                break;
            case DIVIDE:
                resultBuilder.setResult(request.getNumber1() / request.getNumber2());
                break;
            case UNRECOGNIZED:
                break;
        }

        try {
            System.out.println("Sleeping for 10 sec");
            Thread.sleep(10000);
            System.out.println("Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        responseObserver.onNext(resultBuilder.build());
        responseObserver.onCompleted();
    }


}


