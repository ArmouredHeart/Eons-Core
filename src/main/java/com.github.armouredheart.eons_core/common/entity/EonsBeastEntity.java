// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

// Forge imports
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports

public abstract class EonsBeastEntity extends AnimalEntity implements IEonsBeast, IEonsSexuallyDimorphic {

   // *** Attributes ***
   //private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.CARROT, Items.POTATO, Items.BEETROOT);
   private EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
   private boolean isMale = true;

   // *** Constructors ***

   /** */
   protected EonsBeastEntity(final EntityType<? extends AnimalEntity> type, final World world, final EonsFieldNotes fieldNotes) {
      super(type, world);
      this.setFieldNotes(fieldNotes);
      this.stepHeight = 1.0F;
   }

   // *** Methods ***

   /** */
   protected void registerEonsBeastGoals() {

   }

   /** */
   protected float getLocalTemperature() {  
      int i = MathHelper.floor(this.posX);
      int j = MathHelper.floor(this.posY);
      int k = MathHelper.floor(this.posZ);
      return this.world.getBiome(new BlockPos(i, 0, k)).func_225486_c(new BlockPos(i, j, k));
   }

   /** */
   protected double getSpeed() {
      return this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
   }

   /** @return EonsFieldNotes object containing educational notes about lifeform.*/
   public EonsFieldNotes getFieldNotes() {
      return fieldNotes;
   }

   /** */
   protected boolean setFieldNotes(EonsFieldNotes fieldNotes) {
      try { 
         this.fieldNotes = fieldNotes;
         return true;
      } catch (Exception e) {
         return false;
      }
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

   /** */
   @Override
   public EonsBeastEntity createChild(final AgeableEntity parent) {
		// Use getType to support overrides in subclasses
		return (EonsBeastEntity) getType().create(this.world);
	}

   /** */
   @Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
   
   /** Calculated using remaining HP, Personality and Attack damage plus threatBoost.*/
   public int getThreat() {return 1;}

   /** Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
   public int getResolve() {return 1;}

   /** */
   public boolean isMale() {return isMale;}

   /** */
   public boolean isFemale() {return !isMale;}

   /** */
   //protected boolean isHungry();

   /** */
   //public boolean isEnraged();

   /** */
   //protected boolean setEnraged();

   /** */
   //protected boolean setCalm();

   /** */
   //protected boolean resolveCheck(int threat);

   /** Checks if beast becomes enraged.*/
   //protected boolean rageCheck();

   /** Checks if beast calms down.*/
   //protected boolean calmCheck();
}