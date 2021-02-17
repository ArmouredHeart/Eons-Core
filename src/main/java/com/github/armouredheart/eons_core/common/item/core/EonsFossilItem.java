// package
package com.github.armouredheart.eons_core.common.item.core;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundEvent;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.init.EonsItemGroups;
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public class EonsFossilItem extends Item implements IEonsLifeForm {

    // *** Attributes ***
    private final Species SPECIES;

    // *** Constructors ***

    /** */
    public EonsFossilItem(ItemGroup item_group, final Species species) {
        super(new Item.Properties().group(item_group));
        this.SPECIES = species;
    }

    // *** Methods ***

    /** */
    public Species getSpecies() {return this.SPECIES;}
}
