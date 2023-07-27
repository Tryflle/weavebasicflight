package com.tryfle.basicflight;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.Command;
import net.weavemc.loader.api.command.CommandBus;
import org.jetbrains.annotations.NotNull;

public class FlyingMod implements ModInitializer {

    private static boolean flightEnabled = false;

    @Override
    public void preInit() {
        System.out.println("[BasicFlightMod] Initializing");

        CommandBus.register(new Command("fly") {
            @Override
            public void handle(@NotNull String[] args) {
                flightEnabled = !flightEnabled;
                Minecraft.getMinecraft().thePlayer.addChatMessage(
                        new ChatComponentText("Flight " + (flightEnabled ? "enabled" : "disabled"))
                );

                handleFlightLogic(flightEnabled);
            }
        });
    }
    public static void handleFlightLogic(boolean enabled) {
        if (enabled) {
            Minecraft.getMinecraft().thePlayer.capabilities.allowFlying = true;
            Minecraft.getMinecraft().thePlayer.capabilities.isFlying = true;
        } else {
            Minecraft.getMinecraft().thePlayer.capabilities.allowFlying = false;
            Minecraft.getMinecraft().thePlayer.capabilities.isFlying = false;
        }
    }
}
