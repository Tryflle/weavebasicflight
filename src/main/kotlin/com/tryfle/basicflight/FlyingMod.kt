package com.tryfle.basicflight

import com.tryfle.basicflight.command.ToggleCommand
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.command.CommandBus

class FlyingMod: ModInitializer {
    override fun preInit() {
        println("[WeaveBasicFlight] Initializing insane bypasses")
        CommandBus.register(ToggleCommand())
    }

    companion object {
        var flightEnabled = false
    }
}