// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// Forge imports

// Eons imports

// misc imports

public class Diet {

    // *** Attributes ***
    public static final int DEFAULT_STOMACH_SIZE = 6;
    private final int STOMACH_SIZE;

    // *** Constructors ***

    public Diet(int stomach_size, Item[] breeding_items) {
        this.STOMACH_SIZE = stomach_size;
    }

    /** Default settings */
    public Diet() {
        this.STOMACH_SIZE = Diet.DEFAULT_STOMACH_SIZE;
    }


    // *** Inner Classes ***

    public enum DietPreset {
        GENERIC_PREDATOR(),
        GENERIC_HERBIVORE(),
        GENERIC_OMNIVORE();

        // *** Constructors ***

        private DietPreset() {

        }

        // *** Methods ***
    }

    // *** Methods ***

    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    public int getStomachSize() {return this.STOMACH_SIZE;}

    //TODO

    /** @return can this item be eaten? */
    public boolean isEdible(Item foodItem) {
        if(foodItem.isFood()) {
            boolean isMeat = foodItem.getFood().isMeat();
            if(this.isOmnivore) {
                // doesn't matter, omnivore will eat it
                return true;
            } else if(this.isPredator && isMeat) {
                // predators don't really care as long as it is meat
                return true;
            } else if(this.favouriteFoodsInOrder != null) {
                if(!this.isPredator && !isMeat && this.favouriteFoodsInOrder.contains(foodItem)) {
                    // herbivores are picky if not omnivores. Specify 
                    return true;
                }
            }
        }
        return false;
    }

}
