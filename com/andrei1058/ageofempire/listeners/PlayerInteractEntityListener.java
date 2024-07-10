/*     */ package com.andrei1058.ageofempire.listeners;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.Misc;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.game.Buildings;
/*     */ import com.andrei1058.ageofempire.game.Status;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Villager;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.EnchantmentStorageMeta;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.potion.Potion;
/*     */ import org.bukkit.potion.PotionType;
/*     */ 
/*     */ 
/*     */ public class PlayerInteractEntityListener
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void i(PlayerInteractEntityEvent e) {
/*  35 */     if (Main.SETUP)
/*  36 */       return;  if (Main.STATUS == Status.PLAYING) {
/*  37 */       Player p = e.getPlayer();
/*  38 */       if (e.getRightClicked().getType() == EntityType.VILLAGER) {
/*  39 */         Villager v = (Villager)e.getRightClicked();
/*  40 */         if (v.getCustomName() == null)
/*  41 */           return;  e.setCancelled(true);
/*  42 */         if (v == Main.blue_villager) {
/*  43 */           if (Main.bluePlayers.contains(e.getPlayer())) {
/*  44 */             e.getPlayer().openInventory(forum("Blue"));
/*     */           }
/*  46 */         } else if (v == Main.yellow_villager) {
/*  47 */           if (Main.yellowPlayers.contains(e.getPlayer())) {
/*  48 */             e.getPlayer().openInventory(forum("Yellow"));
/*     */           }
/*  50 */         } else if (v == Main.green_villager) {
/*  51 */           if (Main.greenPlayers.contains(e.getPlayer())) {
/*  52 */             e.getPlayer().openInventory(forum("Green"));
/*     */           }
/*  54 */         } else if (v == Main.red_villager) {
/*  55 */           if (Main.redPlayers.contains(e.getPlayer())) {
/*  56 */             e.getPlayer().openInventory(forum("Red"));
/*     */           }
/*  58 */         } else if (Main.blue_forge != null && v == Main.blue_forge) {
/*  59 */           if (Main.bluePlayers.contains(p)) {
/*  60 */             p.openInventory(forge(p));
/*     */           }
/*  62 */         } else if (Main.green_forge != null && v == Main.green_forge) {
/*  63 */           if (Main.greenPlayers.contains(p)) {
/*  64 */             p.openInventory(forge(p));
/*     */           }
/*  66 */         } else if (Main.yellow_forge != null && v == Main.yellow_forge) {
/*  67 */           if (Main.yellowPlayers.contains(p)) {
/*  68 */             p.openInventory(forge(p));
/*     */           }
/*  70 */         } else if (Main.red_forge != null && v == Main.red_forge) {
/*  71 */           if (Main.redPlayers.contains(p)) {
/*  72 */             p.openInventory(forge(p));
/*     */           }
/*  74 */         } else if (v == Main.blue_mill) {
/*  75 */           if (Main.bluePlayers.contains(p)) {
/*  76 */             p.openInventory(mill());
/*     */           }
/*  78 */         } else if (v == Main.green_mill) {
/*  79 */           if (Main.greenPlayers.contains(p)) {
/*  80 */             p.openInventory(mill());
/*     */           }
/*  82 */         } else if (v == Main.yellow_mill) {
/*  83 */           if (Main.yellowPlayers.contains(p)) {
/*  84 */             p.openInventory(mill());
/*     */           }
/*  86 */         } else if (v == Main.red_mill) {
/*  87 */           if (Main.redPlayers.contains(p)) {
/*  88 */             p.openInventory(mill());
/*     */           }
/*  90 */         } else if (v == Main.blue_workshop) {
/*  91 */           if (Main.bluePlayers.contains(p)) {
/*  92 */             p.openInventory(workshop());
/*     */           }
/*  94 */         } else if (v == Main.green_workshop) {
/*  95 */           if (Main.greenPlayers.contains(p)) {
/*  96 */             p.openInventory(workshop());
/*     */           }
/*  98 */         } else if (v == Main.yellow_workshop) {
/*  99 */           if (Main.yellowPlayers.contains(p)) {
/* 100 */             p.openInventory(workshop());
/*     */           }
/* 102 */         } else if (v == Main.red_workshop) {
/* 103 */           if (Main.redPlayers.contains(p)) {
/* 104 */             p.openInventory(workshop());
/*     */           }
/* 106 */         } else if (v == Main.blue_market) {
/* 107 */           if (Main.bluePlayers.contains(p)) {
/* 108 */             p.openInventory(market());
/*     */           }
/* 110 */         } else if (v == Main.green_market) {
/* 111 */           if (Main.greenPlayers.contains(p)) {
/* 112 */             p.openInventory(market());
/*     */           }
/* 114 */         } else if (v == Main.yellow_market) {
/* 115 */           if (Main.yellowPlayers.contains(p)) {
/* 116 */             p.openInventory(market());
/*     */           }
/* 118 */         } else if (v == Main.red_market) {
/* 119 */           if (Main.redPlayers.contains(p)) {
/* 120 */             p.openInventory(market());
/*     */           }
/* 122 */         } else if (v == Main.blue_sabotage) {
/* 123 */           if (Main.bluePlayers.contains(p)) {
/* 124 */             p.openInventory(sabotage());
/*     */           }
/* 126 */         } else if (v == Main.green_sabotage) {
/* 127 */           if (Main.greenPlayers.contains(p)) {
/* 128 */             p.openInventory(sabotage());
/*     */           }
/* 130 */         } else if (v == Main.yellow_sabotage) {
/* 131 */           if (Main.yellowPlayers.contains(p)) {
/* 132 */             p.openInventory(sabotage());
/*     */           }
/* 134 */         } else if (v == Main.red_sabotage) {
/* 135 */           if (Main.redPlayers.contains(p)) {
/* 136 */             p.openInventory(sabotage());
/*     */           }
/* 138 */         } else if (v == Main.blue_kennel) {
/* 139 */           if (Main.bluePlayers.contains(p)) {
/* 140 */             p.openInventory(kennel(p));
/*     */           }
/* 142 */         } else if (v == Main.green_kennel) {
/* 143 */           if (Main.greenPlayers.contains(p)) {
/* 144 */             p.openInventory(kennel(p));
/*     */           }
/* 146 */         } else if (v == Main.yellow_kennel) {
/* 147 */           if (Main.yellowPlayers.contains(p)) {
/* 148 */             p.openInventory(kennel(p));
/*     */           }
/* 150 */         } else if (v == Main.red_kennel) {
/* 151 */           if (Main.redPlayers.contains(p)) {
/* 152 */             p.openInventory(kennel(p));
/*     */           }
/* 154 */         } else if (v == Main.blue_archery) {
/* 155 */           if (Main.bluePlayers.contains(p)) {
/* 156 */             p.openInventory(archeryInv());
/*     */           }
/* 158 */         } else if (v == Main.green_archery) {
/* 159 */           if (Main.greenPlayers.contains(p)) {
/* 160 */             p.openInventory(archeryInv());
/*     */           }
/* 162 */         } else if (v == Main.yellow_archery) {
/* 163 */           if (Main.yellowPlayers.contains(p)) {
/* 164 */             p.openInventory(archeryInv());
/*     */           }
/* 166 */         } else if (v == Main.red_archery) {
/* 167 */           if (Main.redPlayers.contains(p)) {
/* 168 */             p.openInventory(archeryInv());
/*     */           }
/* 170 */         } else if (v == Main.blue_trifarrow) {
/* 171 */           if (Main.bluePlayers.contains(p)) {
/* 172 */             p.openInventory(trifarrowInv());
/*     */           }
/* 174 */         } else if (v == Main.green_trifarrow) {
/* 175 */           if (Main.greenPlayers.contains(p)) {
/* 176 */             p.openInventory(trifarrowInv());
/*     */           }
/* 178 */         } else if (v == Main.yellow_trifarrow) {
/* 179 */           if (Main.yellowPlayers.contains(p)) {
/* 180 */             p.openInventory(trifarrowInv());
/*     */           }
/* 182 */         } else if (v == Main.red_trifarrow) {
/* 183 */           if (Main.redPlayers.contains(p)) {
/* 184 */             p.openInventory(trifarrowInv());
/*     */           }
/* 186 */         } else if (v == Main.blue_stable) {
/* 187 */           if (Main.bluePlayers.contains(p)) {
/* 188 */             p.openInventory(stableInv());
/*     */           }
/* 190 */         } else if (v == Main.green_stable) {
/* 191 */           if (Main.greenPlayers.contains(p)) {
/* 192 */             p.openInventory(stableInv());
/*     */           }
/* 194 */         } else if (v == Main.yellow_stable) {
/* 195 */           if (Main.yellowPlayers.contains(p)) {
/* 196 */             p.openInventory(stableInv());
/*     */           }
/* 198 */         } else if (v == Main.red_stable) {
/* 199 */           if (Main.redPlayers.contains(p)) {
/* 200 */             p.openInventory(stableInv());
/*     */           }
/* 202 */         } else if (v == Main.blue_armory) {
/* 203 */           if (Main.bluePlayers.contains(p)) {
/* 204 */             p.openInventory(armoryInv(p));
/*     */           }
/* 206 */         } else if (v == Main.green_armory) {
/* 207 */           if (Main.greenPlayers.contains(p)) {
/* 208 */             p.openInventory(armoryInv(p));
/*     */           }
/* 210 */         } else if (v == Main.yellow_armory) {
/* 211 */           if (Main.yellowPlayers.contains(p)) {
/* 212 */             p.openInventory(armoryInv(p));
/*     */           }
/* 214 */         } else if (v == Main.red_armory) {
/* 215 */           if (Main.redPlayers.contains(p)) {
/* 216 */             p.openInventory(armoryInv(p));
/*     */           }
/* 218 */         } else if (v == Main.blue_lab) {
/* 219 */           if (Main.bluePlayers.contains(p)) {
/* 220 */             p.openInventory(lab());
/*     */           }
/* 222 */         } else if (v == Main.green_lab) {
/* 223 */           if (Main.greenPlayers.contains(p)) {
/* 224 */             p.openInventory(lab());
/*     */           }
/* 226 */         } else if (v == Main.yellow_lab) {
/* 227 */           if (Main.yellowPlayers.contains(p)) {
/* 228 */             p.openInventory(lab());
/*     */           }
/* 230 */         } else if (v == Main.red_lab) {
/* 231 */           if (Main.redPlayers.contains(p)) {
/* 232 */             p.openInventory(lab());
/*     */           }
/* 234 */         } else if (v == Main.blue_guild) {
/* 235 */           if (Main.bluePlayers.contains(p)) {
/* 236 */             p.openInventory(guild());
/*     */           }
/* 238 */         } else if (v == Main.green_guild) {
/* 239 */           if (Main.greenPlayers.contains(p)) {
/* 240 */             p.openInventory(guild());
/*     */           }
/* 242 */         } else if (v == Main.yellow_guild) {
/* 243 */           if (Main.yellowPlayers.contains(p)) {
/* 244 */             p.openInventory(guild());
/*     */           }
/* 246 */         } else if (v == Main.red_guild) {
/* 247 */           if (Main.redPlayers.contains(p)) {
/* 248 */             p.openInventory(guild());
/*     */           }
/*     */         } else {
/* 251 */           e.setCancelled(true);
/* 252 */           e.getPlayer().sendMessage(Messages.getMsg("villager.cant-open"));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Inventory guild() {
/* 259 */     Inventory inv = Bukkit.createInventory(null, 54, "Guild");
/* 260 */     inv.addItem(new ItemStack[] { enchant(Enchantment.DAMAGE_ALL, "guild.sharpness.name", "guild.sharpness.lore") });
/* 261 */     inv.addItem(new ItemStack[] { enchant(Enchantment.KNOCKBACK, "guild.knockback.name", "guild.knockback.lore") });
/* 262 */     inv.addItem(new ItemStack[] { enchant(Enchantment.PROTECTION_ENVIRONMENTAL, "guild.protection.name", "guild.protection.lore") });
/* 263 */     inv.addItem(new ItemStack[] { enchant(Enchantment.THORNS, "guild.thorns.name", "guild.thorns.lore") });
/* 264 */     inv.addItem(new ItemStack[] { enchant(Enchantment.LURE, "guild.featherfalling.name", "guild.featherfalling.lore") });
/* 265 */     inv.addItem(new ItemStack[] { enchant(Enchantment.PROTECTION_PROJECTILE, "guild.projectileprotection.name", "guild.projectileprotection.lore") });
/* 266 */     inv.addItem(new ItemStack[] { enchant(Enchantment.PROTECTION_FIRE, "guild.fireprotection.name", "guild.fireprotection.lore") });
/* 267 */     inv.addItem(new ItemStack[] { enchant(Enchantment.ARROW_DAMAGE, "guild.power.name", "guild.power.lore") });
/* 268 */     inv.addItem(new ItemStack[] { enchant(Enchantment.ARROW_KNOCKBACK, "guild.punch.name", "guild.punch.lore") });
/* 269 */     return inv;
/*     */   }
/*     */ 
/*     */   
/*     */   private static ItemStack enchant(Enchantment enchantment, String name, String lore) {
/* 274 */     ItemStack i = new ItemStack(Material.ENCHANTED_BOOK);
/* 275 */     EnchantmentStorageMeta m = (EnchantmentStorageMeta)i.getItemMeta();
/* 276 */     m.setDisplayName(Messages.getMsg(name));
/* 277 */     m.setLore((List)Messages.getArray(lore).stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 278 */     m.addEnchant(enchantment, 1, true);
/* 279 */     i.setItemMeta((ItemMeta)m);
/* 280 */     return i;
/*     */   }
/*     */   
/*     */   public static Inventory forum(String team) {
/* 284 */     Inventory inv = Bukkit.createInventory(null, 54, "Forum");
/* 285 */     inv.setItem(0, Misc.getSkull("http://textures.minecraft.net/texture/71bc2bcfb2bd3759e6b1e86fc7a79585e1127dd357fc202893f9de241bc9e530", Messages.getMsg("forum.age1")));
/* 286 */     inv.setItem(1, Misc.getSkull("http://textures.minecraft.net/texture/1a4f68c8fb279e50ab786f9fa54c88ca4ecfe1eb5fd5f0c38c54c9b1c7203d7a", Messages.getMsg("forum.age-buldings")));
/* 287 */     inv.setItem(2, item(Material.ANVIL, (short)0, Messages.getMsg("forum.FORGE.displayname"), Messages.getArray("forum.FORGE.lore"), true, Buildings.hasBuild("FORGE", team)));
/* 288 */     inv.setItem(3, item(Material.WHEAT, (short)0, Messages.getMsg("forum.MILL.displayname"), Messages.getArray("forum.MILL.lore"), true, Buildings.hasBuild("MILL", team)));
/* 289 */     inv.setItem(4, item(Material.DIAMOND_PICKAXE, (short)0, Messages.getMsg("forum.STONE_MINE.displayname"), Messages.getArray("forum.STONE_MINE.lore"), true, Buildings.hasBuild("STONE_MINE", team)));
/* 290 */     inv.setItem(5, item(Material.GOLD_ORE, (short)0, Messages.getMsg("forum.GOLD_MINE.displayname"), Messages.getArray("forum.GOLD_MINE.lore"), true, Buildings.hasBuild("GOLD_MINE", team)));
/* 291 */     inv.setItem(6, item(Material.DIAMOND_AXE, (short)0, Messages.getMsg("forum.SAWMILL.displayname"), Messages.getArray("forum.SAWMILL.lore"), true, Buildings.hasBuild("SAWMILL", team)));
/* 292 */     inv.setItem(7, item(Material.WORKBENCH, (short)0, Messages.getMsg("forum.WORKSHOP.displayname"), Messages.getArray("forum.WORKSHOP.lore"), true, Buildings.hasBuild("WORKSHOP", team)));
/* 293 */     inv.setItem(8, item(Material.EMERALD, (short)0, Messages.getMsg("forum.MARKET.displayname"), Messages.getArray("forum.MARKET.lore"), true, Buildings.hasBuild("MARKET", team)));
/* 294 */     inv.setItem(9, item(Material.BONE, (short)0, Messages.getMsg("forum.KENNEL.displayname"), Messages.getArray("forum.KENNEL.lore"), true, Buildings.hasBuild("KENNEL", team)));
/* 295 */     inv.setItem(10, item(Material.TNT, (short)0, Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname"), Messages.getArray("forum.SABOTAGE_WORKSHOP.lore"), true, Buildings.hasBuild("SABOTAGE_WORKSHOP", team)));
/* 296 */     inv.setItem(18, Misc.getSkull("http://textures.minecraft.net/texture/4cd9eeee883468881d83848a46bf3012485c23f75753b8fbe8487341419847", Messages.getMsg("forum.age2")));
/* 297 */     inv.setItem(19, Misc.getSkull("http://textures.minecraft.net/texture/1a4f68c8fb279e50ab786f9fa54c88ca4ecfe1eb5fd5f0c38c54c9b1c7203d7a", Messages.getMsg("forum.age-buldings")));
/* 298 */     inv.setItem(20, ageBuilding(team, Material.BOW, Messages.getMsg("forum.ARCHERY_STORE.displayname"), Messages.getArray("forum.ARCHERY_STORE.lore"), Buildings.hasBuild("ARCHERY_STORE", team), true, Integer.valueOf(2)));
/* 299 */     inv.setItem(21, ageBuilding(team, Material.ARROW, Messages.getMsg("forum.TRIFARROW.displayname"), Messages.getArray("forum.TRIFARROW.lore"), Buildings.hasBuild("TRIFARROW", team), true, Integer.valueOf(2)));
/* 300 */     inv.setItem(22, ageBuilding(team, Material.SADDLE, Messages.getMsg("forum.STABLE.displayname"), Messages.getArray("forum.STABLE.lore"), Buildings.hasBuild("STABLE", team), true, Integer.valueOf(2)));
/* 301 */     inv.setItem(23, ageBuilding(team, Material.DIAMOND_CHESTPLATE, Messages.getMsg("forum.ARMORY.displayname"), Messages.getArray("forum.ARMORY.lore"), Buildings.hasBuild("ARMORY", team), true, Integer.valueOf(2)));
/* 302 */     inv.setItem(24, ageBuilding(team, Material.BREWING_STAND_ITEM, Messages.getMsg("forum.LABORATORY.displayname"), Messages.getArray("forum.LABORATORY.lore"), Buildings.hasBuild("LABORATORY", team), true, Integer.valueOf(2)));
/* 303 */     inv.setItem(27, Misc.getSkull("http://textures.minecraft.net/texture/1d4eae13933860a6df5e8e955693b95a8c3b15c36b8b587532ac0996bc37e5", Messages.getMsg("forum.age3")));
/* 304 */     inv.setItem(28, Misc.getSkull("http://textures.minecraft.net/texture/1a4f68c8fb279e50ab786f9fa54c88ca4ecfe1eb5fd5f0c38c54c9b1c7203d7a", Messages.getMsg("forum.age-buldings")));
/* 305 */     inv.setItem(29, ageBuilding(team, Material.ENCHANTED_BOOK, Messages.getMsg("forum.GUILD.displayname"), Messages.getArray("forum.GUILD.lore"), Buildings.hasBuild("GUILD", team), true, Integer.valueOf(3)));
/* 306 */     inv.setItem(30, ageBuilding(team, Material.EXP_BOTTLE, Messages.getMsg("forum.TRAINING_CENTER.displayname"), Messages.getArray("forum.TRAINING_CENTER.lore"), Buildings.hasBuild("TRAINING_CENTER", team), true, Integer.valueOf(3)));
/*     */     
/* 308 */     inv.setItem(48, Misc.getSkull("http://textures.minecraft.net/texture/1a4f68c8fb279e50ab786f9fa54c88ca4ecfe1eb5fd5f0c38c54c9b1c7203d7a", "->"));
/* 309 */     inv.setItem(49, ageDoor(team));
/* 310 */     inv.setItem(50, Misc.getSkull("http://textures.minecraft.net/texture/737648ae7a564a5287792b05fac79c6b6bd47f616a559ce8b543e6947235bce", "<-"));
/* 311 */     return inv;
/*     */   }
/*     */   private static ItemStack item(Material material, short sh, String name, ArrayList<String> lore, boolean enchant, boolean built) {
/* 314 */     ItemStack i = new ItemStack(material, 1, sh);
/* 315 */     ItemMeta im = i.getItemMeta();
/* 316 */     im.setDisplayName(name);
/* 317 */     ArrayList<String> l = (ArrayList<String>)lore.stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new));
/* 318 */     if (built) {
/* 319 */       l.add(Messages.getMsg("forum.built"));
/*     */     } else {
/* 321 */       l.add(Messages.getMsg("forum.to-build"));
/*     */     } 
/* 323 */     im.setLore(l);
/* 324 */     if (enchant) {
/* 325 */       im.addEnchant(Enchantment.DURABILITY, 1, true);
/* 326 */       im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*     */     } 
/* 328 */     i.setItemMeta(im);
/* 329 */     return i;
/*     */   }
/*     */   
/*     */   public static ItemStack ageDoor(String team) {
/* 333 */     ItemStack i = new ItemStack(Material.BEDROCK);
/* 334 */     ItemMeta im = i.getItemMeta();
/* 335 */     switch (team) {
/*     */       case "Blue":
/* 337 */         switch (Main.blue_age) {
/*     */           case 1:
/* 339 */             i = new ItemStack(Material.DARK_OAK_DOOR_ITEM);
/* 340 */             im.setDisplayName(Messages.getMsg("forum.age2"));
/* 341 */             im.setLore((List)Messages.getArray("change.age2-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 2:
/* 344 */             i = new ItemStack(Material.IRON_DOOR);
/* 345 */             im.setDisplayName(Messages.getMsg("forum.age3"));
/* 346 */             im.setLore((List)Messages.getArray("change.age3-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 3:
/* 349 */             i = new ItemStack(Material.DIAMOND);
/* 350 */             im.setDisplayName(Messages.getMsg("forum.age4"));
/* 351 */             im.setLore((List)Messages.getArray("change.age4-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 4:
/* 354 */             im.setDisplayName("-");
/*     */             break;
/*     */         } 
/*     */         break;
/*     */       case "Green":
/* 359 */         switch (Main.green_age) {
/*     */           case 1:
/* 361 */             i = new ItemStack(Material.DARK_OAK_DOOR_ITEM);
/* 362 */             im.setDisplayName(Messages.getMsg("forum.age2"));
/* 363 */             im.setLore((List)Messages.getArray("change.age2-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 2:
/* 366 */             i = new ItemStack(Material.IRON_DOOR);
/* 367 */             im.setDisplayName(Messages.getMsg("forum.age3"));
/* 368 */             im.setLore((List)Messages.getArray("change.age3-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 3:
/* 371 */             i = new ItemStack(Material.DIAMOND);
/* 372 */             im.setDisplayName(Messages.getMsg("forum.age4"));
/* 373 */             im.setLore((List)Messages.getArray("change.age4-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 4:
/* 376 */             im.setDisplayName("-");
/*     */             break;
/*     */         } 
/*     */         break;
/*     */       case "Red":
/* 381 */         switch (Main.red_age) {
/*     */           case 1:
/* 383 */             i = new ItemStack(Material.DARK_OAK_DOOR_ITEM);
/* 384 */             im.setDisplayName(Messages.getMsg("forum.age2"));
/* 385 */             im.setLore((List)Messages.getArray("change.age2-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 2:
/* 388 */             i = new ItemStack(Material.IRON_DOOR);
/* 389 */             im.setDisplayName(Messages.getMsg("forum.age3"));
/* 390 */             im.setLore((List)Messages.getArray("change.age3-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 3:
/* 393 */             i = new ItemStack(Material.DIAMOND);
/* 394 */             im.setDisplayName(Messages.getMsg("forum.age4"));
/* 395 */             im.setLore((List)Messages.getArray("change.age4-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 4:
/* 398 */             im.setDisplayName("-");
/*     */             break;
/*     */         } 
/*     */         break;
/*     */       case "Yellow":
/* 403 */         switch (Main.yellow_age) {
/*     */           case 1:
/* 405 */             i = new ItemStack(Material.DARK_OAK_DOOR_ITEM);
/* 406 */             im.setDisplayName(Messages.getMsg("forum.age2"));
/* 407 */             im.setLore((List)Messages.getArray("change.age2-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 2:
/* 410 */             i = new ItemStack(Material.IRON_DOOR);
/* 411 */             im.setDisplayName(Messages.getMsg("forum.age3"));
/* 412 */             im.setLore((List)Messages.getArray("change.age3-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 3:
/* 415 */             i = new ItemStack(Material.DIAMOND);
/* 416 */             im.setDisplayName(Messages.getMsg("forum.age4"));
/* 417 */             im.setLore((List)Messages.getArray("change.age4-lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/*     */             break;
/*     */           case 4:
/* 420 */             im.setDisplayName("-");
/*     */             break;
/*     */         } 
/*     */         break;
/*     */     } 
/* 425 */     i.setItemMeta(im);
/* 426 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack ageBuilding(String team, Material material, String name, ArrayList<String> lore, boolean built, boolean enchant, Integer age) {
/* 431 */     ItemStack i = new ItemStack(material);
/* 432 */     ItemMeta im = i.getItemMeta();
/* 433 */     im.setDisplayName(name);
/* 434 */     ArrayList<String> l = (ArrayList<String>)lore.stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new));
/* 435 */     if (built) {
/* 436 */       l.add(Messages.getMsg("forum.built"));
/*     */     } else {
/* 438 */       l.add(Messages.getMsg("forum.to-build"));
/*     */     } 
/* 440 */     if (enchant) {
/* 441 */       im.addEnchant(Enchantment.DURABILITY, 1, true);
/* 442 */       im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*     */     } 
/* 444 */     im.setLore(l);
/* 445 */     i.setItemMeta(im);
/*     */     
/* 447 */     ItemStack i2 = new ItemStack(Material.BARRIER);
/* 448 */     ItemMeta im2 = i2.getItemMeta();
/* 449 */     im2.setDisplayName(name);
/* 450 */     im2.setLore(l);
/* 451 */     i2.setItemMeta(im2);
/*     */     
/* 453 */     switch (team) {
/*     */       case "Blue":
/* 455 */         if (Main.blue_age >= age.intValue()) {
/* 456 */           return i;
/*     */         }
/*     */         break;
/*     */       case "Green":
/* 460 */         if (Main.green_age >= age.intValue()) {
/* 461 */           return i;
/*     */         }
/*     */         break;
/*     */       case "Yellow":
/* 465 */         if (Main.yellow_age >= age.intValue()) {
/* 466 */           return i;
/*     */         }
/*     */         break;
/*     */       case "Red":
/* 470 */         if (Main.red_age >= age.intValue()) {
/* 471 */           return i;
/*     */         }
/*     */         break;
/*     */     } 
/* 475 */     return i2;
/*     */   }
/*     */   
/*     */   public static Inventory forge(Player p) {
/* 479 */     Inventory inv = Bukkit.createInventory(null, 54, "Forge");
/* 480 */     inv.addItem(new ItemStack[] { forgeItem(Material.STONE_PICKAXE, Messages.getMsg("forge.stonepickaxe.displayname"), Messages.getArray("forge.stonepickaxe.lore")) });
/* 481 */     inv.addItem(new ItemStack[] { forgeItem(Material.STONE_SWORD, Messages.getMsg("forge.stonesword.displayname"), Messages.getArray("forge.stonesword.lore")) });
/* 482 */     inv.addItem(new ItemStack[] { forgeItem(Material.IRON_SWORD, Messages.getMsg("forge.ironsword.displayname"), Messages.getArray("forge.ironsword.lore")) });
/* 483 */     inv.addItem(new ItemStack[] { forgeItem(Material.STONE_AXE, Messages.getMsg("forge.stoneaxe.displayname"), Messages.getArray("forge.stoneaxe.lore")) });
/* 484 */     inv.addItem(new ItemStack[] { forgeItem(Material.IRON_AXE, Messages.getMsg("forge.ironaxe.displayname"), Messages.getArray("forge.ironaxe.lore")) });
/* 485 */     if (Main.bluePlayers.contains(p)) {
/* 486 */       if (Main.blue_age > 2) {
/* 487 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_SWORD, Messages.getMsg("forge.diamondsword.displayname"), Messages.getArray("forge.diamondsword.lore")) });
/* 488 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_AXE, Messages.getMsg("forge.diamondaxe.displayname"), Messages.getArray("forge.diamondaxe.lore")) });
/*     */       } 
/* 490 */     } else if (Main.greenPlayers.contains(p)) {
/* 491 */       if (Main.green_age > 2) {
/* 492 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_SWORD, Messages.getMsg("forge.diamondsword.displayname"), Messages.getArray("forge.diamondsword.lore")) });
/* 493 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_AXE, Messages.getMsg("forge.diamondaxe.displayname"), Messages.getArray("forge.diamondaxe.lore")) });
/*     */       } 
/* 495 */     } else if (Main.yellowPlayers.contains(p)) {
/* 496 */       if (Main.yellow_age > 2) {
/* 497 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_SWORD, Messages.getMsg("forge.diamondsword.displayname"), Messages.getArray("forge.diamondsword.lore")) });
/* 498 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_AXE, Messages.getMsg("forge.diamondaxe.displayname"), Messages.getArray("forge.diamondaxe.lore")) });
/*     */       } 
/* 500 */     } else if (Main.redPlayers.contains(p) && 
/* 501 */       Main.red_age > 2) {
/* 502 */       inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_SWORD, Messages.getMsg("forge.diamondsword.displayname"), Messages.getArray("forge.diamondsword.lore")) });
/* 503 */       inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_AXE, Messages.getMsg("forge.diamondaxe.displayname"), Messages.getArray("forge.diamondaxe.lore")) });
/*     */     } 
/*     */     
/* 506 */     return inv;
/*     */   }
/*     */   
/*     */   public static Inventory mill() {
/* 510 */     Inventory inv = Bukkit.createInventory(null, 54, "Mill");
/* 511 */     inv.addItem(new ItemStack[] { forgeItem(Material.BREAD, Messages.getMsg("mill.bread.displayname"), Messages.getArray("mill.bread.lore")) });
/* 512 */     inv.addItem(new ItemStack[] { forgeItem(Material.POTATO, Messages.getMsg("mill.potato.displayname"), Messages.getArray("mill.potato.lore")) });
/* 513 */     inv.addItem(new ItemStack[] { forgeItem(Material.COOKED_BEEF, Messages.getMsg("mill.steak.displayname"), Messages.getArray("mill.steak.lore")) });
/* 514 */     inv.addItem(new ItemStack[] { forgeItem(Material.COOKED_CHICKEN, Messages.getMsg("mill.chicken.displayname"), Messages.getArray("mill.chicken.lore")) });
/* 515 */     return inv;
/*     */   }
/*     */   
/*     */   public static Inventory armoryInv(Player u) {
/* 519 */     Inventory inv = Bukkit.createInventory(null, 54, "Armory");
/* 520 */     ItemStack ia = new ItemStack(Material.IRON_CHESTPLATE);
/* 521 */     ItemMeta iam = ia.getItemMeta();
/* 522 */     iam.setDisplayName(Messages.getMsg("armory.ironarmor.displayname"));
/* 523 */     iam.setLore((List)Messages.getArray("armory.ironarmor.lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 524 */     ia.setItemMeta(iam);
/* 525 */     inv.addItem(new ItemStack[] { ia });
/* 526 */     ItemStack iha = new ItemStack(Material.IRON_BARDING);
/* 527 */     ItemMeta iham = iha.getItemMeta();
/* 528 */     iham.setDisplayName(Messages.getMsg("armory.ironhorsearmor.displayname"));
/* 529 */     iham.setLore((List)Messages.getArray("armory.ironhorsearmor.lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 530 */     iha.setItemMeta(iham);
/* 531 */     inv.addItem(new ItemStack[] { iha });
/* 532 */     if (Main.bluePlayers.contains(u)) {
/* 533 */       if (Main.blue_age > 2) {
/* 534 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_CHESTPLATE, Messages.getMsg("armory.diamondarmor.displayname"), Messages.getArray("armory.diamondarmor.lore")) });
/* 535 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_BARDING, Messages.getMsg("armory.diamondhorsearmor.displayname"), Messages.getArray("armory.diamondhorsearmor.lore")) });
/*     */       } 
/* 537 */     } else if (Main.redPlayers.contains(u)) {
/* 538 */       if (Main.red_age > 2) {
/* 539 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_CHESTPLATE, Messages.getMsg("armory.diamondarmor.displayname"), Messages.getArray("armory.diamondarmor.lore")) });
/* 540 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_BARDING, Messages.getMsg("armory.diamondhorsearmor.displayname"), Messages.getArray("armory.diamondhorsearmor.lore")) });
/*     */       } 
/* 542 */     } else if (Main.greenPlayers.contains(u)) {
/* 543 */       if (Main.green_age > 2) {
/* 544 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_CHESTPLATE, Messages.getMsg("armory.diamondarmor.displayname"), Messages.getArray("armory.diamondarmor.lore")) });
/* 545 */         inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_BARDING, Messages.getMsg("armory.diamondhorsearmor.displayname"), Messages.getArray("armory.diamondhorsearmor.lore")) });
/*     */       } 
/* 547 */     } else if (Main.yellowPlayers.contains(u) && 
/* 548 */       Main.yellow_age > 2) {
/* 549 */       inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_CHESTPLATE, Messages.getMsg("armory.diamondarmor.displayname"), Messages.getArray("armory.diamondarmor.lore")) });
/* 550 */       inv.addItem(new ItemStack[] { forgeItem(Material.DIAMOND_BARDING, Messages.getMsg("armory.diamondhorsearmor.displayname"), Messages.getArray("armory.diamondhorsearmor.lore")) });
/*     */     } 
/*     */     
/* 553 */     return inv;
/*     */   }
/*     */   
/*     */   public static Inventory sabotage() {
/* 557 */     Inventory inv = Bukkit.createInventory(null, 54, "Sabotage");
/* 558 */     inv.addItem(new ItemStack[] { forgeItem(Material.TNT, Messages.getMsg("sabotage.tnt.displayname"), Messages.getArray("sabotage.tnt.lore")) });
/* 559 */     return inv;
/*     */   }
/*     */   
/*     */   public static Inventory kennel(Player u) {
/* 563 */     Inventory inv = Bukkit.createInventory(null, 54, "Kennel");
/* 564 */     inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog.displayname"), Messages.getArray("kennel.dog.lore")) });
/* 565 */     if (Main.bluePlayers.contains(u)) {
/* 566 */       if (Main.blue_age > 2) {
/* 567 */         inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog2.displayname"), Messages.getArray("kennel.dog2.lore")) });
/* 568 */         inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog3.displayname"), Messages.getArray("kennel.dog3.lore")) });
/*     */       } 
/* 570 */     } else if (Main.greenPlayers.contains(u)) {
/* 571 */       if (Main.green_age > 2) {
/* 572 */         inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog2.displayname"), Messages.getArray("kennel.dog2.lore")) });
/* 573 */         inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog3.displayname"), Messages.getArray("kennel.dog3.lore")) });
/*     */       } 
/* 575 */     } else if (Main.yellowPlayers.contains(u)) {
/* 576 */       if (Main.yellow_age > 2) {
/* 577 */         inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog2.displayname"), Messages.getArray("kennel.dog2.lore")) });
/* 578 */         inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog3.displayname"), Messages.getArray("kennel.dog3.lore")) });
/*     */       } 
/* 580 */     } else if (Main.redPlayers.contains(u) && 
/* 581 */       Main.red_age > 2) {
/* 582 */       inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog2.displayname"), Messages.getArray("kennel.dog2.lore")) });
/* 583 */       inv.addItem(new ItemStack[] { forgeItem(Material.MONSTER_EGG, Messages.getMsg("kennel.dog3.displayname"), Messages.getArray("kennel.dog3.lore")) });
/*     */     } 
/*     */     
/* 586 */     return inv;
/*     */   }
/*     */   
/*     */   private static Inventory trifarrowInv() {
/* 590 */     Inventory inv = Bukkit.createInventory(null, 54, "TrifArrow");
/* 591 */     ItemStack i = new ItemStack(Material.ARROW);
/* 592 */     ItemMeta im = i.getItemMeta();
/* 593 */     im.setDisplayName(Messages.getMsg("trifarrow.arrow.displayname"));
/* 594 */     im.setLore((List)Messages.getArray("trifarrow.arrow.lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 595 */     i.setItemMeta(im);
/* 596 */     inv.addItem(new ItemStack[] { i });
/*     */     
/* 598 */     return inv;
/*     */   }
/*     */   
/*     */   private static Inventory lab() {
/* 602 */     Inventory inv = Bukkit.createInventory(null, 54, "Laboratory");
/* 603 */     inv.addItem(new ItemStack[] { labItem(PotionType.SPEED, "lab.swiftness.name", "lab.swiftness.lore", false) });
/* 604 */     inv.addItem(new ItemStack[] { labItem(PotionType.FIRE_RESISTANCE, "lab.fireresistance.name", "lab.fireresistance.lore", false) });
/* 605 */     inv.addItem(new ItemStack[] { labItem(PotionType.INSTANT_HEAL, "lab.healing.name", "lab.healing.lore", false) });
/* 606 */     inv.addItem(new ItemStack[] { labItem(PotionType.NIGHT_VISION, "lab.nightvision.name", "lab.nightvision.lore", false) });
/* 607 */     inv.addItem(new ItemStack[] { labItem(PotionType.JUMP, "lab.leaping.name", "lab.leaping.lore", false) });
/* 608 */     inv.addItem(new ItemStack[] { labItem(PotionType.WATER_BREATHING, "lab.waterbreathing.name", "lab.waterbreathing.lore", false) });
/* 609 */     inv.addItem(new ItemStack[] { labItem(PotionType.SPEED, "lab.splashswiftness.name", "lab.splashswiftness.lore", true) });
/* 610 */     inv.addItem(new ItemStack[] { labItem(PotionType.REGEN, "lab.regeneration.name", "lab.regeneration.lore", false) });
/* 611 */     inv.addItem(new ItemStack[] { labItem(PotionType.JUMP, "lab.splashleaping.name", "lab.splashleaping.lore", true) });
/* 612 */     return inv;
/*     */   }
/*     */   
/*     */   private static ItemStack labItem(PotionType potionType, String name, String lore, boolean splash) {
/* 616 */     Potion p = new Potion(potionType);
/* 617 */     p.setSplash(splash);
/* 618 */     ItemStack i = p.toItemStack(1);
/* 619 */     ItemMeta itemMeta = i.getItemMeta();
/* 620 */     itemMeta.setDisplayName(Messages.getMsg(name));
/* 621 */     itemMeta.setLore((List)Messages.getArray(lore).stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 622 */     i.setItemMeta(itemMeta);
/* 623 */     return i;
/*     */   }
/*     */   
/*     */   public static Inventory market() {
/* 627 */     Inventory inv = Bukkit.createInventory(null, 54, "Market");
/* 628 */     inv.addItem(new ItemStack[] { forgeItem(Material.FLINT_AND_STEEL, Messages.getMsg("market.flintandsteel.displayname"), Messages.getArray("market.flintandsteel.lore")) });
/* 629 */     inv.addItem(new ItemStack[] { forgeItem(Material.WEB, Messages.getMsg("market.cobweb.displayname"), Messages.getArray("market.cobweb.lore")) });
/* 630 */     inv.addItem(new ItemStack[] { forgeItem(Material.TORCH, Messages.getMsg("market.torches.displayname"), Messages.getArray("market.torches.lore")) });
/* 631 */     inv.addItem(new ItemStack[] { forgeItem(Material.BOAT, Messages.getMsg("market.boat.displayname"), Messages.getArray("market.boat.lore")) });
/* 632 */     return inv;
/*     */   }
/*     */   
/*     */   private static Inventory stableInv() {
/* 636 */     Inventory inv = Bukkit.createInventory(null, 54, "Stable");
/* 637 */     ItemStack i = new ItemStack(Material.MONSTER_EGG, 1, (short)100);
/* 638 */     ItemMeta im = i.getItemMeta();
/* 639 */     im.setDisplayName(Messages.getMsg("stable.horse.displayname"));
/* 640 */     im.setLore((List)Messages.getArray("stable.horse.lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 641 */     i.setItemMeta(im);
/* 642 */     inv.addItem(new ItemStack[] { i });
/* 643 */     return inv;
/*     */   }
/*     */   
/*     */   public static Inventory workshop() {
/* 647 */     Inventory inv = Bukkit.createInventory(null, 54, "Workshop");
/* 648 */     inv.addItem(new ItemStack[] { forgeItem(Material.GRASS, Messages.getMsg("workshop.grass.displayname"), Messages.getArray("workshop.grass.lore")) });
/* 649 */     inv.addItem(new ItemStack[] { forgeItem(Material.DIRT, Messages.getMsg("workshop.dirt.displayname"), Messages.getArray("workshop.dirt.lore")) });
/* 650 */     inv.addItem(new ItemStack[] { forgeItem(Material.WOOD_DOUBLE_STEP, Messages.getMsg("workshop.plank.displayname"), Messages.getArray("workshop.plank.lore")) });
/* 651 */     inv.addItem(new ItemStack[] { forgeItem(Material.SAND, Messages.getMsg("workshop.sand.displayname"), Messages.getArray("workshop.sand.lore")) });
/* 652 */     inv.addItem(new ItemStack[] { forgeItem(Material.GRAVEL, Messages.getMsg("workshop.gravel.displayname"), Messages.getArray("workshop.gravel.lore")) });
/* 653 */     inv.addItem(new ItemStack[] { forgeItem(Material.SPONGE, Messages.getMsg("workshop.sponge.displayname"), Messages.getArray("workshop.sponge.lore")) });
/* 654 */     inv.addItem(new ItemStack[] { forgeItem(Material.GLASS, Messages.getMsg("workshop.glass.displayname"), Messages.getArray("workshop.glass.lore")) });
/* 655 */     inv.addItem(new ItemStack[] { forgeItem(Material.LAPIS_BLOCK, Messages.getMsg("workshop.lapis.displayname"), Messages.getArray("workshop.lapis.lore")) });
/* 656 */     inv.addItem(new ItemStack[] { WOOLItem((short)0, Messages.getMsg("workshop.whitewool.displayname"), Messages.getArray("workshop.whitewool.lore")) });
/* 657 */     inv.addItem(new ItemStack[] { WOOLItem((short)1, Messages.getMsg("workshop.orangewool.displayname"), Messages.getArray("workshop.orangewool.lore")) });
/* 658 */     inv.addItem(new ItemStack[] { WOOLItem((short)2, Messages.getMsg("workshop.magentawool.displayname"), Messages.getArray("workshop.magentawool.lore")) });
/* 659 */     inv.addItem(new ItemStack[] { WOOLItem((short)3, Messages.getMsg("workshop.lightbluewool.displayname"), Messages.getArray("workshop.lightbluewool.lore")) });
/* 660 */     inv.addItem(new ItemStack[] { WOOLItem((short)4, Messages.getMsg("workshop.yellowwool.displayname"), Messages.getArray("workshop.yellowwool.lore")) });
/* 661 */     inv.addItem(new ItemStack[] { WOOLItem((short)5, Messages.getMsg("workshop.lightgreenwool.displayname"), Messages.getArray("workshop.lightgreenwool.lore")) });
/* 662 */     inv.addItem(new ItemStack[] { WOOLItem((short)6, Messages.getMsg("workshop.pinkwool.displayname"), Messages.getArray("workshop.pinkwool.lore")) });
/* 663 */     inv.addItem(new ItemStack[] { WOOLItem((short)7, Messages.getMsg("workshop.graywool.displayname"), Messages.getArray("workshop.graywool.lore")) });
/* 664 */     inv.addItem(new ItemStack[] { WOOLItem((short)9, Messages.getMsg("workshop.cyanwool.displayname"), Messages.getArray("workshop.cyanwool.lore")) });
/* 665 */     inv.addItem(new ItemStack[] { WOOLItem((short)10, Messages.getMsg("workshop.purplewool.displayname"), Messages.getArray("workshop.purplewool.lore")) });
/* 666 */     inv.addItem(new ItemStack[] { WOOLItem((short)11, Messages.getMsg("workshop.bluewool.displayname"), Messages.getArray("workshop.bluewool.lore")) });
/* 667 */     inv.addItem(new ItemStack[] { WOOLItem((short)15, Messages.getMsg("workshop.blackwool.displayname"), Messages.getArray("workshop.blackwool.lore")) });
/* 668 */     inv.addItem(new ItemStack[] { WOOLItem((short)13, Messages.getMsg("workshop.greenwool.displayname"), Messages.getArray("workshop.greenwool.lore")) });
/* 669 */     inv.addItem(new ItemStack[] { WOOLItem((short)14, Messages.getMsg("workshop.redwool.displayname"), Messages.getArray("workshop.redwool.lore")) });
/* 670 */     inv.addItem(new ItemStack[] { WOOLItem((short)12, Messages.getMsg("workshop.brownwool.displayname"), Messages.getArray("workshop.brownwool.lore")) });
/* 671 */     inv.addItem(new ItemStack[] { forgeItem(Material.BRICK, Messages.getMsg("workshop.bricks.displayname"), Messages.getArray("workshop.bricks.lore")) });
/* 672 */     inv.addItem(new ItemStack[] { forgeItem(Material.MOSSY_COBBLESTONE, Messages.getMsg("workshop.mossstone.displayname"), Messages.getArray("workshop.mossstone.lore")) });
/* 673 */     inv.addItem(new ItemStack[] { forgeItem(Material.LEAVES, Messages.getMsg("workshop.leaves.displayname"), Messages.getArray("workshop.leaves.lore")) });
/* 674 */     return inv;
/*     */   }
/*     */   
/*     */   private static ItemStack forgeItem(Material material, String name, ArrayList<String> lore) {
/* 678 */     ItemStack i = new ItemStack(material);
/* 679 */     ItemMeta im = i.getItemMeta();
/* 680 */     im.setDisplayName(name);
/* 681 */     ArrayList<String> list = (ArrayList<String>)lore.stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new));
/* 682 */     im.setLore(list);
/* 683 */     i.setItemMeta(im);
/* 684 */     return i;
/*     */   }
/*     */   
/*     */   private static ItemStack WOOLItem(short sh, String name, ArrayList<String> lore) {
/* 688 */     ItemStack i = new ItemStack(Material.WOOL, 1, sh);
/* 689 */     ItemMeta im = i.getItemMeta();
/* 690 */     im.setDisplayName(name);
/* 691 */     ArrayList<String> list = (ArrayList<String>)lore.stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new));
/* 692 */     im.setLore(list);
/* 693 */     i.setItemMeta(im);
/* 694 */     return i;
/*     */   }
/*     */   
/*     */   private static Inventory archeryInv() {
/* 698 */     Inventory inv = Bukkit.createInventory(null, 54, "Archery Store");
/*     */     
/* 700 */     ItemStack bow = new ItemStack(Material.BOW);
/* 701 */     ItemMeta bowMeta = bow.getItemMeta();
/* 702 */     bowMeta.setDisplayName(Messages.getMsg("archery.bow.displayname"));
/* 703 */     bowMeta.setLore((List)Messages.getArray("archery.bow.lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 704 */     bow.setItemMeta(bowMeta);
/* 705 */     inv.addItem(new ItemStack[] { bow });
/*     */     
/* 707 */     ItemStack arrows5 = new ItemStack(Material.ARROW);
/* 708 */     ItemMeta aroows5Meta = arrows5.getItemMeta();
/* 709 */     aroows5Meta.setDisplayName(Messages.getMsg("archery.arrows5.displayname"));
/* 710 */     aroows5Meta.setLore((List)Messages.getArray("archery.arrows5.lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 711 */     arrows5.setItemMeta(aroows5Meta);
/* 712 */     inv.addItem(new ItemStack[] { arrows5 });
/*     */     
/* 714 */     ItemStack a10 = new ItemStack(Material.ARROW);
/* 715 */     ItemMeta aMeta = arrows5.getItemMeta();
/* 716 */     aMeta.setDisplayName(Messages.getMsg("archery.arrows10.displayname"));
/* 717 */     aMeta.setLore((List)Messages.getArray("archery.arrows10.lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(ArrayList::new)));
/* 718 */     a10.setItemMeta(aMeta);
/* 719 */     inv.addItem(new ItemStack[] { a10 });
/*     */     
/* 721 */     return inv;
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerInteractEntityListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */