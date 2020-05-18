package me.lucashagen.mcstats.api;

public enum Lang {

    ERROR_CONSOLE("Error occurred: %s"),
    CREATING_CONFIG("Config file not found. " +
            "Creating default config file."),
    CONFIG_ERROR("FATAL ERROR! ERROR WHILE LOADING CONFIG FILE!"),
    ;

    private final String message;

    Lang(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }

    public String getMessage(String... args)
    {
        return String.format(this.message, args);
    }

    @Override
    public String toString()
    {
        return this.getMessage();
    }


}
