/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerPickupItemEvent;
/*    */ 
/*    */ 
/*    */ public class ItemPickUpListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void p(PlayerPickupItemEvent e) {
/* 15 */     if (Main.SETUP)
/* 16 */       return;  if (Main.STATUS != Status.PLAYING)
/* 17 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\ItemPickUpListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */