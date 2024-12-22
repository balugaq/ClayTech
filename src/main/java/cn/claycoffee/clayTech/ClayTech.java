package cn.claycoffee.clayTech;

import cn.claycoffee.clayTech.api.ClayTechManager;
import cn.claycoffee.clayTech.aarewrite.api.Planet;
import cn.claycoffee.clayTech.implementation.Planets.Earth;
import cn.claycoffee.clayTech.implementation.Planets.Mars;
import cn.claycoffee.clayTech.implementation.Planets.Moon;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Armors;
import cn.claycoffee.clayTech.aarewrite.implementation.items.ClayFuelResource;
import cn.claycoffee.clayTech.aarewrite.implementation.items.ClayBasic;
import cn.claycoffee.clayTech.aarewrite.implementation.items.DrinkMakingStaff;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Drinks;
import cn.claycoffee.clayTech.aarewrite.implementation.items.EffectItems;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Elements;
import cn.claycoffee.clayTech.aarewrite.implementation.items.FoodMakingStaff;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Foods;
import cn.claycoffee.clayTech.aarewrite.implementation.items.GoldenThings;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Ingots;
import cn.claycoffee.clayTech.aarewrite.implementation.items.MachineMakingBasic;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Machines;
import cn.claycoffee.clayTech.aarewrite.implementation.items.PotionAffectWeapons;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Railways;
import cn.claycoffee.clayTech.aarewrite.implementation.items.RocketMakings;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Rockets;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Skulls;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Spacethings;
import cn.claycoffee.clayTech.aarewrite.implementation.items.Tools;
import cn.claycoffee.clayTech.implementation.resources.ClayFuel;
import cn.claycoffee.clayTech.aarewrite.core.listeners.BlockUseListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.FoodDropListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.FoodEatListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.ItemInteractListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.ItemUseListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.PlanetBaseListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.PlanetListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.RailwayListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.RocketLauncherListener;
import cn.claycoffee.clayTech.aarewrite.core.listeners.WeaponListener;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.Metrics;
import cn.claycoffee.clayTech.utils.PlanetUtils;
import cn.claycoffee.clayTech.utils.RocketUtils;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.exceptions.IdConflictException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings({"unused", "deprecation"})
public class ClayTech extends JavaPlugin implements SlimefunAddon {
    private static final String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",")
            .split(",")[3];
    private static final boolean compatible = true;
    private static final List<Planet> planetList = new ArrayList<>();
    protected static ClayTech plugin;
    private static String locale;
    private static String highrailspeed;
    private static String overworld = "";
    private static ClayTechUpdater updater;
    private static boolean spacetravelneedperm;
    private static String updateBranch;
    private static FileConfiguration config;
    private static FileConfiguration defaultLang;
    private static boolean worldBorderEnabled;
    private static LocalizationService service;
    private static final BukkitRunnable harmInSpace = new BukkitRunnable() {
        @SuppressWarnings("deprecation")
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player == null) {
                    continue;
                }

                if (!player.isOnline()) {
                    continue;
                }

                Planet planet = PlanetUtils.getPlanet(player.getWorld());
                if (planet == null) {
                    continue;
                }

                if (planet.getHabitable()) {
                    continue;
                }

                int harmlevel = planet.getHarmLevel();

                World PreviousWorld = player.getWorld();
                if (!PreviousWorld.equals(player.getWorld())) {
                    return;
                }

                boolean isSpaceSuit = ClayTechManager.isSpaceSuit(player.getInventory().getHelmet())
                        && ClayTechManager.isSpaceSuit(player.getInventory().getChestplate())
                        && ClayTechManager.isSpaceSuit(player.getInventory().getLeggings())
                        && ClayTechManager.isSpaceSuit(player.getInventory().getBoots());
                if (!(isSpaceSuit)) {
                    player.sendTitle(Lang.readGeneralText("SpaceSuitError"),
                            Lang.readGeneralText("SpaceSuitError_Sub"));
                    player.damage(5);
                    return;
                }

                boolean isOxygenSuit = RocketUtils.getOxygen(player.getInventory().getHelmet()) > 0
                        && RocketUtils.getOxygen(player.getInventory().getChestplate()) > 0
                        && RocketUtils.getOxygen(player.getInventory().getLeggings()) > 0
                        && RocketUtils.getOxygen(player.getInventory().getBoots()) > 0;
                if (!(isOxygenSuit)) {
                    player.sendTitle(Lang.readGeneralText("SpaceSuitError"),
                            Lang.readGeneralText("SpaceSuitError_Sub"));
                    player.damage(5);
                    return;
                }

                boolean isProtectSuit =
                        RocketUtils
                                .getProtectLevel(player.getInventory().getHelmet()) > harmlevel
                                && RocketUtils.getProtectLevel(
                                player.getInventory().getChestplate()) > harmlevel
                                && RocketUtils.getProtectLevel(
                                player.getInventory().getLeggings()) > harmlevel
                                && RocketUtils.getProtectLevel(
                                player.getInventory().getBoots()) > harmlevel;

                if (!isProtectSuit) {
                    // 扣血
                    player.sendTitle(Lang.readGeneralText("SpaceSuitError"),
                            Lang.readGeneralText("SpaceSuitError_Sub"));
                    player.damage(5);
                    return;
                }
            }
        }

    };
    private static ConfigManager configManager;
    private static ConfigManager planetManager;
    private static ConfigManager planetDataManager;
    private final BukkitRunnable autoUpdate = new BukkitRunnable() {

        @Override
        public void run() {
            ChatColor yellow = ChatColor.YELLOW;
            ChatColor green = ChatColor.GREEN;
            // Updater
            updateBranch = config.getString("update-branch");
            updater = new ClayTechUpdater();
            if (!getConfig().getBoolean("disable-auto-updater")) {

                updater.tryUpdate();
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        updater.tryUpdate();
                    }

                }.runTaskTimerAsynchronously(ClayTech.getInstance(), 1728000, 1728000);
            } else {
                getLogger().info(yellow + Lang.readGeneralText("Info_1"));
                getLogger().info(yellow + Lang.readGeneralText("Auto-updater_disabled"));
                getLogger().info(yellow + Lang.readGeneralText("Info_6"));
            }
            List<String> Authors = plugin.getDescription().getAuthors();
            getLogger().info(green + Lang.readGeneralText("Info_1"));
            getLogger().info(green + Lang.readGeneralText("Info_2").replaceAll("\\{version\\}",
                    plugin.getDescription().getVersion()));
            getLogger().info(
                    green + Lang.readGeneralText("Info_3").replaceAll(
                            "\\{author\\}",
                            Arrays.toString(Authors.toArray(new String[0]))));
            getLogger().info(green + Lang.readGeneralText("Info_4"));
            getLogger().info(green
                    + Lang.readGeneralText("Info_5").replaceAll("\\{issue_tracker\\}", plugin.getBugTrackerURL()));
            getLogger().info(green + Lang.readGeneralText("Info_6"));
        }

    };

    public static LocalizationService getLocalizationService() {
        return service;
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static ConfigManager getPlanetManager() {
        return planetManager;
    }

    public static ConfigManager getPlanetDataManager() {
        return planetDataManager;
    }

    public static ClayTech getInstance() {
        return plugin;
    }

    public static String getLocale() {
        return locale;
    }

    public static boolean isSpaceTravelNeedPerm() {
        return spacetravelneedperm;
    }

    public static String getHighRailSpeed() {
        return highrailspeed;
    }

    public static ClayTechUpdater getUpdater() {
        return updater;
    }

    public static boolean getCompatible() {
        return compatible;
    }

    public static List<Planet> getPlanets() {
        return planetList;
    }

    public static String getOverworld() {
        return overworld;
    }

    public static String getUpdateBranch() {
        return updateBranch;
    }

    public static FileConfiguration getDefaultLang() {
        return defaultLang;
    }

    public static boolean isWorldBorderEnabled() {
        return worldBorderEnabled;
    }

    @Override
    public void onEnable() {
        plugin = this;

        configManager = new ConfigManager("config.yml");
        config = configManager.getConfig();
        locale = config.getString("Locale");
        if (locale == null) {
            locale = "en-US";
        }
        highrailspeed = configManager.getConfig().getString("highrailspeed");
        if (highrailspeed == null) {
            highrailspeed = "3";
        }

        service = new LocalizationService(this);
        service.addLanguage(locale);
        service.addLanguage("en-US");

        overworld = config.getString("overworld");

        if (!compatible) {
            getLogger().info(Lang.readGeneralText("Not_compatible"));
        }

        Metrics mt = new Metrics(this, 6887);
        mt.addCustomChart(new Metrics.SimplePie("language", () -> languageCodeToLanguage(locale)));

        planetManager = new ConfigManager("planets.yml");
        planetDataManager = new ConfigManager("planetdata.yml");

        getLogger().info(Lang.readGeneralText("startTip"));
        getLogger().info(Lang.readGeneralText("registeringItems"));
        try {
            registerSlimefun();
            registerPlanets();
            registerResources();
        } catch (Exception e) {
            getLogger().info(Lang.readGeneralText("registeringError"));
            e.printStackTrace();
        }
        if (this.getServer().getPluginManager().isPluginEnabled("WorldBorder")) {
            getLogger().info(Lang.readGeneralText("WorldBorder"));
            worldBorderEnabled = true;
        }

        Bukkit.getPluginManager().registerEvents(new ItemInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new ItemUseListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoodEatListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoodDropListener(), this);
        Bukkit.getPluginManager().registerEvents(new WeaponListener(), this);
        Bukkit.getPluginManager().registerEvents(new RailwayListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlanetListener(), this);
        Bukkit.getPluginManager().registerEvents(new RocketLauncherListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlanetBaseListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockUseListener(), this);

        PluginCommand command = this.getCommand("claytech");
        if (command != null) {
            command.setExecutor(new ClayTechCommands());
        } else {
            getLogger().severe("Command /claytech not found.");
        }

        spacetravelneedperm = config.getBoolean("space-travel-need-perm");

        ClayTechData.currentVersion = this.getDescription().getVersion();

        autoUpdate.runTaskAsynchronously(this);

        harmInSpace.runTaskTimer(ClayTech.getInstance(), 20, 20);

        getLogger().info("ClayTech has been enabled.");
    }

    @Override
    public void onDisable() {
        if (ClayTech.getInstance().getConfig().getBoolean("replace-when-server-stops")) {
            if (ClayTechData.jarLocation != null & ClayTechData.updateJar != null) {
                try {
                    FileOutputStream os = new FileOutputStream(new File(ClayTechData.jarLocation));
                    os.write(ClayTechData.updateJar);
                    os.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String languageCodeToLanguage(String code) {
        return switch (code.toUpperCase()) {
            case "ZH-CN" -> "Simplified Chinese";
            case "ZH-TW" -> "Traditional Chinese";
            case "EN-US" -> "English(US)";
            case "EN-GB" -> "English(UK)";
            case "JA" -> "Japanese";
            case "PL-PL" -> "Polski";
            case "FR" -> "Français";
            default -> code;
        };
    }

    private void registerSlimefun() {
        new ClayBasic();
        new Machines();
        new PotionAffectWeapons();
        new GoldenThings();
        new Skulls();
        new Armors();
        new DrinkMakingStaff();
        new Drinks();
        new FoodMakingStaff();
        new Foods();
        new MachineMakingBasic();
        new Elements();
        new Railways();
        new EffectItems();
        new Ingots();
        new Tools();
        new ClayFuelResource();
        new RocketMakings();
        new Rockets();
        new Spacethings();
    }


    @Override
    public @NotNull JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public @NotNull File getFile() {
        return super.getFile();
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/ClayCoffee/ClayTech/issues";
    }

    private void registerPlanets() {
        // Earth(Overworld) 地球(主世界)
        new Earth();
        // Moon 月球
        new Moon();
        // Mars 火星
        new Mars();
    }

    private void registerResources() {
        new ClayFuel();
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, String id) {
        List<String> PlanetNameList = new ArrayList<>();
        List<Planet> PlanetList = getPlanets();
        for (Planet p : PlanetList) {
            PlanetNameList.add(p.getPlanetWorldName());
        }
        for (String name : PlanetNameList.toArray(new String[0])) {
            if (id.equals(name)) {
                return PlanetList.get(PlanetNameList.indexOf(id)).getPlanetGenerator();
            }
        }
        return Bukkit.getWorld(getOverworld()).getGenerator();
    }
}