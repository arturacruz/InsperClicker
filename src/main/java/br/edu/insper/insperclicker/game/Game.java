package br.edu.insper.insperclicker.game;

import br.edu.insper.insperclicker.exception.GameResourceNotFoundException;

import java.time.LocalDateTime;

public class Game
{

    private LocalDateTime lastRequest;
    private final Graduation graduation;
    private Player player;

    public Game(String playerName)
    {
        // TODO: Call init functions
        System.out.println("Initializing game.");
        lastRequest = LocalDateTime.now();
        this.graduation = new Graduation();

        this.player = new Player(playerName);

        // TODO: Main game logic
        System.out.println("Starting game.");
    }

    public void doPassiveActions()
    {

        this.graduation.doMoneyPerSec(lastRequest);
        updateLastRequest();
    }

    public void click(int clickAmount)
    {
        this.graduation.click(clickAmount);
    }

    public void buyBuilding(String buildingName, int amount) throws GameResourceNotFoundException
    {
        graduation.buyBuilding(buildingName, amount);
    }

    public void buyUpgrade(String upgradeName) throws GameResourceNotFoundException
    {
        graduation.buyUpgrade(upgradeName);
    }

    public Graduation getCurrentGraduation()
    {
        return this.graduation;
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
