package mounderfod.industrio.client;

import mounderfod.industrio.IndustrioMain;
import mounderfod.industrio.client.gui.MachineBlockGuiDescription;
import mounderfod.industrio.client.gui.MachineBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class IndustrioClient implements ClientModInitializer {

    public static void init() {
    }

    @Override
    public void onInitializeClient() {
        ScreenRegistry.<MachineBlockGuiDescription, MachineBlockScreen>register(IndustrioMain.MACHINE_SCREEN_HANDLER, (gui, inventory, title) -> new MachineBlockScreen(gui, inventory.player, title));
    }
}
