package me.lucashagen.mcstats.api;

public enum Lang {

    ERROR_CONSOLE("Error occurred: %s"),
    ;

    private String message;

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


}
