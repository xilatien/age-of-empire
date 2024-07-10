/*    */ package com.andrei1058.ageofempire.runnables;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Settings;
/*    */ import com.google.common.io.ByteArrayDataOutput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class Restart
/*    */   extends BukkitRunnable {
/*    */   public void run() {
/* 16 */     if (Main.restart_time != 0) {
/* 17 */       Main.restart_time--;
/*    */     }
/* 19 */     if (Main.restart_time == 3) {
/* 20 */       for (Player p : Bukkit.getOnlinePlayers()) {
/* 21 */         ByteArrayDataOutput out = ByteStreams.newDataOutput();
/* 22 */         out.writeUTF("Connect");
/* 23 */         out.writeUTF(Settings.load().getString("lobby-server"));
/* 24 */         p.sendPluginMessage((Plugin)Main.plugin, "BungeeCord", out.toByteArray());
/*    */       } 
/*    */     }
/* 27 */     if (Main.restart_time == 0) {
/* 28 */       cancel();
/* 29 */       Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), Settings.load().getString("restart-cmd"));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\runnables\Restart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */