// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import java.util.function.Supplier;

public final class EonsEntityTypes {

    // *** Attributes ***

    //
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, EonsCore.MOD_ID);

    // *** Register EntityTypes ***

    // *** Methods ***

    /**
     * @param entity_supplier Minecraft Item object or subclass object
     * @param entity_name String unlocalised name all lowercase
     */
    public static RegistryObject<EntityType<?>> registerEntityType(String entity_name, Supplier<EntityType<?>> entity_supplier){
        return ENTITY_TYPES.register(entity_name, entity_supplier);
    }

}