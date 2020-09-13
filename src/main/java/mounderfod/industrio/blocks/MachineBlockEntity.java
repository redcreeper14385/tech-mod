package mounderfod.industrio.blocks;

import mounderfod.industrio.IndustrioMain;
import mounderfod.industrio.client.gui.MachineBlockGuiDescription;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

import java.util.UUID;

public class MachineBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {

    DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public MachineBlockEntity() {
        super(IndustrioMain.MACHINE_BLOCK_ENTITY);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return pos.isWithinDistance(player.getBlockPos(), 4.5);
    }
     
    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, items);
    }
    
    @Override
    public CompoundTag toTag(CompoundTag tag) {
        Inventories.toTag(tag, items);
        return super.toTag(tag);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }


    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        UUID playerUUID = player.getUuid();
        return new MachineBlockGuiDescription(syncId, inv, ScreenHandlerContext.create(world, pos));
    }
}
