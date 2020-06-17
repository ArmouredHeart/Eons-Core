// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.EntityType;

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
    public static final RegistryObject<Item> EONS_MUSIC_DISC_PRIMAL_AGE = registerItem("eons_music_disc_primal_age", () -> new EonsMusicDiscItem(EonsSounds.MUSIC_EONS_PRIMAL_AGE));
    public static final RegistryObject<Item> EONS_NOTEBOOK_ITEM = registerItem("eons_notebook_item", () -> new EonsNotebookItem());
    public static final RegistryObject<Item> EONS_BIG_LEAF_ITEM = registerItem("eons_big_leaf_item", () -> new EonsBigLeafItem(new Item.Properties().group(EonsItemGroups.EONS_ITEM_GROUP)));
    // Paleozoic
    

    // *** Methods ***
    
    /**
     * @param item_supplier Minecraft Item object or subclass object
     * @param item_name String unlocalised name all lowercase
     */
    private static RegistryObject<Item> registerItem(String item_name, Supplier<Item> item_supplier) {
        return ITEMS.register(item_name, item_supplier);
    }

    private static RegistryObject<Item> registerFishBucket(String item_name, EntityType<? extends AbstractFishEntity> entityType) {
        return registerItem(item_name, () -> new FishBucketItem(entityType, Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(EonsItemGroups.EONS_ITEM_GROUP)));
    }

    private static RegistryObject<Item> registerSpawnEgg(String item_name, EntityType<?> entityType, int primaryColor, int secondaryColor, Item.Properties builder) {
        return registerItem(item_name, () -> new SpawnEggItem(entityType, primaryColor, secondaryColor, builder));
    }

    /** Register spawn eggs, called in EonsEventSubscriber*/
    public static void registerEonsSpawnEggs(RegistryEvent.Register<Item> event) {
        // paleozoic
    }
}