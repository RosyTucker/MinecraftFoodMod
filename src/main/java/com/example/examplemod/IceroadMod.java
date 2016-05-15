package com.example.examplemod;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = IceroadMod.MOD_ID, version = IceroadMod.VERSION)
public class IceroadMod {
    public static final String MOD_ID = "icemod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        registerFoodItem("burger");
    }


    public void registerFoodItem(String name) {
        final ItemFood foodItem = new ItemFood(3, 0.2f, false);

        foodItem.setUnlocalizedName(name);
        GameRegistry.register(foodItem, new ResourceLocation(IceroadMod.MOD_ID, name));

        ModelResourceLocation modelResourceLocation =
                new ModelResourceLocation(IceroadMod.MOD_ID + ":" + foodItem.delegate.name().getResourcePath(), "inventory");
        ModelLoader.setCustomModelResourceLocation(foodItem, 0, modelResourceLocation);
    }
}
