/*    */ package com.andrei1058.ageofempire.commands;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ 
/*    */ 
/*    */ public class Start
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String st, String[] args) {
/* 16 */     if (c.getName().equalsIgnoreCase("start")) {
/* 17 */       if (s.hasPermission("aoe.start") || s.hasPermission("aoe.forcestart") || s.hasPermission("aoe.*")) {
/* 18 */         if (Main.STATUS == Status.STARTING && 
/* 19 */           Bukkit.getOnlinePlayers().size() > 1) {
/* 20 */           Main.lobby_time = 10;
/* 21 */           return true;
/*    */         } 
/*    */         
/* 24 */         s.sendMessage(Messages.getMsg("cantDoNow"));
/*    */       } else {
/* 26 */         s.sendMessage(Messages.getMsg("cantDo"));
/*    */       } 
/*    */     }
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\commands\Start.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */