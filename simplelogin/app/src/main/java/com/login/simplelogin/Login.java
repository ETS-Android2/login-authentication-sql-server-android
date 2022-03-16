package com.login.simplelogin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.login.simplelogin.dao.UsuarioDAO;
import com.login.simplelogin.model.Usuario;


public class Login extends AppCompatActivity {

    public static String usuario;
    private EditText edtUser;
    private EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InicializaObjetos();
    }

    //cria objetos de login e senha

    public void InicializaObjetos()
    {
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
    }

    //mensagem de erro exibida

    private void MensagemInformativa(String mensagen) {
        new AlertDialog.Builder(this)
                .setTitle("ERROR:")
                .setMessage(mensagen)
                .setPositiveButton("OK", null)
                .setCancelable(false)
                .show();
    }

    //chama tela de menu 1

    public void Menu1 (View v){
        usuario = edtUser.getText().toString();
        String senha = edtPass.getText().toString();

        Usuario usu = new UsuarioDAO().selecionaUsuario(usuario, senha);
        if (usu != null){
            Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();            
            finish();

        } else {
            MensagemInformativa("INCORRECT! Please enter a valid login.");
            edtPass.setText(null);
        }

    }

    //chama tela de menu 2

    public void Menu2 (View v){
        usuario = edtUser.getText().toString();
        String senha = edtPass.getText().toString();

        Usuario usu = new UsuarioDAO().selecionaUsuario(usuario, senha);
        if (usu != null){
            Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();            
            finish();

        } else {
            MensagemInformativa("INCORRECT! Please enter a valid login.");
            edtPass.setText(null);
        }

    }

    //limpa login e senha

    public void limpa(View v) {
        edtUser.setText(null);
        edtPass.setText(null);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

}