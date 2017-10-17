package com.creative.primelog.adaptor;

import com.creative.primelog.model.Invoice;
import io.grpc.primelog.invoice.InvoiceOuterClass.InvoiceRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class InvoiceAdaptor {

    private ModelMapper modelMapper = new ModelMapper();

    public Invoice fromDto(InvoiceRequest invoiceRequest) {

        PropertyMap<InvoiceRequest, Invoice> invoicePropertyMap = new PropertyMap<InvoiceRequest, Invoice>() {
            protected void configure() {
            }
        };

        modelMapper.addMappings(invoicePropertyMap);
        return modelMapper.map(invoiceRequest, Invoice.class);
    }
}
