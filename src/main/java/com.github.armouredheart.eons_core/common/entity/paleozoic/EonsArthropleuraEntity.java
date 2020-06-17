// package

// Minecraft imports

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsAmphibianEntity;
import com.github.armouredheart.eons_core.common.EonsFieldNotes; 
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports

public class EonsArthropleuraEntity extends EonsBigBeastEntity {

    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;
    private static final EonsDiet DIET = new EonsDiet(10, false, null);

    // *** Constructors ***
    public EonsArthropleuraEntity(final EntityType<? extends EonsBeastEntity> type, final World world) {
        super(type, world, PARTS, FIELDNOTES, DIET, 50, false);
    }

    // *** Methods ***

    /** */
    @Override
    public CreatureAttribute getCreatureAttribute() {return CreatureAttribute.ARTHROPOD;}

    /** */
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
    }

}