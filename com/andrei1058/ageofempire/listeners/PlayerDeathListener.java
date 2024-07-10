/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.ListIterator;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Projectile;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class PlayerDeathListener
/*    */   implements Listener
/*    */ {
/* 21 */   public static ArrayList<Player> constructor = new ArrayList<>();
/*    */   @EventHandler
/*    */   public void d(PlayerDeathEvent e) {
/* 24 */     if (Main.SETUP)
/* 25 */       return;  Player p = e.getEntity();
/* 26 */     List<ItemStack> drops = e.getDrops();
/* 27 */     ListIterator<ItemStack> litr = drops.listIterator();
/* 28 */     while (litr.hasNext()) {
/* 29 */       ItemStack stack = litr.next();
/* 30 */       if (stack.getType() == Material.SPRUCE_DOOR_ITEM) {
/* 31 */         constructor.add(p);
/*    */       }
/* 33 */       if (stack.getType().equals(Material.PAPER) || stack.getType().equals(Material.MOB_SPAWNER) || stack
/* 34 */         .getType() == Material.STONE_AXE || stack.getType() == Material.STONE_PICKAXE || stack
/* 35 */         .getType() == Material.LEATHER_BOOTS || stack.getType() == Material.LEATHER_CHESTPLATE || stack
/* 36 */         .getType() == Material.LEATHER_HELMET || stack.getType() == Material.LEATHER_LEGGINGS || stack
/* 37 */         .getType() == Material.SPRUCE_DOOR_ITEM) {
/* 38 */         litr.remove();
/*    */       }
/*    */     } 
/* 41 */     if (e.getEntity().getKiller() instanceof Player) {
/* 42 */       e.setDeathMessage(Messages.getMsg("new-kill").replace("{player}", e.getEntity().getName()).replace("{killer}", e.getEntity().getKiller().getName()));
/* 43 */       Main.addKill(e.getEntity().getKiller());
/* 44 */       Main.addDeath(e.getEntity());
/* 45 */     } else if (e.getEntity().getKiller() instanceof Projectile) {
/* 46 */       Projectile proj = (Projectile)e.getEntity().getKiller();
/* 47 */       Player pl = (Player)proj.getShooter();
/* 48 */       e.setDeathMessage(Messages.getMsg("new-kill").replace("{player}", e.getEntity().getName()).replace("{killer}", pl.getName()));
/* 49 */       Main.addKill(pl);
/* 50 */       Main.addDeath(e.getEntity());
/*    */     } else {
/* 52 */       Main.addDeath(e.getEntity());
/* 53 */       e.setDeathMessage(Messages.getMsg("player-died").replace("{player}", e.getEntity().getDisplayName()));
/*    */     } 
/* 55 */     Bukkit.getScheduler().runTaskLater((Plugin)Main.plugin, () -> p.spigot().respawn(), 2L);
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\PlayerDeathListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */