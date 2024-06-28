package Repositorio;

import Interfaces.FuncionarioRepositorio;
import Modelo.Funcionario;
import Utilidades.Conexion;
import Utilidades.Constantes;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioRepositorioImpOrc implements FuncionarioRepositorio {

    @Override
    public boolean create(Funcionario funcionario) {
        Constantes.SQL = "INSERT INTO funcionario (nombre,edad,cargo) VALUES (?,?,?)";
        Connection con = Conexion.conexionorc();
        try {
            PreparedStatement ps = con.prepareStatement(Constantes.SQL,Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, funcionario.getNombre());
            ps.setInt(2, funcionario.getEdad());
            ps.setString(3, funcionario.getCargo());
            Constantes.MENSAJE = "Registro Guardado Exitosamente";
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            Constantes.MENSAJE = e.getMessage();
            return false;

        }
    }

    @Override
    public Funcionario read(int id) {
        Constantes.SQL = "SELECT * FROM funcionario WHERE id=?";
        Connection con = Conexion.conexionorc();

        try {
            PreparedStatement ps = con.prepareStatement(Constantes.SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Funcionario funci = null;
            Constantes.MENSAJE = "Registro No Encontrado";
            if (rs.next()) {
                funci = new Funcionario();
                funci.setId(rs.getInt("id"));
                funci.setNombre(rs.getString("nombre"));
                funci.setEdad(rs.getInt("edad"));
                funci.setCargo(rs.getString("cargo"));
                Constantes.MENSAJE = "La consulta se ha realizado exitosamente¡¡¡¡";
            }
            return funci;
        } catch (SQLException e) {
            Constantes.MENSAJE = e.getMessage();
            return null;
        }
    }

    @Override
    public List<Funcionario> readAll() {
        Constantes.SQL = "SELECT * FROM funcionario ORDER BY nombre";
        Connection con = Conexion.conexionorc();
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Constantes.SQL);

            Funcionario funcio = null;
            Constantes.MENSAJE = "Registro No Encontrado";
            if (rs.next()) {
                funcio = new Funcionario();
                funcio.setId(rs.getInt("id"));
                funcio.setNombre(rs.getString("nombre"));
                funcio.setEdad(rs.getInt("edad"));
                funcio.setCargo(rs.getString("cargo"));
                funcionarios.add(funcio);
            }
        } catch (SQLException e) {
            Constantes.MENSAJE = e.getMessage();
        }
        return funcionarios;
    }
    @Override
    public boolean update(Funcionario funcionario) {
        Constantes.SQL= "UPDATE funcionario SET nombre=?, edad=?, cargo=? WHERE id=?";
        Connection con = Conexion.conexionorc();
        try {
            PreparedStatement ps = con.prepareStatement(Constantes.SQL);
            ps.setString(1, funcionario.getNombre());
            ps.setInt(2, funcionario.getEdad());
            ps.setString(3, funcionario.getCargo());
            ps.setInt(4, funcionario.getId());
            Constantes.MENSAJE = "Registro Actualizado Correctamente";
            
            
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
        Constantes.MENSAJE = e.getMessage();
        return false;
        }
        
    }

    @Override
    public boolean delete(int id) {
       Constantes.SQL = "DELETE  FROM funcionario WHERE id=? ";
        Connection con = Conexion.conexionorc();
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(Constantes.SQL);
            ps.setInt(1, id);
            Constantes.MENSAJE = "Registro Eliminado Correctamente";
            
            return ps.executeUpdate()>0;
            
        } catch (SQLException e) {
            Constantes.MENSAJE = e.getMessage();
        
        return false;
        }
    }

}
