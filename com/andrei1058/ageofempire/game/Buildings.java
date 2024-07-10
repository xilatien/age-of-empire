/*    */ package com.andrei1058.ageofempire.game;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Buildings
/*    */ {
/* 11 */   public static ArrayList<String> vote_in_progress = new ArrayList<>();
/* 12 */   public static HashMap<Player, String> construct_in_inv = new HashMap<>();
/* 13 */   public static ArrayList blue_built = new ArrayList();
/* 14 */   public static ArrayList green_built = new ArrayList();
/* 15 */   public static ArrayList yellow_built = new ArrayList();
/* 16 */   public static ArrayList red_built = new ArrayList(); public static final String forge = "FORGE"; public static final String mill = "MILL"; public static final String stone_mine = "STONE_MINE";
/*    */   public static final String gold_mine = "GOLD_MINE";
/*    */   public static final String sawmill = "SAWMILL";
/*    */   public static final String workshop = "WORKSHOP";
/*    */   public static final String market = "MARKET";
/*    */   public static final String kennel = "KENNEL";
/*    */   
/*    */   public static boolean hasBuild(String build, String team) {
/* 24 */     switch (team) {
/*    */       case "Blue":
/* 26 */         if (blue_built.contains(build)) {
/* 27 */           return true;
/*    */         }
/*    */         break;
/*    */       case "Green":
/* 31 */         if (green_built.contains(build)) {
/* 32 */           return true;
/*    */         }
/*    */         break;
/*    */       case "Yellow":
/* 36 */         if (yellow_built.contains(build)) {
/* 37 */           return true;
/*    */         }
/*    */         break;
/*    */       case "Red":
/* 41 */         if (red_built.contains(build)) {
/* 42 */           return true;
/*    */         }
/*    */         break;
/*    */     } 
/* 46 */     return false;
/*    */   }
/*    */   public static final String sabotage = "SABOTAGE_WORKSHOP"; public static final String age_string = "age"; public static final String archery = "ARCHERY_STORE"; public static final String trifarrow = "TRIFARROW"; public static final String stable = "STABLE"; public static final String armory = "ARMORY"; public static final String laboratory = "LABORATORY"; public static final String guild = "GUILD"; public static final String training_center = "TRAINING_CENTER";
/*    */   public static void addBuild(String build, String team) {
/* 50 */     switch (team) {
/*    */       case "Blue":
/* 52 */         blue_built.add(build);
/*    */         break;
/*    */       case "Green":
/* 55 */         green_built.add(build);
/*    */         break;
/*    */       case "Yellow":
/* 58 */         yellow_built.add(build);
/*    */         break;
/*    */       case "Red":
/* 61 */         red_built.add(build);
/*    */         break;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\game\Buildings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */