package br.edu.insper.coffeeclicker.game.upgrade;

import br.edu.insper.coffeeclicker.game.requirement.Target;
import br.edu.insper.coffeeclicker.game.resource.GameResource;
import jakarta.annotation.Nullable;

public class Upgrade extends GameResource
{
    private final Target primaryResource;
    private final Target secondaryResource;

    public Upgrade(String displayName, String name, String description,
                   Target primaryResource,
                   @Nullable Target secondaryResource)
    {
        super(displayName, name, description);

        this.primaryResource = primaryResource;
        this.secondaryResource = secondaryResource;

    }
}
