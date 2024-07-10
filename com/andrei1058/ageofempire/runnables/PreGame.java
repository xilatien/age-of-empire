/*     */ package com.andrei1058.ageofempire.runnables;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.Misc;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.configuration.Settings;
/*     */ import com.andrei1058.ageofempire.game.Hologram;
/*     */ import com.andrei1058.ageofempire.game.Scoreboard;
/*     */ import com.andrei1058.ageofempire.game.Status;
/*     */ import com.andrei1058.ageofempire.locations.Locations;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ public class PreGame
/*     */   extends BukkitRunnable
/*     */ {
/*     */   public void run() {
/*  25 */     if (Main.pregame_time != 0) {
/*  26 */       Main.pregame_time--;
/*     */     }
/*  28 */     if (Bukkit.getOnlinePlayers().size() < 2) {
/*  29 */       cancel();
/*  30 */       (new Restart()).runTaskTimer((Plugin)Main.plugin, 0L, 20L);
/*  31 */       Main.STATUS = Status.RESTARTING;
/*     */     } 
/*  33 */     if (Main.pregame_time == 2) {
/*  34 */       for (Player p : Bukkit.getOnlinePlayers()) {
/*  35 */         if (Main.bluePlayers.contains(p) || Main.yellowPlayers.contains(p) || Main.redPlayers.contains(p) || Main.greenPlayers.contains(p)) {
/*     */           continue;
/*     */         }
/*  38 */         if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 3) {
/*  39 */           if (Main.bluePlayers.isEmpty()) {
/*  40 */             Main.bluePlayers.add(p); continue;
/*  41 */           }  if (Main.greenPlayers.isEmpty()) {
/*  42 */             Main.greenPlayers.add(p); continue;
/*  43 */           }  if (Main.yellowPlayers.isEmpty()) {
/*  44 */             Main.yellowPlayers.add(p); continue;
/*  45 */           }  if (Main.redPlayers.isEmpty()) {
/*  46 */             Main.redPlayers.add(p); continue;
/*  47 */           }  if (Main.bluePlayers.size() <= Main.max_in_team && Main.bluePlayers.size() <= Main.greenPlayers.size() && Main.bluePlayers.size() <= Main.yellowPlayers.size() && Main.bluePlayers.size() <= Main.redPlayers.size()) {
/*  48 */             Main.bluePlayers.add(p); continue;
/*  49 */           }  if (Main.greenPlayers.size() <= Main.max_in_team && Main.greenPlayers.size() < Main.bluePlayers.size() && Main.greenPlayers.size() < Main.yellowPlayers.size() && Main.greenPlayers.size() < Main.redPlayers.size()) {
/*  50 */             Main.greenPlayers.add(p); continue;
/*  51 */           }  if (Main.yellowPlayers.size() <= Main.max_in_team && Main.yellowPlayers.size() <= Main.bluePlayers.size() && Main.yellowPlayers.size() <= Main.greenPlayers.size() && Main.yellowPlayers.size() <= Main.redPlayers.size()) {
/*  52 */             Main.yellowPlayers.add(p); continue;
/*  53 */           }  if (Main.redPlayers.size() <= Main.max_in_team && Main.redPlayers.size() <= Main.bluePlayers.size() && Main.redPlayers.size() <= Main.greenPlayers.size() && Main.redPlayers.size() <= Main.yellowPlayers.size()) {
/*  54 */             Main.redPlayers.add(p); continue;
/*     */           } 
/*  56 */           p.kickPlayer("Teams are full"); continue;
/*     */         } 
/*  58 */         if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 2) {
/*  59 */           if (Main.bluePlayers.isEmpty()) {
/*  60 */             Main.bluePlayers.add(p); continue;
/*  61 */           }  if (Main.greenPlayers.isEmpty()) {
/*  62 */             Main.greenPlayers.add(p); continue;
/*  63 */           }  if (Main.yellowPlayers.isEmpty()) {
/*  64 */             Main.yellowPlayers.add(p); continue;
/*  65 */           }  if (Main.bluePlayers.size() <= Main.max_in_team && Main.bluePlayers.size() <= Main.greenPlayers.size() && Main.bluePlayers.size() <= Main.yellowPlayers.size()) {
/*  66 */             Main.bluePlayers.add(p); continue;
/*  67 */           }  if (Main.greenPlayers.size() <= Main.max_in_team && Main.greenPlayers.size() <= Main.bluePlayers.size() && Main.greenPlayers.size() <= Main.yellowPlayers.size()) {
/*  68 */             Main.greenPlayers.add(p); continue;
/*  69 */           }  if (Main.yellowPlayers.size() <= Main.max_in_team && Main.yellowPlayers.size() <= Main.bluePlayers.size() && Main.yellowPlayers.size() <= Main.greenPlayers.size()) {
/*  70 */             Main.yellowPlayers.add(p); continue;
/*     */           } 
/*  72 */           p.kickPlayer("Teams are full");
/*     */           continue;
/*     */         } 
/*  75 */         if (Main.bluePlayers.isEmpty()) {
/*  76 */           Main.bluePlayers.add(p); continue;
/*  77 */         }  if (Main.greenPlayers.isEmpty()) {
/*  78 */           Main.greenPlayers.add(p); continue;
/*  79 */         }  if (Main.bluePlayers.size() <= Main.max_in_team && Main.bluePlayers.size() <= Main.greenPlayers.size()) {
/*  80 */           Main.bluePlayers.add(p); continue;
/*  81 */         }  if (Main.greenPlayers.size() <= Main.max_in_team && Main.greenPlayers.size() <= Main.bluePlayers.size()) {
/*  82 */           Main.greenPlayers.add(p); continue;
/*     */         } 
/*  84 */         p.kickPlayer("Teams are full");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     if (Main.pregame_time > 0) {
/*  92 */       for (Player p : Bukkit.getOnlinePlayers()) {
/*  93 */         Main.nms.actionMsg(p, Messages.getMsg("game-start").replace("{time}", String.valueOf(Main.pregame_time)));
/*  94 */         p.getWorld().playSound(p.getLocation(), Main.nms.click(), 1.0F, 1.0F);
/*     */       } 
/*     */     }
/*  97 */     if (Main.pregame_time == 0) {
/*  98 */       cancel();
/*  99 */       Main.STATUS = Status.PLAYING;
/* 100 */       for (Player p : Bukkit.getOnlinePlayers()) {
/* 101 */         Main.players.add(p);
/* 102 */         p.getInventory().clear();
/* 103 */         p.setHealth(20.0D);
/* 104 */         p.setFoodLevel(20);
/* 105 */         p.setGameMode(GameMode.SURVIVAL);
/* 106 */         if (Main.bluePlayers.contains(p)) {
/* 107 */           p.teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Blue"));
/* 108 */           p.getInventory().setHelmet(Misc.leatherArmor(Material.LEATHER_HELMET, Color.BLUE));
/* 109 */           p.getInventory().setChestplate(Misc.leatherArmor(Material.LEATHER_CHESTPLATE, Color.BLUE));
/* 110 */           p.getInventory().setBoots(Misc.leatherArmor(Material.LEATHER_BOOTS, Color.BLUE));
/* 111 */           p.getInventory().setLeggings(Misc.leatherArmor(Material.LEATHER_LEGGINGS, Color.BLUE));
/* 112 */           p.setDisplayName("§9" + p.getName());
/* 113 */         } else if (Main.greenPlayers.contains(p)) {
/* 114 */           p.teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Green"));
/* 115 */           p.getInventory().setHelmet(Misc.leatherArmor(Material.LEATHER_HELMET, Color.GREEN));
/* 116 */           p.getInventory().setChestplate(Misc.leatherArmor(Material.LEATHER_CHESTPLATE, Color.GREEN));
/* 117 */           p.getInventory().setBoots(Misc.leatherArmor(Material.LEATHER_BOOTS, Color.GREEN));
/* 118 */           p.getInventory().setLeggings(Misc.leatherArmor(Material.LEATHER_LEGGINGS, Color.GREEN));
/* 119 */           p.setDisplayName("§a" + p.getDisplayName());
/* 120 */         } else if (Main.yellowPlayers.contains(p)) {
/* 121 */           p.teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Yellow"));
/* 122 */           p.getInventory().setHelmet(Misc.leatherArmor(Material.LEATHER_HELMET, Color.YELLOW));
/* 123 */           p.getInventory().setChestplate(Misc.leatherArmor(Material.LEATHER_CHESTPLATE, Color.YELLOW));
/* 124 */           p.getInventory().setBoots(Misc.leatherArmor(Material.LEATHER_BOOTS, Color.YELLOW));
/* 125 */           p.getInventory().setLeggings(Misc.leatherArmor(Material.LEATHER_LEGGINGS, Color.YELLOW));
/* 126 */           p.setDisplayName("§e" + p.getName());
/* 127 */         } else if (Main.redPlayers.contains(p)) {
/* 128 */           p.teleport(Locations.getLoc("Spawns." + Main.choosenMap + ".Red"));
/* 129 */           p.getInventory().setHelmet(Misc.leatherArmor(Material.LEATHER_HELMET, Color.RED));
/* 130 */           p.getInventory().setChestplate(Misc.leatherArmor(Material.LEATHER_CHESTPLATE, Color.RED));
/* 131 */           p.getInventory().setBoots(Misc.leatherArmor(Material.LEATHER_BOOTS, Color.RED));
/* 132 */           p.getInventory().setLeggings(Misc.leatherArmor(Material.LEATHER_LEGGINGS, Color.RED));
/* 133 */           p.setDisplayName("§c" + p.getName());
/*     */         } 
/* 135 */         ItemStack pick = new ItemStack(Material.STONE_PICKAXE);
/* 136 */         ItemMeta pickMeta = pick.getItemMeta();
/* 137 */         pickMeta.spigot().setUnbreakable(true);
/* 138 */         pick.setItemMeta(pickMeta);
/*     */         
/* 140 */         ItemStack axe = new ItemStack(Material.STONE_AXE);
/* 141 */         ItemMeta axeMeta = axe.getItemMeta();
/* 142 */         axeMeta.spigot().setUnbreakable(true);
/* 143 */         axe.setItemMeta(axeMeta);
/*     */         
/* 145 */         p.getInventory().addItem(new ItemStack[] { pick });
/* 146 */         p.getInventory().addItem(new ItemStack[] { axe });
/* 147 */         p.getInventory().setItem(8, Misc.slotlocked());
/* 148 */         p.getInventory().setItem(7, Misc.slotlocked());
/* 149 */         p.getInventory().setItem(6, Misc.forumPaper());
/* 150 */         Main.gold.put(p, Integer.valueOf(100));
/*     */       } 
/* 152 */       Scoreboard.register();
/* 153 */       Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> {
/*     */             try {
/*     */               if (!Main.bluePlayers.isEmpty()) {
/*     */                 Main.blue_villager = Main.nms.spawnVillager(Locations.getLoc("Forums." + Main.choosenMap + ".Blue"), Integer.valueOf(Main.forum_health));
/*     */                 
/*     */                 new Hologram(Locations.getLoc("Forums." + Main.choosenMap + ".Blue").clone(), Messages.getMsg("villagers.forum"), Messages.getMsg("villagers.buy-buildings"), Main.blue_villager);
/*     */               } 
/*     */               
/*     */               if (!Main.greenPlayers.isEmpty()) {
/*     */                 Main.green_villager = Main.nms.spawnVillager(Locations.getLoc("Forums." + Main.choosenMap + ".Green"), Integer.valueOf(Main.forum_health));
/*     */                 
/*     */                 new Hologram(Locations.getLoc("Forums." + Main.choosenMap + ".Green").clone(), Messages.getMsg("villagers.forum"), Messages.getMsg("villagers.buy-buildings"), Main.green_villager);
/*     */               } 
/*     */               
/*     */               if (!Main.yellowPlayers.isEmpty()) {
/*     */                 Main.yellow_villager = Main.nms.spawnVillager(Locations.getLoc("Forums." + Main.choosenMap + ".Yellow"), Integer.valueOf(Main.forum_health));
/*     */                 new Hologram(Locations.getLoc("Forums." + Main.choosenMap + ".Yellow").clone(), Messages.getMsg("villagers.forum"), Messages.getMsg("villagers.buy-buildings"), Main.yellow_villager);
/*     */               } 
/*     */               if (!Main.redPlayers.isEmpty()) {
/*     */                 Main.red_villager = Main.nms.spawnVillager(Locations.getLoc("Forums." + Main.choosenMap + ".Red"), Integer.valueOf(Main.forum_health));
/*     */                 new Hologram(Locations.getLoc("Forums." + Main.choosenMap + ".Red").clone(), Messages.getMsg("villagers.forum"), Messages.getMsg("villagers.buy-buildings"), Main.red_villager);
/*     */               } 
/* 175 */             } catch (Exception e) {
/*     */               e.printStackTrace();
/*     */             } 
/*     */           }30L);
/* 179 */       Main.pvp_assault = (60000 * Settings.load().getInt("countdowns.pvp"));
/* 180 */       (new Game()).runTaskTimer((Plugin)Main.plugin, 0L, 20L);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\runnables\PreGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */