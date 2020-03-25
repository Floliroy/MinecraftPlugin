package tld.floliroy.plugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MyListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        event.getPlayer().sendMessage("Tu as cassé un " + block.getType().name());
        
        if(block.getType() == Material.GRASS) {
        	event.setCancelled(true);
        }else {
            block.setType(Material.AIR);
            dropItemsNaturally(block, Material.DIAMOND, 64);
        }
    }
	
	private void dropItemsNaturally(Block block, Material material, Integer nombre) {
		for(int i=0 ; i<nombre ; i++) {
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(material));
        }
	}
	
}
