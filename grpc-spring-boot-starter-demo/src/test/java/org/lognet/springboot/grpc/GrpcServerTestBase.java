package org.lognet.springboot.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.CalculatorGrpc;
import io.grpc.examples.CalculatorOuterClass;
import io.grpc.examples.Greeter.GreeterGrpc;
import io.grpc.examples.Greeter.GreeterOuterClass;
import io.grpc.inprocess.InProcessChannelBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class GrpcServerTestBase {

    @Autowired(required = false)
    @Qualifier("grpcServerRunner")
    protected GRpcServerRunner grpcServerRunner;

    @Autowired(required = false)
    @Qualifier("grpcInprocessServerRunner")
    protected GRpcServerRunner grpcInprocessServerRunner;


    protected ManagedChannel channel;
    protected ManagedChannel inProcChannel;

    @Autowired
    protected ApplicationContext context;

    @Autowired
    protected GRpcServerProperties gRpcServerProperties;

    @Before
    public final void setupChannels() {
        if(gRpcServerProperties.isEnabled()) {
            channel = onChannelBuild(ManagedChannelBuilder.forAddress("localhost", gRpcServerProperties.getPort())
                    .usePlaintext(true)
                    ).build();
        }
        if(StringUtils.hasText(gRpcServerProperties.getInProcessServerName())){
            inProcChannel = onChannelBuild(
                                InProcessChannelBuilder.forName(gRpcServerProperties.getInProcessServerName())
                                .usePlaintext(true)
                            ).build();

        }
    }

    protected ManagedChannelBuilder<?>  onChannelBuild(ManagedChannelBuilder<?> channelBuilder){
        return  channelBuilder;
    }

    protected InProcessChannelBuilder onChannelBuild(InProcessChannelBuilder channelBuilder){
        return  channelBuilder;
    }

    @After
    public final void shutdownChannels() {
        Optional.ofNullable(channel).ifPresent(ManagedChannel::shutdownNow);
        Optional.ofNullable(inProcChannel).ifPresent(ManagedChannel::shutdownNow);
    }

    @Test
    public void simpleCalculating() throws ExecutionException, InterruptedException {

        final CalculatorGrpc.CalculatorFutureStub calculatorFutureStub = CalculatorGrpc.newFutureStub(Optional.ofNullable(channel).orElse(inProcChannel));
        final CalculatorOuterClass.CalculatorRequest request = CalculatorOuterClass.CalculatorRequest.newBuilder().setNumber1(20).setNumber2(15)
                .setOperation(CalculatorOuterClass.CalculatorRequest.OperationType.SUBTRACT).build();
        final Double answer = calculatorFutureStub.calculate(request).get().getResult();
        System.out.println("Congratulation!!! It Works.");
        System.out.println("Answer is : " + answer);
        assertEquals(5, answer.intValue());
    }

    @Test
    public void simpleGreeting() throws ExecutionException, InterruptedException {


        String name ="Kasun";
        final GreeterGrpc.GreeterFutureStub greeterFutureStub = GreeterGrpc.newFutureStub(Optional.ofNullable(channel).orElse(inProcChannel));
        final GreeterOuterClass.HelloRequest helloRequest =GreeterOuterClass.HelloRequest.newBuilder().setName(name).build();
        final String reply = greeterFutureStub.sayHello(helloRequest).get().getMessage();
        assertNotNull("Replay should not be null",reply);
        assertTrue(String.format("Replay should contain name '%s'",name),reply.contains(name));
        afterGreeting();

    }
    protected void afterGreeting(){

    }
}
