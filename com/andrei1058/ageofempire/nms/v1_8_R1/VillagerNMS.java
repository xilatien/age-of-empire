/*    */ package com.andrei1058.ageofempire.nms.v1_8_R1;
/*    */ import java.lang.reflect.Field;
/*    */ import net.minecraft.server.v1_8_R1.EntityHuman;
/*    */ import net.minecraft.server.v1_8_R1.EntityInsentient;
/*    */ import net.minecraft.server.v1_8_R1.PathfinderGoal;
/*    */ import net.minecraft.server.v1_8_R1.PathfinderGoalFloat;
/*    */ import net.minecraft.server.v1_8_R1.PathfinderGoalLookAtPlayer;
/*    */ import net.minecraft.server.v1_8_R1.PathfinderGoalSelector;
/*    */ import net.minecraft.server.v1_8_R1.World;
/*    */ import net.minecraft.server.v1_8_R1.WorldServer;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.craftbukkit.v1_8_R1.util.UnsafeList;
/*    */ import org.bukkit.entity.Villager;
/*    */ 
/*    */ public class VillagerNMS extends EntityVillager {
/*    */   public VillagerNMS(World world) {
/* 17 */     super(world);
/*    */     
/*    */     try {
/* 20 */       Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
/* 21 */       bField.setAccessible(true);
/* 22 */       Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
/* 23 */       cField.setAccessible(true);
/*    */       
/* 25 */       bField.set(this.goalSelector, new UnsafeList());
/* 26 */       bField.set(this.targetSelector, new UnsafeList());
/* 27 */       cField.set(this.goalSelector, new UnsafeList());
/* 28 */       cField.set(this.targetSelector, new UnsafeList());
/* 29 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/* 32 */     this.goalSelector.a(0, (PathfinderGoal)new PathfinderGoalFloat((EntityInsentient)this));
/* 33 */     this.goalSelector.a(9, (PathfinderGoal)new PathfinderGoalInteract((EntityInsentient)this, EntityHuman.class, 3.0F, 1.0F));
/* 34 */     this.goalSelector.a(10, (PathfinderGoal)new PathfinderGoalLookAtPlayer((EntityInsentient)this, EntityHuman.class, 8.0F));
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
/* 56 */     WorldServer worldServer = ((CraftWorld)loc.getWorld()).getHandle();
/* 57 */     VillagerNMS customEnt = new VillagerNMS((World)worldServer);
/* 58 */     customEnt.getAttributeInstance(GenericAttributes.maxHealth).setValue(Settings.load().getInt("health.forum"));
/* 59 */     customEnt.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
/* 60 */     ((CraftLivingEntity)customEnt.getBukkitEntity()).setRemoveWhenFarAway(false);
/* 61 */     customEnt.setCustomName("§9" + health);
/* 62 */     customEnt.setCustomNameVisible(true);
/* 63 */     customEnt.setHealth(health.intValue());
/* 64 */     worldServer.addEntity((Entity)customEnt, CreatureSpawnEvent.SpawnReason.CUSTOM);
/* 65 */     return (Villager)customEnt.getBukkitEntity();
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\nms\v1_8_R1\VillagerNMS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */