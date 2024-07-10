/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import com.andrei1058.ageofempire.locations.Locations;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*    */ 
/*    */ public class CreatureSpawnListener
/*    */   implements Listener {
/*    */   public void s(CreatureSpawnEvent e) {
/* 12 */     if (Main.STATUS != Status.PLAYING) {
/*    */       return;
/*    */     }
/* 15 */     if (e.getLocation().getWorld().equals(Locations.getLoc("Spawns.Lobby").getWorld()))
/* 16 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\CreatureSpawnListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */