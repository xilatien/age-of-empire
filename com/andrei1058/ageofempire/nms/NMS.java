package com.andrei1058.ageofempire.nms;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;

public interface NMS {
  void registerVillagers();
  
  void actionMsg(Player paramPlayer, String paramString);
  
  Sound witherDeath();
  
  Sound levelUp();
  
  Sound wolfDeath();
  
  Sound click();
  
  Villager spawnVillager(Location paramLocation, Integer paramInteger);
  
  ItemStack itemInHand(Player paramPlayer);
}


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\nms\NMS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */