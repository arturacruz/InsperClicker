package br.edu.insper.insperclicker.game.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players")
public class Player
{
    @Id
    private String id;

    @Indexed(unique = true)
    private final String name;
    private final String password;

    private double bitcoins;
    private double buildingProductionBonus;
    private double buildingDiscountBonus;

    private final Game game;

    public Player(String id, String name, String password, double bitcoins, double buildingProductionBonus, double buildingDiscountBonus, Game game)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.bitcoins = bitcoins;
        this.buildingProductionBonus = buildingProductionBonus;
        this.buildingDiscountBonus = buildingDiscountBonus;
        this.game = game;
    }

    public Player(String name, String password)
    {
        this.password = password;
        this.name = name;
        this.game = new Game();
        this.bitcoins = 0;
        this.buildingDiscountBonus = 0;
        this.buildingProductionBonus = 0;
    }

    public String getName()
    {
        return name;
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

    public String getPassword()
    {
        return password;
    }
}
