/*    */ package com.andrei1058.ageofempire.game;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.entity.ArmorStand;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Villager;
/*    */ 
/*    */ 
/*    */ public class Hologram
/*    */ {
/* 13 */   private static ArrayList<Hologram> holograms = new ArrayList<>();
/* 14 */   private static HashMap<Villager, Hologram> hash = new HashMap<>();
/*    */   ArmorStand as;
/*    */   ArmorStand as2;
/*    */   public boolean shown = false;
/*    */   
/*    */   public Hologram(Location location2, String text, String text2, Villager villager) {
/* 20 */     ArmorStand as = (ArmorStand)location2.getWorld().spawnEntity(location2.clone().add(0.0D, 2.7D, 0.0D), EntityType.ARMOR_STAND);
/* 21 */     as.setGravity(false);
/* 22 */     as.setCanPickupItems(false);
/* 23 */     as.setCustomName(text);
/* 24 */     as.setCustomNameVisible(true);
/* 25 */     as.setVisible(false);
/* 26 */     as.setSmall(true);
/* 27 */     as.setMarker(true);
/* 28 */     this.as = as;
/*    */     
/* 30 */     ArmorStand as2 = (ArmorStand)location2.getWorld().spawnEntity(location2.clone().add(0.0D, 2.4D, 0.0D), EntityType.ARMOR_STAND);
/* 31 */     as2.setGravity(false);
/* 32 */     as2.setCanPickupItems(false);
/* 33 */     as2.setCustomName(text2);
/* 34 */     as2.setCustomNameVisible(true);
/* 35 */     as2.setVisible(false);
/* 36 */     as2.setMarker(true);
/* 37 */     this.as2 = as2;
/*    */     
/* 39 */     holograms.add(this);
/* 40 */     hash.put(villager, this);
/*    */   }
/*    */   
/*    */   public void remove() {
/* 44 */     this.as.remove();
/* 45 */     this.as2.remove();
/*    */   }
/*    */   
/*    */   public void hide() {
/* 49 */     this.as.setCustomNameVisible(false);
/* 50 */     this.as2.setCustomNameVisible(false);
/*    */   }
/*    */   
/*    */   public void show() {
/* 54 */     this.as.setCustomNameVisible(true);
/* 55 */     this.as2.setCustomNameVisible(true);
/*    */   }
/*    */   
/*    */   public void stuff() {
/* 59 */     if (this.shown) {
/* 60 */       hide();
/* 61 */       this.shown = false;
/*    */     } else {
/* 63 */       show();
/* 64 */       this.shown = true;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static ArrayList<Hologram> list() {
/* 69 */     return holograms;
/*    */   }
/*    */   
/*    */   public static Hologram get(Villager villager) {
/* 73 */     return hash.get(villager);
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\game\Hologram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */