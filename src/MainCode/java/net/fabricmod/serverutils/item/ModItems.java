package net.fabricmod.serverutils.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmod.serverutils.ServerUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.registry.Registries.ITEM;
import static net.minecraft.registry.Registry.*;

public class ModItems {

    public static final Item WORLDSELECTOR = registerItem("worldselector",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(ITEM, new Identifier(ServerUtils.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup()
    {
        addToItemGroup(ItemGroups.INGREDIENTS, WORLDSELECTOR);
    }

    private static void addToItemGroup(ItemGroup group, Item item)
    {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

        addItemsToItemGroup();
    }

    public static void registerModItems()
    {
        ServerUtils.LOGGER.debug("Registering Mod Items for " + ServerUtils.MOD_ID);
    }
}
