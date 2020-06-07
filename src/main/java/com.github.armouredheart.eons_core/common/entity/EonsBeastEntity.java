// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.nbt.CompoundNBT;


// Forge imports
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.api.IEonsAnimationState;
import com.github.armouredheart.eons_core.client.EonsAnimationState;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.common.entity.ai.EonsSex;
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class EonsBeastEntity extends AnimalEntity implements IEonsBeast, IEonsSexuallyDimorphic, IEonsAnimationState {

   // *** Attributes ***
   private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsBeastEntity");
   private EonsAnimationState state;
   private final EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
   private final EonsDiet diet;
   private final boolean isNocturnal;
   private EonsSex sex;

   // *** Constructors ***

   /**
   * @param type
   * @param world
   * @param fieldNotes
   * @param diet
   * @param sexRatio
   * @param isNocturnal
   */
   protected EonsBeastEntity(final EntityType<? extends AnimalEntity> type, final World world, final EonsFieldNotes fieldNotes, final EonsDiet diet, final int sexRatio, final boolean isNocturnal) {
      super(type, world);
      this.fieldNotes = fieldNotes;
      this.stepHeight = 1.0F;
      this.diet = diet;
      this.sex = new EonsSex(this, sexRatio);
      this.isNocturnal = isNocturnal;
   }

   /** Default Settings EonsBeast constructor*/
   protected EonsBeastEntity(final EntityType<? extends AnimalEntity> type, final World world, final EonsFieldNotes fieldNotes) {
      this(type, world, fieldNotes, new EonsDiet(8, false, null), 50, false);
   }

   // *** Methods ***

   /** */
   @Override
   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
   }

   /** */
   @OnlyIn(Dist.CLIENT)
   public EonsAnimationState getState() {return this.state;}

   /** */
   @OnlyIn(Dist.CLIENT)
   public void setState(EonsAnimationState state) {this.state = state;}

   /** */
   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }


   /**
   * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
   * the animal type)
   */
   @Override
   public boolean isBreedingItem(ItemStack stack) {
      return this.diet.isBreedingItem(stack);
   }

   /** */
   public EonsDiet getDiet() {return this.diet;}

   /** */
   public boolean isWounded() {
      if(this.getHealthPercentage() > 0.4D) {
         return false;
      } else {
         return true;
      }
   }

   /** */
   public void setRested() {
      // give regeneration if not hungry
   }

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
   public int getThreat() {
      int threatFactor = 0;
      return (int) this.getHealth()*threatFactor;
   }

   /** Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
   public int getResolve() {
      int resolveFactor = 0;
      return (int) this.getHealth()*resolveFactor;
   }

   /** */
   public boolean isMale() {return this.sex.isMale();}

   /** */
   public boolean isFemale() {return this.sex.isFemale();}

   /** */
   //public boolean isEnraged();

   /** */
   //protected boolean setEnraged();

   /** */
   //protected boolean setCalm();

   /** Checks if beast becomes enraged.*/
   //protected boolean rageCheck();

   /** Checks if beast calms down.*/
   //protected boolean calmCheck();
}