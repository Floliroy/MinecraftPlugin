package tld.floliroy.plugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
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
	
	@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
	public void onBlockBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        event.getPlayer().sendMessage("Tu as cassé un " + block.getType().name());
    }
	
	
}
