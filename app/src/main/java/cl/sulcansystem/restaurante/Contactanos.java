package cl.sulcansystem.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cl.sulcansystem.restaurante.tipos_usuarios.PublicoGeneral;

public class Contactanos extends AppCompatActivity {

    ImageView facebook, instagram, web, consultas, llamar, pedidos, mail, msn, mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        facebook = findViewById(R.id.facebook);
        instagram = findViewById(R.id.instagram);
        web = findViewById(R.id.web);
        consultas = findViewById(R.id.whatsappConsultas);
        pedidos = findViewById(R.id.whatsappPedidos);
        mail = findViewById(R.id.mail);
        msn = findViewById(R.id.msn);
        llamar = findViewById(R.id.llamar);
        mapa = findViewById(R.id.mapa);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://www.facebook.com/Bientaypa-1839190612857423/");
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://www.instagram.com/bientaypa/");
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://www.bientaypa.cl");
            }
        });
        consultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sentWhatsapp("+56958737826", "Hola, Quisiera hacerle una consulta...");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
        pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    sentWhatsapp("+56948120976", "Hola, Quisiera hacer un pedido...");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://www.google.cl/maps/place/Sierra+Bella+1501,+Santiago,+Regi%C3%B3n+Metropolitana/@-33.4643055,-70.6374297,17z/data=!3m1!4b1!4m5!3m4!1s0x9662c56822d5daf5:0xaad32fd3666bb24e!8m2!3d-33.46431!4d-70.635241?hl=es-419&authuser=0");
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = new String[1];
                addresses[0] = "reservas@bientaypa.cl";
                composeEmail(addresses, "Reserva");
            }
        });
        msn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://m.me/1839190612857423");
            }
        });
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("+56225516570");
            }
        });
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sentWhatsapp(String number, String message) throws UnsupportedEncodingException {

        String url = "https://api.whatsapp.com/send?phone=" + number + "&text=" + URLEncoder.encode(message, "UTF-8");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void link(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent publicoGeneral = new Intent(Contactanos.this, PublicoGeneral.class);
        startActivity(publicoGeneral);
        finish();
        super.onBackPressed();
    }
}