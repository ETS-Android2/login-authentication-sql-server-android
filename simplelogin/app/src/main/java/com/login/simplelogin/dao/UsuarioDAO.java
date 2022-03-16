package com.login.simplelogin.dao;

import com.login.simplelogin.conexao.ConSQL;
import com.login.simplelogin.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    Connection connection;

    //verifica se usuário e senha existem na tabela LOGIN
    public Usuario selecionaUsuario(String usuario, String senha){
        try{
            ConSQL c= new ConSQL();
            connection = c.conclass();
            if (connection != null){
                String sql = "select * from LOGIN where USUARIO = '" + usuario + "' and PASSWORD = '" + senha + "'";
                Statement st = null;
                st = connection.createStatement();

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()){
                    Usuario usu = new Usuario();
                    usu.setUsuario(rs.getString("USUARIO"));
                    usu.setSenha(rs.getString("PASSWORD"));

                    connection.close();
                    return usu;
                }
            }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return null;
    }}

