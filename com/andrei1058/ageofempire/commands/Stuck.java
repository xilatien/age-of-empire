/*    */ package com.andrei1058.ageofempire.commands;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class Stuck
/*    */   implements CommandExecutor
/*    */ {
/* 16 */   public static HashMap<Player, Long> stuck = new HashMap<>();
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender s, Command c, String st, String[] args) {
/* 20 */     if (c.getName().equalsIgnoreCase("stuck")) {
/* 21 */       if (Main.STATUS != Status.PLAYING) {
/* 22 */         s.sendMessage(Messages.getMsg("notInGame"));
/* 23 */         return true;
/*    */       } 
/* 25 */       if (s instanceof Player) {
/* 26 */         Player p = (Player)s;
/* 27 */         if (!stuck.containsKey(p)) {
/* 28 */           stuck.put(p, Long.valueOf(System.currentTimeMillis()));
/* 29 */           p.sendMessage(Messages.getMsg("stuckTp"));
/*    */         } 
/*    */       } 
/*    */     } 
/* 33 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\commands\Stuck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */