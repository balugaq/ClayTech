package cn.claycoffee.ClayTech.implementation.machines;

import cn.claycoffee.ClayTech.implementation.abstractMachines.ANewContainer;
import cn.claycoffee.ClayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ElectricStoneCrusher extends ANewContainer {

    public ElectricStoneCrusher(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                                ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_ELECTRIC_STONE_CRUSHER");
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.REDSTONE_TORCH);
    }

    @Override
    public int getEnergyConsumption() {
        return 16;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerRecipe(2, new ItemStack[]{new ItemStack(Material.COBBLESTONE)},
                new ItemStack[]{new ItemStack(Material.GRAVEL)});
    }

    @Override
    public int getCapacity() {
        return 128;
    }

    @Override
    public String getMachineIdentifier() {
        return "CLAY_ELECTRIC_STONE_CRUSHER";
    }
}
