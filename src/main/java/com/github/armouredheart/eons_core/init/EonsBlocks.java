// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.RotatedPillarBlock;
// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.Block;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import net.minecraft.block.LogBlock;
import com.github.armouredheart.eons_core.common.block.*;

// misc imports
import java.util.function.Supplier;

/** */
public final class EonsBlocks {

    // *** Attributes ***
    
    //
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, EonsCore.MOD_ID);

    // *** Register Blocks ***
    // Core
    public static final RegistryObject<Block> CYCAS_LOG = registerBlock("cycas_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_CYCAS_LOG = registerBlock("stripped_cycas_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CYCAS_WOOD = registerBlock("cycas_wood", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CYCAS_PLANKS = registerBlock("cycas_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CYCAS_LEAVES = registerBlock("cycas_leaves", () -> new EonsFruitingLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));

    // Paleozoic
    public static final RegistryObject<Block> DIRAPHORA_NISUIA = registerBlock("diraphora_nisusia", () -> new EonsSeaAnimalBlock(Block.Properties.create(Material.SEA_GRASS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.WET_GRASS), null));
    public static final RegistryObject<Block> MARGARETIA = registerBlock("margaretia", () -> new EonsSeaAnimalBlock(Block.Properties.create(Material.SEA_GRASS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.WET_GRASS), null));
    public static final RegistryObject<Block> CHARNIA = registerBlock("charnia", () -> new EonsGrowingSeaAnimalBlock(Block.Properties.create(Material.SEA_GRASS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.WET_GRASS), null, false, null, null));
    public static final RegistryObject<Block> CAMBRIAN_FOSSIL_BLOCK = registerBlock("cambrian_fossil_block", () -> new EonsFossilBlock(Block.Properties.create(Material.ROCK)));
    
    // *** Methods ***

    /**
     * @param block_supplier Supplier<Block>
     * @param block_name String unlocalised name all lowercase 
     */
    public static RegistryObject<Block> registerBlock(String block_name, Supplier<Block> block_supplier){
        return BLOCKS.register(block_name, block_supplier);
    }
}