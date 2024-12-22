package cn.claycoffee.clayTech.aarewrite.implementation.machines;

import cn.claycoffee.clayTech.aarewrite.api.abstracts.ANewContainer;
import cn.claycoffee.clayTech.utils.Lang;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.machines.MachineProcessor;
import io.github.thebusybiscuit.slimefun4.implementation.operations.CraftingOperation;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: ClayTech
 * @Author: ClayCoffee
 * @Date: 2020/7/20 11:35
 * @Email: 1020757140@qq.com
 * AGPL 3.0
 */

public class ClayElectricCopier extends ANewContainer {
    private static final Map<Block, Integer> mode = new HashMap<>();
    private final MachineProcessor<CraftingOperation> processor = new MachineProcessor<>(this);

    public ClayElectricCopier(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                              ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public MachineProcessor<CraftingOperation> getMachineProcessor() {
        return processor;
    }

    @Override
    public String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_ELECTRIC_COPIER");
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.BOOK);
    }

    @Override
    public int getEnergyConsumption() {
        return 40;
    }

    @Override
    public int getCapacity() {
        return 256;
    }

    // == todo ==
    @Override
    public void constructMenu(BlockMenuPreset preset) {

    }

    @Override
    public MachineRecipe findNextRecipe(BlockMenu inv) {
        return null;
    }

    @Override
    public int[] getInputSlots() {
        return new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return new int[0];
    }

    // == todo ==

    protected void tick(Block b) {
        BlockMenu inv = StorageCacheUtils.getMenu(b.getLocation());
        if (inv == null) {
            return;
        }

        CraftingOperation currentOperation = processor.getOperation(b);

        if (currentOperation != null) {
            if (takeCharge(b.getLocation())) {

                if (!currentOperation.isFinished()) {
                    processor.updateProgressBar(inv, 22, currentOperation);
                    currentOperation.addProgress(1);
                } else {
                    inv.replaceExistingItem(22, new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " "));
                    processor.endOperation(b);
                    inv.addItem(getInputSlots()[0], processor.getOperation(b).getIngredients()[0]);
                }
            }
        } else {
            if (inv.getItemInSlot(19) == null || inv.getItemInSlot(20) == null) return;

            ItemStack input = inv.getItemInSlot(19);
            ItemStack output = inv.getItemInSlot(20);
            if (inv.getItemInSlot(19).getType() == Material.WRITABLE_BOOK && inv.getItemInSlot(20).getType() == Material.WRITABLE_BOOK) {
                // Mode I
                mode.put(b, 1);
            } else if (inv.getItemInSlot(19).getType() == Material.WRITTEN_BOOK && inv.getItemInSlot(20).getType() == Material.WRITABLE_BOOK) {
                // Mode II
                mode.put(b, 2);
            } else if (inv.getItemInSlot(19).getType() == Material.WRITABLE_BOOK && inv.getItemInSlot(20).getType() == Material.WRITTEN_BOOK) {
                // Mode II
                mode.put(b, 2);
            } else mode.put(b, 0);
            if (mode.get(b) > 0) {
                BookMeta sourceMeta = (BookMeta) input.getItemMeta();
                MachineRecipe r;
                if (mode.get(b) == 1) {
                    r = new MachineRecipe(sourceMeta.getPages().size() * 4, new ItemStack[]{}, new ItemStack[]{input});
                } else {
                    BookMeta copyMeta = (BookMeta) output.getItemMeta();
                    copyMeta.setPages(sourceMeta.getPages());
                    copyMeta.setGeneration(BookMeta.Generation.COPY_OF_ORIGINAL);
                    ItemStack c = output.clone();
                    c.setItemMeta(copyMeta);
                    r = new MachineRecipe(sourceMeta.getPages().size() * 4, new ItemStack[]{input}, new ItemStack[]{c});
                }
                processor.startOperation(b, new CraftingOperation(r));
            }
        }
    }
}