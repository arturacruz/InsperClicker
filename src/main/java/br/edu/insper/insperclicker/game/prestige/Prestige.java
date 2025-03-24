package br.edu.insper.insperclicker.game.prestige;

public class Prestige
{
    public static double getBitcoinEarnedOnPrestige(double money)
    {
        double achieved = Math.pow(money / Math.pow(10, 6), 1/3.0);
        if(achieved < 1) return 0;
        return achieved;
    }
}
