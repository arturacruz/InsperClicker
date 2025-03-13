package br.edu.insper.insperclicker.game.crypto;

import br.edu.insper.insperclicker.game.resource.GameResource;
import br.edu.insper.insperclicker.game.resource.LeveledGameResource;

/**
 * Even though it extends GameResource, it's NOT BUY-ABLE, and levels won't be changed.
 * Didn't want to intend it behaves the same way, even it the fields are similar.
 * Works passively.
 */
public class Crypto extends LeveledGameResource
{
    public Crypto(String name, String displayName, String description, int level)
    {
        super(name, displayName, description, level);
    }

}
