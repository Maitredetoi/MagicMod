package com.systemsbysparky.magicmod.magic;

import com.systemsbysparky.magicmod.Reference;
import com.systemsbysparky.magicmod.capability.CapabilityProviderSerializable;
import com.systemsbysparky.magicmod.util.CapabilityUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nullable;

import static com.systemsbysparky.magicmod.util.InjectionUtil.Null;

public class CapabilityMana {

    @CapabilityInject(IMana.class)
    public static final Capability<IMana> MANA_CAPABILITY = Null();

    public static final EnumFacing DEFAULT_FACING = Null();

    public static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "Mana");

    public static void register(){
        CapabilityManager.INSTANCE.register(IMana.class, new Capability.IStorage<IMana>() {
            @Override
            public NBTBase writeNBT(Capability<IMana> capability, IMana instance, EnumFacing side) {
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setInteger("mana", instance.getcurrent());
                nbt.setInteger("maxmana", instance.getmax());
                return nbt;
            }

            @Override
            public void readNBT(Capability<IMana> capability, IMana instance, EnumFacing side, NBTBase nbt) {
                instance.setcurrent(((NBTTagCompound) nbt).getInteger("mana"));
                instance.setmax(((NBTTagCompound) nbt).getInteger("maxmana"));
            }
        }, () -> new Mana());
    }

    @Nullable
    public static IMana getMana(final EntityLivingBase entity){
        return CapabilityUtils.getCapability(entity, MANA_CAPABILITY, DEFAULT_FACING);

    }

    public static ICapabilityProvider createProvider(final IMana mana){
        return new CapabilityProviderSerializable<>(MANA_CAPABILITY, DEFAULT_FACING, mana);
    }

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    private static class EventHandler {
        @SubscribeEvent
        public static void attachCapabilities(final AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof EntityPlayer) {
                final Mana mana = new Mana();
                event.addCapability(ID, createProvider(mana));
            }
        }

        @SubscribeEvent
        public static void playerClone(final PlayerEvent.Clone event) {
            final IMana oldMana = getMana(event.getOriginal());
            final IMana newMana = getMana(event.getEntityPlayer());

            if (newMana != null && oldMana != null) {
                newMana.setmax(oldMana.getmax());
                newMana.setcurrent(oldMana.getcurrent());
            }
        }
        @SubscribeEvent
        public static void onPlayerLogsIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event)
        {
            EntityPlayer player = event.player;
            IMana mana = player.getCapability(MANA_CAPABILITY, null);
            String message = String.format("Hello there, you have §7%d§r mana left.", (int) mana.getcurrent());
            player.sendMessage(new TextComponentString(message));

        }


    }


}
