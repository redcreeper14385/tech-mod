package mounderfod.industrio.client.gui;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class MachineBlockScreen extends CottonInventoryScreen<MachineBlockGuiDescription> {
    public MachineBlockScreen(MachineBlockGuiDescription gui, PlayerEntity player, Text title) {
        super(gui, player, title);
    }
}
