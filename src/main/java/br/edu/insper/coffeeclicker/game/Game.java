package br.edu.insper.coffeeclicker.game;

import java.time.LocalDateTime;

public class Game
{

    private LocalDateTime lastRequest;
    private Ascension ascension;

    public Game()
    {
        // TODO: Call init functions
        System.out.println("Initializing game.");
        lastRequest = LocalDateTime.now();
        this.ascension = new Ascension();

        // TODO: Main game logic
        System.out.println("Starting game.");
    }

    public void doPassiveActions()
    {
        this.ascension.doCoffeePerSec(lastRequest);
        this.lastRequest = LocalDateTime.now();
    }

    public void click(int clickAmount)
    {
        this.ascension.click(clickAmount);
    }

    public void buyBuilding(String buildingName)
    {

    }

    public Ascension getCurrentAscension()
    {
        return this.ascension;
    }

    public LocalDateTime getLastRequest()
    {
        return lastRequest;
    }

    public void updateLastRequest()
    {
        this.lastRequest = LocalDateTime.now();
    }
}
