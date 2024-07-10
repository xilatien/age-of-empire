/*     */ package com.andrei1058.ageofempire.listeners;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.configuration.MySQL;
/*     */ import com.andrei1058.ageofempire.game.Buildings;
/*     */ import com.andrei1058.ageofempire.game.Status;
/*     */ import com.andrei1058.ageofempire.game.Titles;
/*     */ import com.andrei1058.ageofempire.runnables.Restart;
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ public class PlayerQuitListener
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void q(PlayerQuitEvent e) {
/*  23 */     if (Main.STATUS == Status.LOBBY || Main.STATUS == Status.STARTING) {
/*  24 */       for (Player p2 : Bukkit.getOnlinePlayers()) {
/*  25 */         Main.nms.actionMsg(p2, Messages.getMsg("action-player-left").replace("{player}", e.getPlayer().getName()));
/*     */       }
/*  27 */     } else if (Main.STATUS == Status.PLAYING) {
/*  28 */       if (winner == null) {
/*  29 */         int k = 0;
/*  30 */         int d = 0;
/*  31 */         int kd = 0;
/*  32 */         if (Main.kills.containsKey(e.getPlayer())) {
/*  33 */           k = ((Integer)Main.kills.get(e.getPlayer())).intValue();
/*     */         }
/*  35 */         if (Main.deaths.containsKey(e.getPlayer())) {
/*  36 */           d = ((Integer)Main.deaths.get(e.getPlayer())).intValue();
/*     */         }
/*  38 */         if (Main.kingskilled.containsKey(e.getPlayer())) {
/*  39 */           kd = ((Integer)Main.kingskilled.get(e.getPlayer())).intValue();
/*     */         }
/*  41 */         (new MySQL()).addStats(e.getPlayer().getUniqueId(), 0, 1, k, d, kd);
/*     */       }
/*  43 */       else if (!winner.contains(e.getPlayer())) {
/*  44 */         int k = 0;
/*  45 */         int d = 0;
/*  46 */         int kd = 0;
/*  47 */         if (Main.kills.containsKey(e.getPlayer())) {
/*  48 */           k = ((Integer)Main.kills.get(e.getPlayer())).intValue();
/*     */         }
/*  50 */         if (Main.deaths.containsKey(e.getPlayer())) {
/*  51 */           d = ((Integer)Main.deaths.get(e.getPlayer())).intValue();
/*     */         }
/*  53 */         if (Main.kingskilled.containsKey(e.getPlayer())) {
/*  54 */           kd = ((Integer)Main.kingskilled.get(e.getPlayer())).intValue();
/*     */         }
/*  56 */         (new MySQL()).addStats(e.getPlayer().getUniqueId(), 0, 1, k, d, kd);
/*     */       } 
/*     */     } 
/*     */     
/*  60 */     Player p = e.getPlayer();
/*  61 */     if (Main.SETUP)
/*  62 */       return;  e.setQuitMessage(null);
/*  63 */     Main.players.remove(p);
/*  64 */     Main.bluePlayers.remove(p);
/*  65 */     Main.greenPlayers.remove(p);
/*  66 */     Main.yellowPlayers.remove(p);
/*  67 */     Main.redPlayers.remove(p);
/*  68 */     Buildings.construct_in_inv.remove(p);
/*  69 */     Main.help.remove(p);
/*  70 */     checkWinner();
/*     */   }
/*  72 */   public static ArrayList winner = null;
/*     */   public static void checkWinner() {
/*  74 */     if (winner != null)
/*  75 */       return;  if (Main.STATUS == Status.LOBBY || Main.STATUS == Status.STARTING || Main.STATUS == Status.PRE_GAME)
/*  76 */       return;  Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> { if (!Main.bluePlayers.isEmpty() && Main.greenPlayers.isEmpty() && Main.redPlayers.isEmpty() && Main.yellowPlayers.isEmpty()) { for (Player p : Bukkit.getOnlinePlayers()) Titles.sendFullTitle(p, Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(0), Messages.getMsg("victory.blue"), "");  for (Player p : Main.bluePlayers) { int k = 0; int d = 0; int kd = 0; if (Main.kills.containsKey(p)) k = ((Integer)Main.kills.get(p)).intValue();  if (Main.deaths.containsKey(p)) d = ((Integer)Main.deaths.get(p)).intValue();  if (Main.kingskilled.containsKey(p)) kd = ((Integer)Main.kingskilled.get(p)).intValue();  (new MySQL()).addStats(p.getUniqueId(), 1, 1, k, d, kd); }  winner = Main.bluePlayers; Bukkit.broadcastMessage(Main.PREFIX + " " + Messages.getMsg("victory.blue")); stopserver(); } else if (Main.redPlayers.isEmpty() && !Main.greenPlayers.isEmpty() && Main.bluePlayers.isEmpty() && Main.yellowPlayers.isEmpty()) { for (Player p : Bukkit.getOnlinePlayers()) Titles.sendFullTitle(p, Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(0), Messages.getMsg("victory.green"), "");  for (Player p : Main.greenPlayers) { int k = 0; int d = 0; int kd = 0; if (Main.kills.containsKey(p)) k = ((Integer)Main.kills.get(p)).intValue();  if (Main.deaths.containsKey(p)) d = ((Integer)Main.deaths.get(p)).intValue();  if (Main.kingskilled.containsKey(p)) kd = ((Integer)Main.kingskilled.get(p)).intValue();  (new MySQL()).addStats(p.getUniqueId(), 1, 1, k, d, kd); }  winner = Main.greenPlayers; Bukkit.broadcastMessage(Main.PREFIX + " " + Messages.getMsg("victory.green")); stopserver(); } else if (Main.bluePlayers.isEmpty() && Main.greenPlayers.isEmpty() && !Main.redPlayers.isEmpty() && Main.yellowPlayers.isEmpty()) { for (Player p : Bukkit.getOnlinePlayers()) Titles.sendFullTitle(p, Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(0), Messages.getMsg("victory.red"), "");  for (Player p : Main.redPlayers) { int k = 0; int d = 0; int kd = 0; if (Main.kills.containsKey(p)) k = ((Integer)Main.kills.get(p)).intValue();  if (Main.deaths.containsKey(p)) d = ((Integer)Main.deaths.get(p)).intValue();  if (Main.kingskilled.containsKey(p)) kd = ((Integer)Main.kingskilled.get(p)).intValue();  (new MySQL()).addStats(p.getUniqueId(), 1, 1, k, d, kd); }  winner = Main.greenPlayers; Bukkit.broadcastMessage(Main.PREFIX + " " + Messages.getMsg("victory.red")); stopserver(); } else if (Main.bluePlayers.isEmpty() && Main.greenPlayers.isEmpty() && Main.redPlayers.isEmpty() && !Main.yellowPlayers.isEmpty()) { for (Player p : Bukkit.getOnlinePlayers()) Titles.sendFullTitle(p, Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(0), Messages.getMsg("victory.yellow"), "");  for (Player p : Main.yellowPlayers) { int k = 0; int d = 0; int kd = 0; if (Main.kills.containsKey(p)) k = ((Integer)Main.kills.get(p)).intValue();  if (Main.deaths.containsKey(p)) d = ((Integer)Main.deaths.get(p)).intValue();  if (Main.kingskilled.containsKey(p)) kd = ((Integer)Main.kingskilled.get(p)).intValue();  (new MySQL()).addStats(p.getUniqueId(), 1, 1, k, d, kd); }  winner = Main.yellowPlayers; Bukkit.broadcastMessage(Main.PREFIX + " " + Messages.getMsg("victory.yellow")); stopserver(); } else if (Bukkit.getOnlinePlayers().isEmpty()) { stopserver(); }  }5L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void stopserver() {
/* 173 */     (new Restart()).runTaskTimer((Plugin)Main.plugin, 0L, 20L);
/* 174 */     Main.STATUS = Status.RESTARTING;
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerQuitListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */