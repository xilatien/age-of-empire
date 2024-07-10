/*    */ package com.andrei1058.ageofempire.nms.v1_8_R2;
/*    */ 
/*    */ import com.andrei1058.ageofempire.nms.NMS;
/*    */ import net.minecraft.server.v1_8_R2.EntityVillager;
/*    */ import net.minecraft.server.v1_8_R2.IChatBaseComponent;
/*    */ import net.minecraft.server.v1_8_R2.Packet;
/*    */ import net.minecraft.server.v1_8_R2.PacketPlayOutChat;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Villager;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main
/*    */   implements NMS
/*    */ {
/*    */   public void registerVillagers() {
/* 22 */     RegisterNMS.registerEntity("Villager", 120, EntityVillager.class, VillagerNMS.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void actionMsg(Player p, String message) {
/* 27 */     CraftPlayer cPlayer = (CraftPlayer)p;
/* 28 */     String string = ChatColor.translateAlternateColorCodes('&', message);
/* 29 */     IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + string + "\"}");
/* 30 */     PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte)2);
/* 31 */     (cPlayer.getHandle()).playerConnection.sendPacket((Packet)ppoc);
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound witherDeath() {
/* 36 */     return Sound.valueOf("WITHER_DEATH");
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound levelUp() {
/* 41 */     return Sound.valueOf("LEVEL_UP");
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound wolfDeath() {
/* 46 */     return Sound.valueOf("WOLF_DEATH");
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound click() {
/* 51 */     return Sound.valueOf("CLICK");
/*    */   }
/*    */ 
/*    */   
/*    */   public Villager spawnVillager(Location loc, Integer health) {
/* 56 */     return VillagerNMS.spawnVillager(loc, health);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack itemInHand(Player p) {
/* 61 */     return p.getInventory().getItemInHand();
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\nms\v1_8_R2\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */