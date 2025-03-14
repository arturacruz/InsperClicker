package br.edu.insper.insperclicker.game.resources.upgrade;

import br.edu.insper.insperclicker.dto.RequirementTargetDTO;
import br.edu.insper.insperclicker.game.resources.building.Building;
import br.edu.insper.insperclicker.game.target.BonusTarget;
import br.edu.insper.insperclicker.game.target.RequirementBonusTarget;
import br.edu.insper.insperclicker.game.resources.common.GameResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Upgrade extends GameResource
{
    private final List<RequirementBonusTarget<Building>> targetList = new ArrayList<>();
    private boolean taken = false;
    private boolean unlocked = false;
    private final double price;

    @SafeVarargs
    /**
     * @param targetResources -> UNSAFE. Can cause heap pollution. DO NOT ADD A CLASS THAT INHERITS BUILDING, ONLY ITSELF.
     */
    public Upgrade(String name, String displayName, String description, double price,
                   RequirementBonusTarget<Building>... targetResources)
    {
        super(name, displayName, description);
        this.price = price;

        this.targetList.addAll(Arrays.asList(targetResources));
    }

    /**
     * @return the DTO of the buildings
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
                .mapToDouble(BonusTarget::getBonus)
                .sum();
    }

    public boolean isUnlocked()
    {
        return unlocked;
    }

    public boolean anyResourceIs(Building building)
    {
        for(RequirementBonusTarget<Building> rt : targetList)
        {
            if(rt.isOf(building)) return true;
        }
        return false;
    }

    public boolean allResourcesAre(Building... buildings)
    {
        for(Building bd : buildings)
        {
            for(RequirementBonusTarget<Building> rt : targetList)
            {
                if(!rt.isOf(bd)) return false;
            }
        }
        return true;
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
        for(RequirementBonusTarget<Building> rt : targetList)
        {
            if(rt.getRequiredLevel() > rt.getGameResource().getLevel()) return false;
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
