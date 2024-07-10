/*     */ package com.andrei1058.ageofempire.configuration;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.locations.Locations;
/*     */ import com.andrei1058.ageofempire.locations.Region;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.WorldCreator;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Settings
/*     */ {
/*  24 */   private static File file = new File("plugins/Age-Of-Empire/config.yml");
/*  25 */   private static YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
/*     */   
/*     */   public static void setupSettings() {
/*  28 */     if (!file.exists()) {
/*     */       try {
/*  30 */         file.createNewFile();
/*  31 */       } catch (IOException e) {
/*  32 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*  35 */     ArrayList list = new ArrayList();
/*  36 */     yml.addDefault("Setup-Mode", Boolean.valueOf(true));
/*  37 */     yml.addDefault("lobby-server", "aoe");
/*  38 */     yml.addDefault("max-in-team", Integer.valueOf(6));
/*  39 */     yml.addDefault("min-players", Integer.valueOf(6));
/*  40 */     yml.addDefault("countdowns.lobby", Integer.valueOf(60));
/*  41 */     yml.addDefault("countdowns.pregame", Integer.valueOf(20));
/*  42 */     yml.addDefault("countdowns.pvp", Integer.valueOf(6));
/*  43 */     yml.addDefault("countdowns.assault", Integer.valueOf(6));
/*  44 */     yml.addDefault("restart-cmd", "restart");
/*  45 */     yml.addDefault("plot-radius.small", Integer.valueOf(9));
/*  46 */     yml.addDefault("plot-radius.medium", Integer.valueOf(12));
/*  47 */     yml.addDefault("plot-radius.large", Integer.valueOf(16));
/*  48 */     yml.addDefault("Database.enable", Boolean.valueOf(false));
/*  49 */     yml.addDefault("Database.host", "localhost");
/*  50 */     yml.addDefault("Database.port", Integer.valueOf(3306));
/*  51 */     yml.addDefault("Database.database", "AgeOfEmpire");
/*  52 */     yml.addDefault("Database.table", "stats_");
/*  53 */     yml.addDefault("Database.username", "root");
/*  54 */     yml.addDefault("Database.password", "pass");
/*  55 */     yml.addDefault("health.forum", Integer.valueOf(1400));
/*  56 */     yml.addDefault("health.other", Integer.valueOf(500));
/*  57 */     yml.options().header("Age Of Empire plugin by andrei1058 | https://www.spigotmc.org/members/andrei1058.39904/\n---------------------------------------------\nWell, read this if you need help...\nSetup-Mode: false |  Set this to true if you're setting up the server.\nlobby-server: ageofempire | Set this to false if you want a multi-arena server.\nmax-in-team: 2 | How may players can join a team?\nmin-players: 2 | How may players should be connected to start the lobby countdown?\ncountdowns: | Various countdowns.\n  lobby: 40\n  pregame: 10\n  pvp: 5\n  assault: 5\nrestart-cmd: restart | Which command should be executed when the game is over?\nplot-radius: | Various plots radius. Dimensions 9 x 9 etc.  small: 9\n  medium: 12\n  large: 16\nDatabase: | Database credentials. Needed for stats.  enable: true\n  host: localhost\n  port: 3306\n  database: AOE\n  table: stats_\n  username: root\n  password: p4ss2\nhealth: | Various health stuff.  forum: 1400\n  other:  500Arenas: | This is the maps list.\n- mappav2\n");
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
/*  86 */     yml.addDefault("Arenas", list);
/*  87 */     yml.options().copyDefaults(true);
/*     */     try {
/*  89 */       yml.save(file);
/*  90 */     } catch (IOException e) {
/*  91 */       e.printStackTrace();
/*     */     } 
/*  93 */     Messages.setupMessages();
/*  94 */     Main.SETUP = yml.getBoolean("Setup-Mode");
/*  95 */     Main.PREFIX = Messages.getMsg("prefix");
/*  96 */     Main.max_in_team = yml.getInt("max-in-team");
/*  97 */     Main.min_players = yml.getInt("min-players");
/*  98 */     Main.lobby_time = yml.getInt("countdowns.lobby");
/*  99 */     Main.pregame_time = yml.getInt("countdowns.pregame");
/* 100 */     Main.forum_health = yml.getInt("health.forum");
/* 101 */     Main.other_health = yml.getInt("health.other");
/*     */     
/* 103 */     if (load().get("Arenas") != null && !Main.SETUP) {
/* 104 */       Random r = new Random();
/* 105 */       int a = load().getStringList("Arenas").size();
/* 106 */       int mapid = r.nextInt(a);
/* 107 */       Main.choosenMap = load().getStringList("Arenas").get(mapid);
/* 108 */       Bukkit.createWorld(new WorldCreator(Main.choosenMap));
/* 109 */       Location lobby = Locations.getLoc("Spawns.Lobby");
/* 110 */       if (lobby != null) {
/*     */         try {
/* 112 */           lobby.getWorld().getEntities().forEach(Entity::remove);
/* 113 */         } catch (Exception exception) {}
/*     */       } else {
/* 115 */         Main.plugin.getLogger().severe("LOBBY LOCATION IS NOT SET!");
/*     */       } 
/* 117 */       Bukkit.getWorld(Main.choosenMap).setGameRuleValue("keepInventory", "false");
/* 118 */       Bukkit.getWorld(Main.choosenMap).setAutoSave(false);
/* 119 */       Main.blue_large_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Blue.Large").getKeys(false).size();
/* 120 */       Main.blue_medium_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Blue.Medium").getKeys(false).size();
/* 121 */       Main.blue_small_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Blue.Small").getKeys(false).size();
/*     */       
/* 123 */       Main.green_large_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Green.Large").getKeys(false).size();
/* 124 */       Main.green_medium_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Green.Medium").getKeys(false).size();
/* 125 */       Main.green_small_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Green.Small").getKeys(false).size();
/*     */       
/* 127 */       Main.red_large_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Red.Large").getKeys(false).size();
/* 128 */       Main.red_medium_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Red.Medium").getKeys(false).size();
/* 129 */       Main.red_small_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Red.Small").getKeys(false).size();
/*     */       
/* 131 */       Main.yellow_large_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Yellow.Large").getKeys(false).size();
/* 132 */       Main.yellow_medium_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Yellow.Medium").getKeys(false).size();
/* 133 */       Main.yellow_small_plots = Locations.load().getConfigurationSection("Plots." + Main.choosenMap + ".Yellow.Small").getKeys(false).size();
/* 134 */       Region.loadRegions();
/*     */     } 
/* 136 */     File schem = new File("plugins/Age-Of-Empire/schematics");
/* 137 */     if (!schem.exists()) {
/* 138 */       schem.mkdir();
/*     */     }
/* 140 */     saveschem("ARMORY");
/* 141 */     saveschem("ARCHERY_STORE");
/* 142 */     saveschem("FORGE");
/* 143 */     saveschem("GOLD_MINE");
/* 144 */     saveschem("GUILD");
/* 145 */     saveschem("KENNEL");
/* 146 */     saveschem("LABORATORY");
/* 147 */     saveschem("MARKET");
/* 148 */     saveschem("MILL");
/* 149 */     saveschem("SABOTAGE_WORKSHOP");
/* 150 */     saveschem("SAWMILL");
/* 151 */     saveschem("STABLE");
/* 152 */     saveschem("STONE_MINE");
/* 153 */     saveschem("TRAINING_CENTER");
/* 154 */     saveschem("TRIFARROW");
/* 155 */     saveschem("WORKSHOP");
/* 156 */     if (yml.getBoolean("Database.enable")) {
/* 157 */       MySQL.setupDatabase(yml.getString("Database.host"), yml.getInt("Database.port"), yml.getString("Database.database"), yml.getString("Database.username"), yml.getString("Database.password"), yml.getString("Database.table"));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void addMap(String name) {
/* 162 */     ArrayList<String> arene = (ArrayList<String>)yml.getStringList("Arenas");
/* 163 */     arene.add(name);
/* 164 */     yml.set("Arenas", arene);
/*     */     try {
/* 166 */       yml.save(file);
/* 167 */     } catch (IOException e) {
/* 168 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static YamlConfiguration load() {
/* 173 */     return YamlConfiguration.loadConfiguration(file);
/*     */   }
/*     */   
/*     */   public static void togglesetup(boolean b) {
/* 177 */     yml.set("Setup-Mode", Boolean.valueOf(b));
/*     */     try {
/* 179 */       yml.save(file);
/* 180 */     } catch (IOException e) {
/* 181 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void saveschem(String name) {
/* 186 */     InputStream is = Main.plugin.getResource("schematics/" + name + ".schematic");
/*     */     
/*     */     try {
/* 189 */       OutputStream os = new FileOutputStream("plugins/Age-Of-Empire/schematics/" + name + ".schematic", false);
/* 190 */       byte[] buffer = new byte[1024];
/*     */       int length;
/* 192 */       while ((length = is.read(buffer)) > 0) {
/* 193 */         os.write(buffer, 0, length);
/*     */       }
/* 195 */       is.close();
/* 196 */       os.close();
/* 197 */     } catch (FileNotFoundException e) {
/* 198 */       e.printStackTrace();
/* 199 */     } catch (IOException e) {
/* 200 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\configuration\Settings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */