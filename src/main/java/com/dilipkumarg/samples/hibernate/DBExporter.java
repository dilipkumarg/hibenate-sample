package com.dilipkumarg.samples.hibernate;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 11/8/15
 */
public class DBExporter {

    public void export(Configuration configuration) {

      /*  SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.execute(true, true, true, false);*/
        SchemaUpdate update = new SchemaUpdate(configuration);
        update.setOutputFile(new File("target", "ddl.sql").getAbsolutePath());
        update.execute(true, false);
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        DBExporter exporter = new DBExporter();
        Configuration configuration = new Configuration();
        final Properties properties = new Properties();
        properties.load(HbmExporter.class.getResourceAsStream("/hbm.properties"));
        configuration.setProperties(properties);
        configuration.addInputStream(HbmExporter.class.getResourceAsStream("/mappings.hbm.xml"));

        exporter.export(configuration);
    }


}
