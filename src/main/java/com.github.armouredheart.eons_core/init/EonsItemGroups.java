// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import javax.annotation.Nonnull;
import java.util.function.Supplier;


public final class EonsItemGroups {

	// *** Creative Tabs ***

    // Default Creative Tab for Eons
	public static final ItemGroup EONS_ITEM_GROUP = new EonsItemGroup(EonsCore.MOD_ID, () -> new ItemStack(EonsItems.EONS_SPEAR_ITEM.get()));

	// *** Methods ***

    // *** Inner Classes ***
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