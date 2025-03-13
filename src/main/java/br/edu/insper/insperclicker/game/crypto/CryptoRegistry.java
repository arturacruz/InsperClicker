package br.edu.insper.insperclicker.game.crypto;
import br.edu.insper.insperclicker.game.building.Building;

import java.util.ArrayList;
import java.util.HashMap;

public class CryptoRegistry
{
    private static final ArrayList<Crypto> cryptos = new ArrayList<>();

    public static final Crypto ETHEREUM = new Crypto("ethereum", "Ethereum", "Crypto basica", 0);

    public static ArrayList<Crypto> generateStarterCryptoLevels()
    {
        addToList(ETHEREUM);
        return cryptos;
    }

    private static void addToList(Crypto crypto)
    {
        cryptos.add(crypto);
    }
}
