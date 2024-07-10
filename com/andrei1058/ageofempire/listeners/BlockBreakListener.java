/*     */ package com.andrei1058.ageofempire.listeners;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.game.OreHologram;
/*     */ import com.andrei1058.ageofempire.game.Status;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockBreakListener
/*     */   implements Listener
/*     */ {
/*  25 */   private static ArrayList<Player> woodAnnounced = new ArrayList<>();
/*  26 */   private static ArrayList<Player> goldAnnounced = new ArrayList<>();
/*  27 */   private static ArrayList<Player> stoneAnnounced = new ArrayList<>();
/*     */   
/*     */   @EventHandler
/*     */   public void b(BlockBreakEvent e) {
/*  31 */     if (Main.SETUP)
/*  32 */       return;  if (Main.STATUS == Status.PLAYING) {
/*  33 */       switch (e.getBlock().getType()) {
/*     */         case LEAVES:
/*  35 */           if (Main.placedBlocks.contains(e.getBlock())) {
/*  36 */             Main.placedBlocks.remove(e.getBlock());
/*     */           }
/*     */           return;
/*     */         case LOG:
/*  40 */           if (e.getBlock().getData() == 13 || e.getBlock().getData() == 1) {
/*  41 */             e.setCancelled(true);
/*  42 */             e.getBlock().setType(Material.AIR);
/*  43 */             if (Main.help.contains(e.getPlayer())) {
/*  44 */               if (!woodAnnounced.contains(e.getPlayer())) {
/*  45 */                 e.getPlayer().sendMessage(Messages.getMsg("help.cutting-wood"));
/*  46 */                 woodAnnounced.add(e.getPlayer());
/*     */               } 
/*  48 */               if (!goldAnnounced.contains(e.getPlayer())) {
/*  49 */                 e.getPlayer().sendMessage(Messages.getMsg("help.gold-stuff"));
/*  50 */                 goldAnnounced.add(e.getPlayer());
/*     */               } 
/*     */             } 
/*     */             
/*  54 */             Random r = new Random();
/*  55 */             int gold = r.nextInt(2) + 1;
/*  56 */             new OreHologram(e.getBlock().getLocation(), Integer.valueOf(gold), false);
/*  57 */             if (Main.bluePlayers.contains(e.getPlayer())) {
/*  58 */               Main.blue_wood += 3;
/*  59 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/*  60 */             } else if (Main.greenPlayers.contains(e.getPlayer())) {
/*  61 */               Main.green_wood += 3;
/*  62 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/*  63 */             } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/*  64 */               Main.yellow_wood += 3;
/*  65 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/*  66 */             } else if (Main.redPlayers.contains(e.getPlayer())) {
/*  67 */               Main.red_wood += 3;
/*  68 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/*     */             } 
/*  70 */             e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Main.nms.levelUp(), 1.0F, 1.0F);
/*     */           } else {
/*  72 */             e.setCancelled(true);
/*  73 */             e.getPlayer().sendMessage(Messages.getMsg("cant-break"));
/*     */           } 
/*     */           return;
/*     */         case STONE:
/*  77 */           if (e.getBlock().getData() == 5) {
/*  78 */             if (Main.help.contains(e.getPlayer())) {
/*  79 */               if (!stoneAnnounced.contains(e.getPlayer())) {
/*  80 */                 e.getPlayer().sendMessage(Messages.getMsg("help.stone"));
/*  81 */                 stoneAnnounced.add(e.getPlayer());
/*     */               } 
/*  83 */               if (!goldAnnounced.contains(e.getPlayer())) {
/*  84 */                 e.getPlayer().sendMessage(Messages.getMsg("help.gold-stuff"));
/*  85 */                 goldAnnounced.add(e.getPlayer());
/*     */               } 
/*     */             } 
/*  88 */             e.getBlock().breakNaturally(new ItemStack(Material.STICK));
/*  89 */             int gold = 0;
/*  90 */             Random r = new Random();
/*  91 */             gold = r.nextInt(2) + 1;
/*  92 */             new OreHologram(e.getBlock().getLocation(), Integer.valueOf(gold), true);
/*  93 */             if (Main.bluePlayers.contains(e.getPlayer())) {
/*  94 */               Main.blue_stone += 3;
/*  95 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/*  96 */             } else if (Main.greenPlayers.contains(e.getPlayer())) {
/*  97 */               Main.green_stone += 3;
/*  98 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/*  99 */             } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 100 */               Main.yellow_stone += 3;
/* 101 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/* 102 */             } else if (Main.redPlayers.contains(e.getPlayer())) {
/* 103 */               Main.red_stone += 3;
/* 104 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/*     */             } 
/* 106 */             e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Main.nms.levelUp(), 1.0F, 1.0F);
/*     */           } else {
/* 108 */             e.setCancelled(true);
/* 109 */             e.getPlayer().sendMessage(Messages.getMsg("cant-break"));
/*     */           } 
/*     */           return;
/*     */         case SEA_LANTERN:
/* 113 */           if (Main.xp.contains(new Location(Bukkit.getWorld(Main.choosenMap), e.getBlock().getLocation().getBlockX(), e.getBlock().getLocation().getBlockY(), e.getBlock().getLocation().getBlockZ()))) {
/*     */             
/* 115 */             e.getPlayer().giveExp(1);
/* 116 */             Random r = new Random();
/* 117 */             int gold = r.nextInt(2) + 1;
/* 118 */             if (Main.bluePlayers.contains(e.getPlayer())) {
/* 119 */               Main.blue_stone += 3;
/* 120 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/* 121 */               Main.blue_wood += 3;
/* 122 */             } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 123 */               Main.green_stone += 3;
/* 124 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/* 125 */               Main.green_wood += 3;
/* 126 */             } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 127 */               Main.yellow_stone += 3;
/* 128 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/* 129 */               Main.yellow_wood += 3;
/* 130 */             } else if (Main.redPlayers.contains(e.getPlayer())) {
/* 131 */               Main.red_stone += 3;
/* 132 */               Main.gold.replace(e.getPlayer(), Integer.valueOf(((Integer)Main.gold.get(e.getPlayer())).intValue() + gold));
/* 133 */               Main.red_wood += 3;
/*     */             } 
/* 135 */             new OreHologram(e.getBlock().getLocation(), Integer.valueOf(gold), true);
/* 136 */             new OreHologram(e.getBlock().getLocation(), Integer.valueOf(gold), false);
/*     */           } 
/* 138 */           e.setCancelled(true);
/*     */           return;
/*     */         case MELON_BLOCK:
/* 141 */           e.setCancelled(false);
/*     */           return;
/*     */         case GRASS:
/*     */         case DIRT:
/*     */         case WOOD_DOUBLE_STEP:
/*     */         case SAND:
/*     */         case GRAVEL:
/*     */         case SPONGE:
/*     */         case GLASS:
/*     */         case LAPIS_BLOCK:
/*     */         case WOOL:
/*     */         case BRICK:
/*     */         case MOSSY_COBBLESTONE:
/*     */         case LEAVES_2:
/* 155 */           if (Main.placedBlocks.contains(e.getBlock())) {
/* 156 */             Main.placedBlocks.remove(e.getBlock());
/*     */           } else {
/* 158 */             e.setCancelled(true);
/* 159 */             e.getPlayer().sendMessage(Messages.getMsg("cant-break"));
/*     */           } 
/*     */           return;
/*     */       } 
/* 163 */       e.setCancelled(true);
/* 164 */       e.getPlayer().sendMessage(Messages.getMsg("cant-break"));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\BlockBreakListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */