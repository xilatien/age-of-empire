/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Arrow;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Projectile;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityShootBowEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class EntityShootBowListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void s(EntityShootBowEvent e) {
/* 18 */     if (e.getProjectile() instanceof Arrow) {
/* 19 */       Player p; Vector v = e.getProjectile().getVelocity();
/*    */       
/* 21 */       if (e.getEntity() instanceof Player) {
/* 22 */         p = (Player)e.getEntity();
/*    */       } else {
/*    */         return;
/*    */       } 
/* 26 */       e.setCancelled(true);
/* 27 */       for (ItemStack i : p.getInventory().getContents()) {
/* 28 */         if (i != null && 
/* 29 */           i.hasItemMeta() && 
/* 30 */           i.getItemMeta().hasDisplayName())
/* 31 */           if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cExplosive")) {
/* 32 */             if (i.getAmount() > 1) {
/* 33 */               i.setAmount(i.getAmount() - 1);
/*    */             } else {
/* 35 */               i.setType(Material.AIR);
/*    */             } 
/* 37 */             Projectile proj = p.launchProjectile(Arrow.class, v);
/* 38 */             proj.setCustomName("§cExplosive");
/*    */           } else {
/* 40 */             p.launchProjectile(Arrow.class, v);
/*    */           }  
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\EntityShootBowListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */