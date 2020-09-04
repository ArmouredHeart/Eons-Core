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
import net.minecraft.entity.LivingEntity;
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
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.api.IEonsAnimationEntity;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.api.EonsAnimationHandler;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsBeastEntity extends AnimalEntity implements IEonsBeast, IEonsLifeForm, IEonsSexuallyDimorphic, IEonsAnimationEntity {

   // *** Attributes ***
   // data
   private static final DataParameter<Byte> SEX = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BYTE);

   // 
   private static final EonsAnimationHandler ANIMATION_HANDLER = new EonsAnimationHandler();
   private final EonsFieldNotes FIELD_NOTES; // pointer to educational notes about lifeform
   private final EonsDiet DIET;
   private final boolean IS_NOCTURNAL;

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
      this.FIELD_NOTES = fieldNotes;
      this.DIET = diet;
      this.IS_NOCTURNAL = isNocturnal;
      this.setCanPickUpLoot(true);
      IEonsSexuallyDimorphic.assignSexByRatio(this, sexRatio);
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
      this.DIET.dietTick();
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
      return this.DIET.isBreedingItem(stack);
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
   public EonsDiet getDiet() {return this.DIET;}

   public boolean shouldSleep() {return false;}

   /** */
   public boolean isNocturnal() {return this.IS_NOCTURNAL;}

   /** */
   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.0D));
      this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
   }

   /** */
   protected float getLocalTemperature() {  
      /*int i = MathHelper.floor(this.posX);
      int j = MathHelper.floor(this.posY);
      int k = MathHelper.floor(this.posZ);
      return this.world.getBiome(new BlockPos(i, 0, k)).func_225486_c(new BlockPos(i, j, k));// obfuscated method, replace when possible
      */
      return 0.5F;
   }

   /** */
   protected double getSpeed() {
      return this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
   }

   /** @return EonsFieldNotes object containing educational notes about lifeform.*/
   public EonsFieldNotes getFieldNotes() {
      return this.FIELD_NOTES;
   }

   /** */
   @Override
   public boolean processInteract(PlayerEntity player, Hand hand) {
      IEonsLifeForm.addNotesToJournal(this, player, hand);
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
      
   @Override
   protected void registerData() {
      super.registerData();
      IEonsSexuallyDimorphic.registerSexData(this);
   }

   @Override
   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      // entity data
      IEonsSexuallyDimorphic.writeSexToNBT(this, compound);
   }

   @Override
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      // entity data
      IEonsSexuallyDimorphic.readSexFromNBT(this, compound);
   }

   /** */
	@Override
   public EonsAnimationHandler getAnimationHandler() {return EonsBeastEntity.ANIMATION_HANDLER;}

   @Override
   public EntityDataManager getEntityDataManager() {return this.dataManager;}

   @Override
   public DataParameter<Byte> getSexParameter() {return EonsBeastEntity.SEX;}
}