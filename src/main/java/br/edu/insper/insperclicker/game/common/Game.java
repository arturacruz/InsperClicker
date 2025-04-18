package br.edu.insper.insperclicker.game.common;

import br.edu.insper.insperclicker.exception.GameResourceAlreadyOwnedException;
import br.edu.insper.insperclicker.exception.GameResourceNotFoundException;
import br.edu.insper.insperclicker.exception.GameResourceNotUnlockedException;
import br.edu.insper.insperclicker.exception.InsufficientFundsException;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.time.LocalDateTime;

public class Game
{

    private LocalDateTime lastRequest;
    private final Graduation graduation;

    public Game(LocalDateTime lastRequest, Graduation graduation)
    {
        this.lastRequest = lastRequest;
        this.graduation = graduation;
    }

    public Game()
    {
        lastRequest = LocalDateTime.now();
        this.graduation = new Graduation();
    }

    public void doPassiveActions()
    {
        this.graduation.doPassiveActions(lastRequest);
        updateLastRequest();

    }

    public void click(int clickAmount)
    {
        this.graduation.click(clickAmount);
    }

    public void buyBuilding(String buildingName, int amount) throws GameResourceNotFoundException,
                                                                    InsufficientFundsException,
                                                                    GameResourceNotUnlockedException
    {
        graduation.buyBuilding(buildingName, amount);
    }

    public void buyUpgrade(String upgradeName) throws GameResourceNotFoundException,
                                                        GameResourceAlreadyOwnedException,
                                                        GameResourceNotUnlockedException,
                                                        InsufficientFundsException
    {
        graduation.buyUpgrade(upgradeName);
    }

    public Graduation getGraduation()
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
}
