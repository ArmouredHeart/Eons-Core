package my.first.mod.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * charnia - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsCharniaModel<T extends EonsCharniaEntity> extends EntityModel<T> implements IEonsAnimationModel<T> {
 
"variants": {
        "age=0": {
   "public ModelRenderer base_s1;
    public ModelRenderer stem1_s1;
    public ModelRenderer stem2_s1;
    public ModelRenderer part1_s1;
    public ModelRenderer part1_1_s1;
    public ModelRenderer stem4_s1;
    public ModelRenderer part3_s1;
    public ModelRenderer part5_s1;"
	: "texture" },

        "age=1": {
  	"public ModelRenderer base_s2;
   	 public ModelRenderer stem1_s2;
   	 public ModelRenderer stem2_s2;
    	 public ModelRenderer part1_s2;
   	 public ModelRenderer part1_1_s2;
   	 public ModelRenderer stem4_s2;
   	 public ModelRenderer part3_s2;
   	 public ModelRenderer part5_s2;"
	: "texture" },

	"age=2": {
	 "public ModelRenderer base_s3;
  	  public ModelRenderer stem1_s3;
   	  public ModelRenderer stem2_s3;
    	  public ModelRenderer part1_s3;
   	  public ModelRenderer part1_1_s3;
   	  public ModelRenderer stem4_s3;
   	  public ModelRenderer part3_s3;
   	  public ModelRenderer part5_s3;"
	: "texture" },

        "age=3": {
	 "public ModelRenderer base_s4;
    	  public ModelRenderer stem1_s4;
    	  public ModelRenderer stem2_s4;
    	  public ModelRenderer part1_s4;
    	  public ModelRenderer part1_1_S4;
    	  public ModelRenderer stem4_s4;
    	  public ModelRenderer part3_s4;
    	  public ModelRenderer part5_s4;"
	: "texture" },

	"age=4": {
	 "public ModelRenderer base_s5;
    	  public ModelRenderer stem1_s5;
    	  public ModelRenderer stem2_s5;
    	  public ModelRenderer part1_s5;
    	  public ModelRenderer part1_1_s5;
    	  public ModelRenderer stem4_s5;
    	  public ModelRenderer part3_s5;
    	  public ModelRenderer stem5_s5;
    	  public ModelRenderer part4_s5;
    	  public ModelRenderer part5_s5;"
	: "texture" },

	"age=5": {
	 "public ModelRenderer base_s6;
	  public ModelRenderer stem1_s6;
	  public ModelRenderer stem2_s6;
	  public ModelRenderer part1_s6;
	  public ModelRenderer part1_1_s6;
	  public ModelRenderer stem4_s6;
	  public ModelRenderer stem5_s6;
	  public ModelRenderer part3_s6;
	  public ModelRenderer part4_s6;
	  public ModelRenderer stem5_1_s6;
	  public ModelRenderer part4_1_s6;
	  public ModelRenderer part5_s6;"
	: "texture" },

	"age=6": {
	 "public ModelRenderer base_s7;
  	  public ModelRenderer stem1_s7;
  	  public ModelRenderer stem2_s7;
  	  public ModelRenderer part1_s7;
  	  public ModelRenderer stem3_s7;
  	  public ModelRenderer part1_1_s7;
  	  public ModelRenderer stem4_s7;
  	  public ModelRenderer part2_s7;
  	  public ModelRenderer stem5_s7;
 	  public ModelRenderer part3_s7;
 	  public ModelRenderer part4_s7;
  	  public ModelRenderer stem5_1_s7;
  	  public ModelRenderer part4_1_s7;
  	  public ModelRenderer part5_s7;"
	: "texture" }
    }
    

    public EonsCharniaModel() {
	"this.textureWidth = 64;
        this.textureHeight = 32;

	"variants": {
        "age=0": { 

        "this.stem2_s1 = new ModelRenderer(this, 0, 0);
        this.stem2_s1.setRotationPoint(0.0F, -1.6F, 0.0F);
        this.stem2_s1.addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.3F, -0.2F, -0.2F);
        this.stem1_s1 = new ModelRenderer(this, 0, 0);
        this.stem1_s1.setRotationPoint(0.0F, -0.2F, 0.0F);
        this.stem1_s1.addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.3F, -0.2F, -0.1F);
        this.part5_s1 = new ModelRenderer(this, 5, 3);
        this.part5_s1.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.part5_s1.addBox(-1.5F, -3.5F, 0.0F, 3.0F, 5.0F, 0.0F, -1.1F, -1.7F, 0.0F);
        this.base_s1 = new ModelRenderer(this, 16, 1);
        this.base_s1.setRotationPoint(0.0F, 23.6F, 0.0F);
        this.base_s1.addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, -0.4F, -0.1F, -0.4F);
        this.part1_1_s1 = new ModelRenderer(this, 3, 23);
        this.part1_1_s1.setRotationPoint(0.0F, -0.3F, 0.0F);
        this.part1_1_s1.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 5.0F, 0.0F, -2.3F, -1.6F, 0.0F);
        this.part1_s1 = new ModelRenderer(this, 3, 28);
        this.part1_s1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.part1_s1.addBox(-3.0F, -1.3F, 0.0F, 6.0F, 2.0F, 0.0F, -2.0F, -0.5F, 0.0F);
        this.part3_s1 = new ModelRenderer(this, 4, 13);
        this.part3_s1.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.part3_s1.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, -1.3F, -1.6F, 0.0F);
        this.stem4_s1 = new ModelRenderer(this, 0, 0);
        this.stem4_s1.setRotationPoint(0.0F, -1.6F, 0.0F);
        this.stem4_s1.addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.3F, -0.2F, -0.3F);
        this.stem1_s1.addChild(this.stem2_s1);
        this.base_s1.addChild(this.stem1_s1);
        this.part3_s1.addChild(this.part5_s1);
        this.stem2_s1.addChild(this.part1_1_s1);
        this.stem1_s1.addChild(this.part1_s1);
        this.stem4_s1.addChild(this.part3_s1);
        this.stem2_s1.addChild(this.stem4_s1);"}

        "age=1": 
	{ "this.part1_1_s2 = new ModelRenderer(this, 3, 23);
        this.part1_1_s2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part1_1_s2.addBox(-3.0F, -4.0F, 0.0F, 6.0F, 5.0F, 0.0F, -1.6F, -1.2F, 0.0F);
        this.part3_s2 = new ModelRenderer(this, 4, 13);
        this.part3_s2.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.part3_s2.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, -0.9F, -1.2F, 0.0F);
        this.part1_s2 = new ModelRenderer(this, 3, 28);
        this.part1_s2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.part1_s2.addBox(-3.0F, -1.3F, 0.0F, 6.0F, 2.0F, 0.0F, -1.1F, -0.5F, 0.0F);
        this.stem1_s2 = new ModelRenderer(this, 0, 0);
        this.stem1_s2.setRotationPoint(0.0F, 1.2F, 0.0F);
        this.stem1_s2.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, -0.2F, -0.2F, -0.1F);
        this.stem2_s2 = new ModelRenderer(this, 0, 0);
        this.stem2_s2.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.stem2_s2.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, -0.2F, -0.2F, -0.2F);
        this.part5_s2 = new ModelRenderer(this, 5, 3);
        this.part5_s2.setRotationPoint(0.0F, -3.9F, 0.0F);
        this.part5_s2.addBox(-1.5F, -4.0F, 0.0F, 3.0F, 5.0F, 0.0F, -0.6F, -0.9F, 0.0F);
        this.stem4_s2 = new ModelRenderer(this, 0, 0);
        this.stem4_s2.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.stem4_s2.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, -0.2F, -0.2F, -0.3F);
        this.base_s2 = new ModelRenderer(this, 16, 1);
        this.base_s2.setRotationPoint(0.0F, 22.2F, 0.0F);
        this.base_s2.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, -0.4F, -0.4F, -0.4F);
        this.stem2_s2.addChild(this.part1_1_s2);
        this.stem4_s2.addChild(this.part3_s2);
        this.stem1_s2.addChild(this.part1_s2);
        this.base_s2.addChild(this.stem1_s2);
        this.stem1_s2.addChild(this.stem2_s2);
        this.part3_s2.addChild(this.part5_s2);
        this.stem2_s2.addChild(this.stem4_s2);"},

        "age=2": 
	{ "this.part1_1_s3 = new ModelRenderer(this, 3, 23);
        this.part1_1_s3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part1_1_s3.addBox(-3.0F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, -1.6F, -0.2F, 0.0F);
        this.stem2_s3 = new ModelRenderer(this, 0, 0);
        this.stem2_s3.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.stem2_s3.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, -0.2F, -0.2F, -0.2F);
        this.stem1_s3 = new ModelRenderer(this, 0, 0);
        this.stem1_s3.setRotationPoint(0.0F, 1.2F, 0.0F);
        this.stem1_s3.addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, -0.2F, -0.2F, -0.1F);
        this.stem4_s3 = new ModelRenderer(this, 0, 0);
        this.stem4_s3.setRotationPoint(0.0F, -4.6F, 0.0F);
        this.stem4_s3.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, -0.2F, -0.2F, -0.3F);
        this.part1_s3 = new ModelRenderer(this, 3, 28);
        this.part1_s3.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.part1_s3.addBox(-3.0F, -1.3F, 0.0F, 6.0F, 2.0F, 0.0F, -1.1F, -0.5F, 0.0F);
        this.part3_s3 = new ModelRenderer(this, 4, 13);
        this.part3_s3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part3_s3.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, -0.9F, -0.2F, 0.0F);
        this.base_s3 = new ModelRenderer(this, 15, 0);
        this.base_s3.setRotationPoint(0.0F, 22.2F, 0.0F);
        this.base_s3.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, -0.4F, -0.4F, -0.4F);
        this.part5_s3 = new ModelRenderer(this, 5, 3);
        this.part5_s3.setRotationPoint(0.0F, -4.6F, 0.0F);
        this.part5_s3.addBox(-1.5F, -4.0F, 0.0F, 3.0F, 5.0F, 0.0F, -0.6F, -0.9F, 0.0F);
        this.stem2_s3.addChild(this.part1_1_s3);
        this.stem1_s3.addChild(this.stem2_s3);
        this.base_s3.addChild(this.stem1_s3);
        this.stem2_s3.addChild(this.stem4_s3);
        this.stem1_s3.addChild(this.part1_s3);
        this.stem4_s3.addChild(this.part3_s3);
        this.part3_s3.addChild(this.part5_s3);"},

        "age=3": 
	{ "this.base_s4 = new ModelRenderer(this, 15, 0);
        this.base_s4.setRotationPoint(0.0F, 22.2F, 0.0F);
        this.base_s4.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, -0.2F, -0.2F, -0.2F);
        this.stem1_s4 = new ModelRenderer(this, 0, 0);
        this.stem1_s4.setRotationPoint(0.0F, 1.2F, 0.0F);
        this.stem1_s4.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.part5_s4 = new ModelRenderer(this, 5, 3);
        this.part5_s4.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.part5_s4.addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.part3_s4 = new ModelRenderer(this, 4, 13);
        this.part3_s4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part3_s4.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, -0.1F, 0.0F, 0.0F);
        this.part1_1_s4 = new ModelRenderer(this, 3, 23);
        this.part1_1_s4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part1_1_s4.addBox(-3.0F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, -0.6F, 0.0F, 0.0F);
        this.stem2_s4 = new ModelRenderer(this, 0, 0);
        this.stem2_s4.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem2_s4.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.2F);
        this.stem4_s4 = new ModelRenderer(this, 0, 0);
        this.stem4_s4.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem4_s4.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.3F);
        this.part1_s4 = new ModelRenderer(this, 3, 28);
        this.part1_s4.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.part1_s4.addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.base_s4.addChild(this.stem1_s4);
        this.part3_s4.addChild(this.part5_s4);
        this.stem4_s4.addChild(this.part3_s4);
        this.stem2_s4.addChild(this.part1_1_s4);
        this.stem1_s4.addChild(this.stem2_s4);
        this.stem2_s4.addChild(this.stem4_s4);
        this.stem1_s4.addChild(this.part1_s4);"},

        "age=4": 
	{ "this.part1_1_s5 = new ModelRenderer(this, 3, 23);
        this.part1_1_s5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part1_1_s5.addBox(-3.0F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, -0.6F, 0.0F, 0.0F);
        this.stem5_s5 = new ModelRenderer(this, 0, 0);
        this.stem5_s5.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem5_s5.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.3F);
        this.part3_s5 = new ModelRenderer(this, 4, 13);
        this.part3_s5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part3_s5.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, -0.1F, 0.0F, 0.0F);
        this.part5_s5 = new ModelRenderer(this, 5, 3);
        this.part5_s5.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.part5_s5.addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.base_s5 = new ModelRenderer(this, 15, 0);
        this.base_s5.setRotationPoint(0.0F, 22.2F, 0.0F);
        this.base_s5.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, -0.2F, -0.2F, -0.2F);
        this.stem1_s5 = new ModelRenderer(this, 0, 0);
        this.stem1_s5.setRotationPoint(0.0F, 1.2F, 0.0F);
        this.stem1_s5.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.part1_s5 = new ModelRenderer(this, 3, 28);
        this.part1_s5.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.part1_s5.addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.part4_s5 = new ModelRenderer(this, 4, 8);
        this.part4_s5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part4_s5.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, -0.4F, 0.0F, 0.0F);
        this.stem2_s5 = new ModelRenderer(this, 0, 0);
        this.stem2_s5.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem2_s5.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.1F);
        this.stem4_s5 = new ModelRenderer(this, 0, 0);
        this.stem4_s5.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem4_s5.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.2F);
        this.stem2_s5.addChild(this.part1_1_s5);
        this.stem4_s5.addChild(this.stem5_s5);
        this.stem4_s5.addChild(this.part3_s5);
        this.stem5_s5.addChild(this.part5_s5);
        this.base_s5.addChild(this.stem1_s5);
        this.stem1_s5.addChild(this.part1_s5);
        this.stem5_s5.addChild(this.part4_s5);
        this.stem1_s5.addChild(this.stem2_s5);
        this.stem2_s5.addChild(this.stem4_s5);"},

        "age=5": 
	{ "this.part4_1_s6 = new ModelRenderer(this, 4, 8);
        this.part4_1_s6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part4_1_s6.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.stem2_s6 = new ModelRenderer(this, 0, 0);
        this.stem2_s6.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem2_s6.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.1F);
        this.stem5_s6 = new ModelRenderer(this, 0, 0);
        this.stem5_s6.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem5_s6.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.2F);
        this.part3_s6 = new ModelRenderer(this, 4, 13);
        this.part3_s6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part3_s6.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.4F, 0.0F, 0.0F);
        this.stem4_s6 = new ModelRenderer(this, 0, 0);
        this.stem4_s6.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem4_s6.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.1F);
        this.part5_s6 = new ModelRenderer(this, 5, 3);
        this.part5_s6.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.part5_s6.addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.part1_1_s6 = new ModelRenderer(this, 3, 23);
        this.part1_1_s6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part1_1_s6.addBox(-3.0F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.stem5_1_s6 = new ModelRenderer(this, 0, 0);
        this.stem5_1_s6.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem5_1_s6.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.3F);
        this.stem1_s6 = new ModelRenderer(this, 0, 0);
        this.stem1_s6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.stem1_s6.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.part4_s6 = new ModelRenderer(this, 4, 8);
        this.part4_s6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part4_s6.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.base_s6 = new ModelRenderer(this, 15, 0);
        this.base_s6.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.base_s6.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.part1_s6 = new ModelRenderer(this, 3, 28);
        this.part1_s6.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.part1_s6.addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.stem5_1_s6.addChild(this.part4_1_s6);
        this.stem1_s6.addChild(this.stem2_s6);
        this.stem4_s6.addChild(this.stem5_s6);
        this.stem4_s6.addChild(this.part3_s6);
        this.stem2_s6.addChild(this.stem4_s6);
        this.stem5_1_s6.addChild(this.part5_s6);
        this.stem2_s6.addChild(this.part1_1_s6);
        this.stem5_s6.addChild(this.stem5_1_s6);
        this.base_s6.addChild(this.stem1_s6);
        this.stem5._s6addChild(this.part4_s6);
        this.stem1._s6addChild(this.part1_s6);"},

        "age=6": 
	{ "this.stem2_s7 = new ModelRenderer(this, 0, 0);
        this.stem2_s7.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem2_s7.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.1F);
        this.stem3_s7 = new ModelRenderer(this, 0, 0);
        this.stem3_s7.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem3_s7.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.1F);
        this.part3_s7 = new ModelRenderer(this, 4, 13);
        this.part3_s7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part3_s7.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.5F, 0.0F, 0.0F);
        this.part1_1_s7 = new ModelRenderer(this, 3, 23);
        this.part1_1_s7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part1_1_s7.addBox(-3.0F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.part5_s7 = new ModelRenderer(this, 5, 3);
        this.part5_s7.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.part5_s7.addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.part4_1_s7 = new ModelRenderer(this, 4, 8);
        this.part4_1_s7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part4_1_s7.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, -0.3F, 0.0F, 0.0F);
        this.part2_s7 = new ModelRenderer(this, 3, 18);
        this.part2_s7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part2_s7.addBox(-3.0F, -5.0F, 0.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.stem4_s7 = new ModelRenderer(this, 0, 0);
        this.stem4_s7.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem4_s7.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.2F);
        this.part4_s7 = new ModelRenderer(this, 4, 8);
        this.part4_s7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part4_s7.addBox(-2.0F, -5.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.stem5_s7 = new ModelRenderer(this, 0, 0);
        this.stem5_s7.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem5_s7.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.2F);
        this.base_s7 = new ModelRenderer(this, 15, 0);
        this.base_s7.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.base_s7.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.stem5_1_s7 = new ModelRenderer(this, 0, 0);
        this.stem5_1_s7.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.stem5_1_s7.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, -0.3F);
        this.stem1_s7 = new ModelRenderer(this, 0, 0);
        this.stem1_s7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.stem1_s7.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.part1_s7 = new ModelRenderer(this, 3, 28);
        this.part1_s7.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.part1_s7.addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.stem1_s7.addChild(this.stem2_s7);
        this.stem2_s7.addChild(this.stem3_s7);
        this.stem4_s7.addChild(this.part3_s7);
        this.stem2_s7.addChild(this.part1_1_s7);
        this.stem5_1_s7.addChild(this.part5_s7);
        this.stem5_1_s7.addChild(this.part4_1_s7);
        this.stem3_s7.addChild(this.part2_s7);
        this.stem3_s7.addChild(this.stem4_s7);
        this.stem5_s7.addChild(this.part4_s7);
        this.stem4_s7.addChild(this.stem5_s7);
        this.stem5_s7.addChild(this.stem5_1_s7);
        this.base_s7.addChild(this.stem1_s7);
        this.stem1_s7.addChild(this.part1_s7);"}
        
    }

    @Override
    "variants": {
        "age=0": { 
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.base_s1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha); },
        "age=1": {public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.base_s2).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha); },  },
        "age=2": { public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.base_s3).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha); }, },
        "age=3": { public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.base_s4).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha); }, },
        "age=4": { public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.base_s5).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha); }, },
        "age=5": {public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.base_s6).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha); }, },
        "age=6": { public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.base_s7).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha); }, }
        });
    }

    @Override
    protected void animationBreathing //always// (Entity entity, float f, float f1, float f2, float f3, float f4, float f5))
{ 
"variants": {
"age=0": { 
this.stem1_s1.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem4_s1.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
 },
 "age=1": { 
this.stem1_s2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem4_s2.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
 },
"age=2": {
this.stem1_s3.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem4_s3.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.part5_s3.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
 },
"age=3": { 
this.stem1_s4.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem4_s4.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.part5_s4.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
 },
"age=4": {
this.stem1_s5.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem4_s5.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.stem5_s5.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.part5_s5.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
 },
"age=5": { 
this.stem1_s6.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem2_s6.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.stem4_s6.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.stem5_s6.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem5_1_s6.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.part5_s6.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
 },
"age=6": {
this.stem1_s7.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem2_s7.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.stem3_s7.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.stem4_s7.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem5_s7.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
this.stem5_1_s7.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
this.part5_s6.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
 }
 };
    }
}
