/*     */ package com.andrei1058.ageofempire.game;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.runnables.Game;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.scoreboard.DisplaySlot;
/*     */ import org.bukkit.scoreboard.Objective;
/*     */ import org.bukkit.scoreboard.Team;
/*     */ 
/*     */ 
/*     */ public class Scoreboard
/*     */ {
/*     */   private static Team blue;
/*     */   private static Team green;
/*     */   private static Team yellow;
/*     */   private static Team red;
/*     */   private static Team age;
/*     */   private static Team wood;
/*     */   private static Team stone;
/*  25 */   public static SimpleDateFormat df = new SimpleDateFormat("mm:ss"); private static Team gold; private static Team small; private static Team medium; private static Team large; private static Team pvp_assault; public static org.bukkit.scoreboard.Scoreboard board; public static Objective objective;
/*  26 */   public static long blue_age_long = 0L, green_age_long = 0L, yellow_age_long = 0L, red_age_long = 0L;
/*     */   
/*     */   public static void register() {
/*  29 */     if (Main.SETUP)
/*  30 */       return;  for (Player u : Main.players) {
/*  31 */       board = Bukkit.getScoreboardManager().getNewScoreboard();
/*  32 */       objective = board.registerNewObjective("Test", "Test2");
/*  33 */       objective.setDisplayName(Messages.getMsg("scoreboard.title").replace('&', '§'));
/*  34 */       objective.setDisplaySlot(DisplaySlot.SIDEBAR);
/*     */       
/*  36 */       blue = board.registerNewTeam("blue");
/*  37 */       blue.setPrefix(ChatColor.BLUE.toString());
/*     */       
/*  39 */       green = board.registerNewTeam("green");
/*  40 */       green.setPrefix(ChatColor.GREEN.toString());
/*     */       
/*  42 */       yellow = board.registerNewTeam("yellow");
/*  43 */       yellow.setPrefix(ChatColor.YELLOW.toString());
/*     */       
/*  45 */       red = board.registerNewTeam("red");
/*  46 */       red.setPrefix(ChatColor.RED.toString());
/*     */       
/*  48 */       age = board.registerNewTeam("age");
/*  49 */       age.addEntry(Messages.getMsg("scoreboard.14"));
/*  50 */       age.setPrefix(ChatColor.DARK_GRAY.toString());
/*  51 */       objective.getScore(Messages.getMsg("scoreboard.14")).setScore(14);
/*     */       
/*  53 */       objective.getScore(Messages.getMsg("scoreboard.13")).setScore(13);
/*     */       
/*  55 */       wood = board.registerNewTeam("wood");
/*  56 */       wood.addEntry(Messages.getMsg("scoreboard.12"));
/*  57 */       wood.setPrefix(ChatColor.DARK_BLUE.toString());
/*  58 */       objective.getScore(Messages.getMsg("scoreboard.12")).setScore(12);
/*     */       
/*  60 */       stone = board.registerNewTeam("stone");
/*  61 */       stone.addEntry(Messages.getMsg("scoreboard.11"));
/*  62 */       stone.setPrefix(ChatColor.DARK_GREEN.toString());
/*  63 */       objective.getScore(Messages.getMsg("scoreboard.11")).setScore(11);
/*     */ 
/*     */       
/*  66 */       gold = board.registerNewTeam("gold");
/*  67 */       gold.addEntry(Messages.getMsg("scoreboard.10"));
/*  68 */       gold.setPrefix(ChatColor.DARK_RED.toString());
/*  69 */       objective.getScore(Messages.getMsg("scoreboard.10")).setScore(10);
/*     */       
/*  71 */       objective.getScore(Messages.getMsg("scoreboard.9")).setScore(9);
/*  72 */       objective.getScore(Messages.getMsg("scoreboard.8")).setScore(8);
/*     */       
/*  74 */       small = board.registerNewTeam("small");
/*  75 */       small.addEntry(Messages.getMsg("scoreboard.7"));
/*  76 */       small.setPrefix(ChatColor.GREEN.toString());
/*  77 */       objective.getScore(Messages.getMsg("scoreboard.7")).setScore(7);
/*     */       
/*  79 */       medium = board.registerNewTeam("medium");
/*  80 */       medium.addEntry(Messages.getMsg("scoreboard.6"));
/*  81 */       medium.setPrefix(ChatColor.GOLD.toString());
/*  82 */       objective.getScore(Messages.getMsg("scoreboard.6")).setScore(6);
/*     */       
/*  84 */       large = board.registerNewTeam("large");
/*  85 */       large.addEntry(Messages.getMsg("scoreboard.5"));
/*  86 */       large.setPrefix(ChatColor.GRAY.toString());
/*  87 */       objective.getScore(Messages.getMsg("scoreboard.5")).setScore(5);
/*     */       
/*  89 */       objective.getScore(Messages.getMsg("scoreboard.4")).setScore(4);
/*     */       
/*  91 */       pvp_assault = board.registerNewTeam("pvp_assault");
/*  92 */       pvp_assault.addEntry(ChatColor.MAGIC.toString() + ChatColor.RESET.toString());
/*  93 */       pvp_assault.setPrefix(Messages.getMsg("scoreboard.3"));
/*  94 */       objective.getScore(ChatColor.MAGIC.toString() + ChatColor.RESET.toString()).setScore(3);
/*     */       
/*  96 */       objective.getScore(Messages.getMsg("scoreboard.2")).setScore(2);
/*  97 */       objective.getScore(Messages.getMsg("scoreboard.1")).setScore(1);
/*     */       
/*  99 */       for (Player blue2 : Main.bluePlayers) {
/* 100 */         blue.addEntry(blue2.getName());
/*     */       }
/* 102 */       for (Player green2 : Main.greenPlayers) {
/* 103 */         green.addEntry(green2.getName());
/*     */       }
/* 105 */       for (Player yellow2 : Main.yellowPlayers) {
/* 106 */         yellow.addEntry(yellow2.getName());
/*     */       }
/* 108 */       for (Player red2 : Main.redPlayers) {
/* 109 */         red.addEntry(red2.getName());
/*     */       }
/* 111 */       u.setScoreboard(board);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void Refresh() {
/* 116 */     for (Player p : Main.players) {
/* 117 */       Team a = p.getScoreboard().getTeam("age");
/* 118 */       Team w = p.getScoreboard().getTeam("wood");
/* 119 */       Team s = p.getScoreboard().getTeam("stone");
/* 120 */       Team g = p.getScoreboard().getTeam("gold");
/* 121 */       Team sm = p.getScoreboard().getTeam("small");
/* 122 */       Team m = p.getScoreboard().getTeam("medium");
/* 123 */       Team l = p.getScoreboard().getTeam("large");
/* 124 */       Team pvp = p.getScoreboard().getTeam("pvp_assault");
/* 125 */       if (Main.bluePlayers.contains(p)) {
/* 126 */         if (Game.blue_change_age) {
/* 127 */           a.setSuffix(String.valueOf(df.format(new Date(blue_age_long))));
/* 128 */           blue_age_long -= 1000L;
/* 129 */           if (blue_age_long == 0L) {
/* 130 */             Main.blue_age++;
/* 131 */             Game.blue_change_age = false;
/* 132 */             Bukkit.broadcastMessage(Messages.getMsg("blue-changed-age").replace("{age}", String.valueOf(Main.blue_age)));
/* 133 */             for (Player on : Bukkit.getOnlinePlayers()) {
/* 134 */               on.getWorld().playSound(on.getLocation(), Main.nms.witherDeath(), 1.0F, 1.0F);
/*     */             }
/*     */           } 
/*     */         } else {
/* 138 */           a.setSuffix("§e" + String.valueOf(Main.blue_age));
/*     */         } 
/* 140 */         w.setSuffix(String.valueOf(Main.blue_wood));
/* 141 */         s.setSuffix(String.valueOf(Main.blue_stone));
/* 142 */         sm.setSuffix(String.valueOf(Main.blue_small_plots));
/* 143 */         m.setSuffix(String.valueOf(Main.blue_medium_plots));
/* 144 */         l.setSuffix(String.valueOf(Main.blue_large_plots));
/* 145 */         if (Main.blue_xp)
/* 146 */           p.giveExp(1); 
/* 147 */       } else if (Main.greenPlayers.contains(p)) {
/* 148 */         if (Game.green_change_age) {
/* 149 */           a.setSuffix(String.valueOf(df.format(new Date(green_age_long))));
/* 150 */           green_age_long -= 1000L;
/* 151 */           if (green_age_long == 0L) {
/* 152 */             Main.green_age++;
/* 153 */             Game.green_change_age = false;
/* 154 */             Bukkit.broadcastMessage(Messages.getMsg("green-changed-age").replace("{age}", String.valueOf(Main.green_age)));
/* 155 */             for (Player on : Bukkit.getOnlinePlayers()) {
/* 156 */               on.getWorld().playSound(on.getLocation(), Main.nms.witherDeath(), 1.0F, 1.0F);
/*     */             }
/*     */           } 
/*     */         } else {
/* 160 */           a.setSuffix("§e" + String.valueOf(Main.green_age));
/*     */         } 
/* 162 */         w.setSuffix(String.valueOf(Main.green_wood));
/* 163 */         s.setSuffix(String.valueOf(Main.green_stone));
/* 164 */         sm.setSuffix(String.valueOf(Main.green_small_plots));
/* 165 */         m.setSuffix(String.valueOf(Main.green_medium_plots));
/* 166 */         l.setSuffix(String.valueOf(Main.green_large_plots));
/* 167 */         if (Main.green_xp)
/* 168 */           p.giveExp(1); 
/* 169 */       } else if (Main.yellowPlayers.contains(p)) {
/* 170 */         if (Game.yellow_change_age) {
/* 171 */           a.setPrefix(String.valueOf(df.format(new Date(yellow_age_long))));
/* 172 */           yellow_age_long -= 1000L;
/* 173 */           if (green_age_long == 0L) {
/* 174 */             Main.yellow_age++;
/* 175 */             Game.yellow_change_age = false;
/* 176 */             Bukkit.broadcastMessage(Messages.getMsg("yellow-changed-age").replace("{age}", String.valueOf(Main.yellow_age)));
/* 177 */             for (Player on : Bukkit.getOnlinePlayers()) {
/* 178 */               on.getWorld().playSound(on.getLocation(), Main.nms.witherDeath(), 1.0F, 1.0F);
/*     */             }
/*     */           } 
/*     */         } else {
/* 182 */           a.setSuffix("§e" + String.valueOf(Main.yellow_age));
/*     */         } 
/* 184 */         w.setSuffix(String.valueOf(Main.yellow_wood));
/* 185 */         s.setSuffix(String.valueOf(Main.yellow_stone));
/* 186 */         sm.setSuffix(String.valueOf(Main.yellow_small_plots));
/* 187 */         m.setSuffix(String.valueOf(Main.yellow_medium_plots));
/* 188 */         l.setSuffix(String.valueOf(Main.yellow_large_plots));
/* 189 */         if (Main.yellow_xp)
/* 190 */           p.giveExp(1); 
/* 191 */       } else if (Main.redPlayers.contains(p)) {
/* 192 */         if (Game.red_change_age) {
/* 193 */           a.setPrefix(String.valueOf(df.format(new Date(red_age_long))));
/* 194 */           red_age_long -= 1000L;
/* 195 */           if (red_age_long == 0L) {
/* 196 */             Main.red_age++;
/* 197 */             Game.red_change_age = false;
/* 198 */             Bukkit.broadcastMessage(Messages.getMsg("red-changed-age").replace("{age}", String.valueOf(Main.red_age)));
/* 199 */             for (Player on : Bukkit.getOnlinePlayers()) {
/* 200 */               on.getWorld().playSound(on.getLocation(), Main.nms.witherDeath(), 1.0F, 1.0F);
/*     */             }
/*     */           } 
/*     */         } else {
/* 204 */           a.setSuffix("§e" + String.valueOf(Main.red_age));
/*     */         } 
/* 206 */         w.setSuffix(String.valueOf(Main.red_wood));
/* 207 */         s.setSuffix(String.valueOf(Main.red_stone));
/* 208 */         sm.setSuffix(String.valueOf(Main.red_small_plots));
/* 209 */         m.setSuffix(String.valueOf(Main.red_medium_plots));
/* 210 */         l.setSuffix(String.valueOf(Main.red_large_plots));
/* 211 */         if (Main.red_xp)
/* 212 */           p.giveExp(1); 
/*     */       } 
/* 214 */       pvp.setSuffix(String.valueOf(df.format(new Date(Main.pvp_assault))));
/* 215 */       g.setSuffix(String.valueOf(Main.gold.get(p)));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\game\Scoreboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */