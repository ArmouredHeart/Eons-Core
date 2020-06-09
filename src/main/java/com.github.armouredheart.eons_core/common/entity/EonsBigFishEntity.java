// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.item.ItemStack;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;

// Forge imports
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.client.EonsAnimationState;
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.api.IEonsAnimationState;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.common.entity.ai.EonsSex;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsBigFishEntity extends AbstractFishEntity implements IEonsBeast, IEonsSexuallyDimorphic, IEonsAnimationState {
    // *** Attributes ***
    private EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
    private EonsAnimationState state;
    private EonsSex sex;
    private final EonsDiet diet;
    private final boolean isNocturnal;
    private double threatFactor = 1.0D; // default value is 1.0D
    private double resolveFactor = 1.0D; // default value is 1.0D

    // *** Constructors ***

    /**
    * @param type
    * @param world
    * @param fieldNotes
    * @param diet
    * @param sexRatio
    * @param isNocturnal
    */
    protected EonsBigFishEntity(final EntityType<? extends AbstractFishEntity> type, final World world, final EonsFieldNotes fieldNotes, final EonsDiet diet, final int sexRatio, final boolean isNocturnal) {
        super(type, world);
        this.diet = diet;
        this.sex = new EonsSex(this, sexRatio);
        this.isNocturnal = isNocturnal;
        this.setCanPickUpLoot(true);
        this.state = null;
    }

    /** */
    protected EonsBigFishEntity(final EntityType<? extends AbstractFishEntity> type, final World world, final EonsFieldNotes fieldNotes) {
        this(type, world, fieldNotes, new EonsDiet(8, false, null), 50, false);
    }

    // *** Methods ***

    /** */
    public EonsAnimationState getState() {return this.state;}

    /** */
    public void setState(EonsAnimationState state) {this.state = state;}

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
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
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    /** */
    public EonsFieldNotes getFieldNotes(){return fieldNotes;}

    /** */
    public boolean isMale() {return this.sex.isMale();}

    /** */
    public boolean isFemale() {return this.sex.isFemale();}

    /** */
    @Override
    protected SoundEvent getFlopSound() {return null;}

    /** */
    @Override
    protected SoundEvent getSwimSound() {return SoundEvents.ENTITY_DOLPHIN_SWIM;}

    /** */
	@Override
	protected ItemStack getFishBucket() {return null;}

    /** */
    public boolean isNocturnal() {return this.isNocturnal;}

    /** Calculated using remaining HP, Personality and Attack damage plus threatBoost.*/
    public int getThreat() {return (int) (this.getHealth() * this.threatFactor * this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue() / this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).getValue());}

    /** Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
    public int getResolve() {return (int) (this.getHealth()*this.resolveFactor);}

    /** Use when mob needs a boost */
    protected void setThreatFactorResolveFactor(double threatFactor, double resolveFactor) {
        this.threatFactor = threatFactor;
        this.resolveFactor = resolveFactor;
    }

    /** */
    public EonsDiet getDiet() {return this.diet;}

    /** */
    public boolean isWounded() {return IEonsBeast.testForWounds(this, 0.4D, false);}

}