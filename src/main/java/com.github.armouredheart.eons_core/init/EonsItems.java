// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.item.Item;

// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.common.item.EonsMusicDiscItem;
import com.github.armouredheart.eons_core.common.item.EonsSpearItem;
import com.github.armouredheart.eons_core.common.item.EonsNotebookItem;
import com.github.armouredheart.eons_core.init.EonsSounds;

// misc imports
import java.util.function.Supplier;

/** */
public final class EonsItems {

    //
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EonsCore.MOD_ID);

    // *** Register Items ***
    
    //
    public static final RegistryObject<Item> EONS_SPEAR_ITEM = registerItem("eons_spear_item", () -> new EonsSpearItem(new Item.Properties().group(EonsItemGroups.EONS_ITEM_GROUP)));

    //
    public static final RegistryObject<Item> EONS_MUSIC_DISC_PRIMAL_AGE = registerItem("eons_music_disc_primal_age", () -> new EonsMusicDiscItem(EonsSounds.MUSIC_EONS_PRIMAL_AGE));
    
    //
    public static final RegistryObject<Item> EONS_NOTEBOOK_ITEM = registerItem("eons_notebook_item", () -> new EonsNotebookItem());

    // *** Methods ***

    /**
     * @param item_supplier Minecraft Item object or subclass object
     * @param item_name String unlocalised name all lowercase
     */
    public static RegistryObject<Item> registerItem(String item_name, Supplier<Item> item_supplier){
        return ITEMS.register(item_name, item_supplier);
    }
}