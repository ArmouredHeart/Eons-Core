// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.item.ItemStack;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
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
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataParameter;

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
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class EonsBeastEntity extends AnimalEntity implements IEonsBeast, IEonsSexuallyDimorphic, IEonsAnimationState {

   // *** Attributes ***
   // DATA
   private static final DataParameter<Boolean> SLEEPING = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> SWIMMING = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> GRABBING = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> THREATENING = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> SPRINTING = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> SNEAKING = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> FLYING = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BOOLEAN);  
   private static final DataParameter<Byte> SEX = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BYTE);

   // 
   private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsBeastEntity");
   private final EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
   private final EonsDiet diet;
   private final boolean isNocturnal;
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
      this.isNocturnal = isNocturnal;
      this.setCanPickUpLoot(true);
      IEonsSexuallyDimorphic.assignSex(this, sexRatio);
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
      this.diet.dietTick();
   }

   /** */
   @Override
   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
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

   /**
    * Returns true if the mob is currently able to mate with the specified mob.
    */
   @Override
   public boolean canMateWith(AnimalEntity otherAnimal) {
      boolean flag = super.canMateWith(otherAnimal);
      if(otherAnimal instanceof IEonsSexuallyDimorphic) {
         IEonsSexuallyDimorphic other = (IEonsSexuallyDimorphic) otherAnimal;
         return flag && this.isOppositeSex(other);
      } else {
         return flag;
      }
   }

   /** */
   public EonsDiet getDiet() {return this.diet;}

   /** */
   public boolean isWounded() {return IEonsBeast.testForWounds(this, 0.4D, false);}

   public boolean shouldSleep() {return false;}

   /** */
   public boolean isNocturnal() {return this.isNocturnal;}

   /** */
   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.0D));
      this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
   }

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
   public int getThreat() {return 0 + (int) (this.getHealth() * this.threatFactor);}

   /** Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
   public int getResolve() {return 0 + (int) (this.getHealth() * this.resolveFactor);}

   /** default values are 1.0 for each. */
   protected void setThreatFactorResolveFactor(double threatFactor, double resolveFactor) {
      this.threatFactor = threatFactor;
      this.resolveFactor = resolveFactor;
   }

   @Override
   protected void registerData() {
      super.registerData();
      this.dataManager.register(SWIMMING, Boolean.valueOf(false));
      this.dataManager.register(SLEEPING, Boolean.valueOf(false));
      this.dataManager.register(SPRINTING, Boolean.valueOf(false));
      this.dataManager.register(FLYING, Boolean.valueOf(false));
      this.dataManager.register(SNEAKING, Boolean.valueOf(false));
      this.dataManager.register(THREATENING, Boolean.valueOf(false));
      this.dataManager.register(ATTACKING, Boolean.valueOf(false));
      this.dataManager.register(GRABBING, Boolean.valueOf(false));
      this.dataManager.register(SEX, Byte.valueOf((byte) 0));
   }  
      
   /** */
   @Override
   public byte getSexByteData() {return this.dataManager.get(SEX).byteValue();}

   /** */
   @Override
   public void setSexByteData(byte data) {this.dataManager.set(SEX, Byte.valueOf(data));}

   @Override
   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      // animation state data
      compound.putBoolean("Sprinting", this.isSprinting());
      compound.putBoolean("Sneaking", this.isSneaking());
      compound.putBoolean("Threatening", this.isThreatening());
      compound.putBoolean("Grabbing", this.isGrabbing());
      compound.putBoolean("Sleeping", this.isSleeping());   
      compound.putBoolean("Attacking", this.isAttacking());
      compound.putBoolean("Pouncing", this.isPouncing());
      compound.putBoolean("Swimming", this.isSwimming());
      compound.putBoolean("OnShoulder", this.isOnShoulder());
      compound.putBoolean("Climbing", this.isClimbing());
      compound.putBoolean("Flying", this.isFlying());
      compound.putBoolean("Eating", this.isEating());

      // entity data
      compound.putByte("Sex", this.getSexByteData());
   }

   @Override
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      // animation state data
      this.setSprinting(compound.getBoolean("Sprinting"));
      this.setSneaking(compound.getBoolean("Sneaking"));
      this.setThreatening(compound.getBoolean("Threatening"));
      this.setGrabbing(compound.getBoolean("Grabbing"));
      this.setSleeping(compound.getBoolean("Sleeping"));
      this.setAttacking(compound.getBoolean("Attacking"));
      this.setPouncing(compound.getBoolean("Pouncing"));
      this.setSwimming(compound.getBoolean("Swimming"));
      this.setOnShoulder(compound.getBoolean("OnShoulder"));
      this.setClimbing(compound.getBoolean("Climbing"));
      this.setFlying(compound.getBoolean("Flying"));
      this.setEating(compound.getBoolean("Eating"));

      // entity data
      this.setSexByteData(compound.getByte("Sex"));
   }

}