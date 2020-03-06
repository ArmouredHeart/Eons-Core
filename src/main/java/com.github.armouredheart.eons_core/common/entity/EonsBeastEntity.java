// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.passive.WaterMobEntity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;

// misc imports

public abstract class EonsBeastEntity extends AnimalEntity implements IEonsBeast {

   // *** Attributes ***
   protected final static EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform

   // *** Constructors ***

   /** */
   protected EonsBeastEntity(EntityType<? extends AnimalEntity> type, World world, EonsFieldNotes fieldNotes) {
      super(type, world);
      this.fieldNotes = fieldNotes;
   }

   // *** Methods ***

   /** @return EonsFieldNotes object containing educational notes about lifeform.*/
   protected EonsFieldNotes getFieldNotes() {
      return fieldNotes;
   }
      
   /** */
   @Override
   public boolean processInteract(PlayerEntity player, Hand hand) {
      ItemStack itemstack = player.getHeldItem(hand);
      if (this.isBreedingItem(itemstack)) {
         if (this.getGrowingAge() == 0 && this.canBreed()) {
            this.consumeItemFromStack(player, itemstack);
            this.setInLove(player);
            return true;
         }

         if (this.isChild()) {
            this.consumeItemFromStack(player, itemstack);
            this.ageUp((int)((float)(-this.getGrowingAge() / 20) * 0.1F), true);
            return true;
         }
      } else if (false) {
            // add field notes to player book
            //TODO
      }

      return super.processInteract(player, hand);
   }
}