// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.item.ItemStack;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import javax.annotation.Nullable;

public abstract class EonsBigFishEntity extends AbstractFishEntity implements IEonsLifeForm, IEonsSexuallyDimorphic {
    // *** Attributes ***
    private EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
    private boolean isMale = true;

    // *** Constructors ***
    protected EonsBigFishEntity(final EntityType<? extends AbstractFishEntity> type, final World world, final EonsFieldNotes fieldNotes) {
        super(type, world);
    }

    // *** Methods ***

    /** */
    public EonsFieldNotes getFieldNotes(){return fieldNotes;}

    /** */
    public boolean isMale() {return isMale;}

    /** */
    public boolean isFemale() {return !isMale;}

    /** */
    @Override
    protected SoundEvent getFlopSound(){return null;}

    /** */
    @Override
    protected SoundEvent getSwimSound() {return null;}

    /** */
	@Override
	protected ItemStack getFishBucket(){return null;}

}