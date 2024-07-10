/*     */ package com.andrei1058.ageofempire.game;
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.locations.Schematic;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Villager;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ import org.jnbt.ByteArrayTag;
/*     */ import org.jnbt.CompoundTag;
/*     */ import org.jnbt.NBTInputStream;
/*     */ import org.jnbt.ShortTag;
/*     */ import org.jnbt.Tag;
/*     */ 
/*     */ public class BuildSchematic {
/*     */   public Player player;
/*     */   public String team;
/*  27 */   public World world = Bukkit.getWorld(Main.choosenMap); public String chat_build_name; public String build_cfg_name;
/*  28 */   private static HashMap<Player, BuildSchematic> buildSchematicHashMap = new HashMap<>();
/*     */   public ArrayList<Player> teaamarray;
/*     */   public Location villager;
/*     */   
/*     */   public BuildSchematic(Player player, String team, String chat_build_name, String build_cfg_name, ArrayList<Player> teamarray) {
/*  33 */     this.player = player;
/*  34 */     this.team = team;
/*  35 */     this.chat_build_name = chat_build_name;
/*  36 */     this.build_cfg_name = build_cfg_name;
/*  37 */     this.teaamarray = teamarray;
/*  38 */     buildSchematicHashMap.put(player, this);
/*     */   }
/*     */   
/*     */   public void ok(Location center) {
/*  42 */     if (!Buildings.construct_in_inv.containsKey(this.player))
/*  43 */       return;  Buildings.addBuild(this.build_cfg_name, this.team);
/*  44 */     for (Player u : this.teaamarray) {
/*  45 */       u.sendMessage(Messages.getMsg("build-started").replace("{player}", this.player.getName()).replace("{building}", this.chat_build_name));
/*     */     }
/*     */     try {
/*  48 */       pasteSchematic(center, loadSchematic(new File("plugins/Age-Of-Empire/schematics/" + (String)Buildings.construct_in_inv.get(this.player) + ".schematic")));
/*  49 */       end();
/*  50 */     } catch (IOException e) {
/*  51 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void end() {
/*  56 */     buildSchematicHashMap.remove(this.player, this);
/*  57 */     Buildings.construct_in_inv.remove(this.player);
/*     */   }
/*     */   
/*     */   public static BuildSchematic getPlayer(Player player) {
/*  61 */     return buildSchematicHashMap.get(player);
/*     */   }
/*     */   
/*     */   public void pasteSchematic(Location loc, Schematic schematic) {
/*  65 */     short[] blocks = schematic.getBlocks();
/*  66 */     byte[] blockData = schematic.getData();
/*     */     
/*  68 */     short length = schematic.getLenght();
/*  69 */     short width = schematic.getWidth();
/*  70 */     short height = schematic.getHeight();
/*     */     
/*  72 */     ArrayList<Location> locatii = new ArrayList<>();
/*  73 */     final HashMap<Location, Short> iduri = new HashMap<>();
/*  74 */     final HashMap<Location, Byte> data = new HashMap<>();
/*     */     
/*  76 */     for (int x = 0; x < width; x++) {
/*  77 */       for (int y = 0; y < height; y++) {
/*  78 */         for (int z = 0; z < length; z++) {
/*  79 */           int index = y * width * length + z * width + x;
/*  80 */           if (blocks[index] != 0) {
/*  81 */             Location l = new Location(this.world, x + loc.getX(), y + loc.getY(), z + loc.getZ());
/*  82 */             locatii.add(l);
/*  83 */             iduri.put(l, Short.valueOf(blocks[index]));
/*  84 */             if (blocks[index] == 169) this.villager = l.clone().add(0.0D, 1.0D, 0.0D); 
/*  85 */             data.put(l, Byte.valueOf(blockData[index]));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     final List<Location> orderedLocation = new ArrayList<>();
/*     */     
/*  93 */     orderedLocation.addAll(locatii);
/*     */     
/*  95 */     Collections.sort(orderedLocation, Comparator.comparingDouble(Location::getY));
/*  96 */     final int size = locatii.size();
/*  97 */     int blocksPerTime = 2;
/*  98 */     long delay = 0L;
/*     */     
/* 100 */     if (size > 0) {
/* 101 */       (new BukkitRunnable() {
/* 102 */           int index = 0;
/*     */           
/*     */           public void run() {
/* 105 */             for (int i = 0; i < 2; i++) {
/* 106 */               if (this.index < size) {
/* 107 */                 Location loc = orderedLocation.get(this.index);
/* 108 */                 Block block = loc.getBlock();
/* 109 */                 block.setType(Material.getMaterial(((Short)iduri.get(loc)).shortValue()));
/* 110 */                 block.setData(((Byte)data.get(loc)).byteValue());
/* 111 */                 block.getState().update(true);
/* 112 */                 block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getTypeId());
/* 113 */                 this.index++;
/*     */               } else {
/* 115 */                 cancel();
/* 116 */                 for (Player u : BuildSchematic.this.teaamarray) {
/* 117 */                   u.sendMessage(Messages.getMsg("built-success").replace("{building}", BuildSchematic.this.chat_build_name));
/*     */                 }
/* 119 */                 Villager v = Main.nms.spawnVillager(BuildSchematic.this.villager, Integer.valueOf(Main.other_health));
/* 120 */                 switch (BuildSchematic.this.build_cfg_name) {
/*     */                   case "FORGE":
/* 122 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.FORGE.displayname"), Messages.getMsg("forum.FORGE.holo"), v);
/* 123 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 125 */                         Main.blue_forge = v;
/*     */                         break;
/*     */                       case "Green":
/* 128 */                         Main.green_forge = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 131 */                         Main.yellow_forge = v;
/*     */                         break;
/*     */                       case "Red":
/* 134 */                         Main.red_forge = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "STONE_MINE":
/* 139 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.STONE_MINE.displayname"), Messages.getMsg("forum.STONE_MINE.holo"), v);
/* 140 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 142 */                         Main.blue_stonemine = true;
/* 143 */                         Main.blue_smine = v;
/*     */                         break;
/*     */                       case "Green":
/* 146 */                         Main.green_stonemine = true;
/* 147 */                         Main.green_smine = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 150 */                         Main.yellow_stonemine = true;
/* 151 */                         Main.yellow_smine = v;
/*     */                         break;
/*     */                       case "Red":
/* 154 */                         Main.red_stonemine = true;
/* 155 */                         Main.red_smine = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "GOLD_MINE":
/* 160 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.GOLD_MINE.displayname"), Messages.getMsg("forum.GOLD_MINE.holo"), v);
/* 161 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 163 */                         Main.blue_goldmine = true;
/* 164 */                         Main.blue_gmine = v;
/*     */                         break;
/*     */                       case "Green":
/* 167 */                         Main.green_goldmine = true;
/* 168 */                         Main.green_gmine = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 171 */                         Main.yellow_goldmine = true;
/* 172 */                         Main.yellow_gmine = v;
/*     */                         break;
/*     */                       case "Red":
/* 175 */                         Main.red_goldmine = true;
/* 176 */                         Main.red_gmine = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "SAWMILL":
/* 181 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.SAWMILL.displayname"), Messages.getMsg("forum.SAWMILL.holo"), v);
/* 182 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 184 */                         Main.blue_sawmill = true;
/* 185 */                         Main.blue_vsawmill = v;
/*     */                         break;
/*     */                       case "Green":
/* 188 */                         Main.green_sawmill = true;
/* 189 */                         Main.green_vsawmill = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 192 */                         Main.yellow_sawmill = true;
/* 193 */                         Main.yellow_vsawmill = v;
/*     */                         break;
/*     */                       case "Red":
/* 196 */                         Main.red_sawmill = true;
/* 197 */                         Main.red_vsawmill = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "MILL":
/* 202 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.MILL.displayname"), Messages.getMsg("forum.MILL.holo"), v);
/* 203 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 205 */                         Main.blue_mill = v;
/*     */                         break;
/*     */                       case "Green":
/* 208 */                         Main.green_mill = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 211 */                         Main.yellow_mill = v;
/*     */                         break;
/*     */                       case "Red":
/* 214 */                         Main.red_mill = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "WORKSHOP":
/* 219 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.WORKSHOP.displayname"), Messages.getMsg("forum.WORKSHOP.holo"), v);
/* 220 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 222 */                         Main.blue_workshop = v;
/*     */                         break;
/*     */                       case "Green":
/* 225 */                         Main.green_workshop = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 228 */                         Main.yellow_workshop = v;
/*     */                         break;
/*     */                       case "Red":
/* 231 */                         Main.red_workshop = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "MARKET":
/* 236 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.MARKET.displayname"), Messages.getMsg("forum.MARKET.holo"), v);
/* 237 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 239 */                         Main.blue_market = v;
/*     */                         break;
/*     */                       case "Green":
/* 242 */                         Main.green_market = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 245 */                         Main.yellow_market = v;
/*     */                         break;
/*     */                       case "Red":
/* 248 */                         Main.red_market = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "SABOTAGE_WORKSHOP":
/* 253 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.SABOTAGE_WORKSHOP.displayname"), Messages.getMsg("forum.SABOTAGE_WORKSHOP.holo"), v);
/* 254 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 256 */                         Main.blue_sabotage = v;
/*     */                         break;
/*     */                       case "Green":
/* 259 */                         Main.green_sabotage = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 262 */                         Main.yellow_sabotage = v;
/*     */                         break;
/*     */                       case "Red":
/* 265 */                         Main.red_sabotage = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "KENNEL":
/* 270 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.KENNEL.displayname"), Messages.getMsg("forum.KENNEL.holo"), v);
/* 271 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 273 */                         Main.blue_kennel = v;
/*     */                         break;
/*     */                       case "Green":
/* 276 */                         Main.green_kennel = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 279 */                         Main.yellow_kennel = v;
/*     */                         break;
/*     */                       case "Red":
/* 282 */                         Main.red_kennel = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "ARCHERY_STORE":
/* 287 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.ARCHERY_STORE.displayname"), Messages.getMsg("forum.ARCHERY_STORE.holo"), v);
/* 288 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 290 */                         Main.blue_archery = v;
/*     */                         break;
/*     */                       case "Green":
/* 293 */                         Main.green_archery = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 296 */                         Main.yellow_archery = v;
/*     */                         break;
/*     */                       case "Red":
/* 299 */                         Main.red_archery = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "TRIFARROW":
/* 304 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.TRIFARROW.displayname"), Messages.getMsg("forum.TRIFARROW.holo"), v);
/* 305 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 307 */                         Main.blue_trifarrow = v;
/*     */                         break;
/*     */                       case "Green":
/* 310 */                         Main.green_trifarrow = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 313 */                         Main.yellow_trifarrow = v;
/*     */                         break;
/*     */                       case "Red":
/* 316 */                         Main.red_trifarrow = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "STABLE":
/* 321 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.STABLE.displayname"), Messages.getMsg("forum.STABLE.holo"), v);
/* 322 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 324 */                         Main.blue_stable = v;
/*     */                         break;
/*     */                       case "Green":
/* 327 */                         Main.green_stable = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 330 */                         Main.yellow_stable = v;
/*     */                         break;
/*     */                       case "Red":
/* 333 */                         Main.red_stable = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "ARMORY":
/* 338 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.ARMORY.displayname"), Messages.getMsg("forum.ARMORY.holo"), v);
/* 339 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 341 */                         Main.blue_armory = v;
/*     */                         break;
/*     */                       case "Green":
/* 344 */                         Main.green_armory = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 347 */                         Main.yellow_armory = v;
/*     */                         break;
/*     */                       case "Red":
/* 350 */                         Main.red_armory = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "LABORATORY":
/* 355 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.LABORATORY.displayname"), Messages.getMsg("forum.LABORATORY.holo"), v);
/* 356 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 358 */                         Main.blue_lab = v;
/*     */                         break;
/*     */                       case "Green":
/* 361 */                         Main.green_lab = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 364 */                         Main.yellow_lab = v;
/*     */                         break;
/*     */                       case "Red":
/* 367 */                         Main.red_lab = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "GUILD":
/* 372 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.GUILD.displayname"), Messages.getMsg("forum.GUILD.holo"), v);
/* 373 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 375 */                         Main.blue_guild = v;
/*     */                         break;
/*     */                       case "Green":
/* 378 */                         Main.green_guild = v;
/*     */                         break;
/*     */                       case "Yellow":
/* 381 */                         Main.yellow_guild = v;
/*     */                         break;
/*     */                       case "Red":
/* 384 */                         Main.red_guild = v;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                   case "TRAINING_CENTER":
/* 389 */                     new Hologram(v.getLocation(), Messages.getMsg("forum.TRAINING_CENTER.displayname"), Messages.getMsg("forum.TRAINING_CENTER.holo"), v);
/* 390 */                     switch (BuildSchematic.this.team) {
/*     */                       case "Blue":
/* 392 */                         Main.blue_tcenter = v;
/* 393 */                         Main.blue_xp = true;
/*     */                         break;
/*     */                       case "Green":
/* 396 */                         Main.green_tcenter = v;
/* 397 */                         Main.green_xp = true;
/*     */                         break;
/*     */                       case "Yellow":
/* 400 */                         Main.yellow_tcenter = v;
/* 401 */                         Main.yellow_xp = true;
/*     */                         break;
/*     */                       case "Red":
/* 404 */                         Main.red_tcenter = v;
/* 405 */                         Main.red_xp = true;
/*     */                         break;
/*     */                     } 
/*     */                     break;
/*     */                 } 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           }
/* 414 */         }).runTaskTimer((Plugin)Main.plugin, 0L, 0L);
/*     */     }
/*     */   }
/*     */   
/*     */   public static Schematic loadSchematic(File file) throws IOException {
/* 419 */     FileInputStream stream = new FileInputStream(file);
/* 420 */     NBTInputStream nbtStream = new NBTInputStream(stream);
/*     */     
/* 422 */     CompoundTag schematicTag = (CompoundTag)nbtStream.readTag();
/* 423 */     if (!schematicTag.getName().equals("Schematic")) {
/* 424 */       throw new IllegalArgumentException("Tag \"Schematic\" does not exist or is not first");
/*     */     }
/*     */     
/* 427 */     Map<String, Tag> schematic = schematicTag.getValue();
/* 428 */     if (!schematic.containsKey("Blocks")) {
/* 429 */       throw new IllegalArgumentException("Schematic file is missing a \"Blocks\" tag");
/*     */     }
/*     */     
/* 432 */     short width = ((ShortTag)getChildTag(schematic, "Width", ShortTag.class)).getValue().shortValue();
/* 433 */     short length = ((ShortTag)getChildTag(schematic, "Length", ShortTag.class)).getValue().shortValue();
/* 434 */     short height = ((ShortTag)getChildTag(schematic, "Height", ShortTag.class)).getValue().shortValue();
/*     */     
/* 436 */     byte[] blockId = ((ByteArrayTag)getChildTag(schematic, "Blocks", ByteArrayTag.class)).getValue();
/* 437 */     byte[] blockData = ((ByteArrayTag)getChildTag(schematic, "Data", ByteArrayTag.class)).getValue();
/* 438 */     byte[] addId = new byte[0];
/* 439 */     short[] blocks = new short[blockId.length];
/*     */     
/* 441 */     if (schematic.containsKey("AddBlocks")) {
/* 442 */       addId = ((ByteArrayTag)getChildTag(schematic, "AddBlocks", ByteArrayTag.class)).getValue();
/*     */     }
/*     */     
/* 445 */     for (int index = 0; index < blockId.length; index++) {
/* 446 */       if (index >> 1 >= addId.length) {
/* 447 */         blocks[index] = (short)(blockId[index] & 0xFF);
/*     */       }
/* 449 */       else if ((index & 0x1) == 0) {
/* 450 */         blocks[index] = (short)(((addId[index >> 1] & 0xF) << 8) + (blockId[index] & 0xFF));
/*     */       } else {
/* 452 */         blocks[index] = (short)(((addId[index >> 1] & 0xF0) << 4) + (blockId[index] & 0xFF));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 457 */     return new Schematic(blocks, blockData, width, length, height);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T extends Tag> T getChildTag(Map<String, Tag> items, String key, Class<T> expected) throws IllegalArgumentException {
/* 462 */     if (!items.containsKey(key)) {
/* 463 */       throw new IllegalArgumentException("Schematic file is missing a \"" + key + "\" tag");
/*     */     }
/* 465 */     Tag tag = items.get(key);
/* 466 */     if (!expected.isInstance(tag)) {
/* 467 */       throw new IllegalArgumentException(key + " tag is not of tag type " + expected.getName());
/*     */     }
/* 469 */     return expected.cast(tag);
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\game\BuildSchematic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */