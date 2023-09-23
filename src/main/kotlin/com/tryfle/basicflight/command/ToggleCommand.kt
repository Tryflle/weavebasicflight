package com.tryfle.basicflight.command

import com.tryfle.basicflight.FlyingMod
import net.minecraft.client.Minecraft
import net.weavemc.loader.api.command.Command
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

class ToggleCommand: Command("toggleflight") {
    override fun handle(args: Array<String>) {
        FlyingMod.flightEnabled = !FlyingMod.flightEnabled
        Minecraft.getMinecraft().thePlayer.addChatMessage(ChatComponentText(EnumChatFormatting.GREEN.toString() + "Flight " + (if (FlyingMod.flightEnabled) "enabled!" else "disabled!")))
        Minecraft.getMinecraft().thePlayer.capabilities.allowFlying = FlyingMod.flightEnabled
        Minecraft.getMinecraft().thePlayer.capabilities.isFlying = FlyingMod.flightEnabled
    }
}
