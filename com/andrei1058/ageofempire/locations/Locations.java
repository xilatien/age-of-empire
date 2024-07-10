/*    */ package com.andrei1058.ageofempire.locations;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ public class Locations
/*    */ {
/* 12 */   private static File file = new File("plugins/Age-Of-Empire/locations.yml");
/* 13 */   private static YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
/*    */   
/*    */   public static void saveLoc(Location location, String ymlData) {
/* 16 */     if (file.exists()) {
/* 17 */       yml.set(ymlData + ".World", location.getWorld().getName());
/* 18 */       yml.set(ymlData + ".X", Double.valueOf(location.getX()));
/* 19 */       yml.set(ymlData + ".Y", Double.valueOf(location.getY()));
/* 20 */       yml.set(ymlData + ".Z", Double.valueOf(location.getZ()));
/* 21 */       yml.set(ymlData + ".Yaw", Float.valueOf(location.getYaw()));
/* 22 */       yml.set(ymlData + ".Pitch", Float.valueOf(location.getPitch()));
/*    */       try {
/* 24 */         yml.save(file);
/* 25 */       } catch (IOException e) {
/* 26 */         e.printStackTrace();
/*    */       } 
/*    */     } else {
/*    */       try {
/* 30 */         file.createNewFile();
/* 31 */       } catch (IOException e) {
/* 32 */         e.printStackTrace();
/*    */       } 
/* 34 */       yml.set(ymlData + ".World", location.getWorld().getName());
/* 35 */       yml.set(ymlData + ".X", Double.valueOf(location.getX()));
/* 36 */       yml.set(ymlData + ".Y", Double.valueOf(location.getY()));
/* 37 */       yml.set(ymlData + ".Z", Double.valueOf(location.getZ()));
/* 38 */       yml.set(ymlData + ".Yaw", Float.valueOf(location.getYaw()));
/* 39 */       yml.set(ymlData + ".Pitch", Float.valueOf(location.getPitch()));
/*    */       try {
/* 41 */         yml.save(file);
/* 42 */       } catch (IOException e) {
/* 43 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Location getLoc(String ymlData) {
/* 49 */     return new Location(Bukkit.getWorld(yml.getString(ymlData + ".World")), yml.getDouble(ymlData + ".X"), yml.getDouble(ymlData + ".Y"), yml
/* 50 */         .getDouble(ymlData + ".Z"), (float)yml.getDouble(ymlData + ".Yaw"), (float)yml.getDouble(ymlData + ".Pitch"));
/*    */   }
/*    */   
/*    */   public static void savePlot(String ymlData, Location pos1, Location middle, Location pos2) {
/* 54 */     yml.set(ymlData + ".Mid.X", Integer.valueOf(middle.getBlockX()));
/* 55 */     yml.set(ymlData + ".Mid.Y", Integer.valueOf(middle.getBlockY()));
/* 56 */     yml.set(ymlData + ".Mid.Z", Integer.valueOf(middle.getBlockZ()));
/*    */     
/* 58 */     yml.set(ymlData + ".Pos1.X", Integer.valueOf(pos1.getBlockX()));
/* 59 */     yml.set(ymlData + ".Pos1.Y", Integer.valueOf(pos1.getBlockY()));
/* 60 */     yml.set(ymlData + ".Pos1.Z", Integer.valueOf(pos1.getBlockZ()));
/*    */     
/* 62 */     yml.set(ymlData + ".Pos2.X", Integer.valueOf(pos2.getBlockX()));
/* 63 */     yml.set(ymlData + ".Pos2.Y", Integer.valueOf(pos2.getBlockY()));
/* 64 */     yml.set(ymlData + ".Pos2.Z", Integer.valueOf(pos2.getBlockZ()));
/*    */   }
/*    */   
/*    */   public static YamlConfiguration load() {
/* 68 */     return yml;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\locations\Locations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */