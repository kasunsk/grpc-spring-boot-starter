package com.creative.primelog.service;

import com.creative.primelog.adaptor.InvoiceAdaptor;
import com.creative.primelog.dao.InvoiceDao;
import com.creative.primelog.interceptor.NotificationInterceptor;
import io.grpc.primelog.invoice.InvoiceGrpc;
import io.grpc.primelog.invoice.InvoiceOuterClass.InvoiceRequest;
import io.grpc.primelog.invoice.InvoiceOuterClass.InvoiceResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@GRpcService(interceptors = NotificationInterceptor.class)
public class InvoiceService extends InvoiceGrpc.InvoiceImplBase {

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    InvoiceAdaptor invoiceAdaptor;

    @Override
    public void issue(InvoiceRequest request, StreamObserver<InvoiceResponse> responseObserver) {

        String reference = invoiceDao.createInvoice(invoiceAdaptor.fromDto(request));
        InvoiceResponse.Builder resultBuilder = InvoiceResponse.newBuilder();
        resultBuilder.setReference(reference);

        responseObserver.onNext(resultBuilder.build());
        responseObserver.onCompleted();
    }

    public void setInvoiceDao(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }
}
