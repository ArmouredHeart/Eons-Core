// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;

// Forge imports

// Eons imports

// misc imports
import javax.annotation.Nonnull;

public class Diet {

    // *** Attributes ***
    public static final int DEFAULT_STOMACH_SIZE = 6;
    private final int STOMACH_SIZE;
    private final Item[] BREEDING_ITEMS;
    private final DietPreset PRESET;
    private final PreyType GENERAL_PREY;
    private final Species[] FAVOURITE_PREY;

    // *** Constructors ***

    public Diet(@Nonnull final int stomach_size, @Nonnull final DietPreset preset, @Nonnull final Item[] breeding_items, @Nonnull final PreyType prey_type, @Nonnull final Species[] favourite_prey) {
        this.STOMACH_SIZE = stomach_size;
        this.PRESET = preset;
        this.BREEDING_ITEMS = breeding_items;
        this.GENERAL_PREY = prey_type;
        this.FAVOURITE_PREY = favourite_prey;
    }

    public Diet(@Nonnull final int stomach_size, @Nonnull final DietPreset preset, @Nonnull final Item[] breeding_items, @Nonnull final Species[] favourite_prey) {
        this(stomach_size, preset, breeding_items, preset.getPreyType(), favourite_prey);
    }

    public Diet() {
        this(Diet.DEFAULT_STOMACH_SIZE, DietPreset.NONE, new Item[]{}, PreyType.NONE, new Species[]{});
    }


    // *** Enumerators ***

    public enum DietPreset {
        GENERIC_CARNIVORE(true, false, PreyType.NONE),
        GENERIC_HERBIVORE(false, true, PreyType.NONE),
        GENERIC_OMNIVORE(true, true, PreyType.NONE),
        NONE(false, false, PreyType.NONE);

        // *** Constructors ***
        private final boolean EATS_MEAT;
        private final boolean EATS_PLANTS;
        private final PreyType PREY_TYPE;

        private DietPreset(final boolean eats_meat, final boolean eats_plants, final PreyType prey_type) {
            this.EATS_MEAT = eats_meat;
            this.EATS_PLANTS = eats_plants;
            this.PREY_TYPE = prey_type;
        }

        // *** Methods ***
        
        public boolean isOnMenu(Item item) {
            if(!item.isFood()) {return false;}
            boolean isMeat = item.getFood().isMeat();
            return (this.EATS_MEAT && isMeat) || (this.EATS_PLANTS && !isMeat);
        }

        public PreyType getPreyType() {
            return this.PREY_TYPE;
        }
    }

    public enum PreyType {
        // Vanilla Generic Types
        ALL,
        ANIMAL,
        FISH,
        WATER,
        ARTHROPOD,
        FLYING,
        NONE;

        // *** Methods ***

        public static boolean isPreyType(LivingEntity entity, PreyType target_type) {
            switch(target_type){
                // Vanilla Generic Types
                case ALL: {return true;}
                case ANIMAL: {return entity instanceof AnimalEntity;}
                case FISH: {return entity instanceof AbstractFishEntity;}
                case WATER: {return entity.getCreatureAttribute() == CreatureAttribute.WATER;}
                case ARTHROPOD: {return entity.getCreatureAttribute() == CreatureAttribute.ARTHROPOD;}
                case FLYING: {return entity instanceof IFlyingAnimal;}
                default: {return false;}
            }
        }
    }

    // *** Methods ***

    private boolean onBreedingItemList(Item item) {
        for(int i = 0; i < this.BREEDING_ITEMS.length; i++) {
            if(item.equals(BREEDING_ITEMS[i])) {
                return true;
            }
        }
        return false;
    }   

    public boolean isEdible(ItemStack stack) {
        // check preset
        return onBreedingItemList(stack.getItem()) || this.PRESET.isOnMenu(stack.getItem());
    }

    public boolean isBreedingItem(ItemStack stack) {
        // scan breeding items
        if(onBreedingItemList(stack.getItem())) {return true;}
        // check presets if breeding item list is empty
        if(this.BREEDING_ITEMS.length < 1) {
            return this.PRESET.isOnMenu(stack.getItem());
        }
        return false;
    }

    public boolean isPrey(LivingEntity entity) {
        // check for preytype match
        if(PreyType.isPreyType(entity, this.GENERAL_PREY)) {return true;}
        
        // check species
        if(entity instanceof IEonsLifeForm) {
            Species species = ((IEonsLifeForm) entity).getSpecies();
            for(int k = 0; k < this.FAVOURITE_PREY.length; k++) {
                if(this.FAVOURITE_PREY[k].equals(species)) {
                    return true;
                }
            }
        }
        
        // this straight up isn't food my dude
        return false;
    }

    public int getStomachSize() {return this.STOMACH_SIZE;}

}
