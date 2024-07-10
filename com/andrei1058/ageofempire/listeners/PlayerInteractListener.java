/*     */ package com.andrei1058.ageofempire.listeners;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.Misc;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.configuration.MySQL;
/*     */ import com.andrei1058.ageofempire.configuration.Settings;
/*     */ import com.andrei1058.ageofempire.game.Buildings;
/*     */ import com.andrei1058.ageofempire.game.Status;
/*     */ import com.andrei1058.ageofempire.game.Vote;
/*     */ import com.google.common.io.ByteArrayDataOutput;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import java.util.ArrayList;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.inventory.InventoryType;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ public class PlayerInteractListener
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void i(PlayerInteractEvent e) {
/*  32 */     if (Main.SETUP)
/*  33 */       return;  if (Main.STATUS == Status.STARTING || Main.STATUS == Status.LOBBY) {
/*  34 */       if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
/*  35 */         if (Main.nms.itemInHand(e.getPlayer()).getType() == Material.STAINED_GLASS_PANE) {
/*  36 */           if (Main.help.contains(e.getPlayer())) {
/*  37 */             Main.help.remove(e.getPlayer());
/*  38 */             ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
/*  39 */             ItemMeta itemMeta = i.getItemMeta();
/*  40 */             itemMeta.setDisplayName(Messages.getMsg("help-item-off"));
/*  41 */             i.setItemMeta(itemMeta);
/*  42 */             e.getPlayer().getInventory().setItem(4, i);
/*  43 */             e.getPlayer().sendMessage(Main.PREFIX + " " + Messages.getMsg("help-item-off"));
/*     */           } else {
/*  45 */             Main.help.add(e.getPlayer());
/*  46 */             ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
/*  47 */             ItemMeta itemMeta = i.getItemMeta();
/*  48 */             itemMeta.setDisplayName(Messages.getMsg("help-item-on"));
/*  49 */             i.setItemMeta(itemMeta);
/*  50 */             e.getPlayer().getInventory().setItem(4, i);
/*  51 */             e.getPlayer().sendMessage(Main.PREFIX + " " + Messages.getMsg("help-item-on"));
/*     */           } 
/*     */           return;
/*     */         } 
/*  55 */         if (Main.nms.itemInHand(e.getPlayer()).getType() == Material.BED) {
/*  56 */           ByteArrayDataOutput out = ByteStreams.newDataOutput();
/*  57 */           out.writeUTF("Connect");
/*  58 */           out.writeUTF(Settings.load().getString("lobby-server"));
/*  59 */           e.getPlayer().sendPluginMessage((Plugin)Main.plugin, "BungeeCord", out.toByteArray());
/*     */           return;
/*     */         } 
/*  62 */         if (Main.nms.itemInHand(e.getPlayer()).getType() == Material.SKULL_ITEM) {
/*  63 */           if (!Main.nms.itemInHand(e.getPlayer()).hasItemMeta()) {
/*     */             return;
/*     */           }
/*  66 */           if (!Main.nms.itemInHand(e.getPlayer()).getItemMeta().hasDisplayName()) {
/*     */             return;
/*     */           }
/*  69 */           if (!Main.nms.itemInHand(e.getPlayer()).getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("stats.displayname"))) {
/*     */             return;
/*     */           }
/*  72 */           Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, Messages.getMsg("stats.displayname"));
/*  73 */           ArrayList stats = (new MySQL()).getStats(e.getPlayer().getUniqueId());
/*  74 */           ItemStack i = new ItemStack(Material.GOLDEN_APPLE);
/*  75 */           ItemMeta im = i.getItemMeta();
/*  76 */           im.setDisplayName(Messages.getMsg("stats.wins").replace("%wins%", String.valueOf(stats.get(0))));
/*  77 */           i.setItemMeta(im);
/*  78 */           inv.setItem(0, i);
/*     */           
/*  80 */           ItemStack i2 = new ItemStack(Material.IRON_SWORD);
/*  81 */           ItemMeta im2 = i2.getItemMeta();
/*  82 */           im2.setDisplayName(Messages.getMsg("stats.kills").replace("%kills%", String.valueOf(stats.get(2))));
/*  83 */           i2.setItemMeta(im2);
/*  84 */           inv.setItem(1, i2);
/*     */           
/*  86 */           ItemStack i3 = new ItemStack(Material.YELLOW_FLOWER);
/*  87 */           ItemMeta im3 = i3.getItemMeta();
/*  88 */           im3.setDisplayName(Messages.getMsg("stats.deaths").replace("%deaths%", String.valueOf(stats.get(3))));
/*  89 */           i3.setItemMeta(im3);
/*  90 */           inv.setItem(2, i3);
/*     */           
/*  92 */           ItemStack i4 = new ItemStack(Material.WATER_LILY);
/*  93 */           ItemMeta im4 = i4.getItemMeta();
/*  94 */           im4.setDisplayName(Messages.getMsg("stats.gamesplayed").replace("%games%", String.valueOf(stats.get(1))));
/*  95 */           i4.setItemMeta(im4);
/*  96 */           inv.setItem(3, i4);
/*     */           
/*  98 */           ItemStack i5 = new ItemStack(Material.DIAMOND_SWORD);
/*  99 */           ItemMeta im5 = i5.getItemMeta();
/* 100 */           im5.setDisplayName(Messages.getMsg("stats.kingskilled").replace("%kings%", String.valueOf(stats.get(4))));
/* 101 */           i5.setItemMeta(im5);
/* 102 */           inv.setItem(4, i5);
/*     */           
/* 104 */           e.getPlayer().openInventory(inv);
/*     */         } 
/*     */       } 
/* 107 */     } else if (Main.STATUS == Status.PRE_GAME) {
/* 108 */       if ((e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) && 
/* 109 */         Main.nms.itemInHand(e.getPlayer()).getType() == Material.STAINED_GLASS_PANE) {
/* 110 */         if (Main.teamchoose.contains(e.getPlayer())) {
/*     */           return;
/*     */         }
/* 113 */         if (Main.nms.itemInHand(e.getPlayer()).getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("team-choosing.blue"))) {
/* 114 */           if (Main.bluePlayers.contains(e.getPlayer()))
/* 115 */             return;  if (Main.bluePlayers.size() + 1 < Main.max_in_team) {
/* 116 */             if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 3) {
/* 117 */               if (Main.bluePlayers.size() <= Main.greenPlayers.size() || Main.bluePlayers.size() <= Main.yellowPlayers.size() || Main.bluePlayers.size() <= Main.redPlayers.size()) {
/* 118 */                 if (Main.redPlayers.contains(e.getPlayer())) {
/* 119 */                   Main.redPlayers.remove(e.getPlayer());
/* 120 */                 } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 121 */                   Main.yellowPlayers.remove(e.getPlayer());
/* 122 */                 } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 123 */                   Main.greenPlayers.remove(e.getPlayer());
/*     */                 } 
/* 125 */                 Main.teamchoose.add(e.getPlayer());
/* 126 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 127 */                 Main.bluePlayers.add(e.getPlayer());
/* 128 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.blue-join"));
/*     */               } else {
/* 130 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/* 132 */             } else if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 2) {
/* 133 */               if (Main.bluePlayers.size() <= Main.greenPlayers.size() || Main.bluePlayers.size() <= Main.yellowPlayers.size()) {
/* 134 */                 if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 135 */                   Main.yellowPlayers.remove(e.getPlayer());
/* 136 */                 } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 137 */                   Main.greenPlayers.remove(e.getPlayer());
/*     */                 } 
/* 139 */                 Main.teamchoose.add(e.getPlayer());
/* 140 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 141 */                 Main.bluePlayers.add(e.getPlayer());
/* 142 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.blue-join"));
/*     */               } else {
/* 144 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/* 146 */             } else if (Bukkit.getOnlinePlayers().size() >= Main.max_in_team) {
/* 147 */               if (Main.bluePlayers.size() <= Main.greenPlayers.size()) {
/* 148 */                 if (Main.redPlayers.contains(e.getPlayer())) {
/* 149 */                   Main.redPlayers.remove(e.getPlayer());
/* 150 */                 } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 151 */                   Main.yellowPlayers.remove(e.getPlayer());
/* 152 */                 } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 153 */                   Main.greenPlayers.remove(e.getPlayer());
/*     */                 } 
/* 155 */                 Main.teamchoose.add(e.getPlayer());
/* 156 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 157 */                 Main.bluePlayers.add(e.getPlayer());
/* 158 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.blue-join"));
/*     */               } else {
/* 160 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/*     */             } 
/*     */           } else {
/* 164 */             e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */           } 
/* 166 */         } else if (Main.nms.itemInHand(e.getPlayer()).getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("team-choosing.red"))) {
/* 167 */           if (Main.redPlayers.contains(e.getPlayer()))
/* 168 */             return;  if (Main.redPlayers.size() < Main.max_in_team) {
/* 169 */             if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 3) {
/* 170 */               if (Main.redPlayers.size() <= Main.greenPlayers.size() || Main.redPlayers.size() <= Main.yellowPlayers.size() || Main.redPlayers.size() <= Main.bluePlayers.size()) {
/* 171 */                 if (Main.bluePlayers.contains(e.getPlayer())) {
/* 172 */                   Main.bluePlayers.remove(e.getPlayer());
/* 173 */                 } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 174 */                   Main.yellowPlayers.remove(e.getPlayer());
/* 175 */                 } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 176 */                   Main.greenPlayers.remove(e.getPlayer());
/*     */                 } 
/* 178 */                 Main.teamchoose.add(e.getPlayer());
/* 179 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 180 */                 Main.redPlayers.add(e.getPlayer());
/* 181 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.red-join"));
/*     */               } else {
/* 183 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/*     */             }
/*     */           } else {
/* 187 */             e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */           } 
/* 189 */         } else if (Main.nms.itemInHand(e.getPlayer()).getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("team-choosing.yellow"))) {
/* 190 */           if (Main.yellowPlayers.contains(e.getPlayer()))
/* 191 */             return;  if (Main.yellowPlayers.size() < Main.max_in_team) {
/* 192 */             if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 3) {
/* 193 */               if (Main.yellowPlayers.size() <= Main.greenPlayers.size() || Main.yellowPlayers.size() <= Main.bluePlayers.size() || Main.yellowPlayers.size() <= Main.redPlayers.size()) {
/* 194 */                 if (Main.redPlayers.contains(e.getPlayer())) {
/* 195 */                   Main.redPlayers.remove(e.getPlayer());
/* 196 */                 } else if (Main.bluePlayers.contains(e.getPlayer())) {
/* 197 */                   Main.bluePlayers.remove(e.getPlayer());
/* 198 */                 } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 199 */                   Main.greenPlayers.remove(e.getPlayer());
/*     */                 } 
/* 201 */                 Main.teamchoose.add(e.getPlayer());
/* 202 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 203 */                 Main.yellowPlayers.add(e.getPlayer());
/* 204 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.yellow-join"));
/*     */               } else {
/* 206 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/* 208 */             } else if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 2) {
/* 209 */               if (Main.yellowPlayers.size() <= Main.greenPlayers.size() || Main.yellowPlayers.size() <= Main.bluePlayers.size()) {
/* 210 */                 if (Main.bluePlayers.contains(e.getPlayer())) {
/* 211 */                   Main.bluePlayers.remove(e.getPlayer());
/* 212 */                 } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 213 */                   Main.greenPlayers.remove(e.getPlayer());
/*     */                 } 
/* 215 */                 Main.teamchoose.add(e.getPlayer());
/* 216 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 217 */                 Main.yellowPlayers.add(e.getPlayer());
/* 218 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.yellow-join"));
/*     */               } else {
/* 220 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/*     */             } 
/*     */           } else {
/* 224 */             e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */           } 
/* 226 */         } else if (Main.nms.itemInHand(e.getPlayer()).getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("team-choosing.green"))) {
/* 227 */           if (Main.greenPlayers.contains(e.getPlayer()))
/* 228 */             return;  if (Main.greenPlayers.size() < Main.max_in_team) {
/* 229 */             if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 3) {
/* 230 */               if (Main.greenPlayers.size() <= Main.bluePlayers.size() || Main.greenPlayers.size() <= Main.yellowPlayers.size() || Main.greenPlayers.size() <= Main.redPlayers.size()) {
/* 231 */                 if (Main.redPlayers.contains(e.getPlayer())) {
/* 232 */                   Main.redPlayers.remove(e.getPlayer());
/* 233 */                 } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 234 */                   Main.yellowPlayers.remove(e.getPlayer());
/* 235 */                 } else if (Main.bluePlayers.contains(e.getPlayer())) {
/* 236 */                   Main.bluePlayers.remove(e.getPlayer());
/*     */                 } 
/* 238 */                 Main.teamchoose.add(e.getPlayer());
/* 239 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 240 */                 Main.greenPlayers.add(e.getPlayer());
/* 241 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.green-join"));
/*     */               } else {
/* 243 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/* 245 */             } else if (Bukkit.getOnlinePlayers().size() > Main.max_in_team * 2) {
/* 246 */               if (Main.greenPlayers.size() <= Main.bluePlayers.size() || Main.greenPlayers.size() <= Main.yellowPlayers.size()) {
/* 247 */                 if (Main.bluePlayers.contains(e.getPlayer())) {
/* 248 */                   Main.bluePlayers.remove(e.getPlayer());
/* 249 */                 } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 250 */                   Main.yellowPlayers.remove(e.getPlayer());
/*     */                 } 
/* 252 */                 Main.teamchoose.add(e.getPlayer());
/* 253 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 254 */                 Main.greenPlayers.add(e.getPlayer());
/* 255 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.green-join"));
/*     */               } else {
/* 257 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/* 259 */             } else if (Bukkit.getOnlinePlayers().size() >= Main.max_in_team) {
/* 260 */               if (Main.greenPlayers.size() <= Main.bluePlayers.size()) {
/* 261 */                 if (Main.bluePlayers.contains(e.getPlayer())) {
/* 262 */                   Main.bluePlayers.remove(e.getPlayer());
/*     */                 }
/* 264 */                 Main.teamchoose.add(e.getPlayer());
/* 265 */                 Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> Main.teamchoose.remove(e.getPlayer()), 100L);
/* 266 */                 Main.greenPlayers.add(e.getPlayer());
/* 267 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.green-join"));
/*     */               } else {
/* 269 */                 e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */               } 
/*     */             } 
/*     */           } else {
/* 273 */             e.getPlayer().sendMessage(Messages.getMsg("team-choosing.unbalanced-teams"));
/*     */           }
/*     */         
/*     */         } 
/*     */       } 
/* 278 */     } else if (Main.STATUS == Status.PLAYING && (
/* 279 */       e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
/* 280 */       if (Main.nms.itemInHand(e.getPlayer()).getType() == Material.PAPER) {
/* 281 */         if (Main.nms.itemInHand(e.getPlayer()).getItemMeta().getDisplayName() != null && 
/* 282 */           Main.nms.itemInHand(e.getPlayer()).getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("forum-paper"))) {
/* 283 */           if (Main.bluePlayers.contains(e.getPlayer())) {
/* 284 */             e.getPlayer().openInventory(PlayerInteractEntityListener.forum("Blue"));
/* 285 */           } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 286 */             e.getPlayer().openInventory(PlayerInteractEntityListener.forum("Green"));
/* 287 */           } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 288 */             e.getPlayer().openInventory(PlayerInteractEntityListener.forum("Yellow"));
/* 289 */           } else if (Main.redPlayers.contains(e.getPlayer())) {
/* 290 */             e.getPlayer().openInventory(PlayerInteractEntityListener.forum("Red"));
/*     */           }
/*     */         
/*     */         }
/* 294 */       } else if (Main.nms.itemInHand(e.getPlayer()).getType() == Material.SLIME_BALL && 
/* 295 */         Main.nms.itemInHand(e.getPlayer()).getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("validate-vote"))) {
/* 296 */         if (Main.bluePlayers.contains(e.getPlayer())) {
/* 297 */           if (Buildings.vote_in_progress.contains("Blue")) {
/* 298 */             Vote.byTeam("Blue").addVote();
/* 299 */             e.getPlayer().getInventory().setItem(8, Misc.slotlocked());
/*     */           } 
/* 301 */         } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 302 */           if (Buildings.vote_in_progress.contains("Green")) {
/* 303 */             Vote.byTeam("Green").addVote();
/* 304 */             e.getPlayer().getInventory().setItem(8, Misc.slotlocked());
/*     */           } 
/* 306 */         } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 307 */           if (Buildings.vote_in_progress.contains("Yellow")) {
/* 308 */             Vote.byTeam("Yellow").addVote();
/* 309 */             e.getPlayer().getInventory().setItem(8, Misc.slotlocked());
/*     */           } 
/* 311 */         } else if (Main.redPlayers.contains(e.getPlayer()) && 
/* 312 */           Buildings.vote_in_progress.contains("Red")) {
/* 313 */           Vote.byTeam("Red").addVote();
/* 314 */           e.getPlayer().getInventory().setItem(8, Misc.slotlocked());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerInteractListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */