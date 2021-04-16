// package
package com.github.armouredheart.eons_core.api;


// Minecraft imports
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import javax.annotation.Nonnull;
/**
 * @apiNote This exists purely to help organise resource lookup and enforce file structure 
 * by generating resource keys instead of hardcoding them in different locations.
 */
public class EonsResourceHelper {

    /**
     * @param <E> extends {@link net.minecraft.entity.MobEntity} & {@link com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic}
     * @param entity
     * @param geon_file {@link com.github.armouredheart.eons_core.api.Geon}
     * @return non null resource location of mob texture to use
     */
    public static <E extends MobEntity & IEonsSexuallyDimorphic> @Nonnull ResourceLocation getEonsMobTexture(E entity, EonsGeonFile geon_file) {
        String name = entity.getEntityString().toLowerCase();
        return new ResourceLocation(EonsCore.MOD_ID, "textures/entity/" + geon_file.toString() + "/" + name + "/" + name + "_" + entity.getSex().toString().toLowerCase() + ".png");
    }

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
        FOSSIL,
        DNA;
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

