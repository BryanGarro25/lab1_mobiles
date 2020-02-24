/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import BusinessLogic.Curso;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Josue
 */
public class ServicioCurso extends Servicio {

    private static final String INSERTAR_CURSO = "{call PA_insertarCurso(?,?,?,?)}";
    private static final String ELIMINAR_CURSO = "{call PA_eliminarCurso(?)}";
    private static final String BUSCAR_CURSO = "{?=call PA_buscarCurso(?)}";
    private static final String LISTAR_CURSOS = "{?=call PA_listarCursos}";
    private static final String MODIFICAR_CURSO = "{call modificarCurso(?,?,?,?,?)}";
    private static ServicioCurso uniqueInstance;

    public static ServicioCurso instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ServicioCurso();
        }
        return uniqueInstance;
    }

    public ServicioCurso() {
    }

    public void insertarCurso(Curso curso) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTAR_CURSO);
            pstmt.setString(1, curso.getCodigo());
            pstmt.setString(2, curso.getNombre());
            pstmt.setInt(3, curso.getCreditos());
            pstmt.setInt(4, curso.getHorasSemanales());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se realizo la inserci�n");
            }
        } catch (SQLException e) {
            throw new GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    public ArrayList<Curso> listarCursos() throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        ArrayList<Curso> cursos = new ArrayList();
        Curso curso = null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTAR_CURSOS);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                curso = new Curso(
                        rs.getInt("id_DB"),
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getInt("creditos"),
                        rs.getInt("horas_semanales"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (cursos.isEmpty()) {
            throw new NoDataException("No hay datos");
        }
        return cursos;
    }

    public void modificarCurso(Curso curso) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(MODIFICAR_CURSO);
            pstmt.setInt(1, curso.getId());
            pstmt.setString(2, curso.getCodigo());
            pstmt.setString(3, curso.getNombre());
            pstmt.setInt(4, curso.getCreditos());
            pstmt.setInt(5, curso.getHorasSemanales());
            int resultado = pstmt.executeUpdate();

            //si es diferente de 0 es porq si afecto un registro o mas
            if (resultado != 1) {
                throw new NoDataException("No se realizo la actualización");
            } else {
                System.out.println("\nModificación Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    public void eliminarCurso(int id) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(ELIMINAR_CURSO);
            pstmt.setInt(1, id);

            int resultado = pstmt.executeUpdate();

            if (resultado != 1) {
                throw new NoDataException("No se realizo el borrado");
            } else {
                System.out.println("\nEliminación Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }
    public Curso buscarCurso(int id) throws GlobalException, NoDataException, SQLException  	{
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }      
        ResultSet rs = null;
        Curso curso=null;
        CallableStatement pstmt=null;  
        try {            
            pstmt = conexion.prepareCall(BUSCAR_CURSO);            
            pstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);            
            pstmt.setInt(2, id);           
            pstmt.execute();
            rs = (ResultSet)pstmt.getObject(1);
            if (rs.next()) {
               
                curso= new Curso(rs.getInt("id_DB"),rs.getString("codigo"),rs.getString("nombre"),rs.getInt("creditos"), rs.getInt("horas_semanales"));
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (curso == null) {
            return null;
        }
        return curso;
    }

}
