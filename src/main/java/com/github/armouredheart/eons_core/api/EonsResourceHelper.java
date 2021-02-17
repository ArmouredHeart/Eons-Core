// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.util.text.TranslationTextComponent;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;


// misc imports

/**
 * @apiNote This exists purely to help organise resource lookup and enforce file structure 
 * by generating resource keys instead of hardcoding them in different locations.
 */
public interface EonsResourceHelper {

    public static String getGeonFossilItemKey(Geon geon) {
        return getItemKey(geon.toString(), EonsResourcePrefix.NO_PREFIX, EonsSetType.FOSSIL, EonsResourceType.ITEM);
    }

    public static String getFossilItemKey(Species species) {
        return getItemKey(species.toString(), EonsResourcePrefix.NO_PREFIX, EonsSetType.FOSSIL, EonsResourceType.ITEM);
    }

    public static String getItemKey(String identifier, EonsResourcePrefix prefix, EonsSetType set_type, EonsResourceType resource_type) {
        String key = identifier + "_";
        if(prefix != EonsResourcePrefix.NO_PREFIX) {
            key = key + prefix.toString() + "_";
        }
        return (key + set_type.toString() + resource_type.toString()).toLowerCase();
    }

    public static String getFoodItemKey(Species species, EonsResourcePrefix food_state) {
        return getItemKey(species.toString(), food_state, EonsSetType.FOOD, EonsResourceType.ITEM);
    }
 
    public static TranslationTextComponent getLocalisedText(ResourceTextMainCatagory main, ResourceTextSubCatagory sub, String name_definition) {
        return getLocalisedText(main, sub, name_definition, ResourceTextModifier.DEFAULT);
    }

    public static TranslationTextComponent getLocalisedText(ResourceTextMainCatagory main, ResourceTextSubCatagory sub, String name_definition, ResourceTextModifier type) {
        String lookup = main + "." + EonsCore.MOD_ID + "." + sub + "." + name_definition;
        if(type != ResourceTextModifier.DEFAULT) {
            lookup = lookup + "." + type;
        }
        return new TranslationTextComponent(lookup.toLowerCase());
    }

    public enum ResourceTextMainCatagory {
        EDUCATION;
    }

    public enum ResourceTextSubCatagory {
        SPECIES,
        GEON;
    }

    public enum ResourceTextModifier {
        DESC,
        BIOGRAPHY,
        DEFAULT;
    }

    public enum EonsGeonFile {
        // list of geon file names
        PALEOZOIC,
        MESOZOIC,
        CENOZOIC;
    }

    public enum EonsSetType {
        FOOD,
        FOSSIL;
    }

    public enum EonsResourceType {
        ITEM,
        BLOCK;
    }

    public enum EonsResourcePrefix {
        COOKED,
        RAW,
        NO_PREFIX;
    }
}

