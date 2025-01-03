package cn.claycoffee.clayTech.core.worlds;

import cn.claycoffee.clayTech.api.objects.Planet;
import cn.claycoffee.clayTech.core.worlds.decorators.MoonClayFusionOrePopulator;
import cn.claycoffee.clayTech.core.worlds.decorators.MoonCoalPopulator;
import cn.claycoffee.clayTech.core.worlds.decorators.MoonCopperOrePopulator;
import cn.claycoffee.clayTech.core.worlds.decorators.MoonDiamondPopulator;
import cn.claycoffee.clayTech.core.worlds.decorators.MoonKreepPopulator;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Moon extends ChunkGenerator {
    private SimplexOctaveGenerator sog;

    public Moon() {
        new Planet("CMoon", new CustomItemStack(Material.GRAY_GLAZED_TERRACOTTA, Lang.readPlanetsText("Moon")), this,
                Environment.NORMAL, false, 0.165D, 384000, 1, true, 10).register();
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int chunkX, int chunkZ, @NotNull BiomeGrid biome) {
        ChunkData chunkData = createChunkData(world);
        if (sog == null) {
            sog = new SimplexOctaveGenerator(world.getSeed(), 1);
            sog.setScale(0.0025D);
        }
        // 最低一层为基岩
        chunkData.setRegion(0, 0, 0, 16, 1, 16, Material.BEDROCK);
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int realX = chunkX * 16 + x;
                int realZ = chunkZ * 16 + z;
                double noiseValue = sog.noise(realX, realZ, Math.random(), Math.random());
                int height;
                height = (int) (Math.pow(noiseValue, 2) * 40D + 90D);
                for (int y = 1; y < height; y++) {
                    chunkData.setBlock(x, y, z, Material.STONE);
                }
                if (height <= 66) {
                    for (; height <= 66; height++) {
                        chunkData.setBlock(x, height, z, Material.LAVA);
                    }
                } else {
                    chunkData.setBlock(x, height, z, Material.END_STONE);
                }
                biome.setBiome(x, z, Biome.THE_END);

            }
        }
        return chunkData;
    }

    @Override
    public @NotNull List<BlockPopulator> getDefaultPopulators(World world) {
        List<BlockPopulator> ret = new ArrayList<>();
        ret.add(new MoonCoalPopulator());
        ret.add(new MoonDiamondPopulator());
        // Check enabled ores then add its populator to the list
        ret.add(new MoonKreepPopulator());
        ret.add(new MoonCopperOrePopulator());
        ret.add(new MoonClayFusionOrePopulator());
        return ret;
    }
}
