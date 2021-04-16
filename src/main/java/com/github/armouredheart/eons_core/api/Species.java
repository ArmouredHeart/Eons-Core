// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.MobEntity;
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
import javax.annotation.Nonnull;

/** @apiNote this enumerator is used as a lookup table for all species related 
 * information in this mod, including the automatic assignment of ai and attributes to mobs 
 * and texture resource lookup. (This is going to be a gigantic file...) */
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
        EonsMobData.buildAttributes(8.0D, -1.0D, 3.0D, 4.0D),
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
        EonsMobData.buildAttributes(8.0D),
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
        EonsMobData.buildAttributes(10.D),
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
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ), 
    AEGIROCASSIS(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ), 
    ARAXOCERAS(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ),
    BELANTSEA(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ), 
    HYNERIA(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ),
    PARADOXIDES(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ),
    CTENORHABDOTUS(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ),
    HURDIA(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ),
    DICKINSONIA(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ), 
    DIRAPHORA_NISUSIA(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ),
    MARGARETIA(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ),
    CHARNIA(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    ),
    MAZOTHAIROS(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA, EonsPhylum.ARTHROPODA, "", "", ""),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.ARTHROPOD,
        50,
        new Diet()
    ), 
    SPATHICEPHALUS(
        Species.buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA, EonsPhylum.CHORDATA, "", "", ""),
        new String[] {},
        new Geon[] {},
        new Habitat[] {},
        new Behaviour[] {},
        0x000000, 
        0xFFFFFF,
        EonsMobData.buildAttributes(10.0D),
        CreatureAttribute.UNDEFINED,
        50,
        new Diet()
    );
    // *** Mezozoic ***

    // *** Cenozoic ***
    
    // *** Attributes ***
    private final String[] TAXANOMY;
    private final Geon[] PERIODS;
    private final String[] CLADES;
    private final EonsMobData MOB_DATA;

    // *** Constructors ***

    /**
     * for mob species
     * @param taxanomy {@link String} array
     * @param clades {@link String} array
     * @param periods {@link com.github.armouredheart.eons_core.api.Geon} array in format [start, end] or [geon] if species only existed for one geon
     * @param habitats {@link com.github.armouredheart.eons_core.api.Habitat} array
     * @param behaviours {@link com.github.armouredheart.eons_core.api.EonsAIBuilder.Behaviour} array
     * @param egg_colours_A {@link int} hexadecimal colour
     * @param egg_colours_B {@link int} hexadecimal colour
     * @param attributes {@link double} array
     * @param creature_attribute {@link net.minecraft.entity.CreatureAttribute}
     * @param sex_ratio {@link int} between 0 and 100. Set to -1 for monosexual
     */
    private Species(final String[] taxanomy, final String[] clades, final Geon[] periods, final Habitat[] habitats, final Behaviour[] behaviours, final int egg_colours_A, final int egg_colours_B, final double[] attributes, final CreatureAttribute creature_attribute, final int sex_ratio, final Diet diet) {
        this.TAXANOMY = taxanomy;
        this.CLADES = clades;
        this.PERIODS = periods;
        this.MOB_DATA = new EonsMobData(habitats, behaviours, egg_colours_A, egg_colours_B, attributes, creature_attribute, sex_ratio, diet);
    }

    /**
     * for non-mob species
     * @param taxanomy {@link String} array
     * @param clades {@link String} array
     * @param periods {@link com.github.armouredheart.eons_core.api.Geon} array in format [start, end] or [geon] if species only existed for one geon
     */
    private Species(final String[] taxanomy, final String[] clades, final Geon[] periods) {
        this.TAXANOMY = taxanomy;
        this.CLADES = clades;
        this.PERIODS = periods;
        this.MOB_DATA = null;
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
     * This accessor was implemented to prevent null pointers being called if mob data is called for a non-mob species
     * @param <T> extends {@link net.minecraft.entity.MobEntity} & {@link com.github.armouredheart.eons_core.api.IEonsMob}
     * @param mob_entity {@link #T}
     * @return {@link com.github.armouredheart.eons_core.api.EonsMobData} that contains all species specific info for mob entity construction
     */
    public static <T extends MobEntity & IEonsMob> @Nonnull EonsMobData getMobData(T mob_entity) {
        return mob_entity.getSpecies().MOB_DATA;
    }
    
    // getters
    public String[] getTaxanomy() {return this.TAXANOMY;}
    public Geon[] getPeriods() {return this.PERIODS;}
    

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
