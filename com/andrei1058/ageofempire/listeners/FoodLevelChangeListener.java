/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.FoodLevelChangeEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FoodLevelChangeListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void f(FoodLevelChangeEvent e) {
/* 17 */     if (Main.STATUS != Status.PLAYING)
/* 18 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\FoodLevelChangeListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */