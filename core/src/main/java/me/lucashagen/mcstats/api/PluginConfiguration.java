package me.lucashagen.mcstats.api;

public interface PluginConfiguration {

    /**
     * Gets a Object from the config file of the plugin
     *
     * @param key YML key
     * @return Object
     */
    public Object get(String key);

    /**
     * Gets a String from the config file of the plugin
     *
     * @param key YML key
     * @return String
     */
    public String getString(String key);

    /**
     * Gets a Boolean from the config file of the plugin
     *
     * @param key YML key
     * @return Boolean
     */
    public boolean getBoolean(String key);

    /**
     * Gets a int from the config file of the plugin
     *
     * @param key YML key
     * @return int
     */
    public int getInt(String key);

}
