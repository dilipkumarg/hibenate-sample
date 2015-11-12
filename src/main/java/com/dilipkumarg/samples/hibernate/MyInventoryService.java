package com.dilipkumarg.samples.hibernate;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 10/9/15
 */
public class MyInventoryService implements InventoryService {

    private List<Inventory> inventories = new LinkedList<>();

    @Override
    public Inventory create(final Inventory inventory) {
        inventories.add(inventory);
        return inventory;
    }

    @Override
    public List<Inventory> list() {
        return inventories;
    }
}
