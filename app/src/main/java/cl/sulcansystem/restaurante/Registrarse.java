package cl.sulcansystem.restaurante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import cl.sulcansystem.restaurante.modelo.Usuario;
import cl.sulcansystem.restaurante.modelo.VerificadorContraseña;
import cl.sulcansystem.restaurante.presentador.IPresenter;
import cl.sulcansystem.restaurante.presentador.IPresenterView;
import cl.sulcansystem.restaurante.presentador.Presentador;

public class Registrarse extends AppCompatActivity implements IPresenterView {

    private static final String TAG = "MainActivity";
    EditText edtTelefono, edtNombre, edtContraseña, edtConfirmacion, edtDireccion, edtComuna, edtMail;
    TextView textView, telefono_fallido, nombre_fallido, contraseña_fallida, direccion_fallida, comuna_fallida, mail_fallido;
    Button btnRegistrarse;
    IPresenter presenter;
    public static String Nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        edtTelefono = (MaterialEditText) findViewById(R.id.edtTelefono);
        edtNombre = (MaterialEditText) findViewById(R.id.edtNombre);
        edtContraseña = (MaterialEditText) findViewById(R.id.edtContraseña);
        edtConfirmacion = (MaterialEditText) findViewById(R.id.edtConfirmarContraseña);
        edtDireccion = (MaterialEditText) findViewById(R.id.edtDireccion);
        edtComuna = (MaterialEditText) findViewById(R.id.edtComuna);
        edtMail = (MaterialEditText) findViewById(R.id.edtMail);
        textView = (TextView) findViewById(R.id.nivel_seguridad);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        telefono_fallido = findViewById(R.id.numero_fallido);
        nombre_fallido = findViewById(R.id.nombre_fallido);
        contraseña_fallida = findViewById(R.id.contraseña_fallido);
        direccion_fallida = findViewById(R.id.direccion_fallido);
        comuna_fallida = findViewById(R.id.comuna_fallido);
        mail_fallido = findViewById(R.id.mail_fallido);
        Nombre = Ingresar.Nombre;

        //Iniciar Firebase

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference tabla_usuario = database.getReference("USUARIOS");

            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(Registrarse.this);
                mDialog.setMessage("Por Favor, Esere...");
                mDialog.show();
                tabla_usuario.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (edtTelefono.getText().toString().isEmpty()) {
                            mDialog.dismiss();
                            Toast.makeText(Registrarse.this, "El Número de Teléfono es Requerido...", Toast.LENGTH_LONG).show();
                            telefono_fallido.setText("Este Campo Es Requerido...");
                        } else if (!edtTelefono.getText().toString().startsWith("9")) {
                            telefono_fallido.setText("El Número de Teléfono, Debe Empezar con '9'...");
                            Toast.makeText(Registrarse.this, "El Número de Teléfono es Incorrecto...", Toast.LENGTH_LONG).show();
                            mDialog.dismiss();
                        } else if (edtTelefono.getText().toString().length() != 9) {
                            mDialog.dismiss();
                            telefono_fallido.setText("El Número de Teléfono, Debe Tener 9 Dígitos...");
                            Toast.makeText(Registrarse.this, "El Número de Teléfono Debe Tener 9 Dígitos...", Toast.LENGTH_LONG).show();
                        } else if (snapshot.child(edtTelefono.getText().toString()).exists()) {
                            mDialog.dismiss();
                            telefono_fallido.setText("Este Número Ya Existe...!!! Pruebe con Otro o Inicie Sesión...");
                            Toast.makeText(Registrarse.this, "Número de Teléfono ya Registrado..!!!", Toast.LENGTH_LONG).show();
                        } else {
                            mDialog.dismiss();

                            Usuario usuario = new Usuario(edtNombre.getText().toString(), edtComuna.getText().toString(), edtContraseña.getText().toString(), edtDireccion.getText().toString(), "Activo", edtMail.getText().toString(), Nombre, "Público en General");

                            if (!usuario.getContraseña().equals(edtConfirmacion.getText().toString())) {
                                contraseña_fallida.setText("Las Contraseñas no Coinciden...");
                                mDialog.dismiss();
                                edtContraseña.setText("");
                                edtConfirmacion.setText("");
                                Toast.makeText(Registrarse.this, "Las Contraseñas No Coinciden...!!!\nVuelva a Intentarlo", Toast.LENGTH_LONG).show();
                            } else {
                                mDialog.dismiss();

                                if (edtNombre.getText().toString().isEmpty()) {
                                    nombre_fallido.setText("Este Campo Es Requerido...");
                                    Toast.makeText(Registrarse.this, "Todos los Campos son Requeridos...", Toast.LENGTH_LONG).show();
                                    mDialog.dismiss();
                                } else if (edtComuna.getText().toString().isEmpty()) {
                                    comuna_fallida.setText("Este Campo Es Requerido...");
                                    Toast.makeText(Registrarse.this, "Todos los Campos son Requeridos...", Toast.LENGTH_LONG).show();
                                    mDialog.dismiss();
                                } else if (edtDireccion.getText().toString().isEmpty()) {
                                    direccion_fallida.setText("Este Campo Es Requerido...");
                                    Toast.makeText(Registrarse.this, "Todos los Campos son Requeridos...", Toast.LENGTH_LONG).show();
                                    mDialog.dismiss();
                                } else if (edtContraseña.getText().toString().isEmpty()) {
                                    contraseña_fallida.setText("Este Campo Es Requerido...");
                                    Toast.makeText(Registrarse.this, "Todos los Campos son Requeridos...", Toast.LENGTH_LONG).show();
                                    mDialog.dismiss();
                                } else if (edtMail.getText().toString().isEmpty()) {
                                    mail_fallido.setText("Este Campo Es Requerido...");
                                    Toast.makeText(Registrarse.this, "Todos los Campos son Requeridos...", Toast.LENGTH_LONG).show();
                                    mDialog.dismiss();
                                } else if (!edtMail.getText().toString().contains("@")) {
                                    mail_fallido.setText("Éste, No es un Correo Válido, Le Falta '@'");
                                    Toast.makeText(Registrarse.this, "Por Favor, Ingrese Una Dirección de Correo Válida...", Toast.LENGTH_LONG).show();
                                    mDialog.dismiss();
                                } else if (!edtMail.getText().toString().contains(".")) {
                                    mail_fallido.setText("Éste, No es un Correo Válido, Le Falta '.'");
                                    Toast.makeText(Registrarse.this, "Por Favor, Ingrese Una Dirección de Correo Válida...", Toast.LENGTH_LONG).show();
                                    mDialog.dismiss();
                                } else {

                                    tabla_usuario.child(edtTelefono.getText().toString()).setValue(usuario);
                                    Toast.makeText(Registrarse.this, "Usuario Registrado Satisfactoriamente...!!!", Toast.LENGTH_LONG).show();
                                    Intent ingresar = new Intent(Registrarse.this, Ingresar.class);
                                    startActivity(ingresar);
                                    finish();
                                }

                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        edtContraseña.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "changed " + s.toString());
                presenter.evaluatePass(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        presenter = new Presentador((IPresenterView) this, new VerificadorContraseña());
    }

    @Override
    public void showWeak() {
        Log.d(TAG, "Débil");
        textView.setBackgroundColor(Color.RED);
        textView.setText("Débil");
        textView.setTextColor(Color.WHITE);
    }

    @Override
    public void showMedium() {
        Log.d(TAG, "Media");
        textView.setBackgroundColor(Color.BLUE);
        textView.setText("Media");
    }

    @Override
    public void showStrong() {
        Log.d(TAG, "Segura");
        textView.setBackgroundColor(Color.YELLOW);
        textView.setText("Segura");
    }

    @Override
    public void showVeryStrong() {
        Log.d(TAG, "Muy Segura");
        textView.setBackgroundColor(Color.GREEN);
        textView.setText("Muy Segura");
    }

    @Override
    public void onBackPressed() {
        Intent ingresar = new Intent(Registrarse.this, Ingresar.class);
        startActivity(ingresar);
        finish();
        super.onBackPressed();
    }
}
