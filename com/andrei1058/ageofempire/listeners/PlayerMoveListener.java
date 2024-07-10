/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.commands.Stuck;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import com.andrei1058.ageofempire.locations.Locations;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ 
/*    */ 
/*    */ public class PlayerMoveListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void m(PlayerMoveEvent e) {
/* 18 */     if (Main.SETUP)
/* 19 */       return;  if (Main.STATUS != Status.PLAYING) {
/* 20 */       if (e.getPlayer().getLocation().getY() < 0.0D) {
/* 21 */         e.getPlayer().teleport(Locations.getLoc("Spawns.Lobby"));
/*    */       }
/*    */     }
/* 24 */     else if (Stuck.stuck.containsKey(e.getPlayer())) {
/* 25 */       Stuck.stuck.remove(e.getPlayer());
/* 26 */       e.getPlayer().sendMessage(Messages.getMsg("stuckMove"));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerMoveListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */