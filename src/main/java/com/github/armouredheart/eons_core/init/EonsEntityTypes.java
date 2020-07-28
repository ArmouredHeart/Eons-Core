// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;

// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.common.entity.paleozoic.*;

//import com.github.armouredheart.eons_core.common.entity.projectile.*;
import com.github.armouredheart.eons_core.client.render.entity.paleozoic.*;

// misc imports
import com.google.common.collect.Lists;
import com.google.common.base.Preconditions;
import java.util.List;


@EventBusSubscriber(modid = EonsCore.MOD_ID)
public final class EonsEntityTypes {

    // *** Attributes ***
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, EonsCore.MOD_ID);
    private static final List<Item> SPAWN_EGGS = Lists.newArrayList();
    
    // default settings
    private static final int TRACKING_RANGE = 64;
    private static final int UPDATE_INTERVAL = 1;

    // *** Register EntityTypes ***

    // projectile 
    //public static final RegistryObject<EntityType<EonsSpearEntity>> EONS_SPEAR_ENTITY = makeEonsEntity("eons_spear_entity", EonsSpearEntity::new, EntityClassification.MISC, 0.5F, 0.5F);

    // paleozoic
    //public static final RegistryObject<EntityType<EonsAraxocerasEntity>> ARAXOCERAS = makeEonsEntity("araxoceras", EonsAraxocerasEntity::new, EntityClassification.WATER_CREATURE, 0.3F, 0.3F);
    //public static final RegistryObject<EntityType<EonsBelantseaEntity>> BELANTSEA = makeEonsEntity("belantsea", EonsBelantseaEntity::new, EntityClassification.WATER_CREATURE, 0.3F, 0.31F);
    //public static final RegistryObject<EntityType<EonsHyneriaEntity>> HYNERIA = makeEonsEntity("hyneria", EonsHyneriaEntity::new, EntityClassification.WATER_CREATURE, 0.8F, 0.8F);
    //public static final RegistryObject<EntityType<EonsSpathicephalusEntity>> SPATHICEPHALUS = makeEonsEntity("spathicephalus", EonsSpathicephalusEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);
    //public static final RegistryObject<EntityType<EonsMazothairosEntity>> MAZOTHAIROS = makeEonsEntity("mazothairos", EonsMazothairosEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);
    //public static final RegistryObject<EntityType<EonsCtenorhabdotusEntity>> CTENORHABDOTUS = makeEonsEntity("ctenorhabdotus", EonsCtenorhabdotusEntity::new, EntityClassification.WATER_CREATURE, 0.50F, 0.30F);
    //public static final RegistryObject<EntityType<EonsAnomalocarisEntity>> ANOMALOCARIS = makeEonsEntity("anomalocaris", EonsAnomalocarisEntity::new, EntityClassification.WATER_CREATURE, 0.40F, 0.80F);
    //public static final RegistryObject<EntityType<EonsParadoxidesEntity>> PARADOXIDES = makeEonsEntity("paradoxides",  EonsParadoxidesEntity::new, EntityClassification.WATER_CREATURE, 0.30F, 0.30F);
    public static final RegistryObject<EntityType<EonsDimetrodonEntity>> DIMETRODON = makeMobEntity("dimetrodon",  EonsDimetrodonEntity::new, EntityClassification.CREATURE, 1.8F, 2.0F, 0x000000, 0xFFFFFF);
    
    // *** Methods ***

    /** 
     * @param name
     * @param factory
     * @param classification
     * @param width
     * @param height
     * @param eggPrimary
     * @param eggSecondary
    */
    public static <T extends MobEntity> RegistryObject<EntityType<T>> makeMobEntity(String name, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height, int eggPrimary, int eggSecondary) {
        // register entity
        RegistryObject<EntityType<T>> registry_object = ENTITY_TYPES.register(name, () -> EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(TRACKING_RANGE).setUpdateInterval(UPDATE_INTERVAL).build(name));
        
        // build egg
        /**Item spawnEgg = new SpawnEggItem(registry_object.get(), eggPrimary, eggSecondary, (new Item.Properties()).group(ItemGroup.MISC));
        spawnEgg.setRegistryName(new ResourceLocation(EonsCore.MOD_ID, name + "_spawn_egg"));
        SPAWN_EGGS.add(spawnEgg);*/

        return registry_object;
    }

    /** */
    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        for (Item spawnEgg : SPAWN_EGGS) {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }

    /** */
    public static <E extends Entity> RegistryObject<EntityType<E>> makeEonsEntity(String id, EntityType.IFactory<E> factory, EntityClassification classification){
        return makeEonsEntity(id, factory, classification, 0.6F, 1.8F);
    }

    /** */
    public static <E extends Entity> RegistryObject<EntityType<E>> makeEonsEntity(String id, EntityType.IFactory<E> factory, EntityClassification classification, float width, float height) {
        return ENTITY_TYPES.register(id, 
            () -> EntityType.Builder.create(factory, classification)
            .size(width, height).setTrackingRange(EonsEntityTypes.TRACKING_RANGE)
            .setUpdateInterval(EonsEntityTypes.UPDATE_INTERVAL)
            .setShouldReceiveVelocityUpdates(true)
            .build(id));
    }

}