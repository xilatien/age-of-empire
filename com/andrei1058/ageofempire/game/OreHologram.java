/*    */ package com.andrei1058.ageofempire.game;
/*    */ 
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.entity.ArmorStand;
/*    */ import org.bukkit.entity.EntityType;
/*    */ 
/*    */ 
/*    */ public class OreHologram
/*    */ {
/* 12 */   private static ArrayList<OreHologram> holos = new ArrayList<>();
/* 13 */   private final String txt = Messages.getMsg("holo.gold");
/* 14 */   private final String txt2 = Messages.getMsg("holo.stone");
/* 15 */   private final String txt3 = Messages.getMsg("holo.wood");
/*    */   
/*    */   private long time;
/*    */   
/*    */   public OreHologram(Location loc, Integer amount, boolean stone) {
/* 20 */     if (stone) {
/* 21 */       if (amount.intValue() != 0) {
/* 22 */         this.as = (ArmorStand)loc.getWorld().spawnEntity(loc.getBlock().getLocation().clone().add(0.0D, 1.2D, 0.0D), EntityType.ARMOR_STAND);
/* 23 */         this.as.setVisible(false);
/* 24 */         this.as.setGravity(false);
/* 25 */         this.as.setCanPickupItems(false);
/* 26 */         this.as.setCustomName(this.txt.replace("{amount}", String.valueOf(amount)));
/* 27 */         this.as.setCustomNameVisible(true);
/* 28 */         this.as.setSmall(true);
/* 29 */         this.as.setMarker(true);
/*    */       } 
/*    */       
/* 32 */       this.as2 = (ArmorStand)loc.getWorld().spawnEntity(loc.getBlock().getLocation().add(0.0D, 0.9D, 0.0D), EntityType.ARMOR_STAND);
/* 33 */       this.as2.setVisible(false);
/* 34 */       this.as2.setGravity(false);
/* 35 */       this.as2.setCanPickupItems(false);
/* 36 */       this.as2.setCustomName(this.txt2.replace("{amount}", String.valueOf(amount)));
/* 37 */       this.as2.setCustomNameVisible(true);
/* 38 */       this.as2.setSmall(true);
/* 39 */       this.as2.setMarker(true);
/* 40 */       holos.add(this);
/*    */     } else {
/* 42 */       if (amount.intValue() != 0) {
/* 43 */         this.as = (ArmorStand)loc.getWorld().spawnEntity(loc.getBlock().getLocation().clone().add(0.0D, 1.2D, 0.0D), EntityType.ARMOR_STAND);
/* 44 */         this.as.setVisible(false);
/* 45 */         this.as.setGravity(false);
/* 46 */         this.as.setCanPickupItems(false);
/* 47 */         this.as.setCustomName(this.txt.replace("{amount}", String.valueOf(amount)));
/* 48 */         this.as.setCustomNameVisible(true);
/* 49 */         this.as.setSmall(true);
/* 50 */         this.as.setMarker(true);
/*    */       } 
/* 52 */       this.as2 = (ArmorStand)loc.getWorld().spawnEntity(loc.getBlock().getLocation().add(0.0D, 1.2D, 0.0D), EntityType.ARMOR_STAND);
/* 53 */       this.as2.setVisible(false);
/* 54 */       this.as2.setGravity(false);
/* 55 */       this.as2.setCanPickupItems(false);
/* 56 */       this.as2.setCustomName(this.txt3.replace("{amount}", String.valueOf(amount)));
/* 57 */       this.as2.setCustomNameVisible(true);
/* 58 */       this.as2.setSmall(true);
/* 59 */       this.as2.setMarker(true);
/* 60 */       holos.add(this);
/*    */     } 
/* 62 */     this.time = System.currentTimeMillis();
/*    */   }
/*    */   ArmorStand as; ArmorStand as2;
/*    */   public void remove() {
/* 66 */     if (System.currentTimeMillis() - this.time >= 800L) {
/* 67 */       if (this.as != null) {
/* 68 */         this.as.remove();
/*    */       }
/* 70 */       this.as2.remove();
/* 71 */       holos.remove(this);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static ArrayList<OreHologram> list() {
/* 76 */     return holos;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\game\OreHologram.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */