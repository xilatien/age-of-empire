/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import org.bukkit.entity.Arrow;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.ProjectileHitEvent;
/*    */ 
/*    */ public class ProjectileHitListener
/*    */   implements Listener {
/*    */   @EventHandler
/*    */   public void e(ProjectileHitEvent e) {
/* 12 */     if (e.getEntity() instanceof Arrow) {
/* 13 */       Arrow a = (Arrow)e.getEntity();
/* 14 */       if (a.getCustomName() != null && a.getCustomName().equalsIgnoreCase("§cExplosive"))
/* 15 */         e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 0.0F, false); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\ProjectileHitListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */