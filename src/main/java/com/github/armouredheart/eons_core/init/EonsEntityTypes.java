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
import com.github.armouredheart.eons_core.api.Species;
import com.github.armouredheart.eons_core.common.entity.paleozoic.*;

//import com.github.armouredheart.eons_core.common.entity.projectile.*;
import com.github.armouredheart.eons_core.client.render.entity.paleozoic.*;

// misc imports
import com.google.common.collect.Lists;
import com.google.common.base.Preconditions;
import java.util.List;


@EventBusSubscriber(modid = EonsCore.MOD_ID)
public final class EonsEntityTypes {

    // **** NOTE: ALL ENTITY RENDERERS ARE LOCATED IN [com.github.armouredheart.eons_core.EonsEventSubscriber]! ****

    // *** Attributes ***
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, EonsCore.MOD_ID);
    private static final List<Item> SPAWN_EGGS = Lists.newArrayList();
    
    // default settings
    private static final int DEFAULT_TRACKING_RANGE = 64;
    private static final int DEFAULT_UPDATE_INTERVAL = 1;

    // *** Register EntityTypes ***

    // projectile 
    //public static final RegistryObject<EntityType<EonsSpearEntity>> EONS_SPEAR_ENTITY = makeEonsEntity("eons_spear_entity", EonsSpearEntity::new, EntityClassification.MISC, 0.5F, 0.5F);

    // === paleozoic ===
    //public static final RegistryObject<EntityType<EonsAraxocerasEntity>> ARAXOCERAS = makeEonsEntity("araxoceras", EonsAraxocerasEntity::new, EntityClassification.WATER_CREATURE, 0.3F, 0.3F);
    //public static final RegistryObject<EntityType<EonsBelantseaEntity>> BELANTSEA = makeEonsEntity("belantsea", EonsBelantseaEntity::new, EntityClassification.WATER_CREATURE, 0.3F, 0.31F);
    //public static final RegistryObject<EntityType<EonsHyneriaEntity>> HYNERIA = makeMobEntity("hyneria", EonsHyneriaEntity::new, EntityClassification.WATER_CREATURE, 0.8F, 0.8F, DEFAULT_TRACKING_RANGE, DEFAULT_UPDATE_INTERVAL, 0x000000, 0xFFFFFF);
    //public static final RegistryObject<EntityType<EonsSpathicephalusEntity>> SPATHICEPHALUS = makeEonsEntity("spathicephalus", EonsSpathicephalusEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);
    //public static final RegistryObject<EntityType<EonsMazothairosEntity>> MAZOTHAIROS = makeEonsEntity("mazothairos", EonsMazothairosEntity::new, EntityClassification.CREATURE, 0.3F, 0.3F);
    
    // cambrian
    public static final RegistryObject<EntityType<EonsCtenorhabdotusEntity>> CTENORHABDOTUS = makeMobEntity(Species.CTENORHABDOTUS, EonsCtenorhabdotusEntity::new, EntityClassification.WATER_CREATURE, 0.50F, 0.30F, DEFAULT_TRACKING_RANGE, DEFAULT_UPDATE_INTERVAL);
    public static final RegistryObject<EntityType<EonsAnomalocarisEntity>> ANOMALOCARIS = makeMobEntity(Species.ANOMALOCARIS, EonsAnomalocarisEntity::new, EntityClassification.WATER_CREATURE, 0.40F, 0.80F, DEFAULT_TRACKING_RANGE, DEFAULT_UPDATE_INTERVAL);
    public static final RegistryObject<EntityType<EonsParadoxidesEntity>> PARADOXIDES = makeMobEntity(Species.PARADOXIDES, EonsParadoxidesEntity::new, EntityClassification.WATER_CREATURE, 0.30F, 0.30F, DEFAULT_TRACKING_RANGE, DEFAULT_UPDATE_INTERVAL);
    public static final RegistryObject<EntityType<EonsHurdiaEntity>> HURDIA = makeMobEntity(Species.HURDIA, EonsHurdiaEntity::new, EntityClassification.WATER_CREATURE, 1F, 1F, DEFAULT_TRACKING_RANGE, DEFAULT_UPDATE_INTERVAL);
    public static final RegistryObject<EntityType<EonsDickinsoniaEntity>> DICKINSONIA = makeMobEntity(Species.DICKINSONIA, EonsDickinsoniaEntity::new, EntityClassification.WATER_CREATURE, 1F, 1F, DEFAULT_TRACKING_RANGE, DEFAULT_UPDATE_INTERVAL);

    // permian
    public static final RegistryObject<EntityType<EonsDimetrodonEntity>> DIMETRODON = makeMobEntity(Species.DIMETRODON, EonsDimetrodonEntity::new, EntityClassification.CREATURE, 1.8F, 2.0F, DEFAULT_TRACKING_RANGE, DEFAULT_UPDATE_INTERVAL);
    // === mesozoic ===

    // === cenoozoic ===

    // *** Methods ***

    /** 
     * @param species
     * @param factory
     * @param classification
     * @param width
     * @param height
     * @param tracking_range
     * @param update_interval
    */
    public static <T extends MobEntity> RegistryObject<EntityType<T>> makeMobEntity(Species species, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height, int tracking_range, int update_interval) {
        String name = species.toString().toLowerCase();
        // register entity
        //RegistryObject<EntityType<T>> registry_object; 
        
        // build egg
        /**Item spawnEgg = new SpawnEggItem(registry_object.get(), eggPrimary, eggSecondary, (new Item.Properties()).group(ItemGroup.MISC));
        spawnEgg.setRegistryName(new ResourceLocation(EonsCore.MOD_ID, name + "_spawn_egg"));
        SPAWN_EGGS.add(spawnEgg);*/

        return EonsEntityTypes.ENTITY_TYPES.register(name, () -> EntityType.Builder.create(factory, classification).size(width, height).setTrackingRange(tracking_range).setUpdateInterval(update_interval).build(new ResourceLocation(EonsCore.MOD_ID, name).toString()));
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
    /*public static <E extends Entity> RegistryObject<EntityType<E>> makeEonsEntity(String id, EntityType.IFactory<E> factory, EntityClassification classification){
        return makeEonsEntity(id, factory, classification, 0.6F, 1.8F);
    }*/

    /** */
    /*public static <E extends Entity> RegistryObject<EntityType<E>> makeEonsEntity(String id, EntityType.IFactory<E> factory, EntityClassification classification, float width, float height) {
        return ENTITY_TYPES.register(id, 
            () -> EntityType.Builder.create(factory, classification)
            .size(width, height).setTrackingRange(EonsEntityTypes.DEFAULT_TRACKING_RANGE)
            .setUpdateInterval(EonsEntityTypes.DEFAULT_UPDATE_INTERVAL)
            .setShouldReceiveVelocityUpdates(true)
            .build(id));
    }*/

}