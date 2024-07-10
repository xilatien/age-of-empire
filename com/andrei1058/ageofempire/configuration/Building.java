/*    */ package com.andrei1058.ageofempire.configuration;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ public class Building
/*    */ {
/*    */   public static void save(String filename, List<Block> blocks) {
/* 14 */     ArrayList<String> strings = new ArrayList<>();
/* 15 */     for (Block b : blocks) {
/* 16 */       if (b.getType() != Material.AIR) {
/* 17 */         strings.add(b.getLocation().getX() + "," + b.getLocation().getY() + "," + b.getLocation().getZ() + "," + b.getType() + "," + b.getData());
/*    */       }
/*    */     } 
/* 20 */     File file = new File("plugins/Age-Of-Empire/buildings/" + filename + ".yml");
/* 21 */     YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
/* 22 */     if (!file.exists()) {
/*    */       try {
/* 24 */         file.createNewFile();
/* 25 */       } catch (IOException e) {
/* 26 */         e.printStackTrace();
/*    */       } 
/*    */     }
/* 29 */     yml.set("Blocks", strings);
/*    */     try {
/* 31 */       yml.save(file);
/* 32 */     } catch (IOException e) {
/* 33 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static ArrayList<String> load(String filename) {
/* 38 */     File file = new File("plugins/Age-Of-Empire/buildings/" + filename + ".yml");
/* 39 */     YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
/* 40 */     return (ArrayList<String>)yml.getStringList("Block");
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\configuration\Building.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */