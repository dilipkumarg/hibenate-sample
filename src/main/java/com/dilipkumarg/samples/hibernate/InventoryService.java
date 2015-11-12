package com.dilipkumarg.samples.hibernate;

import java.util.List;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 10/9/15
 */
public interface InventoryService {
    Inventory create(Inventory inventory);

    List<Inventory> list();

}
