/*    */ package com.andrei1058.ageofempire;
/*    */ 
/*    */ import com.andrei1058.ageofempire.configuration.Messages;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import com.mojang.authlib.properties.Property;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Collectors;
/*    */ import org.apache.commons.codec.binary.Base64;
/*    */ import org.bukkit.Color;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.inventory.meta.LeatherArmorMeta;
/*    */ import org.bukkit.inventory.meta.SkullMeta;
/*    */ 
/*    */ 
/*    */ public class Misc
/*    */ {
/*    */   public static ItemStack getSkull(String url, String name) {
/* 24 */     ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
/*    */     
/* 26 */     if (url.isEmpty()) return head;
/*    */     
/* 28 */     SkullMeta headMeta = (SkullMeta)head.getItemMeta();
/* 29 */     headMeta.setDisplayName(name);
/* 30 */     GameProfile profile = new GameProfile(UUID.randomUUID(), null);
/* 31 */     byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", new Object[] { url }).getBytes());
/* 32 */     profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
/* 33 */     Field profileField = null;
/*    */     try {
/* 35 */       profileField = headMeta.getClass().getDeclaredField("profile");
/* 36 */       profileField.setAccessible(true);
/* 37 */       profileField.set(headMeta, profile);
/* 38 */     } catch (NoSuchFieldException|IllegalArgumentException|IllegalAccessException e1) {
/* 39 */       e1.printStackTrace();
/*    */     } 
/* 41 */     head.setItemMeta((ItemMeta)headMeta);
/* 42 */     return head;
/*    */   }
/*    */   public static ItemStack leatherArmor(Material material, Color color) {
/* 45 */     ItemStack i = new ItemStack(material);
/* 46 */     LeatherArmorMeta meta = (LeatherArmorMeta)i.getItemMeta();
/* 47 */     meta.setColor(color);
/* 48 */     i.setItemMeta((ItemMeta)meta);
/* 49 */     return i;
/*    */   }
/*    */   
/*    */   public static ItemStack slotlocked() {
/* 53 */     ItemStack i = new ItemStack(Material.MOB_SPAWNER);
/* 54 */     ItemMeta im = i.getItemMeta();
/* 55 */     im.setDisplayName(Messages.getMsg("locked-slot"));
/* 56 */     i.setItemMeta(im);
/* 57 */     return i;
/*    */   }
/*    */   
/*    */   public static ItemStack forumPaper() {
/* 61 */     ItemStack i = new ItemStack(Material.PAPER);
/* 62 */     ItemMeta im = i.getItemMeta();
/* 63 */     im.setDisplayName(Messages.getMsg("forum-paper"));
/* 64 */     i.setItemMeta(im);
/* 65 */     return i;
/*    */   }
/*    */   
/*    */   public static ItemStack voteitem() {
/* 69 */     ItemStack i = new ItemStack(Material.SLIME_BALL);
/* 70 */     ItemMeta im = i.getItemMeta();
/* 71 */     im.setDisplayName(Messages.getMsg("validate-vote"));
/* 72 */     i.setItemMeta(im);
/* 73 */     return i;
/*    */   }
/*    */   public static ItemStack constructor() {
/* 76 */     ItemStack i = new ItemStack(Material.SPRUCE_DOOR_ITEM);
/* 77 */     ItemMeta im = i.getItemMeta();
/* 78 */     im.setDisplayName(Messages.getMsg("constructor.displayname"));
/* 79 */     im.setLore((List)Messages.getArray("constructor.lore").stream().map(s -> s.replace('&', '§')).collect(Collectors.toCollection(java.util.ArrayList::new)));
/* 80 */     i.setItemMeta(im);
/* 81 */     return i;
/*    */   }
/*    */   
/*    */   public static ItemStack statsItem(Player p) {
/* 85 */     ItemStack i = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
/* 86 */     SkullMeta sm = (SkullMeta)i.getItemMeta();
/* 87 */     sm.setDisplayName(Messages.getMsg("stats.displayname"));
/* 88 */     sm.setOwner(p.getName());
/* 89 */     i.setItemMeta((ItemMeta)sm);
/* 90 */     return i;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\Misc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */