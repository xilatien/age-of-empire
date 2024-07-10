/*    */ package com.andrei1058.ageofempire.nms.v1_8_R1;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.server.v1_8_R1.EntityTypes;
/*    */ 
/*    */ 
/*    */ public class RegisterNMS
/*    */ {
/*    */   public static void registerEntity(String name, int id, Class nmsClass, Class customClass) {
/*    */     try {
/* 15 */       List<Map<?, ?>> dataMap = new ArrayList<>();
/* 16 */       for (Field f : EntityTypes.class.getDeclaredFields()) {
/* 17 */         if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
/* 18 */           f.setAccessible(true);
/* 19 */           dataMap.add((Map<?, ?>)f.get((Object)null));
/*    */         } 
/*    */       } 
/*    */       
/* 23 */       if (((Map)dataMap.get(2)).containsKey(Integer.valueOf(id))) {
/* 24 */         ((Map)dataMap.get(0)).remove(name);
/* 25 */         ((Map)dataMap.get(2)).remove(Integer.valueOf(id));
/*    */       } 
/*    */       
/* 28 */       Method method = EntityTypes.class.getDeclaredMethod("a", new Class[] { Class.class, String.class, int.class });
/* 29 */       method.setAccessible(true);
/* 30 */       method.invoke((Object)null, new Object[] { customClass, name, Integer.valueOf(id) });
/*    */     }
/* 32 */     catch (Exception e) {
/* 33 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\nms\v1_8_R1\RegisterNMS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */