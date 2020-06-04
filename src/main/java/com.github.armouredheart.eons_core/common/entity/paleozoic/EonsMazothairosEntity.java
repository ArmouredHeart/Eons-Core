// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.Item;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsArthropodEntity;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports
import java.util.List;
import java.util.Arrays;

public class EonsMazothairosEntity extends EonsArthropodEntity {

    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;
    private static final EonsDiet DIET = new EonsDiet(false, null/**Arrays.asList(null)*/);

    // *** Constructors ***
    
    /** */
    public EonsMazothairosEntity(final EntityType<? extends EonsMazothairosEntity> type, final World world) {
        super(type, world, FIELDNOTES, DIET, 50, false);
    }
    
    // *** Methods ***
}