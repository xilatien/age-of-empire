/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.configuration.Settings;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import com.google.common.io.ByteArrayDataOutput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerLoginEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class PlayerLoginListener implements Listener {
/*    */   @EventHandler
/*    */   public void l(PlayerLoginEvent e) {
/* 19 */     if (Main.SETUP)
/* 20 */       return;  if (Bukkit.getOnlinePlayers().size() == Main.max_in_team * 4) {
/* 21 */       if (e.getPlayer().hasPermission("aoe.vipkick")) {
/* 22 */         boolean allow = false;
/* 23 */         for (Player p : Bukkit.getOnlinePlayers()) {
/* 24 */           if (!p.hasPermission("ageofempire.vipkick")) {
/* 25 */             allow = true;
/* 26 */             p.sendMessage(Messages.getMsg("vip-kick"));
/* 27 */             ByteArrayDataOutput out = ByteStreams.newDataOutput();
/* 28 */             out.writeUTF("Connect");
/* 29 */             out.writeUTF(Settings.load().getString("lobby-server"));
/* 30 */             p.sendPluginMessage((Plugin)Main.plugin, "BungeeCord", out.toByteArray());
/*    */             return;
/*    */           } 
/*    */         } 
/* 34 */         if (!allow) {
/* 35 */           e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You can't join right now!");
/*    */         }
/*    */       } else {
/* 38 */         e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You can't join right now!");
/*    */       } 
/*    */     }
/* 41 */     if (Main.STATUS != Status.LOBBY && Main.STATUS != Status.STARTING)
/* 42 */       e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You can't join right now!"); 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerLoginListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */