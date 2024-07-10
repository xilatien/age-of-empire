/*    */ package org.jnbt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IntTag
/*    */   extends Tag
/*    */ {
/*    */   private final int value;
/*    */   
/*    */   public IntTag(String name, int value) {
/* 53 */     super(name);
/* 54 */     this.value = value;
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer getValue() {
/* 59 */     return Integer.valueOf(this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 64 */     String name = getName();
/* 65 */     String append = "";
/* 66 */     if (name != null && !name.equals("")) {
/* 67 */       append = "(\"" + getName() + "\")";
/*    */     }
/* 69 */     return "TAG_Int" + append + ": " + this.value;
/*    */   }
/*    */ }


/* Location:              D:\MOI\archive de serveur\plugins prenium\AgeOfEmpire.jar!\org\jnbt\IntTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */