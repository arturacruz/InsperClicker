package br.edu.insper.insperclicker.game.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players")
public class Player
{
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private double bitcoins = 0;
    private double buildingProductionBonus = 0;
    private double buildingDiscountBonus = 0;

    private Game game;


    public Player(String name)
    {
        this.game = new Game();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public double getBitcoins()
    {
        return bitcoins;
    }

    public void setBitcoins(double bitcoins) {
        this.bitcoins = bitcoins;
    }

    public double getBuildingProductionBonus()
    {
        return buildingProductionBonus;
    }

    public void setBuildingProductionBonus(double buildingProductionBonus)
    {
        this.buildingProductionBonus = buildingProductionBonus;
    }

    public double getBuildingDiscountBonus()
    {
        return buildingDiscountBonus;
    }

    public void setBuildingDiscountBonus(double buildingDiscountBonus)
    {
        this.buildingDiscountBonus = buildingDiscountBonus;
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
