/*    */ package com.andrei1058.ageofempire.nms.v1_8_R1;
/*    */ 
/*    */ import com.andrei1058.ageofempire.nms.NMS;
/*    */ import net.minecraft.server.v1_8_R1.ChatSerializer;
/*    */ import net.minecraft.server.v1_8_R1.EntityVillager;
/*    */ import net.minecraft.server.v1_8_R1.IChatBaseComponent;
/*    */ import net.minecraft.server.v1_8_R1.Packet;
/*    */ import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
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
/* 23 */     RegisterNMS.registerEntity("Villager", 120, EntityVillager.class, VillagerNMS.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void actionMsg(Player p, String message) {
/* 28 */     CraftPlayer cPlayer = (CraftPlayer)p;
/* 29 */     String string = ChatColor.translateAlternateColorCodes('&', message);
/* 30 */     IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + string + "\"}");
/* 31 */     PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte)2);
/* 32 */     (cPlayer.getHandle()).playerConnection.sendPacket((Packet)ppoc);
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound witherDeath() {
/* 37 */     return Sound.valueOf("WITHER_DEATH");
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound levelUp() {
/* 42 */     return Sound.valueOf("LEVEL_UP");
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound wolfDeath() {
/* 47 */     return Sound.valueOf("WOLF_DEATH");
/*    */   }
/*    */ 
/*    */   
/*    */   public Sound click() {
/* 52 */     return Sound.valueOf("CLICK");
/*    */   }
/*    */ 
/*    */   
/*    */   public Villager spawnVillager(Location loc, Integer health) {
/* 57 */     return VillagerNMS.spawnVillager(loc, health);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack itemInHand(Player p) {
/* 62 */     return p.getInventory().getItemInHand();
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\nms\v1_8_R1\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */