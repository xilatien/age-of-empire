/*     */ package com.andrei1058.ageofempire.runnables;
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.commands.Stuck;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.configuration.Settings;
/*     */ import com.andrei1058.ageofempire.game.Hologram;
/*     */ import com.andrei1058.ageofempire.game.OreHologram;
/*     */ import com.andrei1058.ageofempire.game.Scoreboard;
/*     */ import com.andrei1058.ageofempire.game.Vote;
/*     */ import com.andrei1058.ageofempire.locations.Locations;
/*     */ import java.util.Map;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ public class Game extends BukkitRunnable {
/*  21 */   public static int secPlayed = 0;
/*  22 */   private static int stonecheck = 3;
/*  23 */   private static int holo = 30;
/*     */   public static boolean blue_change_age = false;
/*     */   public static boolean green_change_age = false;
/*     */   public static boolean yellow_change_age = false;
/*     */   public static boolean red_change_age = false;
/*     */   
/*     */   public void run() {
/*  30 */     secPlayed++;
/*  31 */     if (secPlayed == 2) {
/*  32 */       for (Player u : Main.help) {
/*  33 */         u.sendMessage(Messages.getMsg("help.start-guide"));
/*  34 */         u.sendMessage(Messages.getMsg("help.start-buildings"));
/*  35 */         u.sendMessage(Messages.getMsg("help.start-resources"));
/*     */       } 
/*     */     }
/*  38 */     if (secPlayed == stonecheck) {
/*  39 */       stonecheck += 3;
/*  40 */       if (Main.blue_stonemine) {
/*  41 */         Main.blue_stone += 3;
/*     */       }
/*  43 */       if (Main.yellow_stonemine) {
/*  44 */         Main.yellow_stone += 3;
/*     */       }
/*  46 */       if (Main.red_stonemine) {
/*  47 */         Main.red_stone += 3;
/*     */       }
/*  49 */       if (Main.green_stonemine) {
/*  50 */         Main.green_stone += 3;
/*     */       }
/*  52 */       if (Main.blue_goldmine) {
/*  53 */         for (Player u : Main.bluePlayers) {
/*  54 */           Main.gold.replace(u, Integer.valueOf(((Integer)Main.gold.get(u)).intValue() + 3));
/*     */         }
/*     */       }
/*  57 */       if (Main.yellow_goldmine) {
/*  58 */         for (Player u : Main.yellowPlayers) {
/*  59 */           Main.gold.replace(u, Integer.valueOf(((Integer)Main.gold.get(u)).intValue() + 3));
/*     */         }
/*     */       }
/*  62 */       if (Main.green_goldmine) {
/*  63 */         for (Player u : Main.greenPlayers) {
/*  64 */           Main.gold.replace(u, Integer.valueOf(((Integer)Main.gold.get(u)).intValue() + 3));
/*     */         }
/*     */       }
/*  67 */       if (Main.red_goldmine) {
/*  68 */         for (Player u : Main.redPlayers) {
/*  69 */           Main.gold.replace(u, Integer.valueOf(((Integer)Main.gold.get(u)).intValue() + 3));
/*     */         }
/*     */       }
/*  72 */       if (Main.blue_sawmill) {
/*  73 */         Main.blue_wood += 3;
/*     */       }
/*  75 */       if (Main.green_sawmill) {
/*  76 */         Main.green_wood += 3;
/*     */       }
/*  78 */       if (Main.yellow_sawmill) {
/*  79 */         Main.yellow_wood += 3;
/*     */       }
/*  81 */       if (Main.red_sawmill)
/*  82 */         Main.red_wood += 3; 
/*     */     } 
/*  84 */     if (!Main.assualt) {
/*  85 */       Main.pvp_assault -= 1000L;
/*  86 */       if (Main.pvp_assault == 0L) {
/*  87 */         if (!Main.pvp) {
/*  88 */           Bukkit.broadcastMessage(Messages.getMsg("pvp-on"));
/*  89 */           Main.pvp = true;
/*  90 */           Main.pvp_assault = (60000 * Settings.load().getInt("countdowns.assault"));
/*  91 */           for (Player u : Main.players) {
/*  92 */             u.playSound(u.getLocation(), Main.nms.wolfDeath(), 1.0F, 1.0F);
/*  93 */             u.getScoreboard().getTeam("pvp_assault").setPrefix(Messages.getMsg("scoreboard.3_2"));
/*     */           } 
/*  95 */           for (String st : Locations.load().getConfigurationSection("xp." + Main.choosenMap).getKeys(false)) {
/*  96 */             Block b = Bukkit.getWorld(Main.choosenMap).getBlockAt(Locations.getLoc("xp." + Main.choosenMap + "." + st));
/*  97 */             b.setType(Material.SEA_LANTERN);
/*  98 */             Main.xp.add(new Location(Bukkit.getWorld(Main.choosenMap), b.getLocation().getBlockX(), b.getLocation().getBlockY(), b.getLocation().getBlockZ()));
/*     */           }
/*     */         
/* 101 */         } else if (!Main.assualt) {
/* 102 */           Main.assualt = true;
/* 103 */           Bukkit.broadcastMessage(Messages.getMsg("assaults-on"));
/* 104 */           for (Player u : Main.players) {
/* 105 */             u.getScoreboard().resetScores(Messages.getMsg("scoreboard.4"));
/* 106 */             u.getScoreboard().resetScores(ChatColor.MAGIC.toString() + ChatColor.RESET.toString());
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 112 */     Scoreboard.Refresh();
/*     */     try {
/* 114 */       Vote.votes.stream().forEach(Vote::stuff);
/* 115 */       OreHologram.list().stream().forEach(OreHologram::remove);
/* 116 */       if (secPlayed == holo) {
/* 117 */         holo += 30;
/* 118 */         Hologram.list().stream().forEach(Hologram::stuff);
/*     */       } 
/* 120 */       for (Map.Entry<Player, Long> l : (Iterable<Map.Entry<Player, Long>>)Stuck.stuck.entrySet()) {
/* 121 */         if (System.currentTimeMillis() - ((Long)l.getValue()).longValue() >= 5000L) {
/* 122 */           Stuck.stuck.remove(l.getKey());
/* 123 */           if (Main.bluePlayers.contains(l.getKey())) {
/* 124 */             ((Player)l.getKey()).teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Blue")); continue;
/* 125 */           }  if (Main.redPlayers.contains(l.getKey())) {
/* 126 */             ((Player)l.getKey()).teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Red")); continue;
/* 127 */           }  if (Main.yellowPlayers.contains(l.getKey())) {
/* 128 */             ((Player)l.getKey()).teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Yellow")); continue;
/* 129 */           }  if (Main.greenPlayers.contains(l.getKey())) {
/* 130 */             ((Player)l.getKey()).teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Green"));
/*     */           }
/*     */         } 
/*     */       } 
/* 134 */     } catch (Exception exception) {}
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\runnables\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */