package cl.sulcansystem.restaurante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
import cl.sulcansystem.restaurante.tipos_usuarios.PublicoGeneral;

public class Registrarse extends AppCompatActivity implements IPresenterView{

    private static final String TAG = "MainActivity";
    EditText edtTelefono, edtNombre, edtContraseña, edtConfirmacion, edtDireccion, edtComuna, edtMail;
    TextView textView;
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
        textView = (TextView) findViewById(R.id.textView);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
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
                        if(snapshot.child(edtTelefono.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(Registrarse.this, "Número de Teléfono ya Registrado..!!!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mDialog.dismiss();

                            Usuario usuario = new Usuario(edtNombre.getText().toString(), edtComuna.getText().toString(),edtContraseña.getText().toString(),edtDireccion.getText().toString(), "Activo", edtMail.getText().toString(), Nombre,"Público en General");

                            if(usuario.getContraseña().equals(edtConfirmacion.getText().toString())) {
                                tabla_usuario.child(edtTelefono.getText().toString()).setValue(usuario);
                                Toast.makeText(Registrarse.this, "Usuario Registrado Satisfactoriamente...!!!", Toast.LENGTH_SHORT).show();
                                Intent ingresar = new Intent(Registrarse.this, Ingresar.class);
                                startActivity(ingresar);
                                finish();
                            }else{
                                Toast.makeText(Registrarse.this, "Las Contraseñas No Coinciden...!!!", Toast.LENGTH_SHORT).show();

                            }
                        finish();
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


    }
