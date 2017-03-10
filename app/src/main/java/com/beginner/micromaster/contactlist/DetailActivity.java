package com.beginner.micromaster.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beginner.micromaster.contactlist.models.Contact;

public class DetailActivity extends AppCompatActivity {
    private TextView name;
    private TextView lastName;
    private TextView email;
    private TextView phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Contact contact = (Contact) getIntent().getSerializableExtra("contact");

        getViews();
        setData(contact);
    }

    private void getViews() {
        name = (TextView) findViewById(R.id.tvName);
        lastName = (TextView) findViewById(R.id.tvLastName);
        email = (TextView) findViewById(R.id.tvEmail);
        phoneNumber = (TextView) findViewById(R.id.tvPhoneNumber);
    }

    private void setData(Contact contact) {
        name.setText(contact.getName());
        lastName.setText(contact.getLastName());
        email.setText(contact.getEmail());
        phoneNumber.setText(String.valueOf(contact.getPhoneNumber()));
    }
}
