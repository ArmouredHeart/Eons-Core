// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;

// Forge imports

// Eons imports

// misc imports
import javax.annotation.Nullable;

public interface IEonsSexuallyDimorphic {
    
    public static final String key = "Sex"; // this key should be used to store sex in NBT data

    // *** Methods ***

    /**
     * TODO backend method, make private when possible
     * @param data_manager
     * @param sex_parameter
     * @return byte value of sex
     */
    public static byte getSexByte(EntityDataManager data_manager, DataParameter<Byte> sex_parameter) {
        return data_manager.get(sex_parameter).byteValue();
    }

    /**
     * TODO backend method, make private when possible
     * @param data_manager
     * @param sex_parameter
     * @param sex_byte byte value of sex
     */
    public static void setSexByte(EntityDataManager data_manager, DataParameter<Byte> sex_parameter, byte sex_byte) {
        data_manager.set(sex_parameter, Byte.valueOf(sex_byte));
    }

    /**
     * @param entity extends LivingEntity & IEonsSexuallyDimorphic
     * @param sexRatio
     */
    public static <E extends LivingEntity & IEonsSexuallyDimorphic> void assignSex(E entity, int sexRatio) {
        if(sexRatio < 0) {
            // sexless, set to unisex
            assignSex(entity, EonsSex.UNISEX);
        } else {
            // randomise sex based on input ratio
            if(sexRatio < entity.world.rand.nextInt(100)) {
                assignSex(entity, EonsSex.MALE);
            } else {
                assignSex(entity, EonsSex.FEMALE);
            }
        }
    }

    /**
     * @param entity extends LivingEntity & IEonsSexuallyDimorphic
     * @param sex
     */
    public static <E extends LivingEntity & IEonsSexuallyDimorphic> void assignSex(E entity, EonsSex sex) {
        setSexByte(entity.getEntityDataManager(), entity.getSexParameter(), sex.getByte());
    }

    /**
     * @return enumerator of sex of entity
     */
    default public EonsSex getSex() {
        return EonsSex.byteToSex(getSexByte(this.getEntityDataManager(), this.getSexParameter()));
    }

    /** Returns true if entity is of opposite sex or if this entity is unisex. */
    default boolean isOppositeSex(IEonsSexuallyDimorphic entity) {
        return this.getSex().isOppositeSex(entity.getSex());
    }

    /**
     * Call this inside @Link{Entity.writeAdditional()} method
     * @param compound
     */
    public static <E extends LivingEntity & IEonsSexuallyDimorphic> void writeSexToNBT(E entity, CompoundNBT compound) {
        compound.putByte(key, getSexByte(entity.getEntityDataManager(), entity.getSexParameter()));
    }

    /**
     * Call this inside @Link{Entity.readAdditional()} method
     * @param compound
     */
    public static <E extends LivingEntity & IEonsSexuallyDimorphic> void readSexFromNBT(E entity, CompoundNBT compound) {
        compound.getByte(key);
    }

    /**
     * Call this inside @Link{Entity.registerData()} method
     */
    public static <E extends LivingEntity & IEonsSexuallyDimorphic> void registerSexData(E entity) {
        entity.getEntityDataManager().register(entity.getSexParameter(), Byte.valueOf((byte) 0));
    }
    
    public EntityDataManager getEntityDataManager();
    public DataParameter<Byte> getSexParameter();

    // *** Inner Classes ***
    
    public enum EonsSex {
        MALE((byte) 1),
        FEMALE((byte) 2),
        UNISEX((byte) 0);

        // *** Attributes ***
        private final byte BYTE;

        // *** Constructors ***

        private EonsSex(final byte sexByte) {this.BYTE = sexByte;}

        // *** Methods ***

        public static EonsSex byteToSex(byte value) {
            switch(value) {
                case (byte) 1: {return MALE;}
                case (byte) 2: {return FEMALE;}
                case (byte) 0: {return UNISEX;}
                default: {return UNISEX;}
            }
        }

        /** 
         * @return byte value of EonsSex
        */
        public byte getByte() {return this.BYTE;}

        /**
         * @param sex
         * @return true if opposites or if both are unisex
         */
        public boolean isOppositeSex(EonsSex sex) {
            boolean flag = this == sex;
            return !flag || (flag && this == UNISEX);
        }
    }

}