/*     */ package com.andrei1058.ageofempire.listeners;
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.game.Buildings;
/*     */ import com.andrei1058.ageofempire.game.Status;
/*     */ import com.andrei1058.ageofempire.game.Vote;
/*     */ import com.andrei1058.ageofempire.runnables.Game;
/*     */ import org.bukkit.DyeColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.AnimalTamer;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Horse;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Wolf;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.EnchantmentStorageMeta;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.potion.Potion;
/*     */ import org.bukkit.potion.PotionType;
/*     */ 
/*     */ public class InventoryClickListener implements Listener {
/*     */   @EventHandler
/*     */   public void i(InventoryClickEvent e) {
/*  28 */     Player p = (Player)e.getWhoClicked();
/*  29 */     if (Main.SETUP)
/*  30 */       return;  if (Main.STATUS != Status.PLAYING) {
/*  31 */       e.setCancelled(true);
/*     */     }
/*  33 */     if (e.getCurrentItem() == null)
/*  34 */       return;  if (e.getInventory().getName().equalsIgnoreCase(Messages.getMsg("stats.displayname"))) {
/*  35 */       e.setCancelled(true);
/*     */       return;
/*     */     } 
/*  38 */     if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getDisplayName() != null) {
/*  39 */       switch (e.getCurrentItem().getType()) {
/*     */         case SKULL_ITEM:
/*  41 */           e.setCancelled(true);
/*     */           return;
/*     */         case MOB_SPAWNER:
/*  44 */           if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("locked-slot"))) {
/*  45 */             e.setCancelled(true);
/*     */           }
/*     */           return;
/*     */         case PAPER:
/*  49 */           if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("forum-paper"))) {
/*  50 */             e.setCancelled(true);
/*     */           }
/*     */           return;
/*     */         case SLIME_BALL:
/*  54 */           if (e.getCurrentItem().getItemMeta().getDisplayName() != null && 
/*  55 */             e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Messages.getMsg("validate-vote"))) {
/*  56 */             e.setCancelled(true);
/*     */           }
/*     */           return;
/*     */         
/*     */         case ANVIL:
/*  61 */           e.setCancelled(true);
/*  62 */           stuff((Player)e.getWhoClicked(), "FORGE", Integer.valueOf(150), Integer.valueOf(75), true, false, false);
/*     */           return;
/*     */         case WHEAT:
/*  65 */           e.setCancelled(true);
/*  66 */           stuff((Player)e.getWhoClicked(), "MILL", Integer.valueOf(150), Integer.valueOf(75), true, false, false);
/*     */           return;
/*     */         case DIAMOND_PICKAXE:
/*  69 */           e.setCancelled(true);
/*  70 */           stuff((Player)e.getWhoClicked(), "STONE_MINE", Integer.valueOf(150), Integer.valueOf(75), true, false, false);
/*     */           return;
/*     */         case GOLD_ORE:
/*  73 */           e.setCancelled(true);
/*  74 */           stuff((Player)e.getWhoClicked(), "GOLD_MINE", Integer.valueOf(150), Integer.valueOf(100), true, false, false);
/*     */           return;
/*     */         case DIAMOND_AXE:
/*  77 */           e.setCancelled(true);
/*  78 */           if (e.getInventory().getName().equalsIgnoreCase("Forum")) {
/*  79 */             stuff((Player)e.getWhoClicked(), "SAWMILL", Integer.valueOf(150), Integer.valueOf(75), true, false, false);
/*     */           } else {
/*  81 */             buy(p, Material.DIAMOND_AXE, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(25));
/*     */           } 
/*     */           return;
/*     */         case DIAMOND_SWORD:
/*  85 */           e.setCancelled(true);
/*  86 */           buy(p, Material.DIAMOND_SWORD, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(50));
/*     */           return;
/*     */         case WORKBENCH:
/*  89 */           e.setCancelled(true);
/*  90 */           stuff((Player)e.getWhoClicked(), "WORKSHOP", Integer.valueOf(100), Integer.valueOf(50), true, false, false);
/*     */           return;
/*     */         case EMERALD:
/*  93 */           e.setCancelled(true);
/*  94 */           stuff((Player)e.getWhoClicked(), "MARKET", Integer.valueOf(100), Integer.valueOf(50), true, false, false);
/*     */           return;
/*     */         case BONE:
/*  97 */           e.setCancelled(true);
/*  98 */           stuff((Player)e.getWhoClicked(), "KENNEL", Integer.valueOf(100), Integer.valueOf(50), true, false, false);
/*     */           return;
/*     */         case TNT:
/* 101 */           e.setCancelled(true);
/* 102 */           if (e.getInventory().getName().equalsIgnoreCase("Forum")) {
/* 103 */             stuff((Player)e.getWhoClicked(), "SABOTAGE_WORKSHOP", Integer.valueOf(100), Integer.valueOf(50), true, false, false);
/*     */           } else {
/* 105 */             buy(p, Material.TNT, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(5));
/*     */           } 
/*     */           return;
/*     */         case STONE_PICKAXE:
/* 109 */           e.setCancelled(true);
/* 110 */           buy(p, Material.STONE_PICKAXE, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(1));
/*     */           return;
/*     */         case STONE_SWORD:
/* 113 */           e.setCancelled(true);
/* 114 */           buy(p, Material.STONE_SWORD, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case IRON_SWORD:
/* 117 */           e.setCancelled(true);
/* 118 */           buy(p, Material.IRON_SWORD, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(30));
/*     */           return;
/*     */         case STONE_AXE:
/* 121 */           e.setCancelled(true);
/* 122 */           buy(p, Material.STONE_AXE, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(5));
/*     */           return;
/*     */         case IRON_AXE:
/* 125 */           e.setCancelled(true);
/* 126 */           buy(p, Material.IRON_AXE, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(15));
/*     */           return;
/*     */         case BREAD:
/* 129 */           e.setCancelled(true);
/* 130 */           buy(p, Material.BREAD, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case POTATO:
/* 133 */           e.setCancelled(true);
/* 134 */           buy(p, Material.POTATO, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(15));
/*     */           return;
/*     */         case COOKED_BEEF:
/* 137 */           e.setCancelled(true);
/* 138 */           buy(p, Material.COOKED_BEEF, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(22));
/*     */           return;
/*     */         case COOKED_CHICKEN:
/* 141 */           e.setCancelled(true);
/* 142 */           buy(p, Material.COOKED_CHICKEN, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(20));
/*     */           return;
/*     */         case GRASS:
/* 145 */           e.setCancelled(true);
/* 146 */           buy(p, Material.GRASS, Integer.valueOf(10), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case DIRT:
/* 149 */           e.setCancelled(true);
/* 150 */           buy(p, Material.DIRT, Integer.valueOf(10), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case WOOD_DOUBLE_STEP:
/* 153 */           e.setCancelled(true);
/* 154 */           buy(p, Material.WOOD_DOUBLE_STEP, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case SAND:
/* 157 */           e.setCancelled(true);
/* 158 */           buy(p, Material.SAND, Integer.valueOf(10), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case WOOL:
/* 161 */           e.setCancelled(true);
/* 162 */           buy(p, Material.WOOL, Integer.valueOf(10), Short.valueOf((short)e.getCurrentItem().getData().getData()), Integer.valueOf(10));
/*     */           return;
/*     */         case BRICK:
/* 165 */           e.setCancelled(true);
/* 166 */           buy(p, Material.BRICK, Integer.valueOf(10), Short.valueOf((short)0), Integer.valueOf(15));
/*     */           return;
/*     */         case LEAVES:
/* 169 */           e.setCancelled(true);
/* 170 */           buy(p, Material.LEAVES, Integer.valueOf(10), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case MOSSY_COBBLESTONE:
/* 173 */           e.setCancelled(true);
/* 174 */           buy(p, Material.MOSSY_COBBLESTONE, Integer.valueOf(10), Short.valueOf((short)0), Integer.valueOf(15));
/*     */           return;
/*     */         case GRAVEL:
/* 177 */           e.setCancelled(true);
/* 178 */           buy(p, Material.GRAVEL, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case GLASS:
/* 181 */           e.setCancelled(true);
/* 182 */           buy(p, Material.GRAVEL, Integer.valueOf(10), Short.valueOf((short)0), Integer.valueOf(10));
/*     */           return;
/*     */         case LAPIS_BLOCK:
/* 185 */           e.setCancelled(true);
/* 186 */           buy(p, Material.LAPIS_BLOCK, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(26));
/*     */           return;
/*     */         case FLINT_AND_STEEL:
/* 189 */           e.setCancelled(true);
/* 190 */           buy(p, Material.FLINT_AND_STEEL, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(5));
/*     */           return;
/*     */         case WEB:
/* 193 */           e.setCancelled(true);
/* 194 */           buy(p, Material.WEB, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(5));
/*     */           return;
/*     */         case TORCH:
/* 197 */           e.setCancelled(true);
/* 198 */           buy(p, Material.TORCH, Integer.valueOf(12), Short.valueOf((short)0), Integer.valueOf(5));
/*     */           return;
/*     */         case BOAT:
/* 201 */           e.setCancelled(true);
/* 202 */           buy(p, Material.BOAT, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(2));
/*     */           return;
/*     */         case MONSTER_EGG:
/* 205 */           e.setCancelled(true);
/* 206 */           if (e.getInventory().getName().equalsIgnoreCase("Stable")) {
/* 207 */             if (((Integer)Main.gold.get(p)).intValue() >= 30) {
/* 208 */               Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - 30));
/* 209 */               Horse h = (Horse)p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
/* 210 */               h.setOwner((AnimalTamer)p);
/* 211 */               h.getInventory().setSaddle(new ItemStack(Material.SADDLE));
/*     */             } else {
/* 213 */               p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */             }
/*     */           
/* 216 */           } else if (e.getSlot() == 0) {
/* 217 */             if (((Integer)Main.gold.get(p)).intValue() >= 50) {
/* 218 */               Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - 50));
/* 219 */               Wolf w = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
/* 220 */               w.setOwner((AnimalTamer)p);
/* 221 */               w.setCollarColor(DyeColor.BLUE);
/*     */             } else {
/* 223 */               p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */             } 
/* 225 */           } else if (e.getSlot() == 1) {
/* 226 */             if (((Integer)Main.gold.get(p)).intValue() >= 75) {
/* 227 */               Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - 75));
/* 228 */               Wolf w = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
/* 229 */               w.setOwner((AnimalTamer)p);
/* 230 */               w.setCollarColor(DyeColor.BLUE);
/* 231 */               Wolf w2 = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
/* 232 */               w2.setOwner((AnimalTamer)p);
/* 233 */               w2.setCollarColor(DyeColor.BLUE);
/*     */             } else {
/* 235 */               p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */             } 
/* 237 */           } else if (e.getSlot() == 2) {
/* 238 */             if (((Integer)Main.gold.get(p)).intValue() >= 100) {
/* 239 */               Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - 100));
/* 240 */               Wolf w = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
/* 241 */               w.setOwner((AnimalTamer)p);
/* 242 */               w.setCollarColor(DyeColor.BLUE);
/* 243 */               Wolf w2 = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
/* 244 */               w2.setOwner((AnimalTamer)p);
/* 245 */               w2.setCollarColor(DyeColor.BLUE);
/* 246 */               Wolf w3 = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
/* 247 */               w3.setOwner((AnimalTamer)p);
/* 248 */               w3.setCollarColor(DyeColor.BLUE);
/*     */             } else {
/* 250 */               p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         
/*     */         case DARK_OAK_DOOR_ITEM:
/* 256 */           e.setCancelled(true);
/* 257 */           voteAge(p, Integer.valueOf(1250), Integer.valueOf(750), Integer.valueOf(2));
/*     */           return;
/*     */         case IRON_DOOR:
/* 260 */           e.setCancelled(true);
/* 261 */           voteAge(p, Integer.valueOf(2250), Integer.valueOf(1250), Integer.valueOf(3));
/*     */           return;
/*     */         case DIAMOND:
/* 264 */           e.setCancelled(true);
/* 265 */           voteAge(p, Integer.valueOf(4250), Integer.valueOf(3150), Integer.valueOf(4));
/*     */           return;
/*     */         default:
/* 268 */           e.setCancelled(true);
/*     */           return;
/*     */         case BOW:
/* 271 */           e.setCancelled(true);
/* 272 */           if (e.getInventory().getName().equalsIgnoreCase("Forum")) {
/* 273 */             stuff((Player)e.getWhoClicked(), "ARCHERY_STORE", Integer.valueOf(300), Integer.valueOf(150), false, true, false);
/*     */           } else {
/* 275 */             buy(p, Material.BOW, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(30));
/*     */           } 
/*     */           return;
/*     */         case ARROW:
/* 279 */           if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cExplosive")) {
/* 280 */             e.setCancelled(false);
/*     */             return;
/*     */           } 
/* 283 */           e.setCancelled(true);
/* 284 */           if (e.getInventory().getName().equalsIgnoreCase("Forum")) {
/* 285 */             stuff((Player)e.getWhoClicked(), "TRIFARROW", Integer.valueOf(375), Integer.valueOf(175), false, true, false);
/* 286 */           } else if (e.getInventory().getName().equalsIgnoreCase("TrifArrow")) {
/* 287 */             ItemStack i = new ItemStack(Material.ARROW);
/* 288 */             ItemMeta im = i.getItemMeta();
/* 289 */             im.setDisplayName("§cExplosive");
/* 290 */             i.setItemMeta(im);
/* 291 */             if (((Integer)Main.gold.get(p)).intValue() >= 20) {
/* 292 */               Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - 20));
/* 293 */               p.getInventory().addItem(new ItemStack[] { i });
/*     */             } else {
/* 295 */               p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */             } 
/* 297 */           } else if (e.getInventory().getName().equalsIgnoreCase("Archery Store")) {
/* 298 */             if (e.getSlot() == 1 && e.getCurrentItem().getType() == Material.ARROW) {
/* 299 */               buy(p, Material.ARROW, Integer.valueOf(5), Short.valueOf((short)0), Integer.valueOf(5));
/* 300 */             } else if (e.getSlot() == 2 && e.getCurrentItem().getType() == Material.ARROW) {
/* 301 */               buy(p, Material.ARROW, Integer.valueOf(10), Short.valueOf((short)0), Integer.valueOf(7));
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         case SADDLE:
/* 306 */           e.setCancelled(true);
/* 307 */           stuff((Player)e.getWhoClicked(), "STABLE", Integer.valueOf(200), Integer.valueOf(100), false, true, false);
/*     */           return;
/*     */         case DIAMOND_CHESTPLATE:
/* 310 */           if (e.getInventory().getName().equalsIgnoreCase("Forum")) {
/* 311 */             e.setCancelled(true);
/* 312 */             stuff((Player)e.getWhoClicked(), "ARMORY", Integer.valueOf(300), Integer.valueOf(150), false, true, false);
/* 313 */           } else if (e.getInventory().getName().equalsIgnoreCase("Armory")) {
/* 314 */             e.setCancelled(true);
/* 315 */             buyDiamondArmor(p);
/*     */           } 
/*     */           return;
/*     */         case BREWING_STAND_ITEM:
/* 319 */           e.setCancelled(true);
/* 320 */           stuff((Player)e.getWhoClicked(), "LABORATORY", Integer.valueOf(300), Integer.valueOf(150), false, true, false);
/*     */           return;
/*     */         case ENCHANTED_BOOK:
/* 323 */           if (e.getInventory().getName().equalsIgnoreCase("Forum")) {
/* 324 */             e.setCancelled(true);
/* 325 */             stuff((Player)e.getWhoClicked(), "GUILD", Integer.valueOf(600), Integer.valueOf(300), false, false, true);
/* 326 */           } else if (e.getInventory().getName().equalsIgnoreCase("Guild")) {
/* 327 */             e.setCancelled(true);
/* 328 */             String name = e.getCurrentItem().getItemMeta().getDisplayName();
/* 329 */             if (name.equalsIgnoreCase(Messages.getMsg("guild.sharpness.name"))) {
/* 330 */               enchant(p, Enchantment.DAMAGE_ALL, Integer.valueOf(20));
/* 331 */             } else if (name.equalsIgnoreCase(Messages.getMsg("guild.knockback.name"))) {
/* 332 */               enchant(p, Enchantment.KNOCKBACK, Integer.valueOf(10));
/* 333 */             } else if (name.equalsIgnoreCase(Messages.getMsg("guild.protection.name"))) {
/* 334 */               enchant(p, Enchantment.PROTECTION_ENVIRONMENTAL, Integer.valueOf(20));
/* 335 */             } else if (name.equalsIgnoreCase(Messages.getMsg("guild.thorns.name"))) {
/* 336 */               enchant(p, Enchantment.THORNS, Integer.valueOf(10));
/* 337 */             } else if (name.equalsIgnoreCase(Messages.getMsg("guild.featherfalling.name"))) {
/* 338 */               enchant(p, Enchantment.LURE, Integer.valueOf(10));
/* 339 */             } else if (name.equalsIgnoreCase(Messages.getMsg("guild.projectileprotection.name"))) {
/* 340 */               enchant(p, Enchantment.PROTECTION_PROJECTILE, Integer.valueOf(10));
/* 341 */             } else if (name.equalsIgnoreCase(Messages.getMsg("guild.fireprotection.name"))) {
/* 342 */               enchant(p, Enchantment.PROTECTION_FIRE, Integer.valueOf(10));
/* 343 */             } else if (name.equalsIgnoreCase(Messages.getMsg("guild.power.name"))) {
/* 344 */               enchant(p, Enchantment.ARROW_DAMAGE, Integer.valueOf(20));
/* 345 */             } else if (name.equalsIgnoreCase(Messages.getMsg("guild.power.name"))) {
/* 346 */               enchant(p, Enchantment.ARROW_KNOCKBACK, Integer.valueOf(10));
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         case EXP_BOTTLE:
/* 351 */           e.setCancelled(true);
/* 352 */           stuff((Player)e.getWhoClicked(), "TRAINING_CENTER", Integer.valueOf(500), Integer.valueOf(250), false, false, true);
/*     */           return;
/*     */         case IRON_CHESTPLATE:
/* 355 */           if (e.getInventory().getName().equalsIgnoreCase("Armory")) {
/* 356 */             e.setCancelled(true);
/* 357 */             buyIronArmor(p);
/*     */           } 
/*     */           return;
/*     */         case IRON_BARDING:
/* 361 */           if (e.getInventory().getName().equalsIgnoreCase("Armory")) {
/* 362 */             e.setCancelled(true);
/* 363 */             buy(p, Material.IRON_BARDING, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(80));
/*     */           } 
/*     */           return;
/*     */         case DIAMOND_BARDING:
/* 367 */           if (e.getInventory().getName().equalsIgnoreCase("Armory")) {
/* 368 */             e.setCancelled(true);
/* 369 */             buy(p, Material.DIAMOND_BARDING, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(80));
/*     */           }  return;
/*     */         case POTION:
/*     */           break;
/* 373 */       }  if (e.getInventory().getName().equalsIgnoreCase("Laboratory")) {
/* 374 */         e.setCancelled(true);
/* 375 */         String name = e.getCurrentItem().getItemMeta().getDisplayName();
/* 376 */         if (name.equalsIgnoreCase(Messages.getMsg("lab.swiftness.name"))) {
/* 377 */           buyPotion(p, Integer.valueOf(35), PotionType.SPEED, false);
/* 378 */         } else if (name.equalsIgnoreCase(Messages.getMsg("lab.fireresistance.name"))) {
/* 379 */           buyPotion(p, Integer.valueOf(35), PotionType.FIRE_RESISTANCE, false);
/* 380 */         } else if (name.equalsIgnoreCase(Messages.getMsg("lab.healing.name"))) {
/* 381 */           buyPotion(p, Integer.valueOf(35), PotionType.INSTANT_HEAL, false);
/* 382 */         } else if (name.equalsIgnoreCase(Messages.getMsg("lab.nightvision.name"))) {
/* 383 */           buyPotion(p, Integer.valueOf(35), PotionType.NIGHT_VISION, false);
/* 384 */         } else if (name.equalsIgnoreCase(Messages.getMsg("lab.leaping.lore"))) {
/* 385 */           buyPotion(p, Integer.valueOf(35), PotionType.JUMP, false);
/* 386 */         } else if (name.equalsIgnoreCase(Messages.getMsg("lab.regeneration.lore"))) {
/* 387 */           buyPotion(p, Integer.valueOf(50), PotionType.REGEN, false);
/* 388 */         } else if (name.equalsIgnoreCase(Messages.getMsg("lab.waterbreathing.name"))) {
/* 389 */           buyPotion(p, Integer.valueOf(35), PotionType.WATER_BREATHING, false);
/* 390 */         } else if (name.equalsIgnoreCase(Messages.getMsg("lab.splashswiftness.name"))) {
/* 391 */           buyPotion(p, Integer.valueOf(75), PotionType.SPEED, true);
/* 392 */         } else if (name.equalsIgnoreCase(Messages.getMsg("lab.splashleaping.name"))) {
/* 393 */           buyPotion(p, Integer.valueOf(75), PotionType.JUMP, true);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void enchant(Player u, Enchantment enchantment, Integer price) {
/* 403 */     ItemStack i = new ItemStack(Material.ENCHANTED_BOOK);
/* 404 */     EnchantmentStorageMeta m = (EnchantmentStorageMeta)i.getItemMeta();
/* 405 */     m.addStoredEnchant(enchantment, 1, true);
/* 406 */     i.setItemMeta((ItemMeta)m);
/* 407 */     if (((Integer)Main.gold.get(u)).intValue() > price.intValue()) {
/* 408 */       u.getInventory().addItem(new ItemStack[] { i });
/* 409 */       Main.gold.replace(u, Integer.valueOf(((Integer)Main.gold.get(u)).intValue() - price.intValue()));
/*     */     } else {
/* 411 */       u.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void buyPotion(Player p, Integer price, PotionType potionType, boolean splash) {
/* 416 */     if (((Integer)Main.gold.get(p)).intValue() >= price.intValue()) {
/* 417 */       Potion potion = new Potion(potionType);
/* 418 */       potion.setSplash(splash);
/* 419 */       p.getInventory().addItem(new ItemStack[] { potion.toItemStack(1) });
/* 420 */       Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - price.intValue()));
/*     */     } else {
/* 422 */       p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void buy(Player p, Material material, Integer cantitate, Short sh, Integer price) {
/* 427 */     if (((Integer)Main.gold.get(p)).intValue() >= price.intValue()) {
/* 428 */       p.getInventory().addItem(new ItemStack[] { new ItemStack(material, cantitate.intValue(), sh.shortValue()) });
/* 429 */       Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - price.intValue()));
/*     */     } else {
/* 431 */       p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void buyIronArmor(Player p) {
/* 436 */     if (((Integer)Main.gold.get(p)).intValue() >= 40) {
/* 437 */       Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - 40));
/* 438 */       buy(p, Material.IRON_HELMET, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(0));
/* 439 */       buy(p, Material.IRON_CHESTPLATE, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(0));
/* 440 */       buy(p, Material.IRON_LEGGINGS, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(0));
/* 441 */       buy(p, Material.IRON_BOOTS, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(0));
/*     */     } else {
/* 443 */       p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void buyDiamondArmor(Player p) {
/* 448 */     if (((Integer)Main.gold.get(p)).intValue() >= 80) {
/* 449 */       Main.gold.replace(p, Integer.valueOf(((Integer)Main.gold.get(p)).intValue() - 80));
/* 450 */       buy(p, Material.IRON_HELMET, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(0));
/* 451 */       buy(p, Material.DIAMOND_CHESTPLATE, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(0));
/* 452 */       buy(p, Material.IRON_LEGGINGS, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(0));
/* 453 */       buy(p, Material.DIAMOND_BOOTS, Integer.valueOf(1), Short.valueOf((short)0), Integer.valueOf(0));
/*     */     } else {
/* 455 */       p.sendMessage(Messages.getMsg("insufficient-gold"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void voteAge(Player p, Integer wood, Integer stone, Integer age) {
/* 461 */     if (age.intValue() > 4)
/* 462 */       return;  if (Main.bluePlayers.contains(p)) {
/* 463 */       if (Game.blue_change_age)
/* 464 */         return;  if (Buildings.vote_in_progress.contains("Blue")) {
/* 465 */         p.sendMessage(Messages.getMsg("cant-vote"));
/*     */         return;
/*     */       } 
/* 468 */       if (Main.blue_wood >= wood.intValue() && Main.blue_stone >= stone.intValue()) {
/* 469 */         new Vote(Main.bluePlayers, "age", p, "Blue", wood.intValue(), stone.intValue(), "age");
/*     */       } else {
/* 471 */         String miss_wood = "0";
/* 472 */         String miss_stone = "0";
/* 473 */         if (wood.intValue() - Main.blue_wood > 0) {
/* 474 */           miss_wood = String.valueOf(wood.intValue() - Main.blue_wood);
/*     */         }
/* 476 */         if (stone.intValue() - Main.blue_stone > 0) {
/* 477 */           miss_stone = String.valueOf(stone.intValue() - Main.blue_stone);
/*     */         }
/* 479 */         p.sendMessage(Messages.getMsg("insufficient-resources").replace("{wood}", miss_wood).replace("{stone}", miss_stone));
/*     */       } 
/* 481 */     } else if (Main.greenPlayers.contains(p)) {
/* 482 */       if (Game.green_change_age)
/* 483 */         return;  if (Buildings.vote_in_progress.contains("Green")) {
/* 484 */         p.sendMessage(Messages.getMsg("cant-vote"));
/*     */         return;
/*     */       } 
/* 487 */       if (Main.green_wood >= wood.intValue() && Main.green_stone >= stone.intValue()) {
/* 488 */         new Vote(Main.greenPlayers, "age", p, "Green", wood.intValue(), stone.intValue(), "age");
/*     */       } else {
/* 490 */         String miss_wood = "0";
/* 491 */         String miss_stone = "0";
/* 492 */         if (wood.intValue() - Main.green_wood > 0) {
/* 493 */           miss_wood = String.valueOf(wood.intValue() - Main.green_wood);
/*     */         }
/* 495 */         if (stone.intValue() - Main.green_stone > 0) {
/* 496 */           miss_stone = String.valueOf(stone.intValue() - Main.green_stone);
/*     */         }
/* 498 */         p.sendMessage(Messages.getMsg("insufficient-resources").replace("{wood}", miss_wood).replace("{stone}", miss_stone));
/*     */       } 
/* 500 */     } else if (Main.yellowPlayers.contains(p)) {
/* 501 */       if (Game.yellow_change_age)
/* 502 */         return;  if (Buildings.vote_in_progress.contains("Yellow")) {
/* 503 */         p.sendMessage(Messages.getMsg("cant-vote"));
/*     */         return;
/*     */       } 
/* 506 */       if (Main.yellow_wood >= wood.intValue() && Main.yellow_stone >= stone.intValue()) {
/* 507 */         new Vote(Main.yellowPlayers, "age", p, "Yellow", wood.intValue(), stone.intValue(), "age");
/*     */       } else {
/* 509 */         String miss_wood = "0";
/* 510 */         String miss_stone = "0";
/* 511 */         if (wood.intValue() - Main.yellow_wood > 0) {
/* 512 */           miss_wood = String.valueOf(wood.intValue() - Main.yellow_wood);
/*     */         }
/* 514 */         if (stone.intValue() - Main.yellow_stone > 0) {
/* 515 */           miss_stone = String.valueOf(stone.intValue() - Main.yellow_stone);
/*     */         }
/* 517 */         p.sendMessage(Messages.getMsg("insufficient-resources").replace("{wood}", miss_wood).replace("{stone}", miss_stone));
/*     */       } 
/* 519 */     } else if (Main.redPlayers.contains(p)) {
/* 520 */       if (Game.red_change_age)
/* 521 */         return;  if (Buildings.vote_in_progress.contains("Red")) {
/* 522 */         p.sendMessage(Messages.getMsg("cant-vote"));
/*     */         return;
/*     */       } 
/* 525 */       if (Main.red_wood >= wood.intValue() && Main.red_stone >= stone.intValue()) {
/* 526 */         new Vote(Main.redPlayers, "age", p, "Red", wood.intValue(), stone.intValue(), "age");
/*     */       } else {
/* 528 */         String miss_wood = "0";
/* 529 */         String miss_stone = "0";
/* 530 */         if (wood.intValue() - Main.red_wood > 0) {
/* 531 */           miss_wood = String.valueOf(wood.intValue() - Main.red_wood);
/*     */         }
/* 533 */         if (stone.intValue() - Main.red_stone > 0) {
/* 534 */           miss_stone = String.valueOf(stone.intValue() - Main.red_stone);
/*     */         }
/* 536 */         p.sendMessage(Messages.getMsg("insufficient-resources").replace("{wood}", miss_wood).replace("{stone}", miss_stone));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void stuff(Player p, String building, Integer wood, Integer stone, boolean small, boolean medium, boolean large) {
/* 542 */     if (Buildings.construct_in_inv.containsKey(p)) {
/* 543 */       p.sendMessage(Messages.getMsg("having-construct"));
/*     */       return;
/*     */     } 
/* 546 */     if (Main.bluePlayers.contains(p)) {
/* 547 */       if (Buildings.blue_built.contains(building)) {
/* 548 */         p.sendMessage(Messages.getMsg("already-built"));
/*     */         return;
/*     */       } 
/* 551 */       if (Buildings.vote_in_progress.contains("Blue")) {
/* 552 */         p.sendMessage(Messages.getMsg("cant-vote"));
/*     */         return;
/*     */       } 
/* 555 */       if (Main.blue_small_plots == 0 && small) {
/* 556 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 559 */       if (Main.blue_medium_plots == 0 && medium) {
/* 560 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 563 */       if (Main.blue_large_plots == 0 && large) {
/* 564 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 567 */       if (Main.blue_wood >= wood.intValue() && Main.blue_stone >= stone.intValue()) {
/* 568 */         new Vote(Main.bluePlayers, Messages.getMsg("forum." + building + ".displayname"), p, "Blue", wood.intValue(), stone.intValue(), building);
/*     */       } else {
/* 570 */         String miss_wood = "0";
/* 571 */         String miss_stone = "0";
/* 572 */         if (wood.intValue() - Main.blue_wood > 0) {
/* 573 */           miss_wood = String.valueOf(wood.intValue() - Main.blue_wood);
/*     */         }
/* 575 */         if (stone.intValue() - Main.blue_stone > 0) {
/* 576 */           miss_stone = String.valueOf(stone.intValue() - Main.blue_stone);
/*     */         }
/* 578 */         p.sendMessage(Messages.getMsg("insufficient-resources").replace("{wood}", miss_wood).replace("{stone}", miss_stone));
/*     */       } 
/* 580 */     } else if (Main.greenPlayers.contains(p)) {
/* 581 */       if (Buildings.green_built.contains(building)) {
/* 582 */         p.sendMessage(Messages.getMsg("already-built"));
/*     */         return;
/*     */       } 
/* 585 */       if (Buildings.vote_in_progress.contains("Green")) {
/* 586 */         p.sendMessage(Messages.getMsg("cant-vote"));
/*     */         return;
/*     */       } 
/* 589 */       if (Main.green_small_plots == 0 && small) {
/* 590 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 593 */       if (Main.green_medium_plots == 0 && medium) {
/* 594 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 597 */       if (Main.green_large_plots == 0 && large) {
/* 598 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 601 */       if (Main.green_wood >= wood.intValue() && Main.green_stone >= stone.intValue()) {
/* 602 */         new Vote(Main.greenPlayers, Messages.getMsg("forum." + building + ".displayname"), p, "Green", wood.intValue(), stone.intValue(), building);
/*     */       } else {
/* 604 */         String miss_wood = "0";
/* 605 */         String miss_stone = "0";
/* 606 */         if (wood.intValue() - Main.green_wood > 0) {
/* 607 */           miss_wood = String.valueOf(wood.intValue() - Main.green_wood);
/*     */         }
/* 609 */         if (stone.intValue() - Main.green_stone > 0) {
/* 610 */           miss_stone = String.valueOf(stone.intValue() - Main.green_stone);
/*     */         }
/* 612 */         p.sendMessage(Messages.getMsg("insufficient-resources").replace("{wood}", miss_wood).replace("{stone}", miss_stone));
/*     */       } 
/* 614 */     } else if (Main.yellowPlayers.contains(p)) {
/* 615 */       if (Buildings.yellow_built.contains(building)) {
/* 616 */         p.sendMessage(Messages.getMsg("already-built"));
/*     */         return;
/*     */       } 
/* 619 */       if (Buildings.vote_in_progress.contains("Yellow")) {
/* 620 */         p.sendMessage(Messages.getMsg("cant-vote"));
/*     */         return;
/*     */       } 
/* 623 */       if (Main.yellow_small_plots == 0 && small) {
/* 624 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 627 */       if (Main.yellow_medium_plots == 0 && medium) {
/* 628 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 631 */       if (Main.yellow_large_plots == 0 && large) {
/* 632 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 635 */       if (Main.yellow_wood >= wood.intValue() && Main.yellow_stone >= stone.intValue()) {
/* 636 */         new Vote(Main.yellowPlayers, Messages.getMsg("forum." + building + ".displayname"), p, "Yellow", wood.intValue(), stone.intValue(), building);
/*     */       } else {
/* 638 */         String miss_wood = "0";
/* 639 */         String miss_stone = "0";
/* 640 */         if (wood.intValue() - Main.yellow_wood > 0) {
/* 641 */           miss_wood = String.valueOf(wood.intValue() - Main.yellow_wood);
/*     */         }
/* 643 */         if (stone.intValue() - Main.yellow_stone > 0) {
/* 644 */           miss_stone = String.valueOf(stone.intValue() - Main.yellow_stone);
/*     */         }
/* 646 */         p.sendMessage(Messages.getMsg("insufficient-resources").replace("{wood}", miss_wood).replace("{stone}", miss_stone));
/*     */       } 
/* 648 */     } else if (Main.redPlayers.contains(p)) {
/* 649 */       if (Buildings.red_built.contains(building)) {
/* 650 */         p.sendMessage(Messages.getMsg("already-built"));
/*     */         return;
/*     */       } 
/* 653 */       if (Buildings.vote_in_progress.contains("Red")) {
/* 654 */         p.sendMessage(Messages.getMsg("cant-vote"));
/*     */         return;
/*     */       } 
/* 657 */       if (Main.red_small_plots == 0 && small) {
/* 658 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 661 */       if (Main.red_medium_plots == 0 && medium) {
/* 662 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 665 */       if (Main.red_large_plots == 0 && large) {
/* 666 */         p.sendMessage(Messages.getMsg("cant-vote-full"));
/*     */         return;
/*     */       } 
/* 669 */       if (Main.red_wood >= wood.intValue() && Main.red_stone >= stone.intValue()) {
/* 670 */         new Vote(Main.redPlayers, Messages.getMsg("forum." + building + ".displayname"), p, "Red", wood.intValue(), stone.intValue(), building);
/*     */       } else {
/* 672 */         String miss_wood = "0";
/* 673 */         String miss_stone = "0";
/* 674 */         if (wood.intValue() - Main.red_wood > 0) {
/* 675 */           miss_wood = String.valueOf(wood.intValue() - Main.red_wood);
/*     */         }
/* 677 */         if (stone.intValue() - Main.red_stone > 0) {
/* 678 */           miss_stone = String.valueOf(stone.intValue() - Main.red_stone);
/*     */         }
/* 680 */         p.sendMessage(Messages.getMsg("insufficient-resources").replace("{wood}", miss_wood).replace("{stone}", miss_stone));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\InventoryClickListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */