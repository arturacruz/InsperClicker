package br.edu.insper.coffeeclicker.game;

import br.edu.insper.coffeeclicker.exception.GameResourceNotFoundException;
import br.edu.insper.coffeeclicker.game.building.Building;

import javax.naming.NameNotFoundException;
import java.time.LocalDateTime;

public class Game
{

    private LocalDateTime lastRequest;
    private final Ascension ascension;
    private Player player;

    public Game(String playerName)
    {
        // TODO: Call init functions
        System.out.println("Initializing game.");
        lastRequest = LocalDateTime.now();
        this.ascension = new Ascension();

        this.player = new Player(playerName);

        // TODO: Main game logic
        System.out.println("Starting game.");
    }

    public void doPassiveActions()
    {

        this.ascension.doCoffeePerSec(lastRequest);
        updateLastRequest();
    }

    public void click(int clickAmount)
    {
        this.ascension.click(clickAmount);
    }

    public void buyBuilding(String buildingName, int amount) throws GameResourceNotFoundException
    {
        ascension.buyBuilding(buildingName, amount);
    }

    public void buyUpgrade(String upgradeName) throws GameResourceNotFoundException
    {
        ascension.buyUpgrade(upgradeName);
    }

    public Ascension getCurrentAscension()
    {
        return this.ascension;
    }

    public LocalDateTime getLastRequest()
    {
        return lastRequest;
    }

    private void updateLastRequest()
    {
        this.lastRequest = LocalDateTime.now();
    }

    public Player getPlayer() {
        return player;
    }
}
