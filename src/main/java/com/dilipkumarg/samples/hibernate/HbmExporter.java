package com.dilipkumarg.samples.hibernate;

import java.io.File;
import java.net.URISyntaxException;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.ant.ConfigurationTask;
import org.hibernate.tool.ant.JDBCConfigurationTask;
import org.hibernate.tool.hbm2x.HibernateMappingExporter;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 11/8/15
 */
public class HbmExporter {

    public void export(Configuration configuration, File outDir) {
        HibernateMappingExporter mappingExporter = new HibernateMappingExporter(configuration, outDir);
        mappingExporter.start();
    }

    public static void main(String[] args) throws URISyntaxException {
        ConfigurationTask configurationTask = new JDBCConfigurationTask();
        configurationTask.setConfigurationFile(new File(HbmExporter.class.getResource("/hibernate.cfg.xml").toURI()));
        File outDir = new File("target");
        outDir.mkdir();
        HbmExporter exporter = new HbmExporter();
        exporter.export(configurationTask.getConfiguration(), outDir);
    }
}
