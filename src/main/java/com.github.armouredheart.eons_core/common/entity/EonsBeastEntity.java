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
import net.minecraft.util.DamageSource;
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
   private final EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
   private final EonsDiet diet;
   private final boolean isNocturnal;
   private EonsSex sex;
   private double threatFactor = 1.0D;
   private double resolveFactor = 1.0D;

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
      this.setCanPickUpLoot(true);
   }

   /** Default Settings EonsBeast constructor*/
   protected EonsBeastEntity(final EntityType<? extends AnimalEntity> type, final World world, final EonsFieldNotes fieldNotes) {
      this(type, world, fieldNotes, new EonsDiet(8, false, null), 50, false);
   }

   // *** Methods ***

   /** */
   @Override
   public void tick() {
      super.tick();
      // do some stuff here maybe?
   }

   /** */
   @Override
   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
   }

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
   public boolean isWounded() {return IEonsBeast.testForWounds(this, 0.4D, false);}

   public boolean shouldSleep() {return false;}

   /** */
   public boolean isNocturnal() {return this.isNocturnal;}

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
   public int getThreat() {return (int) (this.getHealth() * this.threatFactor * this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue() / this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).getValue());}

   /** Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
   public int getResolve() {return (int) (this.getHealth()*this.resolveFactor);}

   /** */
   protected void setThreatFactorResolveFactor(double threatFactor, double resolveFactor) {
      this.threatFactor = threatFactor;
      this.resolveFactor = resolveFactor;
   }

   /** */
   public boolean isMale() {return this.sex.isMale();}

   /** */
   public boolean isFemale() {return this.sex.isFemale();}

   /** */
	@Override
   public boolean isSwimming() {return this.handleWaterMovement();}

   /** */
	@Override
   public boolean isWalking() {return this.onGround;}

}