package mounderfod.industrio.client.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerContext;
import mounderfod.industrio.IndustrioMain;
import net.minecraft.text.LiteralText;

public class MachineBlockGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 1;


    public MachineBlockGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(IndustrioMain.MACHINE_SCREEN_HANDLER, syncId, playerInventory, getBlockInventory(context, INVENTORY_SIZE), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        root.add(itemSlot, 4, 1);

        WButton button = new WButton(new LiteralText("This is a button."));
        button.setOnClick(() -> {
            System.out.println("hello world!");
                }
        );
        button.setIcon(new ItemIcon(new ItemStack(Items.POTATO)));
        root.add(button, 20, 20, 200, 20);

        root.setSize(300, 200);
        root.add(this.createPlayerInventoryPanel(), 0, 3);
        root.validate(this);


    }

}
