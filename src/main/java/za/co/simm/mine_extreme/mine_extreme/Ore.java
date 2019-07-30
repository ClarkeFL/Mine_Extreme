package za.co.simm.mine_extreme.mine_extreme;

import com.google.common.collect.ImmutableList;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class Ore {

    final static Collection<BlockFace> directions = ImmutableList.of(
            BlockFace.UP,
            BlockFace.DOWN,
            BlockFace.NORTH,
            BlockFace.EAST,
            BlockFace.SOUTH,
            BlockFace.WEST,
            BlockFace.NORTH_EAST,
            BlockFace.SOUTH_EAST,
            BlockFace.NORTH_WEST,
            BlockFace.SOUTH_WEST
    );
    final static int max = 1024;
    final Collection<Block> visited = new ArrayList<>();
    int ore = 0;
    int call = 0;
    int experience = 0;

    public Ore(final Block block) {
        get(block);
        if (isOre()) {
            destroy(block);
        }
    }

    void get(final Block block) {

        call++;

        if (call >= max) {
            return;
        }

        if (block.getType() == Material.AIR) {
            return;
        }

        if (visited.contains(block)) {
            return;
        }

        if (block.getType() == Material.COAL_ORE || block.getType() == Material.DIAMOND_ORE ||
                block.getType() == Material.EMERALD_ORE || block.getType() == Material.GOLD_ORE ||
                block.getType() == Material.IRON_ORE || block.getType() == Material.LAPIS_ORE ||
                block.getType() == Material.NETHER_QUARTZ_ORE || block.getType() == Material.REDSTONE_ORE) {
            visited.add(block);

            for(BlockFace face : BlockFace.values()) {
                //Check if the adjacent block relative to this face is a ORE
                if(block.getRelative(face).getType() == Material.COAL_ORE ||
                        block.getRelative(face).getType() == Material.DIAMOND_ORE ||
                        block.getRelative(face).getType() == Material.EMERALD_ORE ||
                        block.getRelative(face).getType() == Material.GOLD_ORE ||
                        block.getRelative(face).getType() == Material.IRON_ORE ||
                        block.getRelative(face).getType() == Material.LAPIS_ORE ||
                        block.getRelative(face).getType() == Material.NETHER_QUARTZ_ORE ||
                        block.getRelative(face).getType() == Material.REDSTONE_ORE) {
                    visited.add(block);
                    break;
                }
            }

            for (BlockFace direction : directions) {
                get(block.getRelative(direction));
            }
            ore++;
        }

    }

    boolean isOre() { return ore >= 1; }

    void destroy(final Block block) {
        visited.forEach((Block) -> {
            if (block.getType() == Material.COAL_ORE) {
                block.getWorld().spawn(block.getLocation().add(0, 1, 0), ExperienceOrb.class).setExperience(1);
            }
            if (block.getType() == Material.IRON_ORE) {
                block.getWorld().spawn(block.getLocation().add(0, 1, 0), ExperienceOrb.class).setExperience(2);
            }
            if (block.getType() == Material.GOLD_ORE) {
                block.getWorld().spawn(block.getLocation().add(0, 1, 0), ExperienceOrb.class).setExperience(2);
            }
            if (block.getType() == Material.NETHER_QUARTZ_ORE) {
                block.getWorld().spawn(block.getLocation().add(0, 1, 0), ExperienceOrb.class).setExperience(3);
            }
            if (block.getType() == Material.REDSTONE_ORE) {
                block.getWorld().spawn(block.getLocation().add(0, 1, 0), ExperienceOrb.class).setExperience(3);
            }
            if (block.getType() == Material.LAPIS_ORE) {
                block.getWorld().spawn(block.getLocation().add(0, 1, 0), ExperienceOrb.class).setExperience(3);
            }
            if (block.getType() == Material.DIAMOND_ORE) {
                block.getWorld().spawn(block.getLocation().add(0, 1, 0), ExperienceOrb.class).setExperience(5);
            }
            if (block.getType() == Material.EMERALD_ORE) {
                block.getWorld().spawn(block.getLocation().add(0, 1, 0), ExperienceOrb.class).setExperience(5);
            }
        });
        visited.forEach(Block::breakNaturally);
    }
}
