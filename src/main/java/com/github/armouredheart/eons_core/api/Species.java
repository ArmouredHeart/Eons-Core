// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.api.Habitat;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextMainCatagory;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextModifier;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextSubCatagory;
import com.github.armouredheart.eons_core.api.EonsResourceHelper;
import com.github.armouredheart.eons_core.api.EonsAIBuilder.Behaviour;
import com.github.armouredheart.eons_core.common.entity.EonsCreatureAttribute;

// misc imports

/** @apiNote this enumerator is used as a lookup table for all species related 
 * information in this mod, including the automatic assignment of ai and attributes to mobs 
 * and texture resource lookup. This is going to be a gigantic file... */
public enum Species {
    // *** Paleozoic ***
    // Cambrian
    ANOMALOCARIS(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA, EonsPhylum.ARTHROPODA, EonsClass.DINOCARIDIDA.toString(), "RADIODONTA", "ANOMALOCARIDIDAE"),
        new String[] {EonsClade.NOT_DEFINED.toString()},
        new Geon[] {Geon.CAMBRIAN}, 
        new Habitat[] {Habitat.GENERAL_OCEAN}, 
        new Behaviour[] {Behaviour.PREDATOR, Behaviour.AGGRESSIVE},
        0x445C5B,
        0x4C101A,
        Species.buildAttributes(8.0D, -1.0D, 3.0D, 4.0D),
        CreatureAttribute.ARTHROPOD,
        50,
        new Diet()
    ),
    // Ordovician
    // Silurian
    // Devonian
    TIKTAALIK(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA, EonsPhylum.CHORDATA, "SARCOPTERYGII", "ELPISTOSTEGALIA", "STEGOCEPHALIA"),
        new String[] {EonsClade.TETRAPODOMORPHA.toString()},
        new Geon[] {Geon.DEVONIAN},
        new Habitat[] {Habitat.SWAMP_RIVER},
        new Behaviour[] {Behaviour.PREDATOR},
        0xaa7553,
        0x26150c,
        Species.buildAttributes(8.0D),
        EonsCreatureAttribute.AMPHIBIAN,
        50,
        new Diet()
    ),
    // Carboniferous
    ARTHROPLEURA(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA, EonsPhylum.ARTHROPODA, "", "", ""),
        new String[] {},
        new Geon[] {Geon.CARBONIFEROUS},
        new Habitat[] {},
        new Behaviour[] {},
        0xFFFFFF,
        0xFFFFFF,
        Species.buildAttributes(10.D),
        CreatureAttribute.ARTHROPOD,
        50,
        new Diet()
    ),
    // Permian
    DIMETRODON(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA, EonsPhylum.CHORDATA, "", "", "SPENACODONTIDAE"),
        new String[] {},
        new Geon[] {Geon.PERMIAN},
        new Habitat[] {},
        new Behaviour[] {Behaviour.PREDATOR},
        0x000000, 
        0xFFFFFF,
        Species.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ), AEGIROCASSIS, ARAXOCERAS,  BELANTSEA, HYNERIA, PARADOXIDES, CTENORHABDOTUS, HURDIA, DICKINSONIA, DIRAPHORA_NISUSIA, MARGARETIA, CHARNIA, MAZOTHAIROS, SPATHICEPHALUS;
    // *** Mezozoic ***

    // *** Cenozoic ***
    
    
    // *** Attributes ***
    private static final double SKIP_ATTRIBUTE = -1.0D;
    public static final IAttribute[] SPECIES_ATTRIBUTE_MAP = {
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
    private final String[] TAXANOMY;
    private final Geon[] PERIODS;
    private final String[] CLADES;
    private final Habitat[] HABITATS;
    private final Behaviour[] BEHAVIOURS;
    private final int[] EGG_COLOURS;
    private final double[] ATTRIBUTES;
    private final CreatureAttribute CREATURE_ATTRIBUTE;
    private final int SEX_RATIO;
    private final Diet DIET;

    // *** Constructors ***

    /**
     * for mob species
     * @param taxanomy
     * @param clades
     * @param periods
     * @param habitats
     * @param behaviours
     * @param egg_colours_A
     * @param egg_colours_B
     * @param attributes
     * @param creature_attribute
     * @param sex_ratio
     */
    private Species(final String[] taxanomy, final String[] clades, final Geon[] periods, final Habitat[] habitats, final Behaviour[] behaviours, final int egg_colours_A, final int egg_colours_B, final double[] attributes, final CreatureAttribute creature_attribute, final int sex_ratio, final Diet diet) {
        this.TAXANOMY = taxanomy;
        this.CLADES = clades;
        this.PERIODS = periods;
        this.HABITATS = habitats;
        this.BEHAVIOURS = behaviours;
        this.EGG_COLOURS = new int[]{egg_colours_A, egg_colours_B};
        this.ATTRIBUTES = attributes;
        this.CREATURE_ATTRIBUTE = creature_attribute;
        this.SEX_RATIO = sex_ratio;
        this.DIET = diet;
    }

    /**
     * for non-mob species
     * @param taxanomy
     * @param clades
     * @param periods
     */
    private Species(final String[] taxanomy, final String[] clades, final Geon[] periods) {
        this.TAXANOMY = taxanomy;
        this.CLADES = clades;
        this.PERIODS = periods;

        // all this is mob-only
        this.HABITATS = null;
        this.BEHAVIOURS = null;
        this.EGG_COLOURS = null;
        this.ATTRIBUTES = null;
        this.CREATURE_ATTRIBUTE = null;
        this.SEX_RATIO = IEonsSexuallyDimorphic.UNISEX;
        this.DIET = null;
    }

    // *** Methods ***

    /**
     * @param domain
     * @param kingdom
     * @param phylum
     * @param taxaClass
     * @param order
     * @param family
     */
    private static String[] buildTaxanomy(EonsDomain domain, EonsKingdom kingdom, EonsPhylum phylum, String taxaClass, String order, String family) {
        return new String[] {domain.toString(), kingdom.toString(), phylum.toString(), taxaClass, order, family};
    }

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
    private static double[] buildAttributes(double max_health, double follow_range, double knockback_resistance, double movement_speed, double flying_speed, double attack_damage, double attack_knockback, double attack_speed, double armour, double armour_toughness, double luck) {
        return new double[] {max_health, follow_range, knockback_resistance, movement_speed, flying_speed, attack_damage, attack_knockback, attack_speed, armour, armour_toughness, luck};
    }

    /**
     * negative values will skip modifying the attribute
     * @param max_health
     * @param movement_speed
     * @param attack_damage
     * @param armour
     */
    private static double[] buildAttributes(double max_health, double movement_speed, double attack_damage, double armour) {
        return buildAttributes(max_health, Species.SKIP_ATTRIBUTE, Species.SKIP_ATTRIBUTE, movement_speed, Species.SKIP_ATTRIBUTE, attack_damage, Species.SKIP_ATTRIBUTE, Species.SKIP_ATTRIBUTE, armour, Species.SKIP_ATTRIBUTE, Species.SKIP_ATTRIBUTE);
    }

    /**
     * negative values will skip modifying the attribute
     * @param max_health
     */
    private static double[] buildAttributes(double max_health) {
        return buildAttributes(max_health, Species.SKIP_ATTRIBUTE, Species.SKIP_ATTRIBUTE, Species.SKIP_ATTRIBUTE);
    }
    
    // getters
    public String[] getTaxanomy() {return this.TAXANOMY;}
    public Geon[] getPeriods() {return this.PERIODS;}
    public Habitat[] getHabitats() {return this.HABITATS;}
    public Behaviour[] getBehaviours() {return this.BEHAVIOURS;}
    public int[] getSpawnEggColours() {return this.EGG_COLOURS;}
    public double[] getAttributes() {return this.ATTRIBUTES;}
    public CreatureAttribute getCreatureAttribute() {return this.CREATURE_ATTRIBUTE;}
    public int getSexRatio() {return this.SEX_RATIO;}
    public Diet getDiet() {return this.DIET;}
    public int getStomachSize() {return this.DIET.getStomachSize();}

    public TranslationTextComponent getLocalisedName() {
        return EonsResourceHelper.getLocalisedText(ResourceTextMainCatagory.EDUCATION, ResourceTextSubCatagory.SPECIES, super.toString());
    }

    public TranslationTextComponent getLocalisedBiography() {
        return EonsResourceHelper.getLocalisedText(ResourceTextMainCatagory.EDUCATION, ResourceTextSubCatagory.SPECIES, super.toString(), ResourceTextModifier.BIOGRAPHY);
    }

    // *** Enumerators ***

    // taxonomy enumerators - these are just to help cut down on repeated string typing for common taxa 
    public enum EonsDomain {
        BACTERIA,
        ARCHAEA,
        EUKARYOTA;
    }

    public enum EonsKingdom {
        ANIMALIA,
        PLANTAE,
        FUNGI,
        PROTISTA;
    }

    public enum EonsPhylum {
        ARTHROPODA,
        CHORDATA;
    }

    public enum EonsClass {
        MAMMALIA,
        DINOCARIDIDA;
    }

    public enum EonsClade {
        DINOCARIDIDA,
        DINOSAURIA,
        THEROPODA,
        SAURISCHIA,
        TETRAPODOMORPHA,
        NOT_DEFINED;
    }
}
