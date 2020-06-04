// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.LivingEntity;
// Forge imports

// Eons imports

// misc imports
import java.util.List;
import javax.annotation.Nullable;

public class EonsDiet {

    // *** Attributes ***
    private final boolean isPredator;
    private final boolean isOmnivore;
    private final List<Item> favouriteFoodsInOrder;
    private final List<LivingEntity> prey;
    private final EonsPreyType preyType;

    // *** Constructors ***

    /** 
    * @param isPredator 
    * @param isOmnivore
    * @param preyType
    * @param prey
    * @param favouriteFoodsInOrder
    */
    private EonsDiet(boolean isPredator, boolean isOmnivore, @Nullable EonsPreyType preyType, @Nullable List<LivingEntity> prey, @Nullable List<Item> favouriteFoodsInOrder) {
        this.prey = prey;
        this.favouriteFoodsInOrder = favouriteFoodsInOrder;
        this.isPredator = isPredator;
        this.isOmnivore = isOmnivore;
        this.preyType = preyType;
    }

    /** Construct generalist hunting diet */
    public EonsDiet(boolean isOmnivore, @Nullable EonsPreyType preyType, @Nullable List<Item> favouriteFoodsInOrder) {
        this(true, isOmnivore, preyType, null, favouriteFoodsInOrder);
    }

    /** Construct specialist hunting diet */
    public EonsDiet(boolean isOmnivore, @Nullable List<LivingEntity> prey, @Nullable List<Item> favouriteFoodsInOrder) {
        this(true, isOmnivore, null, prey, favouriteFoodsInOrder);
    }

    /** Construct non-hunting diet */
    public EonsDiet(boolean isOmnivore, @Nullable List<Item> favouriteFoodsInOrder) {
        this(false, isOmnivore, null, null, favouriteFoodsInOrder);
    }

    // *** Methods ***

    /** */
    public boolean isBreedingItem(Item item) {
        if(this.favouriteFoodsInOrder != null) {
            return this.favouriteFoodsInOrder.contains(item);
        } else {
            return isEdible(item);
        }
    }

    /** */
    public boolean isBreedingItem(ItemStack stack) {return this.isBreedingItem(stack.getItem());}

    /** */
    public boolean isPredator() {return this.isPredator;}
    
    /** */
    public boolean isPrey(LivingEntity creature) {
        if(this.isPredator) {
            if(this.prey == null && this.preyType != null) {
                return this.preyType.isPrey(creature);
            } else if(this.prey != null && this.preyType == null) {
                return this.prey.contains(creature);
            }
        }
        return false;
    }

    /** @return item wanted most */
    public Item getPreferredFoodItem(List<Item> foodItems) {
        if(foodItems == null || foodItems.isEmpty()) {return null;}
        boolean hasPreferance = this.favouriteFoodsInOrder != null;
        Item preferred = null;
        for(Item foodItem : foodItems) {
            // check if item is food
            if(isEdible(foodItem)) {
                //
                if(preferred != null) {
                    preferred = compareFood(foodItem, preferred);
                } else {
                    preferred = foodItem;
                }

                if(!hasPreferance){return preferred;}
            }
        }
        return preferred;
    }

    /** @return can this item be eaten? */
    private boolean isEdible(Item foodItem) {
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

    /** @return returns the most wanted food item */
    private Item compareFood(Item item1, Item item2) {
        if(this.favouriteFoodsInOrder != null) {
            boolean item1_is_favourite = this.favouriteFoodsInOrder.contains(item1);
            boolean item2_is_favourite = this.favouriteFoodsInOrder.contains(item2);
            if(item1_is_favourite && item2_is_favourite) {
                if(this.favouriteFoodsInOrder.indexOf(item1) < this.favouriteFoodsInOrder.indexOf(item2)) {
                    return item1;
                } else {
                    return item2;
                }
            } else if(item1_is_favourite) {
                return item1;
            } else {
                return item2;
            }
        } else {
            return item1;
        }
    }

    // *** Inner Classes ***
    
    /** */
    public static enum EonsPreyType {
        ALL("all"),
        // Vanilla Generic Types
        ANIMAL("animal"),
        FISH("fish"),
        WATER("water"),
        FLYING("flying");
        // Eons Generic Types
        
        // Eons Specialized Types

        // *** Attributes ***
        private final List<LivingEntity> prey;
        private final String id;

        // *** Constructors ***
        
        /** */
        private EonsPreyType(List<LivingEntity> prey) {
            this.prey = prey;
            this.id = null;
        }

        /** */
        private EonsPreyType(String id) {
            this.prey = null;
            this.id = id;
        }

        // *** Methods ***

        /** */
        public boolean isPrey(LivingEntity entity) {
            if(prey == null && id != null) {
                switch(this.id){
                    // Vanilla Generic Types
                    case "all": {return true;}
                    case "animal": {return entity instanceof AnimalEntity;}
                    case "fish": {return entity instanceof AbstractFishEntity;}
                    case "water": {return entity instanceof WaterMobEntity;}
                    case "flying": {return entity instanceof IFlyingAnimal;}
                    default: {return false;}
                }
            } else {
                return prey.contains(entity);
            }
        }
    }
}