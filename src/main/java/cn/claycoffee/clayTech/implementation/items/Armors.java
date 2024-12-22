package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class Armors {
    public Armors() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("ANTI_SLOWNESS_ARMOR_RESEARCH"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_ARMORS)
                            .withItem(ClayTechItems.ANTI_SLOWNESS_BOOTS)
                            .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                            .withRecipe(ClayTechMachineRecipes.ANTI_SLOWNESS_BOOTS)
                            .build())
                .build();
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAY_ALLOY_ARMORS_RESEARCH"))
                .withCost(65)
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_ARMORS)
                            .withItem(ClayTechItems.CLAY_ALLOY_HELMET)
                            .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                            .withRecipe(SlimefunUtils.getArmorsStack(1, ClayTechItems.CLAY_ALLOY_INGOT))
                            .build())
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_ARMORS)
                            .withItem(ClayTechItems.CLAY_ALLOY_CHESTPLATE)
                            .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                            .withRecipe(SlimefunUtils.getArmorsStack(2, ClayTechItems.CLAY_ALLOY_INGOT))
                            .build())
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_ARMORS)
                            .withItem(ClayTechItems.CLAY_ALLOY_LEGGINGS)
                            .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                            .withRecipe(SlimefunUtils.getArmorsStack(3, ClayTechItems.CLAY_ALLOY_INGOT))
                            .build())
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_ARMORS)
                            .withItem(ClayTechItems.CLAY_ALLOY_BOOTS)
                            .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                            .withRecipe(SlimefunUtils.getArmorsStack(4, ClayTechItems.CLAY_ALLOY_INGOT))
                            .build())
                .build();

    }
}
