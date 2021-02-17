// package
package com.github.armouredheart.eons_core.common.item.core;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public class EonsDnaItem extends Item implements IEonsLifeForm {

    private final Species SPECIES;

    public EonsDnaItem(Species species, ItemGroup item_group) {
        super(new Item.Properties().group(item_group));
        this.SPECIES = species;
    }

    @Override
    public Species getSpecies() {return this.SPECIES;}
    
}
