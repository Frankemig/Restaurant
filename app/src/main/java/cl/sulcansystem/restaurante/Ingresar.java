package cl.sulcansystem.restaurante;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import cl.sulcansystem.restaurante.modelo.Usuario;
import cl.sulcansystem.restaurante.tipos_usuarios.Administrador;
import cl.sulcansystem.restaurante.tipos_usuarios.BarTender;
import cl.sulcansystem.restaurante.tipos_usuarios.Cajero;
import cl.sulcansystem.restaurante.tipos_usuarios.Cocinero;
import cl.sulcansystem.restaurante.tipos_usuarios.Garzon;
import cl.sulcansystem.restaurante.tipos_usuarios.Gerente;
import cl.sulcansystem.restaurante.tipos_usuarios.JefeDeCocina;
import cl.sulcansystem.restaurante.tipos_usuarios.Propietario;
import cl.sulcansystem.restaurante.tipos_usuarios.PublicoGeneral;

public class Ingresar extends AppCompatActivity {

    EditText edtTelefono, edtContraseña;
    Button btnIngresar;
    public static String Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        edtContraseña = (MaterialEditText) findViewById(R.id.edtContraseña);
        edtTelefono = (MaterialEditText) findViewById(R.id.edtTelefono);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        // Iniciando Firebase

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabla_usuario = database.getReference("USUARIOS");

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(Ingresar.this);
                mDialog.setMessage("Por Favor, Esere...");
                mDialog.show();

                tabla_usuario.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Chequeamos Si El Usuario Existe

                        if(snapshot.child(edtTelefono.getText().toString()).exists()) {

                            //Entregamos Información del Usuario
                            mDialog.dismiss();
                            Usuario usuario = snapshot.child(edtTelefono.getText().toString()).getValue(Usuario.class);
                            Nombre = usuario.getNombre();

                            String Tipo_Usuario = usuario.getTipo_Usuario();
                            String Estatus = usuario.getEstatus();

                            if (usuario.getContraseña().equals(edtContraseña.getText().toString())) {
                               if(Tipo_Usuario.equals("Público en General") && Estatus.equals("Activo")){
                                    Intent publicoGeneral = new Intent(Ingresar.this, PublicoGeneral.class);
                                    startActivity(publicoGeneral);
                                    finish();
                                }
                                else if(Tipo_Usuario.equals("Propietario") && Estatus.equals("Activo")){
                                    Intent propietario = new Intent(Ingresar.this, Propietario.class);
                                startActivity(propietario);
                                finish();
                                }
                                else if(Tipo_Usuario.equals("Gerente") && Estatus.equals("Activo")){
                                    Intent gerente = new Intent(Ingresar.this, Gerente.class);
                                startActivity(gerente);
                                finish();
                                }
                                else if(Tipo_Usuario.equals("Administrador") && Estatus.equals("Activo")){
                                    Intent administrador = new Intent (Ingresar.this, Administrador.class);
                                startActivity(administrador);
                                finish();
                                }
                                else if(Tipo_Usuario.equals("Jefe de Cocina") && Estatus.equals("Activo")){
                                    Intent jefe_de_cocina = new Intent(Ingresar.this, JefeDeCocina.class);
                                startActivity(jefe_de_cocina);
                                finish();
                                }
                                else if(Tipo_Usuario.equals("Cocinero") && Estatus.equals("Activo")){
                                    Intent cocinero = new Intent(Ingresar.this, Cocinero.class);
                                startActivity(cocinero);
                                finish();
                                }
                                else if(Tipo_Usuario.equals("Cajero") && Estatus.equals("Activo")){
                                    Intent cajero = new Intent(Ingresar.this, Cajero.class);
                                startActivity(cajero);
                                finish();
                                }
                                else if(Tipo_Usuario.equals("Garzón") && Estatus.equals("Activo")){
                                    Intent garzon = new Intent(Ingresar.this, Garzon.class);
                                startActivity(garzon);
                                finish();
                                }
                                else if(Tipo_Usuario.equals("BarTender") && Estatus.equals("Activo")){
                                    Intent bartender = new Intent(Ingresar.this, BarTender.class);
                                startActivity(bartender);
                                finish();
                                }
                                Toast.makeText(Ingresar.this, "Bienvenido " + Nombre, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Ingresar.this, "Contraseña Incorrecta...!!!", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Ingresar.this, "Usuario No Registrado...!!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
       super.onBackPressed();
    }
}