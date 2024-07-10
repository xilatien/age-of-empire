/*     */ package com.andrei1058.ageofempire.locations;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.Misc;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.configuration.Settings;
/*     */ import com.andrei1058.ageofempire.game.BuildSchematic;
/*     */ import com.andrei1058.ageofempire.game.Buildings;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.entity.ArmorStand;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class Region {
/*  18 */   private static ArrayList<Region> regions = new ArrayList<>();
/*     */   
/*     */   private Location loc1;
/*     */   private Location loc2;
/*     */   private boolean small;
/*     */   private boolean medium;
/*     */   private boolean large;
/*     */   private boolean used = false;
/*     */   private String name;
/*     */   ArmorStand as;
/*     */   
/*     */   public Region(Location center, boolean small, boolean medium, boolean large, String name) {
/*  30 */     this.small = small;
/*  31 */     this.medium = medium;
/*  32 */     this.large = large;
/*  33 */     this.name = name;
/*  34 */     String string = null;
/*  35 */     if (this.small) {
/*  36 */       this.loc1 = center.clone().add(-Settings.load().getInt("plot-radius.small"), -2.0D, -Settings.load().getInt("plot-radius.small"));
/*  37 */       this.loc2 = center.clone().add(Settings.load().getInt("plot-radius.small"), 1.0D, Settings.load().getInt("plot-radius.small"));
/*  38 */       string = Messages.getMsg("plot.small");
/*  39 */     } else if (medium) {
/*  40 */       this.loc1 = center.clone().add(-Settings.load().getInt("plot-radius.medium"), -2.0D, -Settings.load().getInt("plot-radius.medium"));
/*  41 */       this.loc2 = center.clone().add(Settings.load().getInt("plot-radius.medium"), 1.0D, Settings.load().getInt("plot-radius.medium"));
/*  42 */       string = Messages.getMsg("plot.medium");
/*  43 */     } else if (large) {
/*  44 */       this.loc1 = center.clone().add(-Settings.load().getInt("plot-radius.large"), -2.0D, -Settings.load().getInt("plot-radius.large"));
/*  45 */       this.loc2 = center.clone().add(Settings.load().getInt("plot-radius.large"), 1.0D, Settings.load().getInt("plot-radius.large"));
/*  46 */       string = Messages.getMsg("plot.large");
/*     */     } 
/*  48 */     String finalString = string;
/*  49 */     this.as = (ArmorStand)center.clone().getWorld().spawnEntity(center.clone().add(0.0D, 5.0D, 0.0D), EntityType.ARMOR_STAND);
/*  50 */     this.as.setGravity(false);
/*  51 */     this.as.setCanPickupItems(false);
/*  52 */     this.as.setCustomName(finalString);
/*  53 */     this.as.setCustomNameVisible(true);
/*  54 */     this.as.setVisible(false);
/*  55 */     regions.add(this);
/*     */   }
/*     */   
/*     */   public void removeHologram() {
/*  59 */     this.as.remove();
/*     */   }
/*     */   
/*     */   public boolean isInRegion(Location loc) {
/*  63 */     Location low = new Location(this.loc1.getWorld(), Math.min(this.loc1.getX(), this.loc2.getX()), Math.min(this.loc1.getY(), this.loc2.getY()), Math.min(this.loc1.getZ(), this.loc2.getZ()));
/*  64 */     Location high = new Location(this.loc1.getWorld(), Math.max(this.loc1.getX(), this.loc2.getX()), Math.max(this.loc1.getY(), this.loc2.getY()), Math.max(this.loc1.getZ(), this.loc2.getZ()));
/*  65 */     return (loc.getX() <= high.getX() && loc.getX() >= low.getX() && loc.getY() <= high.getY() && loc.getY() >= low.getY() && loc.getZ() <= high.getZ() && loc.getZ() >= low.getZ());
/*     */   }
/*     */   
/*     */   public void allowed(Player player) {
/*  69 */     switch (this.name) {
/*     */       case "Blue":
/*  71 */         if (Main.bluePlayers.contains(player)) {
/*  72 */           if (!Buildings.hasBuild((String)Buildings.construct_in_inv.get(player), "Blue")) {
/*  73 */             rightPlot(player); break;
/*     */           } 
/*  75 */           player.getInventory().setItem(7, Misc.slotlocked());
/*     */           break;
/*     */         } 
/*  78 */         player.sendMessage(Messages.getMsg("cant-construct-outside"));
/*     */         break;
/*     */       
/*     */       case "Green":
/*  82 */         if (Main.greenPlayers.contains(player)) {
/*  83 */           if (!Buildings.hasBuild((String)Buildings.construct_in_inv.get(player), "Green")) {
/*  84 */             rightPlot(player); break;
/*     */           } 
/*  86 */           player.getInventory().setItem(7, Misc.slotlocked());
/*     */           break;
/*     */         } 
/*  89 */         player.sendMessage(Messages.getMsg("cant-construct-outside"));
/*     */         break;
/*     */       
/*     */       case "Yellow":
/*  93 */         if (Main.yellowPlayers.contains(player)) {
/*  94 */           if (!Buildings.hasBuild((String)Buildings.construct_in_inv.get(player), "Yellow")) {
/*  95 */             rightPlot(player); break;
/*     */           } 
/*  97 */           player.getInventory().setItem(7, Misc.slotlocked());
/*     */           break;
/*     */         } 
/* 100 */         player.sendMessage(Messages.getMsg("cant-construct-outside"));
/*     */         break;
/*     */       
/*     */       case "Red":
/* 104 */         if (Main.redPlayers.contains(player)) {
/* 105 */           if (!Buildings.hasBuild((String)Buildings.construct_in_inv.get(player), "Red")) {
/* 106 */             rightPlot(player); break;
/*     */           } 
/* 108 */           player.getInventory().setItem(7, Misc.slotlocked());
/*     */           break;
/*     */         } 
/* 111 */         player.sendMessage(Messages.getMsg("cant-construct-outside"));
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void check(Location loc, Player player) {
/* 118 */     if (getRegion(loc) != null) {
/* 119 */       if (!(getRegion(loc)).used) {
/* 120 */         getRegion(loc).allowed(player);
/*     */       } else {
/* 122 */         player.sendMessage(Messages.getMsg("cant-construct-here"));
/*     */       } 
/*     */     } else {
/* 125 */       player.sendMessage(Messages.getMsg("cant-construct-here"));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean place(Location loc) {
/* 130 */     return (getRegion(loc) == null);
/*     */   }
/*     */   
/*     */   private static Region getRegion(Location loc) {
/* 134 */     for (Region r : regions) {
/* 135 */       if (r.isInRegion(loc)) {
/* 136 */         return r;
/*     */       }
/*     */     } 
/* 139 */     return null;
/*     */   }
/*     */   
/*     */   private boolean isSmall() {
/* 143 */     return this.small;
/*     */   }
/*     */   private boolean isMedium() {
/* 146 */     return this.medium;
/*     */   }
/*     */   private boolean isLarge() {
/* 149 */     return this.large;
/*     */   }
/*     */   
/*     */   private void rightPlot(Player player) {
/* 153 */     switch ((String)Buildings.construct_in_inv.get(player)) {
/*     */       case "FORGE":
/*     */       case "MILL":
/*     */       case "STONE_MINE":
/*     */       case "GOLD_MINE":
/*     */       case "SAWMILL":
/*     */       case "WORKSHOP":
/*     */       case "MARKET":
/*     */       case "KENNEL":
/*     */       case "SABOTAGE_WORKSHOP":
/* 163 */         if (isSmall()) {
/* 164 */           if (Main.bluePlayers.contains(player)) {
/* 165 */             if (Main.blue_small_plots > 0) {
/* 166 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 167 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 168 */               removeHologram();
/* 169 */               Main.blue_small_plots--;
/* 170 */               this.used = true; break;
/*     */             } 
/* 172 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 173 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 175 */           if (Main.greenPlayers.contains(player)) {
/* 176 */             if (Main.green_small_plots > 0) {
/* 177 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 178 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 179 */               removeHologram();
/* 180 */               Main.green_small_plots--;
/* 181 */               this.used = true; break;
/*     */             } 
/* 183 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 184 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 186 */           if (Main.yellowPlayers.contains(player)) {
/* 187 */             if (Main.yellow_small_plots > 0) {
/* 188 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 189 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 190 */               removeHologram();
/* 191 */               Main.yellow_small_plots--;
/* 192 */               this.used = true; break;
/*     */             } 
/* 194 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 195 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 197 */           if (Main.redPlayers.contains(player)) {
/* 198 */             if (Main.red_small_plots > 0) {
/* 199 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 200 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 201 */               removeHologram();
/* 202 */               Main.red_small_plots--;
/* 203 */               this.used = true; break;
/*     */             } 
/* 205 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 206 */             BuildSchematic.getPlayer(player).end();
/*     */           } 
/*     */           break;
/*     */         } 
/* 210 */         player.sendMessage(Messages.getMsg("cant-construct-size"));
/*     */         break;
/*     */       
/*     */       case "ARCHERY_STORE":
/*     */       case "TRIFARROW":
/*     */       case "STABLE":
/*     */       case "ARMORY":
/*     */       case "LABORATORY":
/* 218 */         if (isMedium()) {
/* 219 */           if (Main.bluePlayers.contains(player)) {
/* 220 */             if (Main.blue_medium_plots > 0) {
/* 221 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 222 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 223 */               removeHologram();
/* 224 */               Main.blue_medium_plots--;
/* 225 */               this.used = true; break;
/*     */             } 
/* 227 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 228 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 230 */           if (Main.greenPlayers.contains(player)) {
/* 231 */             if (Main.green_medium_plots > 0) {
/* 232 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 233 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 234 */               removeHologram();
/* 235 */               Main.green_medium_plots--;
/* 236 */               this.used = true; break;
/*     */             } 
/* 238 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 239 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 241 */           if (Main.yellowPlayers.contains(player)) {
/* 242 */             if (Main.yellow_medium_plots > 0) {
/* 243 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 244 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 245 */               removeHologram();
/* 246 */               Main.yellow_medium_plots--;
/* 247 */               this.used = true; break;
/*     */             } 
/* 249 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 250 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 252 */           if (Main.redPlayers.contains(player)) {
/* 253 */             if (Main.red_medium_plots > 0) {
/* 254 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 255 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 256 */               removeHologram();
/* 257 */               Main.red_medium_plots--;
/* 258 */               this.used = true; break;
/*     */             } 
/* 260 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 261 */             BuildSchematic.getPlayer(player).end();
/*     */           } 
/*     */           break;
/*     */         } 
/* 265 */         player.sendMessage(Messages.getMsg("cant-construct-size"));
/*     */         break;
/*     */       
/*     */       case "GUILD":
/*     */       case "TRAINING_CENTER":
/* 270 */         if (isLarge()) {
/* 271 */           if (Main.bluePlayers.contains(player)) {
/* 272 */             if (Main.blue_large_plots > 0) {
/* 273 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 274 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 275 */               removeHologram();
/* 276 */               Main.blue_large_plots--;
/* 277 */               this.used = true; break;
/*     */             } 
/* 279 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 280 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 282 */           if (Main.greenPlayers.contains(player)) {
/* 283 */             if (Main.green_large_plots > 0) {
/* 284 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 285 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 286 */               removeHologram();
/* 287 */               Main.green_large_plots--;
/* 288 */               this.used = true; break;
/*     */             } 
/* 290 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 291 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 293 */           if (Main.yellowPlayers.contains(player)) {
/* 294 */             if (Main.yellow_large_plots > 0) {
/* 295 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 296 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 297 */               removeHologram();
/* 298 */               Main.yellow_large_plots--;
/* 299 */               this.used = true; break;
/*     */             } 
/* 301 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 302 */             BuildSchematic.getPlayer(player).end(); break;
/*     */           } 
/* 304 */           if (Main.redPlayers.contains(player)) {
/* 305 */             if (Main.red_large_plots > 0) {
/* 306 */               player.getInventory().setItem(7, Misc.slotlocked());
/* 307 */               BuildSchematic.getPlayer(player).ok(this.loc1);
/* 308 */               removeHologram();
/* 309 */               Main.red_large_plots--;
/* 310 */               this.used = true; break;
/*     */             } 
/* 312 */             player.getInventory().setItem(7, Misc.slotlocked());
/* 313 */             BuildSchematic.getPlayer(player).end();
/*     */           } 
/*     */           break;
/*     */         } 
/* 317 */         player.sendMessage(Messages.getMsg("cant-construct-size"));
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadRegions() {
/* 324 */     List<String> teams = Arrays.asList(new String[] { "Blue", "Green", "Yellow", "Red" });
/* 325 */     for (String s : teams) {
/* 326 */       for (String key : Locations.load().getConfigurationSection("Plots." + Main.choosenMap + "." + s + ".Small").getKeys(false)) {
/* 327 */         new Region(Locations.getLoc("Plots." + Main.choosenMap + "." + s + ".Small." + key), true, false, false, s);
/*     */       }
/* 329 */       for (String key : Locations.load().getConfigurationSection("Plots." + Main.choosenMap + "." + s + ".Medium").getKeys(false)) {
/* 330 */         new Region(Locations.getLoc("Plots." + Main.choosenMap + "." + s + ".Medium." + key), false, true, false, s);
/*     */       }
/* 332 */       for (String key : Locations.load().getConfigurationSection("Plots." + Main.choosenMap + "." + s + ".Large").getKeys(false))
/* 333 */         new Region(Locations.getLoc("Plots." + Main.choosenMap + "." + s + ".Large." + key), false, false, true, s); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\locations\Region.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */