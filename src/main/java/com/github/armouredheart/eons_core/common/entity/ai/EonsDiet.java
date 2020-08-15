// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
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
    private int metabolismTimer;
    //private final boolean allowCanibalismIfStarving;
    private final boolean isPredator;
    private final boolean isOmnivore;
    private final List<Item> favouriteFoodsInOrder;
    private final List<Class<? extends LivingEntity>> favouritePrey;
    private final EonsPreyType preyType;
    private static final int dayLengthTicks = 24000; // fixed value, make this a calculated value in the future if variable day length

    // *** Constructors ***

    /**
     * 
     * @param stomachSize
     * @param isOmnivore
     * @param preyType
     * @param favouritePrey
     * @param favouriteFoodsInOrder
     */
    public EonsDiet(int stomachSize, boolean isOmnivore, @Nullable EonsPreyType preyType, @Nullable List<Class<? extends LivingEntity>> favouritePrey, @Nullable List<Item> favouriteFoodsInOrder) {
        super(stomachSize);
        this.favouritePrey = favouritePrey;
        this.favouriteFoodsInOrder = favouriteFoodsInOrder;
        this.isPredator = (preyType != null || favouritePrey != null);
        this.isOmnivore = isOmnivore;
        this.preyType = preyType;

        // initialize dynamic attributes
        this.metabolismTimer = 0;
        this.isStarving = true;
        this.isHungry = true;
    }

    /** Construct non-hunting diet */
    public EonsDiet(int stomachSize, boolean isOmnivore, @Nullable List<Item> favouriteFoodsInOrder) {
        this(stomachSize, isOmnivore, null, null, favouriteFoodsInOrder);
    }

    /** Construct non-eating diet */
    public EonsDiet() {
        this(0, false, null, null, null);
    }

    // *** Methods ***


    /** */
    public void dietTick() {
        ++this.metabolismTimer;
        if(this.metabolismTimer > dayLengthTicks) {
            if(this.digestFood()) {
                this.metabolismTimer = 0;
            }
        }
    }

    /** Return false if there is no food to digest. */
    public boolean digestFood() {
        // don't bother if starving
        if(!this.isStarving) {

            // search for food in stomach
            for (int i = 0; i < this.getSizeInventory(); i++) {
                // try to digest
                ItemStack foodStack = decrStackSize(i, 1); 
                if(!foodStack.isEmpty()) {
                    // digestion successful!
                    this.updateStomachState();
                    return true;
                }
            }
        }
        return false;
    }

    /** This method should be called when the stomach inventory is changed. */
    public void updateStomachState() {

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
            ItemStack foodIn = super.addItem(stack);
            this.updateStomachState();
            return foodIn;
        } else {
            // item is not edible
            return stack;
        }
    }

    /** */
    public boolean hasFavouredPrey() {return this.favouritePrey != null;}

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
        if(this.isPredator) {return isFavouredPrey(creature) || isAcceptablePrey(creature);} else {return false;}
    }

    /** */
    public boolean isAcceptablePrey(LivingEntity creature) {
        if(this.preyType != null) {
            return this.preyType.isPrey(creature);
        } else {return false;}
    }

    /** */
    public boolean isFavouredPrey(LivingEntity creature) {
        if(this.hasFavouredPrey()) {
            return this.favouritePrey.contains(creature.getClass());
        } else {return false;}
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
        ALL("all", null),
        // Vanilla Generic Types
        ANIMAL("animal", null),
        FISH("fish", null),
        WATER("water", null),
        ARTHROPOD("arthropod", null),
        FLYING("flying", null);
        // Eons Generic Types
        
        // Eons Specialized Types

        // *** Attributes ***
        private final List<Class<? extends LivingEntity>> prey;
        private final String id;
        private final boolean hasType;
        private final boolean hasPrey;
        // *** Constructors ***
        
        /** */
        private EonsPreyType(@Nullable String id, @Nullable List<Class<? extends LivingEntity>> prey) {
            this.prey = prey;
            this.id = id;
            this.hasType = this.id != null;
            this.hasPrey = this.id != null;
        }

        // *** Methods ***

        /** */
        public boolean isPrey(LivingEntity entity) {
            // check for type match
            if(this.hasType) {
                switch(this.id){
                    // Vanilla Generic Types
                    case "all": {return true;}
                    case "animal": {return entity instanceof AnimalEntity;}
                    case "fish": {return entity instanceof AbstractFishEntity;}
                    case "water": {return entity.getCreatureAttribute() == CreatureAttribute.WATER;}
                    case "arthropod": {return entity.getCreatureAttribute() == CreatureAttribute.ARTHROPOD;}
                    case "flying": {return entity instanceof IFlyingAnimal;}
                    default: {break;}
                }
            }
            // check for class match
            if(this.hasPrey) {return this.prey.contains(entity.getClass());}
            
            // this straight up isn't food my dude
            return false;
        }
    }
}