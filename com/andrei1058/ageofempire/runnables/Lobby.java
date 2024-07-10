/*    */ package com.andrei1058.ageofempire.runnables;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.configuration.Settings;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class Lobby
/*    */   extends BukkitRunnable
/*    */ {
/* 18 */   private static int last = Main.lobby_time;
/*    */   
/*    */   public void run() {
/* 21 */     if (Main.lobby_time != 0) {
/* 22 */       Main.lobby_time--;
/*    */     }
/* 24 */     if (Main.min_players > Bukkit.getOnlinePlayers().size()) {
/* 25 */       cancel();
/* 26 */       Main.STATUS = Status.LOBBY;
/* 27 */       Main.lobby_time = Settings.load().getInt("countdowns.lobby");
/*    */       return;
/*    */     } 
/* 30 */     if (Main.lobby_time != 0 && (last == Main.lobby_time || Main.lobby_time == last - 10 || Main.lobby_time < 6)) {
/* 31 */       last -= 10;
/* 32 */       Bukkit.broadcastMessage(Messages.getMsg("game-start").replace("{time}", String.valueOf(Main.lobby_time)));
/* 33 */       for (Player p : Bukkit.getOnlinePlayers()) {
/* 34 */         p.getWorld().playSound(p.getLocation(), Main.nms.click(), 1.0F, 1.0F);
/*    */       }
/*    */     } 
/* 37 */     if (Main.lobby_time == 0) {
/* 38 */       cancel();
/* 39 */       Main.STATUS = Status.PRE_GAME;
/*    */       
/* 41 */       ItemStack blue = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
/* 42 */       ItemMeta bluemeta = blue.getItemMeta();
/* 43 */       bluemeta.setDisplayName(Messages.getMsg("team-choosing.blue"));
/* 44 */       blue.setItemMeta(bluemeta);
/*    */       
/* 46 */       ItemStack green = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
/* 47 */       ItemMeta greenmeta = green.getItemMeta();
/* 48 */       greenmeta.setDisplayName(Messages.getMsg("team-choosing.green"));
/* 49 */       green.setItemMeta(greenmeta);
/*    */       
/* 51 */       ItemStack yellow = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
/* 52 */       ItemMeta yellowmeta = yellow.getItemMeta();
/* 53 */       yellowmeta.setDisplayName(Messages.getMsg("team-choosing.yellow"));
/* 54 */       yellow.setItemMeta(yellowmeta);
/*    */       
/* 56 */       ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
/* 57 */       ItemMeta redmeta = red.getItemMeta();
/* 58 */       redmeta.setDisplayName(Messages.getMsg("team-choosing.red"));
/* 59 */       red.setItemMeta(redmeta);
/*    */       
/* 61 */       for (Player p : Bukkit.getOnlinePlayers()) {
/* 62 */         p.getInventory().clear();
/* 63 */         if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 3) {
/* 64 */           p.getInventory().setItem(0, blue);
/* 65 */           p.getInventory().setItem(1, green);
/* 66 */           p.getInventory().setItem(2, yellow);
/* 67 */           p.getInventory().setItem(3, red); continue;
/* 68 */         }  if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 2) {
/* 69 */           p.getInventory().setItem(0, blue);
/* 70 */           p.getInventory().setItem(1, green);
/* 71 */           p.getInventory().setItem(2, yellow); continue;
/*    */         } 
/* 73 */         p.getInventory().setItem(0, blue);
/* 74 */         p.getInventory().setItem(1, green);
/*    */       } 
/*    */       
/* 77 */       (new PreGame()).runTaskTimer((Plugin)Main.plugin, 0L, 20L);
/* 78 */       Main.nms.registerVillagers();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\runnables\Lobby.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */