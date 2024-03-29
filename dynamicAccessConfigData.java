public class Configuration {

    /**
     * Provide access to application properties.
     */
    private static final String PROPERTIES_FILE = "config.properties";
    private Properties props = null;

    //TODO make this a Singleton
    public Configuration() {
        loadProperties(PROPERTIES_FILE);
    }

    /** load properties from file */
    private void loadProperties(String filename) {
        props = new Properties();
        InputStream instream = null;
        // find the file as application resource
        ClassLoader loader = this.getClass().getClassLoader();
        instream = loader.getResourceAsStream(filename);
        if (instream == null) {
            System.err.println("Unable to open properties file "+filename);
            return;
        }

        // Load all the properties
        try {
            props.load(instream);
        }
        catch (IOException e) {
            System.err.println("Error reading properties file "+filename);
            System.err.println(e.getMessage());
        }

        try {
            instream.close();
        } catch (IOException ioe) { /* should not happen */ }
    }


    public String getProperty(String dataFromConfigFile) {
        return props.getProperty(dataFromConfigFile);
    }
    
}
