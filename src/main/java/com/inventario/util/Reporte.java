/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.util;

import com.inventario.dao.DAO;
import java.awt.Frame;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author RyuujiMD
 */
public class Reporte {

    private Connection conn;
    private static final Logger LOG = Logger.getLogger(Reporte.class.getName());
    private static final File insignia = new File("reportes/insignia.jpg");
    private static final String rutaRelativa = new File("reportes/").getAbsolutePath() + "/";

    public void generarReporte(File reporte, Map parametros, Frame ventana) throws JRException {
        try {
//            Class.forName("org.postgresql.Driver");            
            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/inventario1","postgres","root");            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventario", "root", "root");
//            DAO dao = new DAO();
//            conn = dao.getEntityManager().unwrap(Connection.class);
            if (conn == null) {
                System.out.println("NO SE CONECTA PAPA!");
            } else {
                System.out.println("SI SE CONECTA " + conn);
            }
        } catch (Exception ex) {
            System.out.println("ESTO ES MALO1: " + ex.getMessage());
        }
        JDialog visor = new JDialog(ventana, "Reporte", true);

        JasperReport report = (JasperReport) JRLoader.loadObject(reporte);

//        File logo = new File("reportes/obs.jpg");
        System.out.println("INSIGNIA: " + insignia.getAbsolutePath());

        //AGREGAMOS LAS IMÁGENES AL REPORTE :D
        parametros.put("insignia", insignia.getAbsolutePath());
        parametros.put("ruta", rutaRelativa);
        LOG.log(Level.INFO, "La ruta relativa es {0}", rutaRelativa);
//        parametros.put("logo",logo.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, conn);
        JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
        visor.setSize(jasperViewer.getSize());
//        visor.setSize(ventana.getSize().width, ventana.getSize().height);
        visor.getContentPane().add(jasperViewer.getContentPane());
        visor.setLocationRelativeTo(ventana);

        visor.setVisible(true);
        visor.setAlwaysOnTop(true);

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("ESTO ES MALO2: " + ex.getMessage());
            }
        }

    }
}
