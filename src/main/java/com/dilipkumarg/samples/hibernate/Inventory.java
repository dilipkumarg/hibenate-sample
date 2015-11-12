package com.dilipkumarg.samples.hibernate;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 10/9/15
 */
public class Inventory {
    private String name;

    public Inventory(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                '}';
    }
}
