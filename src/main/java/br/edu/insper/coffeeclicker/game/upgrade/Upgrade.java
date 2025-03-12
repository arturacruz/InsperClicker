package br.edu.insper.coffeeclicker.game.upgrade;

import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.target.RequirementTarget;
import br.edu.insper.coffeeclicker.game.resource.GameResource;
import br.edu.insper.coffeeclicker.game.target.Target;
import jakarta.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Upgrade extends GameResource
{
    private final RequirementTarget<Building> primaryResource;
    private final RequirementTarget<Building> secondaryResource;
    private final List<Target<Building>> targetList = new ArrayList<>();
    private boolean taken = false;
    private boolean unlocked = false;
    private final double price;

    public Upgrade(String name, String displayName, String description, double price,
                   RequirementTarget<Building> primaryResource,
                   @Nullable RequirementTarget<Building> secondaryResource)
    {
        super(name, displayName, description);
        this.price = price;
        this.primaryResource = primaryResource;
        this.secondaryResource = secondaryResource;
        createTargetList();
    }

    private void createTargetList()
    {
        this.targetList.add(primaryResource);
        if(secondaryResource != null) this.targetList.add(secondaryResource);
    }

    public RequirementTarget<Building> getPrimaryResource()
    {
        return primaryResource;
    }

    public RequirementTarget<Building> getSecondaryResource()
    {
        return secondaryResource;
    }

    public boolean isTaken()
    {
        return taken;
    }

    public void setTaken(boolean taken)
    {
        this.taken = taken;
    }

    public double getTotalProductionBonus()
    {
        return this.targetList.stream()
                .mapToDouble(Target::getBonus)
                .sum();
    }

    public boolean isUnlocked()
    {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked)
    {
        this.unlocked = unlocked;
    }

    public double getPrice()
    {
        return price;
    }
}
