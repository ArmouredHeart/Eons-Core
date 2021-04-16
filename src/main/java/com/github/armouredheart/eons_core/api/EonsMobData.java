// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.EonsAIBuilder.Behaviour;

// misc imports

public class EonsMobData {

    // *** Attributes ***
    //constants
    public static final double SKIP_ATTRIBUTE = -1.0D;
    public static final IAttribute[] ATTRIBUTE_MAP = {
        SharedMonsterAttributes.MAX_HEALTH, 
        SharedMonsterAttributes.FOLLOW_RANGE, 
        SharedMonsterAttributes.KNOCKBACK_RESISTANCE,
        SharedMonsterAttributes.MOVEMENT_SPEED,
        SharedMonsterAttributes.FLYING_SPEED,
        SharedMonsterAttributes.ATTACK_DAMAGE,
        SharedMonsterAttributes.ATTACK_KNOCKBACK,
        SharedMonsterAttributes.ATTACK_SPEED,
        SharedMonsterAttributes.ARMOR,
        SharedMonsterAttributes.ARMOR_TOUGHNESS,
        SharedMonsterAttributes.LUCK
    }; 
    // mob-specific variables
    private final Habitat[] HABITATS;
    private final Behaviour[] BEHAVIOURS;
    private final int[] EGG_COLOURS;
    private final double[] ATTRIBUTES;
    private final CreatureAttribute CREATURE_ATTRIBUTE;
    private final int SEX_RATIO;
    private final Diet DIET;

    public EonsMobData(final Habitat[] habitats, final Behaviour[] behaviours, final int egg_colours_A, final int egg_colours_B, final double[] attributes, final CreatureAttribute creature_attribute, final int sex_ratio, final Diet diet) {
        this.HABITATS = habitats;
        this.BEHAVIOURS = behaviours;
        this.EGG_COLOURS = new int[]{egg_colours_A, egg_colours_B};
        this.ATTRIBUTES = attributes;
        this.CREATURE_ATTRIBUTE = creature_attribute;
        this.SEX_RATIO = sex_ratio;
        this.DIET = diet;
    }

    // *** Methods ***

    // getters
    public Habitat[] getHabitats() {return this.HABITATS;}
    public Behaviour[] getBehaviours() {return this.BEHAVIOURS;}
    public int[] getSpawnEggColours() {return this.EGG_COLOURS;}
    public double[] getAttributes() {return this.ATTRIBUTES;}
    public CreatureAttribute getCreatureAttribute() {return this.CREATURE_ATTRIBUTE;}
    public int getSexRatio() {return this.SEX_RATIO;}
    public Diet getDiet() {return this.DIET;}
    public int getStomachSize() {return this.DIET.getStomachSize();}

    /**
     * negative values will skip modifying the attribute
     * @param max_health
     * @param follow_range
     * @param knockback_resistance
     * @param movement_speed
     * @param flying_speed
     * @param attack_damage
     * @param attack_speed
     * @param armour
     * @param armour_toughness
     * @param luck
     */
    public static double[] buildAttributes(double max_health, double follow_range, double knockback_resistance, double movement_speed, double flying_speed, double attack_damage, double attack_knockback, double attack_speed, double armour, double armour_toughness, double luck) {
        return new double[] {max_health, follow_range, knockback_resistance, movement_speed, flying_speed, attack_damage, attack_knockback, attack_speed, armour, armour_toughness, luck};
    }

    /**
     * negative values will skip modifying the attribute
     * @param max_health
     * @param movement_speed
     * @param attack_damage
     * @param armour
     */
    public static double[] buildAttributes(double max_health, double movement_speed, double attack_damage, double armour) {
        return buildAttributes(max_health, EonsMobData.SKIP_ATTRIBUTE, EonsMobData.SKIP_ATTRIBUTE, movement_speed, EonsMobData.SKIP_ATTRIBUTE, attack_damage, EonsMobData.SKIP_ATTRIBUTE, EonsMobData.SKIP_ATTRIBUTE, armour, EonsMobData.SKIP_ATTRIBUTE, EonsMobData.SKIP_ATTRIBUTE);
    }

    /**
     * negative values will skip modifying the attribute
     * @param max_health
     */
    public static double[] buildAttributes(double max_health) {
        return buildAttributes(max_health, EonsMobData.SKIP_ATTRIBUTE, EonsMobData.SKIP_ATTRIBUTE, EonsMobData.SKIP_ATTRIBUTE);
    }
}
