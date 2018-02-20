package org.lognet.springboot.grpc.demo;

import io.grpc.examples.GreeterOuterClass;
import io.grpc.examples.InvoiceGrpc;
import io.grpc.examples.InvoiceOuterClass;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService(interceptors = LogInterceptor.class)
public class InvoiceService extends InvoiceGrpc.InvoiceImplBase {

    private Logger log = LoggerFactory.getLogger(GreeterService.class);

    @Override
    public void issueInvoice(InvoiceOuterClass.InvoiceRequest request, StreamObserver<InvoiceOuterClass.InvoiceResponse> responseObserver) {

        String message = "Saved " + request.getInvoiceid();
        final InvoiceOuterClass.InvoiceResponse.Builder invoiceBuilder = InvoiceOuterClass.InvoiceResponse.newBuilder().setInvoicename("Test invoice");
        responseObserver.onNext(invoiceBuilder.build());
        responseObserver.onCompleted();
        log.info("Returning " + message);
    }
}
