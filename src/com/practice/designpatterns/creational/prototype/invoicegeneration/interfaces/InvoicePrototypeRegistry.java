package com.practice.designpatterns.creational.prototype.invoicegeneration.interfaces;

import com.practice.designpatterns.creational.prototype.invoicegeneration.Invoice;
import com.practice.designpatterns.creational.prototype.invoicegeneration.InvoiceType;

public interface InvoicePrototypeRegistry {
    void addPrototype(Invoice user);

    Invoice getPrototype(InvoiceType type);

    Invoice clone(InvoiceType type);
}
