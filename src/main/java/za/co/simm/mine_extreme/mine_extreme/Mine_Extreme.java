package za.co.simm.mine_extreme.mine_extreme;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mine_Extreme extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[Mine_Extreme] Enabling the plugin");
        new Mine_ExtremeBlockListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[Mine_Extreme] Disabling the plugin");
    }
}
