/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
/*    */ 
/*    */ public class PlayerArmorStandManipulateListener
/*    */   implements Listener {
/*    */   @EventHandler
/*    */   public void manipulate(PlayerArmorStandManipulateEvent e) {
/* 11 */     if (!e.getRightClicked().isVisible())
/*    */     {
/* 13 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerArmorStandManipulateListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */