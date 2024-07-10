/*    */ package com.andrei1058.ageofempire.nms.v1_8_R3;
/*    */ import java.lang.reflect.Field;
/*    */ import net.minecraft.server.v1_8_R3.Entity;
/*    */ import net.minecraft.server.v1_8_R3.EntityHuman;
/*    */ import net.minecraft.server.v1_8_R3.EntityInsentient;
/*    */ import net.minecraft.server.v1_8_R3.PathfinderGoal;
/*    */ import net.minecraft.server.v1_8_R3.PathfinderGoalLookAtPlayer;
/*    */ import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;
/*    */ import net.minecraft.server.v1_8_R3.World;
/*    */ import net.minecraft.server.v1_8_R3.WorldServer;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.util.UnsafeList;
/*    */ import org.bukkit.entity.Villager;
/*    */ 
/*    */ public class VillagerNMS extends EntityVillager {
/*    */   public VillagerNMS(World world) {
/* 19 */     super(world);
/*    */     
/*    */     try {
/* 22 */       Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
/* 23 */       bField.setAccessible(true);
/* 24 */       Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
/* 25 */       cField.setAccessible(true);
/*    */       
/* 27 */       bField.set(this.goalSelector, new UnsafeList());
/* 28 */       bField.set(this.targetSelector, new UnsafeList());
/* 29 */       cField.set(this.goalSelector, new UnsafeList());
/* 30 */       cField.set(this.targetSelector, new UnsafeList());
/* 31 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/* 34 */     this.goalSelector.a(0, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)this));
/* 35 */     this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalInteract((EntityInsentient)this, EntityHuman.class, 3.0F, 1.0F));
/* 36 */     this.goalSelector.a(10, (PathfinderGoal)new PathfinderGoalLookAtPlayer((EntityInsentient)this, EntityHuman.class, 8.0F));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void move(double d0, double d1, double d2) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void g(double d0, double d1, double d2) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Villager spawnVillager(Location loc, Integer health) {
/* 58 */     WorldServer worldServer = ((CraftWorld)loc.getWorld()).getHandle();
/* 59 */     VillagerNMS customEnt = new VillagerNMS((World)worldServer);
/* 60 */     customEnt.getAttributeInstance(GenericAttributes.maxHealth).setValue(Settings.load().getInt("health.forum"));
/* 61 */     customEnt.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
/* 62 */     ((CraftLivingEntity)customEnt.getBukkitEntity()).setRemoveWhenFarAway(false);
/* 63 */     customEnt.setCustomName("§9" + health);
/* 64 */     customEnt.setCustomNameVisible(true);
/* 65 */     customEnt.setHealth(health.intValue());
/* 66 */     worldServer.addEntity((Entity)customEnt, CreatureSpawnEvent.SpawnReason.CUSTOM);
/* 67 */     return (Villager)customEnt.getBukkitEntity();
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\nms\v1_8_R3\VillagerNMS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */