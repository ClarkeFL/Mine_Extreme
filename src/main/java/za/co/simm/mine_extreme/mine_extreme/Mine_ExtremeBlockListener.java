package za.co.simm.mine_extreme.mine_extreme;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Mine_ExtremeBlockListener implements Listener {

    public Mine_ExtremeBlockListener(final Mine_Extreme instance) {
        Bukkit.getServer().getPluginManager().registerEvents(this, instance);
    }

    @EventHandler(ignoreCancelled = true)
    @SuppressWarnings("unused")
    void onBlockBreak(final BlockBreakEvent event) {
        Block block = event.getBlock();
        if (isOre_block(block)) {
            new Ore(block);
        }
    }

    boolean isOre_block(final Block block) {
        return block.getType() == Material.COAL_ORE || block.getType() == Material.DIAMOND_ORE ||
                block.getType() == Material.EMERALD_ORE || block.getType() == Material.GOLD_ORE ||
                block.getType() == Material.IRON_ORE || block.getType() == Material.LAPIS_ORE ||
                block.getType() == Material.NETHER_QUARTZ_ORE || block.getType() == Material.REDSTONE_ORE;
    }

}
