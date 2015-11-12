package com.dilipkumarg.samples.schemacrawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import schemacrawler.schema.Catalog;
import schemacrawler.schemacrawler.IncludeAll;
import schemacrawler.schemacrawler.SchemaCrawlerException;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.schemacrawler.SchemaInfoLevel;
import schemacrawler.schemacrawler.SchemaInfoLevelBuilder;
import schemacrawler.utility.SchemaCrawlerUtility;


/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 10/11/15
 */
public class App {
    public static void main(
            String[] args) throws SchemaCrawlerException, SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        final SchemaCrawlerOptions options = new SchemaCrawlerOptions();
// Set what details are required in the schema - this affects the
// time taken to crawl the schema

        final SchemaInfoLevel level = SchemaInfoLevelBuilder.standard();
//        level.setRetrieveSequenceInformation(true);
//        level.setRetrieveTriggerInformation(true);
        options.setSchemaInfoLevel(level);
        options.setSequenceInclusionRule(new IncludeAll());

        try (final Connection connection = getMySqlConnection()) {
//            options.setSchemaInclusionRule(s -> s.equalsIgnoreCase("DILIP"));
            options.setSchemaInclusionRule(s -> s.equalsIgnoreCase("all_mappings"));
//            options.setSchemaInclusionRule(s -> s.equalsIgnoreCase("face"));
            final Catalog catalog = SchemaCrawlerUtility.getCatalog(connection, options);

            catalog.getTables().forEach(table -> System.out.println("Name:" + table.getName()));

        }


    }

    private static Connection getMySqlConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Connection conn;
//        String url = "jdbc:mysql://217.72.79.177:3306/";
        String url = "jdbc:mysql://localhost:3306/";
//        String dbName = "face";
        String dbName = "all_mappings";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
//        String password = "3tav";
        String password = "pramati";
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url + dbName, userName, password);
        System.out.println("Connected to the database");
        return conn;
    }

    private static Connection getOracleConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class.forName("oracle.jdbc.driver.OracleDriver");


        System.out.println("Oracle JDBC Driver Registered!");


        return DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.2.22:1521:XE", "dilip", "dilip");
    }
}
