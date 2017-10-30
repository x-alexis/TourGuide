package com.trottdevelopment.tourguide;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity shows information about application, author, credits and contacts.
 */

public class InfoActivity extends AppCompatActivity {

    private String mAuthorEmail;
    private String mAuthorTelegramName;
    private String mAuthorVkontakteId;
    private String mVersionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Adding "Up" button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Filling author contacts
        mAuthorEmail = "trott.alik@gmail.com";
        mAuthorTelegramName = "vault_developer";
        mAuthorVkontakteId = "id414297352";

        //Finding views for contacts
        ImageView contactTelegramImage = (ImageView) findViewById(R.id.contacts_telegram);
        ImageView contactWhatsAppImage = (ImageView) findViewById(R.id.contacts_viber);
        ImageView contactMailImage = (ImageView) findViewById(R.id.contacts_email);
        TextView infoText = (TextView) findViewById(R.id.info_text);
        TextView versionText = (TextView) findViewById(R.id.info_version);

        //Making links clickable
        infoText.setMovementMethod(LinkMovementMethod.getInstance());

        //Setting versionName to textView
        try {
            mVersionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        versionText.setText(getResources().getString(R.string.info_version, mVersionName));

        //Setting intent to contact via email
        contactMailImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mAuthorEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, "приложение Гид Челябинска");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(InfoActivity.this, R.string.info_error_mail, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Setting intent to contact via telegram
        contactTelegramImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/" + mAuthorTelegramName));
                intent.setPackage("org.telegram.messenger");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(InfoActivity.this, R.string.info_error_telegram, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Setting intent to contact via vkontakte
        contactWhatsAppImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://vk.com/" + mAuthorVkontakteId));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(InfoActivity.this, R.string.info_error_vkontakte, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
