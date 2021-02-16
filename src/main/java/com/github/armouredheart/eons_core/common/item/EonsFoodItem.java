// package
package com.github.armouredheart.eons_core.common.item;

import javax.annotation.Nullable;

// Minecraft imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

// inspired by Alex-the-666 ice and fire "GenaricFoodItem"
public class EonsFoodItem extends Item {

    public EonsFoodItem(int feed_amount, float saturation, boolean isMeat, boolean eatFast, boolean alwaysEdible, @Nullable EffectInstance potion, ItemGroup group) {
        super(new Item.Properties().food(createFood(feed_amount, saturation, isMeat, eatFast, alwaysEdible, potion)).group(group));

    }

    public static Food createFood(int feed_amount, float saturation, boolean isMeat, boolean eatFast, boolean alwaysEdible, @Nullable EffectInstance potion) {
        return null;
        //TODO
    }
    
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity LivingEntity) {
        this.onFoodEaten(stack, worldIn, LivingEntity);
        return super.onItemUseFinish(stack, worldIn, LivingEntity);
    }

    public void onFoodEaten(ItemStack stack, World worldIn, LivingEntity livingEntity){}
}
