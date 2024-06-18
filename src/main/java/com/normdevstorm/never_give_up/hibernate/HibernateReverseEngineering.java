//package com.normdevstorm.never_give_up.hibernate;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.tool.hbm2ddl.SchemaExport;
//import org.hibernate.tool.hbm2x.Cfg2JavaTool;
//import org.hibernate.tool.schema.TargetType;
//
//import java.util.EnumSet;
//
//public class HibernateReverseEngineering {
//
//    public static void main(String[] args) {
//        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//        SchemaExport export = new SchemaExport();
//        export.setImportFiles("cfg");
//        export.setOutputFile("src/main/java");
//        export.execute(EnumSet.of(TargetType.
//                DATABASE), SchemaExport.Action.CREATE, false, false);
//        export.ex
//
//        Cfg2JavaTool tool = new Cfg2JavaTool();
//        tool.execute(cfg, "src/main/java");
//    }
//}