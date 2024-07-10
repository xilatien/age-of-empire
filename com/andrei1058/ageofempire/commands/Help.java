/*    */ package com.andrei1058.ageofempire.commands;
/*    */ 
/*    */ import com.andrei1058.ageofempire.Main;
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class Help
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender s, Command c, String st, String[] args) {
/* 18 */     if (c.getName().equalsIgnoreCase("help")) {
/* 19 */       Player p = (Player)s;
/* 20 */       if (Main.help.contains(p)) {
/* 21 */         Main.help.remove(p);
/* 22 */         p.sendMessage(Main.PREFIX + " " + Messages.getMsg("help-item-off"));
/* 23 */         ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
/* 24 */         ItemMeta itemMeta = i.getItemMeta();
/* 25 */         itemMeta.setDisplayName(Messages.getMsg("help-item-off"));
/* 26 */         i.setItemMeta(itemMeta);
/* 27 */         p.getInventory().setItem(4, i);
/*    */       } else {
/* 29 */         Main.help.add(p);
/* 30 */         p.sendMessage(Main.PREFIX + " " + Messages.getMsg("help-item-on"));
/* 31 */         ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
/* 32 */         ItemMeta itemMeta = i.getItemMeta();
/* 33 */         itemMeta.setDisplayName(Messages.getMsg("help-item-on"));
/* 34 */         i.setItemMeta(itemMeta);
/* 35 */         p.getInventory().setItem(4, i);
/*    */       } 
/*    */     } 
/* 38 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\commands\Help.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */