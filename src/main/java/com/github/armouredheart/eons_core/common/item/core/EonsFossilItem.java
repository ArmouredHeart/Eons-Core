// package
package com.github.armouredheart.eons_core.common.item.core;

// Minecraft imports
import net.minecraft.item.Item;

import net.minecraft.item.Rarity;
import net.minecraft.util.SoundEvent;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.init.EonsItemGroups;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;

// misc imports

public class EonsFossilItem extends Item {

    // *** Attributes ***
    private final EonsFieldNotes FIELD_NOTES;

    // *** Constructors ***

    /** */
    public EonsFossilItem(Item.Properties builder, final EonsFieldNotes fieldNotes) {
        super(builder);
        this.FIELD_NOTES = fieldNotes;
    }

    // *** Methods ***

    /** */
    public EonsFieldNotes getFieldNotes() {return this.FIELD_NOTES;}
}