package com.dilipkumarg.samples.hibernate;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    public static void main(String[] args) throws URISyntaxException, IOException {
        ConfigurationTask configurationTask = new JDBCConfigurationTask();
        configurationTask.setConfigurationFile(new File(HbmExporter.class.getResource("/hibernate.cfg.xml").toURI()));
        File outDir = new File("target", "hbm");
        deleteRecursively(outDir);
        outDir.mkdir();
        HbmExporter exporter = new HbmExporter();
        exporter.export(configurationTask.getConfiguration(), outDir);
        combineFiles(outDir);
    }

    private static void combineFiles(File dir) throws IOException {
        List<CharSequence> combinedLines = new LinkedList<>();
        combinedLines.add("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        combinedLines.add("<!DOCTYPE hibernate-mapping PUBLIC \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
        combinedLines.add("\"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">");
        final String startTag = "<hibernate-mapping>";
        final String endTag = "</hibernate-mapping>";
        combinedLines.add(startTag);
        for (final File file : dir.listFiles()) {
            final List<String> strings = Files.readAllLines(file.toPath());
            boolean startFound = false;
            for (int i = 0, stringsSize = strings.size(); i < stringsSize; i++) {
                final String line = strings.get(i);
                if (startFound) {
                    if (!Objects.equals(line, endTag)) {
                        combinedLines.add(line);
                    }
                } else {
                    if (Objects.equals(line, startTag)) {
                        startFound = true;
                    }
                }
            }
        }
        combinedLines.add(endTag);
        final File combinedFile = new File(dir, "combined.xml");
        Files.write(combinedFile.toPath(), combinedLines, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        System.out.println(combinedFile.getCanonicalPath());
    }


    public static void deleteRecursively(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                for (final File file1 : file.listFiles()) {
                    deleteRecursively(file1);
                }
            } else {
                file.delete();
            }
        }
    }
}
