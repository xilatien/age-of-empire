/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.server.ServerListPingEvent;
/*    */ 
/*    */ public class ServerPingListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void ping(ServerListPingEvent e) {
/* 15 */     if (Main.SETUP) {
/* 16 */       e.setMotd("§cMAINTENANCE");
/*    */       return;
/*    */     } 
/* 19 */     if (Main.STATUS == Status.STARTING) {
/* 20 */       e.setMotd(Messages.getMsg("motd.starting"));
/* 21 */     } else if (Main.STATUS == Status.LOBBY) {
/* 22 */       e.setMotd(Messages.getMsg("motd.lobby"));
/* 23 */     } else if (Main.STATUS == Status.PLAYING || Main.STATUS == Status.PRE_GAME) {
/* 24 */       e.setMotd(Messages.getMsg("motd.playing"));
/* 25 */     } else if (Main.STATUS == Status.RESTARTING) {
/* 26 */       e.setMotd(Messages.getMsg("motd.restarting"));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\ServerPingListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */