/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.Misc;
/*    */ import com.andrei1058.ageofempire.locations.Locations;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Color;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerRespawnEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class PlayerRespawnListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void r(PlayerRespawnEvent e) {
/* 22 */     if (Main.SETUP)
/* 23 */       return;  Player p = e.getPlayer();
/* 24 */     e.setRespawnLocation(p.getLocation());
/* 25 */     p.setGameMode(GameMode.SPECTATOR);
/*    */     
/* 27 */     Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> { if (Main.bluePlayers.contains(p)) { p.teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Blue")); p.setGameMode(GameMode.SURVIVAL); p.getInventory().setHelmet(Misc.leatherArmor(Material.LEATHER_HELMET, Color.BLUE)); p.getInventory().setChestplate(Misc.leatherArmor(Material.LEATHER_CHESTPLATE, Color.BLUE)); p.getInventory().setBoots(Misc.leatherArmor(Material.LEATHER_BOOTS, Color.BLUE)); p.getInventory().setLeggings(Misc.leatherArmor(Material.LEATHER_LEGGINGS, Color.BLUE)); p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_PICKAXE) }); p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_AXE) }); p.getInventory().setItem(8, Misc.slotlocked()); if (PlayerDeathListener.constructor.contains(p)) { PlayerDeathListener.constructor.remove(p); p.getInventory().setItem(7, Misc.constructor()); } else { p.getInventory().setItem(7, Misc.slotlocked()); }  p.getInventory().setItem(6, Misc.forumPaper()); } else if (Main.greenPlayers.contains(p)) { p.teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Green")); p.setGameMode(GameMode.SURVIVAL); p.getInventory().setHelmet(Misc.leatherArmor(Material.LEATHER_HELMET, Color.GREEN)); p.getInventory().setChestplate(Misc.leatherArmor(Material.LEATHER_CHESTPLATE, Color.GREEN)); p.getInventory().setBoots(Misc.leatherArmor(Material.LEATHER_BOOTS, Color.GREEN)); p.getInventory().setLeggings(Misc.leatherArmor(Material.LEATHER_LEGGINGS, Color.GREEN)); p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_PICKAXE) }); p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_AXE) }); p.getInventory().setItem(8, Misc.slotlocked()); if (PlayerDeathListener.constructor.contains(p)) { PlayerDeathListener.constructor.remove(p); p.getInventory().setItem(7, Misc.constructor()); } else { p.getInventory().setItem(7, Misc.slotlocked()); }  p.getInventory().setItem(6, Misc.forumPaper()); } else if (Main.yellowPlayers.contains(p)) { p.teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Yellow")); p.setGameMode(GameMode.SURVIVAL); p.getInventory().setHelmet(Misc.leatherArmor(Material.LEATHER_HELMET, Color.YELLOW)); p.getInventory().setChestplate(Misc.leatherArmor(Material.LEATHER_CHESTPLATE, Color.YELLOW)); p.getInventory().setBoots(Misc.leatherArmor(Material.LEATHER_BOOTS, Color.YELLOW)); p.getInventory().setLeggings(Misc.leatherArmor(Material.LEATHER_LEGGINGS, Color.YELLOW)); p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_PICKAXE) }); p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_AXE) }); p.getInventory().setItem(8, Misc.slotlocked()); if (PlayerDeathListener.constructor.contains(p)) { PlayerDeathListener.constructor.remove(p); p.getInventory().setItem(7, Misc.constructor()); } else { p.getInventory().setItem(7, Misc.slotlocked()); }  p.getInventory().setItem(6, Misc.forumPaper()); } else if (Main.redPlayers.contains(p)) { p.teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Red")); p.setGameMode(GameMode.SURVIVAL); p.getInventory().setHelmet(Misc.leatherArmor(Material.LEATHER_HELMET, Color.RED)); p.getInventory().setChestplate(Misc.leatherArmor(Material.LEATHER_CHESTPLATE, Color.RED)); p.getInventory().setBoots(Misc.leatherArmor(Material.LEATHER_BOOTS, Color.RED)); p.getInventory().setLeggings(Misc.leatherArmor(Material.LEATHER_LEGGINGS, Color.RED)); p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_PICKAXE) }); p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_AXE) }); p.getInventory().setItem(8, Misc.slotlocked()); if (PlayerDeathListener.constructor.contains(p)) { PlayerDeathListener.constructor.remove(p); p.getInventory().setItem(7, Misc.constructor()); } else { p.getInventory().setItem(7, Misc.slotlocked()); }  p.getInventory().setItem(6, Misc.forumPaper()); } else { Main.players.remove(p); }  }100L);
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerRespawnListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */