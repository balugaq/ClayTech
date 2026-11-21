package cn.claycoffee.clayTech.utils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.nms.ItemNameAdapter;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ItemStackWrapper;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Final_ROOT, ClayCoffee, balugaq
 */
@SuppressWarnings({"unused", "deprecation"})
public final class ItemStackUtil {
    public static final ItemStack AIR = new ItemStack(Material.AIR);
    public static final @org.jetbrains.annotations.Nullable ItemNameAdapter itemNameAdapter = ItemNameAdapter.get();

    /**
     * Clone an #{@link ItemStack}
     *
     * @param item to be cloned
     * @return a cloned #{@link ItemStack}
     */
    public static @NotNull ItemStack cloneItem(@Nonnull ItemStack item) {
        return item instanceof ItemStackWrapper ? new ItemStack(item) : item.clone();
    }

    public static @NotNull ItemStack getCleanItem(@Nullable ItemStack item) {
        if (item == null) {
            return new ItemStack(Material.AIR);
        }

        ItemStack cleanItem = new ItemStack(item.getType());
        cleanItem.setAmount(item.getAmount());
        if (item.hasItemMeta()) {
            cleanItem.setItemMeta(item.getItemMeta());
        }

        return cleanItem;
    }

    /**
     * Clone an #{@link ItemStack}
     *
     * @param item   to be cloned
     * @param amount the amount of the result item
     * @return a cloned #{@link ItemStack}
     */
    public static @NotNull ItemStack cloneItem(@Nonnull ItemStack item, int amount) {
        ItemStack itemStack = item instanceof ItemStackWrapper ? new ItemStack(item) : item.clone();
        itemStack.setAmount(amount);
        return itemStack;
    }

    /**
     * @return Whether the item seems to be null
     */
    public static boolean isItemNull(@Nullable ItemStack item) {
        return item == null || item.getType() == Material.AIR || item.getAmount() == 0;
    }

    /**
     * @return Name of the given #{@link ItemStack}.
     */
    @Nonnull
    public static String getItemName(@Nullable ItemStack item) {
        if (ItemStackUtil.isItemNull(item)) {
            return "null";
        }
        item = new ItemStack(item);
        if (item.hasItemMeta()) {
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta.hasDisplayName()) {
                return itemMeta.getDisplayName();
            }
        } else {
            try {
                return itemNameAdapter.getName(item);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
                return "unknown";
            }
        }
        return "unknown";
    }

    public static void setItemName(@Nonnull ItemStack item, @Nonnull String itemName) {
        if (!item.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(itemName);
        item.setItemMeta(itemMeta);
    }

    public static void addLoreToFirst(@Nullable ItemStack item, @Nonnull String s) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
            lore.add(s);
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
        } else {
            List<String> newLore = new ArrayList<>(lore.size() + 1);
            newLore.add(s);
            newLore.addAll(lore);
            itemMeta.setLore(newLore);
            item.setItemMeta(itemMeta);
        }
    }

    public static void addLoreToLast(@Nullable ItemStack item, @Nonnull String s) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
        }
        lore.add(s);
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void addLoreToLast(@Nonnull ItemMeta itemMeta, @Nonnull String s) {
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
        }
        lore.add(s);
        itemMeta.setLore(lore);
    }

    public static void addLoresToLast(@Nullable ItemStack item, @Nonnull String... s) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
        }
        lore.addAll(Arrays.stream(s).toList());
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void addLoresToLast(@Nonnull ItemMeta itemMeta, @Nonnull String... s) {
        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            lore = new ArrayList<>(8);
        }
        lore.addAll(Arrays.stream(s).toList());
        itemMeta.setLore(lore);
    }

    public static void removeLastLore(@Nullable ItemStack item) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            return;
        }
        lore = lore.subList(0, Math.max(lore.size() - 1, 0));
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void removeLastLore(@Nonnull ItemMeta itemMeta) {
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            return;
        }
        lore = lore.subList(0, Math.max(lore.size() - 1, 0));
        itemMeta.setLore(lore);
    }

    public static void setLastLore(@Nonnull ItemStack item, @Nonnull String s) {
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            lore = new ArrayList<>();
            lore.add(s);
        } else {
            lore.set(lore.size() - 1, s);
        }
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }

    public static void setLastLore(@Nonnull ItemMeta itemMeta, @Nonnull String s) {
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            lore = new ArrayList<>();
            lore.add(s);
        } else {
            lore.set(lore.size() - 1, s);
        }
        itemMeta.setLore(lore);
    }

    @Nullable
    public static String getLastLore(@Nonnull ItemStack item) {
        if (ItemStackUtil.isItemNull(item)) {
            return null;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            return null;
        }
        return lore.get(lore.size() - 1);
    }

    @Nullable
    public static String getLastLore(@Nonnull ItemMeta itemMeta) {
        List<String> lore = itemMeta.getLore();
        if (lore == null || lore.isEmpty()) {
            return null;
        }
        return lore.get(lore.size() - 1);
    }

    public static void replaceLore(@Nonnull ItemStack item, int loreOffset, @Nonnull String... lore) {
        if (loreOffset < 0) {
            ItemStackUtil.setLore(item, lore);
            return;
        }
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> oldLore = itemMeta.getLore();
        if (oldLore == null) {
            oldLore = new ArrayList<>();
        }
        while (oldLore.size() < loreOffset) {
            oldLore.add("");
        }
        for (int i = 0; i < lore.length; i++) {
            if (oldLore.size() <= loreOffset + i) {
                oldLore.add(loreOffset + i, lore[i]);
            } else {
                oldLore.set(loreOffset + i, lore[i]);
            }
        }
        itemMeta.setLore(oldLore);
        item.setItemMeta(itemMeta);
    }

    public static void replaceLore(@Nonnull ItemStack item, int loreOffset, @Nonnull List<String> lore) {
        if (loreOffset < 0) {
            ItemStackUtil.setLore(item, lore);
            return;
        }
        if (ItemStackUtil.isItemNull(item)) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        List<String> oldLore = itemMeta.getLore();
        if (oldLore == null) {
            oldLore = new ArrayList<>();
        }
        while (oldLore.size() < loreOffset) {
            oldLore.add("");
        }
        for (int i = 0; i < lore.size(); i++) {
            if (oldLore.size() <= loreOffset + i) {
                oldLore.add(loreOffset + i, lore.get(i));
            } else {
                oldLore.set(loreOffset + i, lore.get(i));
            }
        }
        itemMeta.setLore(oldLore);
        item.setItemMeta(itemMeta);
    }

    public static void addItemFlag(@Nonnull ItemStack item, @Nonnull ItemFlag itemFlag) {
        if (!item.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addItemFlags(itemFlag);
        item.setItemMeta(itemMeta);
    }

    public static void addNBT(@Nonnull ItemStack item, @Nonnull NamespacedKey namespacedKey, @Nonnull String value) {
        if (!item.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        if (!persistentDataContainer.has(namespacedKey, PersistentDataType.STRING)) {
            persistentDataContainer.set(namespacedKey, PersistentDataType.STRING, value);
            item.setItemMeta(itemMeta);
        }
    }

    public static void setNBT(@Nonnull ItemStack item, @Nonnull NamespacedKey namespacedKey, @Nonnull String value) {
        if (!item.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(namespacedKey, PersistentDataType.STRING, value);
        item.setItemMeta(itemMeta);
    }

    public static void clearNBT(@Nonnull ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        for (NamespacedKey namespacedKey : persistentDataContainer.getKeys()) {
            persistentDataContainer.remove(namespacedKey);
        }
        itemStack.setItemMeta(itemMeta);
    }

    @Nullable
    public static ItemStack cloneWithoutNBT(@Nullable ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        if (!itemStack.hasItemMeta()) {
            return new ItemStack(itemStack);
        }
        ItemStack result = new ItemStack(itemStack);
        ItemStackUtil.clearNBT(result);
        return result;
    }

    public static @org.jetbrains.annotations.Nullable ItemStack getDried(@Nonnull ItemStack item) {
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            return null;
        }
        return switch (item.getType()) {
            case POTION, DRAGON_BREATH, HONEY_BOTTLE -> new ItemStack(Material.GLASS_BOTTLE, 1);
            case WATER_BUCKET, LAVA_BUCKET, MILK_BUCKET -> new ItemStack(Material.BUCKET, 1);
            default -> null;
        };
    }

    /**
     * Transfer #{@link ItemStack} to #{@link String}
     */
    @Nonnull
    public static String itemStackToString(@Nonnull ItemStack itemStack) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.set("item", itemStack);
        return yamlConfiguration.saveToString();
    }

    /**
     * Transfer #{@link String} to #{@link ItemStack}
     */
    @Nullable
    public static ItemStack stringToItemStack(@Nonnull String local) {
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.loadFromString(local);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return yamlConfiguration.getItemStack("item");
    }

    public static String color(@org.jetbrains.annotations.Nullable String str) {
        if (str == null) {
            return null;
        }
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static void giveOrDropItem(@NotNull Player p, @NotNull ItemStack toGive) {
        for (int i = 0; i < 64; i++) {
            if (toGive.getAmount() <= 0) {
                return;
            }
            ItemStack incoming = toGive.clone();
            incoming.setAmount(Math.min(toGive.getMaxStackSize(), toGive.getAmount()));
            toGive.setAmount(toGive.getAmount() - incoming.getAmount());
            Collection<ItemStack> leftover = p.getInventory().addItem(incoming).values();
            for (ItemStack itemStack : leftover) {
                p.getWorld().dropItemNaturally(p.getLocation(), itemStack);
            }
        }
    }

    public static void send(@NotNull CommandSender p, String message) {
        p.sendMessage(color("&7[&6ClayTech&7] &r" + message));
    }

    public static @NotNull ItemStack getPreEnchantedItemStack(@NotNull Material material) {
        return getPreEnchantedItemStack(material, true);
    }

    @Nonnull
    @SafeVarargs
    public static ItemStack getPreEnchantedItemStack(@NotNull Material material, boolean hide, @Nonnull Pair<Enchantment, Integer>... enchantments) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        for (Pair<Enchantment, Integer> pair : enchantments) {
            itemMeta.addEnchant(pair.getFirstValue(), pair.getSecondValue(), true);
        }
        if (hide) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Nonnull
    public static List<String> getLore(@org.jetbrains.annotations.Nullable ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return new ArrayList<>();
        }

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return new ArrayList<>();
        }

        List<String> lore = meta.getLore();
        if (lore == null) {
            return new ArrayList<>();
        }

        return lore;
    }

    @Nullable
    public static ItemStack setLoreList(@org.jetbrains.annotations.Nullable ItemStack itemStack, List<String> lore) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return null;
        }

        ItemStack copy = itemStack.clone();

        ItemMeta meta = copy.getItemMeta();
        if (meta == null) {
            return null;
        }

        meta.setLore(lore);
        copy.setItemMeta(meta);
        return copy;
    }

    public static ItemStack setLoreList(ItemStack itemStack, String[] lore) {
        return setLoreList(itemStack, new ArrayList<>(List.of(lore)));
    }

    public static @NotNull List<String> getLoreList(ItemStack itemStack) {
        return getLore(itemStack);
    }

    public static ItemStack addLore(@org.jetbrains.annotations.Nullable ItemStack itemStack, String lore) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return null;
        }

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return null;
        }

        List<String> loreList = meta.getLore();
        if (loreList == null) {
            loreList = new ArrayList<>();
        }

        loreList.add(lore);
        meta.setLore(loreList);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack addLore(@org.jetbrains.annotations.Nullable ItemStack itemStack, @NotNull List<String> lore) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return null;
        }

        ItemMeta meta = itemStack.getItemMeta();
        if (meta == null) {
            return null;
        }

        List<String> loreList = meta.getLore();
        if (loreList == null) {
            loreList = new ArrayList<>();
        }

        loreList.addAll(lore);
        meta.setLore(loreList);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static @NotNull ItemStack setDisplayName(@NotNull ItemStack item, String newDisplayName) {
        ItemStack ret = item.clone();
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(newDisplayName);
        ret.setItemMeta(im);
        return ret;
    }

    public static @NotNull ItemStack setLore(@NotNull ItemStack item, String[] newLore) {
        ItemStack ret = item.clone();
        ItemMeta im = item.getItemMeta();
        im.setLore(Arrays.asList(newLore));
        ret.setItemMeta(im);
        return ret;
    }

    public static void setLore(@NotNull ItemStack item, List<String> newLore) {
        ItemMeta im = item.getItemMeta();
        im.setLore(newLore);
        item.setItemMeta(im);
    }

    public static @NotNull ItemStack setInfo(@NotNull ItemStack item, String displayName, List<String> lore) {
        ItemStack ret = item.clone();
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(displayName);
        im.setLore(lore);
        ret.setItemMeta(im);
        return ret;
    }

    public static @NotNull ItemStack setInfo(@NotNull ItemStack item, String displayName, String[] lore) {
        ItemStack ret = item.clone();
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(displayName);
        im.setLore(Arrays.asList(lore));
        ret.setItemMeta(im);
        return ret;
    }

    public static void addEnchantment(@NotNull ItemStack item, @NotNull Enchantment ench, int lvl) {
        item.addUnsafeEnchantment(ench, lvl);
    }
}
