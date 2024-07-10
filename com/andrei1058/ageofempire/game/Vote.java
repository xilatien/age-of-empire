/*     */ package com.andrei1058.ageofempire.game;
/*     */ 
/*     */ import com.andrei1058.ageofempire.Main;
/*     */ import com.andrei1058.ageofempire.Misc;
/*     */ import com.andrei1058.ageofempire.configuration.Messages;
/*     */ import com.andrei1058.ageofempire.runnables.Game;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Vote
/*     */ {
/*  21 */   public static ArrayList<Vote> votes = new ArrayList<>();
/*  22 */   public static HashMap<String, Vote> votes_by_team = new HashMap<>();
/*     */   public ArrayList<Player> team;
/*  24 */   public int time = 9;
/*     */   public String build;
/*     */   public String teamname;
/*     */   public Player requester;
/*     */   public int player_votes;
/*     */   public int wood;
/*     */   public int stone;
/*     */   public String BUILD_NAME;
/*     */   
/*     */   public Vote(ArrayList<Player> team, String build, Player requester, String teamname, int wood, int stone, String BUILD_NAME) {
/*  34 */     this.team = team;
/*  35 */     this.build = build;
/*  36 */     this.requester = requester;
/*  37 */     this.wood = wood;
/*  38 */     this.stone = stone;
/*  39 */     this.BUILD_NAME = BUILD_NAME;
/*  40 */     votes.add(this);
/*  41 */     this.teamname = teamname;
/*  42 */     votes_by_team.put(teamname, this);
/*  43 */     Buildings.vote_in_progress.add(teamname);
/*  44 */     for (Player u : team) {
/*  45 */       if (Main.help.contains(u)) {
/*  46 */         u.sendMessage(Messages.getMsg("help.vote"));
/*     */       }
/*  48 */       u.getInventory().setItem(8, Misc.voteitem());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stuff() {
/*  53 */     this.time--;
/*  54 */     if (this.time == 0 || this.time < 0) {
/*  55 */       if (this.player_votes > this.team.size() / 2) {
/*  56 */         for (Player u : this.team) {
/*  57 */           Main.nms.actionMsg(u, Messages.getMsg("vote-accepted").replace("{player}", this.requester.getName()));
/*  58 */           u.getInventory().setItem(8, Misc.slotlocked());
/*     */         } 
/*  60 */         if (this.teamname == "Blue") {
/*  61 */           Main.blue_wood -= this.wood;
/*  62 */           Main.blue_stone -= this.stone;
/*  63 */         } else if (this.teamname == "Green") {
/*  64 */           Main.green_wood -= this.wood;
/*  65 */           Main.green_stone -= this.stone;
/*  66 */         } else if (this.teamname == "Yellow") {
/*  67 */           Main.yellow_wood -= this.wood;
/*  68 */           Main.yellow_stone -= this.stone;
/*  69 */         } else if (this.teamname == "Red") {
/*  70 */           Main.red_wood -= this.wood;
/*  71 */           Main.red_stone -= this.stone;
/*     */         } 
/*  73 */         switch (this.build) {
/*     */           case "age":
/*  75 */             switch (this.teamname) {
/*     */               case "Blue":
/*  77 */                 Game.blue_change_age = true;
/*  78 */                 Scoreboard.blue_age_long = 60000L;
/*     */                 break;
/*     */               case "Green":
/*  81 */                 Game.green_change_age = true;
/*  82 */                 Scoreboard.green_age_long = 60000L;
/*     */                 break;
/*     */               case "Yellow":
/*  85 */                 Game.yellow_change_age = true;
/*  86 */                 Scoreboard.yellow_age_long = 60000L;
/*     */                 break;
/*     */               case "Red":
/*  89 */                 Game.red_change_age = true;
/*  90 */                 Scoreboard.red_age_long = 60000L;
/*     */                 break;
/*     */             } 
/*     */             break;
/*     */           default:
/*  95 */             Buildings.construct_in_inv.put(this.requester, this.BUILD_NAME);
/*  96 */             this.requester.getInventory().setItem(7, Misc.constructor());
/*  97 */             new BuildSchematic(this.requester, this.teamname, this.build, this.BUILD_NAME, this.team);
/*     */             break;
/*     */         } 
/*     */       } else {
/* 101 */         for (Player u : this.team) {
/* 102 */           Main.nms.actionMsg(u, Messages.getMsg("vote-denied").replace("{player}", this.requester.getName()));
/* 103 */           u.getInventory().setItem(8, Misc.slotlocked());
/*     */         } 
/*     */       } 
/* 106 */       votes_by_team.remove(this.teamname, this);
/* 107 */       votes.remove(this);
/* 108 */       Buildings.vote_in_progress.remove(this.teamname);
/*     */       return;
/*     */     } 
/* 111 */     for (Player u : this.team) {
/* 112 */       switch (this.build) {
/*     */         case "age":
/* 114 */           Main.nms.actionMsg(u, Messages.getMsg("vote-age").replace("{player}", this.requester.getName()).replace("{votes}", String.valueOf(this.player_votes)).replace("{team}", String.valueOf(this.team.size())));
/*     */           continue;
/*     */       } 
/* 117 */       Main.nms.actionMsg(u, Messages.getMsg("new-vote").replace("{player}", this.requester.getName()).replace("{building}", this.build).replace("{votes}", String.valueOf(this.player_votes)).replace("{team}", String.valueOf(this.team.size())));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayList<Vote> votes() {
/* 124 */     return votes;
/*     */   }
/*     */   
/*     */   public static Vote byTeam(String team) {
/* 128 */     return votes_by_team.get(team);
/*     */   }
/*     */   
/*     */   public void addVote() {
/* 132 */     this.player_votes++;
/*     */   }
/*     */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\com\andrei1058\ageofempire\game\Vote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */