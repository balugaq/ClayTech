package cn.claycoffee.clayTech.core.listeners;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechData;
import cn.claycoffee.clayTech.api.ClayTechManager;
import cn.claycoffee.clayTech.api.objects.Planet;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.PlanetUtil;
import cn.claycoffee.clayTech.utils.RocketUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Dispenser;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Boss;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent.Cause;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class PlanetListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void EntitySpawnEvent(@NotNull EntitySpawnEvent e) {
        Planet p = PlanetUtil.getPlanet(e.getEntity().getWorld());
        if (p != null) {
            if (!p.getMobSpawnable()) {
                if (e.getEntity() instanceof Mob || e.getEntity() instanceof Animals || e.getEntity() instanceof Monster
                        || e.getEntity() instanceof Boss) {
                    e.setCancelled(true);
                }

            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerChangeWorldEvent(@NotNull PlayerChangedWorldEvent e) {
        e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
        e.getPlayer().removePotionEffect(PotionEffectType.SLOW_FALLING);

        Planet p = PlanetUtil.getPlanet(e.getPlayer().getWorld());
        if (p != null) {
            if (!p.getHabitable()) {
                if (ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getHelmet())
                        && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getChestplate())
                        && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getLeggings())
                        && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getBoots())) {
                    World PreviousWorld = e.getPlayer().getWorld();
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            if (!PreviousWorld.equals(e.getPlayer().getWorld()) || !e.getPlayer().isOnline()) {
                                this.cancel();
                                return;
                            }
                            // 扣氧气线程
                            if (ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getHelmet())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getChestplate())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getLeggings())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getBoots())) {
                                if (RocketUtil.getOxygen(e.getPlayer().getInventory().getHelmet()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getChestplate()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getLeggings()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getBoots()) > 0) {
                                    ItemStack helmet = e.getPlayer().getInventory().getHelmet();
                                    RocketUtil.setOxygen(helmet, RocketUtil.getOxygen(helmet) - 1);

                                    ItemStack chestplate = e.getPlayer().getInventory().getChestplate();
                                    RocketUtil.setOxygen(chestplate, RocketUtil.getOxygen(chestplate) - 1);

                                    ItemStack leggings = e.getPlayer().getInventory().getLeggings();
                                    RocketUtil.setOxygen(leggings, RocketUtil.getOxygen(leggings) - 1);

                                    ItemStack boots = e.getPlayer().getInventory().getBoots();
                                    RocketUtil.setOxygen(boots, RocketUtil.getOxygen(boots) - 1);
                                }
                            }
                        }

                    }.runTaskTimerAsynchronously(ClayTech.getInstance(), 1200, 1200);
                    new BukkitRunnable() {

                        @SuppressWarnings("deprecation")
                        @Override
                        public void run() {
                            if (!PreviousWorld.equals(e.getPlayer().getWorld()) || !e.getPlayer().isOnline()) {
                                this.cancel();
                                return;
                            }
                            if (!(ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getHelmet())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getChestplate())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getLeggings())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getBoots()))) {
                                // 扣血
                                e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                        Lang.readGeneralText("SpaceSuitError_Sub"));
                                e.getPlayer().damage(5);

                            } else {
                                if (!(RocketUtil.getOxygen(e.getPlayer().getInventory().getHelmet()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getChestplate()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getLeggings()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getBoots()) > 0)) {
                                    // 扣血
                                    e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                            Lang.readGeneralText("SpaceSuitError_Sub"));
                                    e.getPlayer().damage(5);
                                } else {
                                    int harmlevel = p.getHarmLevel();
                                    if (RocketUtil
                                            .getProtectLevel(e.getPlayer().getInventory().getHelmet()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getChestplate()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getLeggings()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getBoots()) < harmlevel) {
                                        // 扣血
                                        e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                                Lang.readGeneralText("SpaceSuitError_Sub"));
                                        e.getPlayer().damage(5);
                                    }
                                }
                            }
                        }

                    }.runTaskTimer(ClayTech.getInstance(), 20, 20);
                } else {
                    World PreviousWorld = e.getPlayer().getWorld();
                    new BukkitRunnable() {

                        @SuppressWarnings("deprecation")
                        @Override
                        public void run() {
                            if (!PreviousWorld.equals(e.getPlayer().getWorld()) || !e.getPlayer().isOnline()) {
                                this.cancel();
                                return;
                            }
                            if (!(ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getHelmet())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getChestplate())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getLeggings())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getBoots()))) {
                                // 扣血
                                e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                        Lang.readGeneralText("SpaceSuitError_Sub"));
                                e.getPlayer().damage(5);

                            } else {
                                if (!(RocketUtil.getOxygen(e.getPlayer().getInventory().getHelmet()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getChestplate()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getLeggings()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getBoots()) > 0)) {
                                    // 扣血
                                    e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                            Lang.readGeneralText("SpaceSuitError_Sub"));
                                    e.getPlayer().damage(5);
                                } else {
                                    int harmlevel = p.getHarmLevel();
                                    if (RocketUtil
                                            .getProtectLevel(e.getPlayer().getInventory().getHelmet()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getChestplate()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getLeggings()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getBoots()) < harmlevel) {
                                        // 扣血
                                        e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                                Lang.readGeneralText("SpaceSuitError_Sub"));
                                        e.getPlayer().damage(5);
                                    }
                                }
                            }
                        }

                    }.runTaskTimer(ClayTech.getInstance(), 20, 20);
                }
            }

            int gravity = (int) (1 / p.getGravity());
            if (gravity > 1) {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, gravity));
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, gravity));
            }
        }
    }

    @EventHandler
    public void PlayerJoinEvent(@NotNull PlayerJoinEvent e) {
        e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
        e.getPlayer().removePotionEffect(PotionEffectType.SLOW_FALLING);

        Planet p = PlanetUtil.getPlanet(e.getPlayer().getWorld());
        if (p != null) {
            if (!p.getHabitable()) {
                if (ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getHelmet())
                        && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getChestplate())
                        && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getLeggings())
                        && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getBoots())) {
                    World PreviousWorld = e.getPlayer().getWorld();
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            if (!PreviousWorld.equals(e.getPlayer().getWorld()) || !e.getPlayer().isOnline()) {
                                this.cancel();
                                return;
                            }
                            // 扣氧气线程
                            if (ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getHelmet())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getChestplate())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getLeggings())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getBoots())) {
                                if (RocketUtil.getOxygen(e.getPlayer().getInventory().getHelmet()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getChestplate()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getLeggings()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getBoots()) > 0) {
                                    ItemStack helmet = e.getPlayer().getInventory().getHelmet();
                                    RocketUtil.setOxygen(helmet, RocketUtil.getOxygen(helmet) - 1);

                                    ItemStack chestplate = e.getPlayer().getInventory().getChestplate();
                                    RocketUtil.setOxygen(chestplate, RocketUtil.getOxygen(chestplate) - 1);

                                    ItemStack leggings = e.getPlayer().getInventory().getLeggings();
                                    RocketUtil.setOxygen(leggings, RocketUtil.getOxygen(leggings) - 1);

                                    ItemStack boots = e.getPlayer().getInventory().getBoots();
                                    RocketUtil.setOxygen(boots, RocketUtil.getOxygen(boots) - 1);
                                }
                            }
                        }

                    }.runTaskTimerAsynchronously(ClayTech.getInstance(), 1200, 1200);
                    new BukkitRunnable() {

                        @SuppressWarnings("deprecation")
                        @Override
                        public void run() {
                            if (!PreviousWorld.equals(e.getPlayer().getWorld()) || !e.getPlayer().isOnline()) {
                                this.cancel();
                                return;
                            }
                            if (!(ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getHelmet())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getChestplate())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getLeggings())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getBoots()))) {
                                // 扣血
                                e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                        Lang.readGeneralText("SpaceSuitError_Sub"));
                                e.getPlayer().damage(5);

                            } else {
                                if (!(RocketUtil.getOxygen(e.getPlayer().getInventory().getHelmet()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getChestplate()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getLeggings()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getBoots()) > 0)) {
                                    // 扣血
                                    e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                            Lang.readGeneralText("SpaceSuitError_Sub"));
                                    e.getPlayer().damage(5);
                                } else {
                                    int harmlevel = p.getHarmLevel();
                                    if (RocketUtil
                                            .getProtectLevel(e.getPlayer().getInventory().getHelmet()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getChestplate()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getLeggings()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getBoots()) < harmlevel) {
                                        // 扣血
                                        e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                                Lang.readGeneralText("SpaceSuitError_Sub"));
                                        e.getPlayer().damage(5);
                                    }
                                }
                            }
                        }

                    }.runTaskTimer(ClayTech.getInstance(), 20, 20);
                } else {
                    World PreviousWorld = e.getPlayer().getWorld();
                    new BukkitRunnable() {

                        @SuppressWarnings("deprecation")
                        @Override
                        public void run() {
                            if (!PreviousWorld.equals(e.getPlayer().getWorld()) || !e.getPlayer().isOnline()) {
                                this.cancel();
                                return;
                            }
                            if (!(ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getHelmet())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getChestplate())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getLeggings())
                                    && ClayTechManager.isSpaceSuit(e.getPlayer().getInventory().getBoots()))) {
                                // 扣血
                                e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                        Lang.readGeneralText("SpaceSuitError_Sub"));
                                e.getPlayer().damage(5);

                            } else {
                                if (!(RocketUtil.getOxygen(e.getPlayer().getInventory().getHelmet()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getChestplate()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getLeggings()) > 0
                                        && RocketUtil.getOxygen(e.getPlayer().getInventory().getBoots()) > 0)) {
                                    // 扣血
                                    e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                            Lang.readGeneralText("SpaceSuitError_Sub"));
                                    e.getPlayer().damage(5);
                                } else {
                                    int harmlevel = p.getHarmLevel();
                                    if (RocketUtil
                                            .getProtectLevel(e.getPlayer().getInventory().getHelmet()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getChestplate()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getLeggings()) < harmlevel
                                            || RocketUtil.getProtectLevel(
                                            e.getPlayer().getInventory().getBoots()) < harmlevel) {
                                        // 扣血
                                        e.getPlayer().sendTitle(Lang.readGeneralText("SpaceSuitError"),
                                                Lang.readGeneralText("SpaceSuitError_Sub"));
                                        e.getPlayer().damage(5);
                                    }
                                }
                            }
                        }

                    }.runTaskTimer(ClayTech.getInstance(), 20, 20);
                }
            }

            int gravity = (int) (1 / p.getGravity());
            if (gravity > 1) {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, gravity));
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, gravity));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void EntityPotionEffectEvent(@NotNull EntityPotionEffectEvent e) {
        if (e.getCause() == Cause.MILK && e.getEntity() instanceof Player) {
            Planet p = PlanetUtil.getPlanet(e.getEntity().getWorld());
            if (p == null) return;
            if (p.getGravity() != 1) {
                e.setCancelled(true);
                e.getEntity().sendMessage(Lang.readGeneralText("Cant_Drink_Milk"));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerTeleportEvent(@NotNull PlayerTeleportEvent e) {
        if (e.getPlayer().hasPermission("claytech.bypasstpcheck")) return;

        Planet p = PlanetUtil.getPlanet(e.getPlayer().getWorld());
        Planet to = PlanetUtil.getPlanet(e.getTo().getWorld());
        boolean inRocket = false;
        if (p != null) {
            // 在一个星球上
            if (to != null) {
                if (p.getPlanetWorldName().equalsIgnoreCase(to.getPlanetWorldName())) {
                    // 如果目标位置在一个星球
                    return;
                }
                // 否则，目标位置在另外一个星球.

                inRocket = ClayTechData.InRocketPlayers.contains(e.getPlayer().getUniqueId());
                boolean ast = ClayTechData.AllowSpaceTeleport.contains(e.getPlayer().getUniqueId());
                if (!inRocket) {
                    if (ast) {
                        ClayTechData.AllowSpaceTeleport.remove(e.getPlayer().getUniqueId());
                        return;
                    }
                    // 其他星球传送到主世界
                    e.getPlayer().sendMessage(Lang.readGeneralText("CantUseOtherTeleportInUniverse"));
                    e.setCancelled(true);
                    return;
                }
            } else {
                // 再否则，目标位置不在任何星球。
                // 比如，月球传送到地狱。
                boolean ast = ClayTechData.AllowSpaceTeleport.contains(e.getPlayer().getUniqueId());
                if (!p.getPlanetWorldName().equalsIgnoreCase(ClayTech.getOverworld())) {
                    if (ast) {
                        ClayTechData.AllowSpaceTeleport.remove(e.getPlayer().getUniqueId());
                        return;
                    }
                    // 其他星球传送到主世界
                    e.getPlayer().sendMessage(Lang.readGeneralText("CantUseOtherTeleportInUniverse"));
                    e.setCancelled(true);
                    return;
                }
            }
        } else if (to != null) {
            // 目标位置是一个星球，但出发位置不是任何一个星球。
            boolean ast = ClayTechData.AllowSpaceTeleport.contains(e.getPlayer().getUniqueId());
            if (!to.getPlanetWorldName().equalsIgnoreCase(ClayTech.getOverworld())) {
                if (ast) {
                    ClayTechData.AllowSpaceTeleport.remove(e.getPlayer().getUniqueId());
                    return;
                }
                // 在主世界传送到其他星球
                e.getPlayer().sendMessage(Lang.readGeneralText("CantUseOtherTeleportInUniverse"));
                e.setCancelled(true);
                return;
            }
        }
        // 最后否则，出发地和结束地都不在任何一个星球，pass掉.
    }

    @EventHandler
    public void EntityDamageEvent(@NotNull EntityDamageEvent e) {
        if (e.getEntityType() == EntityType.PLAYER && e.getCause() == DamageCause.FALL) {
            Player p = (Player) e.getEntity();
            if (ClayTechManager.isSpaceSuit(p.getInventory().getHelmet())
                    && ClayTechManager.isSpaceSuit(p.getInventory().getChestplate())
                    && ClayTechManager.isSpaceSuit(p.getInventory().getLeggings())
                    && ClayTechManager.isSpaceSuit(p.getInventory().getBoots())) {
                e.setDamage(e.getDamage() - e.getFinalDamage());
                if (ClayTechData.SpaceSuitNoCostDurability.contains(p.getUniqueId())) {
                    e.setCancelled(true);
                    ClayTechData.SpaceSuitNoCostDurability.remove(p.getUniqueId());
                }
                p.sendMessage(Lang.readGeneralText("SpaceSuitFall"));
            }
        }
    }

    @EventHandler
    public void EntityDeathEvent(@NotNull EntityDeathEvent ev) {
        EntityDamageEvent e = ev.getEntity().getLastDamageCause();
        if (e == null) return;
        if (e.getEntityType() == EntityType.PLAYER && e.getCause() == DamageCause.FALL) {
            Player p = (Player) e.getEntity();
            if (ClayTechManager.isSpaceSuit(p.getInventory().getHelmet())
                    && ClayTechManager.isSpaceSuit(p.getInventory().getChestplate())
                    && ClayTechManager.isSpaceSuit(p.getInventory().getLeggings())
                    && ClayTechManager.isSpaceSuit(p.getInventory().getBoots())) {
                e.setDamage(e.getDamage() - e.getFinalDamage());
                if (ClayTechData.SpaceSuitNoCostDurability.contains(p.getUniqueId())) {
                    e.setCancelled(true);
                    ClayTechData.SpaceSuitNoCostDurability.remove(p.getUniqueId());
                }
                p.sendMessage(Lang.readGeneralText("SpaceSuitFall"));
            }
        }
    }

    @EventHandler
    public void PlayerBucketEmptyEvent(@NotNull PlayerBucketEmptyEvent e) {
        // 禁止玩家放置液体
        Planet p = PlanetUtil.getPlanet(e.getBlock().getWorld());
        if (p != null) {
            if (p.getCold()) {
                if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.WATER_BUCKET) {
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_FIRE_EXTINGUISH,
                                    1.0F, 1.0F);
                            e.getBlock().setType(Material.BLUE_ICE);
                        }

                    }.runTaskLater(ClayTech.getInstance(), 30);
                    return;
                }
                if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.LAVA_BUCKET) {
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_FIRE_EXTINGUISH,
                                    1.0F, 1.0F);
                            e.getBlock().setType(Material.OBSIDIAN);
                        }

                    }.runTaskLater(ClayTech.getInstance(), 30);
                    return;
                }
            }
        }
    }

    @EventHandler
    public void BlockDispenseEvent(@NotNull BlockDispenseEvent e) {
        // 禁止发射器放置液体
        Planet p = PlanetUtil.getPlanet(e.getBlock().getWorld());
        if (p != null) {
            if (p.getCold()) {
                if (e.getItem().getType() == Material.WATER_BUCKET) {
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            Dispenser d = (Dispenser) e.getBlock().getBlockData();
                            Block targetBlock = e.getBlock().getRelative(d.getFacing());
                            e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_FIRE_EXTINGUISH,
                                    1.0F, 1.0F);
                            targetBlock.setType(Material.BLUE_ICE);
                        }

                    }.runTaskLater(ClayTech.getInstance(), 30);
                    return;
                }
                if (e.getItem().getType() == Material.LAVA_BUCKET) {
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            Dispenser d = (Dispenser) e.getBlock().getBlockData();
                            Block targetBlock = e.getBlock().getRelative(d.getFacing());
                            e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_FIRE_EXTINGUISH,
                                    1.0F, 1.0F);
                            targetBlock.setType(Material.OBSIDIAN);
                        }

                    }.runTaskLater(ClayTech.getInstance(), 30);
                    return;
                }
            }
        }
    }

    @EventHandler
    public void CauldronLevelChangeEvent(@NotNull CauldronLevelChangeEvent e) {
        Planet p = PlanetUtil.getPlanet(e.getBlock().getWorld());
        if (p != null) {
            if (p.getCold()) {
                e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1.0F, 1.0F);
                e.setNewLevel(0);
                return;
            }
        }
    }
}
