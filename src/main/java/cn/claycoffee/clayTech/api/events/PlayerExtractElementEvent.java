package cn.claycoffee.clayTech.api.events;

import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player extracted a item. 当一个玩家使用元素提取器提取元素成功的时候触发.
 */
public class PlayerExtractElementEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Block machine;
    private final ItemStack[] recipe;
    private final ItemStack element;

    public PlayerExtractElementEvent(Block machine, ItemStack[] recipe, ItemStack element) {
        this.recipe = recipe;
        this.element = element;
        this.machine = machine;
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * @return the recipe.合成配方
     */
    public ItemStack[] getRecipe() {
        return recipe;
    }

    /**
     * @return the element just extracted.刚刚提取成功的元素
     */
    public ItemStack getElement() {
        return element;
    }

    /**
     * @return the machine extracted the element.提取元素的机器
     */
    public Block getMachine() {
        return machine;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
