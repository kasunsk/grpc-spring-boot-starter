package com.creative.primelog.dao;

import com.creative.primelog.model.Invoice;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class InvoiceDaoImpl implements InvoiceDao {

    @Override
    public String createInvoice(Invoice invoice) {
        System.out.println("Assumption : Hit the database");
        return "abc123";
    }
}
