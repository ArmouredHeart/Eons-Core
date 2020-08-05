// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;

// Forge imports
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.common.item.core.*;
import com.github.armouredheart.eons_core.init.EonsSounds;
import com.github.armouredheart.eons_core.init.EonsEntityTypes;

// misc imports
import java.util.function.Supplier;

/** */
public final class EonsItems {
    // *** Attributes ***
    
    //
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EonsCore.MOD_ID);

    // *** Register Items ***
    
    // Core
    //public static final RegistryObject<Item> 
    //public static final RegistryObject<Item> EONS_SPEAR_ITEM = registerItem("eons_spear_item", () -> new EonsSpearItem(new Item.Properties().group(EonsItemGroups.EONS_ITEM_GROUP)));
    public static final RegistryObject<Item> EONS_MUSIC_DISC_PRIMAL_AGE = registerItem("eons_music_disc_primal_age", () -> new MusicDiscItem(0, () -> EonsSounds.MUSIC_EONS_PRIMAL_AGE, eonsDiscProperties()));
    public static final RegistryObject<Item> EONS_NOTEBOOK_ITEM = registerItem("eons_notebook_item", () -> new EonsNotebookItem(EonsItemGroups.EONS_ITEM_GROUP));
    public static final RegistryObject<Item> EONS_BIG_LEAF_ITEM = registerItem("eons_big_leaf_item", () -> new EonsBigLeafItem(new Item.Properties().group(EonsItemGroups.EONS_ITEM_GROUP)));
    // Paleozoic
    

    // *** Methods ***

    /** Helper method for registering music discs */
    private static Item.Properties eonsDiscProperties() {return (new Item.Properties()).maxStackSize(1).group(EonsItemGroups.EONS_ITEM_GROUP).rarity(Rarity.RARE);}
    
    /**
     * @param item_supplier Minecraft Item object or subclass object
     * @param item_name String unlocalised name all lowercase
     */
    private static RegistryObject<Item> registerItem(String item_name, Supplier<Item> item_supplier) {
        return ITEMS.register(item_name, item_supplier);
    }

}