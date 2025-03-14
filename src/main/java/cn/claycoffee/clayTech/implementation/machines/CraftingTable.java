package cn.claycoffee.clayTech.implementation.machines;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.api.slimefun.ACraftingTable;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CraftingTable extends ACraftingTable {
    public CraftingTable(@NotNull ItemGroup itemGroup, @NotNull SlimefunItemStack item, String id, @NotNull RecipeType recipeType,
                         ItemStack @NotNull [] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_FUSION_MACHINE");
    }

    @Override
    public @NotNull ItemStack getProgressBar() {
        return new ItemStack(Material.CRAFTING_TABLE);
    }

    @Override
    public int getEnergyConsumption() {
        return 16;
    }

    @Override
    public int getCapacity() {
        return 128;
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerRecipe(20, ClayTechMachineRecipes.BLIND_CORE, new ItemStack[]{ClayTechItems.BLIND_CORE});
        this.registerRecipe(100, ClayTechMachineRecipes.BLIND_SWORD, new ItemStack[]{ClayTechItems.BLIND_SWORD});
        this.registerRecipe(20, ClayTechMachineRecipes.POISON_EYE, new ItemStack[]{ClayTechItems.POISON_EYE});

        this.registerRecipe(20, ClayTechMachineRecipes.POISON_CORE, new ItemStack[]{ClayTechItems.POISON_CORE});

        this.registerRecipe(40, ClayTechMachineRecipes.ADVANCED_POISON_CORE,
                new ItemStack[]{ClayTechItems.ADVANCED_POISON_CORE});
        this.registerRecipe(20, ClayTechMachineRecipes.CONFUSION_CORE,
                new ItemStack[]{ClayTechItems.CONFUSION_CORE});
        this.registerRecipe(40, ClayTechMachineRecipes.ADVANCED_CONFUSION_CORE,
                new ItemStack[]{ClayTechItems.ADVANCED_CONFUSION_CORE});
        this.registerRecipe(20, ClayTechMachineRecipes.BLACK_ROCK_BLOCK,
                new ItemStack[]{ClayTechItems.BLACK_ROCK_BLOCK});
        this.registerRecipe(20, ClayTechMachineRecipes.SLOWNESS_CORE, new ItemStack[]{ClayTechItems.SLOWNESS_CORE});
        this.registerRecipe(40, ClayTechMachineRecipes.ADVANCED_SLOWNESS_CORE,
                new ItemStack[]{ClayTechItems.ADVANCED_SLOWNESS_CORE});
        this.registerRecipe(40, ClayTechMachineRecipes.ADVANCED_BLIND_CORE,
                new ItemStack[]{ClayTechItems.ADVANCED_BLIND_CORE});
        this.registerRecipe(400, ClayTechMachineRecipes.FOUR_BOW, new ItemStack[]{ClayTechItems.FOUR_BOW});
        this.registerRecipe(100, ClayTechMachineRecipes.POISON_SWORD, new ItemStack[]{ClayTechItems.POISON_SWORD});
        this.registerRecipe(100, ClayTechMachineRecipes.ANTI_SLOWNESS_BOOTS,
                new ItemStack[]{ClayTechItems.ANTI_SLOWNESS_BOOTS});
        this.registerRecipe(80, ClayTechMachineRecipes.BLISTERING_CORE,
                new ItemStack[]{ClayTechItems.BLISTERING_CORE});
        this.registerRecipe(30, ClayTechMachineRecipes.ELEMENT_UNIT, new ItemStack[]{ClayTechItems.ELEMENT_UNIT});
        this.registerRecipe(8, ClayTechMachineRecipes.HIGHSPEED_RAILWAY,
                new ItemStack[]{ClayTechItems.HIGHSPEED_RAILWAY});
        ItemStack elem8 = ClayTechItems.ELECTRIC_MOTOR_8.clone();
        elem8.setAmount(8);
        this.registerRecipe(8, ClayTechMachineRecipes.ELECTRIC_MOTOR_8, new ItemStack[]{elem8});

        this.registerRecipe(180, ClayTechMachineRecipes.REINFORCED_ALLOY_PICKAXE,
                new ItemStack[]{ClayTechItems.REINFORCED_ALLOY_PICKAXE});
        this.registerRecipe(40, ClayTechMachineRecipes.CLAY_FUSION_INGOT,
                new ItemStack[]{ClayTechItems.CLAY_FUSION_INGOT});
        this.registerRecipe(50, ClayTechMachineRecipes.CLAY_ALLOY_INGOT,
                new ItemStack[]{ClayTechItems.CLAY_ALLOY_INGOT});
        this.registerRecipe(300, ClayTechMachineRecipes.CLAY_ALLOY_PICKAXE,
                new ItemStack[]{ClayTechItems.CLAY_ALLOY_PICKAXE});
        this.registerRecipe(300, ClayTechMachineRecipes.CLAY_ALLOY_HELMET,
                new ItemStack[]{ClayTechItems.CLAY_ALLOY_HELMET});
        this.registerRecipe(300, ClayTechMachineRecipes.CLAY_ALLOY_CHESTPLATE,
                new ItemStack[]{ClayTechItems.CLAY_ALLOY_CHESTPLATE});
        this.registerRecipe(300, ClayTechMachineRecipes.CLAY_ALLOY_LEGGINGS,
                new ItemStack[]{ClayTechItems.CLAY_ALLOY_LEGGINGS});
        this.registerRecipe(300, ClayTechMachineRecipes.CLAY_ALLOY_BOOTS,
                new ItemStack[]{ClayTechItems.CLAY_ALLOY_BOOTS});

        this.registerRecipe(30, ClayTechMachineRecipes.MOTOR_CORE, new ItemStack[]{ClayTechItems.MOTOR_CORE});
        this.registerRecipe(60, ClayTechMachineRecipes.TEMPERATURE_RESISTANCE_OBSIDIAN,
                new ItemStack[]{ClayTechItems.TEMPERATURE_RESISTANCE_OBSIDIAN});
        this.registerRecipe(120, ClayTechMachineRecipes.ROCKET_ENGINE_SHELL,
                new ItemStack[]{ClayTechItems.ROCKET_ENGINE_SHELL});
        this.registerRecipe(45, ClayTechMachineRecipes.FUEL_TANK, new ItemStack[]{ClayTechItems.FUEL_TANK});
        this.registerRecipe(180, ClayTechMachineRecipes.ROCKET_ENGINE, new ItemStack[]{ClayTechItems.ROCKET_ENGINE});
        this.registerRecipe(120, ClayTechMachineRecipes.ROCKET_ANTENNA,
                new ItemStack[]{ClayTechItems.ROCKET_ANTENNA});
        this.registerRecipe(300, ClayTechMachineRecipes.ROCKET_CPU, new ItemStack[]{ClayTechItems.ROCKET_CPU});
        this.registerRecipe(400, ClayTechMachineRecipes.ROCKET_CONTROL_CORE,
                new ItemStack[]{ClayTechItems.ROCKET_CONTROL_CORE});
        this.registerRecipe(200, ClayTechMachineRecipes.ROCKET_FUEL_TANK,
                new ItemStack[]{ClayTechItems.ROCKET_FUEL_TANK});
        this.registerRecipe(45, ClayTechMachineRecipes.ROCKET_GLASS, new ItemStack[]{ClayTechItems.ROCKET_GLASS});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_STEEL_PLATE,
                new ItemStack[]{ClayTechItems.ROCKET_STEEL_PLATE});

        this.registerRecipe(50, ClayTechMachineRecipes.OXYGEN_TANK, new ItemStack[]{ClayTechItems.OXYGEN_TANK});
        this.registerRecipe(100, ClayTechMachineRecipes.SPACESUIT_OXYGEN_TANK,
                new ItemStack[]{ClayTechItems.SPACESUIT_OXYGEN_TANK});
        this.registerRecipe(300, ClayTechMachineRecipes.SPACESUIT_HELMET,
                new ItemStack[]{ClayTechItems.SPACESUIT_HELMET});
        this.registerRecipe(300, ClayTechMachineRecipes.SPACESUIT_CHESTPLATE,
                new ItemStack[]{ClayTechItems.SPACESUIT_CHESTPLATE});
        this.registerRecipe(300, ClayTechMachineRecipes.SPACESUIT_LEGGINGS,
                new ItemStack[]{ClayTechItems.SPACESUIT_LEGGINGS});
        this.registerRecipe(300, ClayTechMachineRecipes.SPACESUIT_BOOTS,
                new ItemStack[]{ClayTechItems.SPACESUIT_BOOTS});

        this.registerRecipe(60, ClayTechMachineRecipes.PLANET_BASE_SIGNER,
                new ItemStack[]{ClayTechItems.PLANET_BASE_SIGNER});
        this.registerRecipe(20, ClayTechMachineRecipes.TUBE, new ItemStack[]{ClayTechItems.TUBE});
        this.registerRecipe(60, ClayTechMachineRecipes.OXYGEN_DISTRIBUTER,
                new ItemStack[]{ClayTechItems.OXYGEN_DISTRIBUTER});

        this.registerRecipe(2, ClayTechMachineRecipes.COPPER_DUST_O, new ItemStack[]{SlimefunItems.COPPER_DUST});
        this.registerRecipe(2, ClayTechMachineRecipes.CLAY_FUSION_INGOT_O,
                new ItemStack[]{ClayTechItems.CLAY_FUSION_INGOT});

        this.registerRecipe(30, ClayTechMachineRecipes.INK_MODULE,
                new ItemStack[]{ClayTechItems.INK_MODULE});
        this.registerRecipe(60, ClayTechMachineRecipes.COPYING_MODULE,
                new ItemStack[]{ClayTechItems.COPYING_MODULE});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_2_BLUEPRINT, new ItemStack[]{ClayTechItems.ROCKET_2_BLUEPRINT});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_2_CPU, new ItemStack[]{ClayTechItems.ROCKET_2_CPU});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_2_ENGINE, new ItemStack[]{ClayTechItems.ROCKET_2_ENGINE});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_2_FUEL_TANK, new ItemStack[]{ClayTechItems.ROCKET_2_FUEL_TANK});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_2_GLASS, new ItemStack[]{ClayTechItems.ROCKET_2_GLASS});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_2_STEEL_PLATE, new ItemStack[]{ClayTechItems.ROCKET_2_STEEL_PLATE});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_2_CONTROL_CORE, new ItemStack[]{ClayTechItems.ROCKET_2_CONTROL_CORE});
        this.registerRecipe(60, ClayTechMachineRecipes.ROCKET_2, new ItemStack[]{ClayTechItems.ROCKET_2});
    }
}
