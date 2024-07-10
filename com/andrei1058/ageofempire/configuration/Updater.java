/*    */ package com.andrei1058.ageofempire.configuration;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class Updater
/*    */ {
/*    */   public static boolean updateAvailable = false;
/* 15 */   public static String newVersion = "";
/*    */   
/*    */   public static void checkUpdates() {
/* 18 */     Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> {
/*    */           try {
/*    */             HttpURLConnection checkUpdate = (HttpURLConnection)(new URL("https://api.spigotmc.org/legacy/update.php?resource=39573")).openConnection();
/*    */             
/*    */             checkUpdate.setDoOutput(true);
/*    */             String old = Main.plugin.getDescription().getVersion();
/*    */             String newV = (new BufferedReader(new InputStreamReader(checkUpdate.getInputStream()))).readLine();
/*    */             if (!newV.equalsIgnoreCase(old)) {
/*    */               updateAvailable = true;
/*    */               newVersion = newV;
/*    */               Main.plugin.getLogger().info("------------------------------------");
/*    */               Main.plugin.getLogger().info(" ");
/*    */               Main.plugin.getLogger().info("There is a new version available!");
/*    */               Main.plugin.getLogger().info("Version: " + newVersion);
/*    */               Main.plugin.getLogger().info(" ");
/*    */               Main.plugin.getLogger().info("https://www.spigotmc.org/resources/39573/");
/*    */               Main.plugin.getLogger().info("------------------------------------");
/*    */             } 
/* 36 */           } catch (IOException e) {
/*    */             e.printStackTrace();
/*    */           } 
/*    */         }30L);
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\configuration\Updater.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */