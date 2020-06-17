// package
package com.github.armouredheart.eons_core.api;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsBeastPartEntity;

// misc imports
import javax.annotation.Nullable;

public interface IEonsMultiPart {
    // *** ATTRIBUTES ***
    
    // *** METHODS ***

    /** @return returns null if part does not exist */
    default EonsBeastPartEntity getPart(String partName) {
        for(int i = 0; i < this.getPartCount(); i++){
            if(this.getPart(i).getPartName() == partName){
                return this.getPart(i);
            }
        }
        return null;
    }

    /** @return returns null if part does not exist */
    default @Nullable EonsBeastPartEntity getPart(int index) {
        if(index > -1 && index < this.getPartCount()){
            // the index exists
            return this.getPartsList()[index];
        } else {
            // the index does not exist
            return null;
        }
    }

    public EonsBeastPartEntity[] getPartsList();

    public int getPartCount();

    public void setShellBroken();

    public void setShellRestored();

    public boolean isShellBroken();

    /** */
    default void restoreShell() {
        for(int i = 0; i < this.getPartCount(); i++){
            this.getPart(i).restoreShell();
        }
        this.setShellRestored();
    }
}