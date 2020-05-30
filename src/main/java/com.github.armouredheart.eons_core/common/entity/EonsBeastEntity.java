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
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsBeastEntity extends AnimalEntity implements IEonsBeast, IEonsSexuallyDimorphic {

   // *** Attributes ***
   private final EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
   private boolean isMale;
   private final EonsDiet diet;
   private final int sexRatio;
   private final boolean isNocturnal;

   // *** Constructors ***

   /**
   * @param type
   * @param world
   * @param fieldNotes
   * @param diet
   * @param sexRatio
   * @param isNocturnal
   */
   protected EonsBeastEntity(final EntityType<? extends AnimalEntity> type, final World world, final EonsFieldNotes fieldNotes, final EonsDiet diet, int sexRatio, boolean isNocturnal) {
      super(type, world);
      this.fieldNotes = fieldNotes;
      this.stepHeight = 1.0F;
      this.diet = diet;
      this.sexRatio = sexRatio;
      this.isNocturnal = isNocturnal;
   }

   /** Default Settings EonsBeast constructor*/
   protected EonsBeastEntity(final EntityType<? extends AnimalEntity> type, final World world, final EonsFieldNotes fieldNotes) {
      this(type, world, fieldNotes, new EonsDiet(false, null), 50, false);
   }

   // *** Methods ***

   /**
   * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
   * the animal type)
   */
   @Override
   public boolean isBreedingItem(ItemStack stack) {
      return this.diet.isBreedingItem(stack);
   }

   protected boolean determineSex(){
      if(this.sexRatio < this.world.rand.nextInt(99)){return true;} else {return false;}
   }

   /** */
   public EonsDiet getDiet(){return this.diet;}

   /** */
   public boolean isWounded(){
      if(this.getHealthPercentage() > 0.4D) {
         return false;
      } else {
         return true;
      }
   }

   /** */
   public void setRested() {}

   public boolean shouldSleep() {return false;}

   /** */
   public boolean isNocturnal() {
      return this.isNocturnal;
   }

   /** */
   protected void registerEonsBeastGoals() {}

   /** */
   protected float getLocalTemperature() {  
      int i = MathHelper.floor(this.posX);
      int j = MathHelper.floor(this.posY);
      int k = MathHelper.floor(this.posZ);
      return this.world.getBiome(new BlockPos(i, 0, k)).func_225486_c(new BlockPos(i, j, k));// obfuscated method, replace when possible
   }

   /** */
   protected double getSpeed() {
      return this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
   }

   /** */
   protected double getHealthPercentage() {
      double maxHP = this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getValue();
      double currentHP = this.getHealth();
      return (double) currentHP/maxHP;
   }

   /** @return EonsFieldNotes object containing educational notes about lifeform.*/
   public EonsFieldNotes getFieldNotes() {
      return this.fieldNotes;
   }

   /** */
   @Override
   public boolean processInteract(PlayerEntity player, Hand hand) {
      ItemStack itemstack = player.getHeldItem(hand);
      if(false) {
         //TODO collect field notes if holding notebook
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
   public boolean isHungry() {
      return true;
   }

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