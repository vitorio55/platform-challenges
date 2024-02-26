package com.vitorio.util.codegeneration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class CodeGenerator {

    private static final String VELOCITY_PROPERTIES_FILE = "src/main/java/com/vitorio/util/codegeneration/velocity.properties";

    private static Configuration config;

    public static void main(String[] args) throws IOException, ConfigurationException {
        // Load properties
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
            new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                .configure(params.properties()
                    .setFileName(VELOCITY_PROPERTIES_FILE));
        config = builder.getConfiguration();

        // Initialize the Velocity engine
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init(VELOCITY_PROPERTIES_FILE);

        // Set up the context with our template variables
        VelocityContext context = new VelocityContext();
        context.put("className", config.getString("class.name"));
        context.put("packageName", config.getString("package.name"));
        context.put("week", config.getString("week"));

        generateSolutionsClass(velocityEngine, context);
        generateUnitTestsClass(velocityEngine, context);
        createUnitTestsResourcesDir();
    }

    private static void generateSolutionsClass(VelocityEngine velocityEngine, VelocityContext context) throws IOException {
        // Load the template
        Template template = velocityEngine.getTemplate(config.getString("solutions.templatefile"));

        // Generate the Java code
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        createDir(config.getString("solutions.dir"));
        String filePath = config.getString("solutions.class.name") + ".java";
        filePath = config.getString("solutions.dir") + "/" + filePath;
        writeToToFile(filePath, writer);
    }

    private static void generateUnitTestsClass(VelocityEngine velocityEngine, VelocityContext context) throws IOException {
        // Load the template
        Template template = velocityEngine.getTemplate(config.getString("unit.tests.templatefile"));

        // Generate the Java code
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        createDir(config.getString("solutions.tests.dir"));
        String filePath = config.getString("solutions.tests.class.name") + ".java";
        filePath = config.getString("solutions.tests.dir") + "/" + filePath;
        writeToToFile(filePath, writer);
    }

    private static void createDir(String dirName) {
        new File(dirName).mkdirs();
    }

    private static void createUnitTestsResourcesDir() throws IOException {
        new File(config.getString("unit.tests.resources.dir")).mkdirs();
        new File(config.getString("unit.tests.resources.dir") + "/case0").mkdirs();
        new File(config.getString("unit.tests.resources.dir") + "/case0/input.txt").createNewFile();
        new File(config.getString("unit.tests.resources.dir") + "/case0/output.txt").createNewFile();
    }

    private static void writeToToFile(String filePath, StringWriter writer) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(writer.toString());
        fw.close();
    }
}