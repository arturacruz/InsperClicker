package br.edu.insper.insperclicker.game.resource;

public class GameResource
{
    private String displayName;
    private String name;
    private String description;

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

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
