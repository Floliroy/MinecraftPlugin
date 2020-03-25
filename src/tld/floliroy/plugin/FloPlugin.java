package tld.floliroy.plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class FloPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Je démarre");
		getServer().getPluginManager().registerEvents(new MyListener(), this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Je m'éteint");
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("mycommand")) {
            sender.sendMessage("You ran /mycommand!");
            return true;
        }
        if (command.getName().equals("diamond")) {
            sender.sendMessage("TU ES RICHE !!!");
            Player player = (Player) sender;
            player.getInventory().addItem(new ItemStack(Material.DIAMOND));
            return true;
        }
        return false;
    }
	
}
