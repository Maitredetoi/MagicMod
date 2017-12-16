package com.systemsbysparky.magicmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.logging.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.Version, dependencies = Reference.DEPENDENCIES)
public class MagicMod {	
	
	
	@Instance(Reference.MOD_ID)
	public static MagicMod instance;

	public static final CreativeTabSMM creativeTab = new CreativeTabSMM();
	
	@SidedProxy(clientSide = "com.systemsbysparky.magicmod.ClientProxy", serverSide = "com.systemsbysparky.magicmod.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LOGGER.info("Sparky's Magic Mod is Now in preInit!");
		proxy.preInit(event);
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		LOGGER.info("Sparky is now Magically Initializing his Mod");
		proxy.init(event);		
	}	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LOGGER.info("Sparkys Magic Mod has Blasted off into PostInit!");
		proxy.postInit(event);
	
	}

	public static final Logger LOGGER = Logger.getLogger(Reference.MOD_ID);

	
}
