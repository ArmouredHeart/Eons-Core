// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.EonsForgeHelper;

// misc imports

public class Stomach extends Inventory {
    
    // *** Attributes ***
    private boolean isStarving; // cached this value because it is called often.
    private boolean isHungry; // cached this value because it is called often.
    private int metabolismTimer;
    public static final float DEFAULT_DIGESTION_RATE = 1.0f;
    private final int METABOLIC_TICK_TARGET;
    private final Diet DIET;

    // *** Constructors ***

    /**
     * 
     * @param stomach_size
     * @param diet
     * @param digestion_rate
     */
    public Stomach(int stomach_size, Diet diet, double digestion_rate) {
        super(stomach_size);
        this.METABOLIC_TICK_TARGET = (int) (EonsForgeHelper.DEFAULT_DAY_LENGTH_TICKS * digestion_rate);
        // initialize dynamic attributes
        this.metabolismTimer = 0;
        this.isStarving = true;
        this.isHungry = true;
        this.DIET = diet;
    }

    /**
     * 
     * @param species
     */
    public Stomach(Species species) {
        this(species.getStomachSize(), species.getDiet(), Stomach.DEFAULT_DIGESTION_RATE);
    }

    // *** Methods ***

    /** call this every tick for the mob to get accurate digestion*/
    public void stomachTick() {
        ++this.metabolismTimer;
        if(this.metabolismTimer > this.METABOLIC_TICK_TARGET) {
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
        if(this.DIET.isEdible(stack.getItem())) {
            // eat item
            ItemStack foodIn = super.addItem(stack);
            this.updateStomachState();
            return foodIn;
        } else {
            // item is not edible
            return stack;
        }
    }

    public boolean isHungry() {return this.isHungry;}
    public boolean isStarving() {return this.isStarving;}
}
