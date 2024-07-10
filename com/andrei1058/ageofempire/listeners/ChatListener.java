/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ 
/*    */ public class ChatListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void c(AsyncPlayerChatEvent e) {
/* 16 */     if (Main.SETUP)
/* 17 */       return;  if (Main.STATUS == Status.PLAYING) {
/* 18 */       if (e.getMessage().startsWith("!")) {
/* 19 */         e.setFormat(Messages.getMsg("chat.lobby").replace("{v_prefix}", getPrefix(e.getPlayer())).replace("{v_suffix}", getSuffix(e.getPlayer())).replace("{player}", e.getPlayer().getDisplayName()).replace("{message}", e.getMessage().replaceFirst("!", "")));
/*    */       } else {
/* 21 */         e.getRecipients().clear();
/* 22 */         if (Main.bluePlayers.contains(e.getPlayer())) {
/* 23 */           e.getRecipients().addAll(Main.bluePlayers);
/* 24 */           e.setFormat(Messages.getMsg("chat.game").replace("{v_prefix}", getPrefix(e.getPlayer())).replace("{v_suffix}", getSuffix(e.getPlayer())).replace("{player}", "§9" + e.getPlayer().getDisplayName()).replace("{message}", e.getMessage()));
/* 25 */         } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 26 */           e.getRecipients().addAll(Main.greenPlayers);
/* 27 */           e.setFormat(Messages.getMsg("chat.game").replace("{v_prefix}", getPrefix(e.getPlayer())).replace("{v_suffix}", getSuffix(e.getPlayer())).replace("{player}", "§a" + e.getPlayer().getDisplayName()).replace("{message}", e.getMessage()));
/* 28 */         } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 29 */           e.getRecipients().addAll(Main.yellowPlayers);
/* 30 */           e.setFormat(Messages.getMsg("chat.game").replace("{v_prefix}", getPrefix(e.getPlayer())).replace("{v_suffix}", getSuffix(e.getPlayer())).replace("{player}", "§e" + e.getPlayer().getDisplayName()).replace("{message}", e.getMessage()));
/* 31 */         } else if (Main.redPlayers.contains(e.getPlayer())) {
/* 32 */           e.getRecipients().addAll(Main.redPlayers);
/* 33 */           e.setFormat(Messages.getMsg("chat.game").replace("{v_prefix}", getPrefix(e.getPlayer())).replace("{v_suffix}", getSuffix(e.getPlayer())).replace("{player}", "§c" + e.getPlayer().getDisplayName()).replace("{message}", e.getMessage()));
/*    */         } 
/*    */       } 
/*    */     } else {
/* 37 */       e.setFormat(Messages.getMsg("chat.lobby").replace("{v_prefix}", getPrefix(e.getPlayer())).replace("{v_suffix}", getSuffix(e.getPlayer())).replace("{player}", e.getPlayer().getDisplayName()).replace("{message}", e.getMessage()));
/*    */     } 
/*    */   }
/*    */   private static String getPrefix(Player p) {
/* 41 */     if (Main.vaultHook.booleanValue()) {
/* 42 */       return Main.chat.getPlayerPrefix(p).replace('&', '§');
/*    */     }
/* 44 */     return "";
/*    */   }
/*    */   
/*    */   private static String getSuffix(Player p) {
/* 48 */     if (Main.vaultHook.booleanValue()) {
/* 49 */       return Main.chat.getPlayerSuffix(p).replace('&', '§');
/*    */     }
/* 51 */     return "";
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\ChatListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */