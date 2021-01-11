/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author midgu
 */

import Domain.PlanCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanCursoDAO {
   private DataBaseConnection databaseConnection = null;
   private Connection connection;
   private ResultSet resultSet;
   
   public PlanCursoDAO(){
       databaseConnection = new DataBaseConnection();
       
   }
   
   public int insertPlanCurso(PlanCurso planCurso){
       int affectedRows = 0;
       connection = databaseConnection.getConnection();
       String query = "insert into planCurso(nrc, experienciaEducativa, bloque, seccion, numeroPersonal, periodo) values (?,?,?,?,?,?);";
       try{
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1, planCurso.getNrc());
          preparedStatement.setString(2, planCurso.getExperienciaEducativa());
          preparedStatement.setInt(3, planCurso.getBloque());
          preparedStatement.setInt(4, planCurso.getSeccion());
          preparedStatement.setString(5, planCurso.getNumeroPersonal());
          preparedStatement.setString(6, planCurso.getPeriodo());
          
          affectedRows = preparedStatement.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       
       return affectedRows;
       
   }
   
   public PlanCurso getPlanCurso(int idPlanCurso){
       PlanCurso planCurso = null;
       connection = databaseConnection.getConnection();
       String query = "Select * from planCurso where idPlanCurso = ?";
       try{
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setInt(1, idPlanCurso);
           
           resultSet = preparedStatement.executeQuery();
           resultSet.next();
           
           planCurso = new PlanCurso(
                   resultSet.getInt("idPlanCurso"),
                   resultSet.getInt("nrc"),
                   resultSet.getString("experienciaEducativa"),
                   resultSet.getInt("bloque"),
                   resultSet.getInt("seccion"),
                   resultSet.getString("numeroPersonal"),
                   resultSet.getString("periodo")

           );
       } catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
            
       
       return planCurso;
   }
   
   public int updatePlanCurso(PlanCurso planCurso){
       int affectedRows = 0;
       connection = databaseConnection.getConnection();
       String query = "UPDATE planCurso SET nrc = ?, experienciaEducativa = ?, bloque = ?, seccion = ?, numeroPersonal= ?, periodo = ? where idPlanCurso = ?";
       try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, planCurso.getNrc());
            preparedStatement.setString(2, planCurso.getExperienciaEducativa());
            preparedStatement.setInt(3, planCurso.getBloque());
            preparedStatement.setInt(4, planCurso.getSeccion());
            preparedStatement.setString(5, planCurso.getNumeroPersonal());
            preparedStatement.setString(6, planCurso.getPeriodo());
           
            preparedStatement.setInt(7, planCurso.getIdPlanCurso());
           
            affectedRows = preparedStatement.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       
       return affectedRows;
      
   }
   
   public int deletePlanCurso(int idPlanCurso){
       int affectedRows = 0;
       connection = databaseConnection.getConnection();
       String query = "DELETE FROM planCurso WHERE idPlanCurso = ?";
       
       try{
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1, idPlanCurso);
          
          affectedRows = preparedStatement.executeUpdate();
          
       } catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return affectedRows;
   }
   
}
