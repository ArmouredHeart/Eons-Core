// package
package com.github.armouredheart.eons_core.client.model.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsAnimationModel;
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsParadoxidesEntity;

// misc imports
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

/**
 * Paradoxides - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsParadoxidesModel<T extends EonsParadoxidesEntity> extends EntityModel<T> implements IEonsAnimationModel<T> {
    public float[] modelScale = new float[] { 0.3F, 0.3F, 0.3F };
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer turso;
    public ModelRenderer segment1;
    public ModelRenderer segment2;
    public ModelRenderer llegs;
    public ModelRenderer rlegs;
    public ModelRenderer part82;
    public ModelRenderer part84;
    public ModelRenderer head2;
    public ModelRenderer snout;
    public ModelRenderer Leye;
    public ModelRenderer Reye;
    public ModelRenderer Rhadespikes;
    public ModelRenderer antennaR;
    public ModelRenderer Lhadespikes;
    public ModelRenderer antennaL;
    public ModelRenderer shape4;
    public ModelRenderer shape4_1;
    public ModelRenderer antennaR2;
    public ModelRenderer antennaR3;
    public ModelRenderer shape4_2;
    public ModelRenderer shape4_3;
    public ModelRenderer antennaL2;
    public ModelRenderer antennaL3;
    public ModelRenderer end;
    public ModelRenderer segmeant3;
    public ModelRenderer segment4;
    public ModelRenderer llegs2;
    public ModelRenderer rlegs2;
    public ModelRenderer segment5;
    public ModelRenderer segment6;
    public ModelRenderer Ltailstart;
    public ModelRenderer segment7;
    public ModelRenderer Rtailstart;
    public ModelRenderer Rtailantenna;
    public ModelRenderer Ltailantenna;
    public ModelRenderer llegs3;
    public ModelRenderer Llegs3;
    public ModelRenderer Rplat5;
    public ModelRenderer Lplat5;
    public ModelRenderer Rplate6;
    public ModelRenderer Lplate6;
    public ModelRenderer Ltailend;
    public ModelRenderer shape4_4;
    public ModelRenderer shape4_5;
    public ModelRenderer Rtailend;
    public ModelRenderer Rplate3;
    public ModelRenderer Lplate3;
    public ModelRenderer Rplate4;
    public ModelRenderer Lplate4;
    public ModelRenderer Rplate1;
    public ModelRenderer Lplate1;
    public ModelRenderer Rplate2;
    public ModelRenderer Lplate2;

    public EonsParadoxidesModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.turso = new ModelRenderer(this, 41, 0);
        this.turso.setRotationPoint(0.0F, 0.1F, 4.0F);
        this.turso.addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.llegs3 = new ModelRenderer(this, 0, 51);
        this.llegs3.setRotationPoint(-2.0F, 1.4F, 0.0F);
        this.llegs3.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Llegs3 = new ModelRenderer(this, 0, 51);
        this.Llegs3.setRotationPoint(2.0F, 1.4F, 0.0F);
        this.Llegs3.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Rplate6 = new ModelRenderer(this, 54, 4);
        this.Rplate6.setRotationPoint(2.3F, 0.5F, 1.5F);
        this.Rplate6.addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rplate6, 0.0F, -2.185501310652588F, 0.40142572795869574F);
        this.Lplate2 = new ModelRenderer(this, 49, 37);
        this.Lplate2.setRotationPoint(-4.9F, 0.2F, 1.8F);
        this.Lplate2.addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Lplate2, 0.0F, -2.2764328155444717F, -0.4098033003787853F);
        this.Ltailantenna = new ModelRenderer(this, 0, 35);
        this.Ltailantenna.setRotationPoint(0.0F, 0.7F, 6.0F);
        this.Ltailantenna.addBox(0.0F, -0.5F, 0.0F, 0.1F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Ltailantenna, 0.0F, -0.15603242780460005F, 0.0F);
        this.shape4_1 = new ModelRenderer(this, 48, 19);
        this.shape4_1.mirror = true;
        this.shape4_1.setRotationPoint(1.3F, 0.0F, -0.1F);
        this.shape4_1.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape4_1, 0.0F, -0.2275909337942703F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 22.1F, -1.0F);
        this.body.addBox(-2.0F, -1.5F, -4.0F, 4.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Rplate4 = new ModelRenderer(this, 49, 37);
        this.Rplate4.setRotationPoint(4.3F, 0.2F, 1.8F);
        this.Rplate4.addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rplate4, 0.0F, -2.2764328155444717F, 0.4098033003787853F);
        this.shape4_2 = new ModelRenderer(this, 30, 17);
        this.shape4_2.mirror = true;
        this.shape4_2.setRotationPoint(0.2F, -0.2F, 7.7F);
        this.shape4_2.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape4_2, 0.0F, -0.6829473549475088F, 0.0F);
        this.shape4 = new ModelRenderer(this, 30, 17);
        this.shape4.mirror = true;
        this.shape4.setRotationPoint(-0.2F, -0.2F, 7.7F);
        this.shape4.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape4, 0.0F, 0.6829473549475088F, 0.0F);
        this.head = new ModelRenderer(this, 16, 0);
        this.head.setRotationPoint(0.0F, -0.5F, -4.4F);
        this.head.addBox(-6.5F, -1.0F, -2.5F, 13.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Lhadespikes = new ModelRenderer(this, 40, 10);
        this.Lhadespikes.setRotationPoint(1.5F, -0.5F, -1.6F);
        this.Lhadespikes.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Lhadespikes, 0.0F, 0.8196066007575706F, 0.0F);
        this.rlegs = new ModelRenderer(this, 0, 47);
        this.rlegs.setRotationPoint(2.4F, 1.4F, 0.0F);
        this.rlegs.addBox(0.0F, 0.0F, -4.5F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.antennaL3 = new ModelRenderer(this, 0, 27);
        this.antennaL3.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.antennaL3.addBox(0.0F, -0.5F, 0.0F, 0.1F, 1.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antennaL3, 3.141592653589793F, 2.5178118830532203F, 0.0F);
        this.Rplat5 = new ModelRenderer(this, 40, 19);
        this.Rplat5.setRotationPoint(2.6F, 0.3F, 1.6F);
        this.Rplat5.addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rplat5, 0.0F, -2.185501310652588F, 0.40142572795869574F);
        this.llegs = new ModelRenderer(this, 0, 47);
        this.llegs.setRotationPoint(-2.4F, 1.4F, 0.0F);
        this.llegs.addBox(0.0F, 0.0F, -4.5F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Lplate6 = new ModelRenderer(this, 54, 4);
        this.Lplate6.setRotationPoint(-2.3F, 0.5F, 1.5F);
        this.Lplate6.addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Lplate6, 0.0F, -2.185501310652588F, -0.40142572795869574F);
        this.shape4_4 = new ModelRenderer(this, 30, 16);
        this.shape4_4.setRotationPoint(1.9F, 0.7F, 1.5F);
        this.shape4_4.addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape4_4, 0.0F, -2.504198336192953F, 0.40142572795869574F);
        this.antennaL2 = new ModelRenderer(this, 0, 37);
        this.antennaL2.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.antennaL2.addBox(0.0F, -0.5F, 0.0F, 0.1F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antennaL2, 0.0F, -1.1383037594559906F, 0.0F);
        this.Leye = new ModelRenderer(this, 8, 21);
        this.Leye.setRotationPoint(3.1F, 0.2F, -2.1F);
        this.Leye.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Rplate1 = new ModelRenderer(this, 49, 37);
        this.Rplate1.setRotationPoint(5.3F, 0.2F, 1.8F);
        this.Rplate1.addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rplate1, 0.0F, -2.2764328155444717F, 0.4098033003787853F);
        this.part84 = new ModelRenderer(this, 0, 0);
        this.part84.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part84.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.llegs2 = new ModelRenderer(this, 0, 50);
        this.llegs2.setRotationPoint(-2.4F, 1.4F, 0.0F);
        this.llegs2.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Rtailantenna = new ModelRenderer(this, 0, 35);
        this.Rtailantenna.setRotationPoint(0.0F, 0.7F, 6.0F);
        this.Rtailantenna.addBox(0.0F, -0.5F, 0.0F, 0.1F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rtailantenna, 0.0F, 0.15603242780460005F, 0.0F);
        this.Rtailend = new ModelRenderer(this, 30, 19);
        this.Rtailend.mirror = true;
        this.Rtailend.setRotationPoint(-0.4F, 0.0F, 2.5F);
        this.Rtailend.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rtailend, 0.0F, 0.7740534966278743F, 0.0F);
        this.antennaL = new ModelRenderer(this, 0, 37);
        this.antennaL.setRotationPoint(1.5F, 0.0F, -0.9F);
        this.antennaL.addBox(0.0F, -0.5F, 0.0F, 0.1F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antennaL, 0.0F, 2.2689280275926285F, 0.0F);
        this.antennaR2 = new ModelRenderer(this, 0, 37);
        this.antennaR2.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.antennaR2.addBox(0.0F, -0.5F, 0.0F, 0.1F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antennaR2, 0.0F, 1.1383037594559906F, 0.0F);
        this.Rplate3 = new ModelRenderer(this, 49, 37);
        this.Rplate3.setRotationPoint(4.6F, 0.2F, 1.8F);
        this.Rplate3.addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rplate3, 0.0F, -2.2764328155444717F, 0.4098033003787853F);
        this.antennaR = new ModelRenderer(this, 0, 37);
        this.antennaR.setRotationPoint(-1.5F, 0.0F, -0.9F);
        this.antennaR.addBox(0.0F, -0.5F, 0.0F, 0.1F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antennaR, 0.0F, -2.2689280275926285F, 0.0F);
        this.antennaR3 = new ModelRenderer(this, 0, 27);
        this.antennaR3.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.antennaR3.addBox(0.0F, -0.5F, 0.0F, 0.1F, 1.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(antennaR3, 3.141592653589793F, -2.5178118830532203F, 0.0F);
        this.head2 = new ModelRenderer(this, 0, 15);
        this.head2.setRotationPoint(0.0F, -0.4F, -1.4F);
        this.head2.addBox(-3.5F, 0.0F, -3.0F, 7.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.segment5 = new ModelRenderer(this, 31, 32);
        this.segment5.setRotationPoint(0.0F, 0.0F, -0.5F);
        this.segment5.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Lplat5 = new ModelRenderer(this, 40, 19);
        this.Lplat5.setRotationPoint(-2.6F, 0.7F, 1.6F);
        this.Lplat5.addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Lplat5, 0.0F, -2.185501310652588F, -0.40142572795869574F);
        this.rlegs2 = new ModelRenderer(this, 0, 50);
        this.rlegs2.setRotationPoint(2.4F, 1.4F, 0.0F);
        this.rlegs2.addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.segment4 = new ModelRenderer(this, 0, 31);
        this.segment4.setRotationPoint(0.0F, -0.4F, 3.2F);
        this.segment4.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Rplate2 = new ModelRenderer(this, 49, 37);
        this.Rplate2.setRotationPoint(4.9F, 0.2F, 1.8F);
        this.Rplate2.addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rplate2, 0.0F, -2.2764328155444717F, 0.4098033003787853F);
        this.Ltailstart = new ModelRenderer(this, 0, 0);
        this.Ltailstart.mirror = true;
        this.Ltailstart.setRotationPoint(0.0F, 0.7F, 6.1F);
        this.Ltailstart.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Ltailstart, 0.0F, -0.8196066007575706F, 0.0F);
        this.Reye = new ModelRenderer(this, 8, 21);
        this.Reye.setRotationPoint(-3.1F, 0.2F, -2.1F);
        this.Reye.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.shape4_3 = new ModelRenderer(this, 48, 19);
        this.shape4_3.mirror = true;
        this.shape4_3.setRotationPoint(-1.3F, 0.0F, -0.1F);
        this.shape4_3.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape4_3, 0.0F, 0.2275909337942703F, 0.0F);
        this.segmeant3 = new ModelRenderer(this, 34, 26);
        this.segmeant3.setRotationPoint(0.0F, -0.5F, -0.6F);
        this.segmeant3.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.segment6 = new ModelRenderer(this, 46, 33);
        this.segment6.setRotationPoint(0.0F, 0.5F, 1.6F);
        this.segment6.addBox(-2.5F, 0.0F, 0.0F, 5.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Lplate1 = new ModelRenderer(this, 49, 37);
        this.Lplate1.setRotationPoint(-5.3F, 0.2F, 1.8F);
        this.Lplate1.addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Lplate1, 0.0F, -2.2764328155444717F, -0.4098033003787853F);
        this.Lplate3 = new ModelRenderer(this, 49, 37);
        this.Lplate3.setRotationPoint(-4.6F, 0.2F, 1.8F);
        this.Lplate3.addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Lplate3, 0.0F, -2.2764328155444717F, -0.4098033003787853F);
        this.segment1 = new ModelRenderer(this, 20, 10);
        this.segment1.setRotationPoint(0.0F, -0.5F, -4.2F);
        this.segment1.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.part82 = new ModelRenderer(this, 0, 0);
        this.part82.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part82.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Rhadespikes = new ModelRenderer(this, 40, 10);
        this.Rhadespikes.setRotationPoint(-1.5F, -0.5F, -1.6F);
        this.Rhadespikes.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rhadespikes, 0.0F, -0.8196066007575706F, 0.0F);
        this.Ltailend = new ModelRenderer(this, 0, 4);
        this.Ltailend.mirror = true;
        this.Ltailend.setRotationPoint(-0.4F, 0.0F, 2.5F);
        this.Ltailend.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Ltailend, 0.0F, 0.7740534966278743F, 0.0F);
        this.end = new ModelRenderer(this, 18, 25);
        this.end.setRotationPoint(0.0F, 0.1F, 6.5F);
        this.end.addBox(-1.0F, -1.5F, 0.0F, 2.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Rtailstart = new ModelRenderer(this, 54, 0);
        this.Rtailstart.mirror = true;
        this.Rtailstart.setRotationPoint(0.0F, 0.8F, 6.1F);
        this.Rtailstart.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Rtailstart, 3.141592653589793F, -2.321985919674168F, 0.0F);
        this.snout = new ModelRenderer(this, 24, 5);
        this.snout.setRotationPoint(0.0F, 1.4F, -1.9F);
        this.snout.addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.segment2 = new ModelRenderer(this, 0, 46);
        this.segment2.setRotationPoint(0.0F, -0.5F, -0.2F);
        this.segment2.addBox(-4.5F, 0.0F, 0.0F, 9.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.segment7 = new ModelRenderer(this, 16, 5);
        this.segment7.setRotationPoint(0.0F, 0.0F, 4.6F);
        this.segment7.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.shape4_5 = new ModelRenderer(this, 30, 16);
        this.shape4_5.setRotationPoint(-1.9F, 0.7F, 1.5F);
        this.shape4_5.addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape4_5, 0.0F, -2.504198336192953F, -0.40142572795869574F);
        this.Lplate4 = new ModelRenderer(this, 49, 37);
        this.Lplate4.setRotationPoint(-4.3F, 0.2F, 1.8F);
        this.Lplate4.addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Lplate4, 0.0F, -2.2764328155444717F, -0.4098033003787853F);
        this.body.addChild(this.turso);
        this.end.addChild(this.llegs3);
        this.end.addChild(this.Llegs3);
        this.segment6.addChild(this.Rplate6);
        this.segment2.addChild(this.Lplate2);
        this.end.addChild(this.Ltailantenna);
        this.shape4.addChild(this.shape4_1);
        this.segment4.addChild(this.Rplate4);
        this.Lhadespikes.addChild(this.shape4_2);
        this.Rhadespikes.addChild(this.shape4);
        this.body.addChild(this.head);
        this.snout.addChild(this.Lhadespikes);
        this.body.addChild(this.rlegs);
        this.antennaL2.addChild(this.antennaL3);
        this.segment5.addChild(this.Rplat5);
        this.body.addChild(this.llegs);
        this.segment6.addChild(this.Lplate6);
        this.segment7.addChild(this.shape4_4);
        this.antennaL.addChild(this.antennaL2);
        this.head2.addChild(this.Leye);
        this.segment1.addChild(this.Rplate1);
        this.body.addChild(this.part84);
        this.turso.addChild(this.llegs2);
        this.end.addChild(this.Rtailantenna);
        this.Rtailstart.addChild(this.Rtailend);
        this.snout.addChild(this.antennaL);
        this.antennaR.addChild(this.antennaR2);
        this.segmeant3.addChild(this.Rplate3);
        this.snout.addChild(this.antennaR);
        this.antennaR2.addChild(this.antennaR3);
        this.head.addChild(this.head2);
        this.end.addChild(this.segment5);
        this.segment5.addChild(this.Lplat5);
        this.turso.addChild(this.rlegs2);
        this.turso.addChild(this.segment4);
        this.segment2.addChild(this.Rplate2);
        this.end.addChild(this.Ltailstart);
        this.head2.addChild(this.Reye);
        this.shape4_2.addChild(this.shape4_3);
        this.turso.addChild(this.segmeant3);
        this.end.addChild(this.segment6);
        this.segment1.addChild(this.Lplate1);
        this.segmeant3.addChild(this.Lplate3);
        this.body.addChild(this.segment1);
        this.body.addChild(this.part82);
        this.snout.addChild(this.Rhadespikes);
        this.Ltailstart.addChild(this.Ltailend);
        this.turso.addChild(this.end);
        this.end.addChild(this.Rtailstart);
        this.head2.addChild(this.snout);
        this.body.addChild(this.segment2);
        this.end.addChild(this.segment7);
        this.segment7.addChild(this.shape4_5);
        this.segment4.addChild(this.Lplate4);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        matrixStackIn.push();
        matrixStackIn.scale(modelScale[0], modelScale[1], modelScale[2]);
        ImmutableList.of(this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
        matrixStackIn.pop();
    }

    @Override 
    public void animationWalk(T entity, float f, float f1, float f2, float f3, float f4) { 
        this.body.rotateAngleY = MathHelper.cos(f * 0.3331F) * f1;
        this.end.rotateAngleY = MathHelper.cos (f * 0.50F) * -1.0F * f1;
    }

    @Override 
    public void animationBreathing (T entity, float f, float f1, float f2, float f3, float f4) { 
        this.head.rotateAngleX = f4 / (180F / (float) Math.PI); 
        this.head.rotateAngleY = f3 / (90F / (float) Math.PI);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.doAnimations(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

}
