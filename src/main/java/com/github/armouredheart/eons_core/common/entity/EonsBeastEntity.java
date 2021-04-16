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
import com.github.armouredheart.eons_core.api.Species;
import com.github.armouredheart.eons_core.api.Stomach;
import com.github.armouredheart.eons_core.api.EonsAnimationHandler;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsBeastEntity extends AnimalEntity implements IEonsBeast, IEonsSexuallyDimorphic, IEonsAnimationEntity {

   // *** Attributes ***
   // data
   private static final DataParameter<Byte> SEX = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BYTE);

   // 
   private static final EonsAnimationHandler ANIMATION_HANDLER = new EonsAnimationHandler();
   private final Species SPECIES; // pointer to educational notes about lifeform
   private final Stomach STOMACH;

   // *** Constructors ***

   /**
   * @param type
   * @param world
   * @param species
   * @param sexRatio
   * @param isNocturnal
   */
   protected EonsBeastEntity(final EntityType<? extends AnimalEntity> type, final World world, final Species species) {
      super(type, world);
      this.SPECIES = species;
      this.STOMACH = new Stomach(Species.getMobData(this));
      this.setCanPickUpLoot(true);
      IEonsSexuallyDimorphic.assignSexByRatio(this, Species.getMobData(this));
   }

   // *** Methods ***

   /** */
   @Override
   public void tick() {
      super.tick();
      IEonsBeast.doBeastTick(this);
   }

   /** */
   @Override
   protected void registerAttributes() {
      super.registerAttributes();
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
      return Species.getMobData(this).getDiet().isBreedingItem(stack);
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

   public Stomach getStomach() {return this.STOMACH;}
   public boolean shouldSleep() {return false;}

   /** */
   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.0D));
      this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
   }

   /** */
   protected double getSpeed() {
      return this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
   }

   /** @return Species object containing educational notes about lifeform.*/
   public Species getSpecies() {
      return this.SPECIES;
   }

   /** */
   @Override
   public boolean processInteract(PlayerEntity player, Hand hand) {
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