package br.edu.insper.insperclicker.game.achievement;

import br.edu.insper.insperclicker.dto.RequirementTargetDTO;
import br.edu.insper.insperclicker.game.resource.GameResource;
import br.edu.insper.insperclicker.game.resource.LeveledGameResource;
import br.edu.insper.insperclicker.game.target.RequirementTarget;

import java.util.ArrayList;
import java.util.List;

public class Achievement<T extends LeveledGameResource> extends GameResource
{
    private boolean unlocked = false;
    private final ArrayList<RequirementTarget<T>> targetList = new ArrayList<>();

    @SafeVarargs
    /**
     * @param targetResources -> UNSAFE. Can cause heap pollution. DO NOT ADD A CLASS THAT INHERITS BUILDING, ONLY ITSELF.
     */
    public Achievement(String name, String displayName, String description, RequirementTarget<T>... targetResources)
    {
        super(name, displayName, description);
        targetList.addAll(List.of(targetResources));
    }

    public boolean isUnlocked()
    {
        return unlocked;
    }

    public void unlock()
    {
        this.unlocked = true;
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
}
