// package
package com.github.armouredheart.eons_core.common.item.core;

// Minecraft imports
import net.minecraft.item.Item;
// Forge imports
import net.minecraft.item.ItemGroup;

// Eons imports
import com.github.armouredheart.eons_core.api.EonsGeoArtifact;
import com.github.armouredheart.eons_core.api.Geon;

// misc imports

public class EonsGeonFossilItem extends Item implements EonsGeoArtifact {
    // *** Attributes ***
    private final Geon GEON;

    // *** Constructors ***

    /** */
    public EonsGeonFossilItem(ItemGroup item_group, final Geon geon) {
        super(new Item.Properties().group(item_group));
        this.GEON = geon;
    }

    @Override
    public Geon getGeon() {return this.GEON;}
}
