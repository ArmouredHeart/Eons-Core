// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.common.entity.testmobs.*;
import com.github.armouredheart.eons_core.client.render.entity.*;

// misc imports
import java.util.function.Supplier;

public final class EonsEntityTypes {

    // *** Attributes ***

    //
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, EonsCore.MOD_ID);

    // *** Register EntityTypes ***

    public static final RegistryObject<EntityType<EonsArcanineEntity>> ARCANINE = makeEonsEntity("arcanine", EonsArcanineEntity::new, EntityClassification.CREATURE, 1F, 1F);
    // paleozoic
    public static final RegistryObject<EntityType<EonsAraxocerasEntity>> ARAXOCERAS = makeEonsEntity("araxoceras", EonsAraxocerasEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);
    public static final RegistryObject<EntityType<EonsBelantseaEntity>> BELANTSEA = makeEonsEntity("belantsea", EonsBelantseaEntity::new, EntityClassification.CREATURE, 0.3F, 0.31F);
    public static final RegistryObject<EntityType<EonsHyneriaEntity>> HYNERIA = makeEonsEntity("hyneria", EonsHyneriaEntity::new, EntityClassification.CREATURE, 1F, 1F);
    public static final RegistryObject<EntityType<EonsSpathicephalusEntity>> SPATHICEPHALUS = makeEonsEntity("spathicephalus", EonsSpathicephalusEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);
    public static final RegistryObject<EntityType<EonsMazothairosEntity>> MAZOTHAIROS = makeEonsEntity("mazothairos", EonsMazothairosEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);

    // *** Methods ***

    /** */
    public static <E extends Entity> RegistryObject<EntityType<E>> makeEonsEntity(String id, EntityType.IFactory<E> factory, EntityClassification classification){
        return makeEonsEntity(id, factory, classification, 0.6F, 1.8F);
    }

    /** */
    public static <E extends Entity> RegistryObject<EntityType<E>> makeEonsEntity(String id, EntityType.IFactory<E> factory, EntityClassification classification, float width, float height) {
        return ENTITY_TYPES.register(id, 
            () -> EntityType.Builder.create(factory, classification)
            .size(width, height).setTrackingRange(80)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .build(id));
    }

    /** Register client renderers */
	public static void registerEonsEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EonsArcanineEntity.class, manager -> new EonsArcanineRenderer(manager));
        // paleozoic
        RenderingRegistry.registerEntityRenderingHandler(EonsAraxocerasEntity.class, manager -> new EonsAraxocerasRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsBelantseaEntity.class, manager -> new EonsBelantseaRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsHyneriaEntity.class, manager -> new EonsHyneriaRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsSpathicephalusEntity.class, manager -> new EonsSpathicephalusRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsMazothairosEntity.class, manager -> new EonsMazothairosRenderer(manager));
    }
}