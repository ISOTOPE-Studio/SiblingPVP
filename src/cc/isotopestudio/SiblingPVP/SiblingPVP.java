package cc.isotopestudio.SiblingPVP;

import cc.isotopestudio.SiblingPVP.command.SPVPCommand;
import cc.isotopestudio.SiblingPVP.listener.PvPListener;
import cc.isotopestudio.SiblingPVP.util.PluginFile;
import me.NoChance.PvPManager.Managers.PlayerHandler;
import me.NoChance.PvPManager.PvPManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SiblingPVP extends JavaPlugin {

    private static final String pluginName = "SiblingPVP";
    public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
            .append("PvP").append("]").append(ChatColor.RED).toString();

    public static PluginFile config;
    public static PluginFile data;

    private PvPManager pvp;
    public static PlayerHandler pHandler;

    @Override
    public void onEnable() {
//        pvp = (PvPManager) Bukkit.getPluginManager().getPlugin("PvPManager");
//        if (pvp == null) {
//            getLogger().warning(pluginName + "无法加载!");
//            getLogger().warning("没有安装 PvPManager");
//            Bukkit.getPluginManager().disablePlugin(this);
//            return;
//        }

        pHandler = new PlayerHandler(pvp);

        this.getCommand("spvp").setExecutor(new SPVPCommand());
        Bukkit.getPluginManager().registerEvents(new PvPListener(), this);

        config = new PluginFile(this, "config.yml", "config.yml");
        data = new PluginFile(this, "data.yml");

        getLogger().info(pluginName + "成功加载!");
        getLogger().info(pluginName + "由ISOTOPE Studio制作!");
        getLogger().info("http://isotopestudio.cc");
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName + "成功卸载!");
    }

}
