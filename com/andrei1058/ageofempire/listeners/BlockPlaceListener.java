/*    */ package com.andrei1058.ageofempire.listeners;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.andrei1058.ageofempire.game.Buildings;
/*    */ import com.andrei1058.ageofempire.game.Status;
/*    */ import com.andrei1058.ageofempire.locations.Region;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ 
/*    */ public class BlockPlaceListener
/*    */   implements Listener {
/*    */   @EventHandler
/*    */   public void b(BlockPlaceEvent e) {
/* 17 */     if (Main.SETUP)
/* 18 */       return;  if (Main.STATUS == Status.PLAYING) {
/* 19 */       switch (e.getBlock().getType()) {
/*    */         case SPRUCE_DOOR:
/* 21 */           if (Buildings.construct_in_inv.containsKey(e.getPlayer())) {
/* 22 */             Region.check(e.getBlock().getLocation(), e.getPlayer());
/*    */           }
/* 24 */           e.setCancelled(true);
/*    */           return;
/*    */         case GRASS:
/*    */         case DIRT:
/*    */         case WOOD_DOUBLE_STEP:
/*    */         case SAND:
/*    */         case GRAVEL:
/*    */         case SPONGE:
/*    */         case GLASS:
/*    */         case LAPIS_BLOCK:
/*    */         case WOOL:
/*    */         case BRICK:
/*    */         case MOSSY_COBBLESTONE:
/*    */         case LEAVES:
/*    */         case LEAVES_2:
/*    */         case WEB:
/*    */         case TORCH:
/* 41 */           if (Region.place(e.getBlock().getLocation())) {
/* 42 */             Main.placedBlocks.add(e.getBlock());
/*    */           } else {
/* 44 */             e.setCancelled(true);
/* 45 */             e.getPlayer().sendMessage(Messages.getMsg("cant-place-here"));
/*    */           } 
/*    */           return;
/*    */         case FLINT_AND_STEEL:
/* 49 */           if (Region.place(e.getBlock().getLocation())) {
/* 50 */             e.setCancelled(false);
/*    */           } else {
/* 52 */             e.setCancelled(true);
/* 53 */             e.getPlayer().sendMessage(Messages.getMsg("cant-place-here"));
/*    */           } 
/*    */           return;
/*    */       } 
/* 57 */       e.setCancelled(true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\listeners\BlockPlaceListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */