// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.Inventory;

// Forge imports

// Eons imports

// misc imports
import java.util.List;
import javax.annotation.Nullable;

public class EonsDiet extends Inventory {

    // *** Attributes ***
    private boolean isStarving; // cached this value because it is called often.
    private boolean isHungry; // cached this value because it is called often.
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
    private EonsDiet(int stomachSize, boolean isPredator, boolean isOmnivore, @Nullable EonsPreyType preyType, @Nullable List<LivingEntity> prey, @Nullable List<Item> favouriteFoodsInOrder) {
        super(stomachSize);
        this.prey = prey;
        this.favouriteFoodsInOrder = favouriteFoodsInOrder;
        this.isPredator = isPredator;
        this.isOmnivore = isOmnivore;
        this.preyType = preyType;
    }

    /** Construct generalist hunting diet */
    public EonsDiet(int stomachSize, boolean isOmnivore, @Nullable EonsPreyType preyType, @Nullable List<Item> favouriteFoodsInOrder) {
        this(stomachSize, true, isOmnivore, preyType, null, favouriteFoodsInOrder);
    }

    /** Construct specialist hunting diet */
    public EonsDiet(int stomachSize, boolean isOmnivore, @Nullable List<LivingEntity> prey, @Nullable List<Item> favouriteFoodsInOrder) {
        this(stomachSize, true, isOmnivore, null, prey, favouriteFoodsInOrder);
    }

    /** Construct non-hunting diet */
    public EonsDiet(int stomachSize, boolean isOmnivore, @Nullable List<Item> favouriteFoodsInOrder) {
        this(stomachSize, false, isOmnivore, null, null, favouriteFoodsInOrder);
    }

    // *** Methods ***

    /** This method should be called when the stomach inventory is changed. */
    public void updateStomach() {

        // update if this is starving or not
        this.isStarving = this.isEmpty();
        if(this.isStarving) {
            // if starving, then also hungry
            this.isHungry = true;
        } else {
            // is hungry?
            // how many empty slots are in the stomach?
            int numEmptyStacks = 0;
            int stomachSize = this.getSizeInventory();
            for(int i = 0; i < stomachSize; i++) {
                if(this.getStackInSlot(i) == ItemStack.EMPTY) {numEmptyStacks++;}
            }

            // if over half the stomach is empty, return true;
            this.isHungry = numEmptyStacks > stomachSize*2/3;
        }
    }

    /** */
    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {return false;}

    /** */
    @Override
    public ItemStack addItem(ItemStack stack) {
        if(isEdible(stack.getItem())) {
            // eat item
            return super.addItem(stack);
        } else {
            // item is not edible
            return stack;
        }
    }

    /** */
    public boolean isHungry() {return this.isHungry;}

    /** */
    public boolean isStarving() {return this.isStarving;}

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
        ARTHROPOD("arthropod"),
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
                    case "water": {return entity.getCreatureAttribute() == CreatureAttribute.WATER;}
                    case "arthropod": {return entity.getCreatureAttribute() == CreatureAttribute.ARTHROPOD;}
                    case "flying": {return entity instanceof IFlyingAnimal;}
                    default: {return false;}
                }
            } else {
                return prey.contains(entity);
            }
        }
    }
}