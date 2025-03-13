package br.edu.insper.insperclicker.game.resource;

public class GameResource
{
    private final String displayName;
    private final String name;
    private final String description;

    public GameResource(String name, String displayName, String description)
    {
        this.displayName = displayName;
        this.name = name;
        this.description = description;
    }

    public String getDisplayName()
    {
        return displayName;
    }


    public String getName()
    {
        return name;
    }


    public String getDescription() {
        return description;
    }


}
