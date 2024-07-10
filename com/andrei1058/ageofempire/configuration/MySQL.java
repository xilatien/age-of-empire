/*     */ package com.andrei1058.ageofempire.configuration;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.Bukkit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MySQL
/*     */ {
/*     */   private static int port;
/*     */   private static String host;
/*     */   private static String user;
/*     */   private static String db_name;
/*     */   private static String password;
/*     */   private static String table;
/*     */   private Connection connection;
/*     */   
/*     */   public static void setupDatabase(String host1, int port1, String database1, String user1, String password1, String prefixx) {
/*  30 */     host = host1;
/*  31 */     port = port1;
/*  32 */     db_name = database1;
/*  33 */     user = user1;
/*  34 */     password = password1;
/*  35 */     table = prefixx + "Gravity";
/*  36 */     (new MySQL()).createTable();
/*     */   }
/*     */   
/*     */   public boolean isConnected() {
/*  40 */     return (this.connection != null);
/*     */   }
/*     */   public boolean connect() {
/*  43 */     if (!isConnected()) {
/*     */       try {
/*  45 */         this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db_name + "?user=" + user + "&password=" + password);
/*  46 */         return true;
/*  47 */       } catch (SQLException e) {
/*  48 */         Main.plugin.getLogger().severe("Cannot connect to database!");
/*  49 */         return false;
/*     */       } 
/*     */     }
/*  52 */     return false;
/*     */   }
/*     */   public void disconnect() {
/*     */     try {
/*  56 */       this.connection.close();
/*  57 */     } catch (SQLException e) {
/*  58 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   public boolean createTable() {
/*  62 */     connect();
/*  63 */     if (isConnected()) {
/*     */       try {
/*  65 */         this.connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS `" + table + "` (Player varchar(100),UUID varchar(100),Wins int(100),GamesPlayed int(100),Kills int(100),Deaths int(100),KingsKilled int(100));");
/*  66 */         disconnect();
/*  67 */         return true;
/*     */       }
/*  69 */       catch (SQLException e) {
/*  70 */         Main.plugin.getLogger().severe(e.getMessage());
/*  71 */         return false;
/*     */       } 
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   public ArrayList<Integer> getStats(UUID uuid) {
/*  77 */     connect();
/*  78 */     if (!isConnected()) {
/*  79 */       return null_stats;
/*     */     }
/*     */     try {
/*  82 */       ArrayList<Integer> data = new ArrayList<>();
/*  83 */       ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM `" + table + "` WHERE UUID='" + uuid + "';");
/*  84 */       if (rs.next()) {
/*  85 */         data.add(Integer.valueOf(rs.getInt("Wins")));
/*  86 */         data.add(Integer.valueOf(rs.getInt("GamesPlayed")));
/*  87 */         data.add(Integer.valueOf(rs.getInt("Kills")));
/*  88 */         data.add(Integer.valueOf(rs.getInt("Deaths")));
/*  89 */         data.add(Integer.valueOf(rs.getInt("KingsKilled")));
/*  90 */         return data;
/*     */       } 
/*  92 */       return null_stats;
/*     */     }
/*  94 */     catch (SQLException e) {
/*  95 */       e.printStackTrace();
/*     */       
/*  97 */       return null_stats;
/*     */     } 
/*     */   }
/*     */   public void addStats(UUID uuid, int wins, int gamesplayed, int kills, int deaths, int kinskilled) {
/* 101 */     connect();
/* 102 */     if (isConnected()) {
/* 103 */       if (exists(uuid)) {
/*     */         try {
/* 105 */           this.connection.createStatement().executeUpdate("UPDATE `" + table + "` SET Wins=Wins+" + wins + ", GamesPlayed=GamesPlayed+" + gamesplayed + ", Kills=Kills+" + kills + ", Deaths=Deaths+" + deaths + ", KingsKilled=KingsKilled+" + kinskilled + " WHERE UUID='" + uuid + "';");
/* 106 */         } catch (Exception e) {
/* 107 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/*     */         try {
/* 111 */           this.connection.createStatement().executeUpdate("INSERT INTO `" + table + "` VALUES ('" + Bukkit.getPlayer(uuid).getName() + "','" + uuid.toString() + "','" + wins + "','" + gamesplayed + "','" + kills + "','" + deaths + "','" + kinskilled + "') ");
/* 112 */         } catch (SQLException e) {
/* 113 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean exists(UUID uuid) {
/* 120 */     connect();
/* 121 */     if (isConnected()) {
/*     */       try {
/* 123 */         ResultSet rs = this.connection.createStatement().executeQuery("SELECT Player FROM `" + table + "` WHERE UUID='" + uuid + "';");
/* 124 */         if (rs.next()) {
/* 125 */           return true;
/*     */         }
/* 127 */       } catch (SQLException e) {
/* 128 */         e.printStackTrace();
/*     */       } 
/*     */     }
/* 131 */     return false;
/*     */   }
/*     */   
/* 134 */   private static final ArrayList<Integer> null_stats = new ArrayList<>(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }));
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\configuration\MySQL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */