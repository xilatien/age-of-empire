/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.Misc;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.configuration.Settings;
/*    */ import com.andrei1058.ageofempire.configuration.Updater;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import com.andrei1058.ageofempire.locations.Locations;
/*    */ import com.andrei1058.ageofempire.runnables.Lobby;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerJoinListener
/*    */   implements Listener
/*    */ {
/* 28 */   public static String hehe = "%%__USER__%%";
/* 29 */   public static String hehe2 = "%%__NONCE__%%";
/*    */   
/*    */   @EventHandler
/*    */   public void j(PlayerJoinEvent e) {
/* 33 */     if (Main.SETUP)
/* 34 */       return;  Player p = e.getPlayer();
/* 35 */     e.setJoinMessage(null);
/* 36 */     switch (Main.STATUS) {
/*    */       case LOBBY:
/* 38 */         lobbyItems(p);
/* 39 */         if (Bukkit.getOnlinePlayers().size() == Main.min_players) {
/* 40 */           Main.STATUS = Status.STARTING;
/* 41 */           (new Lobby()).runTaskTimer((Plugin)Main.plugin, 0L, 20L);
/*    */         } 
/* 43 */         for (Player p2 : Bukkit.getOnlinePlayers()) {
/* 44 */           Main.nms.actionMsg(p2, Messages.getMsg("action-player-join").replace("{player}", p.getName()));
/*    */         }
/*    */         break;
/*    */       case STARTING:
/* 48 */         lobbyItems(p);
/* 49 */         for (Player p2 : Bukkit.getOnlinePlayers()) {
/* 50 */           Main.nms.actionMsg(p2, Messages.getMsg("action-player-join").replace("{player}", p.getName()));
/*    */         }
/*    */         break;
/*    */     } 
/* 54 */     if (p.getName().equalsIgnoreCase("andrei1058") || p.getName().equalsIgnoreCase("andreea1058")) {
/* 55 */       p.sendMessage(" ");
/* 56 */       p.sendMessage("§9Bukkit v: " + Main.plugin.getServer().getVersion());
/* 57 */       p.sendMessage("§9Pl v: " + Main.plugin.getDescription().getVersion());
/* 58 */       p.sendMessage("§9Pl name: " + Main.plugin.getDescription().getName());
/* 59 */       p.sendMessage("§9UID: " + hehe);
/* 60 */       p.sendMessage("§9UDID: " + hehe2);
/* 61 */       p.sendMessage(" ");
/*    */     } 
/* 63 */     if (p.isOp() && 
/* 64 */       Updater.updateAvailable) {
/* 65 */       p.sendMessage("§9Age of Empire §8> §eThere is a new version available. Please update it!");
/* 66 */       p.sendMessage("§3[§f" + Updater.newVersion + "§3] §ahttps://www.spigotmc.org/resources/39573/");
/*    */     } 
/*    */     
/* 69 */     if (Main.plugin.getServer().getOnlineMode() && 
/* 70 */       p.getUniqueId().equals(UUID.fromString("98b59a50-7b46-4fdb-8f05-32f184a0574d"))) {
/* 71 */       Bukkit.broadcastMessage("§3▋ §7The Age of Empire's developer has joined the server (" + p.getName() + ")");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static void lobbyItems(Player p) {
/* 77 */     p.getInventory().clear();
/* 78 */     p.getInventory().setArmorContents(null);
/* 79 */     Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> { p.teleport(Locations.getLoc("Spawns.Lobby")); Bukkit.broadcastMessage(Messages.getMsg("player-join").replace("%player%", p.getName())); p.setHealthScale(20.0D); p.setHealth(20.0D); p.setFoodLevel(20); p.setExp(0.0F); p.setLevel(0); p.setGameMode(GameMode.ADVENTURE); ItemStack help1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5); ItemMeta helpmeta = help1.getItemMeta(); helpmeta.setDisplayName(Messages.getMsg("help-item-on")); help1.setItemMeta(helpmeta); p.getInventory().setItem(4, help1); ItemStack bed = new ItemStack(Material.BED, 1); ItemMeta bedmeta = bed.getItemMeta(); bedmeta.setDisplayName(Messages.getMsg("leave-item")); bed.setItemMeta(bedmeta); p.getInventory().setItem(8, bed); if (Settings.load().getBoolean("Database.enable")) { p.getInventory().setItem(0, Misc.statsItem(p)); } else { p.getInventory().setItem(0, new ItemStack(Material.AIR)); }  p.sendMessage(Messages.getMsg("help.ison")); Main.help.add(p); }1L);
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerJoinListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */