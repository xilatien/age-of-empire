/*    */ package com.andrei1058.ageofempire.commands;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Settings;
/*    */ import com.google.common.io.ByteArrayDataOutput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class Leave
/*    */   implements CommandExecutor {
/*    */   public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
/* 16 */     if (!(s instanceof Player)) return true; 
/* 17 */     Player p = (Player)s;
/* 18 */     if (c.getName().equalsIgnoreCase("leave")) {
/* 19 */       ByteArrayDataOutput out = ByteStreams.newDataOutput();
/* 20 */       out.writeUTF("Connect");
/* 21 */       out.writeUTF(Settings.load().getString("lobby-server"));
/* 22 */       p.sendPluginMessage((Plugin)Main.plugin, "BungeeCord", out.toByteArray());
/*    */     } 
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\commands\Leave.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */