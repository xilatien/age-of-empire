/*     */ package com.andrei1058.ageofempire;
/*     */ import com.andrei1058.ageofempire.commands.Stuck;
/*     */ import com.andrei1058.ageofempire.configuration.Updater;
/*     */ import com.andrei1058.ageofempire.game.Status;
/*     */ import com.andrei1058.ageofempire.listeners.ChatListener;
/*     */ import com.andrei1058.ageofempire.listeners.PlayerArmorStandManipulateListener;
/*     */ import com.andrei1058.ageofempire.listeners.PlayerInteractListener;
/*     */ import com.andrei1058.ageofempire.listeners.PlayerJoinListener;
/*     */ import com.andrei1058.ageofempire.listeners.PlayerLoginListener;
/*     */ import com.andrei1058.ageofempire.listeners.PlayerMoveListener;
/*     */ import com.andrei1058.ageofempire.listeners.PlayerRespawnListener;
/*     */ import com.andrei1058.ageofempire.listeners.ProjectileHitListener;
/*     */ import com.andrei1058.ageofempire.listeners.ServerPingListener;
/*     */ import com.andrei1058.ageofempire.nms.NMS;
/*     */ import com.andrei1058.ageofempire.nms.v1_8_R3.Main;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import net.milkbowl.vault.chat.Chat;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Villager;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.RegisteredServiceProvider;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ public class Main extends JavaPlugin {
/*     */   public static Main plugin;
/*  34 */   public static String PREFIX = "§9[§7AOE§9]";
/*  35 */   private static File directory = new File("plugins/Age-Of-Empire");
/*     */   
/*  37 */   public static ArrayList<Player> bluePlayers = new ArrayList<>();
/*  38 */   public static ArrayList<Player> greenPlayers = new ArrayList<>();
/*  39 */   public static ArrayList<Player> yellowPlayers = new ArrayList<>();
/*  40 */   public static ArrayList<Player> redPlayers = new ArrayList<>();
/*  41 */   public static ArrayList<Player> help = new ArrayList<>();
/*  42 */   public static ArrayList<Player> players = new ArrayList<>();
/*     */   
/*  44 */   public static ArrayList<Location> xp = new ArrayList<>();
/*  45 */   public static HashMap<Player, Integer> kills = new HashMap<>();
/*  46 */   public static HashMap<Player, Integer> deaths = new HashMap<>();
/*  47 */   public static HashMap<Player, Integer> kingskilled = new HashMap<>();
/*  48 */   public static String choosenMap = "";
/*     */   public static boolean SETUP = false;
/*  50 */   public static Status STATUS = Status.LOBBY; public static boolean pvp = false;
/*     */   public static boolean assualt = false;
/*  52 */   public static int max_in_team = 6, min_players = 6;
/*  53 */   public static int lobby_time = 60, restart_time = 15, pregame_time = 20;
/*  54 */   public static int blue_wood = 100, green_wood = 100, yellow_wood = 100, red_wood = 100;
/*  55 */   public static int blue_stone = 100, green_stone = 100, yellow_stone = 100, red_stone = 100;
/*  56 */   public static int blue_small_plots = 0, green_small_plots = 0, yellow_small_plots = 0, red_small_plots = 0;
/*  57 */   public static int blue_medium_plots = 0, green_medium_plots = 0, yellow_medium_plots = 0, red_medium_plots = 0;
/*  58 */   public static int blue_large_plots = 0, green_large_plots = 0, yellow_large_plots = 0, red_large_plots = 0;
/*  59 */   public static int blue_age = 1; public static int green_age = 1; public static int yellow_age = 1; public static int red_age = 1;
/*  60 */   public static long pvp_assault = 0L; public static final String blue_team = "Blue"; public static final String green_team = "Green"; public static final String yellow_team = "Yellow"; public static final String red_team = "Red"; public static Villager blue_villager; public static Villager green_villager; public static Villager yellow_villager; public static Villager red_villager; public static boolean blue_stonemine = false, green_stonemine = false, yellow_stonemine = false, red_stonemine = false; public static boolean blue_goldmine = false, green_goldmine = false, yellow_goldmine = false, red_goldmine = false; public static boolean blue_sawmill = false, green_sawmill = false, yellow_sawmill = false, red_sawmill = false; public static boolean blue_xp = false; public static boolean green_xp = false; public static boolean yellow_xp = false;
/*     */   public static boolean red_xp;
/*     */   public static Villager blue_forge;
/*     */   public static Villager green_forge;
/*     */   public static Villager yellow_forge;
/*     */   public static Villager red_forge;
/*     */   public static Villager blue_smine;
/*     */   public static Villager green_smine;
/*     */   public static Villager yellow_smine;
/*     */   public static Villager red_smine;
/*     */   public static Villager blue_gmine;
/*     */   public static Villager green_gmine;
/*     */   public static Villager yellow_gmine;
/*     */   public static Villager red_gmine;
/*     */   public static Villager blue_mill;
/*     */   public static Villager green_mill;
/*     */   public static Villager yellow_mill;
/*     */   public static Villager red_mill;
/*     */   public static Villager blue_vsawmill;
/*     */   public static Villager green_vsawmill;
/*     */   public static Villager yellow_vsawmill;
/*     */   public static Villager red_vsawmill;
/*     */   public static Villager blue_workshop;
/*     */   public static Villager green_workshop;
/*     */   public static Villager yellow_workshop;
/*     */   public static Villager red_workshop;
/*  86 */   public static ArrayList<Block> placedBlocks = new ArrayList<>(); public static Villager blue_market; public static Villager green_market; public static Villager yellow_market; public static Villager red_market; public static Villager blue_sabotage; public static Villager green_sabotage; public static Villager yellow_sabotage; public static Villager red_sabotage; public static Villager blue_kennel; public static Villager green_kennel; public static Villager yellow_kennel; public static Villager red_kennel; public static Villager blue_archery; public static Villager green_archery; public static Villager yellow_archery; public static Villager red_archery; public static Villager blue_trifarrow; public static Villager green_trifarrow; public static Villager yellow_trifarrow; public static Villager red_trifarrow; public static Villager blue_stable; public static Villager green_stable; public static Villager yellow_stable; public static Villager red_stable; public static Villager blue_armory; public static Villager green_armory; public static Villager yellow_armory; public static Villager red_armory; public static Villager blue_lab; public static Villager green_lab; public static Villager yellow_lab; public static Villager red_lab; public static Villager blue_guild; public static Villager green_guild; public static Villager yellow_guild; public static Villager red_guild; public static Villager blue_tcenter; public static Villager green_tcenter; public static Villager yellow_tcenter; public static Villager red_tcenter;
/*  87 */   public static HashMap<Player, Integer> gold = new HashMap<>();
/*  88 */   public static ArrayList<Player> teamchoose = new ArrayList<>();
/*  89 */   public static Chat chat = null;
/*  90 */   public static Boolean vaultHook = Boolean.valueOf(false);
/*     */   public static NMS nms;
/*  92 */   public static int forum_health = 1400, other_health = 500;
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  96 */     plugin = this;
/*  97 */     if (!directory.exists()) {
/*  98 */       directory.mkdir();
/*     */     }
/* 100 */     String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
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
/*     */     
/*     */     try {
/* 145 */       nms = (NMS)Main.class.newInstance();
/* 146 */     } catch (InstantiationException e) {
/* 147 */       e.printStackTrace();
/* 148 */     } catch (IllegalAccessException e) {
/* 149 */       e.printStackTrace();
/*     */     } 
/* 151 */     getLogger().info("Loading support for " + version);
/* 152 */     Settings.setupSettings();
/* 153 */     getCommand("setup").setExecutor((CommandExecutor)new Setup());
/* 154 */     getCommand("leave").setExecutor((CommandExecutor)new Leave());
/* 155 */     getCommand("help").setExecutor((CommandExecutor)new Help());
/* 156 */     getCommand("start").setExecutor((CommandExecutor)new Start());
/* 157 */     getCommand("stuck").setExecutor((CommandExecutor)new Stuck());
/* 158 */     PluginManager pm = Bukkit.getPluginManager();
/* 159 */     pm.registerEvents((Listener)new PlayerJoinListener(), (Plugin)this);
/* 160 */     pm.registerEvents((Listener)new PlayerInteractListener(), (Plugin)this);
/* 161 */     pm.registerEvents((Listener)new ItemDropListener(), (Plugin)this);
/* 162 */     pm.registerEvents((Listener)new ItemPickUpListener(), (Plugin)this);
/* 163 */     pm.registerEvents((Listener)new InventoryClickListener(), (Plugin)this);
/* 164 */     pm.registerEvents((Listener)new EntityDamageByEntityListener(), (Plugin)this);
/* 165 */     pm.registerEvents((Listener)new FoodLevelChangeListener(), (Plugin)this);
/* 166 */     pm.registerEvents((Listener)new EntityDamageListener(), (Plugin)this);
/* 167 */     pm.registerEvents((Listener)new PlayerMoveListener(), (Plugin)this);
/* 168 */     pm.registerEvents((Listener)new BlockBreakListener(), (Plugin)this);
/* 169 */     pm.registerEvents((Listener)new PlayerQuitListener(), (Plugin)this);
/* 170 */     pm.registerEvents((Listener)new BlockPlaceListener(), (Plugin)this);
/* 171 */     pm.registerEvents((Listener)new PlayerInteractEntityListener(), (Plugin)this);
/* 172 */     pm.registerEvents((Listener)new ChatListener(), (Plugin)this);
/* 173 */     pm.registerEvents((Listener)new PlayerArmorStandManipulateListener(), (Plugin)this);
/* 174 */     pm.registerEvents((Listener)new ServerPingListener(), (Plugin)this);
/* 175 */     pm.registerEvents((Listener)new EntityDeathListener(), (Plugin)this);
/* 176 */     pm.registerEvents((Listener)new PlayerDeathListener(), (Plugin)this);
/* 177 */     pm.registerEvents((Listener)new PlayerRespawnListener(), (Plugin)this);
/* 178 */     pm.registerEvents((Listener)new CreatureSpawnListener(), (Plugin)this);
/* 179 */     pm.registerEvents((Listener)new PlayerLoginListener(), (Plugin)this);
/* 180 */     pm.registerEvents((Listener)new ProjectileHitListener(), (Plugin)this);
/* 181 */     pm.registerEvents((Listener)new EntityShootBowListener(), (Plugin)this);
/* 182 */     plugin.getServer().getMessenger().registerOutgoingPluginChannel((Plugin)plugin, "BungeeCord");
/*     */     try {
/* 184 */       setupChat();
/* 185 */     } catch (Exception e) {
/* 186 */       e.printStackTrace();
/*     */     } 
/* 188 */     new bStats(this);
/* 189 */     Updater.checkUpdates();
/*     */   }
/*     */   
/*     */   private boolean setupChat() {
/* 193 */     if (getServer().getPluginManager().getPlugin("Vault") == null) {
/* 194 */       return false;
/*     */     }
/* 196 */     RegisteredServiceProvider<Chat> rsp = null;
/*     */     try {
/* 198 */       rsp = getServer().getServicesManager().getRegistration(Chat.class);
/* 199 */     } catch (Exception exception) {}
/*     */     
/* 201 */     chat = (Chat)rsp.getProvider();
/* 202 */     vaultHook = Boolean.valueOf(true);
/* 203 */     plugin.getLogger().info("Loaded Vault support!");
/* 204 */     return (chat != null);
/*     */   }
/*     */   public static void addKill(Player p) {
/* 207 */     if (kills.containsKey(p)) {
/* 208 */       kills.replace(p, Integer.valueOf(((Integer)kills.get(p)).intValue() + 1));
/*     */     } else {
/* 210 */       kills.put(p, Integer.valueOf(1));
/*     */     } 
/*     */   }
/*     */   public static void addDeath(Player p) {
/* 214 */     if (deaths.containsKey(p)) {
/* 215 */       deaths.replace(p, Integer.valueOf(((Integer)deaths.get(p)).intValue() + 1));
/*     */     } else {
/* 217 */       deaths.put(p, Integer.valueOf(1));
/*     */     } 
/*     */   }
/*     */   public static void addKingKill(Player p) {
/* 221 */     if (kingskilled.containsKey(p)) {
/* 222 */       kingskilled.replace(p, Integer.valueOf(((Integer)kingskilled.get(p)).intValue() + 1));
/*     */     } else {
/* 224 */       kingskilled.put(p, Integer.valueOf(1));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */