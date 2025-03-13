package br.edu.insper.insperclicker.game.resource;

public class LeveledGameResource extends GameResource
{
    private int level;


    public LeveledGameResource(String name, String displayName, String description, int level)
    {
        super(name, displayName, description);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    protected void setLevel(int level)
    {
        this.level = level;
    }

    protected void addToLevel(int amount) { this.level += amount; }


}
