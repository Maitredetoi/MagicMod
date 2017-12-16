package com.systemsbysparky.magicmod.init;

import com.systemsbysparky.magicmod.Reference;
import com.systemsbysparky.magicmod.item.itemRuby;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;


@ObjectHolder(Reference.MOD_ID)
public class ModItems {



    //Static Final instance of item , Reference has = null();
    public static final itemRuby ITEM_RUBY = new itemRuby();


    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistrationHandler {
        public static final Set<Item> ITEMS = new HashSet<>();

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event){
            final Item[] items = {
                    ITEM_RUBY,
            };
            final IForgeRegistry<Item> registry = event.getRegistry();
            for (final Item item : items){
                registry.register(item);
                ITEMS.add(item);
            }
        }
    }
}

