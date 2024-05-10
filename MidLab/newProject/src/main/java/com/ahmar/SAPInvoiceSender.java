package com.ahmar;

import com.adilhassan.stub.Invoice;
import com.adilhassan.stub.InvoiceFilter;

import java.util.ArrayList;
import java.util.List;

public class SAPInvoiceSender {

    private final InvoiceFilter filter;
    private final SAP sap;

    public SAPInvoiceSender(InvoiceFilter filter, SAP sap) {
        this.filter = filter;
        this.sap = sap;
    }

    public List<Invoice> sendLowValuedInvoices() {
        List<Invoice> failedInvoices = new ArrayList<>();

        List<Invoice> lowValuedInvoices = filter.lowValueInvoices();
        for(Invoice invoice : lowValuedInvoices) {
            try {
                sap.send(invoice);
            } catch(SAPException e) {
                failedInvoices.add(invoice);
            }
        }

        return failedInvoices;
    }
}
