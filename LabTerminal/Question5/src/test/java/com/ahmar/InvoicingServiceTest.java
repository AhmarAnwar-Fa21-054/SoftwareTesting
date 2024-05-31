package com.ahmar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
class InvoicingServiceTest {
    InvoicingService service;
    InvoicingPortal portal;
    @BeforeEach
    void setUp() {
        portal = mock(InvoicingPortal.class);
        service = new InvoicingService(portal);
    }

    @Test
    void itShouldReturnListOfFailedInvoices() {
        //Given
        Invoice ahmar = new Invoice("Ahmar","abc","9",80);
        doThrow(RuntimeException.class).when(portal).upload(ahmar);
        //When
       var failedInvoices =  service.sendInvoice(ahmar);
        //Then
        assertThat(failedInvoices).containsExactly(ahmar);

    }
    @Test
    void itShouldUploadInvoiceToThePortalAndListOfFailedInvoicesIsEmpty() {
        //Given
        Invoice ahmar = new Invoice("Ahmar","abc","9",80);
        //When
        var failedInvoices =  service.sendInvoice(ahmar);
        //Then
        assertThat(failedInvoices).isEmpty();

    }
}