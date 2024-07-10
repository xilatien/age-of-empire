/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.Misc;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.game.BuildSchematic;
/*    */ import com.andrei1058.ageofempire.game.Buildings;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerDropItemEvent;
/*    */ 
/*    */ 
/*    */ public class ItemDropListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void d(PlayerDropItemEvent e) {
/* 21 */     if (Main.SETUP)
/* 22 */       return;  if (Main.STATUS != Status.PLAYING) {
/* 23 */       e.setCancelled(true);
/*    */     }
/* 25 */     if (e.getItemDrop().getItemStack().getType() == Material.SPRUCE_DOOR_ITEM && 
/* 26 */       Buildings.construct_in_inv.containsKey(e.getPlayer())) {
/* 27 */       e.setCancelled(true);
/* 28 */       e.getItemDrop().remove();
/* 29 */       e.getPlayer().getInventory().setItem(7, Misc.slotlocked());
/* 30 */       if (Main.bluePlayers.contains(e.getPlayer())) {
/* 31 */         for (Player u : Main.bluePlayers) {
/* 32 */           u.sendMessage(Messages.getMsg("build-canceled").replace("{player}", e.getPlayer().getName()).replace("{building}", (BuildSchematic.getPlayer(e.getPlayer())).chat_build_name));
/*    */         }
/* 34 */       } else if (Main.greenPlayers.contains(e.getPlayer())) {
/* 35 */         for (Player u : Main.greenPlayers) {
/* 36 */           u.sendMessage(Messages.getMsg("build-canceled").replace("{player}", e.getPlayer().getName()).replace("{building}", (BuildSchematic.getPlayer(e.getPlayer())).chat_build_name));
/*    */         }
/* 38 */       } else if (Main.yellowPlayers.contains(e.getPlayer())) {
/* 39 */         for (Player u : Main.yellowPlayers) {
/* 40 */           u.sendMessage(Messages.getMsg("build-canceled").replace("{player}", e.getPlayer().getName()).replace("{building}", (BuildSchematic.getPlayer(e.getPlayer())).chat_build_name));
/*    */         }
/* 42 */       } else if (Main.redPlayers.contains(e.getPlayer())) {
/* 43 */         for (Player u : Main.redPlayers) {
/* 44 */           u.sendMessage(Messages.getMsg("build-canceled").replace("{player}", e.getPlayer().getName()).replace("{building}", (BuildSchematic.getPlayer(e.getPlayer())).chat_build_name));
/*    */         }
/*    */       } 
/* 47 */       Buildings.construct_in_inv.remove(e.getPlayer());
/* 48 */       BuildSchematic.getPlayer(e.getPlayer()).end();
/* 49 */       e.getItemDrop().remove();
/*    */     } 
/*    */     
/* 52 */     if (e.getItemDrop().getItemStack().getType() == Material.MOB_SPAWNER) {
/* 53 */       e.setCancelled(true);
/*    */     }
/* 55 */     if (e.getItemDrop().getItemStack().getType() == Material.PAPER)
/* 56 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\ItemDropListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */