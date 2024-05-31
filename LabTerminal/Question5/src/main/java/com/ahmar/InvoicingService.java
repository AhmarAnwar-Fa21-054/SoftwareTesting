package com.ahmar;

import java.util.ArrayList;
import java.util.List;

public class InvoicingService {

    InvoicingPortal invoicingPortal;

    public InvoicingService(InvoicingPortal invoicingPortal) {
        this.invoicingPortal = invoicingPortal;
    }

    public List<Invoice> sendInvoice(Invoice invoice) {
        List<Invoice> failedInvoices = new ArrayList<>();

        try {
            invoicingPortal.upload(invoice);
        } catch (RuntimeException e) {
            failedInvoices.add(invoice);
        }

        return failedInvoices;
    }
}
