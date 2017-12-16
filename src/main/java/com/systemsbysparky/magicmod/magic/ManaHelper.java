package com.systemsbysparky.magicmod.magic;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ManaHelper {


    public static class ManaStorage implements Capability.IStorage<IMana>{

        @Nullable
        @Override
        public NBTBase writeNBT(Capability<IMana> capability, IMana instance, EnumFacing side) {
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("mana", instance.getcurrent());
            nbt.setInteger("maxmana",instance.getmax());
            return null;
        }

        @Override
        public void readNBT(Capability<IMana> capability, IMana instance, EnumFacing side, NBTBase nbt) {
            instance.setmax(((NBTTagCompound) nbt).getInteger("maxmana"));
            instance.setcurrent(((NBTTagCompound) nbt).getInteger("mana"));


        }
    }

    @CapabilityInject(IMana.class)
    private static final Capability<IMana> MANA_CAP = null;

    public static class ManaProvider implements ICapabilityProvider {

        @Override
        public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
            return MANA_CAP != null && capability == MANA_CAP;

        }

        @Nullable
        @Override
        public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {T
            if (MANA_CAP != null && capability == MANA_CAP) return Capability<T>;
            return null;
        }
    }

}
