package com.practice.designpatterns.creational.prototype.invoicegeneration.impl;

import com.practice.designpatterns.creational.prototype.invoicegeneration.Invoice;
import com.practice.designpatterns.creational.prototype.invoicegeneration.InvoiceType;
import com.practice.designpatterns.creational.prototype.invoicegeneration.interfaces.InvoicePrototypeRegistry;

import java.util.HashMap;

public class InvoicePrototypeRegistryImpl implements InvoicePrototypeRegistry {
    HashMap<InvoiceType, Invoice> map = new HashMap<>();

    @Override
    public void addPrototype(Invoice invoice) {
        map.put(invoice.getType(), invoice);
    }

    @Override
    public Invoice getPrototype(InvoiceType type) {
        if(type != null) {
            return map.get(type);
        }
        return null;
    }

    @Override
    public Invoice clone(InvoiceType type) {
        if(type != null) {
            return map.get(type).cloneObject();
        }
        return null;
    }
}
