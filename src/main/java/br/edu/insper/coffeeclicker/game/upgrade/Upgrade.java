package br.edu.insper.coffeeclicker.game.upgrade;

import br.edu.insper.coffeeclicker.dto.RequirementTargetDTO;
import br.edu.insper.coffeeclicker.game.building.Building;
import br.edu.insper.coffeeclicker.game.target.RequirementTarget;
import br.edu.insper.coffeeclicker.game.resource.GameResource;
import br.edu.insper.coffeeclicker.game.target.Target;
import jakarta.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Upgrade extends GameResource
{
    private final List<RequirementTarget<Building>> targetList = new ArrayList<>();
    private boolean taken = false;
    private boolean unlocked = false;
    private final double price;

    @SafeVarargs
    /**
     * @param targetResources -> UNSAFE. Can cause heap pollution. DO NOT ADD A CLASS THAT INHERITS BUILDING, ONLY ITSELF.
     */
    public Upgrade(String name, String displayName, String description, double price,
                   RequirementTarget<Building>... targetResources)
    {
        super(name, displayName, description);
        this.price = price;

        this.targetList.addAll(Arrays.asList(targetResources));
    }

    /**
     *
     * @return the NAMES of the buildings
     */
    public List<RequirementTargetDTO> getTargetList()
    {
        ArrayList<RequirementTargetDTO> targets = new ArrayList<>();
        targetList.forEach(
                target -> targets.add(RequirementTargetDTO.from(target))
        );
        return targets;
    }

    public boolean isTaken()
    {
        return taken;
    }

    public void setTaken(boolean taken)
    {
        this.taken = taken;
    }

    public double getBuildingProductionBonus(Building building)
    {
        return this.targetList.stream()
                .filter(target -> target.isOf(building))
                .mapToDouble(Target::getBonus)
                .sum();
    }

    public boolean isUnlocked()
    {
        return unlocked;
    }

    public boolean anyResourceIs(Building building)
    {
        for(RequirementTarget<Building> rt : targetList)
        {
            if(rt.isOf(building)) return true;
        }
        return false;
    }

    public boolean allResourcesAre(Building... buildings)
    {
        for(Building bd : buildings)
        {
            for(RequirementTarget<Building> rt : targetList)
            {
                if(!rt.isOf(bd)) return false;
            }
        }
        return true;
    }

    public void setUnlocked(boolean unlocked)
    {
        this.unlocked = unlocked;
    }

    public void unlock()
    {
        this.unlocked = true;
    }

    public double getPrice()
    {
        return price;
    }

    public boolean isValidForUnlock()
    {
        for(RequirementTarget<Building> rt : targetList)
        {
            if(rt.getRequiredLevel() != rt.getGameResource().getLevel()) return false;
        }
        return true;
    }

    public void applyBonuses()
    {
        targetList.forEach(
                target -> target.getGameResource()
                        .addToUpgradeProductionBonus(target.getBonus())
        );
    }

}
