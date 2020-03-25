package tld.floliroy.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class FloPlugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Je démarre");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Je m'éteint");
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mycommand")) {
            sender.sendMessage("You ran /mycommand!");
            return true;
        }
        return false;
    }
}
