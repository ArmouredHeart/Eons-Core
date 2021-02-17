// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.potion.EffectInstance;
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
import com.github.armouredheart.eons_core.api.EonsResourceHelper;
import com.github.armouredheart.eons_core.api.Geon;
import com.github.armouredheart.eons_core.api.Species;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.EonsResourcePrefix;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.FoodState;
import com.github.armouredheart.eons_core.common.item.EonsFoodItem;
import com.github.armouredheart.eons_core.common.item.core.*;
import com.github.armouredheart.eons_core.init.EonsSounds;
import com.github.armouredheart.eons_core.init.EonsEntityTypes;

// misc imports
import java.util.function.Supplier;

import javax.annotation.Nullable;

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
    
    // Paleozoic - GeonFossils
    public static final RegistryObject<Item> CAMBRIAN_FOSSIL_ITEM = registerGeonFossilItem(Geon.CAMBRIAN, EonsItemGroups.PALEOZOIC_GROUP);
    public static final RegistryObject<Item> ORDOVICIAN_FOSSIL_ITEM = registerGeonFossilItem(Geon.ORDOVICIAN, EonsItemGroups.PALEOZOIC_GROUP);
    
    // Paleozoic - Fossils
    //public static final RegistryObject<Item> AEGIROCASSIS_FOSSIL_ITEM = registerFossilItem("AEGIROCASSIS", EonsItemGroups.PALEOZOIC_GROUP);
    public static final RegistryObject<Item> ANOMALOCARIS_FOSSIL_ITEM = registerFossilItem(Species.ANOMALOCARIS, EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> ARANDASPIS_FOSSIL_ITEM = registerFossilItem("ARANDASPIS", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> ASTRASPIS_FOSSIL_ITEM = registerFossilItem("ASTRASPIS", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> CAMEROCERAS_FOSSIL_ITEM = registerFossilItem("CAMEROCERAS", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> CHANCELLORIIDAE_FOSSIL_ITEM = registerFossilItem("CHANCELLORIIDAE", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> CHARNIA_FOSSIL_ITEM = registerFossilItem("CHARNIA", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> CHOIA_FOSSIL_ITEM = registerFossilItem("CHOIA", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> CTENORHABDOTUS_FOSSIL_ITEM = registerFossilItem("CTENORHABDOTUS", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> DICKSONIA_FOSSIL_ITEM = registerFossilItem("DICKSONIA", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> DIRAPHORA_FOSSIL_ITEM = registerFossilItem("DIRAPHORA", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> ENDOCERAS_FOSSIL_ITEM = registerFossilItem("ENDOCERAS", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> HURDIA_FOSSIL_ITEM = registerFossilItem("HURDIA", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> ISOTELUS_FOSSIL_ITEM = registerFossilItem("ISOTELUS", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> LITUITES_FOSSIL_ITEM = registerFossilItem("LITUITES", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> MARGARETIA_FOSSIL_ITEM = registerFossilItem("MARGARETIA", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> PARADOXIDES_FOSSIL_ITEM = registerFossilItem("PARADOXIDES", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> PISOCRINUS_FOSSIL_ITEM = registerFossilItem("PISOCRINUS", EonsItemGroups.PALEOZOIC_GROUP);
    //public static final RegistryObject<Item> SIPHUSAUCTUM_FOSSIL_ITEM = registerFossilItem("SIPHUSAUCTUM", EonsItemGroups.PALEOZOIC_GROUP);
    // Paleozoic - DNA
    // Paleozoic - Food

    // *** Methods ***

    private static RegistryObject<Item> registerGeonFossilItem(Geon geon, ItemGroup item_group) {
        return registerItem(EonsResourceHelper.getGeonFossilItemKey(geon), () -> new EonsGeonFossilItem(item_group, geon));
    }

    private static RegistryObject<Item> registerFossilItem(Species species, ItemGroup item_group) {
        return registerItem(EonsResourceHelper.getFossilItemKey(species), () -> new EonsFossilItem(item_group, species));
    }

    private static RegistryObject<Item> registerFoodItem(Species species, EonsResourcePrefix food_state, int feed_amount, float saturation, boolean isMeat, boolean eatFast, boolean alwaysEdible, @Nullable EffectInstance potion, ItemGroup item_group) {
        return registerItem(EonsResourceHelper.getFoodItemKey(species, food_state), () -> new EonsFoodItem(feed_amount, saturation, isMeat, eatFast, alwaysEdible, potion, item_group));
    }

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