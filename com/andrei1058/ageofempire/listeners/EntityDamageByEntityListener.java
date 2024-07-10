/*     */ package com.andrei1058.ageofempire.listeners;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.commands.Stuck;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.game.Status;
/*     */ import com.andrei1058.ageofempire.game.Titles;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Projectile;
/*     */ import org.bukkit.entity.Villager;
/*     */ import org.bukkit.entity.Wolf;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ 
/*     */ public class EntityDamageByEntityListener implements Listener {
/*     */   @EventHandler
/*     */   public void d(EntityDamageByEntityEvent e) {
/*  20 */     if (Main.SETUP)
/*  21 */       return;  if (Main.STATUS != Status.PLAYING) {
/*  22 */       e.setCancelled(true);
/*     */       return;
/*     */     } 
/*  25 */     if (!Main.pvp) {
/*  26 */       e.setCancelled(true);
/*  27 */       e.getDamager().sendMessage(Messages.getMsg("pvp-disabled"));
/*     */       return;
/*     */     } 
/*  30 */     if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
/*  31 */       if (Main.bluePlayers.contains(e.getEntity()) && Main.bluePlayers.contains(e.getDamager())) {
/*  32 */         e.setCancelled(true);
/*  33 */       } else if (Main.greenPlayers.contains(e.getEntity()) && Main.greenPlayers.contains(e.getDamager())) {
/*  34 */         e.setCancelled(true);
/*  35 */       } else if (Main.yellowPlayers.contains(e.getEntity()) && Main.yellowPlayers.contains(e.getDamager())) {
/*  36 */         e.setCancelled(true);
/*  37 */       } else if (Main.redPlayers.contains(e.getEntity()) && Main.redPlayers.contains(e.getDamager())) {
/*  38 */         e.setCancelled(true);
/*     */       } 
/*  40 */       if (Stuck.stuck.containsKey(e.getEntity())) {
/*  41 */         Stuck.stuck.remove(e.getEntity());
/*  42 */         e.getEntity().sendMessage(Messages.getMsg("stuckMove"));
/*     */       } 
/*     */     } 
/*  45 */     if (Stuck.stuck.containsKey(e.getDamager())) {
/*  46 */       Stuck.stuck.remove(e.getDamager());
/*  47 */       e.getDamager().sendMessage(Messages.getMsg("stuckMove"));
/*     */     } 
/*  49 */     if (e.getEntity().getType() == EntityType.VILLAGER) {
/*     */       Player p;
/*  51 */       if (e.getDamager() instanceof Player) {
/*  52 */         p = (Player)e.getDamager();
/*  53 */       } else if (e.getDamager() instanceof Projectile) {
/*  54 */         Projectile proj = (Projectile)e.getDamager();
/*  55 */         p = (Player)proj.getShooter();
/*  56 */       } else if (e.getDamager() instanceof Wolf) {
/*  57 */         Wolf w = (Wolf)e.getDamager();
/*  58 */         p = (Player)w.getOwner();
/*     */       } else {
/*  60 */         e.setCancelled(true);
/*     */         return;
/*     */       } 
/*  63 */       Villager v = (Villager)e.getEntity();
/*  64 */       if (!Main.assualt) {
/*  65 */         e.setCancelled(true);
/*     */         return;
/*     */       } 
/*  68 */       if (v.getCustomName() != null) {
/*  69 */         v.setCustomName("§9" + (int)v.getHealth());
/*     */       }
/*  71 */       if (v == Main.yellow_villager) {
/*  72 */         if (Main.yellowPlayers.contains(p)) {
/*  73 */           e.setCancelled(true);
/*  74 */           p.sendMessage(Messages.getMsg("forum.violence"));
/*     */           return;
/*     */         } 
/*  77 */         for (Player u : Main.yellowPlayers) {
/*  78 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("villager.forum-attacked"));
/*     */         }
/*  80 */       } else if (v == Main.blue_villager) {
/*  81 */         if (Main.bluePlayers.contains(p)) {
/*  82 */           e.setCancelled(true);
/*  83 */           p.sendMessage(Messages.getMsg("forum.violence"));
/*     */           return;
/*     */         } 
/*  86 */         for (Player u : Main.bluePlayers) {
/*  87 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("villager.forum-attacked"));
/*     */         }
/*  89 */       } else if (v == Main.green_villager) {
/*  90 */         if (Main.greenPlayers.contains(p)) {
/*  91 */           e.setCancelled(true);
/*  92 */           p.sendMessage(Messages.getMsg("forum.violence"));
/*     */           return;
/*     */         } 
/*  95 */         for (Player u : Main.greenPlayers) {
/*  96 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("villager.forum-attacked"));
/*     */         }
/*  98 */       } else if (v == Main.red_villager) {
/*  99 */         if (Main.redPlayers.contains(p)) {
/* 100 */           e.setCancelled(true);
/* 101 */           p.sendMessage(Messages.getMsg("forum.violence"));
/*     */           return;
/*     */         } 
/* 104 */         for (Player u : Main.redPlayers) {
/* 105 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("villager.forum-attacked"));
/*     */         }
/* 107 */       } else if (v == Main.blue_forge) {
/* 108 */         if (Main.bluePlayers.contains(p)) {
/* 109 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 110 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 113 */         for (Player u : Main.bluePlayers) {
/* 114 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.FORGE.displayname")));
/*     */         }
/* 116 */       } else if (v == Main.green_forge) {
/* 117 */         if (Main.greenPlayers.contains(p)) {
/* 118 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 119 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 122 */         for (Player u : Main.greenPlayers) {
/* 123 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.FORGE.displayname")));
/*     */         }
/* 125 */       } else if (v == Main.yellow_forge) {
/* 126 */         if (Main.yellowPlayers.contains(p)) {
/* 127 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 128 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 131 */         for (Player u : Main.yellowPlayers) {
/* 132 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.FORGE.displayname")));
/*     */         }
/* 134 */       } else if (v == Main.red_forge) {
/* 135 */         if (Main.redPlayers.contains(p)) {
/* 136 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 137 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 140 */         for (Player u : Main.redPlayers) {
/* 141 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.FORGE.displayname")));
/*     */         }
/* 143 */       } else if (v == Main.blue_smine) {
/* 144 */         if (Main.bluePlayers.contains(p)) {
/* 145 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 146 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 149 */         for (Player u : Main.bluePlayers) {
/* 150 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.STONE_MINE.displayname")));
/*     */         }
/* 152 */       } else if (v == Main.green_smine) {
/* 153 */         if (Main.greenPlayers.contains(p)) {
/* 154 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 155 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 158 */         for (Player u : Main.greenPlayers) {
/* 159 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.STONE_MINE.displayname")));
/*     */         }
/* 161 */       } else if (v == Main.yellow_smine) {
/* 162 */         if (Main.yellowPlayers.contains(p)) {
/* 163 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 164 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 167 */         for (Player u : Main.yellowPlayers) {
/* 168 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.STONE_MINE.displayname")));
/*     */         }
/* 170 */       } else if (v == Main.red_smine) {
/* 171 */         if (Main.redPlayers.contains(p)) {
/* 172 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 173 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 176 */         for (Player u : Main.redPlayers) {
/* 177 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.STONE_MINE.displayname")));
/*     */         }
/* 179 */       } else if (v == Main.blue_gmine) {
/* 180 */         if (Main.bluePlayers.contains(p)) {
/* 181 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 182 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 185 */         for (Player u : Main.bluePlayers) {
/* 186 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.GOLD_MINE.displayname")));
/*     */         }
/* 188 */       } else if (v == Main.green_gmine) {
/* 189 */         if (Main.greenPlayers.contains(p)) {
/* 190 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 191 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 194 */         for (Player u : Main.greenPlayers) {
/* 195 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.GOLD_MINE.displayname")));
/*     */         }
/* 197 */       } else if (v == Main.yellow_gmine) {
/* 198 */         if (Main.yellowPlayers.contains(p)) {
/* 199 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 200 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 203 */         for (Player u : Main.yellowPlayers) {
/* 204 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.GOLD_MINE.displayname")));
/*     */         }
/* 206 */       } else if (v == Main.red_gmine) {
/* 207 */         if (Main.redPlayers.contains(p)) {
/* 208 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 209 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 212 */         for (Player u : Main.redPlayers) {
/* 213 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.GOLD_MINE.displayname")));
/*     */         }
/* 215 */       } else if (v == Main.blue_mill) {
/* 216 */         if (Main.bluePlayers.contains(p)) {
/* 217 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 218 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 221 */         for (Player u : Main.bluePlayers) {
/* 222 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.MILL.displayname")));
/*     */         }
/* 224 */       } else if (v == Main.green_mill) {
/* 225 */         if (Main.greenPlayers.contains(p)) {
/* 226 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 227 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 230 */         for (Player u : Main.greenPlayers) {
/* 231 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.MILL.displayname")));
/*     */         }
/* 233 */       } else if (v == Main.yellow_mill) {
/* 234 */         if (Main.yellowPlayers.contains(p)) {
/* 235 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 236 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 239 */         for (Player u : Main.yellowPlayers) {
/* 240 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.MILL.displayname")));
/*     */         }
/* 242 */       } else if (v == Main.red_mill) {
/* 243 */         if (Main.redPlayers.contains(p)) {
/* 244 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 245 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 248 */         for (Player u : Main.redPlayers) {
/* 249 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.MILL.displayname")));
/*     */         }
/* 251 */       } else if (v == Main.blue_vsawmill) {
/* 252 */         if (Main.bluePlayers.contains(p)) {
/* 253 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 254 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 257 */         for (Player u : Main.bluePlayers) {
/* 258 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.SAWMILL.displayname")));
/*     */         }
/* 260 */       } else if (v == Main.green_vsawmill) {
/* 261 */         if (Main.greenPlayers.contains(p)) {
/* 262 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 263 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 266 */         for (Player u : Main.greenPlayers) {
/* 267 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.SAWMILL.displayname")));
/*     */         }
/* 269 */       } else if (v == Main.yellow_vsawmill) {
/* 270 */         if (Main.yellowPlayers.contains(p)) {
/* 271 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 272 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 275 */         for (Player u : Main.yellowPlayers) {
/* 276 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.SAWMILL.displayname")));
/*     */         }
/* 278 */       } else if (v == Main.red_vsawmill) {
/* 279 */         if (Main.redPlayers.contains(p)) {
/* 280 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 281 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 284 */         for (Player u : Main.redPlayers) {
/* 285 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.SAWMILL.displayname")));
/*     */         }
/* 287 */       } else if (v == Main.blue_workshop) {
/* 288 */         if (Main.bluePlayers.contains(p)) {
/* 289 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 290 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 293 */         for (Player u : Main.bluePlayers) {
/* 294 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.WORKSHOP.displayname")));
/*     */         }
/* 296 */       } else if (v == Main.green_workshop) {
/* 297 */         if (Main.greenPlayers.contains(p)) {
/* 298 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 299 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 302 */         for (Player u : Main.greenPlayers) {
/* 303 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.WORKSHOP.displayname")));
/*     */         }
/* 305 */       } else if (v == Main.yellow_workshop) {
/* 306 */         if (Main.yellowPlayers.contains(p)) {
/* 307 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 308 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 311 */         for (Player u : Main.yellowPlayers) {
/* 312 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.WORKSHOP.displayname")));
/*     */         }
/* 314 */       } else if (v == Main.red_workshop) {
/* 315 */         if (Main.redPlayers.contains(p)) {
/* 316 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 317 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 320 */         for (Player u : Main.redPlayers) {
/* 321 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.WORKSHOP.displayname")));
/*     */         }
/* 323 */       } else if (v == Main.blue_market) {
/* 324 */         if (Main.bluePlayers.contains(p)) {
/* 325 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 326 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 329 */         for (Player u : Main.bluePlayers) {
/* 330 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.MARKET.displayname")));
/*     */         }
/* 332 */       } else if (v == Main.green_market) {
/* 333 */         if (Main.greenPlayers.contains(p)) {
/* 334 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 335 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 338 */         for (Player u : Main.greenPlayers) {
/* 339 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.MARKET.displayname")));
/*     */         }
/* 341 */       } else if (v == Main.yellow_market) {
/* 342 */         if (Main.yellowPlayers.contains(p)) {
/* 343 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 344 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 347 */         for (Player u : Main.yellowPlayers) {
/* 348 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.MARKET.displayname")));
/*     */         }
/* 350 */       } else if (v == Main.red_market) {
/* 351 */         if (Main.redPlayers.contains(p)) {
/* 352 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 353 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 356 */         for (Player u : Main.redPlayers) {
/* 357 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.MARKET.displayname")));
/*     */         }
/* 359 */       } else if (v == Main.blue_sabotage) {
/* 360 */         if (Main.bluePlayers.contains(p)) {
/* 361 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 362 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 365 */         for (Player u : Main.bluePlayers) {
/* 366 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname")));
/*     */         }
/* 368 */       } else if (v == Main.green_sabotage) {
/* 369 */         if (Main.greenPlayers.contains(p)) {
/* 370 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 371 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 374 */         for (Player u : Main.greenPlayers) {
/* 375 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname")));
/*     */         }
/* 377 */       } else if (v == Main.yellow_sabotage) {
/* 378 */         if (Main.yellowPlayers.contains(p)) {
/* 379 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 380 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 383 */         for (Player u : Main.yellowPlayers) {
/* 384 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname")));
/*     */         }
/* 386 */       } else if (v == Main.red_sabotage) {
/* 387 */         if (Main.redPlayers.contains(p)) {
/* 388 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 389 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 392 */         for (Player u : Main.redPlayers) {
/* 393 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname")));
/*     */         }
/* 395 */       } else if (v == Main.blue_kennel) {
/* 396 */         if (Main.bluePlayers.contains(p)) {
/* 397 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 398 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 401 */         for (Player u : Main.bluePlayers) {
/* 402 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.KENNEL.displayname")));
/*     */         }
/* 404 */       } else if (v == Main.yellow_kennel) {
/* 405 */         if (Main.yellowPlayers.contains(p)) {
/* 406 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 407 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 410 */         for (Player u : Main.yellowPlayers) {
/* 411 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.KENNEL.displayname")));
/*     */         }
/* 413 */       } else if (v == Main.green_kennel) {
/* 414 */         if (Main.greenPlayers.contains(p)) {
/* 415 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 416 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 419 */         for (Player u : Main.greenPlayers) {
/* 420 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.KENNEL.displayname")));
/*     */         }
/* 422 */       } else if (v == Main.red_kennel) {
/* 423 */         if (Main.redPlayers.contains(p)) {
/* 424 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 425 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 428 */         for (Player u : Main.redPlayers) {
/* 429 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.KENNEL.displayname")));
/*     */         }
/* 431 */       } else if (v == Main.blue_archery) {
/* 432 */         if (Main.bluePlayers.contains(p)) {
/* 433 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 434 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 437 */         for (Player u : Main.bluePlayers) {
/* 438 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.ARCHERY_STORE.displayname")));
/*     */         }
/* 440 */       } else if (v == Main.green_archery) {
/* 441 */         if (Main.greenPlayers.contains(p)) {
/* 442 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 443 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 446 */         for (Player u : Main.greenPlayers) {
/* 447 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.ARCHERY_STORE.displayname")));
/*     */         }
/* 449 */       } else if (v == Main.yellow_archery) {
/* 450 */         if (Main.yellowPlayers.contains(p)) {
/* 451 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 452 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 455 */         for (Player u : Main.yellowPlayers) {
/* 456 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.ARCHERY_STORE.displayname")));
/*     */         }
/* 458 */       } else if (v == Main.red_archery) {
/* 459 */         if (Main.redPlayers.contains(p)) {
/* 460 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 461 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 464 */         for (Player u : Main.redPlayers) {
/* 465 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.ARCHERY_STORE.displayname")));
/*     */         }
/* 467 */       } else if (v == Main.blue_trifarrow) {
/* 468 */         if (Main.bluePlayers.contains(p)) {
/* 469 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 470 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 473 */         for (Player u : Main.bluePlayers) {
/* 474 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.TRIFARROW.displayname")));
/*     */         }
/* 476 */       } else if (v == Main.green_trifarrow) {
/* 477 */         if (Main.greenPlayers.contains(p)) {
/* 478 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 479 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 482 */         for (Player u : Main.greenPlayers) {
/* 483 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.TRIFARROW.displayname")));
/*     */         }
/* 485 */       } else if (v == Main.yellow_trifarrow) {
/* 486 */         if (Main.yellowPlayers.contains(p)) {
/* 487 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 488 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 491 */         for (Player u : Main.yellowPlayers) {
/* 492 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.TRIFARROW.displayname")));
/*     */         }
/* 494 */       } else if (v == Main.red_trifarrow) {
/* 495 */         if (Main.redPlayers.contains(p)) {
/* 496 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 497 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 500 */         for (Player u : Main.redPlayers) {
/* 501 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.TRIFARROW.displayname")));
/*     */         }
/* 503 */       } else if (v == Main.blue_stable) {
/* 504 */         if (Main.bluePlayers.contains(p)) {
/* 505 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 506 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 509 */         for (Player u : Main.bluePlayers) {
/* 510 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.STABLE.displayname")));
/*     */         }
/* 512 */       } else if (v == Main.green_stable) {
/* 513 */         if (Main.greenPlayers.contains(p)) {
/* 514 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 515 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 518 */         for (Player u : Main.greenPlayers) {
/* 519 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.STABLE.displayname")));
/*     */         }
/* 521 */       } else if (v == Main.yellow_stable) {
/* 522 */         if (Main.yellowPlayers.contains(p)) {
/* 523 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 524 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 527 */         for (Player u : Main.yellowPlayers) {
/* 528 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.STABLE.displayname")));
/*     */         }
/* 530 */       } else if (v == Main.red_stable) {
/* 531 */         if (Main.redPlayers.contains(p)) {
/* 532 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 533 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 536 */         for (Player u : Main.redPlayers) {
/* 537 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.STABLE.displayname")));
/*     */         }
/* 539 */       } else if (v == Main.blue_armory) {
/* 540 */         if (Main.bluePlayers.contains(p)) {
/* 541 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 542 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 545 */         for (Player u : Main.bluePlayers) {
/* 546 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.ARMORY.displayname")));
/*     */         }
/* 548 */       } else if (v == Main.green_archery) {
/* 549 */         if (Main.greenPlayers.contains(p)) {
/* 550 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 551 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 554 */         for (Player u : Main.greenPlayers) {
/* 555 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.ARMORY.displayname")));
/*     */         }
/* 557 */       } else if (v == Main.yellow_armory) {
/* 558 */         if (Main.yellowPlayers.contains(p)) {
/* 559 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 560 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 563 */         for (Player u : Main.yellowPlayers) {
/* 564 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.ARMORY.displayname")));
/*     */         }
/* 566 */       } else if (v == Main.red_armory) {
/* 567 */         if (Main.redPlayers.contains(p)) {
/* 568 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 569 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 572 */         for (Player u : Main.redPlayers) {
/* 573 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.ARMORY.displayname")));
/*     */         }
/* 575 */       } else if (v == Main.blue_lab) {
/* 576 */         if (Main.bluePlayers.contains(p)) {
/* 577 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 578 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 581 */         for (Player u : Main.bluePlayers) {
/* 582 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.LABORATORY.displayname")));
/*     */         }
/* 584 */       } else if (v == Main.green_lab) {
/* 585 */         if (Main.greenPlayers.contains(p)) {
/* 586 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 587 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 590 */         for (Player u : Main.greenPlayers) {
/* 591 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.LABORATORY.displayname")));
/*     */         }
/* 593 */       } else if (v == Main.yellow_lab) {
/* 594 */         if (Main.yellowPlayers.contains(p)) {
/* 595 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 596 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 599 */         for (Player u : Main.yellowPlayers) {
/* 600 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.LABORATORY.displayname")));
/*     */         }
/* 602 */       } else if (v == Main.red_lab) {
/* 603 */         if (Main.redPlayers.contains(p)) {
/* 604 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 605 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 608 */         for (Player u : Main.redPlayers) {
/* 609 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.LABORATORY.displayname")));
/*     */         }
/* 611 */       } else if (v == Main.blue_guild) {
/* 612 */         if (Main.bluePlayers.contains(p)) {
/* 613 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 614 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 617 */         for (Player u : Main.bluePlayers) {
/* 618 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.GUILD.displayname")));
/*     */         }
/* 620 */       } else if (v == Main.green_guild) {
/* 621 */         if (Main.greenPlayers.contains(p)) {
/* 622 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 623 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 626 */         for (Player u : Main.greenPlayers) {
/* 627 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.GUILD.displayname")));
/*     */         }
/* 629 */       } else if (v == Main.yellow_guild) {
/* 630 */         if (Main.yellowPlayers.contains(p)) {
/* 631 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 632 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 635 */         for (Player u : Main.yellowPlayers) {
/* 636 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.GUILD.displayname")));
/*     */         }
/* 638 */       } else if (v == Main.red_guild) {
/* 639 */         if (Main.redPlayers.contains(p)) {
/* 640 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 641 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 644 */         for (Player u : Main.redPlayers) {
/* 645 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.GUILD.displayname")));
/*     */         }
/* 647 */       } else if (v == Main.blue_tcenter) {
/* 648 */         if (Main.bluePlayers.contains(p)) {
/* 649 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 650 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 653 */         for (Player u : Main.bluePlayers) {
/* 654 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.TRAINING_CENTER.displayname")));
/*     */         }
/* 656 */       } else if (v == Main.green_tcenter) {
/* 657 */         if (Main.greenPlayers.contains(p)) {
/* 658 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 659 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 662 */         for (Player u : Main.greenPlayers) {
/* 663 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.TRAINING_CENTER.displayname")));
/*     */         }
/* 665 */       } else if (v == Main.yellow_tcenter) {
/* 666 */         if (Main.yellowPlayers.contains(p)) {
/* 667 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 668 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 671 */         for (Player u : Main.yellowPlayers) {
/* 672 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.TRAINING_CENTER.displayname")));
/*     */         }
/* 674 */       } else if (v == Main.red_tcenter) {
/* 675 */         if (Main.redPlayers.contains(p)) {
/* 676 */           p.sendMessage(Messages.getMsg("forum.violence"));
/* 677 */           e.setCancelled(true);
/*     */           return;
/*     */         } 
/* 680 */         for (Player u : Main.redPlayers)
/* 681 */           Titles.sendFullTitle(u, Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(0), "", Messages.getMsg("x-attacked").replace("{villager}", Messages.getMsg("forum.TRAINING_CENTER.displayname"))); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\EntityDamageByEntityListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */