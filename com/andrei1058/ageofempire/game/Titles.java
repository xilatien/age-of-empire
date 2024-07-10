/*    */ package com.andrei1058.ageofempire.game;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Titles
/*    */ {
/*    */   @Deprecated
/*    */   public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message) {
/* 11 */     sendTitle(player, fadeIn, stay, fadeOut, message, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendSubtitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message) {
/* 16 */     sendTitle(player, fadeIn, stay, fadeOut, null, message);
/*    */   }
/*    */   
/*    */   public static void sendFullTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
/* 20 */     sendTitle(player, fadeIn, stay, fadeOut, title, subtitle);
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public static Integer getPlayerProtocol(Player player) {
/* 26 */     return Integer.valueOf(47);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendPacket(Player player, Object packet) {
/*    */     try {
/* 33 */       Object handle = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
/* 34 */       Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
/* 35 */       playerConnection.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnection, new Object[] { packet });
/*    */     }
/* 37 */     catch (Exception e) {
/*    */       
/* 39 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static Class<?> getNMSClass(String name) {
/* 45 */     String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
/*    */     
/*    */     try {
/* 48 */       return Class.forName("net.minecraft.server." + version + "." + name);
/*    */     }
/* 50 */     catch (ClassNotFoundException e) {
/*    */       
/* 52 */       e.printStackTrace();
/*    */       
/* 54 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
/*    */     try {
/* 61 */       if (title != null) {
/*    */         
/* 63 */         Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
/* 64 */         Object chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + title + "\"}" });
/* 65 */         Constructor<?> titleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
/* 66 */         Object titlePacket = titleConstructor.newInstance(new Object[] { enumTitle, chatTitle, fadeIn, stay, fadeOut });
/* 67 */         sendPacket(player, titlePacket);
/*    */       } 
/* 69 */       if (subtitle != null)
/*    */       {
/* 71 */         Object enumSubtitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
/* 72 */         Object chatSubtitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + subtitle + "\"}" });
/* 73 */         Constructor<?> subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
/* 74 */         Object subtitlePacket = subtitleConstructor.newInstance(new Object[] { enumSubtitle, chatSubtitle, fadeIn, stay, fadeOut });
/* 75 */         sendPacket(player, subtitlePacket);
/*    */       }
/*    */     
/* 78 */     } catch (Exception e) {
/*    */       
/* 80 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\game\Titles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */