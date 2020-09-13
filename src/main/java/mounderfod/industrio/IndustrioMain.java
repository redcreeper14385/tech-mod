package mounderfod.industrio;

import mounderfod.industrio.blocks.MachineBlock;
import mounderfod.industrio.blocks.MachineBlockEntity;
import mounderfod.industrio.client.IndustrioClient;
import mounderfod.industrio.client.gui.MachineBlockGuiDescription;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class IndustrioMain implements ModInitializer{

    public static BlockEntityType<MachineBlockEntity> MACHINE_BLOCK_ENTITY;
    public static final Block MACHINE_BLOCK = new MachineBlock(FabricBlockSettings.of(Material.METAL));
    public static final ScreenHandlerType<MachineBlockGuiDescription> MACHINE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("industrio", "machine_screen_handler"), (syncId, inventory) -> new MachineBlockGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

    @Override
    public void onInitialize() {

        MACHINE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("industrio", "machine_block_entity"), BlockEntityType.Builder.create(MachineBlockEntity::new, MACHINE_BLOCK).build(null));
        Registry.register(Registry.BLOCK, new Identifier("industrio", "machine_block"), MACHINE_BLOCK);
        IndustrioClient.init();
        Registry.register(Registry.ITEM, new Identifier("industrio", "machine_block"), new BlockItem(MACHINE_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));


    }
    
}
