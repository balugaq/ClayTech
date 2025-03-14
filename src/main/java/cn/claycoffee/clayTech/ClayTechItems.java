package cn.claycoffee.clayTech;

import cn.claycoffee.clayTech.utils.ItemStackUtil;
import cn.claycoffee.clayTech.utils.KeyUtil;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SkullUtil;
import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.LockedItemGroup;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class ClayTechItems {
    public static final SlimefunItemStack CLAYCOFFEE_HEAD = getSlimefunItemStack(SkullUtil.getByHash("58c55ba01ccc7e79b5495e5c4e00080ff6c92a832b2905fed724f2f68a3bb94c"), Lang.readItemText("CLAYCOFFEE_HEAD"), Lang.readItemLore("CLAYCOFFEE_HEAD"), "CLAYCOFFEE_HEAD");
    public static final SlimefunItemStack STALIN_HEAD = getSlimefunItemStack(SkullUtil.getByURL("http://textures.minecraft.net/texture/96fb8390f61a2cc51c08201834369829d9ba301effc01b6a7cb10d830c6c5043"), Lang.readItemText("STALIN_HEAD"), Lang.readItemLore("STALIN_HEAD"), "STALIN_HEAD");
    public static final SlimefunItemStack MARX_HEAD = getSlimefunItemStack(SkullUtil.getByURL("http://textures.minecraft.net/texture/69aee2502a4a7db127d891b2449ed5b7e0563bd0f5f443e032cfd3919ffed6ff"), Lang.readItemText("MARX_HEAD"), Lang.readItemLore("MARX_HEAD"), "MARX_HEAD");
    public static final SlimefunItemStack[] NORECIPE = {null, null, null, null, null, null, null, null, null};
    // 注册
    public static final SlimefunItemStack MAGIC_CLAY = getSlimefunItemStack(Material.CLAY_BALL, Lang.readItemText("MAGIC_CLAY"), Lang.readItemLore("MAGIC_CLAY"), "MAGIC_CLAY");
    public static final SlimefunItemStack CLAY_STICK = getSlimefunItemStack(Material.STICK, Lang.readItemText("CLAY_STICK"), Lang.readItemLore("CLAY_STICK"), "CLAY_STICK");
    public static final SlimefunItemStack ARTIFICIAL_GOLD_NUGGET = getSlimefunItemStack(Material.GOLD_NUGGET,
            Lang.readItemText("ARTIFICIAL_GOLD_NUGGET"), "ARTIFICIAL_GOLD_NUGGET");
    public static final SlimefunItemStack ARTIFICIAL_GOLD_INGOT_O = getSlimefunItemStack(Material.COAL,
            Lang.readItemText("ARTIFICIAL_GOLD_INGOT_O"), "ARTIFICIAL_GOLD_INGOT_O");
    public static final SlimefunItemStack ARTIFICIAL_GOLD_INGOT = getSlimefunItemStack(Material.GOLD_INGOT,
            Lang.readItemText("ARTIFICIAL_GOLD_INGOT"), "ARTIFICIAL_GOLD_INGOT");
    public static final SlimefunItemStack ARTIFICIAL_GOLD_BLOCK = getSlimefunItemStack(Material.GOLD_BLOCK,
            Lang.readItemText("ARTIFICIAL_GOLD_BLOCK"), "ARTIFICIAL_GOLD_BLOCK");
    public static final SlimefunItemStack ARTIFICIAL_ENCHANTED_GOLDEN_APPLE = getSlimefunItemStack(Material.ENCHANTED_GOLDEN_APPLE,
            Lang.readItemText("ARTIFICIAL_ENCHANTED_GOLDEN_APPLE"), "ARTIFICIAL_ENCHANTED_GOLDEN_APPLE");
    public static final SlimefunItemStack BLIND_CORE = getSlimefunItemStack(Material.COAL, Lang.readItemText("BLIND_CORE"), "BLIND_CORE");
    public static final SlimefunItemStack BLIND_SWORD = getSlimefunItemStack(Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_16) ? Material.NETHERITE_SWORD : Material.DIAMOND_SWORD, Lang.readItemText("BLIND_SWORD"), Lang.readItemLore("BLIND_SWORD"), "BLIND_SWORD");
    public static final SlimefunItemStack CONFUSION_CORE = getSlimefunItemStack(Material.INK_SAC,
            Lang.readItemText("CONFUSION_CORE"), "CONFUSION_CORE");
    public static final SlimefunItemStack BLACK_ROCK_BLOCK = getSlimefunItemStack(Material.OBSIDIAN,
            Lang.readItemText("BLACK_ROCK_BLOCK"), "BLACK_ROCK_BLOCK");
    public static final SlimefunItemStack SLOWNESS_CORE = getSlimefunItemStack(Material.OBSIDIAN, Lang.readItemText("SLOWNESS_CORE"), "SLOWNESS_CORE");
    public static final SlimefunItemStack POISON_EYE = getSlimefunItemStack(Material.SPIDER_EYE, Lang.readItemText("POISON_EYE"), "POISON_EYE");
    public static final SlimefunItemStack POISON_CORE = getSlimefunItemStack(Material.SPIDER_EYE, Lang.readItemText("POISON_CORE"), "POISON_CORE");
    public static final SlimefunItemStack ADVANCED_BLIND_CORE = getSlimefunItemStack(Material.COAL,
            Lang.readItemText("ADVANCED_BLIND_CORE"), "ADVANCED_BLIND_CORE");
    public static final SlimefunItemStack ADVANCED_CONFUSION_CORE = getSlimefunItemStack(Material.INK_SAC,
            Lang.readItemText("ADVANCED_CONFUSION_CORE"), "ADVANCED_CONFUSION_CORE");
    public static final SlimefunItemStack ADVANCED_SLOWNESS_CORE = getSlimefunItemStack(Material.OBSIDIAN,
            Lang.readItemText("ADVANCED_SLOWNESS_CORE"), "ADVANCED_SLOWNESS_CORE");
    public static final SlimefunItemStack ADVANCED_POISON_CORE = getSlimefunItemStack(Material.SPIDER_EYE,
            Lang.readItemText("ADVANCED_POISON_CORE"), "ADVANCED_POISON_CORE");
    public static final SlimefunItemStack FOUR_BOW = getSlimefunItemStack(Material.BOW, Lang.readItemText("FOUR_BOW"),
            Lang.readItemLore("FOUR_BOW"), "FOUR_BOW");
    public static final SlimefunItemStack POISON_SWORD =
            getSlimefunItemStack(Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_16) ? Material.NETHERITE_SWORD : Material.DIAMOND_SWORD, Lang.readItemText("POISON_SWORD"),
                    Lang.readItemLore("POISON_SWORD"), "POISON_SWORD");
    public static final SlimefunItemStack ANTI_SLOWNESS_BOOTS =
            getSlimefunItemStack(Material.IRON_BOOTS, Lang.readItemText("ANTI_SLOWNESS_BOOTS"),
                    Lang.readItemLore("ANTI_SLOWNESS_BOOTS"), "ANTI_SLOWNESS_BOOTS");
    public static final SlimefunItemStack COCOA_BEAN =
            getSlimefunItemStack(Material.COCOA_BEANS, Lang.readItemText("COCOA_BEAN"), Lang.readItemLore("COCOA_BEAN"), "COCOA_BEAN");
    public static final SlimefunItemStack PLASTIC = getSlimefunItemStack(
            Material.WHITE_DYE,
            Lang.readItemText("PLASTIC"), Lang.readItemLore("PLASTIC"), "PLASTIC");
    public static final SlimefunItemStack RAW_CHICKEN_FOOT =
            getSlimefunItemStack(Material.RABBIT_FOOT, Lang.readItemText("RAW_CHICKEN_FOOT"),
                    Lang.readItemLore("RAW_CHICKEN_FOOT"), "RAW_CHICKEN_FOOT");
    public static final SlimefunItemStack CHICKEN_FOOT =
            getSlimefunItemStack(Material.RABBIT_FOOT, Lang.readItemText("FRIED_CHICKEN_FOOT"),
                    Lang.readItemLore("FRIED_CHICKEN_FOOT"), "FRIED_CHICKEN_FOOT");
    public static final SlimefunItemStack RAW_BREAD = getSlimefunItemStack(Material.BREAD, Lang.readItemText("RAW_BREAD"), Lang.readItemLore("RAW_BREAD"), "RAW_BREAD");
    public static final SlimefunItemStack DIRTY_TEA = getSlimefunItemStack(Material.KELP, Lang.readItemText("DIRTY_TEA"), Lang.readItemLore("DIRTY_TEA"), "DIRTY_TEA");
    public static final SlimefunItemStack RAW_TEA = getSlimefunItemStack(Material.KELP, Lang.readItemText("TEA"),
            Lang.readItemLore("TEA"), "TEA");
    public static final SlimefunItemStack TEA_POWDER = getSlimefunItemStack(
            Material.BROWN_DYE,
            Lang.readItemText("TEA_POWDER"), Lang.readItemLore("TEA_POWDER"), "TEA_POWDER");
    public static final SlimefunItemStack LEMON_POWDER =
            getSlimefunItemStack(Material.YELLOW_DYE, Lang.readItemText("LEMON_POWDER"),
                    Lang.readItemLore("LEMON_POWDER"), "LEMON_POWDER");
    public static final SlimefunItemStack FLOUR = getSlimefunItemStack(Material.SUGAR, Lang.readItemText("FLOUR"), Lang.readItemLore("FLOUR"), "FLOUR");
    public static final SlimefunItemStack STARCH = getSlimefunItemStack(Material.SUGAR, Lang.readItemText("STARCH"), Lang.readItemLore("STARCH"), "STARCH");
    public static final SlimefunItemStack SNAIL_HEALTHY =
            getSlimefunItemStack(Material.NAUTILUS_SHELL, Lang.readItemText("SNAIL_HEALTHY"),
                    Lang.readItemLore("SNAIL_HEALTHY"), "SNAIL_HEALTHY");
    public static final SlimefunItemStack SNAIL_BAD =
            getSlimefunItemStack(Material.NAUTILUS_SHELL, Lang.readItemText("SNAIL_BAD"), Lang.readItemLore("SNAIL_BAD"), "SNAIL_BAD");
    public static final SlimefunItemStack HIGHSPEED_RAILWAY =
            getSlimefunItemStack(Material.POWERED_RAIL, Lang.readItemText("HIGHSPEED_RAILWAY"),
                    Lang.readItemLore("HIGHSPEED_RAILWAY"), "HIGHSPEED_RAILWAY");
    public static final SlimefunItemStack ELECTRIC_MOTOR_8 = getSlimefunItemStack(Material.FEATHER,
            Lang.readItemText("ELECTRIC_MOTOR_8"), "ELECTRIC_MOTOR_8");
    public static final SlimefunItemStack ELEMENT_UNIT =
            getSlimefunItemStack(Material.FLOWER_POT, Lang.readItemText("ELEMENT_UNIT"), Lang.readItemLore("ELEMENT_UNIT"), "ELEMENT_UNIT");
    public static final SlimefunItemStack ELEMENT_OXYGEN =
            getSlimefunItemStack(Material.FLOWER_POT, Lang.readItemText("ELEMENT_OXYGEN"),
                    Lang.readItemLore("ELEMENT_OXYGEN"), "ELEMENT_OXYGEN");
    public static final SlimefunItemStack ELEMENT_CARBON =
            getSlimefunItemStack(Material.FLOWER_POT, Lang.readItemText("ELEMENT_CARBON"),
                    Lang.readItemLore("ELEMENT_CARBON"), "ELEMENT_CARBON");
    public static final SlimefunItemStack ELEMENT_SILICON =
            getSlimefunItemStack(Material.FLOWER_POT, Lang.readItemText("ELEMENT_SILICON"),
                    Lang.readItemLore("ELEMENT_SILICON"), "ELEMENT_SILICON");
    public static final SlimefunItemStack BLISTERING_CORE = getSlimefunItemStack(Material.GOLD_INGOT,
            Lang.readItemText("BLISTERING_CORE"), "BLISTERING_CORE");
    public static final SlimefunItemStack CLAY_SWEET_POTATO =
            getSlimefunItemStack(Material.BEETROOT, Lang.readItemText("SWEET_POTATO"), Lang.readItemLore("SWEET_POTATO"), "SWEET_POTATO");
    public static final SlimefunItemStack COOKED_SWEET_POTATO =
            getSlimefunItemStack(Material.BEETROOT, Lang.readItemText("COOKED_SWEET_POTATO"),
                    Lang.readItemLore("COOKED_SWEET_POTATO"), "COOKED_SWEET_POTATO");


    public static final SlimefunItemStack CLAY_FUSION_INGOT = getSlimefunItemStack(Material.IRON_INGOT,
            Lang.readItemText("CLAY_FUSION_INGOT"), "CLAY_FUSION_INGOT");
    public static final SlimefunItemStack CLAY_ALLOY_INGOT = getSlimefunItemStack(Material.IRON_INGOT,
            Lang.readItemText("CLAY_ALLOY_INGOT"), "CLAY_ALLOY_INGOT");

    public static final SlimefunItemStack SILICON_INGOT = getSlimefunItemStack(Material.IRON_INGOT,
            Lang.readItemText("SILICON_INGOT"), "SILICON_INGOT");
    public static final SlimefunItemStack ROCKET_LAUNCHER = getSlimefunItemStack(Material.IRON_BLOCK,
            Lang.readItemText("ROCKET_LAUNCHER"), "ROCKET_LAUNCHER");
    public static final SlimefunItemStack MOTOR_CORE = getSlimefunItemStack(Material.NETHER_STAR, Lang.readItemText("MOTOR_CORE"), "MOTOR_CORE");
    public static final SlimefunItemStack TEMPERATURE_RESISTANCE_OBSIDIAN =
            getSlimefunItemStack(Material.OBSIDIAN, Lang.readItemText("TEMPERATURE_RESISTANCE_OBSIDIAN"), Lang.readItemLore("TEMPERATURE_RESISTANCE_OBSIDIAN"), "TEMPERATURE_RESISTANCE_OBSIDIAN");
    public static final SlimefunItemStack ROCKET_ENGINE_SHELL = getSlimefunItemStack(Material.IRON_INGOT,
            Lang.readItemText("ROCKET_ENGINE_SHELL"), "ROCKET_ENGINE_SHELL");
    public static final SlimefunItemStack ROCKET_ANTENNA =
            getSlimefunItemStack(Material.REDSTONE_TORCH, Lang.readItemText("ROCKET_ANTENNA"), Lang.readItemLore("ROCKET_ANTENNA"), "ROCKET_ANTENNA");
    public static final SlimefunItemStack ROCKET_CPU = getSlimefunItemStack(Material.NETHER_STAR, Lang.readItemText("ROCKET_CPU"), Lang.readItemLore("ROCKET_CPU"), "ROCKET_CPU");
    public static final SlimefunItemStack ROCKET_CONTROL_CORE =
            getSlimefunItemStack(Material.FIREWORK_STAR, Lang.readItemText("ROCKET_CONTROL_CORE"), Lang.readItemLore("ROCKET_CONTROL_CORE"), "ROCKET_CONTROL_CORE");
    public static final SlimefunItemStack ROCKET_GLASS =
            getSlimefunItemStack(Material.LIME_STAINED_GLASS_PANE, Lang.readItemText("ROCKET_GLASS"), Lang.readItemLore("ROCKET_GLASS"), "ROCKET_GLASS");
    public static final SlimefunItemStack ROCKET_STEEL_PLATE =
            getSlimefunItemStack(Material.PAPER, Lang.readItemText("ROCKET_STEEL_PLATE"), Lang.readItemLore("ROCKET_STEEL_PLATE"), "ROCKET_STEEL_PLATE");
    public static final SlimefunItemStack ROCKET_2_ENGINE_SHELL = getSlimefunItemStack(Material.IRON_INGOT,
            Lang.readItemText("ROCKET_2_ENGINE_SHELL"), "ROCKET_2_ENGINE_SHELL");
    public static final SlimefunItemStack ROCKET_2_CPU =
            getSlimefunItemStack(Material.NETHER_STAR, Lang.readItemText("ROCKET_2_CPU"), Lang.readItemLore("ROCKET_2_CPU"), "ROCKET_2_CPU");
    public static final SlimefunItemStack ROCKET_2_CONTROL_CORE =
            getSlimefunItemStack(Material.FIREWORK_STAR, Lang.readItemText("ROCKET_2_CONTROL_CORE"), Lang.readItemLore("ROCKET_2_CONTROL_CORE"), "ROCKET_2_CONTROL_CORE");
    public static final SlimefunItemStack ROCKET_2_GLASS =
            getSlimefunItemStack(Material.LIME_STAINED_GLASS_PANE, Lang.readItemText("ROCKET_2_GLASS"), Lang.readItemLore("ROCKET_2_GLASS"), "ROCKET_2_GLASS");
    public static final SlimefunItemStack ROCKET_2_STEEL_PLATE =
            getSlimefunItemStack(Material.PAPER, Lang.readItemText("ROCKET_2_STEEL_PLATE"), Lang.readItemLore("ROCKET_2_STEEL_PLATE"), "ROCKET_2_STEEL_PLATE");
    public static final SlimefunItemStack SPACESUIT_HELMET =
            getSlimefunItemStack(Material.DIAMOND_HELMET, Lang.readItemText("SPACESUIT_HELMET"), Lang.readItemLore("SPACESUIT_HELMET"), "SPACESUIT_HELMET");
    public static final SlimefunItemStack SPACESUIT_CHESTPLATE =
            getSlimefunItemStack(Material.DIAMOND_CHESTPLATE, Lang.readItemText("SPACESUIT_CHESTPLATE"), Lang.readItemLore("SPACESUIT_CHESTPLATE"), "SPACESUIT_CHESTPLATE");
    public static final SlimefunItemStack SPACESUIT_LEGGINGS =
            getSlimefunItemStack(Material.DIAMOND_LEGGINGS, Lang.readItemText("SPACESUIT_LEGGINGS"), Lang.readItemLore("SPACESUIT_LEGGINGS"), "SPACESUIT_LEGGINGS"
            );
    public static final SlimefunItemStack SPACESUIT_BOOTS =
            getSlimefunItemStack(Material.DIAMOND_BOOTS, Lang.readItemText("SPACESUIT_BOOTS"), Lang.readItemLore("SPACESUIT_BOOTS"), "SPACESUIT_BOOTS");
    public static final SlimefunItemStack KREEP_ROCK = getSlimefunItemStack(Material.GRANITE, Lang.readItemText("KREEP_ROCK"), Lang.readItemLore("KREEP_ROCK"), "KREEP_ROCK");
    public static final SlimefunItemStack KREEP_INGOT = getSlimefunItemStack(Material.IRON_INGOT, Lang.readItemText("KREEP_INGOT"), Lang.readItemLore("KREEP_INGOT"), "KREEP_INGOT");
    public static final SlimefunItemStack PLANET_BASE_SIGNER =
            getSlimefunItemStack(Material.OBSIDIAN, Lang.readItemText("PLANET_BASE_SIGNER"),
                    Lang.readItemLore("PLANET_BASE_SIGNER"), "PLANET_BASE_SIGNER");
    public static final SlimefunItemStack TUBE = getSlimefunItemStack(Material.BONE, Lang.readItemText("TUBE"), "TUBE");
    public static final SlimefunItemStack OXYGEN_DISTRIBUTER =
            getSlimefunItemStack(Material.FIREWORK_STAR, Lang.readItemText("OXYGEN_DISTRIBUTER"), Lang.readItemLore("OXYGEN_DISTRIBUTER"), "OXYGEN_DISTRIBUTER");
    public static final SlimefunItemStack COPPER_ORE = getSlimefunItemStack(Material.GOLD_BLOCK, Lang.readItemText("COPPER_ORE"), Lang.readItemLore("COPPER_ORE"), "COPPER_ORE");
    public static final SlimefunItemStack CLAY_FUSION_ORE = getSlimefunItemStack(Material.IRON_BLOCK, Lang.readItemText("CLAY_FUSION_ORE"), Lang.readItemLore("CLAY_FUSION_ORE"), "CLAY_FUSION_ORE");
    public static final SlimefunItemStack TUNA_FISH = getSlimefunItemStack(Material.TROPICAL_FISH, Lang.readItemText("TUNA_FISH"), Lang.readItemLore("TUNA_FISH"), "TUNA_FISH");
    public static final SlimefunItemStack GREEN_GRASS = getSlimefunItemStack(Material.GRASS, Lang.readItemText("GREEN_GRASS"), Lang.readItemLore("GREEN_GRASS"), "GREEN_GRASS");
    public static final SlimefunItemStack INK_MODULE = getSlimefunItemStack(Material.INK_SAC, Lang.readItemText("INK_MODULE"), Lang.readItemLore("INK_MODULE"), "INK_MODULE");
    public static final SlimefunItemStack COPYING_MODULE = getSlimefunItemStack(Material.DIAMOND, Lang.readItemText("COPYING_MODULE"), Lang.readItemLore("COPYING_MODULE"), "COPYING_MODULE");
    public static final SlimefunItemStack CLAY_AIR_LOCK_PLATE = getSlimefunItemStack(Material.STONE_PRESSURE_PLATE, Lang.readItemText("CLAY_AIR_LOCK_PLATE"), Lang.readItemLore("CLAY_AIR_LOCK_PLATE"), "CLAY_AIR_LOCK_PLATE");
    public static final SlimefunItemStack CLAY_AIR_LOCK_BLOCK = getSlimefunItemStack(Material.getMaterial(ClayTech.getInstance().getConfig().getString("clay-air-lock-block-texture")), Lang.readItemText("CLAY_AIR_LOCK_BLOCK"), Lang.readItemLore("CLAY_AIR_LOCK_BLOCK"), "CLAY_AIR_LOCK_BLOCK");
    public static final SlimefunItemStack CLAY_ELECTRIC_WATER_PUMP = getSlimefunItemStack(Material.DISPENSER, Lang.readItemText("CLAY_ELECTRIC_WATER_PUMP"), Lang.readItemLore("CLAY_ELECTRIC_WATER_PUMP"), MachineTier.BASIC, MachineType.MACHINE, 256, "CLAY_ELECTRIC_WATER_PUMP");

    // 头颅
    public static final ItemStack CLAY_FUEL = getSlimefunItemStack(
            SkullUtil.getByHash("3ce2dad9baf7eaba7e80d4d0f9fac0aab01a76b12fb71c3d2af2a16fdd4c7383"),
            Lang.readItemText("CLAY_FUEL"), "CLAY_FUEL");
    public static final ItemStack MIXED_ROCKET_FUEL =
            getSlimefunItemStack(SkullUtil.getByHash("3ce2dad9baf7eaba7e80d4d0f9fac0aab01a76b12fb71c3d2af2a16fdd4c7383"),
                    Lang.readItemText("MIXED_ROCKET_FUEL"), Lang.readItemLore("MIXED_ROCKET_FUEL"), "MIXED_ROCKET_FUEL");

    public static final ItemStack CLOCK_C = getSlimefunItemStack(SkullUtil.getByURL(
                    "http://textures.minecraft.net/texture/ba10da526e5111cfb6e3ebd47693e162dd52d41a2182028daa7c2b19aa3143"),
            Lang.readItemText("BLACK_CLOCK"), Lang.readItemLore("BLACK_CLOCK"), "BLACK_CLOCK");
    public static final ItemStack LANTERN_C = getSlimefunItemStack(SkullUtil.getByURL(
                    "http://textures.minecraft.net/texture/7cc217a9b9e3ce3cd0484c7e8ce49d1cf741281bdda5a4d6cb821f378752718"),
            Lang.readItemText("LANTERN"), Lang.readItemLore("LANTERN"), "LANTERN");
    public static final ItemStack CLAY_COFFEE = getSlimefunItemStack(SkullUtil.getByURL(
            "http://textures.minecraft.net/texture/411511bdd55bcb82803c8039f1c155fd43062636e23d4d46c4d761c04d22c2"), Lang.readItemText("CLAY_COFFEE"), Lang.readItemLore("CLAY_COFFEE"), "CLAY_COFFEE");
    public static final ItemStack DRINK_BOTTLE = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/9179ce4849723434e84747ec85fbbfb1121456c8aeb2e9171fb8328921d45"),
            Lang.readItemText("DRINK_BOTTLE"), Lang.readItemLore("DRINK_BOTTLE"), "DRINK_BOTTLE");
    public static final ItemStack DIRTY_DRINK_BOTTLE = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/9179ce4849723434e84747ec85fbbfb1121456c8aeb2e9171fb8328921d45"),
            Lang.readItemText("DIRTY_DRINK_BOTTLE"), Lang.readItemLore("DIRTY_DRINK_BOTTLE"), "DIRTY_DRINK_BOTTLE");
    public static final ItemStack SPICY_CHICKEN_BURGER = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/c5e27988a6538010efc0e24756bc3e3eea24d7536b20932c17e0404e5cc55f"),
            Lang.readItemText("SPICY_CHICKEN_BURGER"), Lang.readItemLore("SPICY_CHICKEN_BURGER"), "SPICY_CHICKEN_BURGER");
    public static final ItemStack BABA_BURGER = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/c5e27988a6538010efc0e24756bc3e3eea24d7536b20932c17e0404e5cc55f"),
            Lang.readItemText("BABA_BURGER"), Lang.readItemLore("BABA_BURGER"), "BABA_BURGER");
    public static final ItemStack RAW_VEGETABLE = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/477dd842c975d8fb03b1add66db8377a18ba987052161f22591e6a4ede7f5"),
            Lang.readItemText("LETTUSE"), Lang.readItemLore("LETTUSE"), "LETTUSE");
    public static final ItemStack CLAY_LEMON = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/957fd56ca15978779324df519354b6639a8d9bc1192c7c3de925a329baef6c"),
            Lang.readItemText("LEMON"), Lang.readItemLore("LEMON"), "LEMON");
    public static final ItemStack LEMON_POWDER_DRINK = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/d8e94ddd769a5bea748376b4ec7383fd36d267894d7c3bee011e8e4f5fcd7"),
            Lang.readItemText("LEMON_POWDER_DRINK"), Lang.readItemLore("LEMON_POWDER_DRINK"), "LEMON_POWDER_DRINK");
    public static final ItemStack TEA_DRINK = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/d8e94ddd769a5bea748376b4ec7383fd36d267894d7c3bee011e8e4f5fcd7"),
            Lang.readItemText("TEA_DRINK"), Lang.readItemLore("TEA_DRINK"), "TEA_DRINK");
    public static final ItemStack LEMON_TEA_DRINK = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/d8e94ddd769a5bea748376b4ec7383fd36d267894d7c3bee011e8e4f5fcd7"),
            Lang.readItemText("LEMON_TEA_DRINK"), Lang.readItemLore("LEMON_TEA_DRINK"), "LEMON_TEA_DRINK");
    public static final ItemStack CHOCOLATE = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/819f948d17718adace5dd6e050c586229653fef645d7113ab94d17b639cc466"),
            Lang.readItemText("CHOCOLATE"), Lang.readItemLore("CHOCOLATE"), "CHOCOLATE");
    public static final ItemStack SNAIL_FOOD = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/26834b5b25426de63538ec82ca8fbecfcbb3e682d8063643d2e67a7621bd"),
            Lang.readItemText("LUOSI_RICE_NOODLE"), Lang.readItemLore("LUOSI_RICE_NOODLE"), "LUOSI_RICE_NOODLE");
    public static final ItemStack ROCKET = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/377bf2855806da82d902314ce3e706cd3d1c1f83ed986df19e179b17a0595"),
            Lang.readItemText("ROCKET"), Lang.readItemLore("ROCKET"), "ROCKET");
    public static final ItemStack FUEL_TANK = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/5175bdf47aea1a4bf1d349be6b7fa4ab37f479672f4c43aca57511b427ab4"),
            Lang.readItemText("FUEL_TANK"), Lang.readItemLore("FUEL_TANK"), "FUEL_TANK");
    public static final ItemStack ROCKET_ENGINE = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/5175bdf47aea1a4bf1d349be6b7fa4ab37f479672f4c43aca57511b427ab4"),
            Lang.readItemText("ROCKET_ENGINE"), Lang.readItemLore("ROCKET_ENGINE"), "ROCKET_ENGINE");
    public static final ItemStack ROCKET_FUEL_TANK = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/5175bdf47aea1a4bf1d349be6b7fa4ab37f479672f4c43aca57511b427ab4"),
            Lang.readItemText("ROCKET_FUEL_TANK"), Lang.readItemLore("ROCKET_FUEL_TANK"), "ROCKET_FUEL_TANK");
    public static final ItemStack ROCKET_2 = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/377bf2855806da82d902314ce3e706cd3d1c1f83ed986df19e179b17a0595"),
            Lang.readItemText("ROCKET_2"), Lang.readItemLore("ROCKET_2"), "ROCKET_2");
    public static final ItemStack ROCKET_2_ENGINE = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/5175bdf47aea1a4bf1d349be6b7fa4ab37f479672f4c43aca57511b427ab4"),
            Lang.readItemText("ROCKET_2_ENGINE"), Lang.readItemLore("ROCKET_2_ENGINE"), "ROCKET_2_ENGINE");
    public static final ItemStack ROCKET_2_FUEL_TANK = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/5175bdf47aea1a4bf1d349be6b7fa4ab37f479672f4c43aca57511b427ab4"),
            Lang.readItemText("ROCKET_2_FUEL_TANK"), Lang.readItemLore("ROCKET_2_FUEL_TANK"), "ROCKET_2_FUEL_TANK");
    public static final ItemStack OXYGEN_TANK = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/52baeb4a35da8a85d14bdccf7184f5545088f954da55144f235c2983fdb8e05b"),
            Lang.readItemText("OXYGEN_TANK"), Lang.readItemLore("OXYGEN_TANK"), "OXYGEN_TANK");
    public static final ItemStack SPACESUIT_OXYGEN_TANK = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/52baeb4a35da8a85d14bdccf7184f5545088f954da55144f235c2983fdb8e05b"),
            Lang.readItemText("SPACESUIT_OXYGEN_TANK"), Lang.readItemLore("SPACESUIT_OXYGEN_TANK"), "SPACESUIT_OXYGEN_TANK");

    // 机器
    public static final ItemStack CLAY_CRAFTING_TABLE = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/6d6c65b44c34b1acc2ccb346752397125f0d9ffa0ab3c50a99d1db3b74c63"),
            Lang.readItemText("CLAY_FUSION_MACHINE"), Lang.readItemLore("CLAY_FUSION_MACHINE"), MachineTier.BASIC, MachineType.MACHINE, 128, "CLAY_FUSION_MACHINE");
    public static final ItemStack CLAY_ELECTRIC_STONE_CRUSHER = getSlimefunItemStack(Material.RED_STAINED_GLASS, Lang.readItemText("CLAY_ELECTRIC_STONE_CRUSHER"), Lang.readItemLore("CLAY_ELECTRIC_STONE_CRUSHER"), MachineTier.BASIC, MachineType.MACHINE, 128, "CLAY_ELECTRIC_STONE_CRUSHER");
    public static final ItemStack CLAY_FOOD_CAULDRON = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/dfd9b2f42d5f1c2a77b511fe41a4c6b5c192fb10b2ceadde05bd1af52a151"),
            Lang.readItemText("CLAY_ELETRIC_CAULDRON"), Lang.readItemLore("CLAY_ELETRIC_CAULDRON"), MachineTier.AVERAGE, MachineType.MACHINE, 512, "CLAY_ELETRIC_CAULDRON");

    public static final ItemStack CLAY_FOOD_CHALKING_MACHINE = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/98636123b1a3755abd8aef6d85b2a85bf10f486edefdd1a3cef7679d825"),
            Lang.readItemText("CLAY_FOOD_CHALKING_MACHINE"), Lang.readItemLore("CLAY_FOOD_CHALKING_MACHINE"), MachineTier.AVERAGE, MachineType.MACHINE, 512, "CLAY_FOOD_CHALKING_MACHINE");

    public static final ItemStack CLAY_ELEMENT_EXTRACTER = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/c74170c66bf3140f234b322add724c5df6949a9209f807ebf86d4f9c8c1e178"),
            Lang.readItemText("CLAY_ELEMENT_EXTRACTER"), Lang.readItemLore("CLAY_ELEMENT_EXTRACTER"), MachineTier.ADVANCED, MachineType.MACHINE, 1024, "CLAY_ELEMENT_EXTRACTER");
    public static final ItemStack CLAY_EXPERIMENT_TABLE_NORMAL = getSlimefunItemStack(SkullUtil.getByURL(
                    "https://textures.minecraft.net/texture/52baeb4a35da8a85d14bdccf7184f5545088f954da55144f235c2983fdb8e05b"),
            Lang.readItemText("CLAY_EXPERIMENT_TABLE_NORMAL"), Lang.readItemLore("CLAY_EXPERIMENT_TABLE_NORMAL"), MachineTier.ADVANCED, MachineType.MACHINE, 1024, "CLAY_EXPERIMENT_TABLE_NORMAL");
    public static final ItemStack CLAY_ROCKET_ASSEMBLING_MACHINE = getSlimefunItemStack(Material.GOLD_BLOCK, Lang.readItemText("CLAY_ROCKET_ASSEMBLING_MACHINE"), Lang.readItemLore("CLAY_ROCKET_ASSEMBLING_MACHINE"), MachineTier.ADVANCED, MachineType.MACHINE, 512, "CLAY_ROCKET_ASSEMBLING_MACHINE");
    public static final ItemStack CLAY_ROCKET_FUEL_GENERATOR = getSlimefunItemStack(Material.EMERALD_BLOCK, Lang.readItemText("CLAY_ROCKET_FUEL_GENERATOR"), Lang.readItemLore("CLAY_ROCKET_FUEL_GENERATOR"),
            MachineTier.ADVANCED, MachineType.MACHINE,
            256, "CLAY_ROCKET_FUEL_GENERATOR");
    public static final ItemStack CLAY_ROCKET_FUEL_INJECTOR = getSlimefunItemStack(Material.DIAMOND_BLOCK, Lang.readItemText("CLAY_ROCKET_FUEL_INJECTOR"), Lang.readItemLore("CLAY_ROCKET_FUEL_INJECTOR"), MachineTier.ADVANCED, MachineType.MACHINE, 256, "CLAY_ROCKET_FUEL_INJECTOR");
    public static final ItemStack CLAY_SPACESUIT_OXYGEN_INJECTOR = getSlimefunItemStack(Material.LAPIS_BLOCK, Lang.readItemText("CLAY_SPACESUIT_OXYGEN_INJECTOR"), Lang.readItemLore("CLAY_SPACESUIT_OXYGEN_INJECTOR"), MachineTier.ADVANCED, MachineType.MACHINE, 256, "CLAY_SPACESUIT_OXYGEN_INJECTOR");
    public static final ItemStack CLAY_COBBLESTONE_GENERATOR = getSlimefunItemStack(Material.FURNACE, Lang.readItemText("CLAY_COBBLESTONE_GENERATOR"), Lang.readItemLore("CLAY_COBBLESTONE_GENERATOR"), MachineTier.ADVANCED, MachineType.MACHINE, 256, "CLAY_COBBLESTONE_GENERATOR");
    public static final ItemStack CLAY_ELECTRIC_COPIER = getSlimefunItemStack(Material.IRON_BLOCK, Lang.readItemText("CLAY_ELECTRIC_COPIER"), Lang.readItemLore("CLAY_ELECTRIC_COPIER"), MachineTier.ADVANCED, MachineType.MACHINE, 256, "CLAY_ELECTRIC_COPIER");
    public static final ItemStack CLAY_WITHER_KILLER = getSlimefunItemStack(Material.OBSIDIAN, Lang.readItemText("CLAY_WITHER_KILLER"), Lang.readItemLore("CLAY_WITHER_KILLER"), MachineTier.END_GAME, MachineType.MACHINE, 5120, "CLAY_WITHER_KILLER");


    public static final SlimefunItemStack REINFORCED_ALLOY_PICKAXE = getSlimefunItemStack(Material.IRON_PICKAXE, Lang.readItemText("REINFORCED_ALLOY_PICKAXE"), "REINFORCED_ALLOY_PICKAXE");
    public static final SlimefunItemStack CLAY_ALLOY_PICKAXE = getSlimefunItemStack(Material.IRON_PICKAXE, Lang.readItemText("CLAY_ALLOY_PICKAXE"), "CLAY_ALLOY_PICKAXE");
    public static final SlimefunItemStack CLAY_ALLOY_HELMET = getSlimefunItemStack(Material.IRON_HELMET, Lang.readItemText("CLAY_ALLOY_HELMET"), "CLAY_ALLOY_HELMET");
    public static final SlimefunItemStack CLAY_ALLOY_CHESTPLATE = getSlimefunItemStack(Material.IRON_CHESTPLATE, Lang.readItemText("CLAY_ALLOY_CHESTPLATE"), "CLAY_ALLOY_CHESTPLATE");
    public static final SlimefunItemStack CLAY_ALLOY_LEGGINGS = getSlimefunItemStack(Material.IRON_LEGGINGS, Lang.readItemText("CLAY_ALLOY_LEGGINGS"), "CLAY_ALLOY_LEGGINGS");
    public static final SlimefunItemStack CLAY_ALLOY_BOOTS = getSlimefunItemStack(Material.IRON_BOOTS, Lang.readItemText("CLAY_ALLOY_BOOTS"), "CLAY_ALLOY_BOOTS");
    private static final NamespacedKey N_BASIC = KeyUtil.newKey("claytech_basic");
    // 分类
    public static final LockedItemGroup C_BASICS = new LockedItemGroup(N_BASIC,
            new CustomItemStack(Material.CLAY, Lang.readCategoriesText("Basic")),
            KeyUtil.newKey(Slimefun.instance(), "basic_machines"));
    public static final LockedItemGroup C_WEAPONS = new LockedItemGroup(
            KeyUtil.newKey("claytech_weapons"),
            new CustomItemStack(Material.DIAMOND_SWORD, Lang.readCategoriesText("Weapons")), N_BASIC);
    public static final LockedItemGroup C_FOOD = new LockedItemGroup(
            KeyUtil.newKey("claytech_food"),
            new CustomItemStack(Material.ENCHANTED_GOLDEN_APPLE, Lang.readCategoriesText("Food")), N_BASIC);
    public static final LockedItemGroup C_FOODMATERIALS = new LockedItemGroup(
            KeyUtil.newKey("claytech_foodmaterials"),
            new CustomItemStack(Material.COCOA_BEANS, Lang.readCategoriesText("FoodMakings")), N_BASIC);
    public static final LockedItemGroup C_DRINK = new LockedItemGroup(
            KeyUtil.newKey("claytech_drink"),
            new CustomItemStack(Material.WATER_BUCKET, Lang.readCategoriesText("Drink")), N_BASIC);
    public static final LockedItemGroup C_MATERIALS = new LockedItemGroup(
            KeyUtil.newKey("claytech_materials"),
            new CustomItemStack(Material.COAL, Lang.readCategoriesText("Makings")), N_BASIC);
    public static final LockedItemGroup C_ARMORS = new LockedItemGroup(
            KeyUtil.newKey("claytech_armors"),
            new CustomItemStack(Material.DIAMOND_CHESTPLATE, Lang.readCategoriesText("Armors")), N_BASIC);
    public static final LockedItemGroup C_DECORATES = new LockedItemGroup(
            KeyUtil.newKey("claytech_decorates"),
            new CustomItemStack(Material.PLAYER_HEAD, Lang.readCategoriesText("Decorates")), N_BASIC);
    public static final LockedItemGroup C_ELEMENTS = new LockedItemGroup(
            KeyUtil.newKey("claytech_elements"),
            new CustomItemStack(Material.FLOWER_POT, Lang.readCategoriesText("Elements")), N_BASIC);
    public static final LockedItemGroup C_MACHINES = new LockedItemGroup(
            KeyUtil.newKey("claytech_machines"),
            new CustomItemStack(Material.FURNACE, Lang.readCategoriesText("Machines")), N_BASIC);
    public static final LockedItemGroup C_OTHER = new LockedItemGroup(
            KeyUtil.newKey("claytech_other"),
            new CustomItemStack(Material.POWERED_RAIL, Lang.readCategoriesText("Other")), N_BASIC);
    public static final LockedItemGroup C_TOOLS = new LockedItemGroup(
            KeyUtil.newKey("claytech_tools"),
            new CustomItemStack(Material.DIAMOND_PICKAXE, Lang.readCategoriesText("Tools")), N_BASIC);
    public static final LockedItemGroup C_ORESTHINGS = new LockedItemGroup(
            KeyUtil.newKey("claytech_oresthings"),
            new CustomItemStack(Material.BRICK, Lang.readCategoriesText("OreThings")), N_BASIC);
    public static @NotNull SlimefunItemStack HONEY_SWEET = getSlimefunItemStack(Material.HONEYCOMB, Lang.readItemText("HONEY_SWEET"),
            Lang.readItemLore("HONEY_SWEET"), "HONEY_SWEET");

    public static @NotNull SlimefunItemStack TNT_EXPLOSION_CREATER = getSlimefunItemStack(new CustomItemStack(Material.TNT, meta -> {
        meta.getPersistentDataContainer().set(KeyUtil.newKey("durability"), PersistentDataType.INTEGER, 32);
    }), Lang.readItemText("TNT_EXPLOSION_CREATER"), Lang.readItemLore("TNT_EXPLOSION_CREATER"), "TNT_EXPLOSION_CREATER");

    public static @NotNull SlimefunItemStack ROCKET_2_BLUEPRINT = getSlimefunItemStack(new CustomItemStack(Material.LIGHT_BLUE_DYE),
            Lang.readItemText("ROCKET_2_BLUEPRINT"), Lang.readItemLore("ROCKET_2_BLUEPRINT"), "ROCKET_2_BLUEPRINT");

    static {
        ItemStackUtil.addEnchantment(REINFORCED_ALLOY_PICKAXE, Enchantment.DURABILITY, 9);
        ItemStackUtil.addEnchantment(REINFORCED_ALLOY_PICKAXE, Enchantment.DIG_SPEED, 9);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_PICKAXE, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_PICKAXE, Enchantment.DIG_SPEED, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_HELMET, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_HELMET, Enchantment.MENDING, 1);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_CHESTPLATE, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_CHESTPLATE, Enchantment.MENDING, 1);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_LEGGINGS, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_LEGGINGS, Enchantment.MENDING, 1);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_BOOTS, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_BOOTS, Enchantment.MENDING, 1);
    }

    static {
        ItemStackUtil.addEnchantment(REINFORCED_ALLOY_PICKAXE, Enchantment.DURABILITY, 9);
        ItemStackUtil.addEnchantment(REINFORCED_ALLOY_PICKAXE, Enchantment.DIG_SPEED, 9);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_PICKAXE, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_PICKAXE, Enchantment.DIG_SPEED, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_HELMET, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_HELMET, Enchantment.MENDING, 1);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_CHESTPLATE, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_CHESTPLATE, Enchantment.MENDING, 1);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_LEGGINGS, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_LEGGINGS, Enchantment.MENDING, 1);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_BOOTS, Enchantment.DURABILITY, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        ItemStackUtil.addEnchantment(CLAY_ALLOY_BOOTS, Enchantment.MENDING, 1);
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(Material m, String name, @NotNull String id) {
        return new SlimefunItemStack("CLAYTECH_" + id, new CustomItemStack(m, name));
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(Material m, String name, @NotNull List<String> lore, @NotNull String id) {
        return new SlimefunItemStack("CLAYTECH_" + id, new CustomItemStack(m, name, lore));
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(@NotNull ItemStack stack, String name, @NotNull String id) {
        return new SlimefunItemStack("CLAYTECH_" + id, ItemStackUtil.setDisplayName(stack, name));
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(@NotNull ItemStack stack, String name, List<String> lore, @NotNull String id) {
        return new SlimefunItemStack("CLAYTECH_" + id, ItemStackUtil.setInfo(stack, name, lore));
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(@NotNull ItemStack stack, String name, String[] lore, @NotNull String id) {
        return new SlimefunItemStack("CLAYTECH_" + id, ItemStackUtil.setInfo(stack, name, lore));
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(@NotNull ItemStack stack, String name, @NotNull List<String> lore, @NotNull MachineTier tier, @NotNull MachineType type, int buffer, @NotNull String id) {
        ItemStack item = stack.clone();

        lore.replaceAll(s -> ClayTech.getLocalizationService().color(s.replaceAll("%TIER%", LoreBuilder.machine(tier, type))));
        lore.replaceAll(s -> ClayTech.getLocalizationService().color(s.replaceAll("%POWER%", LoreBuilder.powerBuffer(buffer))));

        return new SlimefunItemStack(id, ItemStackUtil.setInfo(item, name, lore));
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(@NotNull Material m, String name, @NotNull List<String> lore, @NotNull MachineTier tier, @NotNull MachineType type, int buffer, @NotNull String id) {
        ItemStack item = new ItemStack(m);

        lore.replaceAll(s -> ClayTech.getLocalizationService().color(s.replaceAll("%TIER%", LoreBuilder.machine(tier, type))));
        lore.replaceAll(s -> ClayTech.getLocalizationService().color(s.replaceAll("%POWER%", LoreBuilder.powerBuffer(buffer))));

        return new SlimefunItemStack("CLAYTECH_" + id, ItemStackUtil.setInfo(item, name, lore));
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(@NotNull Material m, String name, String[] lore, @NotNull MachineTier tier, @NotNull MachineType type, int buffer, @NotNull String id) {
        return getSlimefunItemStack(m, name, Arrays.asList(lore), tier, type, buffer, id);
    }

    private static @NotNull SlimefunItemStack getSlimefunItemStack(@NotNull ItemStack stack, String name, String[] lore, @NotNull MachineTier tier, @NotNull MachineType type, int buffer, @NotNull String id) {
        return getSlimefunItemStack(stack, name, Arrays.asList(lore), tier, type, buffer, id);
    }
}
