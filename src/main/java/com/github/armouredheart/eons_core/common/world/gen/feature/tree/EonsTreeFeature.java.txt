// package
package com.github.armouredheart.eons_core.common.world.gen.feature.tree;

// Minecraft imports
import net.minecraft.world.gen.AbstractTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.block.OAK_LOG;
import net.minecraft.block.OAK_LEAVES;
import net.minecraft.block.OAK_SAPLING;

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
	// default values
	private static final BlockState DEFAULT_TRUNK = Blocks.OAK_LOG.getDefaultState();
   	private static final BlockState DEFAULT_LEAF = Blocks.OAK_LEAVES.getDefaultState();
	private static final int DEFAULT_HEIGHT = 6;
	private static final BlockState DEFAULT_TRUNK_FRUIT = null;
	private static final BlockState DEFAULT_HANGING_FRUIT = null;
	private static final IPlantable DEFAULT_SAPLING = null;

	// tree values
    protected final IPlantable SAPLING;
    protected final int MIN_TREE_HEIGHT;
    protected final int MAX_TREE_HEIGHT;
    protected final int TRUNK_THICKNESS;
    protected final boolean VINES_GROW;
    protected final BlockState TRUNK;
    protected final BlockState LEAF;
	protected final BlockState VINE;
	protected final BlockState TRUNK_FRUIT;
	protected final BlockState HANGING_FRUIT;

    // *** Constructors ***

    /**
    * @param configFactoryIn 
    * @param doBlockNotifyOnPlace
    * @param minHeightIn
    * @param maxTreeHeightIn
    * @param trunkThicknessIn
    * @param vinesGrowIn
    */
    public EonsTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, boolean doBlockNotifyOnPlace, int minTreeHeightIn, int maxTreeHeightIn, BlockState trunkState, BlockState leafState, int trunkThicknessIn, boolean vinesGrowIn) {
        super(configFactoryIn, doBlockNotifyOnPlace);
        this.setSapling(SAPLING);
        this.minHeight = minTreeHeightIn;
        this.MAX_TREE_HEIGHT = maxTreeHeightIn;
		this.LEAF = leafState;
		this.TRUNK = trunkState;
        this.TRUNK_THICKNESS = trunkThicknessIn;
        this.VINES_GROW = vinesGrowIn;
    }

	/**
    * @param configFactoryIn 
    * @param doBlockNotifyOnPlace
    * @param minHeightIn
    * @param maxTreeHeightIn
    * @param trunkThicknessIn
    * @param vinesGrowIn
    */
	public EonsTreeFeature() {
		this.EonsTreeFeature();
	}

    // *** Methods ***

	@Nullable
   	protected abstract AbstractTreeFeature<NoFeatureConfig> getEonsTreeFeature(Random random);

	/**
	* @return boolean true if tree placed successfully, false if failed to place tree.
	 */
	@Override
    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox boundingBox) {
		if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256) {
			//
			int xOffset = 0;
			int yOffset = 0;
			int zOffset = 0;

			
		} else {
			return false;
		}
	}

	/** */
	protected boolean placeTrunk(Set<BlockPos> changedBlocks, MutableBoundingBox boundingBox, IWorld world, BlockPos position) {
		try {	
			// set axis so that the log is vertical
			Direction.Axis axis;
			
			// vertical z
			for(int k = 0; k < this.getHeight(); k++) {

				// horizontal y
				for(int j = 0; j < this.TRUNK_THICKNESS; j++) {

					// horizontal x
					for(int i = 0; i < this.TRUNK_THICKNESS; i++) {
						placeLog(world, position.add(i, j, k), axis, changedBlocks, boundingBox);
					}
				}
			}
		} catch(Exception e) {
			return false;
		}
	}

	/** */
	public boolean placeLog() {

	}

	/**
	* @param IWorld
	* @param pos
	* @param axis
	* @param changedBlocks
	* @param boundingBox
	 */
	public boolean placeLog(IWorld world, BlockPos pos, Direction.Axis axis, Set<BlockPos> changedBlocks, MutableBoundingBox boundingBox) {

	}

	/**
	* @param IWorld
	* @param pos
	* @param changedBlocks
	* @param boundingBox
	 */
	public boolean placeLeaves(IWorld world, BlockPos pos, Set<BlockPos> changedBlocks, MutableBoundingBox boundingBox) {
		return placeLog(world, pos, null, changedBlocks, boundingBox);
	}

	/** */
	public boolean setTrunkFruit() {

	}

	/** */
	@Override
	protected void addVine(IWorldWriter worldIn, BlockPos pos, BooleanProperty prop) {
		this.setBlockState(worldIn, pos, this.VINE);
	}

	/** */
	private void addHangingVine(IWorldGenerationReader worldIn, BlockPos pos, BooleanProperty prop) {
		this.addVine(worldIn, pos, prop);
		int i = 4;

		for(BlockPos blockpos = pos.down(); isAir(worldIn, blockpos) && i > 0; --i) {
			this.addVine(worldIn, blockpos, prop);
			blockpos = blockpos.down();
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
		return this.MIN_TREE_HEIGHT + rand.nextInt(this.MAX_TREE_HEIGHT);
	}

	// *** Internal Classes ***
}