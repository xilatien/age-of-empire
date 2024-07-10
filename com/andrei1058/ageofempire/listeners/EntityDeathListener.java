/*     */ package com.andrei1058.ageofempire.listeners;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.game.Hologram;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Projectile;
/*     */ import org.bukkit.entity.Villager;
/*     */ import org.bukkit.entity.Wolf;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDeathEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityDeathListener
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void d(EntityDeathEvent e) {
/*  25 */     if (Main.SETUP)
/*  26 */       return;  if (e.getEntity() instanceof Villager) {
/*  27 */       Villager v = (Villager)e.getEntity();
/*  28 */       String killer = "";
/*  29 */       Player p = null;
/*  30 */       if (e.getEntity().getKiller() instanceof Player) {
/*  31 */         p = e.getEntity().getKiller();
/*  32 */       } else if (e.getEntity().getKiller() instanceof Projectile) {
/*  33 */         Projectile proj = (Projectile)e.getEntity().getKiller();
/*  34 */         p = (Player)proj.getShooter();
/*  35 */       } else if (e.getEntity().getKiller() instanceof Wolf) {
/*  36 */         Wolf w = (Wolf)e.getEntity().getKiller();
/*  37 */         p = (Player)w.getOwner();
/*     */       } else {
/*     */         return;
/*     */       } 
/*  41 */       if (Main.bluePlayers.contains(p)) {
/*  42 */         killer = "§9Blue";
/*  43 */       } else if (Main.greenPlayers.contains(p)) {
/*  44 */         killer = "§aGreen";
/*  45 */       } else if (Main.yellowPlayers.contains(p)) {
/*  46 */         killer = "§eYellow";
/*  47 */       } else if (Main.redPlayers.contains(p)) {
/*  48 */         killer = "§cRed";
/*     */       } 
/*  50 */       if (v == Main.blue_villager) {
/*  51 */         Main.addKingKill(p);
/*  52 */         Bukkit.broadcastMessage(Messages.getMsg("base-destroyed.blue").replace("{team}", killer));
/*  53 */         Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> {
/*     */               try {
/*     */                 if (!Main.bluePlayers.isEmpty()) {
/*     */                   for (Player u : Main.bluePlayers) {
/*     */                     if (u != null) {
/*     */                       Main.players.remove(u);
/*     */                       Main.bluePlayers.remove(u);
/*     */                       u.getInventory().clear();
/*     */                       u.setGameMode(GameMode.SPECTATOR);
/*     */                     } 
/*     */                   } 
/*     */                 }
/*  65 */               } catch (Exception exception) {}
/*     */               PlayerQuitListener.checkWinner();
/*     */             }10L);
/*  68 */       } else if (v == Main.green_villager) {
/*  69 */         Main.addKingKill(p);
/*  70 */         Bukkit.broadcastMessage(Messages.getMsg("base-destroyed.green").replace("{team}", killer));
/*  71 */         Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> {
/*     */               try {
/*     */                 if (!Main.greenPlayers.isEmpty()) {
/*     */                   for (Player u : Main.greenPlayers) {
/*     */                     if (u != null) {
/*     */                       u.getInventory().clear();
/*     */                       u.setGameMode(GameMode.SPECTATOR);
/*     */                       Main.players.remove(u);
/*     */                       Main.greenPlayers.remove(u);
/*     */                     } 
/*     */                   } 
/*     */                 }
/*  83 */               } catch (Exception exception) {}
/*     */               PlayerQuitListener.checkWinner();
/*     */             }10L);
/*  86 */       } else if (v == Main.yellow_villager) {
/*  87 */         Main.addKingKill(p);
/*  88 */         Bukkit.broadcastMessage(Messages.getMsg("base-destroyed.yellow").replace("{team}", killer));
/*  89 */         Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> {
/*     */               try {
/*     */                 if (!Main.yellowPlayers.isEmpty()) {
/*     */                   for (Player u : Main.yellowPlayers) {
/*     */                     if (u != null) {
/*     */                       Main.players.remove(u);
/*     */                       Main.yellowPlayers.remove(u);
/*     */                       u.getInventory().clear();
/*     */                       u.setGameMode(GameMode.SPECTATOR);
/*     */                     } 
/*     */                   } 
/*     */                 }
/* 101 */               } catch (Exception exception) {}
/*     */               PlayerQuitListener.checkWinner();
/*     */             }10L);
/* 104 */       } else if (v == Main.red_villager) {
/* 105 */         Main.addKingKill(p);
/* 106 */         Bukkit.broadcastMessage(Messages.getMsg("base-destroyed.red").replace("{team}", killer));
/* 107 */         Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> {
/*     */               try {
/*     */                 if (!Main.redPlayers.isEmpty()) {
/*     */                   for (Player u : Main.redPlayers) {
/*     */                     if (u != null) {
/*     */                       Main.players.remove(u);
/*     */                       Main.redPlayers.remove(u);
/*     */                       u.getInventory().clear();
/*     */                       u.setGameMode(GameMode.SPECTATOR);
/*     */                     } 
/*     */                   } 
/*     */                 }
/* 119 */               } catch (Exception exception) {}
/*     */               PlayerQuitListener.checkWinner();
/*     */             }10L);
/*     */       } else {
/* 123 */         if (v == Main.blue_forge) {
/* 124 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.FORGE.displayname")));
/* 125 */         } else if (v == Main.green_forge) {
/* 126 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.FORGE.displayname")));
/* 127 */         } else if (v == Main.yellow_forge) {
/* 128 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.FORGE.displayname")));
/* 129 */         } else if (v == Main.red_forge) {
/* 130 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.FORGE.displayname")));
/* 131 */         } else if (v == Main.blue_smine) {
/* 132 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.STONE_MINE.displayname")));
/* 133 */         } else if (v == Main.green_smine) {
/* 134 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.STONE_MINE.displayname")));
/* 135 */         } else if (v == Main.yellow_smine) {
/* 136 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.STONE_MINE.displayname")));
/* 137 */         } else if (v == Main.red_smine) {
/* 138 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.STONE_MINE.displayname")));
/* 139 */         } else if (v == Main.blue_gmine) {
/* 140 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.GOLD_MINE.displayname")));
/* 141 */         } else if (v == Main.green_gmine) {
/* 142 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.GOLD_MINE.displayname")));
/* 143 */         } else if (v == Main.yellow_gmine) {
/* 144 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.GOLD_MINE.displayname")));
/* 145 */         } else if (v == Main.red_gmine) {
/* 146 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.GOLD_MINE.displayname")));
/* 147 */         } else if (v == Main.blue_mill) {
/* 148 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.MILL.displayname")));
/* 149 */         } else if (v == Main.green_mill) {
/* 150 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.MILL.displayname")));
/* 151 */         } else if (v == Main.yellow_mill) {
/* 152 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.MILL.displayname")));
/* 153 */         } else if (v == Main.red_mill) {
/* 154 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.MILL.displayname")));
/* 155 */         } else if (v == Main.blue_vsawmill) {
/* 156 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.SAWMILL.displayname")));
/* 157 */         } else if (v == Main.green_vsawmill) {
/* 158 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.SAWMILL.displayname")));
/* 159 */         } else if (v == Main.yellow_vsawmill) {
/* 160 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.SAWMILL.displayname")));
/* 161 */         } else if (v == Main.red_vsawmill) {
/* 162 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.SAWMILL.displayname")));
/* 163 */         } else if (v == Main.blue_workshop) {
/* 164 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.WORKSHOP.displayname")));
/* 165 */         } else if (v == Main.green_workshop) {
/* 166 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.WORKSHOP.displayname")));
/* 167 */         } else if (v == Main.yellow_workshop) {
/* 168 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.WORKSHOP.displayname")));
/* 169 */         } else if (v == Main.red_workshop) {
/* 170 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.WORKSHOP.displayname")));
/* 171 */         } else if (v == Main.blue_market) {
/* 172 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.MARKET.displayname")));
/* 173 */         } else if (v == Main.green_market) {
/* 174 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.MARKET.displayname")));
/* 175 */         } else if (v == Main.yellow_market) {
/* 176 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.MARKET.displayname")));
/* 177 */         } else if (v == Main.red_market) {
/* 178 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.MARKET.displayname")));
/* 179 */         } else if (v == Main.blue_sabotage) {
/* 180 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname")));
/* 181 */         } else if (v == Main.green_sabotage) {
/* 182 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname")));
/* 183 */         } else if (v == Main.yellow_sabotage) {
/* 184 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname")));
/* 185 */         } else if (v == Main.red_sabotage) {
/* 186 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname")));
/* 187 */         } else if (v == Main.blue_kennel) {
/* 188 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.KENNEL.displayname")));
/* 189 */         } else if (v == Main.green_kennel) {
/* 190 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.KENNEL.displayname")));
/* 191 */         } else if (v == Main.yellow_kennel) {
/* 192 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.KENNEL.displayname")));
/* 193 */         } else if (v == Main.red_kennel) {
/* 194 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.KENNEL.displayname")));
/* 195 */         } else if (v == Main.blue_archery) {
/* 196 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.ARCHERY_STORE.displayname")));
/* 197 */         } else if (v == Main.green_archery) {
/* 198 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.ARCHERY_STORE.displayname")));
/* 199 */         } else if (v == Main.red_archery) {
/* 200 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.ARCHERY_STORE.displayname")));
/* 201 */         } else if (v == Main.yellow_archery) {
/* 202 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.ARCHERY_STORE.displayname")));
/* 203 */         } else if (v == Main.blue_trifarrow) {
/* 204 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.TRIFARROW.displayname")));
/* 205 */         } else if (v == Main.green_trifarrow) {
/* 206 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.TRIFARROW.displayname")));
/* 207 */         } else if (v == Main.yellow_trifarrow) {
/* 208 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.TRIFARROW.displayname")));
/* 209 */         } else if (v == Main.red_trifarrow) {
/* 210 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.TRIFARROW.displayname")));
/* 211 */         } else if (v == Main.blue_armory) {
/* 212 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.ARMORY.displayname")));
/* 213 */         } else if (v == Main.green_armory) {
/* 214 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.ARMORY.displayname")));
/* 215 */         } else if (v == Main.yellow_armory) {
/* 216 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.ARMORY.displayname")));
/* 217 */         } else if (v == Main.red_armory) {
/* 218 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.ARMORY.displayname")));
/* 219 */         } else if (v == Main.blue_lab) {
/* 220 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.LABORATORY.displayname")));
/* 221 */         } else if (v == Main.green_lab) {
/* 222 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.LABORATORY.displayname")));
/* 223 */         } else if (v == Main.yellow_lab) {
/* 224 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.LABORATORY.displayname")));
/* 225 */         } else if (v == Main.red_lab) {
/* 226 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.LABORATORY.displayname")));
/* 227 */         } else if (v == Main.blue_guild) {
/* 228 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.GUILD.displayname")));
/* 229 */         } else if (v == Main.green_guild) {
/* 230 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.GUILD.displayname")));
/* 231 */         } else if (v == Main.yellow_guild) {
/* 232 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.GUILD.displayname")));
/* 233 */         } else if (v == Main.red_guild) {
/* 234 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.GUILD.displayname")));
/* 235 */         } else if (v == Main.blue_tcenter) {
/* 236 */           Bukkit.broadcastMessage(Messages.getMsg("blue-building-explode").replace("{building}", Messages.getMsg("forum.TRAINING_CENTER.displayname")));
/* 237 */           Main.blue_xp = false;
/* 238 */         } else if (v == Main.green_tcenter) {
/* 239 */           Bukkit.broadcastMessage(Messages.getMsg("green-building-explode").replace("{building}", Messages.getMsg("forum.TRAINING_CENTER.displayname")));
/* 240 */           Main.green_xp = false;
/* 241 */         } else if (v == Main.yellow_tcenter) {
/* 242 */           Bukkit.broadcastMessage(Messages.getMsg("yellow-building-explode").replace("{building}", Messages.getMsg("forum.TRAINING_CENTER.displayname")));
/* 243 */           Main.yellow_xp = false;
/* 244 */         } else if (v == Main.red_tcenter) {
/* 245 */           Bukkit.broadcastMessage(Messages.getMsg("red-building-explode").replace("{building}", Messages.getMsg("forum.TRAINING_CENTER.displayname")));
/* 246 */           Main.red_xp = false;
/*     */         } 
/* 248 */         Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Bukkit.getWorld(v.getWorld().getName()).createExplosion(v.getLocation(), 8.0F), 300L);
/*     */       } 
/*     */       try {
/* 251 */         Hologram.get(v).remove();
/* 252 */       } catch (Exception exception) {}
/* 253 */       Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> PlayerQuitListener.checkWinner(), 10L);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\EntityDeathListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */