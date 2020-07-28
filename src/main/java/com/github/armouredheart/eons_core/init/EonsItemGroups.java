// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.init.EonsItems;

// misc imports
import javax.annotation.Nonnull;
import java.util.function.Supplier;


public final class EonsItemGroups {

	// *** Creative Tabs ***

    // Default Creative Tab for Eons
	public static final ItemGroup EONS_ITEM_GROUP = new EonsItemGroup(EonsCore.MOD_ID, () -> new ItemStack(EonsItems.EONS_MUSIC_DISC_PRIMAL_AGE.get()));
	public static final ItemGroup PALEOZOIC_GROUP = new EonsItemGroup(EonsCore.MOD_ID, () -> new ItemStack(EonsItems.EONS_MUSIC_DISC_PRIMAL_AGE.get()));
	public static final ItemGroup CENOZOIC_GROUP = new EonsItemGroup(EonsCore.MOD_ID, () -> new ItemStack(EonsItems.EONS_MUSIC_DISC_PRIMAL_AGE.get()));
	public static final ItemGroup MESOZOIC_GROUP = new EonsItemGroup(EonsCore.MOD_ID, () -> new ItemStack(EonsItems.EONS_MUSIC_DISC_PRIMAL_AGE.get()));

	// *** Methods ***

	// *** Inner Classes ***
	
	/** Cadiboo code */
	public static final class EonsItemGroup extends ItemGroup {

		@Nonnull
		private final Supplier<ItemStack> iconSupplier;

		/** */
		public EonsItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}

		@Override
		@Nonnull
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
		
	}

}