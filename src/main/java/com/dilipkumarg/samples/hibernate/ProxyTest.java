package com.dilipkumarg.samples.hibernate;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 10/9/15
 */
public class ProxyTest {

    public static void main(String[] args) {
        InventoryService inventoryService = (InventoryService) AuditProxy.newInstance(new MyInventoryService());

        inventoryService.create(new Inventory("1"));
        inventoryService.create(new Inventory("2"));
    }
}
