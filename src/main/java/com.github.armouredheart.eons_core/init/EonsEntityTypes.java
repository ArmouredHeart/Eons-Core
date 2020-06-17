// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;

// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.common.entity.paleozoic.*;
//import com.github.armouredheart.eons_core.common.entity.projectile.*;
import com.github.armouredheart.eons_core.client.render.entity.paleozoic.*;

// misc imports
import java.util.function.Supplier;

public final class EonsEntityTypes {

    // *** Attributes ***

    //
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, EonsCore.MOD_ID);

    // *** Register EntityTypes ***

    // projectile 
    //public static final RegistryObject<EntityType<EonsSpearEntity>> EONS_SPEAR_ENTITY = makeEonsEntity("eons_spear_entity", EonsSpearEntity::new, EntityClassification.MISC, 0.5F, 0.5F);

    // paleozoic
    public static final RegistryObject<EntityType<EonsAraxocerasEntity>> ARAXOCERAS = makeEonsEntity("araxoceras", EonsAraxocerasEntity::new, EntityClassification.WATER_CREATURE, 0.3F, 0.3F);
    public static final RegistryObject<EntityType<EonsBelantseaEntity>> BELANTSEA = makeEonsEntity("belantsea", EonsBelantseaEntity::new, EntityClassification.WATER_CREATURE, 0.3F, 0.31F);
    public static final RegistryObject<EntityType<EonsHyneriaEntity>> HYNERIA = makeEonsEntity("hyneria", EonsHyneriaEntity::new, EntityClassification.WATER_CREATURE, 0.8F, 0.8F);
    public static final RegistryObject<EntityType<EonsSpathicephalusEntity>> SPATHICEPHALUS = makeEonsEntity("spathicephalus", EonsSpathicephalusEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);
    public static final RegistryObject<EntityType<EonsMazothairosEntity>> MAZOTHAIROS = makeEonsEntity("mazothairos", EonsMazothairosEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);
    public static final RegistryObject<EntityType<EonsCtenorhabdotusEntity>> CTENORHABDOTUS = makeEonsEntity("ctenorhabdotus", EonsCtenorhabdotusEntity::new, EntityClassification.WATER_CREATURE, 0.50F, 0.30F);
    public static final RegistryObject<EntityType<EonsAnomalocarisEntity>> ANOMALOCARIS = makeEonsEntity("anomalocaris", EonsAnomalocarisEntity::new, EntityClassification.WATER_CREATURE, 0.40F, 0.80F);
    public static final RegistryObject<EntityType<EonsParadoxidesEntity>> PARADOXIDES = makeEonsEntity("paradoxides",  EonsParadoxidesEntity::new, EntityClassification.WATER_CREATURE, 0.30F, 0.30F);
    public static final RegistryObject<EntityType<EonsDimetrodonEntity>> DIMETRODON = makeEonsEntity("dimetrodon",  EonsDimetrodonEntity::new, EntityClassification.CREATURE, 1.8F, 2.0F);
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

    /** Register client renderers, called in EonsEventSubscriber */
	public static void registerEonsEntityRenderers() {
        // paleozoic
        RenderingRegistry.registerEntityRenderingHandler(EonsAraxocerasEntity.class, manager -> new EonsAraxocerasRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsBelantseaEntity.class, manager -> new EonsBelantseaRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsHyneriaEntity.class, manager -> new EonsHyneriaRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsSpathicephalusEntity.class, manager -> new EonsSpathicephalusRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsMazothairosEntity.class, manager -> new EonsMazothairosRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsCtenorhabdotusEntity.class, manager -> new EonsCtenorhabdotusRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsAnomalocarisEntity.class, manager -> new EonsAnomalocarisRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsParadoxidesEntity.class, manager -> new EonsParadoxidesRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EonsDimetrodonEntity.class, manager -> new EonsDimetrodonRenderer(manager));
    }

}