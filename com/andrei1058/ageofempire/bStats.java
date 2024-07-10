/*     */ package com.andrei1058.ageofempire;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.UUID;
/*     */ import java.util.logging.Level;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ import javax.net.ssl.HttpsURLConnection;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.ServicePriority;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.json.simple.JSONArray;
/*     */ import org.json.simple.JSONObject;
/*     */ 
/*     */ public class bStats
/*     */ {
/*     */   public static final int B_STATS_VERSION = 1;
/*     */   private static final String URL = "https://bStats.org/submitData/bukkit";
/*     */   private static boolean logFailedRequests;
/*     */   private static String serverUUID;
/*     */   private final JavaPlugin plugin;
/*     */   
/*     */   static {
/*  31 */     String defaultPackage = new String(new byte[] { 111, 114, 103, 46, 98, 115, 116, 97, 116, 115 });
/*  32 */     String examplePackage = new String(new byte[] { 121, 111, 117, 114, 46, 112, 97, 99, 107, 97, 103, 101 });
/*     */     
/*  34 */     if (bStats.class.getPackage().getName().equals(defaultPackage) || bStats.class.getPackage().getName().equals(examplePackage)) {
/*  35 */       throw new IllegalStateException("bStats Metrics class has not been relocated correctly!");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bStats(JavaPlugin plugin) {
/*  60 */     if (plugin == null) {
/*  61 */       throw new IllegalArgumentException("Plugin cannot be null!");
/*     */     }
/*  63 */     this.plugin = plugin;
/*     */ 
/*     */     
/*  66 */     File bStatsFolder = new File(plugin.getDataFolder().getParentFile(), "bStats");
/*  67 */     File configFile = new File(bStatsFolder, "config.yml");
/*  68 */     YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
/*     */ 
/*     */     
/*  71 */     if (!config.isSet("serverUuid")) {
/*     */ 
/*     */       
/*  74 */       config.addDefault("enabled", Boolean.valueOf(true));
/*     */       
/*  76 */       config.addDefault("serverUuid", UUID.randomUUID().toString());
/*     */       
/*  78 */       config.addDefault("logFailedRequests", Boolean.valueOf(false));
/*     */ 
/*     */       
/*  81 */       config.options().header("bStats collects some data for plugin authors like how many servers are using their plugins.\nTo honor their work, you should not disable it.\nThis has nearly no effect on the server performance!\nCheck out https://bStats.org/ to learn more :)")
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  86 */         .copyDefaults(true);
/*     */       try {
/*  88 */         config.save(configFile);
/*  89 */       } catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */     
/*  93 */     serverUUID = config.getString("serverUuid");
/*  94 */     logFailedRequests = config.getBoolean("logFailedRequests", false);
/*  95 */     if (config.getBoolean("enabled", true)) {
/*  96 */       boolean found = false;
/*     */       
/*  98 */       for (Class<?> service : (Iterable<Class<?>>)Bukkit.getServicesManager().getKnownServices()) {
/*     */         try {
/* 100 */           service.getField("B_STATS_VERSION");
/* 101 */           found = true;
/*     */           break;
/* 103 */         } catch (NoSuchFieldException noSuchFieldException) {}
/*     */       } 
/*     */       
/* 106 */       Bukkit.getServicesManager().register(bStats.class, this, (Plugin)plugin, ServicePriority.Normal);
/* 107 */       if (!found)
/*     */       {
/* 109 */         startSubmitting();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void startSubmitting() {
/* 118 */     final Timer timer = new Timer(true);
/* 119 */     timer.scheduleAtFixedRate(new TimerTask()
/*     */         {
/*     */           public void run() {
/* 122 */             if (!bStats.this.plugin.isEnabled()) {
/* 123 */               timer.cancel();
/*     */               
/*     */               return;
/*     */             } 
/*     */             
/* 128 */             Bukkit.getScheduler().runTask((Plugin)bStats.this.plugin, new Runnable()
/*     */                 {
/*     */                   public void run() {
/* 131 */                     bStats.this.submitData();
/*     */                   }
/*     */                 });
/*     */           }
/*     */         }300000L, 1800000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JSONObject getPluginData() {
/* 148 */     JSONObject data = new JSONObject();
/*     */     
/* 150 */     String pluginName = this.plugin.getDescription().getName();
/* 151 */     String pluginVersion = this.plugin.getDescription().getVersion();
/*     */     
/* 153 */     data.put("pluginName", pluginName);
/* 154 */     data.put("pluginVersion", pluginVersion);
/* 155 */     JSONArray customCharts = new JSONArray();
/* 156 */     data.put("customCharts", customCharts);
/*     */     
/* 158 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JSONObject getServerData() {
/* 168 */     int playerAmount = Bukkit.getOnlinePlayers().size();
/* 169 */     int onlineMode = Bukkit.getOnlineMode() ? 1 : 0;
/* 170 */     String bukkitVersion = Bukkit.getVersion();
/* 171 */     bukkitVersion = bukkitVersion.substring(bukkitVersion.indexOf("MC: ") + 4, bukkitVersion.length() - 1);
/*     */ 
/*     */     
/* 174 */     String javaVersion = System.getProperty("java.version");
/* 175 */     String osName = System.getProperty("os.name");
/* 176 */     String osArch = System.getProperty("os.arch");
/* 177 */     String osVersion = System.getProperty("os.version");
/* 178 */     int coreCount = Runtime.getRuntime().availableProcessors();
/*     */     
/* 180 */     JSONObject data = new JSONObject();
/*     */     
/* 182 */     data.put("serverUUID", serverUUID);
/*     */     
/* 184 */     data.put("playerAmount", Integer.valueOf(playerAmount));
/* 185 */     data.put("onlineMode", Integer.valueOf(onlineMode));
/* 186 */     data.put("bukkitVersion", bukkitVersion);
/*     */     
/* 188 */     data.put("javaVersion", javaVersion);
/* 189 */     data.put("osName", osName);
/* 190 */     data.put("osArch", osArch);
/* 191 */     data.put("osVersion", osVersion);
/* 192 */     data.put("coreCount", Integer.valueOf(coreCount));
/*     */     
/* 194 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void submitData() {
/* 201 */     final JSONObject data = getServerData();
/*     */     
/* 203 */     JSONArray pluginData = new JSONArray();
/*     */     
/* 205 */     for (Class<?> service : (Iterable<Class<?>>)Bukkit.getServicesManager().getKnownServices()) {
/*     */       try {
/* 207 */         service.getField("B_STATS_VERSION");
/* 208 */       } catch (NoSuchFieldException ignored) {
/*     */         continue;
/*     */       } 
/*     */       
/*     */       try {
/* 213 */         pluginData.add(service.getMethod("getPluginData", new Class[0]).invoke(Bukkit.getServicesManager().load(service), new Object[0]));
/* 214 */       } catch (NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException noSuchMethodException) {}
/*     */     } 
/*     */     
/* 217 */     data.put("plugins", pluginData);
/*     */ 
/*     */     
/* 220 */     (new Thread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try {
/* 225 */               bStats.sendData(data);
/* 226 */             } catch (Exception e) {
/*     */               
/* 228 */               if (bStats.logFailedRequests) {
/* 229 */                 bStats.this.plugin.getLogger().log(Level.WARNING, "Could not submit plugin stats of " + bStats.this.plugin.getName(), e);
/*     */               }
/*     */             } 
/*     */           }
/* 233 */         })).start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void sendData(JSONObject data) throws Exception {
/* 243 */     if (data == null) {
/* 244 */       throw new IllegalArgumentException("Data cannot be null!");
/*     */     }
/* 246 */     if (Bukkit.isPrimaryThread()) {
/* 247 */       throw new IllegalAccessException("This method must not be called from the main thread!");
/*     */     }
/* 249 */     HttpsURLConnection connection = (HttpsURLConnection)(new URL("https://bStats.org/submitData/bukkit")).openConnection();
/*     */ 
/*     */     
/* 252 */     byte[] compressedData = compress(data.toString());
/*     */ 
/*     */     
/* 255 */     connection.setRequestMethod("POST");
/* 256 */     connection.addRequestProperty("Accept", "application/json");
/* 257 */     connection.addRequestProperty("Connection", "close");
/* 258 */     connection.addRequestProperty("Content-Encoding", "gzip");
/* 259 */     connection.addRequestProperty("Content-Length", String.valueOf(compressedData.length));
/* 260 */     connection.setRequestProperty("Content-Type", "application/json");
/* 261 */     connection.setRequestProperty("User-Agent", "MC-Server/1");
/*     */ 
/*     */     
/* 264 */     connection.setDoOutput(true);
/* 265 */     DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
/* 266 */     outputStream.write(compressedData);
/* 267 */     outputStream.flush();
/* 268 */     outputStream.close();
/*     */     
/* 270 */     connection.getInputStream().close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] compress(String str) throws IOException {
/* 281 */     if (str == null) {
/* 282 */       return null;
/*     */     }
/* 284 */     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/* 285 */     GZIPOutputStream gzip = new GZIPOutputStream(outputStream);
/* 286 */     gzip.write(str.getBytes("UTF-8"));
/* 287 */     gzip.close();
/* 288 */     return outputStream.toByteArray();
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\bStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */