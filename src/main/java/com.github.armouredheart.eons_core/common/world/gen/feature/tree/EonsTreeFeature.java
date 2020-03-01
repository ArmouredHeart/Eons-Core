// package
package com.github.armouredheart.eons_core.common.world.gen.feature.tree;

// Minecraft imports
import net.minecraft.world.gen.AbstractTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

// Forge imports
import net.minecraftforge.common.IPlantable;

// Eons imports

// misc imports
import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public abstract class EonsTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {

    // *** Attributes ***
    private static final BlockState TRUNK;
    private static final BlockState LEAF;
    private static final IPlantable SAPLING;

    protected final int minTreeHeight;
    protected final int maxTreeHeight;
    protected final int trunkThickness;
    private final boolean vinesGrow;
    private final BlockState trunk;
    private final BlockState leaf;

    // *** Constructors ***

    /**
    * @param configFactoryIn 
    * @param doBlockNotifyOnPlace
    * @param minHeightIn
    * @param maxTreeHeightIn
    * @param trunkThicknessIn
    * @param trunkIn
    * @param leafIn
    * @param vinesGrowIn
    */
    public EonsTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, boolean doBlockNotifyOnPlace, int minTreeHeightIn, int maxTreeHeightIn, int trunkThicknessIn, BlockState trunkState, BlockState leafState, boolean vinesGrowIn) {
        super(configFactoryIn, doBlockNotifyOnPlace);
        this.setSapling(SAPLING);
        this.minHeight = minHeightIn;
        this.maxTreeHeight = maxTreeHeightIn;
        this.trunkThickness = trunkThicknessIn;
        this.trunk = trunkIn;
        this.leaf = leafIn;
        this.vinesGrow = vinesGrowIn;
    }

    /** */
    public EonsTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, boolean doBlockNotifyOnPlace) {
        int minHeight = 6;// default tree size
        int trunkThicknessIn
        this.EonsTreeFeature(configFactoryIn, doBlockNotifyOnPlace);
    }

    // *** Methods ***

    @Override
	protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundingBox) {
		int height = this.getHeight(rand);
		boolean flag = true;
		if (position.getY() >= 1 && position.getY() + height + 1 <= worldIn.getMaxHeight()) {
			for(int j = position.getY(); j <= position.getY() + 1 + height; ++j) {
				int k = 1;
				if (j == position.getY()) {
					k = 0;
				}
				if (j >= position.getY() + 1 + height - 2) {
					k = 2;
				}
				BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
				for(int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
					for(int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
						if (j >= 0 && j < worldIn.getMaxHeight()) {
							if (!func_214587_a(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}
			if(!flag) {
				return false;
			} else if (isSoil(worldIn, position.down(), getSapling()) && position.getY() < worldIn.getMaxHeight() - height - 1) {
				this.setDirtAt(worldIn, position.down(), position);
				for(int l2 = position.getY() - 3 + height; l2 <= position.getY() + height; ++l2) {
					int l3 = l2 - (position.getY() + height);
					int j4 = 1 - l3 / 2;
					for(int j1 = position.getX() - j4; j1 <= position.getX() + j4; ++j1) {
						int k1 = j1 - position.getX();
						for(int l1 = position.getZ() - j4; l1 <= position.getZ() + j4; ++l1) {
							int i2 = l1 - position.getZ();
							if (Math.abs(k1) != j4 || Math.abs(i2) != j4 || rand.nextInt(2) != 0 && l3 != 0) {
								BlockPos blockpos = new BlockPos(j1, l2, l1);
								if (isAirOrLeaves(worldIn, blockpos) || func_214576_j(worldIn, blockpos)) {
									this.setLogState(changedBlocks, worldIn, blockpos, LEAF, boundingBox);
								}
							}
						}
					}
				}
				for(int i3 = 0; i3 < height; ++i3) {
					this.setLogState(changedBlocks, worldIn, position.up(i3), LOG, boundingBox);
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

    /** */
    @Override
	protected IPlantable getSapling() {
		return SAPLING;
	}
	
    /** */
    @Override
	protected int getHeight(Random rand) {
		return this.minHeight + rand.nextInt(this.maxHeight + 1);
	}
}